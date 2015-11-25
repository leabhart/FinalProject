package edu.drake.cs188.finalproject.chapter8;


import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.drake.cs188.finalproject.R;
import edu.drake.cs188.finalproject.chapter7.Chapter7;
import edu.drake.cs188.finalproject.coverpage.CoverPage;


public class Chapter8_2Fragment extends Fragment {
    // Variables declared for the class
    public static final String ARG_PAGE = "ARG_PAGE";

    public Chapter8_2Fragment() {
        // Required empty public constructor
    }


    // Method that creates the Chapter8_2 Fragment takes in arguement
    // page used to display correct page
    public static Chapter8_2Fragment newInstance(int page) {
        Bundle args = new Bundle();  // declaring object args that is an instance of Bundle class
        args.putInt(ARG_PAGE, page); // storing the page into variable ARG_PAGE that will be passed to fragment
        Chapter8_2Fragment fragment = new Chapter8_2Fragment(); // declaring objec fragment  that is a instance of Chapter8_2 Fragment
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
        View rootView = inflater.inflate(R.layout.fragment_chapter8_2, container, false);

        Button submitAction1;
        submitAction1 = (Button) rootView.findViewById(R.id.action8_1);

        // creating on click listener for submitAction1
        submitAction1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action1(); // calling the submit method
            }
        });

        return rootView;    //returning the rootView to be displayed on the fragment
    }


    public void action1(){
        Intent intent = new Intent(getActivity(), CoverPage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

}
