import { ErrorNode } from "antlr4ts/tree/ErrorNode";
import { ParseTree } from "antlr4ts/tree/ParseTree";
import { RuleNode } from "antlr4ts/tree/RuleNode";
import { TerminalNode } from "antlr4ts/tree/TerminalNode";
import {
  ProgramContext,
  StatementContext,
  DefineStmtContext,
  AssignmentContext,
  EquationStmtContext,
  EquationContext,
  PrintStmtContext,
  ExprStmtContext,
  ExprContext,
  Expr2Context,
  Expr3Context,
  ComparisonContext,
  ArithContext,
  TermContext,
  FactorContext,
  UnaryContext,
  AtomContext,
  ImplicitMulContext,
  FunctionCallContext,
  ArgListContext,
  ConstantContext,
  VectorContext,
  MatrixContext,
  RowContext,
  ExprListContext,
} from "../generated/grammar/CalculatorParser";
import { CalculatorVisitor } from "../generated/grammar/CalculatorVisitor";

interface ComplexValue {
  kind: "complex";
  real: number;
  imag: number;
}

type RuntimeValue = number | boolean | string | ComplexValue | RuntimeValue[];

export class Caluctor implements CalculatorVisitor<RuntimeValue | undefined> {
  private readonly variables = new Map<string, RuntimeValue>();
  private readonly constants = new Map<string, number>([
    ["pi", Math.PI],
    ["e", Math.E],
  ]);
  private readonly builtins: Record<string, (...args: RuntimeValue[]) => RuntimeValue>;
  private readonly epsilon = 1e-9;

  constructor(initialVariables?: Record<string, RuntimeValue>) {
    if (initialVariables) {
      for (const [key, value] of Object.entries(initialVariables)) {
        this.variables.set(key, value);
      }
    }

    this.builtins = {
      abs: (...args) => {
        this.expectArgCount("abs", args, 1);
        const value = args[0];
        if (this.isComplex(value)) {
          return Math.hypot(value.real, value.imag);
        }
        return Math.abs(this.toNumber(value, "abs"));
      },
      ceil: (...args) => this.numberUnary("ceil", args, Math.ceil),
      cos: (...args) => this.numberUnary("cos", args, Math.cos),
      exp: (...args) => this.numberUnary("exp", args, Math.exp),
      floor: (...args) => this.numberUnary("floor", args, Math.floor),
      len: (...args) => {
        this.expectArgCount("len", args, 1);
        const target = args[0];
        if (Array.isArray(target)) {
          return target.length;
        }
        if (typeof target === "string") {
          return target.length;
        }
        throw new Error("len expects an array or string");
      },
      log: (...args) => {
        if (args.length === 1) {
          return Math.log(this.toNumber(args[0], "log"));
        }
        if (args.length === 2) {
          const value = this.toNumber(args[0], "log");
          const base = this.toNumber(args[1], "log");
          if (base <= 0 || base === 1) {
            throw new Error("log base must be positive and not equal to 1");
          }
          return Math.log(value) / Math.log(base);
        }
        throw new Error("log expects one or two arguments");
      },
      max: (...args) => this.numberVariadic("max", args, Math.max),
      min: (...args) => this.numberVariadic("min", args, Math.min),
      round: (...args) => this.numberUnary("round", args, Math.round),
      sin: (...args) => this.numberUnary("sin", args, Math.sin),
      sqrt: (...args) => {
        this.expectArgCount("sqrt", args, 1);
        const value = this.toNumber(args[0], "sqrt");
        if (value < 0) {
          const magnitude = Math.sqrt(Math.abs(value));
          return this.fromComplex({ kind: "complex", real: 0, imag: magnitude });
        }
        return Math.sqrt(value);
      },
      sum: (...args) => {
        if (args.length === 1 && Array.isArray(args[0])) {
          const list = args[0] as RuntimeValue[];
          return list.reduce<RuntimeValue>((total, item) => this.add(total, item), 0);
        }
        return args.reduce<RuntimeValue>((total, item) => this.add(total, item), 0);
      },
      tan: (...args) => this.numberUnary("tan", args, Math.tan),
    };
  }

