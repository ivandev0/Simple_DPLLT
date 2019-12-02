grammar Common;

formula: equality                           #singleEquality
    | '(' formula ')'                       #parenthesized
    | '!' formula                           #not
    | formula 'v' formula                   #disjunction
    | formula '^' formula                   #conjunction
    | formula '->' formula                  #implication
    | formula '<->' formula                 #equivalence
    ;

equality: fun '=' fun                       #equal
    | fun '!=' fun                          #notEqual
    ;

fun: IDENTIFIER                             #simple
    | IDENTIFIER args                       #funWithArgs
    | 'select' '(' fun ',' fun ')'          #select
    | 'store' '(' fun ',' fun ',' fun ')'   #store
    ;

args: '(' (fun (',' fun)*)? ')';

IDENTIFIER: [a-zA-Z0-9]+;
WS : [ \t]+ -> skip ; // toss out whitespace