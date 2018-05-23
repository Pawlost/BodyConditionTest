package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import stredoskolskaodbornacinost.soc.bodyconditiontest.*;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.DamageObject;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.adapters.DamageListAdapter;


public class ConditionFragment extends Fragment {

    private ImageView bodyImage;
    private TextView mainText;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_condition, container, false);
        bodyImage = (ImageView) view.findViewById(R.id.bodyImage);
        mainText = (TextView) view.findViewById(R.id.bodyPartText);

        ImageButton fronButton = (ImageButton) view.findViewById(R.id.frontManButton);
        ImageButton backButton = (ImageButton) view.findViewById(R.id.backManButton);

        fronButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                bodyImage.setImageResource(R.drawable.human_body);
                mainText.setText("Přední část");
            }
        });
        backButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                bodyImage.setImageResource(R.drawable.human_back);
                mainText.setText("Zadní část");
            }
        });

        if (getArguments() != null) {
            if (getArguments().containsKey("CONDITION_ALL")) {
                Bundle bundle = getArguments();

                ListView layout = (ListView) view.findViewById(R.id.statusBodyContainer);
                ArrayList<DamageObject> dmgObjs = (ArrayList<DamageObject>) bundle.getSerializable("CONDITION_ALL");
                DamageListAdapter damageListAdapter = new DamageListAdapter(getActivity(), dmgObjs);
                layout.setAdapter(damageListAdapter);
            }
        }
        return view;
    }
}