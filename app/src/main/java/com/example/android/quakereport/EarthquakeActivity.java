package com.example.android.quakereport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class EarthquakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake);

        // Create a fake list of earthquakes
        ArrayList<Earthquake> earthquakes = createEarthquakes();

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }

    private ArrayList<Earthquake> createEarthquakes() {
        ArrayList<Earthquake> earthquakes = new ArrayList<>();
        Calendar cal = new GregorianCalendar(2010, 9, 26);
        earthquakes.add(new Earthquake(7.2, "San Francisco", cal.getTime()));
        earthquakes.add(new Earthquake(6.7, "London", cal.getTime()));
        return earthquakes;
    }
}
