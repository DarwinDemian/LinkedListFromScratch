package randomdatagenerator;

import com.project.exceptions.ParseIntException;
import com.project.randomdatagenerator.RandomDataGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomDataGeneratorUnitTest {
    RandomDataGenerator rng = new RandomDataGenerator();

    // ****************
    // TEST RETURN TYPE 
    // ****************

    @Test
    public void testIntegerType() throws ParseIntException {
        Object integerVal = rng.generateRandomData(2);

        assertTrue(integerVal instanceof Integer);
    }

    @Test
    public void testStringType() throws ParseIntException {
        Object stringVal = rng.generateRandomData("1");

        assertTrue(stringVal instanceof String);
    }

    // *****************
    // TEST RANDOM VALUE 
    // *****************

    @Test
    public void testRandomInteger() throws ParseIntException {
        Object integerVal = rng.generateRandomData(1);
        Object integerVal2 = rng.generateRandomData(2);

        assertNotEquals(integerVal, integerVal2);
    }

    @Test
    public void testRandomString() throws ParseIntException {
        Object stringVal1 = rng.generateRandomData("1");
        Object stringVal2 = rng.generateRandomData("2");

        assertNotEquals(stringVal1, stringVal2);
    }

    @Test
    public void testIntegerArray() throws ParseIntException {
        Object[] intArr = rng.generateArrayOf(1, 3);

        assertNotNull(intArr);
        assertEquals(3, intArr.length);
    }

}
