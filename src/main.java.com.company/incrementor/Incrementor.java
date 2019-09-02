package incrementor;

/**
 * Класс, позволяющий инкрементировать и получать значение числа, хранящегося внутри объекта этого класса,
 * а также устанавливать максимальное значение для этого числа, превышение которого приводит к его обнулению.
 * <p>
 * При инициализации объекта класса число равно 0, а дефолтное максимальное значение равно максимальному
 * значению целочисленного типа {@link Integer#MAX_VALUE}
 */
public class Incrementor {
    /**
     * Инкрементируемое число
     */
    private int incrementedNumber = 0;
    /**
     * Максимально возможное значение инкрементируемого числа
     */
    private int maxValue = Integer.MAX_VALUE;

    /**
     * @return текущее значение инкрементируемого числа
     */
    public int getNumber() {
        return incrementedNumber;
    }

    /**
     * Инкрементирует число, при превышении максимального значения вызывает {@link #onOverflowMaximumValue()}
     */
    public void incrementNumber() {
        if (incrementedNumber == maxValue) {
            onOverflowMaximumValue();
        } else {
            incrementedNumber++;
        }
    }

    /**
     * Устанавливает максимально возможное значение для инкрементируемого числа. Если текущее значение
     * инкрементируемого числа превышает новое максимальное значение,
     * вызывается метод {@link #onOverflowMaximumValue()}
     *
     * @param maxValue - максимально возможное значение. Если maxValue меньше нуля, 
     *                 выбрасывается исключение {@link NegativeMaxValueException}
     *
     */
    public void setMaxValue(int maxValue) {
        if (maxValue < 0) {
            throw new NegativeMaxValueException();
        } else {
            this.maxValue = maxValue;
            if (incrementedNumber > maxValue) {
                onOverflowMaximumValue();
            }
        }
    }

    /**
     * Вызывается когда инкрементируемое число превышает лимит. Обнуляет инкрементируемое число
     */
    private void onOverflowMaximumValue() {
        incrementedNumber = 0;
    }
}
