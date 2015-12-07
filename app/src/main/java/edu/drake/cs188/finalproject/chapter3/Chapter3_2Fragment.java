package edu.drake.cs188.finalproject.chapter3;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import edu.drake.cs188.finalproject.R;
import edu.drake.cs188.finalproject.chapter4.Chapter4;


public class Chapter3_2Fragment extends Fragment {
    // Variables declared for the class
    public static final String ARG_PAGE = "ARG_PAGE";

    public Chapter3_2Fragment() {
        // Required empty public constructor
    }


    // Method that creates the Chapter3_2 Fragment takes in arguement
    // page used to display correct page
    public static Chapter3_2Fragment newInstance(int page) {
        Bundle args = new Bundle();  // declaring object args that is an instance of Bundle class
        args.putInt(ARG_PAGE, page); // storing the page into variable ARG_PAGE that will be passed to fragment
        Chapter3_2Fragment fragment = new Chapter3_2Fragment(); // declaring objec fragment  that is a instance of Chapter3_2 Fragment
        fragment.setArguments(args); // calling method setArguments of fragment object and passing variable args as argument
        return fragment;            // returning the fragment variable
    }


    // onCreate variable for fragment
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    // onCreateView method for fragment. Handles what will be displayed in the fragment page
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // creating object rootView that is istantiated to value of type ViewGroup
        View rootView = inflater.inflate(R.layout.fragment_chapter3_2, container, false);

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "JosefinSans-Regular.ttf");

        // declaring and intializing shared preferences function on android devices
        SharedPreferences shared = this.getActivity().getSharedPreferences("StoryTime", Context.MODE_PRIVATE);
        String firstCharacter = shared.getString("firstCharacter", "");  // getting variable firstCharacter from shared preferences
        String secondCharacter = shared.getString("secondCharacter", "");  // getting variable secondCharacter from shared preferences
        int decision = shared.getInt("decision", 0);

        if (decision == 1) {
            String text = firstCharacter + " " + getResources().getString(R.string.chapter3_2_1textShare) + " " +
                    secondCharacter + " " + getResources().getString(R.string.chapter3_2_2textShare);

            rootView.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.chapter3_2_1));
            TextView textView = (TextView) rootView.findViewById(R.id.chapter3_2_Text);
            textView.setTypeface(tf);
            textView.setTextSize(27);
            textView.setText(text);
        }

        if (decision == 2) {
            String text = secondCharacter + " " + getResources().getString(R.string.chapter3_2_1textNoShare) +" "+
                    firstCharacter + " " + getResources().getString(R.string.chapter3_2_2textNoShare) +" "+
                    secondCharacter + " " + getResources().getString(R.string.chapter3_2_3textNoShare);

            rootView.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.chapter3_2_2));
            TextView textView = (TextView) rootView.findViewById(R.id.chapter3_2_Text);
            textView.setTypeface(tf);
            textView.setTextSize(27);
            textView.setText(text);

        }
        return rootView;    //returning the rootView to be displayed on the fragment
    }
}
