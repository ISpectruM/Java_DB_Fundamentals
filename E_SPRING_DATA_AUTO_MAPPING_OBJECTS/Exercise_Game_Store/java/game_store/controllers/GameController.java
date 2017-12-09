package game_store.controllers;

import game_store.models.Game;
import game_store.services.api.GameService;

import java.math.BigDecimal;
import java.util.Date;

public class GameController {
    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public String add(String title, BigDecimal price,
                      BigDecimal size, String trailer,
                      String thumbnailUrl,
                      String description,
                      Date releaseDate){
        Game game = new Game();
        game.setTitle(title);
        game.setPrice(price);
        game.setSize(size);
        game.setTrailer(trailer);
        game.setThumbnailUrl(thumbnailUrl);
        game.setDescription(description);
        game.setReleaseDate(releaseDate);
        try {
            this.gameService.addGame(game);
        }catch (Exception e ){
            return e.getMessage();
        }
        return "Game successfully added!";
    }

}
