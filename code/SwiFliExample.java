Query query = new Query("parent", new Term[] {
      new Atom("adam"),
      new Variable("X")
    }
  );  // ?- parent(adam, X).
Map<String,Term> solution = query.oneSolution();
System.out.println("The child of Adam is " + solution.get("X"));
