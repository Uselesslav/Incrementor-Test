package incrementor;

// TODO: Add comments
public class Incrementor {
    private int maxValueOfCurrentNumber = Integer.MAX_VALUE;
    private int currentNumber = 0;

    public int getNumber() {
        return currentNumber;
    }

    public void incrementNumber() {
        if (currentNumber == maxValueOfCurrentNumber) {
            onOverflowMaximumValue();
        } else {
            currentNumber = currentNumber + 1;
        }
    }

    public void setMaximumValue(int maximumValue) {
        if (maximumValue < 0) {
            throw new NegativeMaximumValueException();
        } else {
            maxValueOfCurrentNumber = maximumValue;
            if (currentNumber > maxValueOfCurrentNumber) {
                onOverflowMaximumValue();
            }
        }
    }

    private void onOverflowMaximumValue() {
        currentNumber = 0;
    }
}
