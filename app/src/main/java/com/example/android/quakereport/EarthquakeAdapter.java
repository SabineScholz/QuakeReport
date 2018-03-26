package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Sabine on 25.03.2018.
 */

public class EarthquakeAdapter  extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Earthquake earthquake = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_earthquake, parent, false);
        }

        // Get the TextViews from the convertView and put data into them
        TextView magnitudeTextView = convertView.findViewById(R.id.magnitude);
        TextView placeTextView = convertView.findViewById(R.id.place);
        TextView dateTextView = convertView.findViewById(R.id.date);
        TextView timeTextView = convertView.findViewById(R.id.time);

        magnitudeTextView.setText(Double.toString(earthquake.getMagnitude()));
        placeTextView.setText(earthquake.getPlace());
        dateTextView.setText(DateFormat.getDateInstance().format(earthquake.getDate().getTime()));
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm");
        timeTextView.setText(sdf.format(earthquake.getDate().getTimeInMillis()));

        return convertView;
    }
}
