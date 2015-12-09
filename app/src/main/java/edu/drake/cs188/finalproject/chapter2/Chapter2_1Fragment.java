package edu.drake.cs188.finalproject.chapter2;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Locale;

import edu.drake.cs188.finalproject.R;
import edu.drake.cs188.finalproject.classes.Narration;


public class Chapter2_1Fragment extends Fragment {
    // Variables declared for the class
    public static final String ARG_PAGE = "ARG_PAGE";
    String text;
    TextToSpeech voice;

    public Chapter2_1Fragment() {
        // Required empty public constructor
    }


    // Method that creates the Chapter2_1 Fragment takes in arguement
    // page used to display correct page
    public static Chapter2_1Fragment newInstance(int page) {
        Bundle args = new Bundle();  // declaring object args that is an instance of Bundle class
        args.putInt(ARG_PAGE, page); // storing the page into variable ARG_PAGE that will be passed to fragment
        Chapter2_1Fragment fragment = new Chapter2_1Fragment(); // declaring object fragment  that is a instance of Chapter2_1 Fragment
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
        View rootView = inflater.inflate(R.layout.fragment_chapter2_1, container, false);

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "JosefinSans-Bold.ttf");

        // declaring and intializing shared preferences function on android devices
        SharedPreferences shared = this.getActivity().getSharedPreferences("StoryTime", Context.MODE_PRIVATE);
        String firstCharacter = shared.getString("firstCharacter", "");  // getting variable firstCharacter from shared preferences
        String secondCharacter = shared.getString("secondCharacter", "");  // getting variable secondCharacter from shared preferences
        int decision = shared.getInt("decision", 0);

        if (decision == 1){
            text = firstCharacter +" "+ getResources().getString(R.string.chapter2_1_1textWave) +" "+
                    secondCharacter +" "+ getResources().getString(R.string.chapter2_1_2textWave);

            rootView.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.chapter2_1_1));
            TextView textView = (TextView) rootView.findViewById(R.id.chapter2_1_Text);
            textView.setTypeface(tf);
            textView.setTextSize(27);
            textView.setText(text);
        }

        if(decision == 2){
            text = firstCharacter +" "+ getResources().getString(R.string.chapter2_1_1textFive) +" "+
                    secondCharacter +" "+ getResources().getString(R.string.chapter2_1_2textFive);

            rootView.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.chapter2_1_2));
            TextView textView = (TextView) rootView.findViewById(R.id.chapter2_1_Text);
            textView.setTypeface(tf);
            textView.setTextSize(27);
            textView.setText(text);

        }

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


        return rootView;    //returning the rootView to be displayed on the fragment
    }
}
