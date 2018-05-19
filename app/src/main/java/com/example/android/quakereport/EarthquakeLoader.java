package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by TAYE on 28/01/2018.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    /** Tag for log messages */
    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    /** Query URL */
    private String mUrl;

    /**
     * Constructs a new {@link EarthquakeLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG, "TEST: onStartLoading() called ....");
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        //Don't perform the request if there are no URLs, or the first URL is null.
        Log.i(LOG_TAG, "TEST: loadInBackground() called ....");
        if (mUrl == null) {
            return null;
        }
        List<Earthquake> earthquakes = QueryUtils.fetchEartquakeData(mUrl);
        return earthquakes;
    }

}
