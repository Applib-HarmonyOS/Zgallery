package com.mzelzoghbi.zgallery;


import ohos.agp.components.AttrSet;
import ohos.agp.components.PageSlider;
import ohos.app.Context;

/**
 * CustomViewPager for ZGallery
 */
public class CustomViewPager extends PageSlider {
    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttrSet attrSet) {
        super(context, attrSet);
    }

    @Override
    public void setTouchEventListener(TouchEventListener listener) {
        super.setTouchEventListener(listener);
    }


}
