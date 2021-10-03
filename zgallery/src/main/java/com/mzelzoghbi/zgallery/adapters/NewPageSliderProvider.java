package com.mzelzoghbi.zgallery.adapters;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mzelzoghbi.zgallery.ResourceTable;
import com.mzelzoghbi.zgallery.SquarePhotoView;
import ohos.aafwk.ability.Ability;
import ohos.agp.components.*;

import java.util.ArrayList;

/**
 * NewPageSliderProvider
 */
public class NewPageSliderProvider extends PageSliderProvider {

    Ability ability;
    ArrayList<String> images;

    public  NewPageSliderProvider(Ability ability, ArrayList<String> images, ListContainer imagesHorizontalList) {
        this.ability = ability;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object createPageInContainer(ComponentContainer componentContainer, int i) {
        Component component = LayoutScatter.getInstance(ability).parse(ResourceTable.Layout_z_pager_item, null, false);
        SquarePhotoView imageView = (SquarePhotoView) component.findComponentById(ResourceTable.Id_iv);
        Glide.with(ability).load(images.get(i))
                .placeholder(ResourceTable.Graphic_progress)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(imageView);

        componentContainer.addComponent(component);

        return component;
    }

    @Override
    public void destroyPageFromContainer(ComponentContainer componentContainer, int i, Object o) {
        componentContainer.removeComponent((DependentLayout) o);
    }

    @Override
    public boolean isPageMatchToObject(Component component, Object o) {
        return component == ((DependentLayout)o);
    }
}
