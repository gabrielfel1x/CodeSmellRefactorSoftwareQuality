package org.example.studymaterial;

public abstract class Reference {
    private String title;
    private String description;
    private String link;
    private String accessRights;
    private String license;
    private boolean isDownloadable;
    private int rating;
    private String language;
    private int viewCount;
    private int downloadCount;
    private int shareCount;

    // Existing Getters and Setters (unchanged)
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public String getAccessRights() {
        return accessRights;
    }

    public void setAccessRights(String accessRights) {
        this.accessRights = accessRights;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public boolean getIsDownloadable() {
        return isDownloadable;
    }

    public void setDownloadable(boolean downloadable) {
        isDownloadable = downloadable;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    // -----------------------
    // Added Behavior Methods
    // -----------------------

    // Add Method: Apply new title, description, and link
    public void applyBasicDetails(String title, String desc, String url) {
        setTitle(title);
        setDescription(desc);
        setLink(url);
    }

    // Wrapper method for applyBasicDetails
    public void refreshBasicInfo(String title, String desc, String url) {
        applyBasicDetails(title, desc, url);
    }

    // Engagement Tracking
    public void increaseViews() {
        this.viewCount++;
    }

    public void increaseDownloads() {
        this.downloadCount++;
    }

    public void increaseShares() {
        this.shareCount++;
    }

    // Rating validation
    public boolean isRatingAcceptable(int value) {
        return value >= 0 && value <= 5;
    }

    // Summary of reference info
    public String summarize() {
        return String.format(
                "Title: %s%nDescription: %s%nLink: %s%nViews: %d, Downloads: %d, Shares: %d%nRating: %d/5%nAccess: %s%nLanguage: %s%nDownloadable: %b",
                title, description, link, viewCount, downloadCount, shareCount, rating, accessRights, language, isDownloadable
        );
    }

    // Access level check
    public boolean hasPublicAccess() {
        return accessRights != null && accessRights.equalsIgnoreCase("Public");
    }

    // Optional business logic methods

    // Popularity score based on simple weighted formula
    public double popularityScore() {
        return (viewCount * 0.5) + (downloadCount * 1.0) + (shareCount * 1.5) + (rating * 10.0);
    }

    // Safely update engagement stats
    public void updateEngagementStats(int views, int downloads, int shares) {
        if (views > 0) this.viewCount += views;
        if (downloads > 0) this.downloadCount += downloads;
        if (shares > 0) this.shareCount += shares;
    }

    // Determine if the reference is complete
    public boolean isComplete() {
        return title != null && !title.isEmpty() &&
                description != null && !description.isEmpty() &&
                link != null && !link.isEmpty() &&
                accessRights != null && !accessRights.isEmpty() &&
                license != null && !license.isEmpty();
    }

    // Compare engagement between two references
    public int compareEngagement(Reference other) {
        double thisScore = this.popularityScore();
        double otherScore = other != null ? other.popularityScore() : 0;
        return Double.compare(thisScore, otherScore);
    }

    // Check for premium quality
    public boolean isPremiumQuality() {
        return rating >= 4 &&
                (viewCount + downloadCount + shareCount) >= 100;
    }
}
