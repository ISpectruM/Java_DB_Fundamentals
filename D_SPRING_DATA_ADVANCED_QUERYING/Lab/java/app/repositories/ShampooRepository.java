package app.repositories;

import app.model.enums.Size;
import app.model.ingredients.BasicIngredient;
import app.model.ingredients.Ingredient;
import app.model.labels.Label;
import app.model.shampoos.BasicShampoo;
import app.model.shampoos.Shampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Basic;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<BasicShampoo,Long> {
    List<BasicShampoo> findBySizeOrderById(Size size);

    List<BasicShampoo> findBySizeOrLabelOrderByPriceAsc(Size size, Label label);

    List<BasicShampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    int countByPriceLessThan(BigDecimal price);

    @Query("SELECT i.shampoos FROM BasicIngredient AS i " +
            "WHERE i IN :ingredients")
    List<BasicShampoo> findByHavingIngredients(
            @Param("ingredients")List<BasicIngredient> ingredients);

    @Query("SELECT s FROM BasicShampoo AS s " +
            "WHERE s.ingredients.size < :count")
    List<BasicShampoo> findByIngredientsCount(@Param("count")int count);
}
