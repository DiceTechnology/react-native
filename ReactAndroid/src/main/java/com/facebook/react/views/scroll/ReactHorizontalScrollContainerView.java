// Copyright 2004-present Facebook. All Rights Reserved.

package com.facebook.react.views.scroll;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import com.facebook.react.modules.i18nmanager.I18nUtil;

/** Container of Horizontal scrollViews that supports RTL scrolling. */
public class ReactHorizontalScrollContainerView extends ViewGroup {

  public interface Listener {
    void onLayout();
  }

  private int mLayoutDirection;
  private int mLastWidth = 0;
  private Listener rtlListener = null;

  public ReactHorizontalScrollContainerView(Context context) {
    super(context);
    mLayoutDirection =
        I18nUtil.getInstance().isRTL(context) ? LAYOUT_DIRECTION_RTL : LAYOUT_DIRECTION_LTR;
  }

  @Override
  protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
    final HorizontalScrollView parent = (HorizontalScrollView) getParent();
    parent.setClipChildren(false);
    this.setClipChildren(false);

    if (mLayoutDirection == LAYOUT_DIRECTION_RTL) {
      // When the layout direction is RTL, we expect Yoga to give us a layout
      // that extends off the screen to the left so we re-center it with left=0
      int newLeft = 0;
      int width = right - left;
      int newRight = newLeft + width;
      setLeft(newLeft);
      setRight(newRight);

      // Fix the ScrollX position when using RTL language accounting for the case when new
      // data is appended to the "end" (left) of the view (e.g. after fetching additional items)
      final int offsetX = this.getMeasuredWidth() - mLastWidth + parent.getScrollX();

      // Call with the present values in order to re-layout if necessary
      parent.scrollTo(offsetX, parent.getScrollY());
      mLastWidth = this.getMeasuredWidth();

      // Use the listener to adjust the scrollposition if new data was appended
      if (rtlListener != null) {
        rtlListener.onLayout();
      }
    }
  }

  public int getLastWidth() {
    return mLastWidth;
  }

  public void setListener(Listener rtlListener) {
    this.rtlListener = rtlListener;
  }
}
