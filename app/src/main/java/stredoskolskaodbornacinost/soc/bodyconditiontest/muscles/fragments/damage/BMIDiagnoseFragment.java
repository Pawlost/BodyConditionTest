package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.fragments.damage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import stredoskolskaodbornacinost.soc.bodyconditiontest.R;

public class BMIDiagnoseFragment extends Fragment {

    public float BMIndex = 0f;
    public int height;
    public int weight;
    private int value;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.lesserfragment_bmi, container, false);
    }

    public void createBMIndex(int weight, int height) {
        this.weight = weight;
        this.height = height;

        this.BMIndex = BMIndex;
        if (height <= 0 && weight <= 0) {
            float tHeight = height / 100;
            BMIndex = weight / (tHeight * tHeight);
        }
    }

    public void setDiagnosis(float BMIndex) {
        if (BMIndex >= 30) {
            value = 3;
        } else if (BMIndex >= 26 && BMIndex < 30) {
            value = 0;
        } else if (BMIndex >= 19 && BMIndex < 26) {
            value = 2;
        } else if (BMIndex < 19) {
            value = 1;
        }
    }

    public String getWeightString() {
        String diagnose = "";
        switch (value) {
            case 3:
                diagnose = "Obesita";
                break;
            case 2:
                diagnose = "Nadváha";
                break;
            case 1:
                diagnose = "Podváha";
                break;
            case 0:
                diagnose = "Normální";
                break;
        }
        return diagnose;
    }

    public float getBMIndex() {
        if (BMIndex <= 0f) {
            return 0f;
        } else {
            return BMIndex;
        }
    }
}
