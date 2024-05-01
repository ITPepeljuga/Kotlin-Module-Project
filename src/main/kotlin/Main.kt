fun main() {
    val archiveMenu = ArchiveMenu()
    val noteMenu = NoteMenu(archiveMenu)

    archiveMenu.show()

    if (archiveMenu.appStatus) {
        noteMenu.show()
    }
}
