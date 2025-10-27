grammar Calculator;

// ─────────────────────────────────────────────────────────────
// Program
// ─────────────────────────────────────────────────────────────
program
    : statement* EOF
    ;

statement
    : defineStmt (SEMICOLON | NEWLINE)?
    | assignment (SEMICOLON | NEWLINE)?
    | equationStmt (SEMICOLON | NEWLINE)?
    | printStmt (SEMICOLON | NEWLINE)?
    | exprStmt (SEMICOLON | NEWLINE)?
    | NEWLINE
    ;

// ─────────────────────────────────────────────────────────────
// Statements
// ─────────────────────────────────────────────────────────────
defineStmt // 定义语句 声明变量 = 表达式
    : VAR ID ASSIGN expr
    ;

assignment  // 定义赋值语句 变量 = 表达式
    : ID ASSIGN expr
    ;

equationStmt // 比较语句  表达式 == 表达式
    : equation
    ;

equation // 表达式 比较运算符 表达式
    : expr EQUAL expr
    ;

printStmt // 输出语句 print(表达式)
    : PRINT LPAREN expr RPAREN
    ;

exprStmt // 表达式语句 仅包含表达式
    : expr
    ;

// ─────────────────────────────────────────────────────────────
// Expressions (with precedence)
// ─────────────────────────────────────────────────────────────
// Logical OR
expr // 优先级最低 因为在最外层
    : expr OR expr2 // 递归 左右或运算 
    | expr2 // 如果没有 or 则进入下一层
    ;

// Logical AND
expr2 // 优先级 第二低 在or里层
    : expr2 AND expr3 // 递归 左右与运算
    | expr3  // 如果没有 and 则进入下一层
    ;

// NOT
expr3 // 优先级 第三低 在and里层
    : NOT expr3 // 递归 非运算
    | comparison // 如果没有 not 则进入下一层
    ;

// Comparison
comparison // 优先级 第四低 在not里层
    : arith ((EQUAL | NOT_EQUAL | LESS | LESS_EQUAL | GREATER | GREATER_EQUAL) arith)* 
    ; 
    // a == b , 
    // 2 < 3 <= 5
    //  x + 1 != y * 2 > z 
    // ((x + 1) != (y * 2)) and ((y * 2) > z)

// Addition / Subtraction
arith // 优先级 第五低 在comparison里层
    : arith PLUS term // 左递归，加法
    | arith MINUS term // 左递归，减法
    | term // 如果没有加减则进入下一层
    ;

// Multiplication / Division / Modulo
term // 优先级 第六低 在arith里层
    : term MULT factor // 左递归，乘法
    | term DIV factor // 左递归，除法
    | term MOD factor // 左递归，取模
    | factor // 若果没有乘除模则进入下一层
    ;

// Power (right associative)
factor // 优先级 第七低 在term里层
    : unary POW factor // 右递归，幂运算
    | unary // 如果没有幂运算则进入下一层
    ;

// Unary
unary // 优先级 第八低 在factor里层
    : PLUS unary  // 右递归，正号
    | MINUS unary // 右递归，负号
    | atom // 数值部分 
    ;

// ─────────────────────────────────────────────────────────────
// Atom Types
// ─────────────────────────────────────────────────────────────
atom
    : NUMBER        //数字
    | IMAG              //虚数
    | ID                    //变量
    | constant       //常量
    | functionCall  //函数调用
    | LPAREN expr RPAREN  //括号表达式
    | vector           //向量
    | matrix          //矩阵
    | atom FACT //阶乘
    | implicitMul //隐式乘法
    ;

// Support implicit multiplication: 2x → 2 * x
implicitMul
    : NUMBER ID // 2var
    | NUMBER LPAREN expr RPAREN // 2(1+1)
    | ID LPAREN expr RPAREN // x(1+1)
    | constant ID // PI(x) E(y)
    | ID ID // xx xy abc
    ;

// ─────────────────────────────────────────────────────────────
// Function Calls
// ─────────────────────────────────────────────────────────────
functionCall
    : ID LPAREN argList? RPAREN 
    ;

argList
    : expr (COMMA expr)*
    ;

constant
    : PI
    | E
    ;

// ─────────────────────────────────────────────────────────────
// Vectors & Matrices
// ─────────────────────────────────────────────────────────────
vector
    : LBRACK exprList? RBRACK 
    ;

matrix
    : LBRACK row (SEMICOLON row)* RBRACK
    ;

row
    : exprList
    ;

exprList
    : expr (COMMA expr)*
    ;

// ─────────────────────────────────────────────────────────────
// Lexer
// ─────────────────────────────────────────────────────────────
VAR : 'var';

PI : 'pi';
E  : 'e';

PRINT: 'print';
OR : 'or';
AND : 'and';
NOT : 'not';

ID : [a-zA-Z_][a-zA-Z0-9_]* ;

// Complex number literal: 2i, 3.5i, .5i, 1e3i
IMAG : (DECIMAL_LITERAL | HEX_LITERAL | BIN_LITERAL | OCT_LITERAL) [iI] ;

NUMBER : DECIMAL_LITERAL | HEX_LITERAL | BIN_LITERAL | OCT_LITERAL ;

fragment BIN_LITERAL : '0' [bB] [01]+ ;  // 0b1010
fragment OCT_LITERAL : '0' [oO] [0-7]+ ; // 0o755
fragment HEX_LITERAL : '0' [xX] [0-9a-fA-F]+ ; // 0x1A3F
fragment DECIMAL_LITERAL : [0-9]+ ('.' [0-9]*)? ([eE][+-]?[0-9]+)? | '.' [0-9]+ ([eE][+-]?[0-9]+)? ;

PLUS : '+' ;
MINUS : '-' ;
MULT : '*' ;
DIV : '/' ;
MOD : '%' ;
POW : '^' ;
ASSIGN : '=' ;
LPAREN : '(' ;
RPAREN : ')' ;
LBRACK : '[' ;
RBRACK : ']' ;
COMMA : ',' ;
SEMICOLON : ';' ;

EQUAL : '==' ;
NOT_EQUAL : '!=' ;
LESS_EQUAL : '<=' ;
GREATER_EQUAL : '>=' ;
LESS : '<' ;
GREATER : '>' ;

FACT : '!' ;

// Comments
LINE_COMMENT : '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT : '/*' .*? '*/' -> skip ;

// Whitespace
WS : [ \t\r]+ -> skip ;
NEWLINE : '\r'? '\n' ;

