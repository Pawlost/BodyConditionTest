package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.ListHelpers.MyPagerAdapter;


//Basic Activity for muscle functions
public class BasicMuscleActivity extends AppCompatActivity {

    private ArrayList<Fragment> fragments;

    private BSMuscleHelper database;
    RadioGroup radGroup;
    ViewPager viewPager;
    MyPagerAdapter myPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        fragments = new ArrayList<>();

        fragments.add(new HomeScreenFragment());
        fragments.add(new UserTestsFragment());
        fragments.add(new FirstAidFragment());
        fragments.add(new ConditionFragment());
        fragments.add(new ProfileFragment());

        radGroup = findViewById(R.id.mainNavigation);
        myPA = new MyPagerAdapter(this, radGroup, fragments);
        viewPager = findViewById(R.id.basic_fragment_pager);
        viewPager.setAdapter(myPA);

        viewPager.setCurrentItem(0);

        //database = new BSMuscleHelper(this);
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
    //PASSING ARGUMENTS BETWEEN FRAGMENTS

    public void setConditionDiagnose(int damageValue, String[] data) {
        if (data.length != 0) {
            Bundle bundle = new Bundle();
            DiagnoseHelper diagnoseHelper = new DiagnoseHelper();
            switch (damageValue) {
                case 0:
                    DamageObject dmgO = new DamageObject("BMI Index",
                            String.valueOf(myRound(diagnoseHelper.createBMIndex(Integer.parseInt(data[2]),
                                    Integer.parseInt(data[3])))), diagnoseHelper.getBMIDiagnose(), 0);

                    bundle.putInt("CONDITION_ALL_KEY", 0);
                    bundle.putSerializable("CONDITION_ALL", dmgO);
                    fragments.get(3).setArguments(bundle);
                    break;
                case 1:
                    DamageObject dmgO2 = new DamageObject("BMI Index",
                            String.valueOf(myRound(diagnoseHelper.createBMIndex(Integer.parseInt(data[2]),
                                    Integer.parseInt(data[3])))), diagnoseHelper.getBMIDiagnose(), 0);
                    bundle.putInt("CONDITION_ALL_KEY", 0);
                    bundle.putSerializable("CONDITION_ALL", dmgO2);
                    fragments.get(4).setArguments(bundle);
                    break;
                case 2:
                    break;
            }
            myPA.updateFragments(fragments);
        }
    }

    //MADE FOR FUTURE DATABASE
            /*
    public void setProfileData() {
        if (!database.getAllDiagnostics().isEmpty()) {
            ArrayList<String> data = database.getAllDiagnostics();
            String[] data2 = new String [5];
            for (int i = 0; i < data.size(); i++){
                data2[i] = data.get(i);
            }
            fragments.get(4).setEditTParams(data2);
            setConditionDiagnose(0, data2);
        }
    */

            /*
    public void setMuscleDatabase(String[] data, boolean whamen) {
        if (whamen) {
            database.insertProfileData(data[0], data[1], data[2], data[3], "Whamen");
        } else {
            database.insertProfileData(data[0], data[1], data[2], data[3], "Man");
        }
    }
*/

}
