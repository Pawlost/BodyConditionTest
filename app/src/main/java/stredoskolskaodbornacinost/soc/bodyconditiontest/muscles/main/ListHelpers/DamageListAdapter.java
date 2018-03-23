package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.ListHelpers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import stredoskolskaodbornacinost.soc.bodyconditiontest.R;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.Model.Damage.DamageObject;

/**
 * Created by balda on 23.03.2018.
 */

public class DamageListAdapter extends ArrayAdapter<DamageObject> {
    public DamageListAdapter(Context context, ArrayList<DamageObject> dmg) {
        super(context, 0, dmg);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DamageObject dam = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.damage_layout, parent, false);
        }

        TextView mainTitle = (TextView) convertView.findViewById(R.id.mainTitle);
        TextView valueText = (TextView) convertView.findViewById(R.id.Value);
        TextView diagnoseValue = (TextView) convertView.findViewById(R.id.setDiagnose);

        if(dam.getMainTitle() != null){
            mainTitle.setText(dam.getMainTitle());
        }
        if(dam.getValue() != null) {
            valueText.setText("Tvůj BMI index je: " + dam.getValue());
        }
        if(dam.getDiagnose() != null) {
            diagnoseValue.setText("Diagnoza je: " + dam.getDiagnose());
        }

        return convertView;
    }
}
