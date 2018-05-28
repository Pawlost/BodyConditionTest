package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.model.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.*;
import android.database.sqlite.SQLiteDatabase;

import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.main.damage.Obesity;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.model.dao.FirstAidDao;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.model.dao.ProfileDao;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.model.entities.FirstAidObject;
import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.model.entities.ProfileData;

/**
 * Object representing database with DAOs. Act as singleton.
 */
@Database(entities = {ProfileData.class, FirstAidObject.class},version = 2 )
public abstract class MuscleDatabase extends RoomDatabase {

    private static MuscleDatabase instance;

    // Declare all DAOs
    public abstract ProfileDao profileDao();
    public abstract FirstAidDao firstAidDao();

    public static MuscleDatabase getPreBuildedDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, MuscleDatabase.class, "firstaid").fallbackToDestructiveMigration()
                    .allowMainThreadQueries().addCallback(DB_CALLBACK).build();
        }
        return instance;
    }

    public static MuscleDatabase save(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context, MuscleDatabase.class, "profile").fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    public static MuscleDatabase load(Context context) {
    //    instance = null;
        if (instance == null) {
            instance = Room.databaseBuilder(context, MuscleDatabase.class, "profile").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instance;
    }


    /* =============================================================================================
     * Migrations and Callbacks
     * =============================================================================================
     */

    static final RoomDatabase.Callback DB_CALLBACK = new RoomDatabase.Callback() {
        public void onCreate(SupportSQLiteDatabase db) {
            /* Here is insertion of initial data. Insertion take place at first run of the app.
             * For now, only testing data are inserted. No real one.
             */
                ContentValues values = new ContentValues();
            values.put("ID", Obesity.OBESITY_ID);
            values.put("title", "Obezita");
            values.put("text", "Zhubni");
            values.put("critical", false);
            db.insert("firstaid", SQLiteDatabase.CONFLICT_FAIL, values);

          /*  ContentValues values1 = new ContentValues();
            values1.put("name", "xxx");
            values1.put("lastname", "xxx");
            values1.put("age", 10);
            values1.put("weight", 10);
            values1.put("height", 10);
            values1.put("whamen", false);
            db.insert("profile", SQLiteDatabase.CONFLICT_FAIL, values1);
            */
        }
    };
}
