package game_store.services.api;

import game_store.models.Game;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public interface OrderService {
    void buyItems(Collection<Game> products, String email);
}
