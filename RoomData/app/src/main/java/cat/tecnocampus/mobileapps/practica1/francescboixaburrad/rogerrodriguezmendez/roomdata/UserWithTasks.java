package cat.tecnocampus.mobileapps.practica1.francescboixaburrad.rogerrodriguezmendez.roomdata;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class UserWithTasks {
    @Embedded public User user;

    @Relation(
            parentColumn = "uid",
            entityColumn = "idOwnerId"

    )

    public List<Task> task;

}
