import com.example.Alex;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AlexTest {

    @Mock
    private Feline feline;

    @Test
    void shouldReturnAlexFriends() throws Exception {
        Alex alex = new Alex(feline);

        List<String> expectedFriends = List.of(
                "Марти",
                "Глория",
                "Мелман"
        );

        assertEquals(expectedFriends, alex.getFriends());
    }

    @Test
    void shouldReturnPlaceOfLiving() throws Exception {
        Alex alex = new Alex(feline);

        assertEquals(
                "Нью-Йоркский зоопарк",
                alex.getPlaceOfLiving()
        );
    }

    @Test
    void shouldReturnZeroKittens() throws Exception {
        Alex alex = new Alex(feline);

        assertEquals(0, alex.getKittens());
    }

    @Test
    void shouldNotHaveMane() throws Exception {
        Alex alex = new Alex(feline);

        assertTrue(alex.doesHaveMane());
    }
}