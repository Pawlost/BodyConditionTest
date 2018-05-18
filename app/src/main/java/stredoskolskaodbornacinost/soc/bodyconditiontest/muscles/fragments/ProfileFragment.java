package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.ArrayList;

import stredoskolskaodbornacinost.soc.bodyconditiontest.*;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.BasicMuscleActivity;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.model.entities.ProfileData;

public class ProfileFragment extends Fragment {

    BasicMuscleActivity mainActivity;
    ArrayList<EditText> profileArray;
    private ProfileData profData;
    private RadioButton whamenButton;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        profileArray = new ArrayList<>();
        mainActivity = (BasicMuscleActivity) getActivity();

        profileArray.add((EditText) view.findViewById(R.id.editJmeno));
        profileArray.add((EditText) view.findViewById(R.id.editPrijmeni));
        profileArray.add((EditText) view.findViewById(R.id.editVek));
        profileArray.add((EditText) view.findViewById(R.id.editVaha));
        profileArray.add((EditText) view.findViewById(R.id.editVyska));
        whamenButton = view.findViewById(R.id.whameButton);

        profData = ((BasicMuscleActivity) getActivity()).getProfileData();

        if(profData != null) {
            initText();
            if(profData.whamen){
               whamenButton.setChecked(true);
            }else{
               RadioButton manButton = view.findViewById(R.id.manButton);
               manButton.setChecked(true);
            }
        }
        this.view = view;

        Button fronButton = view.findViewById(R.id.saveProfButton);

        fronButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProf();
            }
        });

        return view;
    }
//Updates text from database text
    private void initText() {
        profileArray.get(0).setText(profData.name);
        profileArray.get(1).setText(profData.lastname);
        profileArray.get(2).setText(String.valueOf(profData.age));
        profileArray.get(3).setText(String.valueOf(profData.weight));
        profileArray.get(4).setText(String.valueOf(profData.height));
    }

    @Override
    public void onPause(){
        super.onPause();
        saveProf();
    }

    public void saveProf(){
        profData = new ProfileData();
        profData.name = profileArray.get(0).getText().toString();
        profData.lastname = profileArray.get(1).getText().toString();
        profData.age = Integer.parseInt(profileArray.get(2).getText().toString());
        profData.weight = Integer.parseInt(profileArray.get(3).getText().toString());
        profData.height = Integer.parseInt(profileArray.get(4).getText().toString());
        profData.whamen = whamenButton.isChecked();

        mainActivity.setConditionDiagnose(new int[]{0, 1}, profData);
    }
}
