package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.Model.Damage;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by balda on 20.03.2018.
 */

public class DamageObject implements Serializable {
    private final String mainTitle;
    private final String value;
    private final String diagnose;
    private final int index;

    public DamageObject(String title, String value, String diagnose, int index) {
        this.mainTitle = title;
        this.value=value;
        this.diagnose = diagnose;
        this.index = index;
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
    public int getIndex() {
        return this.index;
    }
}
