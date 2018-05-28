package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main;

import java.math.BigDecimal;

public class DiagnoseHelper {

    private boolean critcalCondition;

    public String[] obesity(int weight, int height){
        float index = createBMIndex(weight, height);
        return new String []{String.valueOf(myRound(index)), getBMIDiagnose(index)};
    }

    private float createBMIndex(int weight, int height) {
        float BMIndex = 0f;
        if (height > 0 && weight > 0) {
            float tHeight = (float)(height) / 100;
            BMIndex = weight / (tHeight * tHeight);
        }
        return BMIndex;
    }

    private String getBMIDiagnose(float BMIndex) {
        String diagnose = "";
        if (BMIndex >= 40) {
            diagnose = "Obezita III. stupně";
            critcalCondition = true;

        }else if (BMIndex >= 35 && BMIndex < 40) {
            diagnose = "Obezita II. stupně";
            critcalCondition = true;

        }else if (BMIndex >= 30 && BMIndex < 35) {
            diagnose = "Obezita I. stupně";
            critcalCondition = true;

        }else if (BMIndex >= 25 && BMIndex < 30) {
            diagnose = "Nadváha";

        }else if (BMIndex >= 18.5f && BMIndex < 25) {
            diagnose = "Normální";

        } else if (BMIndex >= 16 && BMIndex < 18.5f) {
            diagnose = "Podváha";

        } else if (BMIndex >= 15 && BMIndex < 16) {
            diagnose = "Vážná podvýživa";

            critcalCondition = true;
        } else if (BMIndex < 15) {
            diagnose = "Velmi vážná podvýživa";
            critcalCondition = true;

        }
        return diagnose;
    }

    public boolean isCritcalCondition() {
        return critcalCondition;
    }

    //Function for round numbers
    private float myRound(float number) {
        BigDecimal bd = new BigDecimal(Float.toString(number));
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

}
