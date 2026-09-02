import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FelineTest {

    @Test
    void shouldReturnOneKittenByDefault() {
        Feline feline = new Feline();

        assertEquals(1, feline.getKittens());
    }

    @Test
    void shouldReturnPredatorFood() throws Exception {
        Feline feline = new Feline();

        List<String> expectedFood = List.of(
                "Животные",
                "Птицы",
                "Рыба"
        );

        assertEquals(expectedFood, feline.eatMeat());
    }

    @Test
    void shouldReturnCatFamily() {
        Feline feline = new Feline();

        assertEquals("Кошачьи", feline.getFamily());
    }
}

