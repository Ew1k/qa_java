import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
   private Feline feline;

    @Test
    void shouldReturnKittensFromFeline() throws Exception {
        when(feline.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", feline);

        assertEquals(3, lion.getKittens());

        verify(feline).getKittens();
    }

    @Test
    void shouldReturnFoodFromFeline() throws Exception {
        List<String> expectedFood = List.of(
                "Животные",
                "Птицы",
                "Рыба"
        );

        when(feline.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", feline);

        assertEquals(expectedFood, lion.getFood());

        verify(feline).getFood("Хищник");
    }

    @Test
    void shouldThrowExceptionForInvalidSex() {
        Exception exception = assertThrows(
                Exception.class,
                () -> new Lion("Неизвестно", feline)
        );

        assertEquals(
                "Используйте допустимые значения пола животного - самей или самка",
                exception.getMessage()
        );
    }
}