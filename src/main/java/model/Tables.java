package model;

import model.CRUDutils;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Tables {

    private static final Logger logger = Logger.getLogger(Tables.class.getName());
    private Tables() {}
    public static void start() throws SQLException {

        Scanner scanner = new Scanner(System.in);

        logger.log(Level.INFO, () -> "1. Actors \n" +
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

        logger.log(Level.INFO, () -> "Выберите таблицу: ");
        int choiceTable = scanner.nextInt();

        if (choiceTable == 12) System.exit(0);

        logger.log(Level.INFO, () -> "1. SELECT \n" +
                         "2. INSERT \n" +
                         "3. UPDATE \n" +
                         "4. DELETE \n" +
                         "5. Вернуться к выбору таблицы \n" +
                         "Выберите операцию: ");

        int choiceOperation = scanner.nextInt();

        CRUDutils.start(choiceTable, choiceOperation);
    }
}
