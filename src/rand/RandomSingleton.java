package rand;

import java.util.Random;

public class RandomSingleton {
    private static RandomSingleton instance = null;
    private Random random;

    private RandomSingleton() {
        random = new Random();
    }

    public static RandomSingleton getInstance() {
        if (instance == null) {
            instance = new RandomSingleton();
        }
        return instance;
    }

    public Random getRandom() {
        return random;
    }
}
