package observer;

import java.util.ArrayList;
import java.util.List;

class GameConsole implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private List<Game> games = new ArrayList<>();

    public void newGame(Game game) {
        System.out.println("[GameConsole] New game");
        games.add(game);
        notifyObservers();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(games.get(games.size() - 1));
        }
    }
}

