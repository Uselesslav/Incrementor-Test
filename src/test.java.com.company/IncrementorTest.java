
import incrementor.Incrementor;
import incrementor.NegativeMaxValueException;
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

    @Test
    void overflowDefaultLimit() {
        Incrementor incrementor = new Incrementor();
        int actualMaxValue;
        int actualValueAfterOverflow;

        int i = 0;
        while (i != Integer.MAX_VALUE) {
            i++;
            incrementor.incrementNumber();
        }

        actualMaxValue = incrementor.getNumber();
        incrementor.incrementNumber();
        actualValueAfterOverflow = incrementor.getNumber();

        Assertions.assertEquals(Integer.MAX_VALUE, actualMaxValue);
        Assertions.assertEquals(0, actualValueAfterOverflow);
    }

    @Test
    void overflowCustomLimit() {
        Incrementor incrementor = new Incrementor();
        int maxValue = 10;
        int actualValue = incrementor.getNumber();
        int actualValueAfterOverflow;

        incrementor.setMaxValue(maxValue);

        for (int i = 1; i <= maxValue; i++) {
            incrementor.incrementNumber();
            actualValue = incrementor.getNumber();
        }

        incrementor.incrementNumber();
        actualValueAfterOverflow = incrementor.getNumber();

        Assertions.assertEquals(maxValue, actualValue);
        Assertions.assertEquals(0, actualValueAfterOverflow);
    }

    @Test
    void setNegativeMaxValue() {
        Incrementor incrementor = new Incrementor();
        int negativeMaxValue = -1;

        Assertions.assertThrows(NegativeMaxValueException.class, () -> incrementor.setMaxValue(negativeMaxValue));
    }

    @Test
    void setMaxValueLessThenCurrentValue() {
        Incrementor incrementor = new Incrementor();
        int maxValue = 10;
        int currentValue = 15;
        int actualValue = incrementor.getNumber();
        int actualValueAfterChangeMaxValue;

        for (int i = 1; i <= currentValue; i++) {
            incrementor.incrementNumber();
            actualValue = incrementor.getNumber();
        }

        incrementor.setMaxValue(maxValue);
        actualValueAfterChangeMaxValue = incrementor.getNumber();

        Assertions.assertEquals(currentValue, actualValue);
        Assertions.assertEquals(0, actualValueAfterChangeMaxValue);
    }
}