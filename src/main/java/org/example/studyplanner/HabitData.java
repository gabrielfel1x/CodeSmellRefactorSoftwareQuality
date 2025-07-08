package org.example.studyplanner;

import java.time.LocalDateTime;

public class HabitData {
    private final String name;
    private final String motivation;
    private final int dailyMinutesDedication;
    private final int dailyHoursDedication;
    private final LocalDateTime startDate;
    private final boolean isConcluded;

    private HabitData(Builder builder) {
        this.name = builder.name;
        this.motivation = builder.motivation;
        this.dailyMinutesDedication = builder.dailyMinutesDedication;
        this.dailyHoursDedication = builder.dailyHoursDedication;
        this.startDate = builder.startDate;
        this.isConcluded = builder.isConcluded;
    }

    public String getName() {
        return name;
    }

    public String getMotivation() {
        return motivation;
    }

    public int getDailyMinutesDedication() {
        return dailyMinutesDedication;
    }

    public int getDailyHoursDedication() {
        return dailyHoursDedication;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public boolean isConcluded() {
        return isConcluded;
    }

    public static class Builder {
        private String name;
        private String motivation;
        private int dailyMinutesDedication;
        private int dailyHoursDedication;
        private LocalDateTime startDate;
        private boolean isConcluded;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setMotivation(String motivation) {
            this.motivation = motivation;
            return this;
        }

        public Builder setDailyMinutesDedication(int dailyMinutesDedication) {
            this.dailyMinutesDedication = dailyMinutesDedication;
            return this;
        }

        public Builder setDailyHoursDedication(int dailyHoursDedication) {
            this.dailyHoursDedication = dailyHoursDedication;
            return this;
        }

        public Builder setStartDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder setIsConcluded(boolean isConcluded) {
            this.isConcluded = isConcluded;
            return this;
        }

        public HabitData build() {
            return new HabitData(this);
        }
    }
}
