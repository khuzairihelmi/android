package com.khu.dbmlearning;

import android.provider.BaseColumns;

public final class QuizContract {

    private QuizContract(){}

    public static class QuestionsTableQUIZ1 implements BaseColumns {

        public static final String TABLE_NAME_QUIZ1 = "quiz_question";
        public static final String COLUMN_QUESTION_QUIZ1 = "question";
        public static final String COLUMN_OPTION1_QUIZ1 = "option1";
        public static final String COLUMN_OPTION2_QUIZ1 = "option2";
        public static final String COLUMN_OPTION3_QUIZ1 = "option3";
        public static final String COLUMN_OPTION4_QUIZ1 = "option4";
        public static final String COLUMN_ANSWER_NR_QUIZ1 = "answer_nr";

    }

    public static class QuestionsTableQUIZ2 implements BaseColumns {

        public static final String TABLE_NAME_QUIZ2 = "quiz_question";
        public static final String COLUMN_QUESTION_QUIZ2 = "question";
        public static final String COLUMN_OPTION1_QUIZ2 = "option1";
        public static final String COLUMN_OPTION2_QUIZ2 = "option2";
        public static final String COLUMN_OPTION3_QUIZ2 = "option3";
        public static final String COLUMN_OPTION4_QUIZ2 = "option4";
        public static final String COLUMN_ANSWER_NR_QUIZ2 = "answer_nr";

    }

    public static class QuestionsTableQUIZ3 implements BaseColumns {

        public static final String TABLE_NAME_QUIZ3 = "quiz_question";
        public static final String COLUMN_QUESTION_QUIZ3 = "question";
        public static final String COLUMN_OPTION1_QUIZ3 = "option1";
        public static final String COLUMN_OPTION2_QUIZ3 = "option2";
        public static final String COLUMN_OPTION3_QUIZ3 = "option3";
        public static final String COLUMN_OPTION4_QUIZ3 = "option4";
        public static final String COLUMN_ANSWER_NR_QUIZ3 = "answer_nr";

    }
}
