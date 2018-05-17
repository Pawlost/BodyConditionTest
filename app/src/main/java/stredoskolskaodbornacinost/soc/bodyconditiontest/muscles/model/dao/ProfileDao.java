package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.model.entities.ProfileData;

/**
 * Object defining operations over the database
 */
@Dao
public interface ProfileDao {

    /**
     * Fetch articles
     * @return Array of all articles in the database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProfile(ProfileData... profileData);

    @Query("SELECT * FROM profile")
    ProfileData[] getProfile();
}
