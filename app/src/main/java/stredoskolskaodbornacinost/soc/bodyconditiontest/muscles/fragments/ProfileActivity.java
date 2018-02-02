package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import stredoskolskaodbornacinost.soc.bodyconditiontest.*;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.BCTMuscleHelper;

public class ProfileActivity extends Fragment {

    private BCTMuscleHelper database;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        database = new BCTMuscleHelper(this.getContext());
        return view;
    }
}
