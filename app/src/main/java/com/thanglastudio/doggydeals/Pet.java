package com.thanglastudio.doggydeals;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Pet extends Fragment {
    ListView listView;
    //You need to get all data here to show in listview

    String[] data={"check1 ","Check 2"};
    ArrayAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_pet, container, false);
        listView=(ListView)v.findViewById(R.id.dataListView);

        adapter= new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);
        return v;
    }
}
