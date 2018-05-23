package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Objects;

import stredoskolskaodbornacinost.soc.bodyconditiontest.*;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.DamageObjects;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.adapters.DamageListAdapter;

public class HomeScreenFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_homescreen, container, false);

        if (getArguments() != null) {
            if (getArguments().containsKey("PROFILE_NAME")) {
                Bundle bundle = getArguments();
                TextView welcomeText = (TextView)view.findViewById(R.id.welcomeText);
                String name = Objects.requireNonNull(bundle.getStringArray("PROFILE_NAME"))[0];
                String lastname = Objects.requireNonNull(bundle.getStringArray("PROFILE_NAME"))[1];
                welcomeText.setText(getContext().getResources().getString(R.string.welcome_string) + " "
                + name + " " + lastname);
            }
        }

        return view;
    }
}
