package edu.drake.cs188.finalproject.coverpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.drake.cs188.finalproject.R;
import edu.drake.cs188.finalproject.chapter1.Chapter1;


public class TitlePageFragment extends Fragment {
    // Variables declared for the class
    public static final String ARG_PAGE = "ARG_PAGE";

    public TitlePageFragment() {
        // Required empty public constructor
    }


    // Method that creates the UserContextActivityFragment takes in arguement
    // page used to display correct page
    public static TitlePageFragment newInstance(int page) {
        Bundle args = new Bundle();  // declaring object args that is an instance of Bundle class
        args.putInt(ARG_PAGE, page); // storing the page into variable ARG_PAGE that will be passed to fragment
        TitlePageFragment fragment = new TitlePageFragment(); // declaring objec fragment  that is a instance of UserContextActivityFragment
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
        View rootView = inflater.inflate(R.layout.fragment_title_page, container, false);

        Button submitButton;
        submitButton = (Button) rootView.findViewById(R.id.submitButton);

        // creating on click listener for submitButton
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit(); // calling the submit method
            }
        });

        return rootView;    //returning the rootView to be displayed on the fragment
    }

    // method that will create the intent to the new activity
    public void submit(){
        Intent intent = new Intent(getActivity(), Chapter1.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}
