package com.thanglastudio.doggydeals;

/**
 * Created by 984480 on 9/9/2015.
 */
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created
    int resId=0;


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapter(FragmentManager fm,CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }


    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if(position == 0) // if the position is 0 we are returning the First tab
        {
            Pet tab1 = new Pet();


            return tab1;
        }
        else if (position==1)             // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            Register tab2 = new Register();
            return tab2;
        }
        else             // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            MyGallery tab3 = new MyGallery();
            return tab3;
        }


    }
    @Override
    public Object instantiateItem(View collection, int position) {


        View view=null;

        LayoutInflater inflater = (LayoutInflater) collection.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        int resId = 0;
        switch (position) {
            case 0:
                resId = R.layout.tab_pet;
                view = inflater.inflate(resId, null);
                break;


              
            case 1:
                resId = R.layout.tab_videos;
                view = inflater.inflate(resId, null);
                break;
            case 2:

                resId = R.layout.tab_gallery;
                view = inflater.inflate(resId, null);
                break;

        }



        ((ViewPager) collection).addView(view, 0);

        return view;
    }



    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}
