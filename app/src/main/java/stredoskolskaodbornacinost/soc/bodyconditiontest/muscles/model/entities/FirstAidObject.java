package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "firstaid")
public class FirstAidObject {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "first_aid_id")
    public int firstaidId = 0;

    public int ID;
    public String title;
    public String text;
    public boolean critical = false;
}
