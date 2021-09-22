package com.mzelzoghbi.zgallery;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.hiviewdfx.HiLog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ZGallery {
    private Ability mAbility;
    private List<String> imagesURLs;
    private String title;
    private int toolbarColor = -1;
    private int color = -1;
    private int selectedImgPosition;
    private int backgroundColor = -1;

    private ZGallery() {
    }

    public static ZGallery with(Ability ability, List<String> imagesURLs) {
        return new ZGallery(ability, imagesURLs);
    }


    private ZGallery(Ability ability, List<String> imagesURLs) {
        this.imagesURLs = imagesURLs;
        this.mAbility = ability;
    }

    /**
     * Set z_toolbar title
     *
     * @param title
     * @return
     */
    public ZGallery setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Setting z_toolbar Color ResourceId
     *
     * @param colorResId
     * @return
     */
    public ZGallery setToolbarColorResId(int colorResId) {
        this.toolbarColor = colorResId;
        return this;
    }

    /**
     * Setting z_toolbar color
     *
     * @param color enum color may be black or white
     * @return
     */
    public ZGallery setToolbarTitleColor(int color) {
        this.color = color;
        return this;
    }


    /**
     * Setting starting position
     *
     * @param selectedImgPosition
     * @return
     */
    public ZGallery setSelectedImgPosition(int selectedImgPosition) {
        this.selectedImgPosition = selectedImgPosition;
        return this;
    }

    public ZGallery setGalleryBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * Start the gallery Ability with builder settings
     */
    public void show() {
        HiLog.debug(Constants.LABEL,"1st image url : "+imagesURLs.get(0));
        Intent galleryIntent = new Intent();
        Operation systemOperation = new Intent.OperationBuilder()
                .withAction("ability.intent.GALLERY_IMAGES")
                .build();
        galleryIntent.setOperation(systemOperation);
        galleryIntent.setParam(Constants.IntentPassingParams.IMAGES, (Serializable) imagesURLs);
        galleryIntent.setParam(Constants.IntentPassingParams.TITLE, title);
        galleryIntent.setParam(Constants.IntentPassingParams.TOOLBAR_COLOR_ID, toolbarColor);
        galleryIntent.setParam(Constants.IntentPassingParams.TOOLBAR_TITLE_COLOR, color);
        galleryIntent.setParam(Constants.IntentPassingParams.SELECTED_IMG_POS, selectedImgPosition);
        galleryIntent.setParam(Constants.IntentPassingParams.BG_COLOR, backgroundColor);
        mAbility.startAbility(galleryIntent);
    }
}
