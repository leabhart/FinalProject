package edu.drake.cs188.finalproject.chapter2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import edu.drake.cs188.finalproject.R;


public class Chapter2 extends FragmentActivity{

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
        final int PAGE_COUNT = 11;

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
                    return Chapter2_1Fragment.newInstance(position);
                case 1:
                    return Chapter2_2Fragment.newInstance(position);
                case 2:
                    return Chapter2_3Fragment.newInstance(position);
                case 3:
                    return Chapter2_4Fragment.newInstance(position);
                case 4:
                    return Chapter2_5Fragment.newInstance(position);
                case 5:
                    return Chapter2_6Fragment.newInstance(position);
                case 6:
                    return Chapter2_7Fragment.newInstance(position);
                case 7:
                    return Chapter2_8Fragment.newInstance(position);
                case 8:
                    return Chapter2_9Fragment.newInstance(position);
                case 9:
                    return Chapter2_10Fragment.newInstance(position);
                case 10:
                    return Chapter2_11Fragment.newInstance(position);
                default:
                    return null;
            }
        }
    }
}
