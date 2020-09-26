import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BodyMassIndexTest {
    @Test
    public void testCategoryPickerUnder(){
        BodyMassIndex calc = new BodyMassIndex(4,5);
        assertEquals(calc.CategoryPicker(8.5), "Underweight");
    }
    @Test
    public void testCategoryPickerNormal(){
        BodyMassIndex calc = new BodyMassIndex(4,5);
        assertEquals(calc.CategoryPicker(20), "Normal weight");
    }
    @Test
    public void testCategoryPickerOver(){
        BodyMassIndex calc = new BodyMassIndex(4,5);
        assertEquals(calc.CategoryPicker(27.8), "Overweight");
    }
    @Test
    public void testCategoryPickerObese(){
        BodyMassIndex calc = new BodyMassIndex(4,5);
        assertEquals(calc.CategoryPicker(40), "Obesity");
    }
    @Test
    public void testBodyMassIndex(){
        BodyMassIndex calc = new BodyMassIndex(72,145);
        assertEquals(calc.bmi, 19.663387345679013);
    }

}