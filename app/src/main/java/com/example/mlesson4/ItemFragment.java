package com.example.mlesson4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mlesson4.placeholder.PlaceholderContent;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ItemFragment extends Fragment implements Adapter.Listener {
    private RecyclerView recyclerView;
    private ArrayList<Musics> arrayList = new ArrayList<>();
    private Adapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_list, container, false);
    }


    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CreateList();
        initFrag(view);
    }


    private void initFrag(@NotNull View view) {
        recyclerView = view.findViewById(R.id.recycler);
        adapter = new Adapter();
        adapter.setListener(arrayList, this);
        recyclerView.setAdapter(adapter);
    }

    private void CreateList() {
        arrayList = new ArrayList<>();
        arrayList.add(new Musics("Blank Space", "3:22", "1", "Taylor Swift", 101));
        arrayList.add(new Musics("Watch Me", "5:36", "2", "Silento", 102));
        arrayList.add(new Musics("Earned it", "4:51", "3", "The Weekend", 103));
        arrayList.add(new Musics("The Hills", "3:41", "4", "The Weekend", 104));
        arrayList.add(new Musics("Перемен", "4:55", "5", "КИНО", 105));
        arrayList.add(new Musics("Stayin' Alive", "4:45", "6", "Bee Gees", 106));
        arrayList.add(new Musics("Smells Like Teen Spirit", "5:01", "7", "Nirvana", 107));
        arrayList.add(new Musics("Billie Jean", "4:53", "8", "Micheal Jackson", 108));
        arrayList.add(new Musics("San Andreas Theme Song", "1:26", "9", "Young MayLay", 109));
        arrayList.add(new Musics("Take Me To Touch", "4:01", "10", "Hozier", 110));
    }

    @Override
    public void onClick(Musics musics) {
        Intent intent = new Intent(getActivity(), MainActivity2.class);
        intent.putExtra("key", musics.getName());
        startActivity(intent);
    }
}