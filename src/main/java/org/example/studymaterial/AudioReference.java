package org.example.studymaterial;

import java.util.List;

public class AudioReference extends Reference {
    public enum AudioQuality {
        LOW, MEDIUM, HIGH, VERY_HIGH;
    }
    private AudioQuality audioQuality;

    public AudioReference(AudioQuality quality){
        this.audioQuality = quality;
    }

    public AudioQuality getAudioQuality() {
        return audioQuality;
    }

    public static AudioQuality audioQualityAdapter(String quality){
        return switch (quality.toLowerCase()) {
            case "low" -> AudioQuality.LOW;
            case "medium" -> AudioQuality.MEDIUM;
            case "high" -> AudioQuality.HIGH;
            case "very_high" -> AudioQuality.VERY_HIGH;
            default -> null;
        };
    }

    public void setAudioQuality(AudioQuality audioQuality) {
        this.audioQuality = audioQuality;
    }

    public void editAudio(AudioEditData data) {
        editBasic(data.getTitle(), data.getDescription(), data.getLink());
        this.setAccessRights(data.getAccessRights());
        this.setLicense(data.getLicense());
        this.setAudioQuality(data.getAudioQuality());
        editVideoAttributes(data.getRating(), data.getLanguage(), data.getViewCount(), data.getShareCount(), data.isDownloadable());
    }

    public void editAudioAdapter(List<String> properties, List<Integer> intProperties, AudioQuality audioQuality, boolean isDownloadable){
        AudioEditData data = new AudioEditData.Builder()
                .audioQuality(audioQuality)
                .isDownloadable(isDownloadable)
                .title(properties.get(0))
                .description(properties.get(1))
                .link(properties.get(2))
                .accessRights(properties.get(3))
                .license(properties.get(4))
                .language(properties.get(5))
                .rating(intProperties.get(0))
                .viewCount(intProperties.get(1))
                .shareCount(intProperties.get(2))
                .build();

        this.editAudio(data);
    }

     private void editVideoAttributes(int rating, String language, int viewCount, int shareCount,boolean isDownloadable){
         this.setRating(rating);
         this.setShareCount(shareCount);
         this.setViewCount(viewCount);
         this.setDownloadable(isDownloadable);
         this.setLanguage(language);
     }

     public void editBasic(String title, String description, String link){
         this.setTitle(title);
         this.setDescription(description);
         this.setLink(link);
     }

}
