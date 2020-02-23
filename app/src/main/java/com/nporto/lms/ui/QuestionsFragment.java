package com.nporto.lms.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.nporto.lms.R;
import com.nporto.lms.TestActivity;
import com.nporto.lms.data.chapters;

public class QuestionsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_questions, container, false);

        chapters data = new chapters();

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(
                root.getContext(),
                R.layout.list_item_simple,
                data.getChapters()
        );

        final ListView listView = root.findViewById(R.id.chapters_q);

        // Set an item click listener for ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item text from ListView
                String selectedItem = (String) parent.getItemAtPosition(position);

                Intent intent = new Intent(getActivity(), TestActivity.class);
                intent.putExtra("chapter", position);
                intent.putExtra("chapterTitle", selectedItem);
                //based on item add info to intent
                startActivity(intent);
            }
        });




        listView.setAdapter(itemsAdapter);



        return root;
    }
}