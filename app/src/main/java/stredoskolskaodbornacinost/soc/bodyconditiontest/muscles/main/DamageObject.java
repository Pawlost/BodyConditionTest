package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main;

import java.io.Serializable;

public class DamageObject implements Serializable {
    protected String mainTitle;
    protected String text;
    protected boolean criticalCondition;

    public boolean isCriticalCondition() {
        return criticalCondition;
    }

    public String getText() {
        return this.text;
    }

    public String getMainTitle() {
        return this.mainTitle;
    }
}
