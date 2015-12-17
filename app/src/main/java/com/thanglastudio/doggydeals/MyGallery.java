package com.thanglastudio.doggydeals;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MyGallery extends Fragment {
    TextView display;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_gallery, container, false);
        display=(TextView)v.findViewById(R.id.gallery_tv);
        String myTag= getTag();
        ((DashBoard)getActivity()).setTabFragmentNext(myTag);
        Toast.makeText(getActivity(),
                "GalleryFragment.onCreateView(): " + myTag,
                Toast.LENGTH_LONG).show();

        return v;
    }
    public  void  updateText(String text){
        display.setText(text);
    }

}
