package com.nporto.lms.model;


public class QuestionSet {

    private String[] questions;
    private String[][] choices;
    private String[] correctAnswer;

    public QuestionSet(Chapter ch){
        this.questions = ch.questions;
        this.choices = ch.choices;
        this.correctAnswer = ch.correctAnswer;

    }

    public int total(){
        return questions.length;
    }
    public String[] getQuestions(){
        return questions;
    }

    public String getQuestion(int a){
        String question = questions[a];
        return question;
    }

    public String getchoice1(int a){
        String choice = choices[a][0];
        return choice;
    }

    public String getchoice2(int a){
        String choice = choices[a][1];
        return choice;
    }

    public String getchoice3(int a){
        String choice = choices[a][2];
        return choice;
    }

    public String getchoice4(int a){
        String choice = choices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = correctAnswer[a];
        return answer;
    }
}
