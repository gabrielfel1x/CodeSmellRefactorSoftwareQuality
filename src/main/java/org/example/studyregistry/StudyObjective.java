package org.example.studyregistry;

import java.time.LocalDateTime;
import java.util.List;

public class StudyObjective extends Registry {
    private String title;
    private String description;
    private String topic;
    private Integer practicedDays;
    private LocalDateTime startDate;
    private Double duration;
    private String objectiveInOneLine;
    private String objectiveFullDescription;
    private String motivation;

    public String getTitle() {
        return title;
    }

    public String getTopic() {
        return topic;
    }

    public Integer getPracticedDays() {
        return practicedDays;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public Double getDuration() {
        return duration;
    }

    public String getObjectiveInOneLine() {
        return objectiveInOneLine;
    }

    public String getObjectiveFullDescription() {
        return objectiveFullDescription;
    }

    public String getMotivation() {
        return motivation;
    }

    @Override
    public String toString() {
        return "StudyObjective [title:" + title + ", description:" + description + (topic != null ? ", topic:" + topic : "")
                + (practicedDays != null ? ", practicedDays:" + practicedDays : "") + (duration != null ? ", duration:" + duration : "")
                + (objectiveInOneLine != null ? ", objective summary:" + objectiveInOneLine : "") + (objectiveFullDescription != null ? ", objective full description:" + objectiveFullDescription : "")
                + (motivation != null ? ", motivation:" + motivation : "") + "]";
    }

    public StudyObjective(String title, String description) {
        this.title = title;
        this.description = description;
        this.name = title;
    }

    public void handleSetRegistry(Integer id, String name, Integer priority, boolean isActive) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.isActive = isActive;
    }

    public void handleSetTextualInfo(String title, String description, String topic, String objectiveInOneLine, String objectiveFullDescription, String motivation) {
        this.title = title;
        this.description = description;
        this.topic = topic;
        this.objectiveInOneLine = objectiveInOneLine;
        this.objectiveFullDescription = objectiveFullDescription;
        this.motivation = motivation;
    }

    public void handleSetTime(Integer practicedDays, LocalDateTime startDate, Double duration) {
        this.practicedDays = practicedDays;
        this.startDate = startDate;
        this.duration = duration;
    }

    public void handleSetObjective(ObjectiveParameters params) {
        handleSetRegistry(params.id, params.name, params.priority, params.isActive);
        handleSetTextualInfo(params.title, params.description, params.topic,
                params.objectiveInOneLine, params.objectiveFullDescription, params.motivation);
        handleSetTime(params.practicedDays, params.getStartDate(), params.duration);
    }

    public int handleSetObjectiveAdapter(List<Integer> intProperties, List<String> stringProperties, Double duration, boolean isActive) {
        ObjectiveParameters params = new ObjectiveParameters();
        params.id = intProperties.get(0);
        params.priority = intProperties.get(1);
        params.practicedDays = intProperties.get(2);
        params.day = intProperties.get(3);
        params.month = intProperties.get(4);
        params.year = intProperties.get(5);

        params.name = stringProperties.get(0);
        params.title = stringProperties.get(1);
        params.description = stringProperties.get(2);
        params.topic = stringProperties.get(3);
        params.objectiveInOneLine = stringProperties.get(4);
        params.objectiveFullDescription = stringProperties.get(5);
        params.motivation = stringProperties.get(6);
        params.duration = duration;
        params.isActive = isActive;

        handleSetObjective(params);
        return params.id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
