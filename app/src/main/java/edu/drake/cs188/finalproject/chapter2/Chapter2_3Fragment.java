package edu.drake.cs188.finalproject.chapter2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.drake.cs188.finalproject.R;


public class Chapter2_3Fragment extends Fragment {
    // Variables declared for the class
    public static final String ARG_PAGE = "ARG_PAGE";

    public Chapter2_3Fragment() {
        // Required empty public constructor
    }


    // Method that creates the Chapter2_1 Fragment takes in arguement
    // page used to display correct page
    public static Chapter2_3Fragment newInstance(int page) {
        Bundle args = new Bundle();  // declaring object args that is an instance of Bundle class
        args.putInt(ARG_PAGE, page); // storing the page into variable ARG_PAGE that will be passed to fragment
        Chapter2_3Fragment fragment = new Chapter2_3Fragment(); // declaring object fragment  that is a instance of Chapter2_1 Fragment
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
        View rootView = inflater.inflate(R.layout.fragment_chapter2_3, container, false);

        return rootView;    //returning the rootView to be displayed on the fragment
    }
}
