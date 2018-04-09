package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.model.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.model.dao.ProfileDao;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.model.entities.ProfileData;

/**
 * Object representing database with DAOs. Act as singleton.
 */
@Database(entities = {ProfileData.class}, version = 1)
public abstract class MuscleDatabase extends RoomDatabase {
    private static MuscleDatabase instance;

    // Declare all DAOs
    public abstract ProfileDao profileDao();

    public static MuscleDatabase getDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, MuscleDatabase.class, "profile").build();
        }
        return instance;
    }

}
