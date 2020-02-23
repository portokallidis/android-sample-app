package com.nporto.lms;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.nporto.lms.data.chapters;
import com.nporto.lms.model.Chapter;
import com.nporto.lms.model.QuestionSet;
import com.nporto.lms.model.Score;

import java.util.ArrayList;
import java.util.Random;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_one, btn_two, btn_three, btn_four;
    TextView tv_question;


    private int chapterIndex;
    private String chapterTitle;
    private com.nporto.lms.model.QuestionSet questionSet;

    private String answer;
    private int questionLength;

    private int QuestionSet = 4;
    private int QuestionCounter = 0;
    private int CorrentAnswersCounter = 0;
    private Chapter chapterData;

    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Intent iin= getIntent();
        Bundle extras = iin.getExtras();

        TextView ViewChapter = (TextView) findViewById(R.id.toolbar_title);


        chapters data = new chapters();
        ArrayList<Chapter> chaptersList = data.getData();
        random = new Random();



        btn_one = (Button)findViewById(R.id.btn_one);
        btn_one.setOnClickListener(this);
        btn_two = (Button)findViewById(R.id.btn_two);
        btn_two.setOnClickListener(this);
        btn_three = (Button)findViewById(R.id.btn_three);
        btn_three.setOnClickListener(this);
        btn_four = (Button)findViewById(R.id.btn_four);
        btn_four.setOnClickListener(this);
        tv_question = (TextView)findViewById(R.id.tv_question);

        if(extras!=null)
        {
//            data
            chapterIndex = extras.getInt("chapter");
            chapterTitle = extras.getString("chapterTitle");
            ViewChapter.setText(chapterTitle);

//            init questionSet data
            chapterData = chaptersList.get(chapterIndex);
            questionSet = new QuestionSet(chapterData);
            questionLength = questionSet.total();

//            trigger first questionSet
            NextQuestion(random.nextInt(questionLength));
        }



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_one:
                if(btn_one.getText() == answer) CorrectAnswer(); else WrongAnswer();
                break;

            case R.id.btn_two:
                if(btn_two.getText() == answer) CorrectAnswer(); else WrongAnswer();
                break;

            case R.id.btn_three:
                if(btn_three.getText() == answer) CorrectAnswer(); else WrongAnswer();
                break;

            case R.id.btn_four:
                if(btn_four.getText() == answer) CorrectAnswer(); else WrongAnswer();
                break;
        }
    }

    private void CorrectAnswer(){
//        Toast.makeText(TestActivity.this, R.string.questions_correct_answer, Toast.LENGTH_SHORT).show();
        CorrentAnswersCounter++;

        String btnText = "Επομενη ερωτηση";
        if((QuestionCounter==QuestionSet)) btnText = "Αποτελεσματα";

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(TestActivity.this);
        alertDialogBuilder
                .setTitle("Ερώτηση "+QuestionCounter+"/"+QuestionSet)
                .setMessage(R.string.questions_correct_answer)
                .setCancelable(false)
                .setPositiveButton(btnText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if((QuestionCounter==QuestionSet)) {
                            ShowResults();
                        } else {
                            NextQuestion(random.nextInt(questionLength));
                        }
                    }
                });
        alertDialogBuilder.show();
    }
    private void WrongAnswer(){
//        Toast.makeText(TestActivity.this, R.string.questions_wrong_answer, Toast.LENGTH_SHORT).show();

        String btnText = "Επομενη ερωτηση";
        if((QuestionCounter==QuestionSet)) btnText = "Αποτελεσματα";

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(TestActivity.this);
        alertDialogBuilder
                .setTitle("Ερώτηση "+QuestionCounter+"/"+QuestionSet)
                .setMessage(R.string.questions_wrong_answer)
                .setCancelable(false)
                .setPositiveButton(btnText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(QuestionCounter==QuestionSet) {
                            ShowResults();
                        } else {
                            NextQuestion(random.nextInt(questionLength));
                        }
                    }
                });
        alertDialogBuilder.show();
    }

    private void ShowResults(){
        int result = (int) Math.round(((double) CorrentAnswersCounter/QuestionSet)*100);

        // Handle highscore
        Score score = new Score(TestActivity.this);
        int highscore = score.getChapterScore(chapterIndex);
        if(result>highscore) {
            score.setChapterScore(chapterIndex,result);

        }

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(TestActivity.this);
        alertDialogBuilder
                .setTitle("Αποτελέσματα")
                .setMessage("Η επίδοση σου είναι "+result+"%")
                .setCancelable(false)
                .setPositiveButton("Επιλογη αλλου κεφαλαιου", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
        alertDialogBuilder.show();

    }

    private void NextQuestion(int num){
//        Log.d("NextQuestion",String.valueOf(num));
//        Log.d("NextQuestion", Arrays.toString(questionSet.getQuestions()));
        tv_question.setText(questionSet.getQuestion(num));
        btn_one.setText(questionSet.getchoice1(num));
        btn_two.setText(questionSet.getchoice2(num));
        btn_three.setText(questionSet.getchoice3(num));
        btn_four.setText(questionSet.getchoice4(num));

        answer = questionSet.getCorrectAnswer(num);
        QuestionCounter++;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
