package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

import java.math.BigDecimal;
import java.util.ArrayList;

import stredoskolskaodbornacinost.soc.bodyconditiontest.*;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.ConditionFragment;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.FirstAidFragment;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.HomeScreenFragment;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.ProfileFragment;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.UserTestsFragment;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.adapters.MyPagerAdapter;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.model.database.MuscleDatabase;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.model.entities.ProfileData;


//Basic Activity for muscle functions
public class BasicMuscleActivity extends AppCompatActivity {

    private ArrayList<Fragment> fragments;

    private ViewPager viewPager;
    private MyPagerAdapter myPA;
    private ProfileData profData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        //init fragments
        fragments = new ArrayList<>();
        fragments.add(new HomeScreenFragment());
        fragments.add(new UserTestsFragment());
        fragments.add(new FirstAidFragment());
        fragments.add(new ConditionFragment());
        fragments.add(new ProfileFragment());
        MuscleDatabase load = MuscleDatabase.load(this);

        try{
            profData = load.profileDao().getProfile()[0];
            Log.e("Nacitani", "Povedlo se");
        }catch (RuntimeException e){
            profData = new ProfileData();
            Log.e("Nacitani", "Nepovedlo se" + e.getMessage());
        }
        RadioGroup radGroup = findViewById(R.id.mainNavigation);
        myPA = new MyPagerAdapter(this, radGroup, fragments);
        viewPager = findViewById(R.id.basic_fragment_pager);
        viewPager.setAdapter(myPA);

        viewPager.setCurrentItem(0);
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
    //PASSING ARGUMENTS BETWEEN FRAGMENTS
    //INSERT DATA INTO DATABASE

    @SuppressLint("StaticFieldLeak")
    public void setConditionDiagnose(int damageValue, ProfileData profData) {
        this.profData = profData;
        final ProfileData profDataFinal = profData;
        Log.e("ProfileData", String.valueOf(profDataFinal==null));
        final MuscleDatabase save = MuscleDatabase.save(this);
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                if(android.os.Debug.isDebuggerConnected())
                    android.os.Debug.waitForDebugger();
                save.profileDao().insertProfile(profDataFinal);
                Log.e("Ukladani", "Povedlo se");
                return null;
            }
        }.execute();

        Log.e("Ukladani", "Nepovedlo se");
        if (profData != null) {
            Bundle bundle = new Bundle();
            DiagnoseHelper diagnoseHelper = new DiagnoseHelper();
            switch (damageValue) {
                case 0:
                    DamageObjects dmgO = new DamageObjects("BMI Index",
                            String.valueOf(myRound(diagnoseHelper.createBMIndex(profData.weight,
                                    profData.height))), diagnoseHelper.getBMIDiagnose(), 0);

                    bundle.putInt("CONDITION_ALL_KEY", 0);
                    bundle.putSerializable("CONDITION_ALL", dmgO);
                    fragments.get(3).setArguments(bundle);
                    break;

                case 1:
                    DamageObjects dmgO2 = new DamageObjects("BMI Index",
                            String.valueOf(myRound(diagnoseHelper.createBMIndex(profData.weight,
                                    profData.height))), diagnoseHelper.getBMIDiagnose(), 0);

                    bundle.putInt("CONDITION_ALL_KEY", 0);
                    bundle.putSerializable("CONDITION_ALL", dmgO2);
                    fragments.get(3).setArguments(bundle);
                    break;
                case 2:
                    break;
            }
            myPA.updateFragments(fragments);
        }
    }
    //Function for round numbers
    public float myRound(float number) {
        BigDecimal bd = new BigDecimal(Float.toString(number));
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
    public ProfileData getProfileData(){
        return profData;
    }
}