  visitProgram(ctx: ProgramContext): RuntimeValue | undefined {
    let result: RuntimeValue | undefined;
    for (const stmt of ctx.statement()) {
      result = stmt.accept(this);
    }
    return result;
  }

  visitStatement(ctx: StatementContext): RuntimeValue | undefined {
    if (ctx.defineStmt()) {
      return this.visitDefineStmt(ctx.defineStmt()!);
    }
    if (ctx.assignment()) {
      return this.visitAssignment(ctx.assignment()!);
    }
    if (ctx.equationStmt()) {
      return this.visitEquationStmt(ctx.equationStmt()!);
    }
    if (ctx.printStmt()) {
      return this.visitPrintStmt(ctx.printStmt()!);
    }
    if (ctx.exprStmt()) {
      return this.visitExprStmt(ctx.exprStmt()!);
    }
    return undefined;
  }

  visitDefineStmt(ctx: DefineStmtContext): RuntimeValue {
    const name = ctx.ID().text;
    if (this.variables.has(name)) {
      throw new Error(`Variable '${name}' already defined`);
    }
    const value = this.evaluate(ctx.expr());
    this.variables.set(name, value);
    return value;
  }

  visitAssignment(ctx: AssignmentContext): RuntimeValue {
    const name = ctx.ID().text;
    if (!this.variables.has(name)) {
      throw new Error(`Variable '${name}' is not defined`);
    }
    const value = this.evaluate(ctx.expr());
    this.variables.set(name, value);
    return value;
  }

  visitEquationStmt(ctx: EquationStmtContext): RuntimeValue {
    return this.visitEquation(ctx.equation()!);
  }

  visitEquation(ctx: EquationContext): RuntimeValue {
    const left = this.evaluate(ctx.expr(0));
    const right = this.evaluate(ctx.expr(1));
    return this.equals(left, right);
  }

  visitPrintStmt(ctx: PrintStmtContext): RuntimeValue {
    const value = this.evaluate(ctx.expr());
    console.log(this.stringify(value));
    return value;
  }

  visitExprStmt(ctx: ExprStmtContext): RuntimeValue {
    return this.evaluate(ctx.expr());
  }

  visitExpr(ctx: ExprContext): RuntimeValue {
    if (ctx.OR()) {
      const left = this.evaluate(ctx.expr()!);
      if (this.isTruthy(left)) {
        return true;
      }
      return this.isTruthy(this.evaluate(ctx.expr2()));
    }
    return this.evaluate(ctx.expr2());
  }

  visitExpr2(ctx: Expr2Context): RuntimeValue {
    if (ctx.AND()) {
      const left = this.evaluate(ctx.expr2()!);
      if (!this.isTruthy(left)) {
        return false;
      }
      return this.isTruthy(this.evaluate(ctx.expr3()));
    }
    return this.evaluate(ctx.expr3());
  }

  visitExpr3(ctx: Expr3Context): RuntimeValue {
    if (ctx.NOT()) {
      const value = ctx.expr3()!.accept(this);
      return !this.isTruthy(value);
    }
    return this.evaluate(ctx.comparison()!);
  }

  visitComparison(ctx: ComparisonContext): RuntimeValue {
    const children = ctx.children ?? [];
    if (children.length === 1) {
      return this.evaluate(ctx.arith(0));
    }

    let current = this.evaluate(ctx.arith(0));
    for (let i = 1; i < children.length; i += 2) {
      const operator = children[i].text;
      const nextValue = this.evaluate(children[i + 1]);
      if (!this.compare(operator, current, nextValue)) {
        return false;
      }
      current = nextValue;
    }
    return true;
  }

  visitArith(ctx: ArithContext): RuntimeValue {
    if (!ctx.arith()) {
      return this.evaluate(ctx.term());
    }

    const left = this.evaluate(ctx.arith()!);
    const right = this.evaluate(ctx.term());
    if (ctx.PLUS()) {
      return this.add(left, right);
    }
    return this.subtract(left, right);
  }

