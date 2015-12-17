package com.thanglastudio.doggydeals;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class DashBoard extends FragmentActivity {
	private Toolbar toolbar;
	private ViewPager pager;
	ViewPagerAdapter adapter;
	SlidingTabLayout tabs;
	CharSequence Titles[] = { "Pet Store", "Register Pet", " My Pet Gallery" };
	int Numboftabs = 3;

	String TabFragmentNext;

	public void setTabFragmentNext(String t){
		TabFragmentNext = t;
	}

	public String getTabFragmentNext(){
		return TabFragmentNext;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);

		toolbar = (Toolbar) findViewById(R.id.tool_bar);
		//setSupportActionBar(toolbar);
		toolbar.setNavigationIcon(R.drawable.icon);
		toolbar.setNavigationContentDescription("Navigation Icon");
		//getSupportActionBar().setTitle("DOG DEALS");
		toolbar.setSubtitle("All about pets");

		// Creating The ViewPagerAdapter and Passing Fragment Manager, Titles
		// fot the Tabs and Number Of Tabs.
		adapter = new ViewPagerAdapter(getSupportFragmentManager(), Titles,
				Numboftabs);

		// Assigning ViewPager View and setting the adapter
		pager = (ViewPager) findViewById(R.id.pager);
		pager.setAdapter(adapter);

		// Assiging the Sliding Tab Layout View
		tabs = (SlidingTabLayout) findViewById(R.id.tabs);
		tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true,
										// This makes the tabs Space Evenly in
										// Available width

		// Setting Custom Color for the Scroll bar indicator of the Tab View
		tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
			@Override
			public int getIndicatorColor(int position) {
				return getResources().getColor(R.color.tabScrollColor);
			}
		});

		// Setting the ViewPager For the SlidingTabsLayout
		tabs.setViewPager(pager);

	}


}
