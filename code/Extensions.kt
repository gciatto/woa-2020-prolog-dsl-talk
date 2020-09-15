fun Any.toTerm(): Term = // converts Kotlin objects into terms

operator fun String.invoke(vararg args: Term): Struct =
    Struct.of(this, args.map { it.toTerm() })

// now one can write
"member"("X", arrayOf(1 .. 3)) // member(X, [1, 2, 3])
