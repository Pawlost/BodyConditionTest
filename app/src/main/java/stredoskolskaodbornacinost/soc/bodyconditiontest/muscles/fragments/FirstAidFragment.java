package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import stredoskolskaodbornacinost.soc.bodyconditiontest.*;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.DamageObject;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.adapters.DamageListAdapter;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.adapters.FirstAidListAdapter;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.model.entities.FirstAidObject;

public class FirstAidFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_firstaid, container, false);

        if (getArguments() != null) {
            if (getArguments().containsKey("FIRST_AID_ALL")) {
                Bundle bundle = getArguments();

                ListView layout = (ListView) view.findViewById(R.id.firstAidListNormal);
                ArrayList<FirstAidObject> faos = (ArrayList<FirstAidObject>) bundle.getSerializable("FIRST_AID_ALL");
                FirstAidListAdapter faListAdapter = new FirstAidListAdapter(getActivity(), faos);
                layout.setAdapter(faListAdapter);
            }
        }
        return view;
    }
}
