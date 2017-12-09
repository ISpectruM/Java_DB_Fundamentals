package game_store.controllers;

import game_store.AuthenticationContext;
import game_store.Cart;
import game_store.models.Game;
import game_store.services.api.GameService;
import game_store.services.api.OrderService;


public class ItemController {
    private OrderService orderService;
    private GameService gameService;
    private AuthenticationContext authenticationContext;
    private Cart cart;

    public ItemController(OrderService orderService,
                          GameService gameService,
                          AuthenticationContext authenticationContext) {
        this.orderService = orderService;
        this.gameService = gameService;
        this.authenticationContext = authenticationContext;
    }

    public String add(String title){
        if (this.cart == null){
            this.cart = new Cart();
        }

        Game game = this.gameService.findGameByTitle(title);
        this.cart.addItem(game);
        return "Game successfully added to cart!";
    }

    public String buy(){
        try {
            this.orderService.buyItems(this.cart.getCartItems(),
                    this.authenticationContext.getLoggedInUser().getEmail());
        }catch (Exception e){
            e.getMessage();
        }
        return "You order is finished!";
    }
}
