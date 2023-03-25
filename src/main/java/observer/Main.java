package observer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameConsole gameConsole = new GameConsole();

        Player player = new Player();
        Developer developer = new Developer();
        Journalist journalist = new Journalist();

        gameConsole.registerObserver(player);
        gameConsole.registerObserver(developer);
        gameConsole.registerObserver(journalist);

        List<String> achievementsMario = new ArrayList<String>();
        achievementsMario.add("Cross the finish line at the end of the stage and collect the max 50 stars.");
        achievementsMario.add("Cross the finish line at the end of the stage and collect the max 100 stars.");

        Game game = new Game("Super Mario", "Super Mario is a platform game series created by " +
                "Nintendo starring their mascot, Mario. It is the central series of the greater Mario franchise." +
                " At least one Super Mario game has been released for every major Nintendo video game console.",
                "The game was written almost entirely in C" +
                        " and was compiled using a Silicon Graphics IDO compiler.", achievementsMario);

        gameConsole.newGame(game);

        List<String> achievementsTetris = new ArrayList<String>();
        achievementsTetris.add("Clear 4 rows of bricks at once");
        achievementsTetris.add("Clear 5 rows of bricks at once");

        Game game2 = new Game("Tetris", "Tetris is a puzzle video game created by Soviet software" +
                " engineer Alexey Pajitnov in 1984. It has been published by several companies for multiple" +
                " platforms, most prominently during a dispute over the appropriation of the rights in the" +
                " late 1980s. After a significant period of publication by Nintendo, the rights reverted" +
                " to Pajitnov in 1996, who co-founded the Tetris Company with Henk Rogers to manage licensing.",
                "The original Tetris was programmed by Alexey Pajitnov using the programming " +
                        "language Pascal on an Electronika 60 (Russian: Электроника 60) - an unauthorized " +
                        "Soviet clone of a Digital Equipment Corp. PDP-11 computer.", achievementsTetris);

        gameConsole.newGame(game2);

    }
}
