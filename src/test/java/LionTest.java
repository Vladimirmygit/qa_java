import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Test
    public void testGetKittens() throws Exception {
        Feline felineMock = mock(Feline.class);
        Lion lion = new Lion("Самец", felineMock);

        int actualKittens = lion.getKittens();

        assertEquals(0, actualKittens);
    }

    @Test
    public void testGetFood() throws Exception {
        Feline felineMock = mock(Feline.class);
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", felineMock);

        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
    }
}