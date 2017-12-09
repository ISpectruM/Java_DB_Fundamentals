package game_store;

import game_store.models.dtos.UserDto;

public class AuthenticationContext {
    private UserDto loggedInUser;

    public UserDto getLoggedInUser() {
        return this.loggedInUser;
    }

    public void setLoggedInUser(UserDto loggedInUser) {
        this.loggedInUser = loggedInUser;
    }


}
