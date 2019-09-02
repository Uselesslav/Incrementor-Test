
import incrementor.Incrementor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// TODO: Add comments
class IncrementorTest {

    @Test
    void getNumberAfterInit() {
        Incrementor incrementor = new Incrementor();
        int actualValue = incrementor.getNumber();


        Assertions.assertEquals(0, actualValue);
    }

    @Test
    void getNumberAfterMultiplyIncrement() {
        Incrementor incrementor = new Incrementor();
        int actualValue;

        for (int i = 1; i <= 10; i++) {
            incrementor.incrementNumber();
            actualValue = incrementor.getNumber();
            Assertions.assertEquals(i, actualValue);
        }
    }
}