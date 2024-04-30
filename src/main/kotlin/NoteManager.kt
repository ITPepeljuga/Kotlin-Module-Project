class NoteManager {
    private val notes = mutableListOf<Note>()

    fun addNote(title: String, text: String) {
        val note = Note(title, text)
        notes.add(note)
        println("Заметка успешно добавлена.")
    }

    fun listNotes(): List<Note> {
        if (notes.isEmpty()) {
            println("Список заметок пуст.")
        }
        return notes.toList()
    }

    fun getNoteAtIndex(index: Int): Note? {
        if (index < 0 || index >= notes.size) {
            println("Некорректный номер заметки.")
            return null
        }
        return notes[index]
    }
}
