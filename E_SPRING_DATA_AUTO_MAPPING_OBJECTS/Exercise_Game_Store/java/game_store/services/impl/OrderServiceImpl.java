package game_store.services.impl;

import game_store.models.Game;
import game_store.models.Order;
import game_store.repositories.OrderRepository;
import game_store.services.api.OrderService;
import game_store.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class OrderServiceImpl implements OrderService {
    private UserService userService;
    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, UserService userService) {
        this.orderRepository = orderRepository;

        this.userService = userService;
    }

    @Override
    public void buyItems(Collection<Game> products, String email){
        Order order = new Order();
        order.setProducts(products);
        order.setBuyer(this.userService.getUserByEmail(email));
        this.orderRepository.save(order);
    }

}
