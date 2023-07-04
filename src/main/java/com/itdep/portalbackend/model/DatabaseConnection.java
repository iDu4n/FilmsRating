package com.itdep.portalbackend.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {

    private static final Logger logger = Logger.getLogger(DatabaseConnection.class.getName());
    private static Connection connection = null;

    private DatabaseConnection() {}
    public static Connection databaseConnect() {
        Properties property = new Properties();

        String url = "";
        String login = "";
        String password = "";

        try (FileInputStream fis = new FileInputStream("src/main/resources/file.txt")) {
            property.load(fis);

            url = property.getProperty("url");
            login = property.getProperty("login");
            password = property.getProperty("password");

        } catch (
                IOException e) {
            logger.log(Level.INFO, () -> "\nОШИБКА: Файл свойств отсуствует!");
        }

        try {
            connection = DriverManager
                    .getConnection(url, login, password);
            logger.log(Level.INFO, () -> "\nYou successfully connected to database");
        } catch (
                SQLException e) {
            logger.log(Level.INFO, () -> "\nConnection Failed");
            throw new IllegalArgumentException(e);
        }

        return connection;
    }
}
