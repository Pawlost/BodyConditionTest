package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import stredoskolskaodbornacinost.soc.bodyconditiontest.*;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.status.BackManActivity;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.status.FrontManActivity;


public class ConditionActivity extends Fragment {

    private static FragmentManager frM;
    private FragmentTransaction frT;
    private Fragment fr;

    View view;
    Button frontB;
    Button backB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_condition, container, false);
        frM = getFragmentManager();

        frontB = (Button) view.findViewById(R.id.front);
        backB = (Button) view.findViewById(R.id.back);

        //Set buttons to work
        frontB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                fr = new FrontManActivity();
                switchFragment(fr);
            }
        });
        backB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                fr = new BackManActivity();
                switchFragment(fr);
            }
        });

        Fragment fr = new FrontManActivity();
        switchFragment(fr);

        return view;
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        if(frM.findFragmentByTag("muscle_fragment") != null){
            frT.remove(frM.findFragmentByTag("muscle_fragment"));
        }
    }
    public void switchFragment(Fragment fr){
        frT = frM.beginTransaction();
        if(frM.findFragmentByTag("muscle_fragment") != null){
            frT.remove(frM.findFragmentByTag("muscle_fragment"));
        }
        frT.add(R.id.muscle_fragment_container, fr, "muscle_fragment");
        frT.commit();
    }
}
