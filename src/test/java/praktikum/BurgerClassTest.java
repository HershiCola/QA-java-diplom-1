package praktikum;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class BurgerClassTest {

    Database burgerDatabase = new Database(); //инициализируем тестовые данные

    @Mock
    Bun mockBun;
    //используем мок\стаб чтобы получить только значение имени или цены для использования в методах класса Burger,
    //без самой сущности Bun

    @Test
    public void setBunMethodWorks(){
        Burger testBurger = new Burger();
        testBurger.setBuns(mockBun);
        assertNotNull(testBurger.bun); //если NULL, то поле не заполнилось и метод не отработал
    }

    @Test
    public void addIngredientMethodWorks(){

        Burger testBurger = new Burger();
        testBurger.addIngredient(burgerDatabase.availableIngredients().get(5));
        assertNotEquals("Метод добавления ингредиента не сработал",0, testBurger.ingredients.size());

    }

    @Test
    public void removeIngredientMethodWorks(){

        Burger testBurger = new Burger();
        testBurger.addIngredient(burgerDatabase.availableIngredients().get(3));
        testBurger.removeIngredient(0);
        assertEquals("Метод удаления ингредиента не сработал",0, testBurger.ingredients.size());

    }

    @Test
    public void moveIngredientMethodWorks(){

        Burger testBurger = new Burger();
        testBurger.addIngredient(burgerDatabase.availableIngredients().get(0)); //hot sauce
        testBurger.addIngredient(burgerDatabase.availableIngredients().get(3)); //cutlet
        testBurger.moveIngredient(1, 0);
        assertEquals("Перемещение не сработало", testBurger.ingredients.get(0), burgerDatabase.availableIngredients().get(3));

    }

    @Test
    public void getPriceMethodWorks(){

        Burger testBurger = new Burger();
        testBurger.setBuns(mockBun);
        Mockito.when(mockBun.getPrice()).thenReturn(100f);
        testBurger.addIngredient(burgerDatabase.availableIngredients().get(3)); //цена в Database 100
        assertEquals(300, testBurger.getPrice(), 0.01);
    }

    @Test
    public void getReceiptMethodWorks(){

        Burger testBurger = new Burger();
        testBurger.setBuns(mockBun);
        testBurger.addIngredient(burgerDatabase.availableIngredients().get(0)); //hot sauce
        testBurger.addIngredient(burgerDatabase.availableIngredients().get(4)); //dinosaur
        Mockito.when(mockBun.getName()).thenReturn("MockBun");
        assertTrue(testBurger.getReceipt().contains("MockBun")
                &&testBurger.getReceipt().contains(burgerDatabase.availableIngredients().get(0).getName())
                &&testBurger.getReceipt().contains(burgerDatabase.availableIngredients().get(4).getName()));

    }
}
