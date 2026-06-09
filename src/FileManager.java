import java.io.*;
import java.util.ArrayList;
/**
 * Handles loading and saving tasks to a file.
 */
public class FileManager {
    private static final String FILE_NAME = "tasks.txt";
    /**
     * Saves all tasks to a text file.
     *
     * @param tasks list of tasks
     */
    public static void saveTasks(ArrayList<Task> tasks) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.println(task.isDone() + ";" + task.getTitle());
            }
        } catch (IOException e) {
            System.out.println("Error while saving tasks.");
        }
    }
    /**
     * Loads tasks from a text file.
     *
     * @return list of loaded tasks
     */
    public static ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";", 2);

                if (parts.length == 2) {
                    boolean done = Boolean.parseBoolean(parts[0]);
                    String title = parts[1];
                    tasks.add(new Task(title, done));
                }
            }
        } catch (IOException e) {
            System.out.println("No saved tasks found.");
        }

        return tasks;
    }
}