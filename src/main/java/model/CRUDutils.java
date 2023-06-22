package model;

import model.crud.Delete;
import model.crud.Update;
import model.crud.Select;
import model.crud.Insert;

import java.sql.*;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRUDutils {

    private static int ser_id;
    private static int user_id;
    private static int id;
    private static int age;
    private static String username;
    private static String description;
    private static String name;
    private static String title;
    

    private static final Logger logger = Logger.getLogger(CRUDutils.class.getName());
    
    private static final Connection CONNECTION = DatabaseConnection.databaseConnect();

    public static void start(int choiceTable, int choiceOperation) throws SQLException {
        if (choiceOperation == 1) {
            Select.start(choiceTable);
        } else if (choiceOperation == 2) {
            Insert.start(choiceTable);
        } else if (choiceOperation == 3) {
            Update.start(choiceTable);
        } else if (choiceOperation == 4) {
            Delete.start(choiceTable);
        } else if (choiceOperation == 5) {
            Tables.start();
        } else {
            logger.log(Level.INFO, () -> "Некорректный выбор.");
        }
        Tables.start();
    }

    public static void selectActors() throws SQLException {
         try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                 ResultSet.CONCUR_UPDATABLE)) {

             ResultSet table = statement.executeQuery("SELECT * FROM public.\"Actors\"\n ORDER BY id ASC ");

             while (table.next()) {
                 id = table.getInt("id");
                 name = table.getString("name");
                 description = table.getString("description");
                 age = table.getInt("age");

                 logger.log(Level.INFO, () -> "ID: " + id + ", Name: " + name + ", Description: " + description + ", Age: " + age);
             }
             table.close();
         }
    }

    public static void selectCategory(){
        try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {

            ResultSet table = statement.executeQuery("SELECT * FROM public.\"Category\"\n ORDER BY id ASC ");

            while (table.next()) {
                id = table.getInt("id");
                title = table.getString("title");
                description = table.getString("description");
                
                logger.log(Level.INFO, () -> "ID: " + id + ", Title: " + title + ", Description: " + description);
            }

            table.close();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Ошибка в чтении таблицы.");
            e.printStackTrace();
        }
    }

    public static void selectComments(){
        try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {

            ResultSet table = statement.executeQuery("SELECT * FROM public.\"Comments\"\n ORDER BY id ASC ");

            while (table.next()) {
                id = table.getInt("id");
                username = table.getString("username");
                String comment = table.getString("commentary");
                ser_id = table.getInt("ser_id");
                user_id = table.getInt("user_id");

                logger.log(Level.INFO, () -> "ID: " + id + ", username: " + username + ", Commentary: "
                        + comment + ", ser_id: " + ser_id + ", user_id: " + user_id);
            }

            table.close();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Ошибка в чтении таблицы.");
            e.printStackTrace();
        }
    }

    public static void selectCountry(){
        try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {

            ResultSet table = statement.executeQuery("SELECT * FROM public.\"Country\"\n ORDER BY id ASC ");

            while (table.next()) {
                id = table.getInt("id");
                title = table.getString("title");
                description = table.getString("description");

                logger.log(Level.INFO, () -> "ID: " + id + ", Title: " + title + ", Description: " + description);
            }

            table.close();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Ошибка в чтении таблицы.");
            e.printStackTrace();
        }
    }

    public static void selectFilm(){
        try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {

            ResultSet table = statement.executeQuery("SELECT * FROM public.\"Film\"\n ORDER BY id ASC");

            while (table.next()) {
                id = table.getInt("id");
                title = table.getString("title");
                description = table.getString("description");
                int year = table.getInt("year");
                int prod_id = table.getInt("prod_id");
                int country_id = table.getInt("country_id");

                logger.log(Level.INFO, () -> "ID: " + id + ", Title: " + title + ", Description: "
                        + description + ", Year: " + year + ", prod_id: " + prod_id + ", country_id: " + country_id);
            }

            table.close();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Ошибка в чтении таблицы.");
            e.printStackTrace();
        }
    }

    public static void selectProducer() {
        try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {

            ResultSet table = statement.executeQuery("SELECT * FROM public.\"Producer\"\n ORDER BY id ASC ");

            while (table.next()) {
                id = table.getInt("id");
                name = table.getString("name");
                description = table.getString("description");
                age = table.getInt("age");

                logger.log(Level.INFO, () -> "ID: " + id + ", Name: " + name + ", Description: " + description + ", Age: " + age);
            }

            table.close();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Ошибка в чтении таблицы.");
            e.printStackTrace();
        }
    }

    public static void selectRating(){
        try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {

            ResultSet table = statement.executeQuery("SELECT * FROM public.\"Rating\"\n ORDER BY id ASC ");

            while (table.next()) {
                id = table.getInt("id");
                String kp = table.getString("kp");
                String imdb = table.getString("imdb");
                ser_id = table.getInt("ser_id");

                logger.log(Level.INFO, () -> "ID: " + id + ", Kp: " + kp + ", Imdb: " + imdb + ", ser_id: " + ser_id);
            }

            table.close();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Ошибка в чтении таблицы.");
            e.printStackTrace();
        }
    }

    public static void selectReviews(){
         try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                 ResultSet.CONCUR_UPDATABLE)) {

             ResultSet table = statement.executeQuery("SELECT * FROM public.\"Reviews\"\n ORDER BY id ASC ");

             while (table.next()) {
                 id = table.getInt("id");
                 username = table.getString("username");
                 String review = table.getString("review");
                 ser_id = table.getInt("ser_id");
                 user_id = table.getInt("user_id");

                 logger.log(Level.INFO, () -> "ID: " + id + ", username: " + username + ", Review: " + review
                         + ", ser_id: " + ser_id + ", user_id" + user_id);
             }

             table.close();
         } catch(SQLException e){
             logger.log(Level.INFO, () -> "Ошибка в чтении таблицы.");
             e.printStackTrace();
         }
    }

    public static void selectSerAndAct(){
         try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                 ResultSet.CONCUR_UPDATABLE)) {

             ResultSet table = statement.executeQuery("SELECT * FROM public.\"Ser_and_Act\"\n");

             while (table.next()) {
                 ser_id = table.getInt("ser_id");
                 int act_id = table.getInt("act_id");

                 logger.log(Level.INFO, () -> "ser_id: " + ser_id + ", act_id: " + act_id);
             }

             table.close();
         } catch(SQLException e){
             logger.log(Level.INFO, () -> "Ошибка в чтении таблицы.");
             e.printStackTrace();
         }
    }

    public static void selectSerAndCat() {

         try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                 ResultSet.CONCUR_UPDATABLE)) {

             ResultSet table = statement.executeQuery("SELECT * FROM public.\"Ser_and_cat\"\n");

             while (table.next()) {
                 ser_id = table.getInt("ser_id");
                 int cat_id = table.getInt("cat_id");

                 logger.log(Level.INFO, () -> "ser_id: " + ser_id + ", cat_id: " + cat_id);
             }

             table.close();
         } catch(SQLException e){
             logger.log(Level.INFO, () -> "Ошибка в чтении таблицы.");
             e.printStackTrace();
         }
    }

    public static void selectUser() {
        try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {

            ResultSet table = statement.executeQuery("SELECT * FROM public.\"User\"\n ORDER BY id ASC ");

            while (table.next()) {
                id = table.getInt("id");
                username = table.getString("username");
                String role = table.getString("role");
                String email = table.getString("email");
                String password = table.getString("password");

                logger.log(Level.INFO, () -> "ID: " + id + ", username: " + username + ", Role: "
                        + role + ", Email: " + email + ", Password: " + password);
            }

            table.close();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Ошибка в чтении таблицы.");
            e.printStackTrace();
        }
    }

    public static void selectUserList() {
        try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {

            ResultSet table = statement.executeQuery("SELECT id, username FROM public.\"User\"\n ORDER BY id ASC ");

            while (table.next()) {
                id = table.getInt("id");
                username = table.getString("username");

                logger.log(Level.INFO, () -> "ID: " + id + ", username: " + username);
            }
            table.close();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Ошибка в чтении таблицы.");
            e.printStackTrace();
        }

    }

    public static void insertActors() {

        String INSERT_SQL = """
                INSERT INTO public."Actors"(
                \tname, description, age)
                \tVALUES (?, ?, ?);""";

         try (PreparedStatement statement = CONNECTION.prepareStatement(INSERT_SQL)) {

             Scanner scanner = new Scanner(System.in);

             logger.log(Level.INFO, () -> "Введите ФИО, описание и возраст актёра: ");
             name = scanner.nextLine();
             description = scanner.nextLine();
             age = scanner.nextInt();

             statement.setString(1, name);
             statement.setString(2, description);
             statement.setInt(3, age);

             logger.log(Level.INFO, (Supplier<String>) statement);

             statement.executeUpdate();
         } catch(SQLException e){
             logger.log(Level.INFO, () -> "Не удалось заполнить строку таблицы.");
             e.printStackTrace();
         }
    }

    public static void insertCategory(){

        String INSERT_SQL = """
                INSERT INTO public."Category"(
                \ttitle, description)
                \tVALUES (?, ?);""";

         try (PreparedStatement statement = CONNECTION.prepareStatement(INSERT_SQL)) {

             Scanner scanner = new Scanner(System.in);

             logger.log(Level.INFO, () -> "Введите название категории и её описание: ");
             title = scanner.nextLine();
             description = scanner.nextLine();

             statement.setString(1, title);
             statement.setString(2, description);

             logger.log(Level.INFO, (Supplier<String>) statement);

             statement.executeUpdate();
         } catch(SQLException e){
             logger.log(Level.INFO, () -> "Не удалось заполнить строку таблицы.");
             e.printStackTrace();
         }
    }

    public static void insertComments() {

        logger.log(Level.INFO, () -> "Список фильмов:");
        selectFilm();
        logger.log(Level.INFO, () -> "Список пользователей");
        selectUserList();

        String INSERT_SQL = """
                INSERT INTO public."Comments"(
                \tusername, commentary, ser_id, user_id)
                \tVALUES (?, ?, ?, ?);""";

         try (PreparedStatement PreparedStatement = CONNECTION.prepareStatement(INSERT_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Введите имя пользователя, комментарий к сериалу, ID этого сериала и ID пользователя: ");
            username = scanner.nextLine();
            String commentary = scanner.nextLine();
            ser_id = scanner.nextInt();
            user_id = scanner.nextInt();

            PreparedStatement.setString(1, username);
            PreparedStatement.setString(2, commentary);
            PreparedStatement.setInt(3, ser_id);
            PreparedStatement.setInt(4, user_id);

            logger.log(Level.INFO, (Supplier<String>) PreparedStatement);

            PreparedStatement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось заполнить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void insertCountry() {

        String INSERT_SQL = """
                INSERT INTO public."Country"(
                \ttitle, description)
                \tVALUES (?, ?);""";

         try (PreparedStatement statement = CONNECTION.prepareStatement(INSERT_SQL)) {

             Scanner scanner = new Scanner(System.in);

             logger.log(Level.INFO, () -> "Введите название страны производства и описание этой страны: ");
             title = scanner.nextLine();
             description = scanner.nextLine();

             statement.setString(1, title);
             statement.setString(2, description);

             logger.log(Level.INFO, (Supplier<String>) statement);

             statement.executeUpdate();
         } catch(SQLException e){
             logger.log(Level.INFO, () -> "Не удалось заполнить строку таблицы.");
             e.printStackTrace();
         }
    }

    public static void insertFilm() {

        logger.log(Level.INFO, () -> "Список стран:");
        selectCountry();
        logger.log(Level.INFO, () -> "Список режиссёров:");
        selectProducer();

        String INSERT_SQL = """
                INSERT INTO public."Film"(
                \ttitle, description, year, "prod_id", "country_id")
                \tVALUES (?, ?, ?, ?, ?);""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(INSERT_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Введите название фильма, его описание, год выхода, ID режисера и ID страны: ");
            name = scanner.nextLine();
            description = scanner.nextLine();
            int year = scanner.nextInt();
            int prod_id = scanner.nextInt();
            int country_id = scanner.nextInt();

            statement.setString(1, name);
            statement.setString(2, description);
            statement.setInt(3, year);
            statement.setInt(4, prod_id);
            statement.setInt(5, country_id);

            logger.log(Level.INFO, (Supplier<String>) statement);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось заполнить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void insertProducer() {

        String INSERT_SQL = """
                INSERT INTO public."Producer"(
                \tname, description, age)
                \tVALUES (?, ?, ?);""";

         try (PreparedStatement statement = CONNECTION.prepareStatement(INSERT_SQL)) {

             Scanner scanner = new Scanner(System.in);

             logger.log(Level.INFO, () -> "Введите ФИО, описание и возраст продюсера: ");
             name = scanner.nextLine();
             description = scanner.nextLine();
             age = scanner.nextInt();

             statement.setString(1, name);
             statement.setString(2, description);
             statement.setInt(3, age);

             logger.log(Level.INFO, (Supplier<String>) statement);

             statement.executeUpdate();
         } catch(SQLException e){
             logger.log(Level.INFO, () -> "Не удалось заполнить строку таблицы.");
             e.printStackTrace();
         }
    }

    public static void insertRating() {
        logger.log(Level.INFO, () -> "Список фильмов:");
        selectFilm();

        String INSERT_SQL = """
                INSERT INTO public."Rating"(
                \tkp, imdb, ser_id)
                \tVALUES (?, ?, ?);""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(INSERT_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Оценку фильма на кинопоиске и imdb, ID фильма ");
            double kp = scanner.nextDouble();
            double imdb = scanner.nextDouble();
            ser_id = scanner.nextInt();

            statement.setDouble(1, kp);
            statement.setDouble(2, imdb);
            statement.setInt(3, ser_id);

            logger.log(Level.INFO, (Supplier<String>) statement);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось заполнить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void insertReviews() {

        logger.log(Level.INFO, () -> "Список фильмов:");
        selectFilm();
        logger.log(Level.INFO, () -> "Список пользователей");
        selectUserList();

        String INSERT_SQL = """
                INSERT INTO public."Reviews"(
                \tusername, review, ser_id, user_id)
                \tVALUES (?, ?, ?, ?);""";

         try (PreparedStatement statement = CONNECTION.prepareStatement(INSERT_SQL)) {

             Scanner scanner = new Scanner(System.in);

             logger.log(Level.INFO, () -> "Введите ФИО, описание и возраст актёра: ");
             username = scanner.nextLine();
             String review = scanner.nextLine();
             ser_id = scanner.nextInt();
             user_id = scanner.nextInt();

             statement.setString(1, username);
             statement.setString(2, review);
             statement.setInt(3, ser_id);
             statement.setInt(4, user_id);

             logger.log(Level.INFO, (Supplier<String>) statement);

             statement.executeUpdate();
         } catch(SQLException e){
             logger.log(Level.INFO, () -> "Не удалось заполнить строку таблицы.");
             e.printStackTrace();
         }
    }

    public static void insertSerAndAct() throws SQLException {

        logger.log(Level.INFO, () -> "Список фильмов:");
        selectFilm();
        logger.log(Level.INFO, () -> "Список актёров:");
        selectActors();

        String INSERT_SQL = """
                INSERT INTO public."Ser_and_Act"(
                \tser_id, act_id)
                \tVALUES (?, ?);""";

         try (PreparedStatement statement = CONNECTION.prepareStatement(INSERT_SQL)) {

             Scanner scanner = new Scanner(System.in);

             logger.log(Level.INFO, () -> "Введите ID фильма и ID актёра: ");
             ser_id = scanner.nextInt();
             int act_id = scanner.nextInt();

             statement.setInt(1, ser_id);
             statement.setInt(2, act_id);

             logger.log(Level.INFO, (Supplier<String>) statement);

             statement.executeUpdate();
         } catch(SQLException e){
             logger.log(Level.INFO, () -> "Не удалось заполнить строку таблицы.");
             e.printStackTrace();
         }
    }

    public static void insertSerAndCat() {

        logger.log(Level.INFO, () -> "Список фильмов:");
        selectFilm();
        logger.log(Level.INFO, () -> "Список категорий:");
        selectCategory();

        String INSERT_SQL = """
                INSERT INTO public."Ser_and_cat"(
                \tser_id, cat_id)
                \tVALUES (?, ?);""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(INSERT_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Введите ID фильма и ID категории фильма: ");
            ser_id = scanner.nextInt();
            int cat_id = scanner.nextInt();

            statement.setInt(1, ser_id);
            statement.setInt(2, cat_id);

            logger.log(Level.INFO, (Supplier<String>) statement);

            statement.executeUpdate();

        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось заполнить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void insertUser() {

        String INSERT_SQL = """
                INSERT INTO public."User"(
                \tusername, role, email, password)
                \tVALUES (?, ?, ?, ?);""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(INSERT_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Введите имя пользователя, его роль, электронную почту и пароль: ");
            username = scanner.nextLine();
            String role = scanner.nextLine();
            String email = scanner.nextLine();
            String password = scanner.nextLine();

            statement.setString(1, username);
            statement.setString(2, role);
            statement.setString(3, email);
            statement.setString(4, password);

            logger.log(Level.INFO, (Supplier<String>) statement);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось заполнить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void deleteActors() throws SQLException {

        logger.log(Level.INFO, () -> "Список фильмов" + "\u001B[31m" + " (не внешний ключ):" + "\u001B[0m");
        selectFilm();
        logger.log(Level.INFO, () -> "Список зависимостей фильмов и актёров:");
        selectSerAndAct();
        logger.log(Level.INFO, () -> "Список актёров:");
        selectActors();

        String DELETE_SQL = "DELETE FROM public.\"Actors\"\n" +
                            "WHERE id = ?;";

        try (PreparedStatement statement = CONNECTION.prepareStatement(DELETE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Введите ID актёра, которого хотите удалить: ");
            id = scanner.nextInt();

            statement.setInt(1, id);

            logger.log(Level.INFO, (Supplier<String>) statement);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось удалить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void deleteCategory() {

        logger.log(Level.INFO, () -> "Список зависимостей фильмов и категорий:");
        selectSerAndCat();
        logger.log(Level.INFO, () -> "Список категорий:");
        selectSerAndCat();

        String DELETE_SQL = "DELETE FROM public.\"Category\"\n" +
                "WHERE id = ?;";

        try (PreparedStatement statement = CONNECTION.prepareStatement(DELETE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Введите ID категории, которую хотите удалить: ");
            id = scanner.nextInt();

            statement.setInt(1, id);

            logger.log(Level.INFO, (Supplier<String>) statement);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось удалить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void deleteComments() {

        logger.log(Level.INFO, () -> "Список фильмов" + "\u001B[31m" + " (не внешний ключ):" + "\u001B[0m");
        selectFilm();
        logger.log(Level.INFO, () -> "Список комментариев:");
        selectComments();

        String DELETE_SQL = "DELETE FROM public.\"Comments\"\n" +
                "WHERE id = ?;";

        try (PreparedStatement statement = CONNECTION.prepareStatement(DELETE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Введите ID комментария, который необходимо удалить: ");
            id = scanner.nextInt();

            statement.setInt(1, id);

            logger.log(Level.INFO, (Supplier<String>) statement);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось удалить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void deleteCountry() {

        logger.log(Level.INFO, () -> "Список стран:");
        selectCountry();

        String DELETE_SQL = "DELETE FROM public.\"Country\"\n" +
                "WHERE id = ?;";

        try (PreparedStatement statement = CONNECTION.prepareStatement(DELETE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Введите ID страны, которую необходимо удалить: ");
            id = scanner.nextInt();

            statement.setInt(1, id);

            logger.log(Level.INFO, (Supplier<String>) statement);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось удалить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void deleteFilm() {

        logger.log(Level.INFO, () -> "Список зависимостей фильмов и актёров:");
        selectSerAndAct();
        logger.log(Level.INFO, () -> "Список зависимостей фильмов и категорий:");
        selectSerAndCat();
        logger.log(Level.INFO, () -> "Список фильмов и их оценок:");
        selectRating();
        logger.log(Level.INFO, () -> "Список фильмов и их отзывов:");
        selectComments();
        logger.log(Level.INFO, () -> "Список фильмов и их рецензий:");
        selectReviews();
        logger.log(Level.INFO, () -> "Список фильмов:");
        selectFilm();

        String DELETE_SQL = "DELETE FROM public.\"Film\"\n" +
                "WHERE id = ?;";

        try (PreparedStatement statement = CONNECTION.prepareStatement(DELETE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Введите ID фильма, которого хотите удалить: ");
            id = scanner.nextInt();

            statement.setInt(1, id);

            logger.log(Level.INFO, (Supplier<String>) statement);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось удалить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void deleteProducer() {

        logger.log(Level.INFO, () -> "Список фильмов:");
        selectFilm();
        logger.log(Level.INFO, () -> "Список режиссёров:");
        selectProducer();

        String DELETE_SQL = "DELETE FROM public.\"Producer\"\n" +
                "WHERE id = ?;";

        try (PreparedStatement statement = CONNECTION.prepareStatement(DELETE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Введите ID режиссёра, которого хотите удалить: ");
            id = scanner.nextInt();

            statement.setInt(1, id);

            logger.log(Level.INFO, (Supplier<String>) statement);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось удалить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void deleteRating() {

        logger.log(Level.INFO, () -> "Список фильмов" + "\u001B[31m" + " (не внешний ключ):" + "\u001B[0m");
        selectFilm();
        logger.log(Level.INFO, () -> "Список оценок:");
        selectRating();

        String DELETE_SQL = "DELETE FROM public.\"Rating\"\n" +
                "WHERE id = ?;";

        try (PreparedStatement statement = CONNECTION.prepareStatement(DELETE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Введите ID фильма и его оценок, которые хотите удалить: ");
            id = scanner.nextInt();

            statement.setInt(1, id);

            logger.log(Level.INFO, (Supplier<String>) statement);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось удалить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void deleteReviews() {

        logger.log(Level.INFO, () -> "Список фильмов" + "\u001B[31m" + " (не внешний ключ):" + "\u001B[0m");
        selectFilm();
        logger.log(Level.INFO, () -> "Список рецензий:");
        selectReviews();

        String DELETE_SQL = "DELETE FROM public.\"Reviews\"\n" +
                "WHERE id = ?;";

        try (PreparedStatement statement = CONNECTION.prepareStatement(DELETE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Введите ID рецензии, которую хотите удалить: ");
            id = scanner.nextInt();

            statement.setInt(1, id);

            logger.log(Level.INFO, (Supplier<String>) statement);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось удалить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void deleteSerAndAct() throws SQLException {

        logger.log(Level.INFO, () -> "Список фильмов" + "\u001B[31m" + " (не внешний ключ):" + "\u001B[0m");
        selectFilm();
        logger.log(Level.INFO, () -> "Список актёров" + "\u001B[31m" + " (не внешний ключ):" + "\u001B[0m");
        selectActors();
        logger.log(Level.INFO, () -> "Список зависимостей фильмов и актёров:");
        selectSerAndAct();

        String DELETE_SQL = "DELETE FROM public.\"Ser_and_Act\"\n" +
                "WHERE id = ?;";

        try (PreparedStatement statement = CONNECTION.prepareStatement(DELETE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Введите ID актёра, которого хотите удалить: ");
            id = scanner.nextInt();

            statement.setInt(1, id);

            logger.log(Level.INFO, (Supplier<String>) statement);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось удалить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void deleteSerAndCat() {

        logger.log(Level.INFO, () -> "Список фильмов" + "\u001B[31m" + " (не внешний ключ):" + "\u001B[0m");
        selectFilm();
        logger.log(Level.INFO, () -> "Список категорий" + "\u001B[31m" + " (не внешний ключ):" + "\u001B[0m");
        selectCategory();
        logger.log(Level.INFO, () -> "Список зависимостей фильмов и категорий:");
        selectSerAndCat();

        String DELETE_SQL = "DELETE FROM public.\"Ser_and_cat\"\n" +
                "WHERE id = ?;";

        try (PreparedStatement statement = CONNECTION.prepareStatement(DELETE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Введите ID актёра, которого хотите удалить: ");
            id = scanner.nextInt();

            statement.setInt(1, id);

            logger.log(Level.INFO, (Supplier<String>) statement);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось удалить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void deleteUser() {

        logger.log(Level.INFO, () -> "Список отзывов:");
        selectComments();
        logger.log(Level.INFO, () -> "Список рецензий:");
        selectReviews();
        logger.log(Level.INFO, () -> "Список пользователей:");
        selectUserList();

        String DELETE_SQL = "DELETE FROM public.\"User\"\n" +
                "WHERE id = ?;";

        try (PreparedStatement statement = CONNECTION.prepareStatement(DELETE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Введите ID актёра, которого хотите удалить: ");
            id = scanner.nextInt();

            statement.setInt(1, id);

            logger.log(Level.INFO, (Supplier<String>) statement);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось удалить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void updateActors() throws SQLException {

        logger.log(Level.INFO, () -> "Список актёров:");
        selectActors();

        String UPDATE_SQL = """
                UPDATE public."Actors"
                	SET name=?, description=?, age=?
                	WHERE id=?;""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(UPDATE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Актёр, данные о котором необходимо заменить: ");
            id = scanner.nextInt();
            scanner.nextLine();
            logger.log(Level.INFO, () -> "Напишите имя, описание и возраст актёра: ");
            name = scanner.nextLine();
            description = scanner.nextLine();
            age = scanner.nextInt();

            statement.setString(1, name);
            statement.setString(2, description);
            statement.setInt(3, age);
            statement.setInt(4, id);

            logger.log(Level.INFO, (Supplier<String>) statement);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось изменить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void updateCategory() throws SQLException {

        logger.log(Level.INFO, () -> "Список категорий:");
        selectActors();

        String UPDATE_SQL = """
                UPDATE public."Category"
                	SET title=?, description=?
                	WHERE id = ?;""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(UPDATE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Введите ID категории, которую необходимо изменить: ");
            id = scanner.nextInt();
            scanner.nextLine();
            logger.log(Level.INFO, () -> "Введите название и описание категории: ");
            title = scanner.nextLine();
            description = scanner.nextLine();

            statement.setString(1, title);
            statement.setString(2, description);
            statement.setInt(3, id);

            logger.log(Level.INFO, (Supplier<String>) statement);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось изменить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void updateComments() {

        logger.log(Level.INFO, () -> "Список фильмов:");
        selectFilm();
        logger.log(Level.INFO, () -> "Список пользователей:");
        selectUserList();
        logger.log(Level.INFO, () -> "Список комментариев");
        selectComments();

        String UPDATE_SQL = """
                UPDATE public."Comments"
                	SET username=?, commentary=?, ser_id=?, user_id=?
                	WHERE id = ?""";

        try (PreparedStatement PreparedStatement = CONNECTION.prepareStatement(UPDATE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Введите ID комментария, который  необходимо изменить: ");
            id = scanner.nextInt();
            scanner.nextLine();
            logger.log(Level.INFO, () -> "Введите имя пользователя, комментарий к сериалу, ID этого сериала и ID пользователя: ");
            username = scanner.nextLine();
            String commentary = scanner.nextLine();
            ser_id = scanner.nextInt();
            user_id = scanner.nextInt();

            PreparedStatement.setString(1, username);
            PreparedStatement.setString(2, commentary);
            PreparedStatement.setInt(3, ser_id);
            PreparedStatement.setInt(4, user_id);
            PreparedStatement.setInt(5, id);

            logger.log(Level.INFO, (Supplier<String>) PreparedStatement);

            PreparedStatement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось изменить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void updateCountry() {

        logger.log(Level.INFO, () -> "Список стран:");
        selectCountry();

        String UPDATE_SQL = """
                UPDATE public."Country"
                	SET title=?, description=?
                	WHERE id=?;""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(UPDATE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Введите ID страны, которую необходимо изменить: ");
            id = scanner.nextInt();
            scanner.nextLine();
            logger.log(Level.INFO, () -> "Введите название страны производства и описание этой страны: ");
            title = scanner.nextLine();
            description = scanner.nextLine();

            statement.setString(1, title);
            statement.setString(2, description);
            statement.setInt(3, id);

            logger.log(Level.INFO, (Supplier<String>) statement);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось изменить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void updateFilm() {

        logger.log(Level.INFO, () -> "Список фильмов:");
        selectFilm();
        logger.log(Level.INFO, () -> "Список стран:");
        selectCountry();
        logger.log(Level.INFO, () -> "Список режиссёров:");
        selectProducer();

        String UPDATE_SQL = """
                UPDATE public."Film"
                	SET title=?, description=?, year=?, prod_id=?, country_id=?
                	WHERE id=?;""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(UPDATE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Введите ID фильма, который необходимо изменить: ");
            id = scanner.nextInt();
            scanner.nextLine();
            logger.log(Level.INFO, () -> "Введите название фильма, его описание, год выхода, ID режисера и ID страны: ");
            name = scanner.nextLine();
            description = scanner.nextLine();
            int year = scanner.nextInt();
            int prod_id = scanner.nextInt();
            int country_id = scanner.nextInt();

            statement.setString(1, name);
            statement.setString(2, description);
            statement.setInt(3, year);
            statement.setInt(4, prod_id);
            statement.setInt(5, country_id);
            statement.setInt(6, id);

            logger.log(Level.INFO, (Supplier<String>) statement);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось изменить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void updateProducer() {

        logger.log(Level.INFO, () -> "Список режиссёров:");
        selectProducer();

        String UPDATE_SQL = """
                UPDATE public."Producer"
                	SET name=?, description=?, age=?
                	WHERE id=?;""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(UPDATE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Введите ID режиссёра, которого необходимо изменить: ");
            id = scanner.nextInt();
            scanner.nextLine();
            logger.log(Level.INFO, () -> "Введите ФИО, описание и возраст продюсера: ");
            name = scanner.nextLine();
            description = scanner.nextLine();
            age = scanner.nextInt();

            statement.setString(1, name);
            statement.setString(2, description);
            statement.setInt(3, age);
            statement.setInt(4, id);

            logger.log(Level.INFO, (Supplier<String>) statement);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось изменить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void updateRating() {

        logger.log(Level.INFO, () -> "Список фильмов:");
        selectFilm();
        logger.log(Level.INFO, () -> "Список рейтингов:");
        selectRating();

        String UPDATE_SQL = """
                UPDATE public."Rating"
                    SET kp=?, imdb=?, ser_id=?
                    WHERE id=?;""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(UPDATE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Введите ID строчки в рейтинге, которую необходимо изменить: ");
            id = scanner.nextInt();
            scanner.nextLine();
            logger.log(Level.INFO, () -> "Введите оценку фильма на кинопоиске и imdb, а также ID фильма ");
            double kp = scanner.nextDouble();
            double imdb = scanner.nextDouble();
            ser_id = scanner.nextInt();

            statement.setDouble(1, kp);
            statement.setDouble(2, imdb);
            statement.setInt(3, ser_id);
            statement.setInt(4, id);

            logger.log(Level.INFO, (Supplier<String>) statement);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось изменить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void updateReviews() {

        logger.log(Level.INFO, () -> "Список фильмов:");
        selectFilm();
        logger.log(Level.INFO, () -> "Список пользователей");
        selectUserList();
        logger.log(Level.INFO, () -> "Список рецензий");
        selectReviews();

        String UPDATE_SQL = """
                UPDATE public."Reviews"
                	SET username=?, review=?, ser_id=?, user_id=?
                	WHERE id=?;""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(UPDATE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Введите ID рецензии, которую необходимо изменить: ");
            id = scanner.nextInt();
            scanner.nextLine();
            logger.log(Level.INFO, () -> "Введите ФИО, описание и возраст актёра: ");
            username = scanner.nextLine();
            String review = scanner.nextLine();
            ser_id = scanner.nextInt();
            user_id = scanner.nextInt();

            statement.setString(1, username);
            statement.setString(2, review);
            statement.setInt(3, ser_id);
            statement.setInt(4, user_id);
            statement.setInt(5, id);

            logger.log(Level.INFO, (Supplier<String>) statement);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось изменить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void updateSerAndAct() throws SQLException {

        logger.log(Level.INFO, () -> "Список фильмов:");
        selectFilm();
        logger.log(Level.INFO, () -> "Список актёров:");
        selectActors();
        logger.log(Level.INFO, () -> "Список фильмов и актёров:");
        selectSerAndAct();

        String UPDATE_SQL = """
                UPDATE public."Ser_and_Act"
                	SET ser_id=?, act_id=?
                	WHERE ser_id=? AND act_id=?;""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(UPDATE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Введите ID фильма и ID актёра, отношение которых хотите поменять: ");
            int ser_id_change = scanner.nextInt();
            int act_id_change = scanner.nextInt();
            logger.log(Level.INFO, () -> "Введите новые ID фильма и ID актёра: ");
            ser_id = scanner.nextInt();
            int act_id = scanner.nextInt();

            statement.setInt(1, ser_id);
            statement.setInt(2, act_id);
            statement.setInt(3, ser_id_change);
            statement.setInt(4, act_id_change);

            logger.log(Level.INFO, (Supplier<String>) statement);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось изменить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void updateSerAndCat() {

        logger.log(Level.INFO, () -> "Список фильмов:");
        selectFilm();
        logger.log(Level.INFO, () -> "Список категорий:");
        selectCategory();
        logger.log(Level.INFO, () -> "Отношение фильмов и категорий:");
        selectSerAndCat();

        String UPDATE_SQL = """
                 UPDATE public."Ser_and_cat"
                    SET ser_id=?, cat_id=?
                    WHERE ser_id=? AND cat_id=?;""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(UPDATE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Введите ID фильма и ID категории, отношение которых хотите поменять: ");
            int ser_id_change = scanner.nextInt();
            int act_id_change = scanner.nextInt();
            logger.log(Level.INFO, () -> "Введите новые ID фильма и ID категории фильма: ");
            ser_id = scanner.nextInt();
            int cat_id = scanner.nextInt();

            statement.setInt(1, ser_id);
            statement.setInt(2, cat_id);
            statement.setInt(3, ser_id_change);
            statement.setInt(4, act_id_change);

            logger.log(Level.INFO, (Supplier<String>) statement);

            statement.executeUpdate();

        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось изменить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void updateUser() throws SQLException {

        logger.log(Level.INFO, () -> "Список пользователей:");
        selectActors();

        String UPDATE_SQL = """
                INSERT INTO public."User"(
                \tusername, role, email, password)
                \tVALUES (?, ?, ?, ?);""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(UPDATE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "Введите ID категории, которую необходимо изменить: ");
            id = scanner.nextInt();
            scanner.nextLine();
            logger.log(Level.INFO, () -> "Введите имя пользователя, его роль, электронную почту и пароль: ");
            username = scanner.nextLine();
            String role = scanner.nextLine();
            String email = scanner.nextLine();
            String password = scanner.nextLine();

            statement.setString(1, username);
            statement.setString(2, role);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.setInt(5, id);

            logger.log(Level.INFO, (Supplier<String>) statement);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> "Не удалось изменить строку таблицы.");
            e.printStackTrace();
        }
    }
}
