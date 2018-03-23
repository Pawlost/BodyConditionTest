package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.ArrayList;

import stredoskolskaodbornacinost.soc.bodyconditiontest.*;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.Model.Damage.DamageObject;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.BasicMuscleActivity;

public class ProfileFragment extends Fragment {

    BasicMuscleActivity mainActivity;
    ArrayList<EditText> profileData;
    private boolean whamen;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        profileData = new ArrayList<>();
        mainActivity = (BasicMuscleActivity) getActivity();

        profileData.add((EditText) view.findViewById(R.id.editJmeno));
        profileData.add((EditText) view.findViewById(R.id.editPrijmeni));
        profileData.add((EditText) view.findViewById(R.id.editVaha));
        profileData.add((EditText) view.findViewById(R.id.editVyska));

        this.view = view;
        return view;
    }

    @Override
    public void onPause(){
        super.onPause();

        whamen = view.findViewById(R.id.whameButton).isActivated();
        String[] data = new String[profileData.size()];
        for (int i=0; i<profileData.size(); i++)
        {
            if (profileData.get(i).getText().toString() == ""){
                profileData.get(i).setText("0");
            }
            data[i] = profileData.get(i).getText().toString();
        }
        mainActivity.setConditionDiagnose(0, data);
    }
    //MADE FOR DATABASE
        /*
    public void setEditTParams(String[] data){
        name.setText(data[0]);
        lastname.setText(data[1]);
        weight.setText(data[2]);
        height.setText(data[3]);
        if(data[4]=="whamen"){
            view.findViewById(R.id.whameButton).setPressed(true);
        }
    }
    */
}
