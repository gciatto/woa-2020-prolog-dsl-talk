prolog {
  staticKb(
    rule {
      "ancestor"(X, Y) `if` "parent"(X, Y)        // ancestor(X, Y) :- parent(X, Y).
    },
    rule {
      "ancestor"(X, Y) `if` (                     // ancestor(X, Y) :-
        "parent"(X, Z) and "ancestor"(Z, Y)       //     parent(X, Z), ancestor(Z, Y).
      )
    },
    fact { "parent"("abraham", "isaac") },        // parent(abraham, isaac).
    fact { "parent"("isaac", "jacob") },          // parent(isaac, jacob).
    fact { "parent"("jacob", "joseph") }          // parent(jacob, joseph).
  )

  for (sol in solve("ancestor"("abraham", D)))    // ?- ancestor(abraham, D),
    if (sol is Solution.Yes)                      //        write(D), nl.
      println(sol.substitution[D])
}


