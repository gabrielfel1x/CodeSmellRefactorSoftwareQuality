package org.example.studyplanner;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ToDo implements PlannerMaterial {
    private Integer id;
    private String title;
    private String description;
    private int priority;

    // New fields for execution tracking
    private int executionCount = 0;
    private LocalDateTime lastExecutionTime = null;

    public ToDo(Integer id, String title, String description, int priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    /**
     * Increment execution count and update lastExecutionTime.
     */
    public void execute() {
        executionCount++;
        lastExecutionTime = LocalDateTime.now();
    }

    /**
     * Returns true if the task has been executed at least once.
     */
    public boolean wasExecuted() {
        return executionCount > 0;
    }

    /**
     * Resets execution tracking stats.
     */
    public void resetExecutionStats() {
        executionCount = 0;
        lastExecutionTime = null;
    }

    /**
     * Returns a one-line summary of execution stats.
     */
    public String getExecutionSummary() {
        if (!wasExecuted()) {
            return "Not executed yet";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Executed " + executionCount + " times. Last run: " + lastExecutionTime.format(formatter);
    }

    @Override
    public String toString() {
        String base = MessageFormat.format("[(Priority:{3}) ToDo {0}: {1}, {2}]", id, title, description, priority);
        if (wasExecuted()) {
            base += "\n" + getExecutionSummary();
        }
        return base;
    }

    // Getters and setters omitted for brevity (same as before)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
}
