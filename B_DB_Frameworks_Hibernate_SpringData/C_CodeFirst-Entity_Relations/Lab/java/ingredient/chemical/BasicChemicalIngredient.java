package ingredient.chemical;

import ingredient.basic.BasicIngredient;
import shampoo.BasicShampoo;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.List;

@Entity
public abstract class BasicChemicalIngredient extends BasicIngredient
        implements ChemicalIngredient {
    @Column(name = "chemical_formula")
    String chemicalFormula;

    protected BasicChemicalIngredient() {}
    BasicChemicalIngredient(String name, BigDecimal price, String chemicalFormula) {
        super(name, price);
        this.chemicalFormula = chemicalFormula;
    }

    public String getChemicalFormula() {
        return null;
    }

    public void setChemicalFormula(String chemicalFormula) {

    }

    public int getId() {
        return 0;
    }

    public void setId(int id) {

    }

    public String getName() {
        return null;
    }

    public void setName(String name) {

    }

    public BigDecimal getPrice() {
        return null;
    }

    public void setPrice(BigDecimal price) {

    }

    public List<BasicShampoo> getShampoos() {
        return null;
    }

    public void setShampoos(List<BasicShampoo> shampoos) {

    }
}