  visitTerm(ctx: TermContext): RuntimeValue {
    if (!ctx.term()) {
      return this.evaluate(ctx.factor());
    }

    const left = this.evaluate(ctx.term()!);
    const right = this.evaluate(ctx.factor());
    if (ctx.MULT()) {
      return this.multiply(left, right);
    }
    if (ctx.DIV()) {
      return this.divide(left, right);
    }
    return this.modulo(left, right);
  }

  visitFactor(ctx: FactorContext): RuntimeValue {
    const base = this.evaluate(ctx.unary());
    if (!ctx.POW()) {
      return base;
    }
    const exponent = this.evaluate(ctx.factor()!);
    return this.power(base, exponent);
  }

  visitUnary(ctx: UnaryContext): RuntimeValue {
    if (ctx.PLUS()) {
      return this.evaluate(ctx.unary()!);
    }
    if (ctx.MINUS()) {
      const value = this.evaluate(ctx.unary()!);
      return this.multiply(-1, value);
    }
    return this.evaluate(ctx.atom()!);
  }

  visitAtom(ctx: AtomContext): RuntimeValue {
    if (ctx.atom()) {
      const value = this.evaluate(ctx.atom()!);
      return this.factorial(value);
    }
    if (ctx.implicitMul()) {
      return this.evaluate(ctx.implicitMul()!);
    }
    if (ctx.functionCall()) {
      return this.evaluate(ctx.functionCall()!);
    }
    if (ctx.vector()) {
      return this.evaluate(ctx.vector()!);
    }
    if (ctx.matrix()) {
      return this.evaluate(ctx.matrix()!);
    }
    if (ctx.expr()) {
      return this.evaluate(ctx.expr()!);
    }
    if (ctx.constant()) {
      return this.evaluate(ctx.constant()!);
    }
    if (ctx.ID()) {
      return this.resolveIdentifier(ctx.ID()!.text);
    }
    if (ctx.IMAG()) {
      return this.parseImag(ctx.IMAG()!.text);
    }
    if (ctx.NUMBER()) {
      return this.parseNumber(ctx.NUMBER()!.text);
    }
    throw new Error(`Unsupported atom: ${ctx.text}`);
  }

  visitImplicitMul(ctx: ImplicitMulContext): RuntimeValue {
    if (ctx.NUMBER() && ctx.ID().length === 1 && !ctx.LPAREN()) {
      const scalar = this.parseNumber(ctx.NUMBER()!.text);
      const value = this.resolveIdentifier(ctx.ID(0)!.text);
      return this.multiply(scalar, value);
    }

    if (ctx.NUMBER() && ctx.LPAREN()) {
      const scalar = this.parseNumber(ctx.NUMBER()!.text);
      const value = this.evaluate(ctx.expr()!);
      return this.multiply(scalar, value);
    }

    if (ctx.constant() && ctx.ID().length === 1) {
      const constantValue = this.evaluate(ctx.constant()!);
      const value = this.resolveIdentifier(ctx.ID(0)!.text);
      return this.multiply(constantValue, value);
    }

    if (ctx.ID().length === 2 && !ctx.LPAREN()) {
      const left = this.resolveIdentifier(ctx.ID(0)!.text);
      const right = this.resolveIdentifier(ctx.ID(1)!.text);
      return this.multiply(left, right);
    }

    if (ctx.ID().length === 1 && ctx.LPAREN()) {
      const left = this.resolveIdentifier(ctx.ID(0)!.text);
      const right = this.evaluate(ctx.expr()!);
      return this.multiply(left, right);
    }

    throw new Error(`Unsupported implicit multiplication: ${ctx.text}`);
  }

