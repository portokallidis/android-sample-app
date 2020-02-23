package com.nporto.lms.model;

public class Chapter {

    public String name;
    public String[] paragraphs;
    public int contentID;
    public String[] questions;
    public String[][] choices;
    public String[] correctAnswer;


    public Chapter(String na, String[] pa, int pac, String[] qu, String[][] ch, String[] co ) {
        this.name = na;
        this.paragraphs = pa;
        this.contentID = pac;
        this.questions = qu;
        this.choices = ch;
        this.correctAnswer = co;
    }

}

