package com.example.topquiz.controler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.topquiz.R;
import com.example.topquiz.model.Question;
import com.example.topquiz.model.QuestionBank;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView gQuestionTextview;
    private Button gAnswerButton1;
    private Button gAnswerButton2;
    private Button gAnswerButton3;
    private Button gAnswerButton4;
    QuestionBank mQuestionBank = generateQuestions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        gQuestionTextview = findViewById(R.id.game_activity_textview_question);
        gAnswerButton1 = findViewById(R.id.game_activity_button_1);
        gAnswerButton2 = findViewById(R.id.game_activity_button_2);
        gAnswerButton3 = findViewById(R.id.game_activity_button_3);
        gAnswerButton4 = findViewById(R.id.game_activity_button_4);


        gAnswerButton1.setOnClickListener(this);
        gAnswerButton2.setOnClickListener(this);
        gAnswerButton3.setOnClickListener(this);
        gAnswerButton4.setOnClickListener(this);

        displayQuestion(mQuestionBank.getCurrentQuestion());

    }
    private void displayQuestion(final Question question) {
        // Set the text for the question text view and the four buttons
        gQuestionTextview.setText(question.getQuestion());
        gAnswerButton1.setText(question.getChoiceList().get(0));
        gAnswerButton2.setText(question.getChoiceList().get(1));
        gAnswerButton3.setText(question.getChoiceList().get(2));
        gAnswerButton4.setText(question.getChoiceList().get(3));


    }

    private QuestionBank generateQuestions(){

        Question question1 = new Question(
                "Who is the creator of Android?",
                Arrays.asList(
                        "Andy Rubin",
                        "Steve Wozniak",
                        "Jake Wharton",
                        "Paul Smith"
                ),
                0
        );

        Question question2 = new Question(
                "When did the first man land on the moon?",
                Arrays.asList(
                        "1958",
                        "1962",
                        "1967",
                        "1969"
                ),
                3
        );

        Question question3 = new Question(
                "What is the house number of The Simpsons?",
                Arrays.asList(
                        "42",
                        "101",
                        "666",
                        "742"
                ),
                3
        );

        return new QuestionBank(Arrays.asList(question1, question2, question3));
    }


    @Override
    public void onClick(View view) {
        int index;

        if (view == gAnswerButton1) {
            index = 0;
        } else if (view == gAnswerButton2) {
            index = 1;
        } else if (view == gAnswerButton3) {
            index = 2;
        } else if (view == gAnswerButton4) {
            index = 3;
        } else {
            throw new IllegalStateException("Unknown clicked view : " + view);
        }

        if (index == mQuestionBank.getCurrentQuestion().getAnswerIndex()){
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "incorrect!", Toast.LENGTH_SHORT).show();
        }

    }
}