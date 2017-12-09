package game_store.services.api;

import game_store.models.Game;

public interface GameService {
    void  addGame(Game game);

    boolean checkIfGameExists(String title);

    Game findGameByTitle(String title);
}
