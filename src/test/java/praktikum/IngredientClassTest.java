package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class IngredientClassTest {

    @Test
    public void getPriceMethodWorks(){
        Ingredient testIngredient = new Ingredient(IngredientType.SAUCE, "TestSauce", 111);
        assertEquals(111, testIngredient.getPrice(), 0.01);
    }

    @Test
    public void getNameMethodWorks(){
        Ingredient testIngredient = new Ingredient(IngredientType.FILLING, "Cheese", 555.55f);
        assertEquals("Cheese", testIngredient.getName());
    }
}

