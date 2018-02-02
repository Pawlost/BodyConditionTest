package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import stredoskolskaodbornacinost.soc.bodyconditiontest.*;

public class ExerciseActivity extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_firstaid, container, false);
    }
}
