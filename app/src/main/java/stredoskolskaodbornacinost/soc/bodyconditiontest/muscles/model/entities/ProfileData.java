package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Contains metadata about article, text itself is in
 */
@Entity(tableName = "profile")
public class ProfileData {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "profile_id")
    public int profileId = 0;

    public String name;
    public String lastname;
    public int age;
    public int weight;
    public int height;
    public boolean whamen;
}
