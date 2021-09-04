package com.mzelzoghbi.zgallery;

import com.github.chrisbanes.photoview.PhotoView;
import ohos.agp.components.AttrSet;
import ohos.app.Context;

public class SquarePhotoView extends PhotoView {

    public SquarePhotoView(Context context, AttrSet attrSet) {
        super(context, attrSet);
    }

    @Override
    public void estimateSize(int widthEstimatedConfig, int heightEstimatedConfig) {
        super.estimateSize(widthEstimatedConfig, heightEstimatedConfig);
        int width = getEstimatedWidth();
        setComponentSize(width, width);
    }
}
