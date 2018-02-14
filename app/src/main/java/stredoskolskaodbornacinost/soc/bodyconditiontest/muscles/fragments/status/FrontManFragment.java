package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.status;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import stredoskolskaodbornacinost.soc.bodyconditiontest.*;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.damage.BMIDiagnoseFragment;

public class FrontManFragment extends Fragment {
    private FragmentManager frM;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.lesserfragment_frontman, container, false);
        if (getArguments().containsKey("CONDITION_ALL")) {
            Bundle bundle = getArguments();
            switch (bundle.getInt("CONDITION_ALL")) {
                case 1:
                    createDiagnosisFragment(new BMIDiagnoseFragment());
                    break;
            }
        }
        return view;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        FragmentTransaction frT = frM.beginTransaction();
        if (frM.findFragmentByTag("BMIDiagnosis_fragment") != null) {
            frT.remove(frM.findFragmentByTag("BMIDiagnosis_fragment"));
        }
        frT.commit();
    }
    public void createDiagnosisFragment(Fragment fr){
        FragmentTransaction frT = frM.beginTransaction();
        if(frM.findFragmentByTag("BMIDiagnosis_fragment") != null){
            frT.remove(frM.findFragmentByTag("BMIDiagnosis_fragment"));
        }
        frT.add(R.id.muscle_fragment_container, fr, "BMIDiagnosis_fragment");
        frT.commit();
    }
    public void setDiagonosisFragmentManager(AppCompatActivity context){
        frM = context.getSupportFragmentManager();
    }
}
