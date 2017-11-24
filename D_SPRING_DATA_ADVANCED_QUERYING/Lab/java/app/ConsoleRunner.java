package app;

import app.model.enums.Size;
import app.model.ingredients.BasicIngredient;
import app.model.ingredients.Ingredient;
import app.model.labels.Label;
import app.model.shampoos.BasicShampoo;
import app.repositories.IngredientRepository;
import app.repositories.LabelRepository;
import app.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.security.provider.SHA;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class ConsoleRunner implements CommandLineRunner {

    private ShampooRepository shampooRepository;
    private IngredientRepository ingredientRepository;
    private LabelRepository labelRepository;

    @Autowired
    public ConsoleRunner(ShampooRepository shampooRepository, IngredientRepository ingredientRepository, LabelRepository labelRepository) {
        this.shampooRepository = shampooRepository;
        this.ingredientRepository = ingredientRepository;
        this.labelRepository = labelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        ----------Problem 1
//        List<BasicShampoo> bySize =
//          this.shampooRepository.findBySizeOrderById(Size.MEDIUM);
//
//        for (Shampoo shampoo : bySize) {
//            System.out.println(shampoo.getBrand() +
//                    " " + shampoo.getSize() +
//                    " " + shampoo.getPrice());
//        }

//        -----------Problem 2
//        Label label = this.labelRepository.findOne(10L);
//        List<BasicShampoo> bySizeOrLabel =
//                this.shampooRepository
//                        .findBySizeOrLabelOrderByPriceAsc(Size.MEDIUM, label);
//        for (BasicShampoo shampoo : bySizeOrLabel) {
//            System.out.println(shampoo.getBrand() + " "
//            + shampoo.getSize() + " "
//            + shampoo.getPrice() + "lv.");
//        }

//        -------Problem 3
//        List<BasicShampoo> byPriceHigherThan =
//                this.shampooRepository
//                        .findByPriceGreaterThanOrderByPriceDesc(
//                                new BigDecimal("5"));
//        for (BasicShampoo basicShampoo : byPriceHigerThan) {
//            System.out.println(basicShampoo.getBrand() + " "
//            + basicShampoo.getSize() + " "
//            + basicShampoo.getPrice() + "lv.");
//        }
//        ------Problem 4
//        List<BasicIngredient> startsWithLetter =
//                this.ingredientRepository.findByNameStartsWith("M");
//        for (BasicIngredient ingredient : startsWithLetter) {
//            System.out.println(ingredient.getName());
//        }

//        -------Problem 5
//        List<String> strings = new ArrayList<>();
//        strings.add("Lavender");
//        strings.add("Herbs");
//        strings.add("Apple");
//
//        List<BasicIngredient> ingredients =
//                this.ingredientRepository.findAllByNameInOrderByPrice(strings);
//
//        for (BasicIngredient ingredient : ingredients) {
//            System.out.println(ingredient.getName());
//        }

//        ------Problem 6
//        System.out.println(this.shampooRepository
//                .countByPriceLessThan(new BigDecimal("8.50")));

//        ---------Problem 7
//        BasicIngredient apple = this.ingredientRepository.findOne(1L);
//        List<BasicIngredient> ingredients = Collections.singletonList(apple);
//
//        List<BasicShampoo> byIngredient =
//        this.shampooRepository.findByHavingIngredients(ingredients);
//
//        for (BasicShampoo Shampoo : byIngredient) {
//            System.out.println(Shampoo.getBrand());
//        }

        List<BasicShampoo> byIngredientsCount =
                this.shampooRepository.findByIngredientsCount(2);
        for (BasicShampoo basicShampoo : byIngredientsCount) {
            System.out.println(basicShampoo.getBrand());
        }

    }
}
