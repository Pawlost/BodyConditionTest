package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import stredoskolskaodbornacinost.soc.bodyconditiontest.*;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.status.BackManFragment;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.status.FrontManFragment;


public class ConditionActivity extends Fragment {

    private static FragmentManager frM;
    private FragmentTransaction frT;
    private Fragment fr;

    View view;
    ImageButton frontB;
    ImageButton backB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_condition, container, false);
        frM = getFragmentManager();

        frontB = view.findViewById(R.id.front);
        backB = view.findViewById(R.id.back);

        //Set buttons to work
        frontB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment();
            }
        });
        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment();
            }
        });
        switchFragment();

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
