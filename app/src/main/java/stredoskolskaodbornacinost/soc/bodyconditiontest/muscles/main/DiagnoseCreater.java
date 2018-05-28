package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main;

import java.util.ArrayList;

import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.damage.Obesity;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.model.entities.ProfileData;

public class DiagnoseCreater {

    public ArrayList<DamageObject> get(ProfileData profileData){
        ArrayList<DamageObject> dmgObs = new ArrayList<>();

        //Adds OBESITY diagnose
        if(profileData.height > 0 && profileData.weight > 0) {
            dmgObs.add(new Obesity(profileData.weight, profileData.height));
        }

        return dmgObs;
    }
}
