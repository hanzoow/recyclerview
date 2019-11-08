package com.example.recycleview.adapter.ViewHolder;

import android.view.View;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.R;

public class ViewHolderLoading extends RecyclerView.ViewHolder {
    public ProgressBar progressBar;

    public ViewHolderLoading(View view) {
        super(view);
//        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
    }
}
