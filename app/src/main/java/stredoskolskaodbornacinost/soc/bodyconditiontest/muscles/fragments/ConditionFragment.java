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
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.DamageObjects;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.adapters.DamageListAdapter;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.model.entities.ProfileData;


public class ConditionFragment extends Fragment {

    private ImageView bodyImage;
    private TextView mainText;
    private View view;
    private ProfileData profData;

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

        ArrayList<DamageObjects> dmgObjs = new ArrayList<DamageObjects>();

        if (getArguments() != null) {
            if (getArguments().containsKey("CONDITION_ALL_KEY") && getArguments().containsKey("CONDITION_ALL")) {
                Bundle bundle = getArguments();
                ListView layout = (ListView)view.findViewById(R.id.statusBodyContainer);
                dmgObjs.add((DamageObjects) bundle.getSerializable("CONDITION_ALL"));

                switch (bundle.getInt("CONDITION_ALL")) {
                    case 0:
                        DamageListAdapter damageListAdapter = new DamageListAdapter(getActivity(), dmgObjs);
                        layout.setAdapter(damageListAdapter);
                        break;
                }
            }
        }


        return view;
    }
}