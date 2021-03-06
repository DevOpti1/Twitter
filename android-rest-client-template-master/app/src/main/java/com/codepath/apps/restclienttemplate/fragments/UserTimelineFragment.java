package com.codepath.apps.restclienttemplate.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.codepath.apps.restclienttemplate.TwitterApp;
import com.codepath.apps.restclienttemplate.TwitterClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by DevOpti on 11/17/2017.
 */

public class UserTimelineFragment extends TweetsListFragment {
    TwitterClient client;
public static UserTimelineFragment newInstance(String screenName){
    UserTimelineFragment userTimelineFragment = new UserTimelineFragment();
    Bundle args = new Bundle();
    args.putString("screen_name", screenName);
    userTimelineFragment.setArguments(args);
    return userTimelineFragment;
}
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = TwitterApp.getRestClient();
        populateTimeline();
    }

    private void populateTimeline(){
        // cones from the activity
        String screenName = getArguments().getString("screen_name");
        client.getUserTimeLine(screenName, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.d("TwitterClient", response.toString());

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                //  Log.d("TwitterClient", response.toString());
                addItems(response);
                // iterate through the JSON Array
                // for each entry, deserialize the JSON object

                // convert each object to a tweet
                // add that tweet model to our data source
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("TwitterClient", responseString);
                throwable.printStackTrace();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                Log.d("TwitterClient", errorResponse.toString());
                throwable.printStackTrace();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                //throwable.printStackTrace();
            }
        });
    }

}
