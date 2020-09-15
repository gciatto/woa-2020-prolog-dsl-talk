solutions.filter({ it -> it is Solution.Yes })
         .map({ it -> it.substitution["X"] })
         .joinToString(" ", { it.toString() })

 // ↑ can be rewritten as ↓

 solutions.filter { it is Solution.Yes }
          .map { it.substitution["X"] }
          .joinToString(" ") { it.toString() }