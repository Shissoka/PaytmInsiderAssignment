package com.developerssociety.bhargavreddy.paytminsiderassignment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.developerssociety.bhargavreddy.paytminsiderassignment.databinding.InflateGridBinding;
import com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.DigitalEventGroupObject;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DigitalAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private Context mContext;

   private List<DigitalEventGroupObject> digitalEventGroupObjectList;

    public DigitalAdapter(Context context, List<DigitalEventGroupObject> list) {
        this.digitalEventGroupObjectList=list;
        this.mContext=context;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
        InflateGridBinding inflateGridBinding=InflateGridBinding.inflate(layoutInflater,parent,false);
        return new DigitalViewHolder(inflateGridBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if(digitalEventGroupObjectList==null)
            return 0;
        return digitalEventGroupObjectList.size();
    }

    public class DigitalViewHolder extends BaseViewHolder{

        private InflateGridBinding binding;
        public DigitalViewHolder(@NonNull InflateGridBinding inflateGridBinding) {
            super(inflateGridBinding.getRoot());
            this.binding=inflateGridBinding;

        }

        @Override
        public void onBind(int pos) {
            Picasso.get().load(digitalEventGroupObjectList.get(pos).getThumbnailUrl()).fit().into(binding.image);
        }

        @Override
        public LinearLayoutManager getLayoutManager() {
            return null;
        }
    }


}