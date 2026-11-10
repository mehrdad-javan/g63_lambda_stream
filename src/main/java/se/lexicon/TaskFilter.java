package se.lexicon;

@FunctionalInterface
public interface TaskFilter {
    boolean matches(Todo todo);

    // combine two filters with AND
    default TaskFilter and(TaskFilter other) {
        return todo -> this.matches(todo) && other.matches(todo);
    }

    // combine two filters with OR
    default TaskFilter or(TaskFilter other) {
        return todo -> this.matches(todo) || other.matches(todo);
    }


    // reverse the filter condition
    default TaskFilter negate() {
        return todo -> !this.matches(todo);
    }
}
