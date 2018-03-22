package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import java.math.BigDecimal;
import java.util.ArrayList;

import stredoskolskaodbornacinost.soc.bodyconditiontest.*;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.Model.Database.BSMuscleHelper;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.Model.Damage.DamageObject;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.ConditionFragment;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.FirstAidFragment;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.HomeScreenFragment;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.ProfileFragment;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.UserTestsFragment;

public class BasicMuscleActivity extends AppCompatActivity {

    private HomeScreenFragment homeScreen;
    private ConditionFragment conditionScreen;
    private FirstAidFragment firsAidScreen;
    private UserTestsFragment userTestsScreen;
    private ProfileFragment profileScreen;

    private BSMuscleHelper database;
    private DiagnoseHelper diagnoseHelper;
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
        database = new BSMuscleHelper(this);

        viewPager.setCurrentItem(0);
    }

    public void setMuscleDatabase(String[] data, boolean whamen) {
        if (whamen) {
            database.insertProfileData(data[0], data[1], data[2], data[3], "Whamen");
        } else {
            database.insertProfileData(data[0], data[1], data[2], data[3], "Man");
        }
    }
    public void setProfileData() {
        if (!database.getAllDiagnostics().isEmpty()) {
            ArrayList<String> data = database.getAllDiagnostics();
            String[] data2 = new String [5];
            for (int i = 0; i < data.size(); i++){
                data2[i] = data.get(i);
            }
            profileScreen.setEditTParams(data2);
            setConditionDiagnose(0, data2);
        }
    }
    
    public void setConditionDiagnose(int damageValue, String[] data) {
        if(data.length != 0) {
            Bundle bundle = new Bundle();
            diagnoseHelper = new DiagnoseHelper();
            switch (damageValue) {
                case 0:
                    DamageObject dmgO = new DamageObject("BMI Index",
                            String.valueOf(myRound(diagnoseHelper.createBMIndex(Integer.parseInt(data[2]),
                                    Integer.parseInt(data[3])))), diagnoseHelper.getBMIDiagnose(), 0);
                    bundle.putInt("CONDITION_ALL_KEY", 0);
                    bundle.putSerializable("CONDITION_ALL", dmgO);
                    conditionScreen.setArguments(bundle);
                    break;
                case 1:
                    DamageObject dmgO2 = new DamageObject("BMI Index",
                            String.valueOf(myRound(diagnoseHelper.createBMIndex(Integer.parseInt(data[2]),
                                    Integer.parseInt(data[3])))), diagnoseHelper.getBMIDiagnose(), 0);
                    bundle.putInt("CONDITION_ALL_KEY", 0);
                    bundle.putSerializable("CONDITION_ALL", dmgO2);
                    conditionScreen.setArguments(bundle);
                    break;
                case 2:
                    break;
            }
        }
    }
    public float myRound(float number){
        BigDecimal bd = new BigDecimal(Float.toString(number));
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

    public void onClickButtonMethod(View v) {
        viewPager.setAdapter(myPA);

        switch (v.getId()) {
            case R.id.homeButton:
                viewPager.setCurrentItem(0);
                break;
            case R.id.testsButton:
                viewPager.setCurrentItem(1);
                break;
            case R.id.firstAidButton:
                viewPager.setCurrentItem(2);
                break;
            case R.id.conditionButton:
                viewPager.setCurrentItem(3);
                break;
            case R.id.profilButton:
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
           vp.setOffscreenPageLimit(1);
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
