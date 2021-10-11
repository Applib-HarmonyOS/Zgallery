package com.mzelzoghbi.sample.slice;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.ability.delegation.AbilityDelegatorRegistry;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import com.mzelzoghbi.zgallery.ZGallery;
import com.mzelzoghbi.zgallery.ZGrid;
import static org.junit.Assert.assertNotNull;

/**
 * MainAbilitySlice - Ohos Test.
 */
public class MainAbilitySliceOhosTest {

    Ability mContext;


    @Before
    public void setUp(){
        mContext= AbilityDelegatorRegistry.getAbilityDelegator().getCurrentTopAbility();
    }

    @Test
    public void setzGallery(){
        ZGallery  zGallery1 = ZGallery.with((Ability) mContext, getDummyImageList());
        assertNotNull(zGallery1);
    }

    @Test
    public void setzGrid(){
        ZGrid  zGrid1 = ZGrid.with((Ability) mContext, getDummyImageList());
        assertNotNull(zGrid1);
    }

    /**
     * Adding dummy images which are to be displayed.
     */
    private ArrayList<String> getDummyImageList() {
        ArrayList<String> imagesList = new ArrayList<>();
        imagesList.add("https://images.unsplash.com/photo-1606787366850-de6330128bfc?ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80");
        imagesList.add("https://images.unsplash.com/photo-1626462223686-bfd4080b4754?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80");
        imagesList.add("https://images.unsplash.com/photo-1626447857058-2ba6a8868cb5?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=791&q=80");
        imagesList.add("https://images.unsplash.com/photo-1626322719607-61a8b4d31fed?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80");
        imagesList.add("https://images.unsplash.com/photo-1626065838283-d338b7702fed?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80");
        imagesList.add("https://images.unsplash.com/photo-1625664166621-fe9de64f71a0?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80");
        return imagesList;
    }


}