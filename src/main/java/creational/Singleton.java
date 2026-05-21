package creational;

class Logger {
    private static Logger instance = null;

    private Logger() {

    }

    public static Logger getInstance() {
        instance = ((instance == null) ? new Logger() : instance);
        return instance;
    }

    public void test() {
        System.out.println("This is an instance of Logger class");
    }
}

public class Singleton {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.test();
    }
}