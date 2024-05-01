class NoteMenu(private val archiveMenu: ArchiveMenu) : Menu() {
    private val noteManager = NoteManager()

    override fun show() {
        val noteList = noteManager.listNotes()
        println("Меню заметок:")
        println("0. Создать заметку")

        for (index in noteList.indices) {
            val note = noteList[index]
            println("${index + 1}. ${note.title}")
        }

        println("${noteList.size + 1}. Назад")

        val userInput = readLine()?.toIntOrNull()
        if (userInput != null) {
            when {
                userInput == 0 -> createNote()
                userInput in 1..noteList.size -> select(userInput - 1)
                userInput == noteList.size + 1 -> archiveMenu.show() // исправлена логика c Back
                else -> {
                    println("Некорректный ввод. Введите цифру от 0 до ${noteList.size + 1}.")
                    show()
                }
            }
        } else {
            println("Некорректный ввод. Пожалуйста, введите цифру от 0 до ${noteList.size + 1}.")
            show()
        }
    }

    override fun create() {}

    override fun select(option: Int) {
        val note = noteManager.getNoteAtIndex(option)
        if (note != null) {
            println("Выбрана заметка:")
            println("Заголовок: ${note.title}")
            println("Текст: ${note.text}")
            show()
        }
    }

    private fun createNote() {
        println("Создание новой заметки:")
        println("Введите заголовок заметки:")
        var title: String? = readLine()
        while (title.isNullOrBlank()) {
            println("Заголовок заметки не может быть пустым. Пожалуйста, введите заголовок:")
            title = readLine()
        }
        println("Введите текст заметки:")
        var text: String? = readLine()
        while (text.isNullOrBlank()) {
            println("Текст заметки не может быть пустым. Пожалуйста, введите текст:")
            text = readLine()
        }
        noteManager.addNote(title!!, text!!)
        show()
    }
}
