package org.example.studyplanner;

import java.util.ArrayList;
import java.util.List;

public class TodoTracker {
    private List<ToDo> toDos = new ArrayList<>();
    private Integer nextId;
    private static TodoTracker instance;

    private TodoTracker() {
        this.toDos = new ArrayList<>();
        this.nextId = 1;
    }

    public static TodoTracker getInstance() {
        if (instance == null) {
            instance = new TodoTracker();
        }
        return instance;
    }

    @Override
    public String toString() {
        if (toDos.isEmpty()) {
            return "No ToDos found";
        }
        StringBuilder str = new StringBuilder();
        for (ToDo toDo : toDos) {
            str.append(toDo.toString()).append("\n");
        }
        return str.toString();
    }

    /**
     * Refactored method - now simply calls execute() on the matching ToDo.
     */
    public void addToDoExecutionTime(Integer id) {
        ToDo toDo = getToDoById(id);
        if (toDo != null) {
            toDo.execute();
        }
    }

    public List<ToDo> getToDos() {
        return toDos;
    }

    public ToDo getToDoById(Integer id) {
        for (ToDo toDo : toDos) {
            if (toDo.getId().equals(id)) {
                return toDo;
            }
        }
        return null;
    }

    public Integer addToDo(String title, String description, Integer priority) {
        ToDo toAdd = new ToDo(nextId, title, description, priority);
        nextId++;
        this.toDos.add(toAdd);
        return toAdd.getId();
    }

    public void removeToDo(Integer id) {
        toDos.removeIf(toDo -> toDo.getId().equals(id));
    }

    public List<ToDo> sortTodosByPriority() {
        List<ToDo> sortedToDos = new ArrayList<>(toDos);
        sortedToDos.sort((a, b) -> Integer.compare(a.getPriority(), b.getPriority()));
        return sortedToDos;
    }

    public List<String> searchInTodos(String search) {
        List<String> todos = new ArrayList<>();
        for (ToDo toDo : toDos) {
            if (toDo.getTitle().toLowerCase().contains(search.toLowerCase()) ||
                    toDo.getDescription().toLowerCase().contains(search.toLowerCase())) {
                todos.add(toDo.toString());
            }
        }
        return todos;
    }
}
