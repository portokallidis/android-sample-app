package com.nporto.lms.model;

import android.content.Context;
import android.content.SharedPreferences;

public class Score {

    SharedPreferences store;


    public Score(Context context) {
        this.store = context.getApplicationContext().getSharedPreferences("user_score", 0);
    }

    private String chapterKey(int chapterIndex){
        return "chapter_score:"+chapterIndex;
    }

    public int getChapterScore(int chapterIndex) {
        int score = store.getInt(chapterKey(chapterIndex), 0);
        return score;
    }
    public void setChapterScore(int chapterIndex, int score) {
        SharedPreferences.Editor editor = store.edit();
        editor.putInt(chapterKey(chapterIndex), score);
        editor.commit();
    }

}

