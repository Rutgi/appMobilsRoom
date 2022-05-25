package cat.tecnocampus.mobileapps.practica1.francescboixaburrad.rogerrodriguezmendez.roomdata;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DatabaseController {
    private UserDao userDao;
    private TaskDao taskDao;
    private LiveData<List<UserWithTasks>> allUserWithTasks;

    public DatabaseController(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        userDao = db.userDao();
        taskDao = db.taskDao();
        allUserWithTasks = userDao.getUsersWithTasks();
    }

    public LiveData<List<UserWithTasks>> fetchAll() {
        return allUserWithTasks;
    }

    public void setTask(int id, String descripcio, int minuts, int idOwnerId) {
        Task task = new Task(id, descripcio, minuts, idOwnerId);
        new insertAsyncTask(taskDao).execute(task);
    }

    public void setUser(int uid, String firstName, String lastName, Address address) {
        User user = new User(uid, firstName, lastName, address);
        new insertAsyncUser(userDao).execute(user);
    }

    private static class insertAsyncUser {
        private UserDao asyncUser;
        private Executor executor = Executors.newSingleThreadExecutor();

        insertAsyncUser(UserDao user) {
            asyncUser = user;
        }

        public void execute(User user) { this.doInBackground(user); }

        private void doInBackground(final User user) {
            this.executor.execute(new Runnable() {
                @Override
                public void run() {
                    asyncUser.insert(user);
                }
            });
        }
    }

    private static class insertAsyncTask {
        private TaskDao asyncTask;
        private Executor executor = Executors.newSingleThreadExecutor();

        insertAsyncTask(TaskDao task) {
            asyncTask = task;
        }

        public void execute(Task task) { this.doInBackground(task); }

        private void doInBackground(final Task task) {
            this.executor.execute(new Runnable() {
                @Override
                public void run() {
                    asyncTask.insertTask(task);
                }
            });
        }
    }
}
