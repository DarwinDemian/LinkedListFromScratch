package randomdatagenerator;

import com.project.exceptions.ParseIntException;
import com.project.randomdatagenerator.RandomDataGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomDataGeneratorUnitTest {
    private RandomDataGenerator rng = new RandomDataGenerator();

    // ***********
    // RETURN TYPE
    // ***********

    @Test
    public void testIntegerType() throws ParseIntException {
        Object integerVal = rng.generateRandomData(2);

        assertTrue(integerVal instanceof Integer); // if you pass an Integer, it should generate an Integer
    }

    @Test
    public void testStringType() throws ParseIntException {
        Object stringVal = rng.generateRandomData("1");

        assertTrue(stringVal instanceof String); // if you pass a String, it should generate a String
    }

    // ************
    // RANDOM VALUE
    // ************

    @Test
    public void testRandomInteger() throws ParseIntException {
        Object integerVal = rng.generateRandomData(1);
        Object integerValCopy = rng.generateRandomData(1);

        Object integerVal2 = rng.generateRandomData(2);

        assertNotEquals(integerVal, integerVal2); // different seeds should not generate the same value
        assertEquals(integerVal, integerValCopy); // the same seed should generate the same value
    }

    @Test
    public void testRandomString() throws ParseIntException {
        Object stringVal = rng.generateRandomData("1");
        Object stringVal2 = rng.generateRandomData("2");

        assertNotEquals(stringVal, stringVal2); // different seeds should not generate the same value
    }

    // *****
    // ARRAY
    // *****

    @Test
    public void testIntegerArray() throws ParseIntException {
        Object[] intArr = rng.generateArrayOf(1, 3);

        assertNotNull(intArr); // since I put length 3, arr can't be null
        assertEquals(3, intArr.length); // arr should have 3 items inside it
    }

}
