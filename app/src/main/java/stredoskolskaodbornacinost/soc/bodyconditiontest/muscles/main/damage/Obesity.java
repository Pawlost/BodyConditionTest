package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.damage;

import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.DamageObject;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.DiagnoseHelper;

public class Obesity extends DamageObject {
    public static final int OBESITY_ID = 1;

    public Obesity(int weight, int height) {
        mainTitle = "BMI Index";
        ID = OBESITY_ID;
        DiagnoseHelper diagnoseHelper = new DiagnoseHelper();
        String[] diagnose = diagnoseHelper.obesity(weight, height);
        text = "Váš BMI index je: " + diagnose[0] + "\n"
                +"Diagnoza je: " + diagnose[1];
        criticalCondition = diagnoseHelper.isCritcalCondition();
    }
}
