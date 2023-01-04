package net.lustenauer.myquizzapp

data class Question(
    val id: Int,
    val question: String,
    val imageResourceId: Int,
    val options: List<String>,
    val correctOption: Int
)
