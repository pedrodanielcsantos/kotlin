// !WITH_NEW_INFERENCE
// !DIAGNOSTICS: -UNUSED_PARAMETER

fun Int.invoke(a: Int) {}
fun Int.invoke(a: Int, b: Int) {}

class SomeClass

fun test(identifier: SomeClass, fn: String.() -> Unit) {
    <!NI;NONE_APPLICABLE, OI;FUNCTION_EXPECTED, OI;DEBUG_INFO_MISSING_UNRESOLVED!>identifier<!>()
    <!NI;NONE_APPLICABLE, OI;UNRESOLVED_REFERENCE_WRONG_RECEIVER!>identifier<!>(123)
    <!NI;NONE_APPLICABLE, OI;UNRESOLVED_REFERENCE_WRONG_RECEIVER!>identifier<!>(1, 2)
    1.<!NI;DEBUG_INFO_MISSING_UNRESOLVED!><!NI;DEBUG_INFO_UNRESOLVED_WITH_TARGET, UNRESOLVED_REFERENCE_WRONG_RECEIVER!>fn<!>()<!>
}