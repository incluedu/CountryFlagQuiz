package net.lustenauer.myquizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName = findViewById<TextView>(R.id.tv_name)
        val tvScore = findViewById<TextView>(R.id.tv_score)
        val btnFinish = findViewById<TextView>(R.id.btn_finish)

        tvName.text = intent.getStringExtra(Constants.USER_NAME)

        val score = intent.getIntExtra(Constants.SCORE,0)
        val maxScore = intent.getIntExtra(Constants.MAX_SCORE,0)
        tvScore.text = "Your Score is $score out of $maxScore"

        btnFinish.setOnClickListener {
            Intent(this, QuizQuestionsActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }
    }
}