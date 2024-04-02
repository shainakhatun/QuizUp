package com.example.quizup

import ResultActivity
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.myquizapp.R
import com.example.quizup.R


class QuizActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var isSelectedAnswer: Boolean = false
    private var mUserName: String? = null
    private var mCorrectAnswer: Int = 0

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null
    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null
    private var btnSubmit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        setPassingRetrieveDataIntent()
        setUpView()
        getQuestions()
        setQuestionList()
        defaultOptionsView()

    }

    private fun setUpView() {
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_question)
        tvOptionOne = findViewById(R.id.tv_option_one)
        tvOptionTwo = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)
        btnSubmit = findViewById(R.id.btn_submit)

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)
    }

    private fun setPassingRetrieveDataIntent() {
        mUserName = intent.getStringExtra(Constants.USER_NAME)
    }

    private fun getQuestions() {
        mQuestionList = Constants.getQuestions()
    }

    private fun setQuestionList() {
        defaultOptionsView()
        mQuestionList?.let {
            val questionsList = it
            val currentPosition = mCurrentPosition
            val question : Question = questionsList[currentPosition - 1]

            ivImage?.setImageResource(question.image)
            progressBar?.progress = currentPosition

            tvProgress?.text = "$currentPosition/${questionsList.size}"
            tvQuestion?.text = question.question
            tvOptionOne?.text = question.optionOne
            tvOptionTwo?.text = question.optionTwo
            tvOptionThree?.text = question.optionThree
            tvOptionFour?.text = question.optionFour

            if (currentPosition > questionsList.size) {
                btnSubmit?.text = "FINISH"
            } else {
                btnSubmit?.text = "SUBMIT"
            }
        }

        intent.putExtra(Constants.USER_NAME, mUserName)
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0,it)
        }
        tvOptionTwo?.let {
            options.add(1,it)
        }
        tvOptionThree?.let {
            options.add(2,it)
        }
        tvOptionFour?.let {
            options.add(3,it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.default_option_border)
        }
    }

    private fun selectedOptionView(tv:TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        isSelectedAnswer = true
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_option_border)
    }

    override fun onClick(view: View?) {
        val isAnswerNotSubmitDone : Boolean =  (btnSubmit?.text == "SUBMIT")
        when (view?.id) {

            R.id.tv_option_one -> {
                if  (isAnswerNotSubmitDone) {
                    tvOptionOne?.let {
                        selectedOptionView(it,1)
                    }
                }
            }

            R.id.tv_option_two -> {
                if  (isAnswerNotSubmitDone) {
                    tvOptionTwo?.let {
                        selectedOptionView(it,2)
                    }
                }
            }

            R.id.tv_option_three -> {
                if  (isAnswerNotSubmitDone) {
                    tvOptionThree?.let {
                        selectedOptionView(it,3)
                    }
                }
            }

            R.id.tv_option_four -> {
                if  (isAnswerNotSubmitDone) {
                    tvOptionFour?.let {
                        selectedOptionView(it,4)
                    }
                }

            }

            R.id.btn_submit -> {
                btnSubmit?.let {
                    if (mSelectedOptionPosition == 0) {
                        if (isSelectedAnswer == true) {
                            isSelectedAnswer = false

                            mCurrentPosition++

                            when {
                                mCurrentPosition <= mQuestionList!!.size -> {
                                    setQuestionList()
                                }
                                else -> {
                                    val intent = Intent(this,ResultActivity::class.java)
                                    intent.putExtra(Constants.USER_NAME, mUserName)
                                    intent.putExtra(Constants.CORRECT_ANSWER, mCorrectAnswer)
                                    intent.putExtra(Constants.TOTAL_QUESTIONS,
                                    mQuestionList!!.size)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}