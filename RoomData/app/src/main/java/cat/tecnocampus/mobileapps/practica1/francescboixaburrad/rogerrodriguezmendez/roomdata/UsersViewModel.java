package cat.tecnocampus.mobileapps.practica1.francescboixaburrad.rogerrodriguezmendez.roomdata;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UsersViewModel extends AndroidViewModel {
    private DatabaseController repository; //Instancia al controller
    private LiveData<List<UserWithTasks>> allUserTask; //LiveData

    public UsersViewModel(@NonNull Application application) {
        super(application);
        repository = new DatabaseController(application);
        allUserTask = repository.fetchAll();//agafem tot el que tenim a la taula
    }

    LiveData<List<UserWithTasks>> getAllUserTask() {
        return allUserTask;
    }//retornem totes les dades

    void insertUser(int uid, String firstName, String lastName, Address address) {
        repository.setUser(uid, firstName, lastName, address);
    }//cridem el DatabaseController, es qui afegirar

    void insertTask(int id, String descripcio, int minuts, int idOwnerId) {
        repository.setTask(id, descripcio, minuts, idOwnerId);
    }//cridem el DatabaseController, es qui afegirar
}
