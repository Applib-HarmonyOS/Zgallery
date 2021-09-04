package com.mzelzoghbi.zgallery;

import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

public final class Constants {

    public static final HiLogLabel LABEL = new HiLogLabel(HiLog.LOG_APP, 0x00201, "MY_TAG");

    public class IntentPassingParams {
        public static final String IMAGES = "images";
        public static final String COUNT = "count";
        public static final String TOOLBAR_COLOR_ID = "toolbarColorId";
        public static final String TITLE = "title";
        public static final String IMG_PLACEHOLDER = "placeholder";
        public static final String TOOLBAR_TITLE_COLOR = "toolbarTitleColor";
        public static final String SELECTED_IMG_POS = "selectedImgPos";
        public static final String BG_COLOR = "bgColor";
    }
}
