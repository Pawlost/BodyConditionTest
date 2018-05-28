package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main;

import java.io.Serializable;

public class DamageObject{

    protected int ID;
    protected String mainTitle;
    protected String text;
    protected boolean criticalCondition;

    public int getID() {
        return ID;
    }

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
