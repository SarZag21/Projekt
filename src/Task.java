/**
 * Represents a task in the To-Do application.
 */
public class Task {
    private String title;
    private boolean done;
    /**
     * Creates a new task.
     *
     * @param title title of the task
     * @param done status of the task
     */
    public Task(String title, boolean done) {
        this.title = title;
        this.done = done;
    }
    /**
     * Returns the task title.
     *
     * @return task title
     */

    public String getTitle() {
        return title;
    }
    /**
     * Returns whether the task is completed.
     *
     * @return true if completed
     */

    public boolean isDone() {
        return done;
    }
    /**
     * Updates the completion status.
     *
     * @param done new status
     */
    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        if (done) {
            return "[Done] " + title;
        } else {
            return "[Open] " + title;
        }
    }
}