package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;

import stredoskolskaodbornacinost.soc.bodyconditiontest.*;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.Model.Damage.DamageObject;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.BasicMuscleActivity;

public class ProfileFragment extends Fragment {

    BasicMuscleActivity mainActivity;
    EditText name;
    EditText lastname;
    EditText weight;
    EditText height;
    private boolean whamen;
    View view;

    private String[] data = new String[4];
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        mainActivity = (BasicMuscleActivity) getActivity();
        name = (EditText) view.findViewById(R.id.editJmeno);
        lastname = view.findViewById(R.id.editPrijmeni);
        weight = view.findViewById(R.id.editVaha);
        height = view.findViewById(R.id.editVyska);

        this.view = view;
        return view;
    }
    public void setEditTParams(String[] data){
        name.setText(data[0]);
        lastname.setText(data[1]);
        weight.setText(data[2]);
        height.setText(data[3]);
        if(data[4]=="whamen"){
            view.findViewById(R.id.whameButton).setPressed(true);
        }
    }
    @Override
    public void onPause(){
        super.onPause();
        whamen = view.findViewById(R.id.whameButton).isActivated();
        data[0] = name.getText().toString();
        data[1] = lastname.getText().toString();
        if(weight.getText().toString() != "" && height.getText().toString() != "") {
            data[2] = weight.getText().toString();
            data[3] = height.getText().toString();
        }else{
            data[2] = "0";
            data[3] = "0";
        }
        mainActivity.setMuscleDatabase(data, whamen);
        mainActivity.setConditionDiagnose(1, data);
    }
}
