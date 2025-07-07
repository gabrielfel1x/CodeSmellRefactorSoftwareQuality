package org.example.studysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchLog {
    private List<String> searchHistory;
    private Map<String, Integer> searchCount;
    private boolean isLocked;
    private int numUsages;
    private String logName;

    public SearchLog(String logName) {
        this.searchHistory = new ArrayList<>();
        this.searchCount = new HashMap<>();
        this.logName = logName;
        this.numUsages = 0;
        this.isLocked = false;
    }

    // Legacy method retained
    public void addSearchHistory(String searchHistory) {
        this.searchHistory.add(searchHistory);
    }

    // Behavior method (replaces direct manipulation from clients)
    public void logSearch(String searchTerm) {
        if (isLocked) return;

        addSearchHistory(searchTerm);
        searchCount.put(searchTerm, searchCount.getOrDefault(searchTerm, 0) + 1);
        numUsages++;
    }

    public List<String> getSearchHistory() {
        return new ArrayList<>(searchHistory);
    }

    public void setSearchHistory(List<String> searchHistory) {
        this.searchHistory = searchHistory;
    }

    public Map<String, Integer> getSearchCount() {
        return new HashMap<>(searchCount);
    }

    public void setSearchCount(Map<String, Integer> searchCount) {
        this.searchCount = searchCount;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        this.isLocked = locked;
    }

    public int getNumUsages() {
        return numUsages;
    }

    public void setNumUsages(int numUsages) {
        this.numUsages = numUsages;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public void reset() {
        searchHistory.clear();
        searchCount.clear();
        numUsages = 0;
    }
}
