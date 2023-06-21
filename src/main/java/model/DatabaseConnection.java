package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    public static Connection databaseConnect() {
        FileInputStream fis;
        Properties property = new Properties();

        String url = "", login = "", password = "";

        try {
            fis = new FileInputStream("src/main/resources/file.txt");
            property.load(fis);

            url = property.getProperty("url");
            login = property.getProperty("login");
            password = property.getProperty("password");

        } catch (
                IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }

        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection(url, login, password);
            System.out.println("You successfully connected to database");
        } catch (
                SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }

        return connection;
    }
}
