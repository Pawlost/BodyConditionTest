package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import stredoskolskaodbornacinost.soc.bodyconditiontest.R;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.DamageObjects;

/**
 * Created by balda on 23.03.2018.
 */

public class DamageListAdapter extends ArrayAdapter<DamageObjects> {

    public DamageListAdapter(Context context, ArrayList<DamageObjects> dmg) {
        super(context, 0, dmg);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DamageObjects dam = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.damage_layout, parent, false);
        }

        TextView mainTitle = (TextView) convertView.findViewById(R.id.mainTitle);
        TextView valueText = (TextView) convertView.findViewById(R.id.diagnoseValue);
        TextView diagnoseValue = (TextView) convertView.findViewById(R.id.setDiagnose);

        if(dam.getMainTitle() != null){
            mainTitle.setText(dam.getMainTitle());
        }
        if(dam.getValue() != null) {
            valueText.setText(R.string.diagnose_value_string + dam.getValue());
        }
        if(dam.getDiagnose() != null) {
            diagnoseValue.setText(R.string.set_diagnose_string_lg + dam.getDiagnose());
        }

        return convertView;
    }
}
