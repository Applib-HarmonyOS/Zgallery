package com.mzelzoghbi.zgallery.adapters;

import com.bumptech.glide.Glide;
import com.mzelzoghbi.zgallery.Constants;
import com.mzelzoghbi.zgallery.OnImgClick;
import com.mzelzoghbi.zgallery.ResourceTable;
import ohos.aafwk.ability.Ability;
import ohos.agp.components.*;
import ohos.hiviewdfx.HiLog;

import java.util.ArrayList;

public class HorizontalItemProvider extends BaseItemProvider {

    ArrayList<String> images;
    Ability ability;
    int selectedItem = -1;
    OnImgClick imgClick;

    public HorizontalItemProvider(Ability ability, ArrayList<String> images, OnImgClick imgClick) {
        this.ability = ability;
        this.images = images;
        this.imgClick = imgClick;
    }

    @Override
    public int getCount() {
        return images == null ? 0 : images.size();
    }

    @Override
    public Object getItem(int i) {
        if (images != null && i >= 0 && i < images.size()) {
            return images.get(i);
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Component getComponent(int i, Component convertComponent, ComponentContainer componentContainer) {
        final Component cpt;
        ImageHolder imageHolder;
        HiLog.debug(Constants.LABEL, "Set image " + i + " selected image " + selectedItem);
        if (convertComponent == null) {
            cpt = LayoutScatter.getInstance(ability).parse(ResourceTable.Layout_z_item_image_horizontal, null, false);
            imageHolder = new ImageHolder(cpt);
            cpt.setTag(imageHolder);
        } else {
            cpt = convertComponent;
            imageHolder = (ImageHolder) cpt.getTag();
        }
        String imageUrl = images.get(i);
        imageHolder.image.setClickedListener(component -> {
            imgClick.onClick(i);
        });
        HiLog.debug(Constants.LABEL, "Set image " + i + " selected image");
        Glide.with(ability)
                .load(imageUrl)
                .placeholder(ResourceTable.Graphic_progress)
                .centerCrop()
                .into(imageHolder.image);
        if (selectedItem != i) {
            HiLog.debug(Constants.LABEL, "Set image " + i + " selected image " + selectedItem + "not equal");
            imageHolder.image.setAlpha(0.3f);
        } else {
            HiLog.debug(Constants.LABEL, "Set image " + i + " selected image " + selectedItem + " equal");
            imageHolder.image.setAlpha(1f);
        }
        return cpt;
    }

    public void setSelectedItem(int currentPos) {
        selectedItem = currentPos;
        notifyDataChanged();
    }

    public static class ImageHolder {
        Image image;

        ImageHolder(Component component) {
            image = (Image) component.findComponentById(ResourceTable.Id_iv);
        }
    }
}
