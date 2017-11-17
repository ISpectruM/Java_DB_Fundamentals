package ingredient.chemical;

import ingredient.basic.Ingredient;

interface ChemicalIngredient extends Ingredient {
    String  getChemicalFormula();

    void setChemicalFormula(String chemicalFormula);
}
