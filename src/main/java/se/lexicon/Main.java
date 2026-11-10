package se.lexicon;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // Filters: rules that SELECT which tasks we care about
    static TaskFilter highPriority = t -> t.getPriority() >= 4;
    static TaskFilter mediumPriority = t -> t.getPriority() == 3;
    static TaskFilter lowPriority = t -> t.getPriority() <= 2;
    static TaskFilter completed = t -> t.isCompleted();
    static TaskFilter notCompleted = t -> !t.isCompleted();
    static TaskFilter lowAndCompleted = lowPriority.and(completed);
    static TaskAction markAsCompleted = todo -> todo.setCompleted(true);

    static void main() {

        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo("Fix bugs", 2, false));
        todos.add(new Todo("Write tests", 1, false));
        todos.add(new Todo("Deploy app", 3, false));
        todos.add(new Todo("Refactor code", 1, true));
        todos.add(new Todo("Update documentation", 1, false));
        todos.add(new Todo("Investigate production issue", 5, false));
        todos.add(new Todo("Code review PR #42", 2, true));
        todos.add(new Todo("Optimize database query", 4, false));
        todos.add(new Todo("Plan next sprint", 3, true));
        todos.add(new Todo("Clean up warnings", 2, false));
        todos.add(new Todo("Improve UI layout", 3, false));
        todos.add(new Todo("Release hotfix", 5, true));

        /*
        for (Todo todo : todos) {
            IO.println(todo);
        }

        List<Todo> highPriorityTasks = new ArrayList<>();
        for (Todo todo : todos) {
            if (todo.getPriority() >= 4) {
                highPriorityTasks.add(todo);
            }
        }
        IO.println("\n--- Without lambda: high priority tasks ---");
        IO.println(highPriorityTasks);


        List<Todo> completedTasks = new ArrayList<>();
        for (Todo todo : todos) {
            if (todo.isCompleted()) {
                completedTasks.add(todo);
            }
        }
        IO.println("Without lambda: completed tasks: " + completedTasks);

         */



        // Filtered results
        IO.println("\n--- Filter results (no changes) ---");
        IO.println("Low priority tasks: " + findTasks(todos, lowPriority));
        IO.println("Completed tasks: " + findTasks(todos, completed));
        IO.println("Low priority & Completed tasks: " + findTasks(todos, lowAndCompleted));


        // Filter and Update results
        IO.println("\n--- Filter and Update results ---");
        IO.println("Make Low priority tasks completed: " + applyToMatchingTasks(todos, lowPriority, markAsCompleted));


    }

    public static List<Todo> findTasks(List<Todo> todos, TaskFilter filter) {
        List<Todo> result = new ArrayList<>();
        for (Todo todo : todos) {
            if (filter.matches(todo)) {
                result.add(todo);
            }
        }
        return result;
    }


    public static List<Todo> applyToMatchingTasks(List<Todo> todos, TaskFilter filter, TaskAction action) {
        List<Todo> updated = new ArrayList<>();
        for (Todo todo : todos) {
            if (filter.matches(todo)) {
                action.run(todo);
                updated.add(todo);
            }
        }
        return updated;
    }

}
