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
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.model.entities.FirstAidObject;

/**
 * Created by balda on 23.03.2018.
 */

public class FirstAidListAdapter extends ArrayAdapter<FirstAidObject> {

    public FirstAidListAdapter(Context context, ArrayList<FirstAidObject> dmg) {
        super(context, 0, dmg);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        FirstAidObject fa = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.firstaid_list_layout, parent, false);
        }

        TextView mainTitle = (TextView) convertView.findViewById(R.id.mainTitle);

        if(fa.title != null){
            mainTitle.setText(fa.title);
        }

        return convertView;
    }
}
