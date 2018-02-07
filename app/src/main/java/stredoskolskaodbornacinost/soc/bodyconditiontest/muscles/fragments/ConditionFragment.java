package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import stredoskolskaodbornacinost.soc.bodyconditiontest.*;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.status.BackManFragment;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.status.FrontManFragment;


public class ConditionFragment extends Fragment {

    private static FragmentManager frM;
    private FragmentTransaction frT;
    private FrontManFragment frontMan;
    private BackManFragment backMan;
    View view;
    Button frontB;
    Button backB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_condition, container, false);
        if(getArguments().containsKey("CONDITION_ALL")){
            frontMan.setArguments(savedInstanceState);
            backMan.setArguments(savedInstanceState);
        }

        frontB = (Button) view.findViewById(R.id.front);
        backB = (Button) view.findViewById(R.id.back);

        //Set buttons to work
        frontB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switchFragment(frontMan);
            }
        });
        backB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switchFragment(backMan);
            }
        });

        Fragment fr = new FrontManFragment();
        switchFragment(fr);

        return view;
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        if(frM.findFragmentByTag("muscle_fragment") != null){
            frT.remove(frM.findFragmentByTag("muscle_fragment"));
        }
    }
    public void switchFragment(Fragment fr){
        frT = frM.beginTransaction();
        if(frM.findFragmentByTag("muscle_fragment") != null){
            frT.remove(frM.findFragmentByTag("muscle_fragment"));
        }
        frT.add(R.id.muscle_fragment_container, fr, "muscle_fragment");
        frT.commit();
    }
}
