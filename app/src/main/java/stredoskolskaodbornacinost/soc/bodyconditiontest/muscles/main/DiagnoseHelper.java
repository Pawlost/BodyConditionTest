package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import stredoskolskaodbornacinost.soc.bodyconditiontest.R;

public class DiagnoseHelper {

    private float BMIndex = 0f;
    private int value;

    public float createBMIndex(int weight, int height) {

        this.BMIndex = BMIndex;
        if (height > 0 && weight > 0) {
            float tHeight = (float)(height) / 100;
            BMIndex = weight / (tHeight * tHeight);

            if (BMIndex >= 40) {
                value = 7;
            }else if (BMIndex >= 35 && BMIndex < 40) {
                value = 6;
            }else if (BMIndex >= 30 && BMIndex < 35) {
                value = 5;
            }else if (BMIndex >= 25 && BMIndex < 30) {
                value = 4;
            }else if (BMIndex >= 18.5f && BMIndex < 25) {
                value = 3;
            } else if (BMIndex >= 16 && BMIndex < 18.5f) {
                value = 2;
            } else if (BMIndex >= 15 && BMIndex < 16) {
                value = 1;
            } else if (BMIndex < 15) {
                value = 0;
            }
        } else{
            BMIndex = 0f;
        }
        return BMIndex;
    }

    public String getBMIDiagnose() {
        String diagnose = "";
        switch (value) {
            case 7:
                diagnose = "Obezita III. stupně";
                break;
            case 6:
                diagnose = "Obezita II. stupně";
                break;
            case 5:
                diagnose = "Obezita I. stupně";
                break;
            case 4:
                diagnose = "Nadváha";
                break;
            case 3:
                diagnose = "Normální";
                break;
            case 2:
                diagnose = "Podváha";
                break;
            case 1:
                diagnose = "Vážná podvýživa";
                break;
            case 0:
                diagnose = "Velmi vážná podvýživa";
                break;
        }
        return diagnose;
    }
}
