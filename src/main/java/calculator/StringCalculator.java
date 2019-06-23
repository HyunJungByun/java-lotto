package calculator;

public class StringCalculator {
    private static final int EMPTY_NUM = 0;

    int add(String value) {
        if (isNull(value)) {
            return EMPTY_NUM;
        }
        if (isEmpty(value)) {
            return EMPTY_NUM;
        }

        return -1;
    }

    boolean isNull(String value) {
        if (value == null) {
            return true;
        }
        return false;
    }

    boolean isEmpty(String value) {
        value = value.trim();
        if (value.isEmpty()) {
            return true;
        }
        return false;
    }
}
