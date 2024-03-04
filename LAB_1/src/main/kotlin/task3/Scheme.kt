package task3

internal sealed interface Scheme {
    val state: SchemaState
    fun disconnect()
}