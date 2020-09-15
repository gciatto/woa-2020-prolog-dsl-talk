class PrologDsl {
  fun Any.toTerm(): Term = // ...
  operator fun String.invoke(vararg args: Term): Struct = // ...

  operator fun Any.plus(other: Any): Struct =
    this.toTerm() + other.toTerm()
}

//                 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ type with receiver
fun prolog(action: PrologDsl.() -> Any): Any =
    PrologDsl().action()

//     ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓  lambda with receiver
prolog { "f"("1") + "f"("2") } // in braces this is PrologDsl