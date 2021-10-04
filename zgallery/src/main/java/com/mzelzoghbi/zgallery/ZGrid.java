package com.mzelzoghbi.zgallery;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.hiviewdfx.HiLog;

import java.io.Serializable;
import java.util.List;

/**
 * ZGrid.
 */
public class ZGrid {
    private final Ability ability;
    private final List<String> imageUrls;
    private String title;
    private int spanCount = 2;
    private int toolbarColor = -1;
    private int imgPlaceHolderResId = -1;
    private int color;

    /**
     * call ZGrid from other apps.
     *
     * @param ability   Reference from current activity
     * @param imageUrls Image URLs to be displayed
     */
    public static ZGrid with(Ability ability, List<String> imageUrls) {
        return new ZGrid(ability, imageUrls);
    }


    private ZGrid(Ability ability, List<String> imageUrls) {
        this.imageUrls = imageUrls;
        this.ability = ability;
    }

    /**
     * Set toolbar title.
     *
     * @param title title
     * @return ZGrid
     */
    public ZGrid setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Set grid layout colums count (default: 2).
     *
     * @param count integer number for colum count
     * @return ZGrid
     */
    public ZGrid setSpanCount(int count) {
        this.spanCount = count;
        return this;
    }

    /**
     * Setting toolbar Color ResourceId.
     *
     * @param colorResId res color
     * @return ZGrid
     */
    public ZGrid setToolbarColorResId(int colorResId) {
        this.toolbarColor = colorResId;
        return this;
    }

    /**
     * Set placeholder image for images in the grid.
     *
     * @param imgPlaceHolderResId placeholder
     * @return ZGrid
     */
    public ZGrid setGridImgPlaceHolder(int imgPlaceHolderResId) {
        this.imgPlaceHolderResId = imgPlaceHolderResId;
        return this;
    }

    /**
     * Setting toolbar color.
     *
     * @param color enum color may be black or white
     * @return ZGrid
     */
    public ZGrid setToolbarTitleColor(int color) {
        this.color = color;
        return this;
    }

    /**
     * Start the grid activity with builder settings.
     */
    public void show() {
        HiLog.debug(Constants.LABEL, "1st image url : " + imageUrls.get(0));
        Intent gridIntent = new Intent();
        Operation systemOperation = new Intent.OperationBuilder()
                .withAction("ability.intent.GRID_IMAGES")
                .build();
        gridIntent.setOperation(systemOperation);
        gridIntent.setParam(Constants.IntentPassingParams.IMAGES, (Serializable) imageUrls);
        gridIntent.setParam(Constants.IntentPassingParams.COUNT, spanCount);
        gridIntent.setParam(Constants.IntentPassingParams.TITLE, title);
        gridIntent.setParam(Constants.IntentPassingParams.TOOLBAR_COLOR_ID, toolbarColor);
        gridIntent.setParam(Constants.IntentPassingParams.IMG_PLACEHOLDER, imgPlaceHolderResId);
        gridIntent.setParam(Constants.IntentPassingParams.TOOLBAR_TITLE_COLOR, color);
        ability.startAbility(gridIntent);
    }
}
