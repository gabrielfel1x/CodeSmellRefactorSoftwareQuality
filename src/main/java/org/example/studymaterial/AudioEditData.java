// File: org/example/studymaterial/AudioEditData.java
package org.example.studymaterial;

public class AudioEditData {
    private final AudioReference.AudioQuality audioQuality;
    private final boolean isDownloadable;
    private final String title;
    private final String description;
    private final String link;
    private final String accessRights;
    private final String license;
    private final String language;
    private final int rating;
    private final int viewCount;
    private final int shareCount;

    private AudioEditData(Builder builder) {
        this.audioQuality = builder.audioQuality;
        this.isDownloadable = builder.isDownloadable;
        this.title = builder.title;
        this.description = builder.description;
        this.link = builder.link;
        this.accessRights = builder.accessRights;
        this.license = builder.license;
        this.language = builder.language;
        this.rating = builder.rating;
        this.viewCount = builder.viewCount;
        this.shareCount = builder.shareCount;
    }

    public static class Builder {
        private AudioReference.AudioQuality audioQuality;
        private boolean isDownloadable;
        private String title;
        private String description;
        private String link;
        private String accessRights;
        private String license;
        private String language;
        private int rating;
        private int viewCount;
        private int shareCount;

        public Builder audioQuality(AudioReference.AudioQuality audioQuality) {
            this.audioQuality = audioQuality;
            return this;
        }

        public Builder isDownloadable(boolean isDownloadable) {
            this.isDownloadable = isDownloadable;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder link(String link) {
            this.link = link;
            return this;
        }

        public Builder accessRights(String accessRights) {
            this.accessRights = accessRights;
            return this;
        }

        public Builder license(String license) {
            this.license = license;
            return this;
        }

        public Builder language(String language) {
            this.language = language;
            return this;
        }

        public Builder rating(int rating) {
            this.rating = rating;
            return this;
        }

        public Builder viewCount(int viewCount) {
            this.viewCount = viewCount;
            return this;
        }

        public Builder shareCount(int shareCount) {
            this.shareCount = shareCount;
            return this;
        }

        public AudioEditData build() {
            return new AudioEditData(this);
        }
    }

    // Getters
    public AudioReference.AudioQuality getAudioQuality() { return audioQuality; }
    public boolean isDownloadable() { return isDownloadable; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getLink() { return link; }
    public String getAccessRights() { return accessRights; }
    public String getLicense() { return license; }
    public String getLanguage() { return language; }
    public int getRating() { return rating; }
    public int getViewCount() { return viewCount; }
    public int getShareCount() { return shareCount; }
}
