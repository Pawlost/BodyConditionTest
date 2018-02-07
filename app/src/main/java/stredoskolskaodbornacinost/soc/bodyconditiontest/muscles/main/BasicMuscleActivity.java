package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.app.FragmentTransaction;
import android.app.FragmentManager;

import stredoskolskaodbornacinost.soc.bodyconditiontest.*;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.ConditionFragment;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.FirstAidFragment;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.HomeScreenFragment;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.ProfileFragment;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.UserTestsFragment;

public class BasicMuscleActivity extends AppCompatActivity {
    private BCTMuscleHelper database;
    private static FragmentManager frM;
    private Fragment fr;
    private HomeScreenFragment homeScreen;
    private ConditionFragment conditionScreen;
    private FirstAidFragment firsAidScreen;
    private UserTestsFragment userTestsScreen;
    private ProfileFragment profileScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        frM = getFragmentManager();

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
    }
}
