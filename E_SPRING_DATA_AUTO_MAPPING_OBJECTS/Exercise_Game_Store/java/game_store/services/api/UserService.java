package game_store.services.api;

import game_store.models.User;
import game_store.models.dtos.UserDto;

public interface UserService {
    void registerUser(User user, String confirmPassword);

    boolean checkIfUserExists(String email);

    UserDto getUserDtoByEmail(String email);

    User getUserByEmail(String email);
}
