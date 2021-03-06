package edu.drake.cs188.finalproject.coverpage;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import edu.drake.cs188.finalproject.R;


public class CoverPage extends FragmentActivity{

        // declared variables for the class
        private ViewPager mPager;
        private PagerAdapter mPagerAdapter;


        // onCreate method
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
            final int PAGE_COUNT = 2;

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
                        return CoverPageFragment.newInstance(position);
                    case 1:
                        return TitlePageFragment.newInstance(position);
                    default:
                        return null;
                }
            }

        }
}
