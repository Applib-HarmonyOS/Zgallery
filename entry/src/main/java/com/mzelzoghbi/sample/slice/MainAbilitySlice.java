package com.mzelzoghbi.sample.slice;

import com.mzelzoghbi.sample.ResourceTable;
import com.mzelzoghbi.zgallery.ZGallery;
import com.mzelzoghbi.zgallery.ZGrid;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.utils.Color;
import java.util.ArrayList;

/**
 * MainAbilitySlice - display 2 buttons, for ZGallery and ZGrid
 */
public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        Button zgridButton = (Button) findComponentById(ResourceTable.Id_zgrid_button);
        Button zgalleryButton = (Button) findComponentById(ResourceTable.Id_zgallery_button);

        zgalleryButton.setClickedListener(component ->
                galleryActivity()
        );

        zgridButton.setClickedListener(component ->
                gridActivity()
        );
    }

    /**
     * ButtonClick function for ZGrid
     */
    public void gridActivity() {
        ZGrid.with(this.getAbility(), getDummyImageList())
                .setToolbarColorResId(Color.BLACK.getValue())
                .setTitle("ZGallery")
                .setToolbarTitleColor(Color.WHITE.getValue())
                .setSpanCount(3)
                .setGridImgPlaceHolder(Color.BLACK.getValue())
                .show();
    }

    /**
     * ButtonClick function for ZGallery
     */
    public void galleryActivity() {
        ZGallery.with(this.getAbility(), getDummyImageList())
                .setToolbarTitleColor(Color.WHITE.getValue())
                .setGalleryBackgroundColor(Color.BLACK.getValue())
                .setToolbarColorResId(Color.BLACK.getValue())
                .setTitle("ZGallery")
                .show();
    }

    /**
     * Adding dummy images which are to be displayed
     */
    private ArrayList<String> getDummyImageList() {
        ArrayList<String> imagesList = new ArrayList<>();
        imagesList.add("https://images.unsplash.com/photo-1606787366850-de6330128bfc?ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80");
        imagesList.add("https://images.unsplash.com/photo-1626462223686-bfd4080b4754?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80");
        imagesList.add("https://images.unsplash.com/photo-1626447857058-2ba6a8868cb5?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=791&q=80");
        imagesList.add("https://images.unsplash.com/photo-1626322719607-61a8b4d31fed?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80");
        imagesList.add("https://images.unsplash.com/photo-1626065838283-d338b7702fed?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80");
        imagesList.add("https://images.unsplash.com/photo-1625664166621-fe9de64f71a0?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80");
        imagesList.add("https://pic4.zhimg.com/02685b7a5f2d8cbf74e1fd1ae61d563b_xll.jpg");
        imagesList.add("https://pic4.zhimg.com/fc04224598878080115ba387846eabc3_xll.jpg");
        imagesList.add("https://pic3.zhimg.com/d1750bd47b514ad62af9497bbe5bb17e_xll.jpg");
        imagesList.add("https://pic4.zhimg.com/da52c865cb6a472c3624a78490d9a3b7_xll.jpg");
        imagesList.add("https://pic3.zhimg.com/0c149770fc2e16f4a89e6fc479272946_xll.jpg");
        imagesList.add("https://pic1.zhimg.com/76903410e4831571e19a10f39717988c_xll.png");
        imagesList.add("https://images.unsplash.com/photo-1626257673564-7e37d8a547a0?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80");
        imagesList.add("https://images.unsplash.com/photo-1621862194864-9363167fc586?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1567&q=80");
        imagesList.add("https://images.unsplash.com/photo-1626208655973-78ae68dbbc30?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80");
        imagesList.add("https://images.unsplash.com/photo-1626443314808-78815aa40621?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=375&q=80");
        imagesList.add("https://images.unsplash.com/photo-1626428433381-f62eaed37787?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=705&q=80");
        imagesList.add("https://images.unsplash.com/photo-1626196607732-eb69a05ac32b?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=334&q=80");
        imagesList.add("https://images.unsplash.com/photo-1626193588857-f8c35ecb0e6f?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=667&q=80");
        imagesList.add("https://images.unsplash.com/photo-1621862194864-9363167fc586?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1567&q=80");
        imagesList.add("https://images.unsplash.com/photo-1626454503701-3e9af8a46dc7?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80");
        imagesList.add("https://images.unsplash.com/photo-1626373413704-b28f15159ab3?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=400&q=80");
        imagesList.add("https://images.unsplash.com/photo-1626437513811-d24a8173854a?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80");
        imagesList.add("https://images.unsplash.com/photo-1606787619248-f301830a5a57?ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80");
        imagesList.add("https://images.unsplash.com/photo-1626372416494-3183a0c4f726?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=700&q=80");
        imagesList.add("https://images.unsplash.com/photo-1626450780751-d0d764738e86?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=786&q=80");
        imagesList.add("https://images.unsplash.com/photo-1593642531955-b62e17bdaa9c?ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80");
        imagesList.add("https://picsum.photos/600");
        return imagesList;
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
