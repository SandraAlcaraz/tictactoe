ordered(1,2,3).
ordered(4,5,6).
ordered(7,8,9).
ordered(1,4,7).
ordered(2,5,8).
ordered(3,6,9).
ordered(1,5,9).
ordered(3,5,7).

line(A,B,C):-ordered(A,B,C).
line(A,B,C):-ordered(A,C,B).
line(A,B,C):-ordered(B,A,C).
line(A,B,C):-ordered(B,C,A).
line(A,B,C):-ordered(C,A,B).
line(A,B,C):-ordered(C,B,A).

:- dynamic x/1, o/1.

empty(A):- \+(full(A)).

win(A) :- x(B),x(C), line(A,B,C).

blockwin(A):-o(B),o(C),line(A,B,C).

different(A,B):- \+(same(A,B)).

split(A):-x(B),x(C), different(B,C), line(A,B,D), line(A,C,E), empty(D),empty(E).
risky(C):-o(D), line(C,D,E), empty(E).
strongbuild(A):-x(B), line(A,B,C), empty(C), \+(risky(C)).

doublerisky(C):- o(D),o(E), different(D,E),line(C,D,F), line(C,E,G), empty(F), empty(G).


weakbuild(A):-x(B), line(A,B,C), empty(C), \+(doublerisky(C)).


same(A,A).

good(A):-win(A).
good(A):-blockwin(A).
good(A):-split(A).
good(A):-strongbuild(A).
good(A):- weakbuild(A).
good(5).
good(1).
good(3).
good(7).
good(9).
good(2).
good(4).
good(6).
good(8).


move(A):-good(A),empty(A).

full(A):-x(A).
full(A):-o(A).


