package task3

internal class DamageIdea(
    private val survivable: Survivable,
) : Idea {
    override fun embody() {
        survivable.survivability -= 1
    }
}