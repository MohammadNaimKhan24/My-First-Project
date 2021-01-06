package com.myportfolio.coronaquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonTrue;
    Button buttonFalse;
    TextView questionTextView;
    ImageButton nextButton;

    private int currentQuestionIndex = 0;

    Question [] questionList = new Question[] {
            new Question(R.string.COVID_19,true),
            new Question(R.string.Syntoms,true),
            new Question(R.string.SyntomeTime,false),
            new Question(R.string.CleanHands,true),
            new Question(R.string.Touch,false),
            new Question(R.string.Mask,true),
            new Question(R.string.StayHome,false),
            new Question(R.string.MedicalAttention,true),
            new Question(R.string.FoodTaste,true),
            new Question(R.string.OldSafe,false),
            new Question(R.string.Identify,false),
            new Question(R.string.Declaration,true),
            new Question(R.string.Risk,false),
            new Question(R.string.Virus,true),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonTrue = findViewById(R.id.btn_true_id);
        buttonFalse = findViewById(R.id.btn_false_id);
        questionTextView = findViewById(R.id.tv_question_id);
        nextButton = findViewById(R.id.ib_next_id);

        buttonTrue.setOnClickListener(this);
        buttonFalse.setOnClickListener(this);
        questionTextView.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_true_id:
                checkAnswer(true);
                break;

            case R.id.btn_false_id:
                checkAnswer(false);
                break;

            case R.id.ib_next_id:
                currentQuestionIndex = (currentQuestionIndex + 1) % questionList.length;
                updateQuestions();
                break;
        }
    }

    public void checkAnswer (boolean chooseCorrect) {
        boolean answerIsTrue = questionList[currentQuestionIndex].isAnswerTrue();
        int toastMessage;
        if (chooseCorrect == answerIsTrue) {
            toastMessage = R.string.correct;
        } else {
            toastMessage = R.string.wrong;
        }
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }

    public void updateQuestions () {

        questionTextView.setText(questionList[currentQuestionIndex].getAnswerResult());
    }
}