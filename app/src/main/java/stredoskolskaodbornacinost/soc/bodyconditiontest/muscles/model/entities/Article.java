package stredoskolskaodbornacinost.soc.bodyconditiontest.muscles.model.entities;

        import android.arch.persistence.room.ColumnInfo;
        import android.arch.persistence.room.Entity;
        import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "article")
public class Article {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "article_id")
    public int articleId;
    public int minutes;
    public int pages;
    public String title;
    public String text;
    public int importance;

}