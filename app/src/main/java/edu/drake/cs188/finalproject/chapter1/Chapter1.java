package edu.drake.cs188.finalproject.chapter1;

import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import edu.drake.cs188.finalproject.R;

import static edu.drake.cs188.finalproject.R.raw.*;

public class Chapter1 extends FragmentActivity{

    // declared variables for the class
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;


    // onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover_page);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

    }


    // onBackPressed method that will flip the fragment back when back button is pressed
    @Override
    public void onBackPressed(){
        if(mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        }

        else{
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    // Pager adapter class that will determine which fragment should appear on the screen
    public class ScreenSlidePagerAdapter extends FragmentPagerAdapter {
        final int PAGE_COUNT = 5;

        // pager adapter method
        public ScreenSlidePagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        // method that will return the page the fragment is on
        @Override
        public int getCount() {
            return PAGE_COUNT;
        }


        // method that will return the specific fragment dependant on the position
        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    playSound(wakeup); // craig
                    return Chapter1_1Fragment.newInstance(position);
                case 1:
                    return Chapter1_2Fragment.newInstance(position);
                case 2:
                    return Chapter1_3Fragment.newInstance(position);
                case 3:
                    return Chapter1_4Fragment.newInstance(position);
                case 4:
                    return Chapter1_5Fragment.newInstance(position);
                default:
                    return null;
            }
        }

    }

    /**
     * craig: function to play the sound
     */
    private void playSound(int sound_file_id){
        MediaPlayer some_sound = MediaPlayer.create(this, sound_file_id);
        some_sound.start();
    }
}
