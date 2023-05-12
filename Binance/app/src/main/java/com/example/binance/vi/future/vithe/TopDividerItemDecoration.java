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
public class TopDividerItemDecoration extends RecyclerView.ItemDecoration {
    private int dividerHeight;
    private Paint dividerPaint;

    public TopDividerItemDecoration(Context context) {
        dividerPaint = new Paint();
        dividerPaint.setColor(ContextCompat.getColor(context, R.color.binance));
        dividerHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, context.getResources().getDisplayMetrics());
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = dividerHeight;
        } else {
            outRect.top = 0;
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            if (parent.getChildAdapterPosition(child) == 0) {
                int top = child.getTop() - dividerHeight;
                int bottom = child.getTop();
                c.drawRect(left, top, right, bottom, dividerPaint);
            }
        }
    }
}
