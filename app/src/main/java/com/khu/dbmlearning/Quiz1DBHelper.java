package com.khu.dbmlearning;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

class Quiz1DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Quiz1.db";
    private static final int DATABASE_VERSION = +1;

    private SQLiteDatabase db;

    Quiz1DBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +

                QuizContract.QuestionsTableQUIZ1.TABLE_NAME_QUIZ1 + " ( " +

                QuizContract.QuestionsTableQUIZ1._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                QuizContract.QuestionsTableQUIZ1.COLUMN_QUESTION_QUIZ1 + " TEXT, " +

                QuizContract.QuestionsTableQUIZ1.COLUMN_OPTION1_QUIZ1 + " TEXT, " +

                QuizContract.QuestionsTableQUIZ1.COLUMN_OPTION2_QUIZ1 + " TEXT, " +

                QuizContract.QuestionsTableQUIZ1.COLUMN_OPTION3_QUIZ1 + " TEXT, " +

                QuizContract.QuestionsTableQUIZ1.COLUMN_OPTION4_QUIZ1 + " TEXT, " +

                QuizContract.QuestionsTableQUIZ1.COLUMN_ANSWER_NR_QUIZ1 + " INTEGER" +

                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionTableQUIZ1();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + QuizContract.QuestionsTableQUIZ1.TABLE_NAME_QUIZ1);

        onCreate(db);
    }

    /*=========================================== fillQuestion =========================================================*/

    private void fillQuestionTableQUIZ1()
    {
        Question q1 = new Question("Select the CORRECT symbolic notation for project operator.", "A. π", "B. X.", "C. σ.","D. ∪.", 1);
        addQuestionQUIZ1(q1);

        Question q2 = new Question("Choose the most suitable example of data.", "A. City", "B. State", "C. Pahang","D. Country", 2);
        addQuestionQUIZ1(q2);

        Question q3 = new Question("Select the most suitable term that will define the relationships between tables that can be used as a cross reference table.", "A. Foreign Key", "B. Primary Key", "C. Candidate Key","D. Composite Key", 2);
        addQuestionQUIZ1(q3);

        Question q4 = new Question("Select the CORRECT relational algebra statement to view Zahra Husna’s birth date.", "A. πname(σname= ‘Zahra Husna’)(EMPLOYEE)", "B. πbirhdate(σname=‘Zahra Husna’)(EMPLOYEE)", "C. σ name(πname= ‘Zahra Husna’)(EMPLOYEE)","D. σ birhdate(πname=‘Zahra Husna’)(EMPLOYEE)", 4);
        addQuestionQUIZ1(q4);

        Question q5 = new Question("List all managerID and managerName whose workExperience more than 5.", "A. πmanagerID,managerName (σworkExperience=5)(MANAGER)", "B. πmanagerID,managerName (σworkExperience>5)(MANAGER)", "C. σmanagerID,managerName (πworkExperience=5)(MANAGER)","D. σmanagerID,managerName (πworkExperience>5)(MANAGER)", 2);
        addQuestionQUIZ1(q5);

    }

    /*====================================== addQuestion =========================================================== */

    private void addQuestionQUIZ1(Question question)
    {
        ContentValues cv = new ContentValues();
        cv.put(QuizContract.QuestionsTableQUIZ1.COLUMN_QUESTION_QUIZ1, question.getQuestion());
        cv.put(QuizContract.QuestionsTableQUIZ1.COLUMN_OPTION1_QUIZ1, question.getOption1());
        cv.put(QuizContract.QuestionsTableQUIZ1.COLUMN_OPTION2_QUIZ1, question.getOption2());
        cv.put(QuizContract.QuestionsTableQUIZ1.COLUMN_OPTION3_QUIZ1, question.getOption3());
        cv.put(QuizContract.QuestionsTableQUIZ1.COLUMN_OPTION4_QUIZ1, question.getOption4());
        cv.put(QuizContract.QuestionsTableQUIZ1.COLUMN_ANSWER_NR_QUIZ1, question.getAnswerNr());

        db.insert(QuizContract.QuestionsTableQUIZ1.TABLE_NAME_QUIZ1, null, cv);

    }

    /*================================= getAllQuestion ========================================================== */

    List<Question> getAllQuestionQUIZ1()
    {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract.QuestionsTableQUIZ1.TABLE_NAME_QUIZ1,null);

        if (c.moveToFirst())
        {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionsTableQUIZ1.COLUMN_QUESTION_QUIZ1)));
                question.setOption1(c.getString(c.getColumnIndex(QuizContract.QuestionsTableQUIZ1.COLUMN_OPTION1_QUIZ1)));
                question.setOption2(c.getString(c.getColumnIndex(QuizContract.QuestionsTableQUIZ1.COLUMN_OPTION2_QUIZ1)));
                question.setOption3(c.getString(c.getColumnIndex(QuizContract.QuestionsTableQUIZ1.COLUMN_OPTION3_QUIZ1)));
                question.setOption4(c.getString(c.getColumnIndex(QuizContract.QuestionsTableQUIZ1.COLUMN_OPTION4_QUIZ1)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuizContract.QuestionsTableQUIZ1.COLUMN_ANSWER_NR_QUIZ1)));
                questionList.add(question);
            }
            while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

}
