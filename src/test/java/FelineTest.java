import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineTest {

    private int kittensCount;
    private int expectedKittens;

    public FelineTest(int kittensCount, int expectedKittens) {
        this.kittensCount = kittensCount;
        this.expectedKittens = expectedKittens;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1},
                {3, 3},
                {5, 5}
        });
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();

        int actualKittens = feline.getKittens(kittensCount);

        assertEquals(expectedKittens, actualKittens);
    }
}




