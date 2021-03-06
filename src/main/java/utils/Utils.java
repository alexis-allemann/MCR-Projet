package utils;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.Random;

/**
 * Application utils (singleton pattern used)
 */
public class Utils {
    private static final Utils INSTANCE = new Utils();
    private final Random RANDOM = new Random();
    private Properties properties;

    /**
     * Private constructor to apply pattern
     */
    private Utils() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream input = classloader.getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            properties = new Properties();
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Get utils class instance
     *
     * @return the instance of the singleton
     */
    public static Utils getInstance() {
        return INSTANCE;
    }

    /**
     * Get a random float between given min and max numbers
     *
     * @param min value
     * @param max value
     * @return the random float
     */
    public float randomFloat(float min, float max) {
        return RANDOM.nextFloat() * (max - min) + min;
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
     * @return object chosen or null if list is empty
     */
    public <T> T chooseRandomElement(List<T> objectList) {
        if (objectList.isEmpty())
            return null;
        int index = RANDOM.nextInt(objectList.size());
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

    /**
     * Get a property from config file
     *
     * @param propertyKey to find
     * @return the property value
     */
    public String getProperty(String propertyKey) {
        if (!properties.containsKey(propertyKey))
            throw new IllegalArgumentException("Property" + propertyKey + "missing in config.properties file");
        return properties.getProperty(propertyKey);
    }
}
