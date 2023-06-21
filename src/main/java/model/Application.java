package model;
import java.sql.*;

public class Application {
    public static void main(String[] argv) throws SQLException {

        Tables.start();

        System.out.println("Конец");
    }
}