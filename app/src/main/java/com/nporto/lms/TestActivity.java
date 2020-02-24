package com.nporto.lms;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.nporto.lms.data.chapters;
import com.nporto.lms.model.Chapter;
import com.nporto.lms.model.QuestionSet;
import com.nporto.lms.model.Score;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_one, btn_two, btn_three, btn_four,btn_submit;
    TextView tv_question;
    EditText answer_input;


    private int chapterIndex;
    private String chapterTitle;
    private com.nporto.lms.model.QuestionSet questionSet;

    private String answer;
    private int questionLength;

    private int QuestionSetLength = 4;
    private int[] shuffledQS = {0,0,0,0};

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



        answer_input = (EditText) findViewById(R.id.answer_input);
        btn_submit = (Button)findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(this);

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

//            prepare shuffled questions
            int index;
            for(int i=0;i<QuestionSetLength;i++){
                do{
                    index = random.nextInt(questionLength);
                } while (contains(shuffledQS,index));
                shuffledQS[i] = index;

//                index = random.nextInt(questionLength);
//                shuffledQS[i] = index;
//                while(contains(shuffledQS,index)){
//                    index = random.nextInt(questionLength);
//                    shuffledQS[i] = index;
//                }

            }

//            trigger first questionSet
            NextQuestion();
        }



    }

    private boolean contains(final int[] array, final int key) {
        for (final int i : array) {
            if (i == key) {
                return true;
            }
        }
        return false;
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

            case R.id.btn_submit:
                String ans = answer_input.getText().toString().toLowerCase();
//                Log.d("Answer",ans);
//                Log.d("CorrectAnswer",answer);
                if (ans.length()>0) {
                    if (ans.contains(answer)) {
                        CorrectAnswer();
                    } else WrongAnswer();
                }
                break;
        }
    }

    private void CorrectAnswer(){
//        Toast.makeText(TestActivity.this, R.string.questions_correct_answer, Toast.LENGTH_SHORT).show();
        CorrentAnswersCounter++;

        String btnText = "Επομενη ερωτηση";
        if((QuestionCounter==QuestionSetLength)) btnText = "Αποτελεσματα";

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(TestActivity.this);
        alertDialogBuilder
                .setTitle("Ερώτηση "+QuestionCounter+"/"+QuestionSetLength)
                .setMessage(R.string.questions_correct_answer)
                .setCancelable(false)
                .setPositiveButton(btnText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if((QuestionCounter==QuestionSetLength)) {
                            ShowResults();
                        } else {
                            NextQuestion();
                        }
                    }
                });
        alertDialogBuilder.show();
    }
    private void WrongAnswer(){
//        Toast.makeText(TestActivity.this, R.string.questions_wrong_answer, Toast.LENGTH_SHORT).show();

        String btnText = "Επομενη ερωτηση";
        if((QuestionCounter==QuestionSetLength)) btnText = "Αποτελεσματα";

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(TestActivity.this);
        alertDialogBuilder
                .setTitle("Ερώτηση "+QuestionCounter+"/"+QuestionSetLength)
                .setMessage(R.string.questions_wrong_answer)
                .setCancelable(false)
                .setPositiveButton(btnText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(QuestionCounter==QuestionSetLength) {
                            ShowResults();
                        } else {
                            NextQuestion();
                        }
                    }
                });
        alertDialogBuilder.show();
    }

    private void ShowResults(){
        int result = (int) Math.round(((double) CorrentAnswersCounter/QuestionSetLength)*100);

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

    private void NextQuestion(){
        int num = shuffledQS[QuestionCounter];

        tv_question.setText(questionSet.getQuestion(num));
        int totalChoices = questionSet.totalChoices(num);
        if(totalChoices==0) {
//            then its a free-form answer
//            hide the multiple-choice buttons
            btn_four.setVisibility(View.INVISIBLE);
            btn_three.setVisibility(View.INVISIBLE);
            btn_two.setVisibility(View.INVISIBLE);
            btn_one.setVisibility(View.INVISIBLE);

            btn_submit.setVisibility(View.VISIBLE);
            answer_input.setVisibility(View.VISIBLE);

        } else {
//            hide the free-form field
            btn_submit.setVisibility(View.INVISIBLE);
            answer_input.setVisibility(View.INVISIBLE);

            btn_four.setVisibility(View.VISIBLE);
            btn_three.setVisibility(View.VISIBLE);
            btn_two.setVisibility(View.VISIBLE);
            btn_one.setVisibility(View.VISIBLE);

//          multiple choice or true/false
            String choice;
            for (int i=0;i<totalChoices;i++){
                choice = questionSet.getChoice(num,i);
                Log.d("Test",choice);
                if(choice!=null) {
                    switch (i){
                        case 0:
                            btn_one.setText(choice);
                            break;
                        case 1:
                            btn_two.setText(choice);
                            break;
                        case 2:
                            btn_three.setText(choice);
                            break;
                        case 3:
                            btn_four.setText(choice);
                            break;

                    }

                }
            }

            if(totalChoices<4) btn_four.setVisibility(View.INVISIBLE);
            if(totalChoices<3) btn_three.setVisibility(View.INVISIBLE);
            if(totalChoices<2) {
                btn_two.setVisibility(View.INVISIBLE);
                btn_one.setVisibility(View.INVISIBLE);
            }


        }



        answer = questionSet.getCorrectAnswer(num);
        QuestionCounter++;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
