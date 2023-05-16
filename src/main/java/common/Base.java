package common;

public class Base {

    protected static String env;

    protected void sleep(long millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public long getRandomNumber() {
        return System.currentTimeMillis();
    }
}
