package application.services.user;

import application.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import application.repositories.UserRepository;

@Service
@Primary
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        Long id = user.getId();

        if (id != null){
            if (userRepository.exists(id)){
                throw new RuntimeException("Duplicate user");
            }
        }

        String userName = user.getUsername();

        if (userName != null){
            if (userRepository.findByUsername(userName) != null){
                throw new RuntimeException("Duplicate user");
            }
        }

        userRepository.save(user);
    }
}
