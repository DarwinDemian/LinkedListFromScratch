package tests;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RandomDataGeneratorUnitTest {
    RandomDataGenerator rng = new RandomDataGenerator();

    @Test
    public void testIntegerType() {
        Object integerVal = rng.generateRandomData(2);

        assertTrue(integerVal instanceof Integer);
    }

    @Test
    public void testStringType() {
        Object stringVal = rng.generateRandomData("abcd");

        assertTrue(stringVal instanceof String);
    }

    @Test
    public void testRandomInteger() {
        Object integerVal = rng.generateRandomData(1);
        Object integerVal2 = rng.generateRandomData(2);

        assertNotEquals(integerVal, integerVal2);
    }

    @Test
    public void testIntegerArray() {
        Object[] intArr = rng.generateArrayOf(1, 3);

        assertTrue(intArr instanceof Object[]);
        assertTrue(intArr.length == 3);
    }

}
