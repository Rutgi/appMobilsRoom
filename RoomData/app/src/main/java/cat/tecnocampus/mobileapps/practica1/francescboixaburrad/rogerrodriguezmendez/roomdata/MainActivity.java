package cat.tecnocampus.mobileapps.practica1.francescboixaburrad.rogerrodriguezmendez.roomdata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private TextView tv_output;
    UsersViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_output = findViewById(R.id.TV_output);

        Random rand = new Random();
        int randId = rand.nextInt(99);

        //crea instancia del ViewModel per accedir a les dades del llistat.
        //ViewModel ens permet desvincular la vista (Activity) de la font de dades.
        viewModel = new ViewModelProvider(this).get(UsersViewModel.class);
        //Observe es una funció de LiveData, que ens permet detectar quan
        // les dades s'han modificat.
        viewModel.getAllUserTask().observe(this, new Observer<List<UserWithTasks>>() {
            @Override
            public void onChanged(List<UserWithTasks> userWithTasks) {
                //onChanged s'executa quan el llistat es modifica a la bbdd.
                //Si afegiu una tasca, veureu que s'executa aquest codi per
                //actualitzar el llistat (adapter)
                try {
                    //senselle
                    List<UserWithTasks> allUsers = viewModel.getAllUserTask().getValue();
                    int indexOut = Math.abs( allUsers.size() - rand.nextInt(allUsers.size())-1 );

                    tv_output.setText("ID: "+allUsers.get(indexOut).user.uid+
                            "\nName: "+allUsers.get(indexOut).user.firstName+" "+allUsers.get(indexOut).user.lastName+
                            "\nAddress:\n\t"+allUsers.get(indexOut).user.address.toStringAll()+
                            "\nTasques:\n\tSize: "+allUsers.get(indexOut).task.size());
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "User duplicated", Toast.LENGTH_LONG).show();
                }
            }
        });


        Address address = new Address("Major", "Mataró", "Mataró", rand.nextInt());
        viewModel.insertUser(randId, "Roger", "Rodriguez", address);
        viewModel.insertTask(randId*2, "tasca", 60, randId);






    }
}