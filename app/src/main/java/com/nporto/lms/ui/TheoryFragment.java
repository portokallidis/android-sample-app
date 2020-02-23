package com.nporto.lms.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.nporto.lms.R;
import com.nporto.lms.data.chapters;
import com.nporto.lms.model.Chapter;

import java.util.ArrayList;

public class TheoryFragment extends Fragment {


    chapters chapterList;
    ArrayList<Chapter> data;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_theory, container, false);

        chapterList = new chapters();
        data = chapterList.getData();
        ExpandableChapterAdapter adapter = new ExpandableChapterAdapter(getContext(),getActivity(), data);

        final ExpandableListView listView = root.findViewById(R.id.chapters_t);

        listView.setAdapter(adapter);
        return root;
    }

}