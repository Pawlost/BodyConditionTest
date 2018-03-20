package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import stredoskolskaodbornacinost.soc.bodyconditiontest.*;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.Model.Damage.DamageObject;

public class HomeScreenFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_homescreen, container, false);
    }
}
    class DamageListAdapter extends ArrayAdapter<DamageObject> {
        public DamageListAdapter(Context context, ArrayList<DamageObject> art) {
            super(context, 0, art);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            DamageObject dam = getItem(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.damage_layout, parent, false);
            }

            TextView mainTitle = (TextView) convertView.findViewById(R.id.mainTitle);
            TextView valueText = (TextView) convertView.findViewById(R.id.Value);
            TextView diagnoseValue = (TextView) convertView.findViewById(R.id.setDiagnose);

            if (dam.getMainTitle() != null) {
                mainTitle.setText("Nazev testu " + dam.getMainTitle());
            }
            if (dam.getValue() != null) {
                valueText.setText("Tvůj čas pro čtení je: " + dam.getValue());
            }
            if (dam.getDiagnose() != null) {
                diagnoseValue.setText("Tvůj čas pro čtení je: " + dam.getDiagnose());
            }

            return convertView;
        }
    }
