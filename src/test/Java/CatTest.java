import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    private Feline feline;

    @Test
    void shouldReturnMeow() {
        Cat cat = new Cat(feline);

        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void shouldReturnFoodFromFeline() throws Exception {
        List<String> expectedFood = List.of(
                "Животные",
                "Птицы",
                "Рыба"
        );

        when(feline.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(feline);

        assertEquals(expectedFood, cat.getFood());

        verify(feline).eatMeat();
    }
}