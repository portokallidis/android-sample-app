package com.nporto.lms.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.nporto.lms.R;
import com.nporto.lms.TestActivity;
import com.nporto.lms.data.chapters;
import com.nporto.lms.model.Score;

public class ScoreFragment extends Fragment {


/* With ScoreChapterAdapter */

    private View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_score, container, false);

        Score score = new Score(root.getContext());

        chapters data = new chapters();
        String[] ch = data.getChapters();
        final ScoreChapterAdapter itemsAdapter = new ScoreChapterAdapter(root.getContext(), ch, score);

        final ListView listView = (ListView) root.findViewById(R.id.chapters_score);

        // Set an item click listener for ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                // Get the selected item text from ListView
                String selectedChapter = (String) parent.getItemAtPosition(position);


                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(root.getContext());
                final AlertDialog.Builder builder = alertDialogBuilder
                        .setTitle("Επαναφορα High Score")
                        .setMessage("Θελετε να διαγράψετε το high score για το κεφάλαιο \n<< " + selectedChapter + " >>;")
                        .setCancelable(false)
                        .setPositiveButton("Διαγραφή score", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Handle highscore
                                Score score = new Score(root.getContext());
                                score.setChapterScore(position,0);

                                // refresh data on custom list view adapter
                                itemsAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("Ακυρο", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which){
                                // do nothing
                            }
                        });
                alertDialogBuilder.show();
            }
        });


        listView.setAdapter(itemsAdapter);



        return root;
    }


}
