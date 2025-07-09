package org.example.studyregistry;

import java.time.LocalDateTime;

public class ObjectiveParameters {
    public Integer id;
    public Integer priority;
    public Integer practicedDays;
    public int day;
    public int month;
    public int year;
    public String name;
    public String title;
    public String description;
    public String topic;
    public String objectiveInOneLine;
    public String objectiveFullDescription;
    public String motivation;
    public Double duration;
    public boolean isActive;

    public LocalDateTime getStartDate() {
        return LocalDateTime.of(year, month, day, 0, 0);
    }
}
