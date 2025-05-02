grammar Polynomial;   // Nyelvtan neve.

program: statement* EOF;   // Egy program 0 vagy több utasításból áll, amelyet a fájl vége követ.

statement
    : 'polynom' ID (',' ID)* ';'    // Egy vagy több polinom típusú változó deklarálása.
    | 'number' ID (',' ID)* ';'     // Egy vagy több szám típusú változó deklarálása.
    | ID '=' expr ';'               // Változóhoz érték rendelés.
    | 'show' expr ';'               // Kiíratás.
    ;

expr
    : expr '[' expr ']'                     #EvalExpr          // Polinom kiértékelés.
    | expr op=('*'|'/'|'%') expr            #MulDivModExpr     // Szorzás, osztás, maradékos osztás.
    | expr op=('+'|'-') expr                #AddSubExpr        // Összeadás, kivonás.
    | '(' expr ')'                          #ParenExpr         // Zárójelezés.
    | polynomial                            #PolynomialExpr    // Polinom.
    | NUM                                   #NumExpr           // Szám.
    | ID                                    #VarExpr           // Változó.
    ;

polynomial: '<' polyTerm (('+'|'-') polyTerm)* '>';   // Polinom felépítése.

polyTerm
    : (NUM | ID)? 'x' '^' NUM   // pl.: 3x^2 vagy ax^3.
    | (NUM | ID)? 'x'           // pl.: 4x vagy ax.
    | NUM                       // Konstans tag.
    | ID                        // Változó.
    ;

NUM: [0-9]+ ('.' [0-9]+)?;        // Egész vagy valós szám.
ID: [a-zA-Z_][a-zA-Z_0-9]*;       // Változó név.

WS: [ \t\r\n]+ -> skip;           // Whitespace kihagyása.
COMMENT: '//' ~[\r\n]* -> skip;   // Kommentek kihagyása.