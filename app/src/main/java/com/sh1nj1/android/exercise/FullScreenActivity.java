package com.sh1nj1.android.exercise;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;


public class FullScreenActivity extends ActionBarActivity implements BlankFragment.OnFragmentInteractionListener {

    private static final String TAG = FullScreenActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.d(TAG, "onFragmentInteraction: uri="+String.valueOf(uri));
    }
}
