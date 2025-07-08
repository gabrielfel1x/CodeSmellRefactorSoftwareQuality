package org.example.studyregistry;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Task extends Registry {
    private String title;
    private String description;
    private String author;
    private LocalDateTime date;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Task(String title, String description, String author, LocalDateTime date) {
        this.title = Objects.requireNonNull(title, "title must not be null");
        this.name = title;
        this.description = description != null ? description : "";
        this.author = author != null ? author : "Unknown";
        this.date = date != null ? date : LocalDateTime.now();
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getDate() {
        return date;
    }

    // Setters delegating to update methods for compatibility with existing tests
    public void setTitle(String title) {
        updateTitle(title);
    }

    public void setDescription(String description) {
        updateDescription(description);
    }

    public void setAuthor(String author) {
        changeAuthor(author);
    }

    public void setDate(LocalDateTime date) {
        reschedule(date);
    }

    // Behavior methods

    public void updateTitle(String newTitle) {
        if (newTitle == null || newTitle.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = newTitle;
        this.name = newTitle;
    }

    public void updateDescription(String newDescription) {
        this.description = newDescription != null ? newDescription : "";
    }

    public void changeAuthor(String newAuthor) {
        this.author = newAuthor != null ? newAuthor : "Unknown";
    }

    public void reschedule(LocalDateTime newDate) {
        if (newDate == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        this.date = newDate;
    }

    public void updateDateToNow() {
        this.date = LocalDateTime.now();
    }

    public String getFormattedDate() {
        return date.format(DATE_FORMATTER);
    }

    public String getSummary() {
        return String.format("Task: %s | Author: %s | Date: %s", title, author, getFormattedDate());
    }

    @Override
    public String toString() {
        return getSummary();
    }
}
