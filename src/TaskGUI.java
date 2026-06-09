import javax.swing.*;
import java.awt.*;

public class TaskGUI extends JFrame {
    private TaskManager taskManager;
    private DefaultListModel<Task> listModel;
    private JList<Task> taskList;
    private JTextField taskField;

    public TaskGUI() {
        taskManager = new TaskManager();
        listModel = new DefaultListModel<>();

        for (Task task : FileManager.loadTasks()) {
            taskManager.getTasks().add(task);
            listModel.addElement(task);
        }

        setTitle("To-Do App");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        taskField = new JTextField();

        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");
        JButton doneButton = new JButton("Mark as Done");

        taskList = new JList<>(listModel);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(taskField, BorderLayout.CENTER);
        topPanel.add(addButton, BorderLayout.EAST);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(doneButton);
        bottomPanel.add(deleteButton);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(taskList), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addTask());
        deleteButton.addActionListener(e -> deleteTask());
        doneButton.addActionListener(e -> markDone());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addTask() {
        String title = taskField.getText().trim();

        if (!title.isEmpty()) {
            taskManager.addTask(title);
            Task newTask = taskManager.getTasks().get(taskManager.getTasks().size() - 1);
            listModel.addElement(newTask);
            taskField.setText("");
            FileManager.saveTasks(taskManager.getTasks());
        }
    }

    private void deleteTask() {
        int index = taskList.getSelectedIndex();

        if (index != -1) {
            taskManager.removeTask(index);
            listModel.remove(index);
            FileManager.saveTasks(taskManager.getTasks());
        }
    }

    private void markDone() {
        int index = taskList.getSelectedIndex();

        if (index != -1) {
            taskManager.markDone(index);
            taskList.repaint();
            FileManager.saveTasks(taskManager.getTasks());
        }
    }
}