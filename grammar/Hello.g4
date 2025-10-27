grammar Hello;

// Parser Rules
prog: stat+ ;

stat: expr NEWLINE                 # printExpr
    | ID '=' expr NEWLINE          # assign
    | NEWLINE                      # blank
    ;

expr: expr op=('*'|'/') expr      # MulDiv
    | expr op=('+'|'-') expr      # AddSub
    | INT                          # int
    | ID                           # id
    | '(' expr ')'                 # parens
    ;

// Lexer Rules
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
ID  : [a-zA-Z]+ ;
INT : [0-9]+ ;
NEWLINE: '\r'? '\n' ;
WS  : [ \t]+ -> skip ;
