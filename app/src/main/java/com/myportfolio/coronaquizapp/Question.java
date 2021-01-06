package com.myportfolio.coronaquizapp;

public class Question {
    private int answerResult;
    private boolean answerTrue;


    public Question(int answerResult, boolean answerTrue) {
        this.answerResult = answerResult;
        this.answerTrue = answerTrue;
    }

    public int getAnswerResult() {
        return answerResult;
    }

    public void setAnswerResult(int answerResult) {
        this.answerResult = answerResult;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }
}
