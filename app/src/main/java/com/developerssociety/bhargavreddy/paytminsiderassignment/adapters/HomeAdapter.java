package com.developerssociety.bhargavreddy.paytminsiderassignment.adapters;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

import com.developerssociety.bhargavreddy.paytminsiderassignment.databinding.InflateRecyclerviewBinding;
import com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.FinalHomeData;
import com.developerssociety.bhargavreddy.paytminsiderassignment.utils.Commons;

import java.util.HashMap;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private HashMap<Integer, Parcelable> scrollMap = new HashMap<>();

    private final SortedList<FinalHomeData> sortedList = new SortedList<>(FinalHomeData.class, new SortedList.Callback<FinalHomeData>() {
        @Override
        public int compare(FinalHomeData o1, FinalHomeData o2) {
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
        public boolean areContentsTheSame(FinalHomeData oldItem, FinalHomeData newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areItemsTheSame(FinalHomeData item1, FinalHomeData item2) {
            return item1 == item2;
        }
    });

    private Context context;

    public HomeAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<FinalHomeData> data) {
        sortedList.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        InflateRecyclerviewBinding inflateRecyclerviewBinding = InflateRecyclerviewBinding.inflate(layoutInflater, parent, false);
        return new HomeViewHolder(inflateRecyclerviewBinding);
    }


    @Override
    public void onViewRecycled(@NonNull BaseViewHolder holder) {
        super.onViewRecycled(holder);
        scrollMap.put(holder.getAdapterPosition(), holder.getLayoutManager().onSaveInstanceState());
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
        Parcelable parcelable = scrollMap.get(position);
        if (parcelable != null) {
            holder.getLayoutManager().onRestoreInstanceState(parcelable);
        } else {
            holder.getLayoutManager().scrollToPosition(0);
        }
    }

    @Override
    public int getItemCount() {
        return sortedList.size();
    }

    public class HomeViewHolder extends BaseViewHolder {

        private InflateRecyclerviewBinding binding;
        private LinearLayoutManager layoutManager;

        public HomeViewHolder(@NonNull InflateRecyclerviewBinding inflateRecyclerviewBinding) {
            super(inflateRecyclerviewBinding.getRoot());
            this.binding = inflateRecyclerviewBinding;
            layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        }

        @Override
        public LinearLayoutManager getLayoutManager() {
            return layoutManager;
        }

        @Override
        public void onBind(int position) {
            switch (sortedList.get(position).getLayoutId()) {
                case Commons.BANNER_LAYOUT_ID:
                    BannerAdapter bannerAdapter = new BannerAdapter(context);
                    binding.horizontalRecyclerView.setAdapter(bannerAdapter);
                    binding.horizontalRecyclerView.setLayoutManager(layoutManager);

                    binding.descriptonText.setVisibility(View.GONE);

                    if (binding.horizontalRecyclerView.getOnFlingListener() == null) {
                        PagerSnapHelper snapHelper = new PagerSnapHelper();
                        snapHelper.attachToRecyclerView(binding.horizontalRecyclerView);
                    }

                    binding.horizontalRecyclerView.setHasFixedSize(true);

                    binding.headingText.setVisibility(View.GONE);
                    bannerAdapter.setData(sortedList.get(position).getBannerList());
                    break;
                case Commons.EVENT_LAYOUT_ID:
                    EventsAdapter eventsAdapter = new EventsAdapter(context, sortedList.get(position).getEventDataList());
                    binding.horizontalRecyclerView.setLayoutManager(layoutManager);

                    binding.horizontalRecyclerView.setHasFixedSize(true);

                    binding.horizontalRecyclerView.setAdapter(eventsAdapter);

                    binding.descriptonText.setVisibility(View.GONE);
                    binding.headingText.setVisibility(View.VISIBLE);
                    binding.horizontalRecyclerView.setOnFlingListener(null);
                    binding.headingText.setText(sortedList.get(position).getText());
                    break;

            }
        }
    }
}
