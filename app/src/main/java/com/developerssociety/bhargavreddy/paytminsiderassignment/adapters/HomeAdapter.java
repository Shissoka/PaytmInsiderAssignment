package com.developerssociety.bhargavreddy.paytminsiderassignment.adapters;

import android.content.Context;
import android.os.Parcelable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
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
    private static int VIEW_NORMAL = 1;

    private static int VIEW_SPACING = 2;

    private static int MARGIN_SIZE = 14;

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
        if (sortedList.size() == 0) {
            sortedList.addAll(data);
        } else {
            sortedList.clear();
            sortedList.addAll(data);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        if (viewType == VIEW_NORMAL) {
            InflateRecyclerviewBinding inflateRecyclerviewBinding = InflateRecyclerviewBinding.inflate(layoutInflater, parent, false);
            return new HomeViewHolder(inflateRecyclerviewBinding);
        } else {
            InflateRecyclerviewBinding inflateRecyclerviewBinding = InflateRecyclerviewBinding.inflate(layoutInflater, parent, false);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) inflateRecyclerviewBinding.horizontalRecyclerView.getLayoutParams();
            marginLayoutParams.leftMargin = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    MARGIN_SIZE,
                    context.getResources().getDisplayMetrics()
            );
            marginLayoutParams.rightMargin = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    MARGIN_SIZE,
                    context.getResources().getDisplayMetrics()
            );
            inflateRecyclerviewBinding.horizontalRecyclerView.setLayoutParams(marginLayoutParams);
            return new HomeViewHolder(inflateRecyclerviewBinding);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (sortedList.get(position).getLayoutId() == Commons.DIGITAL_EVENT_LAYOUT_ID) {
            return VIEW_SPACING;
        } else {
            return VIEW_NORMAL;
        }
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

        public HomeViewHolder(@NonNull InflateRecyclerviewBinding inflateRecyclerviewBinding) {
            super(inflateRecyclerviewBinding.getRoot());
            this.binding = inflateRecyclerviewBinding;
        }

        @Override
        public RecyclerView.LayoutManager getLayoutManager() {
            return binding.horizontalRecyclerView.getLayoutManager();
        }

        @Override
        public void onBind(int position) {
            switch (sortedList.get(position).getLayoutId()) {
                case Commons.BANNER_LAYOUT_ID:
                    binding.descriptonText.setVisibility(View.GONE);
                    binding.headingText.setVisibility(View.GONE);

                    BannerAdapter bannerAdapter = new BannerAdapter(context);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
                    binding.horizontalRecyclerView.setLayoutManager(linearLayoutManager);
                    binding.horizontalRecyclerView.setAdapter(bannerAdapter);
                    binding.horizontalRecyclerView.setHasFixedSize(true);
                    if (binding.horizontalRecyclerView.getOnFlingListener() == null) {
                        PagerSnapHelper snapHelper = new PagerSnapHelper();
                        snapHelper.attachToRecyclerView(binding.horizontalRecyclerView);
                    }

                    bannerAdapter.setData(sortedList.get(position).getBannerList());
                    break;
                case Commons.EVENT_LAYOUT_ID:
                    binding.descriptonText.setVisibility(View.GONE);
                    binding.headingText.setVisibility(View.VISIBLE);
                    binding.headingText.setText(sortedList.get(position).getText());

                    EventsAdapter eventsAdapter = new EventsAdapter(context, sortedList.get(position).getEventDataList());
                    LinearLayoutManager linearLayoutManagerEvent = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
                    binding.horizontalRecyclerView.setLayoutManager(linearLayoutManagerEvent);
                    binding.horizontalRecyclerView.setAdapter(eventsAdapter);
                    binding.horizontalRecyclerView.setHasFixedSize(true);

                    binding.horizontalRecyclerView.setOnFlingListener(null);
                    break;
                case Commons.DIGITAL_EVENT_LAYOUT_ID:
                    binding.descriptonText.setVisibility(View.VISIBLE);
                    binding.headingText.setVisibility(View.VISIBLE);
                    binding.descriptonText.setText(sortedList.get(position).getDescription());
                    binding.headingText.setText(sortedList.get(position).getText());

                    DigitalAdapter digitalAdapter = new DigitalAdapter(context, sortedList.get(position).getDigitalEventGroupObjectList());
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
                    binding.horizontalRecyclerView.setLayoutManager(gridLayoutManager);
                    binding.horizontalRecyclerView.setHasFixedSize(true);
                    binding.horizontalRecyclerView.setAdapter(digitalAdapter);

                    binding.horizontalRecyclerView.setOnFlingListener(null);
                    break;

            }
        }
    }
}
