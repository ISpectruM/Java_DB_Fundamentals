package game_store;

import game_store.models.Game;

import java.util.Collection;
import java.util.HashMap;

public class Cart {
    HashMap<String,Game> cartItems;

    public Cart() {
    }

    public Collection<Game> getCartItems() {
        return this.cartItems.values();
    }

    public void setCartItems(HashMap<String, Game> cartItems) {
        this.cartItems = cartItems;
    }

    public void addItem(Game game){
        if (cartItems == null){
            this.cartItems = new HashMap<>();
        }

        if (cartItems.containsKey(game.getTitle())){
            throw new IllegalArgumentException("Game is already in cart");
        }

        this.cartItems.put(game.getTitle(),game);
    }

    public void removeItem(String title){
        if (cartItems == null){
            throw new IllegalArgumentException("Cannot remove from empty cart!");
        }

        if (!cartItems.containsKey(title)){
            throw new IllegalArgumentException("Game not present in cart!");
        }

        this.cartItems.remove(title);
    }
}
