package com.developerssociety.bhargavreddy.paytminsiderassignment.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class ControlledRecyclerView extends RecyclerView {

    private float lastX = 0.0f;
    private float lastY = 0.0f;
    private boolean scrolling = false;
    private RecyclerView recyclerViewGlobal;

    public ControlledRecyclerView(@NonNull Context context) {
        this(context, null);
    }

    public ControlledRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ControlledRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs,
                                  int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                scrolling = newState != RecyclerView.SCROLL_STATE_IDLE;
                recyclerViewGlobal = recyclerView;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        final LayoutManager lm = getLayoutManager();
        if (lm == null) {
            return super.onInterceptTouchEvent(e);
        }

        boolean allowScroll = true;

        switch (e.getActionMasked()) {
            case MotionEvent.ACTION_DOWN: {
                lastX = e.getX();
                lastY = e.getY();
                if (scrolling) {
                    MotionEvent newEvent = MotionEvent.obtain(e);
                    newEvent.setAction(MotionEvent.ACTION_UP);
                    recyclerViewGlobal.stopScroll();
                    return super.onInterceptTouchEvent(newEvent);
                }
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                float currentX = e.getX();
                float currentY = e.getY();
                float dx = Math.abs(currentX - lastX);
                float dy = Math.abs(currentY - lastY);
                allowScroll = dy > dx ? lm.canScrollVertically() : lm.canScrollHorizontally();
                break;
            }
        }

        if (!allowScroll) {
            return false;
        }

        return super.onInterceptTouchEvent(e);
    }

}
