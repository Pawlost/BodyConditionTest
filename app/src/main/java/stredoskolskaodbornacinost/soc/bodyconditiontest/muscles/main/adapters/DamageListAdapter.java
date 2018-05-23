package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import stredoskolskaodbornacinost.soc.bodyconditiontest.R;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.DamageObject;

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
        TextView valueText = (TextView) convertView.findViewById(R.id.diagnoseText);

        if (dam.isCriticalCondition()){
            mainTitle.setTextColor(Color.RED);
            valueText.setTextColor(Color.RED);
        }

        if(dam.getMainTitle() != null){
            mainTitle.setText(dam.getMainTitle());
        }
        if(dam.getText() != null) {
            valueText.setText(dam.getText());
        }

        return convertView;
    }
}
