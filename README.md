# Fordítóprogramok gyakorlat projektmunka

Projektmunka témája: Polinom-számológép

Felhasznált eszközök: [ANTLR](https://www.antlr.org/), Java

A program képes valós együtthatós polinomokkal (polinomtörtekkel) számolni.

* Egy polinom <a_n x^n + ... + a_1 x + a_0> alakban adható meg, ahol
* az x egy foglalt nyelvi elem
* n tetszőleges egész szám lehet
* a_n ... a_0 valós együttható értékek (literálok)
* a 0 együtthatójú tag elhagyható
* az x^1 jelölés írható x alakban is
* az x^0 jelölés pedig elhagyható (ekkor csak az a_0 együttható szerepel a polinom megadásában).
* Polinom-változóknak p = <kifejezés> alakban lehet értéket adni, ahol
* p egy polynom p;-ként deklarált változó,
* a <kifejezés> egy polinom-kifejezés.
* Polinomokkal a következő műveletek végezhetők:
* +, -, *, /, % (utóbbi kettő maradékos polinom-osztás hányadosa és maradéka, mindkettő polinom),
* zárójelezés ( és ) segítségével, valamint
* kiértékelés <kifejezés>[X] alakban, ahol X tetszőleges valós szám lehet, és
* a kiértékelés művelet magas prioritású.
* A program show utasítása kiírja a megadott kifejezés értékét (ha az polinom, akkor a polinomot).
* A programban lehetnek valós típusú változók (number), amelyek a polinomokban együtthatóként használhatók.
