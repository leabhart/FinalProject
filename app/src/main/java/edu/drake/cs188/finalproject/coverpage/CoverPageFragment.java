package edu.drake.cs188.finalproject.coverpage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.drake.cs188.finalproject.R;


public class CoverPageFragment extends Fragment {
    // Variables declared for the class
    public static final String ARG_PAGE = "ARG_PAGE";

    public CoverPageFragment() {
        // Required empty public constructor
    }


    // Method that creates the UserContextActivityFragment takes in arguement
    // page used to display correct page
    public static CoverPageFragment newInstance(int page) {
        Bundle args = new Bundle();  // declaring object args that is an instance of Bundle class
        args.putInt(ARG_PAGE, page); // storing the page into variable ARG_PAGE that will be passed to fragment
        CoverPageFragment fragment = new CoverPageFragment(); // declaring objec fragment  that is a instance of UserContextActivityFragment
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
        View rootView = inflater.inflate(R.layout.fragment_cover_page, container, false);

        return rootView;    //returning the rootView to be displayed on the fragment
    }
}
