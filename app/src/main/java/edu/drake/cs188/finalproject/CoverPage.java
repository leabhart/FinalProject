package edu.drake.cs188.finalproject;



import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class CoverPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover_page);


        /* craig:
         * here is example of code to play sound effects
         * create a media player for the sound file
         * then set the listener and use start()

        final MediaPlayer exampleMediaPlayer = MediaPlayer.create(this,R.raw.exampleFileName);
        exampleClickable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exampleMediaPlayer.start();
            }
        });

         */

    }
}
