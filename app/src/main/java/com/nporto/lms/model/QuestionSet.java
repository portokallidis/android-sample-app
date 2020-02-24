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

    public String getChoice(int a,int choice){
        return choices[a][choice];
    }
    public int totalChoices(int a){
        return choices[a].length;
    }

    public String getCorrectAnswer(int a){
        String answer = correctAnswer[a];
        return answer;
    }
}
