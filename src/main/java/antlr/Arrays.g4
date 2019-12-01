grammar Arrays;

formula: equality                       #function
    | formula '^' equality              #conjunction
    ;

equality: fun '=' fun
    | fun '!=' fun
    ;

fun: 'select(' fun ',' fun ')'          #select
    | 'store(' fun ',' fun ',' fun ')'  #store
    | IDENTIFIER                        #simpleName
    ;

IDENTIFIER: [a-zA-Z0-9]+;
WS : [ \t]+ -> skip ; // toss out whitespace