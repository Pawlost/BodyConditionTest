package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import stredoskolskaodbornacinost.soc.bodyconditiontest.*;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.BCTMuscleHelper;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.BasicMuscleActivity;

public class ProfileActivity extends Fragment {

    BasicMuscleActivity mainActivity;

    private EditText editName;
    private EditText editLastName;
    private EditText editWeight;
    private EditText editHeight;
    private RadioButton whamenButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        mainActivity = (BasicMuscleActivity) getActivity();

        editName = (EditText) view.findViewById(R.id.editJmeno);
        editLastName = (EditText) view.findViewById(R.id.editPrijmeni);
        editWeight = (EditText) view.findViewById(R.id.editVaha);
        editHeight = (EditText) view.findViewById(R.id.editVyska);
        whamenButton = (RadioButton) view.findViewById(R.id.whameButton);
        return view;
    }
    @Override
    public void onStop(){
        super.onStop();
        mainActivity.saveToDatabase(editName.getText().toString(), editLastName.getText().toString(), Integer.parseInt(editWeight.getText().toString()),
                Integer.parseInt(editWeight.getText().toString()), whamenButton.isChecked());
    }
}
