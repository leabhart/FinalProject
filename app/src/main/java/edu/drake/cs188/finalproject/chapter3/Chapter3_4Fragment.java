package edu.drake.cs188.finalproject.chapter3;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.drake.cs188.finalproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Chapter3_4Fragment extends Fragment {
    // Variables declared for the class
    public static final String ARG_PAGE = "ARG_PAGE";

    public Chapter3_4Fragment() {
        // Required empty public constructor
    }


    // Method that creates the Chapter3_4 Fragment takes in arguement
    // page used to display correct page
    public static Chapter3_4Fragment newInstance(int page) {
        Bundle args = new Bundle();  // declaring object args that is an instance of Bundle class
        args.putInt(ARG_PAGE, page); // storing the page into variable ARG_PAGE that will be passed to fragment
        Chapter3_4Fragment fragment = new Chapter3_4Fragment(); // declaring objec fragment  that is a instance of Chapter3_4 Fragment
        fragment.setArguments(args); // calling method setArguments of fragment object and passing variable args as argument
        return fragment;            // returning the fragment variable
    }


    // onCreate variable for fragment
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_chapter3_4, container, false);

        // declaring and intializing shared preferences function on android devices
        SharedPreferences shared = this.getActivity().getSharedPreferences("StoryTime", Context.MODE_PRIVATE);
        String firstCharacter = shared.getString("firstCharacter", "");  // getting variable firstCharacter from shared preferences
        String secondCharacter = shared.getString("secondCharacter", "");  // getting variable secondCharacter from shared preferences

        String text = firstCharacter +" "+ getResources().getString(R.string.chapter3_4_1text) +" "+ secondCharacter +" "+
                getResources().getString(R.string.chapter3_4_2text);

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "JosefinSans-Regular.ttf");
        TextView textView = (TextView) rootView.findViewById(R.id.chapter3_4_Text);
        textView.setTypeface(tf);
        textView.setTextSize(27);
        textView.setText(text);

        return rootView;
    }


}
