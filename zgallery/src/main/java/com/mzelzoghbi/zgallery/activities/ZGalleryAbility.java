package com.mzelzoghbi.zgallery.activities;


import com.mzelzoghbi.zgallery.Constants;
import com.mzelzoghbi.zgallery.CustomViewPager;
import com.mzelzoghbi.zgallery.ResourceTable;
import com.mzelzoghbi.zgallery.adapters.HorizontalItemProvider;
import com.mzelzoghbi.zgallery.adapters.NewPageSliderProvider;
import ohos.aafwk.content.Intent;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.Component;
import ohos.agp.components.DependentLayout;
import ohos.agp.components.ListContainer;
import ohos.agp.components.PageSlider;
import ohos.agp.components.element.ShapeElement;
import ohos.hiviewdfx.HiLog;

/**
 * ZGalleryAbility
 */
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
        mViewPager = (CustomViewPager) findComponentById(ResourceTable.Id_pager);
        imagesHorizontalList = (ListContainer) findComponentById(ResourceTable.Id_imagesHorizontalList);
        DependentLayout mainLayout = (DependentLayout) findComponentById(ResourceTable.Id_mainLayout);

        // get intent data
        int currentPos = intent.getIntParam(Constants.IntentPassingParams.SELECTED_IMG_POS, 0);
        int bgColorId = intent.getIntParam(Constants.IntentPassingParams.BG_COLOR, 0);

        ShapeElement backgroundShape = new ShapeElement();
        backgroundShape.setShape(ShapeElement.RECTANGLE);
        backgroundShape.setRgbColor(RgbColor.fromArgbInt(bgColorId));
        mainLayout.setBackground(backgroundShape);

        // pager adapter
        HiLog.debug(Constants.LABEL,"in zgallery activity");

        adapter = new NewPageSliderProvider(this, imageURLs, imagesHorizontalList);
        mViewPager.setProvider(adapter);
        // horizontal list adapter
        horizontalItemProvider = new HorizontalItemProvider(this, imageURLs, pos -> {
            HiLog.debug(Constants.LABEL,"in zgallery activity set to " + pos);
            mViewPager.setCurrentPage(pos, false);
            horizontalItemProvider.notifyDataChanged();
        });
        imagesHorizontalList.setOrientation(Component.HORIZONTAL);
        imagesHorizontalList.setItemProvider(horizontalItemProvider);
        horizontalItemProvider.notifyDataChanged();

        mViewPager.addPageChangedListener(new PageSlider.PageChangedListener() {
            @Override
            public void onPageSliding(int i, float v, int i1) {
                //Not used
            }

            @Override
            public void onPageSlideStateChanged(int i) {
                //Not used
            }

            @Override
            public void onPageChosen(int i) {
                HiLog.debug(Constants.LABEL,"page slider in zgallery activity set to " + i);
                horizontalItemProvider.setSelectedItem(i);
                imagesHorizontalList.scrollTo(i);

            }
        });
        horizontalItemProvider.setSelectedItem(currentPos);
        mViewPager.setCurrentPage(currentPos);
    }

}
