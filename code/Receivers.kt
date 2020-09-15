class PrologScope {
  fun Any.toTerm(): Term = // ...
  operator fun String.invoke(vararg args: Term): Struct = // ...

  operator fun Any.plus(other: Any): Struct =
    this.toTerm() + other.toTerm()
}

// type with receiver  ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
fun <R> prolog(action: PrologScope.() -> R): R =
    PrologScope().action()

//     ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓  lambda with receiver
prolog { "f"("1") + "f"("2") } // in braces this is PrologScope