package model;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Application {

    private static final Logger logger = Logger.getLogger(Application.class.getName());

    public static void main(String[] argv) throws SQLException {

        Tables.start();

        logger.log(Level.INFO, () -> "\nКонец");
    }

    private Application() {}
}