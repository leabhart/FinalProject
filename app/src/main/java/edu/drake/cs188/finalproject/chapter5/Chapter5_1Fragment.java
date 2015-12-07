package edu.drake.cs188.finalproject.chapter5;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.drake.cs188.finalproject.R;


public class Chapter5_1Fragment extends Fragment {
    // Variables declared for the class
    public static final String ARG_PAGE = "ARG_PAGE";

    public Chapter5_1Fragment() {
        // Required empty public constructor
    }


    // Method that creates the Chapter5_1 Fragment takes in arguement
    // page used to display correct page
    public static Chapter5_1Fragment newInstance(int page) {
        Bundle args = new Bundle();  // declaring object args that is an instance of Bundle class
        args.putInt(ARG_PAGE, page); // storing the page into variable ARG_PAGE that will be passed to fragment
        Chapter5_1Fragment fragment = new Chapter5_1Fragment(); // declaring object fragment  that is a instance of Chapter5_1 Fragment
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
        View rootView = inflater.inflate(R.layout.fragment_chapter5_1, container, false);

        // declaring and intializing shared preferences function on android devices
        SharedPreferences shared = this.getActivity().getSharedPreferences("StoryTime", Context.MODE_PRIVATE);
        String firstCharacter = shared.getString("firstCharacter", "");  // getting variable firstCharacter from shared preferences
        String secondCharacter = shared.getString("secondCharacter", "");  // getting variable secondCharacter from shared preferences
        int decision = shared.getInt("decision", 0);  // getting variable decision from shared preferences

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "JosefinSans-Regular.ttf");
        if (decision == 1){
            String text = firstCharacter +" "+ getResources().getString(R.string.chapter5_1_1textFour) +" "+
                    secondCharacter + " " + getResources().getString(R.string.chapter5_1_2textFour);

            rootView.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.chapter5_1_1));
            TextView textView = (TextView) rootView.findViewById(R.id.chapter5_1_Text);
            textView.setTypeface(tf);
            textView.setTextSize(27);
            textView.setText(text);
        }

        if(decision == 2){
            String text = firstCharacter +" "+ getResources().getString(R.string.chapter5_1_1textSwing)
                    +" "+ secondCharacter + " " + getResources().getString(R.string.chapter5_1_2textSwing);

            rootView.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.chapter5_1_2));
            TextView textView = (TextView) rootView.findViewById(R.id.chapter5_1_Text);
            textView.setTypeface(tf);
            textView.setTextSize(27);
            textView.setText(text);

        }

        return rootView;    //returning the rootView to be displayed on the fragment
    }
}
