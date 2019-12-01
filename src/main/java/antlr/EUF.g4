grammar EUF;

formula: equality               #function
    | formula '^' equality      #conjunction
    ;

equality: fun '=' fun
    | fun '!=' fun
    ;

fun: IDENTIFIER
    | IDENTIFIER args
    ;

args: '(' (fun (',' fun)*)? ')';

IDENTIFIER: [a-zA-Z0-9]+;
WS : [ \t]+ -> skip ; // toss out whitespace