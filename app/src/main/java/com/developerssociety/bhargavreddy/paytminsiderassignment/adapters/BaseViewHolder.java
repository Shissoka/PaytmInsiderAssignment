package com.developerssociety.bhargavreddy.paytminsiderassignment.adapters;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

abstract public class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void onBind(int position);

    public abstract LinearLayoutManager getLayoutManager();
}