  visitFunctionCall(ctx: FunctionCallContext): RuntimeValue {
    const name = ctx.ID().text;
    const args = ctx.argList()?.expr().map((exprCtx) => this.evaluate(exprCtx)) ?? [];
    const handler = this.builtins[name];
    if (!handler) {
      if (args.length === 1) {
        let left: RuntimeValue | undefined;
        if (this.variables.has(name)) {
          left = this.variables.get(name);
        } else if (this.constants.has(name)) {
          left = this.constants.get(name);
        }
        if (left !== undefined) {
          return this.multiply(left, args[0]);
        }
      }
      throw new Error(`Unknown function '${name}'`);
    }
    return handler(...args);
  }

  visitArgList(ctx: ArgListContext): RuntimeValue {
    return ctx.expr().map((exprCtx) => this.evaluate(exprCtx));
  }

  visitConstant(ctx: ConstantContext): RuntimeValue {
    const token = ctx.text.toLowerCase();
    const value = this.constants.get(token);
    if (value === undefined) {
      throw new Error(`Unknown constant '${ctx.text}'`);
    }
    return value;
  }

  visitVector(ctx: VectorContext): RuntimeValue {
    if (!ctx.exprList()) {
      return [];
    }
    return this.evaluate(ctx.exprList()!) as RuntimeValue[];
  }

  visitMatrix(ctx: MatrixContext): RuntimeValue {
    const rows = ctx.row().map((rowCtx) => this.evaluate(rowCtx) as RuntimeValue[]);
    return rows;
  }

  visitRow(ctx: RowContext): RuntimeValue {
    return this.evaluate(ctx.exprList());
  }

  visitExprList(ctx: ExprListContext): RuntimeValue {
    return ctx.expr().map((exprCtx) => this.evaluate(exprCtx));
  }

  visit(tree: ParseTree): RuntimeValue | undefined {
    return tree.accept(this);
  }

  visitChildren(node: RuleNode): RuntimeValue | undefined {
    let result: RuntimeValue | undefined;
    const childCount = node.childCount;
    for (let i = 0; i < childCount; i += 1) {
      result = node.getChild(i).accept(this);
    }
    return result;
  }

  visitTerminal(node: TerminalNode): RuntimeValue {
    return node.text;
  }

  visitErrorNode(node: ErrorNode): RuntimeValue {
    throw new Error(`Unexpected token '${node.text}'`);
  }

  private evaluate(tree: ParseTree): RuntimeValue {
    const value = tree.accept(this);
    if (value === undefined) {
      throw new Error("Expression did not return a value");
    }
    return value;
  }

  private stringify(value: RuntimeValue): string {
    if (typeof value === "string" || typeof value === "number" || typeof value === "boolean") {
      return String(value);
    }
    if (this.isComplex(value)) {
      const realPart = this.approxZero(value.real) ? 0 : this.normalizeNumber(value.real);
      const imagPart = this.approxZero(value.imag) ? 0 : this.normalizeNumber(value.imag);
      if (this.approxZero(imagPart)) {
        return String(realPart);
      }
      if (this.approxZero(realPart)) {
        return `${imagPart}i`;
      }
      const sign = imagPart >= 0 ? "+" : "-";
      return `${realPart} ${sign} ${Math.abs(imagPart)}i`;
    }
    if (Array.isArray(value)) {
      const items = value.map((item) => this.stringify(item));
      return `[${items.join(", ")}]`;
    }
    return "undefined";
  }

  private resolveIdentifier(name: string): RuntimeValue {
    if (this.variables.has(name)) {
      return this.variables.get(name)!;
    }
    if (this.constants.has(name)) {
      return this.constants.get(name)!;
    }
    throw new Error(`Identifier '${name}' is not defined`);
  }

  private parseNumber(text: string): number {
    if (/^0[bB]/.test(text)) {
      return parseInt(text.slice(2), 2);
    }
    if (/^0[oO]/.test(text)) {
      return parseInt(text.slice(2), 8);
    }
    if (/^0[xX]/.test(text)) {
      return parseInt(text.slice(2), 16);
    }
    return Number(text);
  }

