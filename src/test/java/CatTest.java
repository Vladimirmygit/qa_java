import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline felineMock;

    @Test
    public void testGetFood() throws Exception {
        when(felineMock.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));

        Cat cat = new Cat(felineMock);

        List<String> actualFood = cat.getFood();

        assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), actualFood);
    }
}