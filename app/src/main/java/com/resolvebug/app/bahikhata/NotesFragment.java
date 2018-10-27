package com.resolvebug.app.bahikhata;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotesFragment extends Fragment {

    private RecyclerView recyclerView;
    private NotesRecyclerViewAdapter notesRecyclerViewAdapter;
    List<CardItems> cardItemsList;
    private DatabaseReference databaseReference;

    public NotesFragment() {

    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cardItemsList = new ArrayList<>();
        recyclerView = getView().findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getView().getContext()));

        cardItemsList.add(new CardItems("60000", "Hello 1"));
        cardItemsList.add(new CardItems("60000", "Hello 1"));
        cardItemsList.add(new CardItems("60000", "Hello last"));

        notesRecyclerViewAdapter = new NotesRecyclerViewAdapter(getView().getContext(), cardItemsList);
        recyclerView.setAdapter(notesRecyclerViewAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

}