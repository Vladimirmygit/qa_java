import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
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
    public void testDoesHaveMane() throws Exception {
        Feline felineMock = mock(Feline.class);
        Lion lionMale = new Lion("Самец", felineMock);
        Lion lionFemale = new Lion("Самка", felineMock);

        assertTrue(lionMale.doesHaveMane());
        assertFalse(lionFemale.doesHaveMane());
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

    @RunWith(Parameterized.class)
    public static class ParameterizedLionTest {
        private String sex;
        private boolean hasMane;

        public ParameterizedLionTest(String sex, boolean hasMane) {
            this.sex = sex;
            this.hasMane = hasMane;
        }

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {"Самец", true},
                    {"Самка", false}
            });
        }

        @Test
        public void testDoesHaveMane() throws Exception {
            Feline felineMock = mock(Feline.class);
            Lion lion = new Lion(sex, felineMock);

            assertEquals(hasMane, lion.doesHaveMane());
        }
    }
}