package stredoskolskaodbornacinost.soc.bodyconditiontest;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.app.FragmentTransaction;
import android.app.FragmentManager;

public class BasicActivity extends AppCompatActivity {

    private static FragmentManager frM;
    private FragmentTransaction frT;
    private Fragment fr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_activity);

        frM = getFragmentManager();
    }

    public void homeButton(View view) {
        fr = new HomeScreen();
        frT = frM.beginTransaction();
        frT.replace(R.id.main_fragment, fr, null);
        frT.commit();
    }
    public void testButton(View view) {
        fr = new UserTests();
        frT = frM.beginTransaction();
        frT.replace(R.id.main_fragment, fr, null);
        frT.commit();
    }
    public void exerciseButton(View view) {
        fr = new ExerciseActivity();
        frT = frM.beginTransaction();
        frT.replace(R.id.main_fragment, fr, null);
        frT.commit();
    }
    public void statisticsButton(View view) {
        fr = new StatisticsActivity();
        frT = frM.beginTransaction();
        frT.replace(R.id.main_fragment, fr, null);
        frT.commit();
    }
    public void profilButton(View view) {
        fr = new ProfileActivity();
        frT = frM.beginTransaction();
        frT.replace(R.id.main_fragment, fr, null);
        frT.commit();
    }
}
