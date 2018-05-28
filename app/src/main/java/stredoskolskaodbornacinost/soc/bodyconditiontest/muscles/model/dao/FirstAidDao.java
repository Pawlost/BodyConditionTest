package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.model.entities.FirstAidObject;

@Dao
public interface FirstAidDao {
    @Query("SELECT * FROM firstaid")
    FirstAidObject[] getFirstAid();
}
