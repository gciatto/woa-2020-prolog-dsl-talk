interface Term {
  operator fun plus(other: Term): Struct =
    Struct.of("+", this, other)
}

// now one can write:
val term3: Term = term1 + term2