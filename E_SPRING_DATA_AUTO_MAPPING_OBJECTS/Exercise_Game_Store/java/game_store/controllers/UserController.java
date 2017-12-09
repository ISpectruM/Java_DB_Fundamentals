package game_store.controllers;

import game_store.AuthenticationContext;
import game_store.models.User;
import game_store.services.api.UserService;

public class UserController {
    private UserService userService;
    private AuthenticationContext authenticationContext;

    public UserController(UserService userService, AuthenticationContext authenticationContext) {
        this.userService = userService;
        this.authenticationContext = authenticationContext;
    }

    public String register(String email, String password, String confirmPassword, String fullName){
        User user = new User();
        user.setEmail(email);
        user.setFullName(fullName);
        user.setPassword(password);

        try{
            this.userService.registerUser(user,confirmPassword);
        } catch (Exception e){
            return  e.getMessage();
        }

        return String.format("%s successfully registered", fullName);
    }

    public String login(String email, String password) {
        if (!this.userService.checkIfUserExists(email)) {
            return "User does not exists!";
        }
        this.authenticationContext.setLoggedInUser(this.userService.getUserDtoByEmail(email));
        return "User logged in successfully!";

    }

    public String logout(){
        if (this.authenticationContext.getLoggedInUser() == null){
            return "No user logged in!";
        }
        this.authenticationContext.setLoggedInUser(null);
        return "You successfully logged out!";
    }
}
