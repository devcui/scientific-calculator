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

type RuntimeValue = number | boolean | string | RuntimeValue[];

export class Caluctor implements CalculatorVisitor<RuntimeValue | undefined> {
  visitProgram(ctx: ProgramContext): RuntimeValue |undefined {
    let last: RuntimeValue | undefined;
    for (const stmt of ctx.statement()) {
      last = this.visit(stmt);
    }
    return last;
  }

  visitStatement(ctx: StatementContext): RuntimeValue |undefined{
    if(ctx.defineStmt()) return this.visitDefineStmt(ctx.defineStmt()!);
    if(ctx.assignment()) return this.visitAssignment(ctx.assignment()!);
    if(ctx.equationStmt()) return this.visitEquationStmt(ctx.equationStmt()!);
    if(ctx.printStmt()) return this.visitPrintStmt(ctx.printStmt()!);
    if(ctx.exprStmt()) return this.visitExprStmt(ctx.exprStmt()!);
    return undefined; 
  }

  visitDefineStmt(ctx: DefineStmtContext): RuntimeValue {
    console.log("Visiting DefineStmt", ctx.text);
    return 0;
  }

  visitAssignment(ctx: AssignmentContext): RuntimeValue {
    console.log("Visiting Assignment", ctx.text);
    return 0;
  }

  visitEquationStmt(ctx: EquationStmtContext): RuntimeValue {
    console.log("Visiting EquationStmt", ctx.text);
    return 0;
  }

  visitEquation(ctx: EquationContext): RuntimeValue {
    console.log("Visiting Equation", ctx.text);
    return 0;
  }

  visitPrintStmt(ctx: PrintStmtContext): RuntimeValue {
    console.log("Visiting PrintStmt", ctx.text);
    return 0;
  }

  visitExprStmt(ctx: ExprStmtContext): RuntimeValue {
    console.log("Visiting ExprStmt", ctx.text);
    return 0;
  }

  visitExpr(ctx: ExprContext): RuntimeValue {
    console.log("Visiting Expr", ctx.text);
    return 0;
  }

  visitExpr2(ctx: Expr2Context): RuntimeValue {
    console.log("Visiting Expr2", ctx.text);
    return 0;
  }

  visitExpr3(ctx: Expr3Context): RuntimeValue {
    console.log("Visiting Expr3", ctx.text);
    return 0;
  }

  visitComparison(ctx: ComparisonContext): RuntimeValue {
    console.log("Visiting Comparison", ctx.text);
    return false;
  }

  visitArith(ctx: ArithContext): RuntimeValue {
    console.log("Visiting Arith", ctx.text);
    return 0;
  }

  visitTerm(ctx: TermContext): RuntimeValue {
    console.log("Visiting Term", ctx.text);
    return 0;
  }

  visitFactor(ctx: FactorContext): RuntimeValue {
    console.log("Visiting Factor", ctx.text);
    return 0;
  }

  visitUnary(ctx: UnaryContext): RuntimeValue {
    console.log("Visiting Unary", ctx.text);
    return 0;
  }

  visitAtom(ctx: AtomContext): RuntimeValue {
    console.log("Visiting Atom", ctx.text);
    return 0;
  }

  visitImplicitMul(ctx: ImplicitMulContext): RuntimeValue {
    console.log("Visiting ImplicitMul", ctx.text);
    return 0;
  }

  visitFunctionCall(ctx: FunctionCallContext): RuntimeValue {
    console.log("Visiting FunctionCall", ctx.text);
    return 0;
  }

  visitArgList(ctx: ArgListContext): RuntimeValue {
    console.log("Visiting ArgList", ctx.text);
    return 0;
  }

  visitConstant(ctx: ConstantContext): RuntimeValue {
    console.log("Visiting Constant", ctx.text);
    return 0;
  }

  visitVector(ctx: VectorContext): RuntimeValue {
    console.log("Visiting Vector", ctx.text);
    return 0;
  }

  visitMatrix(ctx: MatrixContext): RuntimeValue {
    console.log("Visiting Matrix", ctx.text);
    return 0;
  }

  visitRow(ctx: RowContext): RuntimeValue {
    console.log("Visiting Row", ctx.text);
    return 0;
  }

  visitExprList(ctx: ExprListContext): RuntimeValue {
    console.log("Visiting ExprList", ctx.text);
    return 0;
  }

  visit(tree: ParseTree): RuntimeValue {
    return tree.accept(this);
  }

  visitChildren(node: RuleNode): RuntimeValue {
    return 0;
  }

  visitTerminal(node: TerminalNode): RuntimeValue {
    return node.text;
  }

  visitErrorNode(node: ErrorNode): RuntimeValue {
    return "Error";
  }
}
