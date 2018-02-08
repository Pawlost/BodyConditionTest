package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import stredoskolskaodbornacinost.soc.bodyconditiontest.*;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.ConditionFragment;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.FirstAidFragment;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.HomeScreenFragment;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.ProfileFragment;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.UserTestsFragment;

public class BasicMuscleActivity extends AppCompatActivity {

    private  HomeScreenFragment homeScreen;
    private  ConditionFragment conditionScreen;
    private FirstAidFragment firsAidScreen;
    private UserTestsFragment userTestsScreen;
    private ProfileFragment profileScreen;

    private BCTMuscleHelper database;
    RadioGroup radGroup;
    ViewPager viewPager;
    MyPagerAdapter myPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        homeScreen = new HomeScreenFragment();
        conditionScreen = new ConditionFragment();
        firsAidScreen = new FirstAidFragment();
        userTestsScreen = new UserTestsFragment();
        profileScreen = new ProfileFragment();

        radGroup = findViewById(R.id.mainNavigation);
        myPA = new MyPagerAdapter(this);
        viewPager = findViewById(R.id.basic_fragment_pager);
        viewPager.setAdapter(myPA);
        database = new BCTMuscleHelper(this);

        viewPager.setCurrentItem(0);
    }

    public void saveToDatabase(String name, String lastName, int weight, int height, boolean whamen) {
        if (whamen) {
            database.insertdWeightData(name, lastName, Integer.toString(weight), Integer.toString(height), "Woman");
        } else {
            database.insertdWeightData(name, lastName, Integer.toString(weight), Integer.toString(height), "Man");
        }
    }
    public void recaiveDiagnoseFragments(int value) {

        Bundle bundle = new Bundle();
        switch (value) {
            case 1:
                bundle.putInt("CONDITION_ALL", 1);
                firsAidScreen.setArguments(bundle);
                break;
        }
    }
    public BCTMuscleHelper getMainDatabase() {
        return database;
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
    public class MyPagerAdapter extends FragmentPagerAdapter {
        final static int NUM_FRAGMENT = 5;

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
            Bundle bundle = new Bundle();
            switch (position) {
                case 0:
                    fr = homeScreen;
                    break;
                case 1:
                    fr = userTestsScreen;
                    break;
                case 2:
                    fr = firsAidScreen;
                    break;
                case 3:
                    fr = conditionScreen;
                    break;
                case 4:
                    fr = profileScreen;
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
