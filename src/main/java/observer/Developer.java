package observer;

class Developer implements Observer {
    public void update(Game game) {
        System.out.println("[Developer] New game released: " + game.getTitle());
        System.out.println("[Developer] Technical data: " + game.getTechnicalData());
    }
}