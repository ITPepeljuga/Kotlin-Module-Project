class ArchiveMenu : Menu() {
    private val archives = mutableListOf<String>()
    private val noteMenu = NoteMenu()

    override fun show() {
        println("Список архивов:")
        println("0. Создать архив")
        archives.forEachIndexed { index, archive ->
            println("${index + 1}. $archive")
        }
        println("${archives.size + 1}. Выход")

        val userInput = readLine()?.toIntOrNull()
        if (userInput != null) {
            when {
                userInput == 0 -> create()
                userInput in 1..archives.size -> noteMenu.show()
                userInput == archives.size + 1 -> exitApp()
                else -> {
                    println("Некорректный ввод. Введите цифру от 0 до ${archives.size + 1}.")
                    show()
                }
            }
        } else {
            println("Некорректный ввод. Пожалуйста, введите цифру от 0 до ${archives.size + 1}.")
            show()
        }
    }

    override fun create() {
        println("Создание нового архива")
        println("Введите название архива:")
        var archiveName: String? = readLine()
        while (archiveName.isNullOrBlank()) {
            println("Название архива не может быть пустым. Пожалуйста, введите название:")
            archiveName = readLine()
        }
        archives.add(archiveName!!)
        println("Архив \"$archiveName\" успешно создан")
        show()
    }

    override fun select(option: Int) {
    }

    private fun exitApp() {
        println("Выход из приложения")
    }
}
