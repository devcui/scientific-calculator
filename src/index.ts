import { CharStreams, CommonTokenStream } from "antlr4ts";
import { CalculatorLexer } from "../generated/grammar/CalculatorLexer";
import { CalculatorParser } from "../generated/grammar/CalculatorParser";
import { Caluctor } from "./calculator";

export function main() {
  // 输入流
  const inputStream = CharStreams.fromString(`
    var a = 1;
    a = a + 1;
    var b = 3 + 1;
    print(a + b);
    print(+1 + 1);
    print(3 > 2 and 2 < 3);
    print(not(2 == 3 or 3 == 4));
    print(5 != 4 or 4 != 4);
    print((2 + 3) * 4);
    print(2 + 3 * 4);
    print((5 - 2) / 3);

    // 数学函数
    var angle = pi / 2;
    print(sin(angle));
    print(cos(0));
    print(tan(pi / 4));
    print(log(e));
    print(sqrt(16));

    // 隐式乘法与复数
    var x = 2(3 + 4);
    print(x);
    print(2i * 2i);

    // 幂和阶乘
    print(2 ^ 5);
    print(5!);

    // 向量与矩阵
    var vec = [1, 2, 3];
    var mat = [ [1, 2]; [3, 4] ];
    print(vec);
    print(mat);
    print(len(vec));
    print(sum(vec));

    // 变量与等式
    var y = angle;
    y = y - pi / 2;
    print(y == 0);
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
