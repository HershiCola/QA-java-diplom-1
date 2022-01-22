package praktikum;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientClassEnumParameterizedTest {

    private final IngredientType expectedIngredientType;

    public IngredientClassEnumParameterizedTest(IngredientType expectedIngredientType){
        this.expectedIngredientType = expectedIngredientType;
    }

    @Parameterized.Parameters
    public static Object[][] checkIngredientType() {
        return new Object[][] {
                {IngredientType.FILLING},
                {IngredientType.SAUCE},
        };
    }

    @Test
    public void getTypeMethodParameterizedTest(){
        Ingredient testIngredient = new Ingredient(expectedIngredientType, "Sauce or Filling", 123);
        assertEquals(expectedIngredientType, testIngredient.getType());
    }
}
