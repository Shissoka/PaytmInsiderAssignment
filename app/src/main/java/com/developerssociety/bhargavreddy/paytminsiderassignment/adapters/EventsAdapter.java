package com.developerssociety.bhargavreddy.paytminsiderassignment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

import com.developerssociety.bhargavreddy.paytminsiderassignment.R;
import com.developerssociety.bhargavreddy.paytminsiderassignment.databinding.InflateEventsBinding;
import com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.event.EventData;
import com.developerssociety.bhargavreddy.paytminsiderassignment.utils.CommUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<BaseViewHolder> {


    private Context context;
    private final SortedList<EventData> eventDataSortedList = new SortedList<>(EventData.class, new SortedList.Callback<EventData>() {
        @Override
        public int compare(EventData o1, EventData o2) {
            return 0;
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
        public boolean areContentsTheSame(EventData oldItem, EventData newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areItemsTheSame(EventData item1, EventData item2) {
            return item1 == item2;
        }
    });

    public EventsAdapter(Context context, List<EventData> list) {
        this.context = context;
        eventDataSortedList.addAll(list);
    }



    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        InflateEventsBinding inflateEventsBinding = InflateEventsBinding.inflate(layoutInflater, parent, false);
        int width = CommUtil.getScreenWidth();
        ViewGroup.LayoutParams params = inflateEventsBinding.getRoot().getLayoutParams();
        params.width = (int) (width * 0.90);
        inflateEventsBinding.getRoot().measure(
                View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        params.height = inflateEventsBinding.getRoot().getMeasuredHeight();
        inflateEventsBinding.getRoot().setLayoutParams(params);
        return new EventsViewHolder(inflateEventsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return eventDataSortedList.size();
    }

    class EventsViewHolder extends BaseViewHolder {

        private InflateEventsBinding binding;

        public EventsViewHolder(@NonNull InflateEventsBinding inflateEventsBinding) {
            super(inflateEventsBinding.getRoot());
            this.binding = inflateEventsBinding;
        }

        @Override
        public void onBind(int pos) {

            binding.eventHeadingText.setText(eventDataSortedList.get(pos).getName());
            binding.timeText.setText(eventDataSortedList.get(pos).getVenueDateString());
            binding.venueDetails.setText(eventDataSortedList.get(pos).getVenueName());
            if (eventDataSortedList.get(pos).getMinPrice() == 0) {
                binding.minPrice.setText("FREE");
            } else {
                binding.minPrice.setText(context.getResources().getString(R.string.Rs) + " " + eventDataSortedList.get(pos).getPriceDisplayString());
            }

            Picasso.get().load(eventDataSortedList.get(pos).getHorizontalCoverImage()).fit().into(binding.eventImageID);
        }

        @Override
        public LinearLayoutManager getLayoutManager() {
            return null;
        }
    }
}
