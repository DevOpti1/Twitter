package com.codepath.apps.restclienttemplate.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by DevOpti on 11/16/2017.
 */

public class TweetsPaperAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[]{"Home", "Mention"};
    private Context context;
    public TweetsPaperAdapter(FragmentManager fm, Context context){
        super(fm);
        this.context = context;
    }
    // return the total # of fragment

    @Override
    public int getCount() {
        return 2;
    }

    // return the fragment to use depending on the position

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new HomeTimelineFragment();
        }else if (position == 1){
            return new MentionsTimeFragment();
        }else {
            return null;
        }

    }

    // return title

    @Override
    public CharSequence getPageTitle(int position) {
        // generate title based on item position
        return tabTitles[position];

    }
}
