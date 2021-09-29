package com.mzelzoghbi.zgallery.activities;

import com.mzelzoghbi.zgallery.Constants;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.hiviewdfx.HiLog;

import java.util.ArrayList;

public abstract class BaseAbility extends Ability {

    protected ArrayList<String> imageURLs;
    protected int toolbarTitleColorId;
    protected int toolbarColorResId;
    protected String title;

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(getResourceLayoutId());

        imageURLs = intent.getStringArrayListParam(Constants.IntentPassingParams.IMAGES);
        toolbarColorResId = intent.getIntParam(Constants.IntentPassingParams.TOOLBAR_COLOR_ID, -1);
        title = intent.getStringParam(Constants.IntentPassingParams.TITLE);
        toolbarTitleColorId = intent.getIntParam(Constants.IntentPassingParams.TOOLBAR_TITLE_COLOR, 0);
        HiLog.debug(Constants.LABEL,"In Base : 1st image url : "+imageURLs.get(0));

        afterInflation(intent);
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);

    }

    protected abstract int getResourceLayoutId();

    protected abstract void afterInflation(Intent intent);
}
