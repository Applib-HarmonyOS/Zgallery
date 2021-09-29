package com.mzelzoghbi.zgallery.activities;

import com.mzelzoghbi.zgallery.Constants;
import com.mzelzoghbi.zgallery.ResourceTable;
import com.mzelzoghbi.zgallery.ZGallery;
import com.mzelzoghbi.zgallery.adapters.GridItemProvider;
import com.mzelzoghbi.zgallery.adapters.listeners.GridClickListener;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.DirectionalLayoutManager;
import ohos.agp.components.ListContainer;
import ohos.hiviewdfx.HiLog;

public final class ZGridAbility extends BaseAbility implements GridClickListener {

    private int spanCount = 2;

    @Override
    protected int getResourceLayoutId() {
        return ResourceTable.Layout_z_activity_grid;
    }

    @Override
    protected void afterInflation(Intent intent) {
        ListContainer mRecyclerView = (ListContainer) findComponentById(ResourceTable.Id_recyclerView);

        // get extra values
        int imgPlaceHolderResId = intent.getIntParam(Constants.IntentPassingParams.IMG_PLACEHOLDER, -1);
        spanCount = intent.getIntParam(Constants.IntentPassingParams.COUNT, spanCount);
        HiLog.debug(Constants.LABEL,"in zgrid activity");
        mRecyclerView.setOrientation(Component.VERTICAL);
        mRecyclerView.setLayoutManager(new DirectionalLayoutManager());
        GridItemProvider gridItemProvider = new GridItemProvider(this, imageURLs, imgPlaceHolderResId);
        gridItemProvider.setNumColumns(2);
        mRecyclerView.setItemProvider(gridItemProvider);
    }


    @Override
    public void onClick(int pos) {
        ZGallery.with(this, imageURLs)
                .setToolbarTitleColor(toolbarTitleColorId)
                .setToolbarColorResId(toolbarColorResId)
                .setSelectedImgPosition(pos)
                .setTitle(title)
                .show();
    }
}
