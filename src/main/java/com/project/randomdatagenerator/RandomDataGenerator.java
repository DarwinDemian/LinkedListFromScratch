package com.project.randomdatagenerator;

import com.project.exceptions.ParseIntException;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomDataGenerator {

    // **************
    // PRIVATE FIELDS
    // **************

    private Random generator = new Random(0);
    private Object seed = 0;

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

        // Make the seed used in this instance visible
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

        // setting parameters to RandomStringUtils
        int count = 8; // Length
        int start = 0; // start from ' '
        int end = 0; // end in 'z'
        boolean letters = true; // use letters
        boolean numbers = false; // use numbers
        char[] chars = null; // null, so it will use all chars

        return RandomStringUtils.random(count, start, end, letters, numbers, chars, this.generator);
    }

    // **************
    // PUBLIC METHODS
    // **************

    public Object generateRandomData(Object seed) throws ParseIntException {
        if (seed != null && getSeed() != seed) {
            // if seed is passed, use it, otherwise use default '0' or seed already defined
            setGeneratorSeed(seed);
        }

        // return string or int depending on what was given as an argument
        return seed instanceof String
                ? generateRandomString()
                : generateRandomInt();
    }

    public Object generateRandomData() throws ParseIntException {
        // if no argument is given, just generate data with random seed
        return generateRandomData(generateRandomInt());
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
