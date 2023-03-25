package observer;

class Player implements Observer {
    public void update(Game game) {
        System.out.println("[Player] New game released: " + game.getTitle());
        System.out.println("[Player] Achievements: ");
        for (String achievement : game.getAchievements()) {
            System.out.println("> " + achievement);
        }
    }
}