package se.lexicon;

public class Todo {

    private String title;
    private int priority;
    private boolean completed;

    public Todo(String title, int priority, boolean completed) {
        this.title = title;
        this.priority = priority;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "title='" + title + '\'' +
                ", priority=" + priority +
                ", completed=" + completed +
                '}';
    }
}
