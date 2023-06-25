import config.ConfigurationHolder;
import config.ConfigurationInitializer;

public class Main {
    public static void main(String[] args) {
        ConfigurationHolder configuration = new ConfigurationInitializer().getHolder();
    }
}