  private parseImag(text: string): ComplexValue {
    const raw = text.slice(0, -1);
    if (raw.length === 0 || raw === "+") {
      return { kind: "complex", real: 0, imag: 1 };
    }
    if (raw === "-") {
      return { kind: "complex", real: 0, imag: -1 };
    }
    return { kind: "complex", real: 0, imag: this.parseNumber(raw) };
  }

  private isComplex(value: RuntimeValue): value is ComplexValue {
    return typeof value === "object" && value !== null && !Array.isArray(value) && (value as ComplexValue).kind === "complex";
  }

  private fromComplex(value: ComplexValue): RuntimeValue {
    const real = this.normalizeNumber(value.real);
    const imag = this.normalizeNumber(value.imag);
    if (this.approxZero(imag)) {
      return real;
    }
    return { kind: "complex", real, imag };
  }

  private normalizeNumber(value: number): number {
    return this.approxZero(value) ? 0 : value;
  }

  private approxZero(value: number): boolean {
    return Math.abs(value) <= this.epsilon;
  }

  private toComplex(value: RuntimeValue, context: string): ComplexValue {
    if (typeof value === "number") {
      return { kind: "complex", real: value, imag: 0 };
    }
    if (typeof value === "boolean") {
      return { kind: "complex", real: value ? 1 : 0, imag: 0 };
    }
    if (this.isComplex(value)) {
      return value;
    }
    throw new Error(`${context} expects numeric arguments`);
  }

  private toNumber(value: RuntimeValue, context: string): number {
    if (typeof value === "number") {
      return value;
    }
    if (typeof value === "boolean") {
      return value ? 1 : 0;
    }
    if (this.isComplex(value)) {
      if (!this.approxZero(value.imag)) {
        throw new Error(`${context} does not support complex values`);
      }
      return value.real;
    }
    throw new Error(`${context} expects numeric arguments`);
  }

  private add(left: RuntimeValue, right: RuntimeValue): RuntimeValue {
    const a = this.toComplex(left, "addition");
    const b = this.toComplex(right, "addition");
    return this.fromComplex({ kind: "complex", real: a.real + b.real, imag: a.imag + b.imag });
  }

  private subtract(left: RuntimeValue, right: RuntimeValue): RuntimeValue {
    const a = this.toComplex(left, "subtraction");
    const b = this.toComplex(right, "subtraction");
    return this.fromComplex({ kind: "complex", real: a.real - b.real, imag: a.imag - b.imag });
  }

  private multiply(left: RuntimeValue, right: RuntimeValue): RuntimeValue {
    const a = this.toComplex(left, "multiplication");
    const b = this.toComplex(right, "multiplication");
    const real = a.real * b.real - a.imag * b.imag;
    const imag = a.real * b.imag + a.imag * b.real;
    return this.fromComplex({ kind: "complex", real, imag });
  }

  private divide(left: RuntimeValue, right: RuntimeValue): RuntimeValue {
    const a = this.toComplex(left, "division");
    const b = this.toComplex(right, "division");
    const denom = b.real * b.real + b.imag * b.imag;
    if (this.approxZero(denom)) {
      throw new Error("Division by zero");
    }
    const real = (a.real * b.real + a.imag * b.imag) / denom;
    const imag = (a.imag * b.real - a.real * b.imag) / denom;
    return this.fromComplex({ kind: "complex", real, imag });
  }

  private modulo(left: RuntimeValue, right: RuntimeValue): RuntimeValue {
    const dividend = this.toNumber(left, "modulo");
    const divisor = this.toNumber(right, "modulo");
    if (this.approxZero(divisor)) {
      throw new Error("Modulo by zero");
    }
    return dividend % divisor;
  }

