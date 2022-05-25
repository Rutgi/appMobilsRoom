package cat.tecnocampus.mobileapps.practica1.francescboixaburrad.rogerrodriguezmendez.roomdata;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Task {

    @PrimaryKey
    private int id;
    private String descripcio;
    private int minuts;

    private int idOwnerId;


    public Task(int id, String descripcio, int minuts, int idOwnerId) {
        this.id = id;
        this.descripcio = descripcio;
        this.minuts = minuts;
        this.idOwnerId = idOwnerId;
    }

    public int getId() {
        return id;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public int getMinuts() {
        return minuts;
    }

    public int getIdOwnerId() {
        return idOwnerId;
    }
}
