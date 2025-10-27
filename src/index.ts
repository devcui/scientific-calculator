import { ANTLRInputStream, CommonTokenStream } from 'antlr4ts';
import { HelloLexer } from '../generated/grammar/HelloLexer';
import { HelloParser } from '../generated/grammar/HelloParser';
import { HelloVisitor } from '../generated/grammar/HelloVisitor';
import { AbstractParseTreeVisitor } from 'antlr4ts/tree/AbstractParseTreeVisitor';
import * as Context from '../generated/grammar/HelloParser';

// 自定义访问器，用于遍历解析树
class MyVisitor extends AbstractParseTreeVisitor<void> implements HelloVisitor<void> {
  defaultResult(): void {
    return;
  }

  visitProg(ctx: Context.ProgContext): void {
    console.log('Visiting program...');
    this.visitChildren(ctx);
  }

  visitPrintExpr(ctx: Context.PrintExprContext): void {
    console.log('Print expression:', ctx.text);
    this.visitChildren(ctx);
  }

  visitAssign(ctx: Context.AssignContext): void {
    console.log('Assignment:', ctx.text);
    this.visitChildren(ctx);
  }

  visitBlank(ctx: Context.BlankContext): void {
    // 空行，忽略
  }

  visitMulDiv(ctx: Context.MulDivContext): void {
    console.log('MulDiv operation:', ctx.text);
    this.visitChildren(ctx);
  }

  visitAddSub(ctx: Context.AddSubContext): void {
    console.log('AddSub operation:', ctx.text);
    this.visitChildren(ctx);
  }

  visitInt(ctx: Context.IntContext): void {
    console.log('Integer:', ctx.text);
  }

  visitId(ctx: Context.IdContext): void {
    console.log('Identifier:', ctx.text);
  }

  visitParens(ctx: Context.ParensContext): void {
    console.log('Parentheses:', ctx.text);
    this.visitChildren(ctx);
  }
}

// 主函数
function main() {
  // 示例输入
  const input = `a = 5
b = 10
a + b * 2
`;

  console.log('Input:');
  console.log(input);
  console.log('\nParsing...\n');

  // 创建输入流
  const inputStream = new ANTLRInputStream(input);

  // 创建词法分析器
  const lexer = new HelloLexer(inputStream);

  // 创建token流
  const tokenStream = new CommonTokenStream(lexer);

  // 创建语法分析器
  const parser = new HelloParser(tokenStream);

  // 解析程序
  const tree = parser.prog();

  // 创建访问器并遍历解析树
  const visitor = new MyVisitor();
  visitor.visit(tree);

  console.log('\nParsing completed!');
}

// 运行主函数
main();
