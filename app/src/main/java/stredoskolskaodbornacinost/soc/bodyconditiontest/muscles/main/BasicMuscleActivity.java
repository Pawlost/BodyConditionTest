package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.app.FragmentTransaction;
import android.app.FragmentManager;

import stredoskolskaodbornacinost.soc.bodyconditiontest.*;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.ConditionActivity;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.ExerciseActivity;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.HomeScreen;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.ProfileActivity;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.UserTests;

public class BasicMuscleActivity extends AppCompatActivity {

    private static FragmentManager frM;
    private FragmentTransaction frT;
    private Fragment fr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        frM = getFragmentManager();

        Fragment fr = new HomeScreen();
        switchFragment(fr);
    }
    public void switchFragment(Fragment fr){
        frT = frM.beginTransaction();
        if(frM.findFragmentByTag("new_fragment") != null){
            frT.remove(frM.findFragmentByTag("new_fragment"));
        }
        frT.add(R.id.basic_fragment_container, fr, "new_fragment");
        frT.commit();
    }
    public void homeButton(View view) {
        fr = new HomeScreen();
        switchFragment(fr);
    }
    public void testButton(View view) {
        fr = new UserTests();
        switchFragment(fr);
    }
    public void exerciseButton(View view) {
        fr = new ExerciseActivity();
        switchFragment(fr);
    }
    public void conditionButton(View view) {
        fr = new ConditionActivity();
        switchFragment(fr);
    }
    public void profilButton(View view) {
        fr = new ProfileActivity();
        switchFragment(fr);
    }
}
