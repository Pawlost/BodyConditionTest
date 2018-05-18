package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.RadioGroup;

import java.util.ArrayList;

import stredoskolskaodbornacinost.soc.bodyconditiontest.R;

public class MyPagerAdapter extends FragmentPagerAdapter {

    private final static int NUM_FRAGMENT = 5;
    private RadioGroup radGroup;
    private ArrayList<Fragment> fragments;

    public MyPagerAdapter(AppCompatActivity context, RadioGroup radGroup, ArrayList<Fragment> fragments) {
        super(context.getSupportFragmentManager());
        this.radGroup = radGroup;
        this.fragments = fragments;
    }

    @Override
    public void startUpdate(ViewGroup vg) {
        ViewPager vp = (ViewPager) vg.findViewById(R.id.basic_fragment_pager);
        vp.setOffscreenPageLimit(1);
        switch (vp.getCurrentItem()) {
            case 0:
                radGroup.check(R.id.homeButton);
                break;
            case 1:
                radGroup.check(R.id.testsButton);
                break;
            case 2:
                radGroup.check(R.id.firstAidButton);
                break;
            case 3:
                radGroup.check(R.id.conditionButton);
                break;
            case 4:
                radGroup.check(R.id.profilButton);
                break;
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return NUM_FRAGMENT;
    }

    public void updateFragments(ArrayList<Fragment> fragments){
        this.fragments = fragments;
    }
}