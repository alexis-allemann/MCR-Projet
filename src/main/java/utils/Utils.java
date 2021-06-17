package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Application utils (singleton pattern used)
 */
public class Utils {
    private final Random random = new Random();
    private static final Utils instance = new Utils();

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

    /**
     * Choose random object in list
     *
     * @param objectList to choose an object
     * @return object choosen
     */
    public <T> T chooseRandom(List<T> objectList) {
        int index = randomInt(objectList.size() - 1);
        return objectList.get(index);
    }

    /**
     * Get image from resources with given filename
     *
     * @param filename of the image
     * @return the image
     */
    public Image getImageFromResources(String filename) {
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            return ImageIO.read(Objects.requireNonNull(classloader.getResource(filename)));
        } catch (IOException e) {
            System.out.println("Component image has not been found in resources");
        }
        return null;
    }
}
