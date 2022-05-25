package cat.tecnocampus.mobileapps.practica1.francescboixaburrad.rogerrodriguezmendez.roomdata;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskDao {
    @Query("SELECT * FROM task")
    List<Task> getAll();

    @Insert
    void insertTask(Task t);

    @Delete
    void delete(Task t);
}
