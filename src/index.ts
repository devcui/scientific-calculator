import { CharStreams, CommonTokenStream } from "antlr4ts";
import { CalculatorLexer } from "../generated/grammar/CalculatorLexer";
import { CalculatorParser } from "../generated/grammar/CalculatorParser";
import { Caluctor } from "./calculator";

export function main() {
  // 输入流
  const inputStream = CharStreams.fromString(`
    print(+1+1);
    print(3 > 2 and 2 < 3);
    print(not(2 == 3 or 3 == 4));
    print(5 != 4 or 4 != 4);
    print( (2 + 3) * 4 );
    print(2 + 3 * 4);
    print( (5 - 2) / 3 );
`);
  // 词法解析
  const lexer = new CalculatorLexer(inputStream);
  // Token流
  const tokenStream = new CommonTokenStream(lexer);
  // 语法解析
  const parser = new CalculatorParser(tokenStream);
  // 语法树解析
  const ast = parser.program();
  // 计算结果
  const visitor = new Caluctor()
  // 计算结果
  visitor.visit(ast)
}

main();
