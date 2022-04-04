package com.example.flick.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flick.Network.PhotoName;
import com.example.flick.R;

import java.util.ArrayList;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.ViewHolder> {
    private ArrayList<PhotoName> photoNames;


    public TitleAdapter(ArrayList<PhotoName> flickResponses) {
        this.photoNames = flickResponses;
    }

    @NonNull
    @Override
    public TitleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title_activity,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PhotoName photoName = photoNames.get(position);
        holder.textView.setText(photoName.getTitle());
    }

    @Override
    public int getItemCount() {
        return photoNames.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txtItem);
        }
    }
}

