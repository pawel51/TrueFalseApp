package com.example.task1_sm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val trueButton: Button = findViewById(R.id.trueButton)
        val falseButton: Button = findViewById(R.id.falseButton)
        val nextButton: Button = findViewById(R.id.nextButton)
        val question: TextView = findViewById(R.id.textView)

        var currentIndex = 0;
        val questionNumber = 4;
        val questions: IntArray = intArrayOf(
            R.string.q1,
            R.string.q2,
            R.string.q3,
            R.string.q4,
        )
        val answers: IntArray = intArrayOf(
            R.string.a1,
            R.string.a2,
            R.string.a3,
            R.string.a4
        )

        fun showToast(b: Boolean) {
            if (b)
                Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, R.string.incorrect, Toast.LENGTH_SHORT).show()
        }

        fun updateIndex() {
            currentIndex = if (currentIndex + 1 == questionNumber) 0 else currentIndex + 1
            question.setText(questions[currentIndex])
        }

        fun checkAnswer(usersAnswer: String) {
            if (getString(answers[currentIndex]) == usersAnswer) {
                showToast(true)
            } else
                showToast(false)
            updateIndex();
        }

        trueButton.setOnClickListener { checkAnswer("True") }
        falseButton.setOnClickListener { checkAnswer("False") }
        nextButton.setOnClickListener { updateIndex() }

        // Display first
        updateIndex();
    }


}