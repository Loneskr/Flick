package com.example.flick.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flick.Network.PhotoNameResponse;
import com.example.flick.R;

import java.util.ArrayList;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.ViewHolder> {
    private ArrayList<PhotoNameResponse> photoNames;


    public TitleAdapter(ArrayList<PhotoNameResponse> photoTitleName) {
        this.photoNames = photoTitleName;
    }

    @NonNull
    @Override
    public TitleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title_activity,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PhotoNameResponse photoName = photoNames.get(position);
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

