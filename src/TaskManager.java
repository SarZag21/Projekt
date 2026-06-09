import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String title) {
        tasks.add(new Task(title, false));
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public void markDone(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).setDone(true);
        }
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}