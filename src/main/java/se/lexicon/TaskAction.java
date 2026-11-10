package se.lexicon;

@FunctionalInterface
public interface TaskAction {

    void run(Todo todo);
}
