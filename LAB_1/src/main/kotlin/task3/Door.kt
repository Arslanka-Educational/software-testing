package task3

internal data class Door(
    override val cells: List<Cell>,
    override var survivability: Int,
) : MolecularComponent, Survivable