  private power(base: RuntimeValue, exponent: RuntimeValue): RuntimeValue {
    const exp = this.toComplex(exponent, "power");
    if (!this.approxZero(exp.imag)) {
      throw new Error("Complex exponents are not supported");
    }

    const exponentValue = exp.real;
    const baseComplex = this.toComplex(base, "power");

    if (this.isInteger(exponentValue)) {
      let result: ComplexValue = { kind: "complex", real: 1, imag: 0 };
      const iterations = Math.abs(exponentValue);
      for (let i = 0; i < iterations; i += 1) {
        result = this.toComplex(this.multiply(result, baseComplex), "power");
      }
      if (exponentValue < 0) {
        result = this.toComplex(this.divide(1, result), "power");
      }
      return this.fromComplex(result);
    }

    if (!this.approxZero(baseComplex.imag)) {
      throw new Error("Non-integer powers of complex numbers are not supported");
    }

    return Math.pow(baseComplex.real, exponentValue);
  }

  private factorial(value: RuntimeValue): RuntimeValue {
    const number = this.toNumber(value, "factorial");
    if (number < 0 || !this.isInteger(number)) {
      throw new Error("Factorial expects a non-negative integer");
    }
    let result = 1;
    for (let i = 2; i <= number; i += 1) {
      result *= i;
    }
    return result;
  }

  private isInteger(value: number): boolean {
    return Math.abs(value - Math.round(value)) <= this.epsilon;
  }

  private compare(operator: string, left: RuntimeValue, right: RuntimeValue): boolean {
    switch (operator) {
      case "==":
        return this.equals(left, right);
      case "!=":
        return !this.equals(left, right);
      case "<":
        return this.toNumber(left, "comparison") < this.toNumber(right, "comparison");
      case "<=":
        return this.toNumber(left, "comparison") <= this.toNumber(right, "comparison");
      case ">":
        return this.toNumber(left, "comparison") > this.toNumber(right, "comparison");
      case ">=":
        return this.toNumber(left, "comparison") >= this.toNumber(right, "comparison");
      default:
        throw new Error(`Unsupported operator '${operator}'`);
    }
  }

  private equals(left: RuntimeValue, right: RuntimeValue): boolean {
    if (typeof left === "number" || typeof right === "number" || typeof left === "boolean" || typeof right === "boolean" || this.isComplex(left) || this.isComplex(right)) {
      const a = this.toComplex(left, "equality");
      const b = this.toComplex(right, "equality");
      return this.approxZero(a.real - b.real) && this.approxZero(a.imag - b.imag);
    }

    if (typeof left === "string" && typeof right === "string") {
      return left === right;
    }

    if (Array.isArray(left) && Array.isArray(right)) {
      if (left.length !== right.length) {
        return false;
      }
      for (let i = 0; i < left.length; i += 1) {
        if (!this.equals(left[i], right[i])) {
          return false;
        }
      }
      return true;
    }

    return false;
  }

  private isTruthy(value: RuntimeValue | undefined): boolean {
    if (value === undefined) {
      return false;
    }
    if (typeof value === "boolean") {
      return value;
    }
    if (typeof value === "number") {
      return !this.approxZero(value);
    }
    if (typeof value === "string") {
      return value.length > 0;
    }
    if (Array.isArray(value)) {
      return value.length > 0;
    }
    if (this.isComplex(value)) {
      return !this.approxZero(value.real) || !this.approxZero(value.imag);
    }
    return false;
  }

  private expectArgCount(name: string, args: RuntimeValue[], count: number): void {
    if (args.length !== count) {
      throw new Error(`${name} expects ${count} argument(s)`);
    }
  }

  private numberUnary(name: string, args: RuntimeValue[], fn: (value: number) => number): RuntimeValue {
    this.expectArgCount(name, args, 1);
    return fn(this.toNumber(args[0], name));
  }

  private numberVariadic(name: string, args: RuntimeValue[], fn: (...values: number[]) => number): RuntimeValue {
    if (args.length === 1 && Array.isArray(args[0])) {
      const numbers = args[0].map((item) => this.toNumber(item, name));
      return fn(...numbers);
    }
    if (args.length === 0) {
      throw new Error(`${name} expects at least one argument`);
    }
    const numbers = args.map((item) => this.toNumber(item, name));
    return fn(...numbers);
  }
}
