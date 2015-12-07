package edu.drake.cs188.finalproject.coverpage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


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
        final View rootView = inflater.inflate(R.layout.fragment_title_page, container, false);

        final Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "JosefinSans-Regular.ttf");
        Button submitButton;
        submitButton = (Button) rootView.findViewById(R.id.submitButton);
        submitButton.setTypeface(tf);

//        String text = "";
//        TextView textView = (TextView) rootView.findViewById(R.id.titleText);
//        textView.setTypeface(tf);
//        textView.setTextSize(27);
//        textView.setText(text);


        // creating on click listener for submitButton
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText firstCharacter = (EditText) rootView.findViewById(R.id.firstCharacter);
                EditText secondCharacter = (EditText) rootView.findViewById(R.id.secondCharacter);
                firstCharacter.setTypeface(tf);
                secondCharacter.setTypeface(tf);
                String first = firstCharacter.getText().toString().toUpperCase();
                String second = secondCharacter.getText().toString().toUpperCase();

                if(first.equals("")){
                    first = "PENGUIN";
                }

                if(second.equals("")){
                    second = "CAT";
                }

                SharedPreferences shared = getActivity().getSharedPreferences("StoryTime", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.putString("firstCharacter", first);
                editor.putString("secondCharacter", second);
                editor.commit();

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
