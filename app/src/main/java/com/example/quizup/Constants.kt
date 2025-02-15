package com.example.quizup

import com.example.myquizapp.R

object Constants {

        const val USER_NAME: String = "user_name"
        const val TOTAL_QUESTIONS: String = "total_questions"
        const val CORRECT_ANSWER: String = "correct_answers"

        fun getQuestions(): ArrayList<Question> {
            val questionsList = ArrayList<Question>()

            // 1
            val que1 = Question(
                1, "What country does this flag belong to?",
                R.drawable.img,
                "Argentina", "Australia",
                "Armenia", "Austria", 1
            )

            questionsList.add(que1)

            // 2
            val que2 = Question(
                2, "What country does this flag belong to?",
                R.drawable.img,
                "India", "Austria",
                "Australia", "Armenia", 3
            )

            questionsList.add(que2)

            // 3
            val que3 = Question(
                3, "What country does this flag belong to?",
                R.drawable.img,
                "", "Belize",
                "Brunei", "Brazil", 4
            )

            questionsList.add(que3)

            // 4
            val que4 = Question(
                4, "What country does this flag belong to?",
                R.drawable.img,
                "Bahamas", "Belgium",
                "India", "Belize", 2
            )

            questionsList.add(que4)

            // 5
            val que5 = Question(
                5, "What country does this flag belong to?",
                R.drawable.img,
                "Gabon", "France",
                "Fiji", "India", 3
            )

            questionsList.add(que5)

            // 6
            val que6 = Question(
                6, "What country does this flag belong to?",
                R.drawable.img,
                "Germany", "Georgia",
                "Greece", "none of these", 1
            )

            questionsList.add(que6)

            // 7
            val que7 = Question(
                7, "What country does this flag belong to?",
                R.drawable.img,
                "Dominica", "Egypt",
                "India", "Ethiopia", 3
            )

            questionsList.add(que7)

            // 8
            val que8 = Question(
                8, "What country does this flag belong to?",
                R.drawable.img,
                "Ireland", "Iran",
                "Hungary", "India", 4
            )

            questionsList.add(que8)

            // 9
            val que9 = Question(
                9, "What country does this flag belong to?",
                R.drawable.img,
                "Australia", "India",
                "Tuvalu", "United States of America", 2
            )

            questionsList.add(que9)

            // 10
            val que10 = Question(
                10, "What country does this flag belong to?",
                R.drawable.img,
                "Kuwait", "Jordan",
                "India", "Palestine", 1
            )

            questionsList.add(que10)

            return questionsList
        }
        // END
        var MAX_PROGRESS_VALUE = 10
    }
