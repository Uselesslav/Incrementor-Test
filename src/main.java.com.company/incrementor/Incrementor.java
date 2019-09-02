package incrementor;

// TODO: Add comments
public class Incrementor {
    private int maxValue = Integer.MAX_VALUE;
    private int currentNumber = 0;

    public int getNumber() {
        return currentNumber;
    }

    public void incrementNumber() {
        if (currentNumber == maxValue) {
            onOverflowMaximumValue();
        } else {
            currentNumber = currentNumber + 1;
        }
    }

    public void setMaxValue(int maxValue) {
        if (maxValue < 0) {
            throw new NegativeMaxValueException();
        } else {
            this.maxValue = maxValue;
            if (currentNumber > maxValue) {
                onOverflowMaximumValue();
            }
        }
    }

    private void onOverflowMaximumValue() {
        currentNumber = 0;
    }
}
