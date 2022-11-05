package tests;

import java.util.Random;

public class RandomDataGenerator {
    public RandomDataGenerator(Object value) {

    }

    public RandomDataGenerator(Object value, boolean asArray) {

    }

    private int generateRandomInt() {
        return new Random().nextInt(50 - 1) + 1;
    }

    private void generateRandomString(int strValue) {

    }

    private Object[] generateArrayOf(Object... values) {
        Object[] intArr = { values };
        return intArr;
    }

}
