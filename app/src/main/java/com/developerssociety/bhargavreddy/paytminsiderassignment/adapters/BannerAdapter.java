package com.developerssociety.bhargavreddy.paytminsiderassignment.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

import com.developerssociety.bhargavreddy.paytminsiderassignment.databinding.InflateBannersBinding;
import com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.Banner;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private Context mContext;

    private final SortedList<Banner> sortedBannerList = new SortedList<>(Banner.class, new SortedList.Callback<Banner>() {
        @Override
        public int compare(Banner o1, Banner o2) {
            return o2.getPriority() - o1.getPriority();

        }

        @Override
        public void onInserted(int position, int count) {
            notifyItemRangeInserted(position, count);
        }

        @Override
        public void onRemoved(int position, int count) {
            notifyItemRangeRemoved(position, count);
        }

        @Override
        public void onMoved(int fromPosition, int toPosition) {
            notifyItemMoved(fromPosition, toPosition);
        }

        @Override
        public void onChanged(int position, int count) {
            notifyItemRangeChanged(position, count);
        }

        @Override
        public boolean areContentsTheSame(Banner oldItem, Banner newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areItemsTheSame(Banner item1, Banner item2) {
            return item1 == item2;
        }
    });

    public BannerAdapter(Context context) {
        this.mContext=context;
    }
    public void setData(List<Banner> list){
        sortedBannerList.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
        InflateBannersBinding inflateBannersBinding=InflateBannersBinding.inflate(layoutInflater,parent,false);
        return new BannerViewHolder(inflateBannersBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return sortedBannerList.size();
    }

    public class BannerViewHolder extends BaseViewHolder{

        private InflateBannersBinding binding;
        public BannerViewHolder(@NonNull InflateBannersBinding inflateBannersBinding) {
            super(inflateBannersBinding.getRoot());
            this.binding=inflateBannersBinding;

        }

        @Override
        public void onBind(int pos) {
            Log.e("pos",sortedBannerList.get(pos).getVerticalCoverImage());
            Log.e("chck",sortedBannerList.get(pos).getPriority()+" ");
            Picasso.get().load(sortedBannerList.get(pos).getVerticalCoverImage()).fit().into(binding.banner);
        }
    }


}
