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
import java.util.HashMap;

public class GridItemProvider extends BaseItemProvider {

    private ArrayList<String> imageURLs;
    private Ability mAbility;
    private int imgPlaceHolderResId = -1;
    private GridClickListener clickListener;
    private int numColumns;

    public GridItemProvider(Ability mAbility, ArrayList<String> imageURLs, int imgPlaceHolderResId) {
        HiLog.debug(Constants.LABEL, "in griditemprovider constructor");
        this.imageURLs = imageURLs;
        this.mAbility = mAbility;
        this.imgPlaceHolderResId = imgPlaceHolderResId;
        this.clickListener = (GridClickListener) mAbility;
    }

    public void setNumColumns(int numColumns) {
        this.numColumns = numColumns;
    }

    @Override
    public int getCount() {
        if (imageURLs != null) {
            return imageURLs.size() % numColumns == 0 ? imageURLs.size() / numColumns : imageURLs.size() / numColumns + 1;
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int i) {
        HiLog.debug(Constants.LABEL, "get Item " + i);

        if (imageURLs != null && i >= 0 && i < imageURLs.size()) {
            return imageURLs.get(i);
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Component getComponent(int position, Component convertComponent, ComponentContainer componentContainer) {
        ViewHolder viewHolder;
        convertComponent = new DirectionalLayout(mAbility);
        ((DirectionalLayout) convertComponent).setOrientation(Component.HORIZONTAL);
        ComponentContainer.LayoutConfig layoutConfig = convertComponent.getLayoutConfig();
        layoutConfig.width = DependentLayout.LayoutConfig.MATCH_PARENT;
        layoutConfig.height = DependentLayout.LayoutConfig.MATCH_CONTENT;
        convertComponent.setLayoutConfig(layoutConfig);
        for (int i = 0; i < numColumns; i++) {
            if (position * numColumns + i < imageURLs.size()) {
                DirectionalLayout dlItemParent = new DirectionalLayout(mAbility);
                dlItemParent.setLayoutConfig(new DirectionalLayout.LayoutConfig(0, DirectionalLayout.LayoutConfig.MATCH_CONTENT, LayoutAlignment.TOP, 1));
                Component childConvertComponent = LayoutScatter.getInstance(mAbility).parse(ResourceTable.Layout_z_item_image, null, false);
                int finalI = i;
                childConvertComponent.setClickedListener(component -> {
                    if (clickListener != null) {
                        clickListener.onClick(finalI);
                    }
                });
                dlItemParent.addComponent(childConvertComponent);
                ((ComponentContainer) convertComponent).addComponent(dlItemParent);
                viewHolder = new ViewHolder(childConvertComponent);
                String imageUrl = getItem(position * numColumns + i).toString();
                HiLog.debug(Constants.LABEL, "image " + imageUrl);
                Glide.with(mAbility).load(imageUrl)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true)
                        .centerCrop()
                        .placeholder(imgPlaceHolderResId != -1 ? imgPlaceHolderResId : ResourceTable.Graphic_progress)
                        .into(viewHolder.image);
            } else {
                DirectionalLayout childConvertComponent = new DirectionalLayout(mAbility);
                childConvertComponent.setLayoutConfig(new DirectionalLayout.LayoutConfig(0, DirectionalLayout.LayoutConfig.MATCH_CONTENT, LayoutAlignment.TOP, 1));
                ((ComponentContainer) convertComponent).addComponent(childConvertComponent);
            }
        }
        return convertComponent;
    }

    protected static class ViewHolder {
        HashMap<Integer, Component> mViews = new HashMap<>();
        Component itemView;
        Image image;

        ViewHolder(Component component) {
            this.itemView = component;
            image = (Image) component.findComponentById(ResourceTable.Id_imageView);
        }

        public <E extends Component> E getView(int viewId) {
            E view = (E) mViews.get(viewId);
            if (view == null) {
                view = (E) itemView.findComponentById(viewId);
                mViews.put(viewId, view);
            }
            return view;
        }

    }
}
