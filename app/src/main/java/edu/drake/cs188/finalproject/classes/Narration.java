package edu.drake.cs188.finalproject.classes;

import android.content.Context;
import android.speech.tts.TextToSpeech;

import java.util.Locale;

/**
 * Created by Jesse on 12/8/2015.
 * Description: Java class that will play the narration of the story
 */
public class Narration {

    private TextToSpeech voice;

    public void Narration(Context context){
        voice = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    voice.setLanguage(Locale.US);
                }
            }
        });
    }

    public void playNarration(TextToSpeech voice, String text){

        voice.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
}