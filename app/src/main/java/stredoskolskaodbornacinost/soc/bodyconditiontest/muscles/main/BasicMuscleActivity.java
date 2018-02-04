package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import stredoskolskaodbornacinost.soc.bodyconditiontest.*;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.ConditionActivity;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.ExerciseActivity;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.HomeScreen;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.ProfileActivity;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.UserTests;

public class BasicMuscleActivity extends AppCompatActivity{
    final static int NUM_FRAGMENT = 5;
    static RadioGroup radGroup;
    ViewPager viewPager;
    MyPagerAdapter myPA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        radGroup = findViewById(R.id.mainNavigation);
        myPA = new MyPagerAdapter(this);
        viewPager = findViewById(R.id.basic_fragment_pager);
        viewPager.setAdapter(myPA);

        viewPager.setCurrentItem(0);
    }

    public void onClickButtonMethod(View v) {
        switch (v.getId()) {
            case R.id.homeButton:
                viewPager.setAdapter(myPA);
                viewPager.setCurrentItem(0);
                break;
            case R.id.testsButton:
                viewPager.setAdapter(myPA);
                viewPager.setCurrentItem(1);
                break;
            case R.id.firstAidButton:
                viewPager.setAdapter(myPA);
                viewPager.setCurrentItem(2);
                break;
            case R.id.conditionButton:
                viewPager.setAdapter(myPA);
                viewPager.setCurrentItem(3);
                break;
            case R.id.profilButton:
                viewPager.setAdapter(myPA);
                viewPager.setCurrentItem(4);
                break;
        }
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {

        private MyPagerAdapter(AppCompatActivity context) {
            super(context.getSupportFragmentManager());
        }
        @Override
        public void startUpdate (ViewGroup vg){
           ViewPager vp = (ViewPager) vg.findViewById(R.id.basic_fragment_pager);
           switch(vp.getCurrentItem()){
               case 0:
                   radGroup.check(R.id.homeButton);
                   break;
               case 1:
                   radGroup.check(R.id.testsButton);
                   break;
               case 2:
                   radGroup.check(R.id.firstAidButton);
                   break;
               case 3:
                   radGroup.check(R.id.conditionButton);
                   break;
               case 4:
                   radGroup.check(R.id.profilButton);
                   break;
           }
        }
        @Override
        public Fragment getItem(int position) {
            Fragment fr = null;
            Log.println(Log.INFO, "LOL", String.valueOf(position));
            switch (position) {
                case 0:
                    fr = new HomeScreen();
                    break;
                case 1:
                    fr = new UserTests();
                    break;
                case 2:
                    fr = new ExerciseActivity();
                    break;
                case 3:
                    fr = new ConditionActivity();
                    break;
                case 4:
                    fr = new ProfileActivity();
                    break;
            }
            return fr;
        }
        @Override
        public int getCount() {
            return NUM_FRAGMENT;
        }
    }
}
