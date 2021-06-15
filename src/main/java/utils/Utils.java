package utils;

import java.util.Random;

/**
 * Application utils (singleton pattern used)
 */
public class Utils {
    private Random random = new Random();
    private static Utils instance = new Utils();

    /**
     * Private constructor to apply pattern
     */
    private Utils() {
    }

    /**
     * Get utils class instance
     *
     * @return the instance of the singleton
     */
    public static Utils getInstance() {
        return instance;
    }

    /**
     * Get a random integer between given min and max numbers
     *
     * @param min value
     * @param max value
     * @return the random integer
     */
    public int randomInt(int min, int max) {
        return random.nextInt(max + 1 - min) + min;
    }

    /**
     * Get a random integer between 0 and a given max numbers
     *
     * @param max value
     * @return the random integer
     */
    public int randomInt(int max) {
        return random.nextInt(max);
    }

    /**
     * Get a random float between given min and max numbers
     *
     * @param min value
     * @param max value
     * @return the random float
     */
    public float randomFloat(float min, float max) {
        return random.nextFloat() * (max - min) + min;
    }

    /**
     * Get a random float between 0 and a given max numbers
     *
     * @param max value
     * @return the random float
     */
    public float randomFloat(float max) {
        return randomFloat(0, max);
    }
}
