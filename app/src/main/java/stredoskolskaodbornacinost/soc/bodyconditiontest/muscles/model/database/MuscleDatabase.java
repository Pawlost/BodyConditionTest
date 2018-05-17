package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.model.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

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

    public static MuscleDatabase save(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context, MuscleDatabase.class, "profile").build();
        }
        return instance;
    }

    public static MuscleDatabase load(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, MuscleDatabase.class, "profile").allowMainThreadQueries().build();
        }
        return instance;
    }


    /* =============================================================================================
     * Migrations and Callbacks
     * =============================================================================================
     */

    /*static final RoomDatabase.Callback DB_CALLBACK = new RoomDatabase.Callback() {
        public void onCreate(SupportSQLiteDatabase db) {
            /* Here is insertion of initial data. Insertion take place at first run of the app.
             * For now, only testing data are inserted. No real one.

                ContentValues values = new ContentValues();
                values.put("name", "Pawlost");
                values.put("lastname", "Bestos");
                values.put("age", 15);
                values.put("weight", 70);
                values.put("height", 200);
                 values.put("whamen", false);
                db.insert("profile", SQLiteDatabase.CONFLICT_FAIL, values);
        }
    }; */
}
