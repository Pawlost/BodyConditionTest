package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments;
<<<<<<< HEAD:app/src/main/java/stredoskolskaodbornacinost/soc/bodyconditiontest/muscles/fragments/ConditionFragment.java
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
=======
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
>>>>>>> master:app/src/main/java/stredoskolskaodbornacinost/soc/bodyconditiontest/muscles/fragments/ConditionActivity.java
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import stredoskolskaodbornacinost.soc.bodyconditiontest.*;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.status.BackManFragment;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.status.FrontManFragment;


public class ConditionFragment extends Fragment {

    private static FragmentManager frM;
    private FragmentTransaction frT;
    private FrontManFragment frontMan;
    private BackManFragment backMan;
    View view;
    ImageButton frontB;
    ImageButton backB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_condition, container, false);
        if(getArguments().containsKey("CONDITION_ALL")){
            frontMan.setArguments(savedInstanceState);
            backMan.setArguments(savedInstanceState);
        }

        frontB = view.findViewById(R.id.front);
        backB = view.findViewById(R.id.back);

        //Set buttons to work
        frontB.setOnClickListener(new View.OnClickListener() {
            @Override
<<<<<<< HEAD:app/src/main/java/stredoskolskaodbornacinost/soc/bodyconditiontest/muscles/fragments/ConditionFragment.java
            public void onClick(View v)
            {
                switchFragment(frontMan);
=======
            public void onClick(View v) {
                switchFragment();
>>>>>>> master:app/src/main/java/stredoskolskaodbornacinost/soc/bodyconditiontest/muscles/fragments/ConditionActivity.java
            }
        });
        backB.setOnClickListener(new View.OnClickListener() {
            @Override
<<<<<<< HEAD:app/src/main/java/stredoskolskaodbornacinost/soc/bodyconditiontest/muscles/fragments/ConditionFragment.java
            public void onClick(View v)
            {
                switchFragment(backMan);
            }
        });

        Fragment fr = new FrontManFragment();
        switchFragment(fr);
=======
            public void onClick(View v) {
                switchFragment();
            }
        });
        switchFragment();
>>>>>>> master:app/src/main/java/stredoskolskaodbornacinost/soc/bodyconditiontest/muscles/fragments/ConditionActivity.java

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (frM.findFragmentByTag("muscle_fragment") != null) {
            frT.remove(frM.findFragmentByTag("muscle_fragment"));
        }
    }

    public void switchFragment() {
        frT = frM.beginTransaction();
        Fragment fr;
        if (frM.findFragmentByTag("FrontMan_fragment") != null) {
            frT.remove(frM.findFragmentByTag("FrontMan_fragment"));
            fr = new BackManFragment();
            frT.add(R.id.muscle_fragment_container, fr, "BackMan_fragment");
        } else {
            if (frM.findFragmentByTag("BackMan_fragment") != null) frT.remove(frM.findFragmentByTag("BackMan_fragment"));
            fr = new FrontManFragment();
            frT.add(R.id.muscle_fragment_container, fr, "FrontMan_fragment");
        }
        frT.commit();
    }
}
