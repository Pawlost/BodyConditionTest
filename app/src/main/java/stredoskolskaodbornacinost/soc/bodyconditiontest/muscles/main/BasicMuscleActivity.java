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
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.ConditionFragment;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.FirstAidFragment;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.HomeScreenFragment;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.ProfileFragment;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.UserTestsFragment;

<<<<<<< HEAD
public class BasicMuscleActivity extends AppCompatActivity {
    private BCTMuscleHelper database;
    private static FragmentManager frM;
    private Fragment fr;
    private HomeScreenFragment homeScreen;
    private ConditionFragment conditionScreen;
    private FirstAidFragment firsAidScreen;
    private UserTestsFragment userTestsScreen;
    private ProfileFragment profileScreen;


=======
public class BasicMuscleActivity extends AppCompatActivity{
    final static int NUM_FRAGMENT = 5;
    static RadioGroup radGroup;
    ViewPager viewPager;
    MyPagerAdapter myPA;
>>>>>>> master
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        radGroup = findViewById(R.id.mainNavigation);
        myPA = new MyPagerAdapter(this);
        viewPager = findViewById(R.id.basic_fragment_pager);
        viewPager.setAdapter(myPA);

<<<<<<< HEAD
        database = new BCTMuscleHelper(this);

        Fragment fr = new HomeScreenFragment();
        switchFragment(fr);
    }
    public void saveToDatabase(String name, String lastName, int weight, int height, boolean whamen){
        if(whamen) {
            database.insertdWeightData(name, lastName, Integer.toString(weight), Integer.toString(height), "Woman");
        }else{
            database.insertdWeightData(name, lastName, Integer.toString(weight), Integer.toString(height), "Man");
        }
    }
    public void createDiagnoseFragments(int value){
        Bundle bundle = new Bundle();
        switch (value){
            //BMI
            case 1:
                bundle.putInt("CONDITION_ALL", 1);
                firsAidScreen.setArguments(bundle);
                break;
        }
    }
    public void switchFragment(Fragment fr){
        FragmentTransaction frT = frM.beginTransaction();
        if(frM.findFragmentByTag("new_fragment") != null){
            frT.remove(frM.findFragmentByTag("new_fragment"));
        }
        frT.add(R.id.basic_fragment_container, fr, "new_fragment");
        frT.commit();
    }
    public void homeButton(View view) {
        switchFragment(homeScreen);
    }
    public void testButton(View view) {
        switchFragment(userTestsScreen);
    }
    public void firsAidButton(View view) {
        switchFragment(firsAidScreen);
    }
    public void conditionButton(View view) {
        switchFragment(conditionScreen);
    }
    public void profilButton(View view) {
        fr = new ProfileFragment();
        switchFragment(profileScreen);
    }
    public BCTMuscleHelper getMainDatabase(){
        return database;
=======
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
>>>>>>> master
    }
}
