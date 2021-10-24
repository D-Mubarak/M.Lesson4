package com.example.mlesson4;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mlesson4.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.mlesson4.databinding.FragmentItemBinding;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Musics> list = new ArrayList<>();
    private Listener listener;

    public void setListener(ArrayList<Musics> list, Listener listener) {
        this.listener = listener;
        this.list = new ArrayList<>();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name, minutes, number, author;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            minutes = itemView.findViewById(R.id.minutes);
            number = itemView.findViewById(R.id.number);
            author = itemView.findViewById(R.id.author);
        }

        public void onBind(Musics musics) {
            name.setText(String.valueOf(musics.getName()));
            minutes.setText(String.valueOf(musics.getMinutes()));
            number.setText(String.valueOf(musics.getNumber()));
            author.setText(String.valueOf(musics.getAuthor()));

            itemView.setOnClickListener(v -> {
                listener.onClick(musics);
            });
        }
    }

        public interface Listener {
            void onClick(Musics musics);
        }

    }