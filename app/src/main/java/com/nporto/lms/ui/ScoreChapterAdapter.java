package com.nporto.lms.ui;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nporto.lms.R;
import com.nporto.lms.model.Score;

import java.util.Arrays;

public class ScoreChapterAdapter extends BaseAdapter {
    private final String[] chapters;
    private final Context context;
    private Score score;
    private LayoutInflater inflater;

    public ScoreChapterAdapter(Context context, String[] chapters, Score score) {
        this.context = context;
        this.chapters = chapters;
        this.score = score;
    }

    @Override
    public int getCount() { return chapters.length; }
    @Override
    public String getItem(int pos) { return chapters[pos]; }
    @Override
    public long getItemId(int pos) { return pos; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_item_score, parent, false);

        TextView chapterView = (TextView) rowView.findViewById(R.id.chapter);
        chapterView.setText(chapters[position]);

//        Log.d("Chapter",chapters[position]);

        TextView scoreView = (TextView) rowView.findViewById(R.id.score);
        scoreView.setText(score.getChapterScore(position)+"%");


        return rowView;
    }
}