package edu.drake.cs188.finalproject.chapter3;


import android.content.Context;
import android.content.Intent;
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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

import edu.drake.cs188.finalproject.R;
import edu.drake.cs188.finalproject.chapter4.Chapter4;
import edu.drake.cs188.finalproject.classes.Narration;


public class Chapter3_2Fragment extends Fragment {
    // Variables declared for the class
    public static final String ARG_PAGE = "ARG_PAGE";
    String text;
    TextToSpeech voice;

    public Chapter3_2Fragment() {
        // Required empty public constructor
    }


    // Method that creates the Chapter3_2 Fragment takes in arguement
    // page used to display correct page
    public static Chapter3_2Fragment newInstance(int page) {
        Bundle args = new Bundle();  // declaring object args that is an instance of Bundle class
        args.putInt(ARG_PAGE, page); // storing the page into variable ARG_PAGE that will be passed to fragment
        Chapter3_2Fragment fragment = new Chapter3_2Fragment(); // declaring objec fragment  that is a instance of Chapter3_2 Fragment
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
        View rootView = inflater.inflate(R.layout.fragment_chapter3_2, container, false);

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "JosefinSans-Bold.ttf");

        // declaring and intializing shared preferences function on android devices
        SharedPreferences shared = this.getActivity().getSharedPreferences("StoryTime", Context.MODE_PRIVATE);
        String firstCharacter = shared.getString("firstCharacter", "");  // getting variable firstCharacter from shared preferences
        String secondCharacter = shared.getString("secondCharacter", "");  // getting variable secondCharacter from shared preferences
        int decision = shared.getInt("decision", 0);

        if (decision == 1) {
            text = firstCharacter + " " + getResources().getString(R.string.chapter3_2_1textShare) + " " +
                    secondCharacter + " " + getResources().getString(R.string.chapter3_2_2textShare);

            rootView.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.chapter3_2_1));
            TextView textView = (TextView) rootView.findViewById(R.id.chapter3_2_Text);
            textView.setTypeface(tf);
            textView.setTextSize(27);
            textView.setText(text);
        }

        if (decision == 2) {
            text = secondCharacter + " " + getResources().getString(R.string.chapter3_2_1textNoShare) +" "+
                    firstCharacter + " " + getResources().getString(R.string.chapter3_2_2textNoShare) +" "+
                    secondCharacter + " " + getResources().getString(R.string.chapter3_2_3textNoShare);

            rootView.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.chapter3_2_2));
            TextView textView = (TextView) rootView.findViewById(R.id.chapter3_2_Text);
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

        /**
         * craig: sound button
         */
        ImageView cookie = (ImageView) rootView.findViewById(R.id.cookie);
        cookie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.eatcookie);
            }
        });

        return rootView;    //returning the rootView to be displayed on the fragment
    }

    /**
     * craig: function to play the sound
     */
    private void playSound(int sound_file_id){
        MediaPlayer some_sound = MediaPlayer.create(getContext(), sound_file_id);
        some_sound.start();
    }
}
