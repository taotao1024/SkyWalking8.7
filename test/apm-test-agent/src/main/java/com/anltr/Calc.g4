// Calc.g4 名称要和文件名一致
grammar Calc;

// Tokens
LE: '(';
RE: ')';
MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';
NUMBER: [0-9]+;
WHITESPACE: [ \r\n\t]+ -> skip;

// Rules 解析规则
start : expression EOF;

expression
   : expression op=('*'|'/') expression # MulDiv
   | expression op=('+'|'-') expression # AddSub
   | LE expression RE                   # LERE
   | NUMBER                             # Number
   ;

// 输入 1+2+3*4
// 分析1 NUMBER ADD NUMBER ADD NUMBER ADD MUL NUMBER