package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.damage.Obesity;
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

        RadioGroup radGroup = findViewById(R.id.mainNavigation);
        myPA = new MyPagerAdapter(this, radGroup, fragments);
        initViewPager();
        MuscleDatabase load = MuscleDatabase.load(this);

        try{
            profData = load.profileDao().getProfile()[0];
            setConditionDiagnose( new int[]{0, 1}, profData);
            Log.e("Nacitani", "Povedlo se");
        }catch (RuntimeException e){
            profData = new ProfileData();
            Log.e("Nacitani", "Nepovedlo se" + e.getMessage());
        }

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
    public void setConditionDiagnose(int[] damageValue, ProfileData profData) {
        if(profData != this.profData) {
            this.profData = profData;
        }
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

        if (profData != null) {
            Bundle bundle = new Bundle();
            Sender sender = new Sender();
            for(int i:damageValue) {
                switch (i) {
                    case 0:
                        ArrayList<DamageObject> dmgObs = sender.get(profData);
                        bundle.putSerializable("CONDITION_ALL", dmgObs);
                        fragments.get(3).setArguments(bundle);
                        break;

                    case 1:
                        bundle.putStringArray("PROFILE_NAME", new String[]{profData.name, profData.lastname});
                        fragments.get(0).setArguments(bundle);
                        break;
                }
                myPA.updateFragments(fragments);
            }
        }
    }

    private void initViewPager(){
        viewPager = findViewById(R.id.basic_fragment_pager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Fragment fr = myPA.getItem(position);
                if(fr.getView() != null) {
                    InputMethodManager imm = (InputMethodManager) fr.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(fr.getView().getWindowToken(), 0);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager.setAdapter(myPA);
        viewPager.setCurrentItem(0);
    }

    public ProfileData getProfileData(){
        return this.profData;
    }

}
