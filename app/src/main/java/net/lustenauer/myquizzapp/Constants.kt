package net.lustenauer.myquizzapp

object Constants {

    const val USER_NAME : String = "user_name"
    const val MAX_SCORE: String = "total_questions"
    const val SCORE: String = "correct_answers"

    fun getQuestions(): List<Question> = listOf(
        Question(
            id = 1,
            question = "What country does this flag belong to?",
            imageResourceId = R.drawable.ic_flag_of_argentina,
            options = listOf("Argentina", "Australia", "Armenia", "Austria"),
            correctOption = 0
        ),
        Question(
            id = 2,
            question = "What country does this flag belong to?",
            imageResourceId = R.drawable.ic_flag_of_australia,
            options = listOf("Angola", "Austria", "Australia", "Armenia"),
            correctOption = 2
        ),
        Question(
            id = 3,
            question = "What country does this flag belong to?",
            imageResourceId = R.drawable.ic_flag_of_brazil,
            options = listOf("Belarus", "Belize", "Brunei", "Brazil"),
            correctOption = 3
        ),
        Question(
            id = 4,
            question = "What country does this flag belong to?",
            imageResourceId = R.drawable.ic_flag_of_belgium,
            options = listOf("Bahamas", "Belgium", "Barbados", "Belize"),
            correctOption = 1
        ),
        Question(
            id = 5,
            question = "What country does this flag belong to?",
            imageResourceId = R.drawable.ic_flag_of_fiji,
            options = listOf("Gabon", "France", "Fiji", "Finland"),
            correctOption = 2
        ),
        Question(
            id = 6,
            question = "What country does this flag belong to?",
            imageResourceId = R.drawable.ic_flag_of_germany,
            options = listOf("Germany", "Georgia", "Greece", "none of these"),
            correctOption = 0
        ),
        Question(
            id = 7,
            question = "What country does this flag belong to?",
            imageResourceId = R.drawable.ic_flag_of_denmark,
            options = listOf("Dominica", "Egypt", "Denmark", "Ethiopia"),
            correctOption = 2
        ),
        Question(
            id = 8,
            question = "What country does this flag belong to?",
            imageResourceId = R.drawable.ic_flag_of_india,
            options = listOf("Ireland", "Iran", "Hungary", "India"),
            correctOption = 3
        ),
        Question(
            id = 9,
            question = "What country does this flag belong to?",
            imageResourceId = R.drawable.ic_flag_of_new_zealand,
            options = listOf("Australia", "New Zealand", "Tuvalu", "United States of America"),
            correctOption = 1
        ),
        Question(
            id = 10,
            question = "What country does this flag belong to?",
            imageResourceId = R.drawable.ic_flag_of_kuwait,
            options = listOf("Kuwait", "Jordan", "Sudan", "Palestine"),
            correctOption = 0
        )
    )
}