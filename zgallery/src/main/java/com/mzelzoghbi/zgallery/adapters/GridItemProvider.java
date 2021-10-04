package com.mzelzoghbi.zgallery.adapters;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mzelzoghbi.zgallery.Constants;
import com.mzelzoghbi.zgallery.ResourceTable;
import com.mzelzoghbi.zgallery.adapters.listeners.GridClickListener;
import ohos.aafwk.ability.Ability;
import ohos.agp.components.*;
import ohos.agp.utils.LayoutAlignment;
import ohos.hiviewdfx.HiLog;
import java.util.ArrayList;

/**
 * GridItemProvider.
 */
public class GridItemProvider extends BaseItemProvider {

    private final ArrayList<String> imageUrls;
    private final Ability ability;
    private final int imgPlaceHolderResId;
    private final GridClickListener clickListener;
    private int numColumns;

    /**
     * GridItemProvider Constructor.
     */
    public GridItemProvider(Ability ability, ArrayList<String> imageUrls, int imgPlaceHolderResId) {
        HiLog.debug(Constants.LABEL, "in griditemprovider constructor");
        this.imageUrls = imageUrls;
        this.ability = ability;
        this.imgPlaceHolderResId = imgPlaceHolderResId;
        this.clickListener = (GridClickListener) ability;
    }

    /**
     * set number of columns for grid.
     * @param numColumns number of columns
     *
     */
    public void setNumColumns(int numColumns) {
        this.numColumns = numColumns;
    }

    @Override
    public int getCount() {
        if (imageUrls != null) {
            return imageUrls.size() % numColumns == 0
                    ? imageUrls.size() / numColumns : imageUrls.size() / numColumns + 1;
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int i) {
        HiLog.debug(Constants.LABEL, "get Item " + i);

        if (imageUrls != null && i >= 0 && i < imageUrls.size()) {
            return imageUrls.get(i);
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Component getComponent(int position, Component comp, ComponentContainer componentContainer) {
        ViewHolder viewHolder;
        DirectionalLayout convertComponent = new DirectionalLayout(ability);
        convertComponent.setOrientation(Component.HORIZONTAL);
        ComponentContainer.LayoutConfig layoutConfig = convertComponent.getLayoutConfig();
        layoutConfig.width = DependentLayout.LayoutConfig.MATCH_PARENT;
        layoutConfig.height = DependentLayout.LayoutConfig.MATCH_CONTENT;
        convertComponent.setLayoutConfig(layoutConfig);
        for (int i = 0; i < numColumns; i++) {
            if (position * numColumns + i < imageUrls.size()) {
                DirectionalLayout dlItemParent = new DirectionalLayout(ability);
                dlItemParent.setLayoutConfig(new DirectionalLayout
                        .LayoutConfig(0,
                        DirectionalLayout.LayoutConfig.MATCH_CONTENT,
                        LayoutAlignment.TOP,
                        1));
                Component childConvertComponent = LayoutScatter
                        .getInstance(ability)
                        .parse(ResourceTable.Layout_z_item_image, null, false);
                int finalI = i;
                childConvertComponent.setClickedListener(component -> {
                    if (clickListener != null) {
                        clickListener.onClick(finalI);
                    }
                });
                dlItemParent.addComponent(childConvertComponent);
                convertComponent.addComponent(dlItemParent);
                viewHolder = new ViewHolder(childConvertComponent);
                String imageUrl = getItem(position * numColumns + i).toString();
                HiLog.debug(Constants.LABEL, "image " + imageUrl);
                Glide.with(ability).load(imageUrl)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true)
                        .centerCrop()
                        .placeholder(imgPlaceHolderResId != -1
                                ? imgPlaceHolderResId : ResourceTable.Graphic_progress)
                        .into(viewHolder.image);
            } else {
                DirectionalLayout childConvertComponent = new DirectionalLayout(ability);
                childConvertComponent.setLayoutConfig(new DirectionalLayout
                        .LayoutConfig(0,
                        DirectionalLayout.LayoutConfig.MATCH_CONTENT,
                        LayoutAlignment.TOP,
                        1));
                convertComponent.addComponent(childConvertComponent);
            }
        }
        return convertComponent;
    }

    /**
     * ViewHolder.
     */
    protected static class ViewHolder {
        Component itemView;
        Image image;

        ViewHolder(Component component) {
            this.itemView = component;
            image = (Image) component.findComponentById(ResourceTable.Id_imageView);
        }
    }
}
