package com.platzi.sezzh.thefm.ui;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.IntegerRes;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by sezzh on 15/03/2016.
 */
public class ItemOffsetDecoration extends RecyclerView.ItemDecoration {
  // size in pixels for space between objects
  private int mItemOffset;
  private Context context;

  public ItemOffsetDecoration(Context context, @IntegerRes int integerRId) {
    int itemOffsetDp = context.getResources().getInteger(integerRId);
    this.mItemOffset = this.convertToPixels(
        itemOffsetDp, context.getResources().getDisplayMetrics()
    );
  }

  @Override
  public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                             RecyclerView.State state) {
    super.getItemOffsets(outRect, view, parent, state);
    outRect.set(
        this.mItemOffset, this.mItemOffset, this.mItemOffset, this.mItemOffset
    );
  }

  private int convertToPixels(int offsetDp, DisplayMetrics metrics) {
    int result = offsetDp * (metrics.densityDpi / 160);
    return result;
  }
}
