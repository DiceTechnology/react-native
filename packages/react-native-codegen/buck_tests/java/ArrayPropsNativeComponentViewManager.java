package com.facebook.react.uimanager;

import android.view.ViewGroup;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.viewmanagers.ArrayPropsNativeComponentDelegate;
import com.facebook.react.viewmanagers.ArrayPropsNativeComponentInterface;

public class ArrayPropsNativeComponentViewManager extends SimpleViewManager<ViewGroup>
    implements ArrayPropsNativeComponentInterface<ViewGroup> {

  public static final String REACT_CLASS = "ArrayPropsNativeComponent";

  @Override
  public String getName() {
    return REACT_CLASS;
  }

  private void test() {
    ArrayPropsNativeComponentDelegate delegate = new ArrayPropsNativeComponentDelegate<ViewGroup>();
  }

  @Override
  public ViewGroup createViewInstance(ThemedReactContext context) {
    throw new IllegalStateException();
  }

  @Override
  public void setNames(ViewGroup view, ReadableArray value) {}

  @Override
  public void setDisableds(ViewGroup view, ReadableArray value) {}

  @Override
  public void setProgress(ViewGroup view, ReadableArray value) {}

  @Override
  public void setRadii(ViewGroup view, ReadableArray value) {}

  @Override
  public void setColors(ViewGroup view, ReadableArray value) {}

  @Override
  public void setSrcs(ViewGroup view, ReadableArray value) {}

  @Override
  public void setPoints(ViewGroup view, ReadableArray value) {}

  @Override
  public void setSizes(ViewGroup view, ReadableArray value) {}
}
