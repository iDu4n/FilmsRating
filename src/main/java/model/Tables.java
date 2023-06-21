package model;

import model.CRUDutils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Tables {

    public static void start() throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Actors \n" +
                           "2. Category \n" +
                           "3. Comments \n" +
                           "4. Country \n" +
                           "5. Film \n" +
                           "6. Producer \n" +
                           "7. Rating \n" +
                           "8. Reviews \n" +
                           "9. Ser_and_Act \n" +
                           "10. Ser_and_cat \n" +
                           "11. User \n" +
                           "12. Выйти");

        System.out.print("Выберите таблицу: ");
        int choiceTable = scanner.nextInt();

        if (choiceTable == 12) System.exit(0);

        System.out.print("1. SELECT \n" +
                         "2. INSERT \n" +
                         "3. UPDATE \n" +
                         "4. DELETE \n" +
                         "5. Вернуться к выбору таблицы \n" +
                         "Выберите операцию: ");

        int choiceOperation = scanner.nextInt();

        CRUDutils.start(choiceTable, choiceOperation);
    }
}
