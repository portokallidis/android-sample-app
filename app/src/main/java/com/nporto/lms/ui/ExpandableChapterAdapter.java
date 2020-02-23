package com.nporto.lms.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.nporto.lms.R;
import com.nporto.lms.ReadingActivity;
import com.nporto.lms.model.Chapter;

import java.util.ArrayList;


public class ExpandableChapterAdapter extends BaseExpandableListAdapter {

    private final ArrayList<Chapter> chapters;
    public final LayoutInflater inflater;
    public final Activity activity;
    public final Context context;


    public ExpandableChapterAdapter(Context context, Activity act, ArrayList<Chapter> chapters) {

        this.activity = act;
        this.context = context;
        this.chapters = chapters;
        inflater = act.getLayoutInflater();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return chapters.get(groupPosition).paragraphs[childPosition];
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String chapterTitle = (String)((Chapter) getGroup(groupPosition)).name;
        final String paragraphTitle = (String) getChild(groupPosition, childPosition);
        final int paragraphContentID =  chapters.get(groupPosition).contentID;

        TextView text = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.expandable_details, null);
        }
        text = (TextView) convertView.findViewById(R.id.textView1);
        text.setText(paragraphTitle);

        convertView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(activity, ReadingActivity.class);
                //based on item add info to intent
                intent.putExtra("chapter", groupPosition);
                intent.putExtra("paragraph", childPosition);
                intent.putExtra("chapterTitle", chapterTitle);
                intent.putExtra("paragraphTitle", paragraphTitle);
                intent.putExtra("paragraphContentID", paragraphContentID);
                context.startActivity(intent);

            }
        });
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return chapters.get(groupPosition).paragraphs.length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return chapters.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return chapters.size();
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.expandable_group, null);
        }
        Chapter chapter = (Chapter) getGroup(groupPosition);
        ((CheckedTextView) convertView).setText(chapter.name);
        ((CheckedTextView) convertView).setChecked(isExpanded);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}