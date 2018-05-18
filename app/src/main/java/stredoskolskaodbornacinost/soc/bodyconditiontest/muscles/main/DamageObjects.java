package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main;

import java.io.Serializable;

public class DamageObjects implements Serializable {
    private final String mainTitle;
    private final String value;
    private final String diagnose;

    public DamageObjects(String title, String value, String diagnose) {
        this.mainTitle = title;
        this.value = value;
        this.diagnose = diagnose;
    }

    public String getDiagnose() {
        return this.diagnose;
    }

    public String getValue() {
        return this.value;
    }

    public String getMainTitle() {
        return this.mainTitle;
    }
}
