package edu.drake.cs188.finalproject.chapter4;


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
import android.widget.TextView;

import java.util.Locale;

import edu.drake.cs188.finalproject.R;
import edu.drake.cs188.finalproject.chapter5.Chapter5;
import edu.drake.cs188.finalproject.chapter6.Chapter6;
import edu.drake.cs188.finalproject.classes.Narration;


public class Chapter4_2Fragment extends Fragment {
    // Variables declared for the class
    public static final String ARG_PAGE = "ARG_PAGE";
    SharedPreferences shared;
    String text;
    TextToSpeech voice;

    public Chapter4_2Fragment() {
        // Required empty public constructor
    }


    // Method that creates the Chapter4_2 Fragment takes in arguement
    // page used to display correct page
    public static Chapter4_2Fragment newInstance(int page) {
        Bundle args = new Bundle();  // declaring object args that is an instance of Bundle class
        args.putInt(ARG_PAGE, page); // storing the page into variable ARG_PAGE that will be passed to fragment
        Chapter4_2Fragment fragment = new Chapter4_2Fragment(); // declaring objec fragment  that is a instance of Chapter4_2 Fragment
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

        View rootView = inflater.inflate(R.layout.fragment_chapter4_2, container, false);

        rootView.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.decision));


        // declaring and intializing shared preferences function on android devices
        shared = this.getActivity().getSharedPreferences("StoryTime", Context.MODE_PRIVATE);
        String firstCharacter = shared.getString("firstCharacter", "");  // getting variable firstCharacter from shared preferences
        String secondCharacter = shared.getString("secondCharacter", "");  // getting variable secondCharacter from shared preferences
        int decision = shared.getInt("decision", 0);

        Button submitAction1;
        Button submitAction2;
        submitAction1 = (Button) rootView.findViewById(R.id.action4_1);
        submitAction2 = (Button) rootView.findViewById(R.id.action4_2);

        TextView textView = (TextView) rootView.findViewById(R.id.chapter4_2_Text);

        if (decision == 1) {

            text = firstCharacter + " " + getResources().getString(R.string.chapter4_2_1libtext) + " " +
                    secondCharacter + " " + getResources().getString(R.string.chapter4_2_2libtext);

            Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "JosefinSans-Bold.ttf");
            textView.setTypeface(tf);
            textView.setTextSize(27);
            textView.setText(text);

            submitAction1.setTypeface(tf);
            submitAction1.setText(getResources().getString(R.string.chapter4_libaction1_1) + " " +
                    firstCharacter + " " + getResources().getString(R.string.chapter4_libaction1_2) + " " +
                    secondCharacter + " " + getResources().getString(R.string.chapter4_libaction1_3));

            submitAction2.setTypeface(tf);
            submitAction2.setText(getResources().getString(R.string.chapter4_libaction2_1) + " " +
                    firstCharacter + " " + getResources().getString(R.string.chapter4_libaction2_2) + " " +
                    secondCharacter + " " + getResources().getString(R.string.chapter4_libaction2_3));

            // creating on click listener for submitAction1
            submitAction1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playSound(R.raw.typing); // craig
                    action1(1); // calling the submit method
                }
            });

            // creating on click listener for submitAction2
            submitAction2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playSound(R.raw.pagesturning); //craig
                    action2(1); // calling the submit method
                }
            });

        }

        if (decision == 2) {

            text = firstCharacter + " " + getResources().getString(R.string.chapter4_2_1playtext) + " " +
                    secondCharacter + " " + getResources().getString(R.string.chapter4_2_2libtext);

            Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "JosefinSans-Regular.ttf");
            textView.setTypeface(tf);
            textView.setTextSize(27);
            textView.setText(text);

            submitAction1.setTypeface(tf);
            submitAction1.setText(getResources().getString(R.string.chapter4_playaction1_1) + " " +
                    firstCharacter + " " + getResources().getString(R.string.chapter4_playaction1_2) + " " +
                    secondCharacter + " " + getResources().getString(R.string.chapter4_playaction1_3));

            submitAction2.setTypeface(tf);
            submitAction2.setText(getResources().getString(R.string.chapter4_playaction2_1) + " " +
                    firstCharacter + " " + getResources().getString(R.string.chapter4_playaction2_2) + " " +
                    secondCharacter + " " + getResources().getString(R.string.chapter4_playaction2_3));

            // creating on click listener for submitAction1
            submitAction1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    action1(2); // calling the submit method
                }
            });

            // creating on click listener for submitAction2
            submitAction2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    action2(2); // calling the submit method
                }
            });

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


    public void action1(int d){
        if (d == 1){
            Intent intent = new Intent(getActivity(), Chapter6.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

            SharedPreferences.Editor editor = shared.edit();
            editor.putInt("decision", 1);
            editor.apply();

            startActivity(intent);
        }

        if (d == 2){
            Intent intent = new Intent(getActivity(), Chapter5.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

            SharedPreferences.Editor editor = shared.edit();
            editor.putInt("decision", 1);
            editor.apply();

            startActivity(intent);
        }

    }

    public void action2(int d){

        if (d == 1){
            Intent intent = new Intent(getActivity(), Chapter6.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

            SharedPreferences.Editor editor = shared.edit();
            editor.putInt("decision", 2);
            editor.apply();

            startActivity(intent);
        }

        if (d == 2){
            Intent intent = new Intent(getActivity(), Chapter5.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

            SharedPreferences.Editor editor = shared.edit();
            editor.putInt("decision", 2);
            editor.apply();

            startActivity(intent);
        }

    }

    /**
     * craig: function to play the sound
     */
    private void playSound(int sound_file_id){
        MediaPlayer some_sound = MediaPlayer.create(getContext(), sound_file_id);
        some_sound.start();
    }

}
