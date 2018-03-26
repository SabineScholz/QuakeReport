package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import com.example.android.quakereport.model.Earthquake;

import java.util.List;


/**
 * Loads a list of earthquakes by using an AsyncTask to perform the
 * network request to the given URL.
 */
public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    /** Tag for log messages */
    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    /** Query URL */
    String url;

    /**
     * Constructs a new {@link EarthquakeLoader}.
     *
     * @param context of the activity
     * @param usgsRequestUrl to load data from
     */
    public EarthquakeLoader(Context context, String usgsRequestUrl) {
        super(context);
        url = usgsRequestUrl;
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<Earthquake> loadInBackground() {
        Log.d(LOG_TAG, "loadInBackground");

        if(url == null) return null;

        // Perform the HTTP request for earthquake data and process the response.
        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(url);

        return earthquakes;
    }

    @Override
    protected void onStartLoading() {
        Log.d(LOG_TAG, "onStartLoading");

        forceLoad();
    }
}
