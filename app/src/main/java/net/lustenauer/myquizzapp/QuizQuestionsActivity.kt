package net.lustenauer.myquizzapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.R.color.design_default_color_primary

class QuizQuestionsActivity : AppCompatActivity(), OnClickListener {
    private var questionIdx = 0
    private val questions = Constants.getQuestions().shuffled()
    private var selectedOption = -1
    private var score = questions.size
    private var questionDone = false

    private val pbProgress by lazy { findViewById<ProgressBar>(R.id.pb_progress) }
    private val tvProgress by lazy { findViewById<TextView>(R.id.tv_progress) }
    private val tvQuestion by lazy { findViewById<TextView>(R.id.tv_question) }
    private val ivQuestion by lazy { findViewById<ImageView>(R.id.iv_image) }
    private val tvOption0 by lazy { findViewById<TextView>(R.id.tv_option0) }
    private val tvOption1 by lazy { findViewById<TextView>(R.id.tv_option1) }
    private val tvOption2 by lazy { findViewById<TextView>(R.id.tv_option2) }
    private val tvOption3 by lazy { findViewById<TextView>(R.id.tv_option3) }
    private val btnSubmit by lazy { findViewById<Button>(R.id.btn_submit) }

    private val tvOptions by lazy { listOf<TextView>(tvOption0, tvOption1, tvOption2, tvOption3) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        pbProgress.max = questions.size

        tvOptions.forEach { it.setOnClickListener(this) }
        btnSubmit.setOnClickListener { onClickBtnSubmit() }
        btnSubmit.isEnabled = false

        setQuestion()
    }

    override fun onClick(view: View) {
        if (!questionDone) {
            if (tvOptions.contains(view)) {
                selectTvOption(view as TextView)
            }
            btnSubmit.isEnabled = selectedOption != -1
        }
    }

    private fun selectTvOption(tvOption: TextView) {
        resetTvOptions()
        selectedOption = tvOptions.indexOf(tvOption)

        tvOption.setTextColor(ContextCompat.getColor(this, design_default_color_primary))
        tvOption.typeface = Typeface.DEFAULT_BOLD
        tvOption.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

    private fun resetTvOptions() {
        tvOptions.forEach { option ->
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }

    }

    private fun setQuestion() {
        val question = questions[questionIdx]
        ivQuestion.setImageResource(question.imageResourceId)
        pbProgress.progress = questionIdx + 1
        tvProgress.text = "${questionIdx + 1} / ${pbProgress.max}"
        tvQuestion.text = question.question
        tvOption0.text = question.options[0]
        tvOption1.text = question.options[1]
        tvOption2.text = question.options[2]
        tvOption3.text = question.options[3]
    }

    private fun onClickBtnSubmit() {
        if (!questionDone) {
            questionDone = true

            val correctOption = questions[questionIdx].correctOption
            if (selectedOption != correctOption) {
                score--
                setTvOptionsBackground(selectedOption, R.drawable.wrong_option_border_bg)
            }
            setTvOptionsBackground(correctOption, R.drawable.correct_option_border_bg)

            if (questionIdx < questions.size - 1) {
                btnSubmit.text = "GO TO NEXT QUESTION"
                selectedOption = -1
            } else {
                btnSubmit.text = "FINISH"
                Intent(this, ResultActivity::class.java).apply {
                    putExtra(Constants.USER_NAME, intent.getStringExtra(Constants.USER_NAME))
                    putExtra(Constants.SCORE, score)
                    putExtra(Constants.MAX_SCORE, questions.size)
                    startActivity(this)
                    finish()
                }
            }

        } else {
            if (questionIdx < questions.size - 1) {
                questionIdx++
                setQuestion()
                resetTvOptions()
                questionDone = false
                btnSubmit.isEnabled = false
                btnSubmit.text = "SUBMIT"
            }
            Log.i("", "questionIdx:= $questionIdx")
        }
    }

    private fun setTvOptionsBackground(correctOption: Int, drawableResId: Int) {
        tvOptions[correctOption].background = ContextCompat.getDrawable(this, drawableResId)
    }
}