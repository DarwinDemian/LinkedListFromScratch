package tests;

import java.util.Random;


public class RandomDataGenerator {
    private Random generator = new Random(0);
    private Object seed;

    public Object getSeed() {
        return seed;
    }

    private void setSeed(Object seed) {
        this.seed = seed;
    }

    public void setGeneratorSeed(Object seed) {
        if (seed instanceof Integer) {
            this.generator = new Random((Integer) seed);
        }

        setSeed(seed);
    }

    // ***************
    // PRIVATE METHODS
    // ***************

    private int generateRandomInt() {
        return generator.nextInt(50 - 1) + 1;
    }

    private String generateRandomString() {
        // implement a seed and random string generator
        return "test";
    }

    // **************
    // PUBLIC METHODS
    // **************

    public Object generateRandomData(Object seed) {
        setGeneratorSeed(seed);
        return seed instanceof String ? generateRandomString() : generateRandomInt();
    }

    public Object[] generateArrayOf(Object seed, int length) {
        Object[] intArr = new Object[length];

        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = generateRandomData(seed);
        }

        return intArr;
    }

}
