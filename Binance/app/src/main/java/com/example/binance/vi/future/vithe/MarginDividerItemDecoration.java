package com.example.binance.vi.future.vithe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.binance.R;

public class MarginDividerItemDecoration extends RecyclerView.ItemDecoration {
    private int dividerHeight;
    private int margin;
    private Paint dividerPaint;

    public MarginDividerItemDecoration(Context context) {
        dividerPaint = new Paint();
        dividerPaint.setColor(ContextCompat.getColor(context, R.color.binance));
        dividerHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, context.getResources().getDisplayMetrics());
        margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, context.getResources().getDisplayMetrics());
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        if (position == RecyclerView.NO_POSITION) {
            return;
        }
        if (position == 0) {
            outRect.top = margin;
            outRect.bottom = dividerHeight;
        } else if (position == parent.getAdapter().getItemCount() - 1) {
            outRect.top = dividerHeight;
            outRect.bottom = margin;
        } else {
            outRect.top = dividerHeight;
            outRect.bottom = dividerHeight;
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft() + margin;
        int right = parent.getWidth() - parent.getPaddingRight() - margin;
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(child);
            if (position == RecyclerView.NO_POSITION) {
                continue;
            }
            if (position == 0) {
                int bottom = child.getTop();
                int top = bottom - dividerHeight;
                c.drawRect(left, top, right, bottom, dividerPaint);
            } else if (position == parent.getAdapter().getItemCount() - 1) {
                int top = child.getBottom();
                int bottom = top + dividerHeight;
                c.drawRect(left, top, right, bottom, dividerPaint);
            } else {
                int top = child.getBottom();
                int bottom = top + dividerHeight;
                c.drawRect(left, top, right, bottom, dividerPaint);
                top = child.getTop() - dividerHeight;
                bottom = child.getTop();
                c.drawRect(left, top, right, bottom, dividerPaint);
            }
        }
    }
}


