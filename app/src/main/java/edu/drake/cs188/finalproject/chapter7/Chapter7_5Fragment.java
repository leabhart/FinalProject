package edu.drake.cs188.finalproject.chapter7;


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

/**
 * A simple {@link Fragment} subclass.
 */
public class Chapter7_5Fragment extends Fragment {
    // Variables declared for the class
    public static final String ARG_PAGE = "ARG_PAGE";

    public Chapter7_5Fragment() {
        // Required empty public constructor
    }


    // Method that creates the Chapter7_4 Fragment takes in arguement
    // page used to display correct page
    public static Chapter7_5Fragment newInstance(int page) {
        Bundle args = new Bundle();  // declaring object args that is an instance of Bundle class
        args.putInt(ARG_PAGE, page); // storing the page into variable ARG_PAGE that will be passed to fragment
        Chapter7_5Fragment fragment = new Chapter7_5Fragment(); // declaring objec fragment  that is a instance of Chapter7_4 Fragment
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
        View rootView = inflater.inflate(R.layout.fragment_chapter7_5, container, false);

        rootView.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.decision));

        // declaring and intializing shared preferences function on android devices
        SharedPreferences shared = this.getActivity().getSharedPreferences("StoryTime", Context.MODE_PRIVATE);
        String firstCharacter = shared.getString("firstCharacter", "");  // getting variable firstCharacter from shared preferences
        String secondCharacter = shared.getString("secondCharacter", "");  // getting variable secondCharacter from shared preferences

        String text = getResources().getString(R.string.chapter7_5_1text);

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "JosefinSans-Regular.ttf");
        TextView textView = (TextView) rootView.findViewById(R.id.chapter7_4_Text);
        textView.setTypeface(tf);
        textView.setTextSize(27);
        textView.setTextColor(getResources().getColor(R.color.orange));
        textView.setText(text);

        return rootView;
    }
}
