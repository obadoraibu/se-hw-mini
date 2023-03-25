package observer;

import java.util.List;

class Game {
    private String title;
    private String summary;
    private String technicalData;
    private List<String> achievements;

    public Game(String title, String summary, String technicalData, List<String> achievements) {
        this.title = title;
        this.summary = summary;
        this.technicalData = technicalData;
        this.achievements = achievements;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getTechnicalData() {
        return technicalData;
    }

    public List<String> getAchievements() {
        return achievements;
    }
}