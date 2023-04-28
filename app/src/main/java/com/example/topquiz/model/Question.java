package com.example.topquiz.model;

import java.util.List;

public class Question {

    public Question(String question, List<String> choiceList, int answerIndex) {
        mQuestion = question;
        mChoiceList = choiceList;
        mAnswerIndex = answerIndex;
    }

    private final String mQuestion;
    private final List<String> mChoiceList;
    private final int mAnswerIndex;

    /******** Getters ********/

    public String getQuestion() {return mQuestion;}
    public List<String> getChoiceList() {return mChoiceList;}
    public int getAnswerIndex() {
        return mAnswerIndex;
    }


}
