package game_store.services.impl;

import game_store.models.User;
import game_store.models.dtos.UserDto;
import game_store.repositories.UserRepository;
import game_store.services.api.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private Validator validator;
    private ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.getValidator();
        this.mapper = new ModelMapper();
    }

    private void getValidator(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @Override
    public void registerUser(User user, String confirmPassword) {
        if (checkIfUserExists(user.getEmail())){
            throw new IllegalArgumentException("User already exists");
        }

        if (!user.getPassword().equals(confirmPassword)){
            throw new IllegalArgumentException("Passwords do not match!");
        }

        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
        if (constraintViolations.size() == 0){
            this.userRepository.save(user);
        } else {
            for (ConstraintViolation<User> constraintViolation : constraintViolations) {
                System.out.println(constraintViolation.getMessage());
            }
        }
    }

    @Override
    public boolean checkIfUserExists(String email){
        User user = this.userRepository.findByEmail(email);
        return user != null;
    }

    @Override
    public UserDto getUserDtoByEmail(String email) {
        User user = this.userRepository.findByEmail(email);

        UserDto dto = new UserDto();
        this.mapper.map(user,dto);
        return dto;
    }

    @Override
    public User getUserByEmail(String email) {
       return this.userRepository.findByEmail(email);
    }


}
