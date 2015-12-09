package edu.drake.cs188.finalproject.chapter2;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

import edu.drake.cs188.finalproject.R;
import edu.drake.cs188.finalproject.chapter3.Chapter3;
import edu.drake.cs188.finalproject.classes.Narration;


public class Chapter2_10Fragment extends Fragment {
    // Variables declared for the class
    public static final String ARG_PAGE = "ARG_PAGE";
    SharedPreferences shared;
    TextToSpeech voice;

    public Chapter2_10Fragment() {
        // Required empty public constructor
    }


    // Method that creates the Chapter2_10 Fragment takes in arguement
    // page used to display correct page
    public static Chapter2_10Fragment newInstance(int page) {
        Bundle args = new Bundle();  // declaring object args that is an instance of Bundle class
        args.putInt(ARG_PAGE, page); // storing the page into variable ARG_PAGE that will be passed to fragment
        Chapter2_10Fragment fragment = new Chapter2_10Fragment(); // declaring objec fragment  that is a instance of Chapter2_10 Fragment
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
        View rootView = inflater.inflate(R.layout.fragment_chapter2_10, container, false);

        rootView.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.decision));

        // declaring and intializing shared preferences function on android devices
        shared = this.getActivity().getSharedPreferences("StoryTime", Context.MODE_PRIVATE);
        String firstCharacter = shared.getString("firstCharacter", "");  // getting variable firstCharacter from shared preferences
        String secondCharacter = shared.getString("secondCharacter", "");  // getting variable secondCharacter from shared preferences

        final String text = getResources().getString(R.string.chapter2_10_1text) +" "+ secondCharacter +" "+ getResources().getString(R.string.chapter2_10_2text)
                +" "+ firstCharacter + getResources().getString(R.string.chapter2_10_3text);

        // initializing TextToSpeech: JJeun
        voice = new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    voice.setLanguage(Locale.UK);
                }
            }
        });

        // creating on click listener for speechButton: JJeun
        ImageButton narrationButton = (ImageButton) rootView.findViewById(R.id.narrationButton);
        narrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Narration narration = new Narration(); // calling instance of narration
                narration.playNarration(voice, text); // calling playNarration of custom narration class
            }
        });

        // declaring and calling instance of Typeface. Will be used to set the fonts on textView
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "JosefinSans-Bold.ttf");
        TextView textView = (TextView) rootView.findViewById(R.id.chapter2_10_Text);
        textView.setTypeface(tf);
        textView.setTextSize(27);
        textView.setText(text);

        Button submitAction1;
        Button submitAction2;

        submitAction1 = (Button) rootView.findViewById(R.id.action2_1);
        submitAction1.setTypeface(tf);
        submitAction1.setText(getResources().getString(R.string.chapter2_action1_1) + " " + secondCharacter + " " + getResources().getString(R.string.chapter2_action1_2));

        submitAction2 = (Button) rootView.findViewById(R.id.action2_2);
        submitAction2.setText(getResources().getString(R.string.chapter2_action2_1) +" "+ secondCharacter +" "+ getResources().getString(R.string.chapter2_action2_2));
        submitAction2.setTypeface(tf);

        // creating on click listener for submitAction1
        submitAction1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action1(); // calling the submit method
            }
        });

        // creating on click listener for submitAction2
        submitAction2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action2(); // calling the submit method
            }
        });

        return rootView;    //returning the rootView to be displayed on the fragment
    }


    public void action1(){
        Intent intent = new Intent(getActivity(), Chapter3.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

        SharedPreferences.Editor editor = shared.edit();
        editor.putInt("decision", 1);
        editor.apply();

        startActivity(intent);
    }

    public void action2(){
        Intent intent = new Intent(getActivity(), Chapter3.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

        SharedPreferences.Editor editor = shared.edit();
        editor.putInt("decision", 2);
        editor.apply();

        startActivity(intent);
    }
}
