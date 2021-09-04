package com.mzelzoghbi.zgallery.activities;

import com.mzelzoghbi.zgallery.Constants;
import com.mzelzoghbi.zgallery.CustomViewPager;
import com.mzelzoghbi.zgallery.OnImgClick;
import com.mzelzoghbi.zgallery.ResourceTable;
import com.mzelzoghbi.zgallery.adapters.HorizontalItemProvider;
import com.mzelzoghbi.zgallery.adapters.NewPageSliderProvider;
import com.mzelzoghbi.zgallery.entities.ZColor;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.DependentLayout;
import ohos.agp.components.ListContainer;
import ohos.agp.components.PageSlider;
import ohos.hiviewdfx.HiLog;

public class ZGalleryAbility extends BaseAbility {

    CustomViewPager mViewPager;
    NewPageSliderProvider adapter;
    ListContainer imagesHorizontalList;
    HorizontalItemProvider horizontalItemProvider;


    @Override
    protected int getResourceLayoutId() {
        return ResourceTable.Layout_z_activity_gallery;
    }

    @Override
    protected void afterInflation(Intent intent) {
        // init layouts
        DependentLayout mainLayout = (DependentLayout) findComponentById(ResourceTable.Id_mainLayout);
        mViewPager = (CustomViewPager) findComponentById(ResourceTable.Id_pager);
        imagesHorizontalList = (ListContainer) findComponentById(ResourceTable.Id_imagesHorizontalList);

        // get intent data
        int currentPos = intent.getIntParam(Constants.IntentPassingParams.SELECTED_IMG_POS, 0);
        int bgColorId =  intent.getIntParam(Constants.IntentPassingParams.BG_COLOR,0);
        ZColor bgColor = ZColor.values()[bgColorId];
//        if (bgColor == ZColor.WHITE) {
//            mainLayout.setBackground(Color.WHITE);
//        }

        // pager adapter
        HiLog.debug(Constants.LABEL,"in zgallery activity");

        adapter = new NewPageSliderProvider(this, imageURLs, imagesHorizontalList);
        mViewPager.setProvider(adapter);
        // horizontal list adapter
        horizontalItemProvider = new HorizontalItemProvider(this, imageURLs, new OnImgClick() {
            @Override
            public void onClick(int pos) {
                HiLog.debug(Constants.LABEL,"in zgallery activity set to "+pos);
                mViewPager.setCurrentPage(pos, false);
                horizontalItemProvider.notifyDataChanged();
            }
        });
        imagesHorizontalList.setOrientation(Component.HORIZONTAL);
        imagesHorizontalList.setItemProvider(horizontalItemProvider);
        horizontalItemProvider.notifyDataChanged();

        mViewPager.addPageChangedListener(new PageSlider.PageChangedListener() {
            @Override
            public void onPageSliding(int i, float v, int i1) {

            }

            @Override
            public void onPageSlideStateChanged(int i) {
//                HiLog.debug(Constants.LABEL,"page slider in zgallery activity set to "+i);
//                horizontalItemProvider.setSelectedItem(i);
//                imagesHorizontalList.scrollTo(i);
            }

            @Override
            public void onPageChosen(int i) {
                HiLog.debug(Constants.LABEL,"page slider in zgallery activity set to "+i);
                horizontalItemProvider.setSelectedItem(i);
                imagesHorizontalList.scrollTo(i);

            }
        });
        horizontalItemProvider.setSelectedItem(currentPos);
        mViewPager.setCurrentPage(currentPos);
    }

}
