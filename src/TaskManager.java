import java.util.ArrayList;
/**
 * Manages all tasks in the application.
 */
public class TaskManager {
    /**
     * Adds a new task.
     *
     * @param title task title
     */
    private ArrayList<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String title) {
        tasks.add(new Task(title, false));
    }
    /**
     * Removes a task by index.
     *
     * @param index task position
     */
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }
    /**
     * Marks a task as completed.
     *
     * @param index task position
     */
    public void markDone(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).setDone(true);
        }
    }
    /**
     * Returns all tasks.
     *
     * @return list of tasks
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }
}