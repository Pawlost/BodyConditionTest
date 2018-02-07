package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.status;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import stredoskolskaodbornacinost.soc.bodyconditiontest.*;

public class FrontManFragment extends Fragment {
private FragmentManager frM;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int value = 0;
        if (getArguments().containsKey("CONDITION_ALL")) {
            value = getArguments().getInt("CONDITION_ALL");
        }
        switch (value){
            case 1:

                break;

        }
        frM = getS
        return inflater.inflate(R.layout.lesserfragment_frontman, container, false);
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
