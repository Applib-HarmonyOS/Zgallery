package com.mzelzoghbi.zgallery;

import ohos.aafwk.ability.Ability;
import java.util.ArrayList;
import com.mzelzoghbi.zgallery.entities.ZColor;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.hiviewdfx.HiLog;

public class ZGrid {
    private Ability ability;
    private ArrayList<String> imagesURLs;
    private String title;
    private int spanCount = 2;
    private int toolbarColor = -1;
    private int imgPlaceHolderResId = -1;
    private int color;

    private ZGrid() {
    }

    /**
     * @param ability   Reference from current activity
     * @param imagesURLs Image URLs to be displayed
     */
    public static ZGrid with(Ability ability, ArrayList<String> imagesURLs) {
        return new ZGrid(ability, imagesURLs);
    }


    private ZGrid(Ability ability, ArrayList<String> imagesURLs) {
        this.imagesURLs = imagesURLs;
        this.ability = ability;
    }

    /**
     * Set toolbar title
     *
     * @param title
     * @return
     */
    public ZGrid setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Set grid layout colums count (default: 2)
     *
     * @param count integer number for colum count
     * @return
     */
    public ZGrid setSpanCount(int count) {
        this.spanCount = count;
        return this;
    }

    /**
     * Setting toolbar Color ResourceId
     *
     * @param colorResId
     * @return
     */
    public ZGrid setToolbarColorResId(int colorResId) {
        this.toolbarColor = colorResId;
        return this;
    }

    /**
     * Set placeholder image for images in the grid
     * @param imgPlaceHolderResId
     * @return
     */
    public ZGrid setGridImgPlaceHolder(int imgPlaceHolderResId) {
        this.imgPlaceHolderResId = imgPlaceHolderResId;
        return this;
    }

    /**
     * Setting toolbar color
     *
     * @param color enum color may be black or white
     * @return
     */
    public ZGrid setToolbarTitleColor(int color) {
        this.color = color;
        return this;
    }
    /**
     * Start the grid activity with builder settings
     */
    public void show() {
        HiLog.debug(Constants.LABEL,"1st image url : "+imagesURLs.get(0));
        Intent gridIntent = new Intent();
        Operation systemOperation = new Intent.OperationBuilder()
                .withAction("ability.intent.GRID_IMAGES")
                .build();
        gridIntent.setOperation(systemOperation);
        gridIntent.setStringArrayListParam(Constants.IntentPassingParams.IMAGES, imagesURLs);
        gridIntent.setParam(Constants.IntentPassingParams.COUNT, spanCount);
        gridIntent.setParam(Constants.IntentPassingParams.TITLE, title);
        gridIntent.setParam(Constants.IntentPassingParams.TOOLBAR_COLOR_ID, toolbarColor);
        gridIntent.setParam(Constants.IntentPassingParams.IMG_PLACEHOLDER, imgPlaceHolderResId);
        gridIntent.setParam(Constants.IntentPassingParams.TOOLBAR_TITLE_COLOR, color);
        ability.startAbility(gridIntent);
        ;
    }
}
