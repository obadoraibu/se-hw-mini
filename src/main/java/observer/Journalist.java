package observer;

class Journalist implements Observer {
    public void update(Game game) {
        System.out.println("[Journalist] New game released: " + game.getTitle());
        System.out.println("[Journalist] Brief information: " + game.getSummary());
    }
}