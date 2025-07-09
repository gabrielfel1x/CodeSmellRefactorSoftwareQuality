package org.example.studyregistry;

import java.time.LocalDateTime;

public class StudyPlanSteps {
    private final String firstStep;
    private final String resetStudyMechanism;
    private final String consistentStep;
    private final String seasonalSteps;
    private final String basicSteps;
    private final String mainObjectiveTitle;
    private final String mainGoalTitle;
    private final String mainMaterialTopic;
    private final String mainTask;
    private final Integer numberOfSteps;
    private final boolean isImportant;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    private StudyPlanSteps(Builder builder) {
        this.firstStep = builder.firstStep;
        this.resetStudyMechanism = builder.resetStudyMechanism;
        this.consistentStep = builder.consistentStep;
        this.seasonalSteps = builder.seasonalSteps;
        this.basicSteps = builder.basicSteps;
        this.mainObjectiveTitle = builder.mainObjectiveTitle;
        this.mainGoalTitle = builder.mainGoalTitle;
        this.mainMaterialTopic = builder.mainMaterialTopic;
        this.mainTask = builder.mainTask;
        this.numberOfSteps = builder.numberOfSteps;
        this.isImportant = builder.isImportant;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
    }

    public static class Builder {
        private String firstStep;
        private String resetStudyMechanism;
        private String consistentStep;
        private String seasonalSteps;
        private String basicSteps;
        private String mainObjectiveTitle;
        private String mainGoalTitle;
        private String mainMaterialTopic;
        private String mainTask;
        private Integer numberOfSteps;
        private boolean isImportant;
        private LocalDateTime startDate;
        private LocalDateTime endDate;

        public Builder firstStep(String step) { this.firstStep = step; return this; }
        public Builder resetStudyMechanism(String step) { this.resetStudyMechanism = step; return this; }
        public Builder consistentStep(String step) { this.consistentStep = step; return this; }
        public Builder seasonalSteps(String step) { this.seasonalSteps = step; return this; }
        public Builder basicSteps(String step) { this.basicSteps = step; return this; }
        public Builder mainObjectiveTitle(String title) { this.mainObjectiveTitle = title; return this; }
        public Builder mainGoalTitle(String title) { this.mainGoalTitle = title; return this; }
        public Builder mainMaterialTopic(String topic) { this.mainMaterialTopic = topic; return this; }
        public Builder mainTask(String task) { this.mainTask = task; return this; }
        public Builder numberOfSteps(Integer steps) { this.numberOfSteps = steps; return this; }
        public Builder isImportant(boolean isImportant) { this.isImportant = isImportant; return this; }
        public Builder startDate(LocalDateTime start) { this.startDate = start; return this; }
        public Builder endDate(LocalDateTime end) { this.endDate = end; return this; }

        public StudyPlanSteps build() {
            return new StudyPlanSteps(this);
        }
    }

    // Getters
    public String getFirstStep() { return firstStep; }
    public String getResetStudyMechanism() { return resetStudyMechanism; }
    public String getConsistentStep() { return consistentStep; }
    public String getSeasonalSteps() { return seasonalSteps; }
    public String getBasicSteps() { return basicSteps; }
    public String getMainObjectiveTitle() { return mainObjectiveTitle; }
    public String getMainGoalTitle() { return mainGoalTitle; }
    public String getMainMaterialTopic() { return mainMaterialTopic; }
    public String getMainTask() { return mainTask; }
    public Integer getNumberOfSteps() { return numberOfSteps; }
    public boolean isImportant() { return isImportant; }
    public LocalDateTime getStartDate() { return startDate; }
    public LocalDateTime getEndDate() { return endDate; }
}
