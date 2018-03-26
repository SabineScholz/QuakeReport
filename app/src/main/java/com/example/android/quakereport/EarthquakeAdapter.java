package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.quakereport.model.Earthquake;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Sabine on 25.03.2018.
 */

public class EarthquakeAdapter  extends ArrayAdapter<Earthquake> {

    Earthquake earthquake;

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        earthquake = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_earthquake, parent, false);
        }

        // Get the TextViews from the convertView and put data into them
        TextView magnitudeTextView = convertView.findViewById(R.id.magnitude);
        TextView primaryPlaceTextView = convertView.findViewById(R.id.primary_place);
        TextView offsetPlaceTextView = convertView.findViewById(R.id.offset_place);
        TextView dateTextView = convertView.findViewById(R.id.date);
        TextView timeTextView = convertView.findViewById(R.id.time);

        magnitudeTextView.setText(formatMagnitude(earthquake.getMagnitude()));
        primaryPlaceTextView.setText(getPrimaryPlace(earthquake.getPlace()));
        offsetPlaceTextView.setText(getOffsetPlace(earthquake.getPlace()));
        dateTextView.setText(formatDate(earthquake.getDate()));
        timeTextView.setText(formatTime(earthquake.getDate()));

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(earthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        return convertView;
    }

    private int getMagnitudeColor(double magnitude) {

        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);

    }

    private String getPrimaryPlace(String place) {
        if(place.contains("km ") && place.contains(" of")){
            String s = place.split(" of")[1];
            return s.substring(1);
        }
        return place;
    }

    private  String getOffsetPlace(String place) {
        if(place.contains("km ") && place.contains(" of")){
            return place.split(" of")[0] + " of";
        }
        return "Near the";
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private String formatTime(Calendar date){
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm");
        return sdf.format(date.getTime());
    }

    private String formatDate(Calendar date) {
        return DateFormat.getDateInstance().format(date.getTime());
    }
}
