package tests;

import java.util.Random;

public class RandomDataGenerator {
    public static final Random random = new Random();

    public RandomDataGenerator(Object value) {

    }

    public RandomDataGenerator(Object value, boolean asArray) {

    }

    private int generateRandomInt() {
        return random.nextInt(50 - 1) + 1;
    }

    private void generateRandomString(int strValue) {

    }

    private Object[] generateArrayOf(Object... values) {
        Object[] intArr = { values };
        return intArr;
    }

}
