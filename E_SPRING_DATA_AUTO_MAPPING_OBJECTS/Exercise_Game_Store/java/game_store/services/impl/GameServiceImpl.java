package game_store.services.impl;


import game_store.models.Game;
import game_store.repositories.GameRepository;
import game_store.services.api.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Service
@Transactional
public class GameServiceImpl implements GameService {
    private GameRepository gameRepository;
    private Validator validator;


    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
        this.getValidator();
    }
    @Override
    public void  addGame(Game game){
        if (this.checkIfGameExists(game.getTitle())){
            throw new IllegalArgumentException("Game already exists!");
        }

        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(game);
        if (constraintViolations.size() == 0){
            this.gameRepository.save(game);
        } else {
            for (ConstraintViolation<Game> constraintViolation : constraintViolations) {
                System.out.println(constraintViolation.getMessage());
            }
        }
    }

    @Override
    public boolean checkIfGameExists(String title){
        Game byTitle = this.gameRepository.findByTitle(title);
        return byTitle != null;
    }

    private void getValidator(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @Override
    public Game findGameByTitle(String title){
        return this.gameRepository.findByTitle(title);
    }

}
