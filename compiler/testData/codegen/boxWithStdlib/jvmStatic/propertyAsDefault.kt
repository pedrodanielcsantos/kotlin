object X {
    @JvmStatic val x = "OK"

    fun fn(value : String = x): String = value
}

fun box(): String {
    return X.fn()
}