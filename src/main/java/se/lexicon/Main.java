package se.lexicon;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

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
    }

}
