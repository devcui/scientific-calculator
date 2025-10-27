import { ErrorNode } from "antlr4ts/tree/ErrorNode";
import { ParseTree } from "antlr4ts/tree/ParseTree";
import { RuleNode } from "antlr4ts/tree/RuleNode";
import { TerminalNode } from "antlr4ts/tree/TerminalNode";
import { ProgramContext, StatementContext, DefineStmtContext, AssignmentContext, EquationStmtContext, EquationContext, PrintStmtContext, ExprStmtContext, ExprContext, Expr2Context, Expr3Context, ComparisonContext, ArithContext, TermContext, FactorContext, UnaryContext, AtomContext, ImplicitMulContext, FunctionCallContext, ArgListContext, ConstantContext, VectorContext, MatrixContext, RowContext, ExprListContext } from "../generated/grammar/CalculatorParser";
import { CalculatorVisitor } from "../generated/grammar/CalculatorVisitor";

export class Caluctor implements CalculatorVisitor<number | string | boolean> {
    visitProgram(ctx: ProgramContext): string | number | boolean {
        return 0; 
    }

    visitStatement(ctx: StatementContext): string | number | boolean {
        return 0;
    }

    visitDefineStmt(ctx: DefineStmtContext): string | number | boolean {
        return 0;
    }

    visitAssignment(ctx: AssignmentContext): string | number | boolean {
        return 0;
    }

    visitEquationStmt(ctx: EquationStmtContext): string | number | boolean {
        return 0;
    }

    visitEquation(ctx: EquationContext): string | number | boolean {
        return 0;
    }

    visitPrintStmt(ctx: PrintStmtContext): string | number | boolean {
        return 0;
    }

    visitExprStmt(ctx: ExprStmtContext): string | number | boolean {
        return 0;
    }

    visitExpr(ctx: ExprContext): string | number | boolean {
        return 0;
    }

    visitExpr2(ctx: Expr2Context): string | number | boolean {
        return 0;
    }

    visitExpr3(ctx: Expr3Context): string | number | boolean {
        return 0;
    }

    visitComparison(ctx: ComparisonContext): string | number | boolean {
        return false;
    }

    visitArith(ctx: ArithContext): string | number | boolean {
        return 0;
    }

    visitTerm(ctx: TermContext): string | number | boolean {
        return 0;
    }

    visitFactor(ctx: FactorContext): string | number | boolean {
        return 0;
    }

    visitUnary(ctx: UnaryContext): string | number | boolean {
        return 0;
    }

    visitAtom(ctx: AtomContext): string | number | boolean {
        return 0;
    }

    visitImplicitMul(ctx: ImplicitMulContext): string | number | boolean {
        return 0;
    }

    visitFunctionCall(ctx: FunctionCallContext): string | number | boolean {
        return 0;
    }

    visitArgList(ctx: ArgListContext): string | number | boolean {
        return 0;
    }

    visitConstant(ctx: ConstantContext): string | number | boolean {
        return 0;
    }

    visitVector(ctx: VectorContext): string | number | boolean {
        return 0;
    }

    visitMatrix(ctx: MatrixContext): string | number | boolean {
        return 0;
    }

    visitRow(ctx: RowContext): string | number | boolean {
        return 0;
    }

    visitExprList(ctx: ExprListContext): string | number | boolean {
        return 0;
    }

    visit(tree: ParseTree): string | number | boolean {
        return 0;
    }

    visitChildren(node: RuleNode): string | number | boolean {
        return 0;
    }

    visitTerminal(node: TerminalNode): string | number | boolean {
        return node.text;  
    }

    visitErrorNode(node: ErrorNode): string | number | boolean {
        return "Error";  
    }
}