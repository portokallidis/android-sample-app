package com.nporto.lms.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.nporto.lms.R;
import com.nporto.lms.data.chapters;
import com.nporto.lms.model.Score;

public class ScoreFragment extends Fragment {


/* With ScoreChapterAdapter */

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_score, container, false);

        Score score = new Score(root.getContext());

        chapters data = new chapters();
        String[] ch = data.getChapters();
        ScoreChapterAdapter itemsAdapter = new ScoreChapterAdapter(root.getContext(), ch, score);

        final ListView listView = (ListView) root.findViewById(R.id.chapters_score);


        listView.setAdapter(itemsAdapter);

        return root;
    }


}
