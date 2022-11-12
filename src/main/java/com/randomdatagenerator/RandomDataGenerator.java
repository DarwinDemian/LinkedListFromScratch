package java.com.randomdatagenerator;

import java.com.exceptions.ParseIntException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class RandomDataGenerator {

    // **************
    // PRIVATE FIELDS
    // **************

    private Random generator = new Random(0);
    private Object seed;

    // *****************
    // GETTERS & SETTERS
    // *****************

    public Object getSeed() {
        return seed;
    }

    private void setSeed(Object seed) {
        this.seed = seed;
    }

    private void setGeneratorSeed(Object seed) throws ParseIntException {
        // Set seed depending on parameter type
        if (seed instanceof Integer) {

            // Just generate seed with given value
            this.generator = new Random((Integer) seed);
        } else {
            try {
                // Parse it to integer
                this.generator = new Random(Integer.parseInt((String) seed));

            } catch (Exception e) {
                // Value passed could not be parsed to Int
                throw new ParseIntException(seed);
            }

        }

        // Set seed so you can know what seed you're using
        setSeed(seed);
    }

    // ***************
    // PRIVATE METHODS
    // ***************

    private int generateRandomInt() {
        // Using Random to generate random int from 1 to 50
        return generator.nextInt(50 - 1) + 1;
    }

    private String generateRandomString() {
        // Creating byte array with length 8 -> length for new Random String
        byte[] array = new byte[8];
        generator.nextBytes(array);

        return new String(array, StandardCharsets.UTF_8);
    }

    // **************
    // PUBLIC METHODS
    // **************

    public Object generateRandomData(Object seed) throws ParseIntException {
        // first set seed
        setGeneratorSeed(seed);

        // return string or int depending on what was given as an argument
        return seed instanceof String ? generateRandomString() : generateRandomInt();
    }

    public Object[] generateArrayOf(Object seed, int length) throws ParseIntException {
        // set length for object array
        Object[] objectArray = new Object[length];

        // keep generating random data for length
        for (int i = 0; i < objectArray.length; i++) {
            objectArray[i] = generateRandomData(seed);
        }

        return objectArray;
    }

}
