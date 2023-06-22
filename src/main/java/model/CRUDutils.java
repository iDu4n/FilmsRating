package model;

import model.crud.Delete;
import model.crud.Update;
import model.crud.Select;
import model.crud.Insert;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRUDutils {

    private CRUDutils () {}

    private static int serID;
    private static int userID;
    private static int id;
    private static int age;
    private static String username;
    private static String description;
    private static String name;
    private static String title;
    private static final String STRINGUSERNAMECOLUMN = "username";
    private static final String STRINGUSERNAME = ", username: ";
    private static final String STRINGDESCRIPTIONCOLUMN = "description";
    private static final String STRINGDESCRIPTION = ", Description: ";
    private static final String STRINGTITLECOLUMN = "title";
    private static final String STRINGTITLE = ", Title: ";
    private static final String STRINGSERIDCOLUMN = "ser_id";
    private static final String STRINGSERID = ", serID: ";
    private static final String STRINGID = "\nID: ";
    private static final String READERROR = "\nОшибка в чтении таблицы.";
    private static final String INSERTERROR = "\nНе удалось заполнить строку таблицы.";
    private static final String DELETEERROR = "\nНе удалось удалить строку таблицы.";
    private static final String UPDATEERROR = "\nНе удалось изменить строку таблицы.";
    private static final String ACTORLIST = "\nСписок актёров:";
    private static final String CATEGORYLIST = "\nСписок категорий:";
    private static final String FILMLIST = "\nСписок фильмов";
    private static final String USERSLIST = "\nСписок пользователей";
    private static final String COUNTRYLIST = "\nСписок стран:";
    private static final String PRODUCERLIST = "\nСписок режиссёров:";
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
            logger.log(Level.INFO, () -> "\nНекорректный выбор.");
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
                 description = table.getString(STRINGDESCRIPTIONCOLUMN);
                 age = table.getInt("age");

                 logger.log(Level.INFO, () -> STRINGID + id + ", Name: " + name + STRINGDESCRIPTION + description + ", Age: " + age);
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
                title = table.getString(STRINGTITLECOLUMN);
                description = table.getString(STRINGDESCRIPTIONCOLUMN);
                
                logger.log(Level.INFO, () -> STRINGID + id + STRINGTITLE + title + STRINGDESCRIPTION + description);
            }

            table.close();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> READERROR);
            throw new RuntimeException(e);
        }
    }

    public static void selectComments(){
        try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {

            ResultSet table = statement.executeQuery("SELECT * FROM public.\"Comments\"\n ORDER BY id ASC ");

            while (table.next()) {
                id = table.getInt("id");
                username = table.getString(STRINGUSERNAMECOLUMN);
                String comment = table.getString("commentary");
                serID = table.getInt(STRINGSERIDCOLUMN);
                userID = table.getInt("user_id");

                logger.log(Level.INFO, () -> STRINGID + id + STRINGUSERNAME + username + ", Commentary: "
                        + comment + STRINGSERID + serID + ", userID: " + userID);
            }

            table.close();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> READERROR);
            throw new RuntimeException(e);
        }
    }

    public static void selectCountry(){
        try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {

            ResultSet table = statement.executeQuery("SELECT * FROM public.\"Country\"\n ORDER BY id ASC ");

            while (table.next()) {
                id = table.getInt("id");
                title = table.getString(STRINGTITLECOLUMN);
                description = table.getString(STRINGDESCRIPTIONCOLUMN);

                logger.log(Level.INFO, () -> STRINGID + id + STRINGTITLE + title + STRINGDESCRIPTION + description);
            }

            table.close();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> READERROR);
            throw new RuntimeException(e);
        }
    }

    public static void selectFilm(){
        try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {

            ResultSet table = statement.executeQuery("SELECT * FROM public.\"Film\"\n ORDER BY id ASC");

            while (table.next()) {
                id = table.getInt("id");
                title = table.getString(STRINGTITLECOLUMN);
                description = table.getString(STRINGDESCRIPTIONCOLUMN);
                int year = table.getInt("year");
                int prodID = table.getInt("prod_id");
                int countryID = table.getInt("country_id");

                logger.log(Level.INFO, () -> STRINGID + id + STRINGTITLE + title + STRINGDESCRIPTION
                        + description + ", Year: " + year + ", prodID: " + prodID + ", countryID: " + countryID);
            }

            table.close();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> READERROR);
            throw new RuntimeException(e);
        }
    }

    public static void selectProducer() {
        try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {

            ResultSet table = statement.executeQuery("SELECT * FROM public.\"Producer\"\n ORDER BY id ASC ");

            while (table.next()) {
                id = table.getInt("id");
                name = table.getString("name");
                description = table.getString(STRINGDESCRIPTIONCOLUMN);
                age = table.getInt("age");

                logger.log(Level.INFO, () -> STRINGID + id + ", Name: " + name + STRINGDESCRIPTION + description + ", Age: " + age);
            }

            table.close();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> READERROR);
            throw new RuntimeException(e);
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
                serID = table.getInt(STRINGSERIDCOLUMN);

                logger.log(Level.INFO, () -> STRINGID + id + ", Kp: " + kp + ", Imdb: " + imdb + STRINGSERID + serID);
            }

            table.close();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> READERROR);
            throw new RuntimeException(e);
        }
    }

    public static void selectReviews(){
         try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                 ResultSet.CONCUR_UPDATABLE)) {

             ResultSet table = statement.executeQuery("SELECT * FROM public.\"Reviews\"\n ORDER BY id ASC ");

             while (table.next()) {
                 id = table.getInt("id");
                 username = table.getString(STRINGUSERNAMECOLUMN);
                 String review = table.getString("review");
                 serID = table.getInt(STRINGSERIDCOLUMN);
                 userID = table.getInt("user_id");

                 logger.log(Level.INFO, () -> STRINGID + id + STRINGUSERNAME + username + ", Review: " + review
                         + STRINGSERID + serID + ", userID" + userID);
             }

             table.close();
         } catch(SQLException e){
             logger.log(Level.INFO, () -> READERROR);
             throw new RuntimeException(e);
         }
    }

    public static void selectSerAndAct(){
         try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                 ResultSet.CONCUR_UPDATABLE)) {

             ResultSet table = statement.executeQuery("SELECT * FROM public.\"Ser_and_Act\"\n");

             while (table.next()) {
                 serID = table.getInt(STRINGSERIDCOLUMN);
                 int actID = table.getInt("act_id");

                 logger.log(Level.INFO, () -> "\nser_id: " + serID + ", actID: " + actID);
             }

             table.close();
         } catch(SQLException e){
             logger.log(Level.INFO, () -> READERROR);
             throw new RuntimeException(e);
         }
    }

    public static void selectSerAndCat() {

         try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                 ResultSet.CONCUR_UPDATABLE)) {

             ResultSet table = statement.executeQuery("SELECT * FROM public.\"Ser_and_cat\"\n");

             while (table.next()) {
                 serID = table.getInt(STRINGSERIDCOLUMN);
                 int catID = table.getInt("cat_id");

                 logger.log(Level.INFO, () -> "\nser_id: " + serID + ", catID: " + catID);
             }

             table.close();
         } catch(SQLException e){
             logger.log(Level.INFO, () -> READERROR);
             throw new RuntimeException(e);
         }
    }

    public static void selectUser() {
        try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {

            ResultSet table = statement.executeQuery("SELECT * FROM public.\"User\"\n ORDER BY id ASC ");

            while (table.next()) {
                id = table.getInt("id");
                username = table.getString(STRINGUSERNAMECOLUMN);
                String role = table.getString("role");
                String email = table.getString("email");
                String password = table.getString("password");

                logger.log(Level.INFO, () -> STRINGID + id + STRINGUSERNAME + username + ", Role: "
                        + role + ", Email: " + email + ", Password: " + password);
            }

            table.close();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> READERROR);
            throw new RuntimeException(e);
        }
    }

    public static void selectUserList() {
        try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {

            ResultSet table = statement.executeQuery("SELECT id, username FROM public.\"User\"\n ORDER BY id ASC ");

            while (table.next()) {
                id = table.getInt("id");
                username = table.getString(STRINGUSERNAMECOLUMN);

                logger.log(Level.INFO, () -> STRINGID + id + STRINGUSERNAME + username);
            }
            table.close();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> READERROR);
            throw new RuntimeException(e);
        }

    }

    public static void insertActors() {

         try (PreparedStatement statement = CONNECTION.prepareStatement("INSERT INTO public.\"Actors\" (name, description, age)\tVALUES (?, ?, ?);")) {

             Scanner scanner = new Scanner(System.in);

             logger.log(Level.INFO, () -> "\nВведите ФИО,  описание и возраст актёра: ");
             name = scanner.nextLine();
             description = scanner.nextLine();
             age = scanner.nextInt();

             statement.setString(1, name);
             statement.setString(2, description);
             statement.setInt(3, age);

             statement.executeUpdate();
         } catch(SQLException e){
             logger.log(Level.INFO, () -> INSERTERROR);
             throw new RuntimeException(e);
         }
    }

    public static void insertCategory(){

         try (PreparedStatement statement = CONNECTION.prepareStatement("INSERT INTO public.\"Category\" (title, description) VALUES (?, ?);")) {

             Scanner scanner = new Scanner(System.in);

             logger.log(Level.INFO, () -> "\nВведите название категории и её описание: ");
             title = scanner.nextLine();
             description = scanner.nextLine();

             statement.setString(1, title);
             statement.setString(2, description);

             statement.executeUpdate();
         } catch(SQLException e){
             logger.log(Level.INFO, () -> INSERTERROR);
             throw new RuntimeException(e);
         }
    }

    public static void insertComments() {

        logger.log(Level.INFO, () -> FILMLIST);
        selectFilm();
        logger.log(Level.INFO, () -> USERSLIST);
        selectUserList();

         try (PreparedStatement statement = CONNECTION.prepareStatement("INSERT INTO public.\"Comments\" (username, commentary, ser_id, user_id) VALUES (?, ?, ?, ?);")) {


            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nВведите имя пользователя, комментарий к сериалу, ID этого сериала и ID пользователя: ");
            username = scanner.nextLine();
            String commentary = scanner.nextLine();
            serID = scanner.nextInt();
            userID = scanner.nextInt();

             statement.setString(1, username);
             statement.setString(2, commentary);
             statement.setInt(3, serID);
             statement.setInt(4, userID);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, (    ) -> INSERTERROR);
            throw new RuntimeException(e);
        }
    }

    public static void insertCountry() {

         try (PreparedStatement statement = CONNECTION.prepareStatement("INSERT INTO public.\"Country\"(title, description) VALUES (?, ?);")) {

             Scanner scanner = new Scanner(System.in);

             logger.log(Level.INFO, () -> "\nВведите название страны производства и описание этой страны: ");
             title = scanner.nextLine();
             description = scanner.nextLine();

             statement.setString(1, title);
             statement.setString(2, description);

             statement.executeUpdate();
         } catch(SQLException e){
             logger.log(Level.INFO, () -> INSERTERROR);
             throw new RuntimeException(e);
         }
    }

    public static void insertFilm() {

        logger.log(Level.INFO, () -> COUNTRYLIST);
        selectCountry();
        logger.log(Level.INFO, () -> PRODUCERLIST);
        selectProducer();

        try (PreparedStatement statement = CONNECTION.prepareStatement("INSERT INTO public.\"Film\"(\ttitle, description, year, prod_id, country_id) VALUES (?, ?, ?, ?, ?);")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nВведите название фильма, его описание, год выхода, ID режисера и ID страны: ");
            name = scanner.nextLine();
            description = scanner.nextLine();
            int year = scanner.nextInt();
            int prodID = scanner.nextInt();
            int countryID = scanner.nextInt();

            statement.setString(1, name);
            statement.setString(2, description);
            statement.setInt(3, year);
            statement.setInt(4, prodID);
            statement.setInt(5, countryID);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> INSERTERROR);
            throw new RuntimeException(e);
        }
    }

    public static void insertProducer() {

         try (PreparedStatement statement = CONNECTION.prepareStatement("INSERT INTO public.\"Producer\"(name, description, age) VALUES (?, ?, ?);")) {

             Scanner scanner = new Scanner(System.in);

             logger.log(Level.INFO, () -> "\nВведите ФИО, описание и возраст продюсера: ");
             name = scanner.nextLine();
             description = scanner.nextLine();
             age = scanner.nextInt();

             statement.setString(1, name);
             statement.setString(2, description);
             statement.setInt(3, age);

             statement.executeUpdate();
         } catch(SQLException e){
             logger.log(Level.INFO, () -> INSERTERROR);
             throw new RuntimeException(e);
         }
    }

    public static void insertRating() {
        logger.log(Level.INFO, () -> FILMLIST);
        selectFilm();

        try (PreparedStatement statement = CONNECTION.prepareStatement("INSERT INTO public.\"Rating\"(kp, imdb, ser_id) VALUES (?, ?, ?);")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nОценку фильма на кинопоиске и imdb, ID фильма ");
            double kp = scanner.nextDouble();
            double imdb = scanner.nextDouble();
            serID = scanner.nextInt();

            statement.setDouble(1, kp);
            statement.setDouble(2, imdb);
            statement.setInt(3, serID);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> INSERTERROR);
            throw new RuntimeException(e);
        }
    }

    public static void insertReviews() {

        logger.log(Level.INFO, () -> FILMLIST);
        selectFilm();
        logger.log(Level.INFO, () -> USERSLIST);
        selectUserList();

         try (PreparedStatement statement = CONNECTION.prepareStatement("INSERT INTO public.\"Reviews\"(username, review, ser_id, user_id)\tVALUES (?, ?, ?, ?);")) {

             Scanner scanner = new Scanner(System.in);

             logger.log(Level.INFO, () -> "\nВведите ФИО, описание и возраст актёра: ");
             username = scanner.nextLine();
             String review = scanner.nextLine();
             serID = scanner.nextInt();
             userID = scanner.nextInt();

             statement.setString(1, username);
             statement.setString(2, review);
             statement.setInt(3, serID);
             statement.setInt(4, userID);

             statement.executeUpdate();
         } catch(SQLException e){
             logger.log(Level.INFO, () -> INSERTERROR);
             throw new RuntimeException(e);
         }
    }

    public static void insertSerAndAct() throws SQLException {

        logger.log(Level.INFO, () -> FILMLIST);
        selectFilm();
        logger.log(Level.INFO, () -> ACTORLIST);
        selectActors();

         try (PreparedStatement statement = CONNECTION.prepareStatement("INSERT INTO public.\"Ser_and_Act\"(ser_id, act_id) VALUES (?, ?);")) {

             Scanner scanner = new Scanner(System.in);

             logger.log(Level.INFO, () -> "\nВведите ID фильма и ID актёра: ");
             serID = scanner.nextInt();
             int actID = scanner.nextInt();

             statement.setInt(1, serID);
             statement.setInt(2, actID);

             statement.executeUpdate();
         } catch(SQLException e){
             logger.log(Level.INFO, () -> INSERTERROR);
             throw new RuntimeException(e);
         }
    }

    public static void insertSerAndCat() {

        logger.log(Level.INFO, () -> FILMLIST);
        selectFilm();
        logger.log(Level.INFO, () -> CATEGORYLIST);
        selectCategory();

        try (PreparedStatement statement = CONNECTION.prepareStatement("INSERT INTO public.\"Ser_and_cat\"(ser_id, cat_id) VALUES (?, ?);")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nВведите ID фильма и ID категории фильма: ");
            serID = scanner.nextInt();
            int catID = scanner.nextInt();

            statement.setInt(1, serID);
            statement.setInt(2, catID);

            statement.executeUpdate();

        } catch(SQLException e){
            logger.log(Level.INFO, () -> INSERTERROR);
            throw new RuntimeException(e);
        }
    }

    public static void insertUser() {

        try (PreparedStatement statement = CONNECTION.prepareStatement("INSERT INTO public.\"User\"(username, role, email, password) VALUES (?, ?, ?, ?);")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nВведите имя пользователя, его роль, электронную почту и пароль: ");
            username = scanner.nextLine();
            String role = scanner.nextLine();
            String email = scanner.nextLine();
            String password = scanner.nextLine();

            statement.setString(1, username);
            statement.setString(2, role);
            statement.setString(3, email);
            statement.setString(4, password);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> INSERTERROR);
            throw new RuntimeException(e);
        }
    }

    public static void deleteActors() throws SQLException {

        logger.log(Level.INFO, () -> FILMLIST);
        selectFilm();
        logger.log(Level.INFO, () -> "\nСписок зависимостей  фильмов и актёров:");
        selectSerAndAct();
        logger.log(Level.INFO, () -> ACTORLIST);
        selectActors();

        try (PreparedStatement statement = CONNECTION.prepareStatement("DELETE FROM public.\"Actors\"\nWHERE id = ?;")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nВведите ID актёра, которого хотите удалить: ");
            id = scanner.nextInt();

            statement.setInt(1, id);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> DELETEERROR);
            throw new RuntimeException(e);
        }
    }

    public static void deleteCategory() {

        logger.log(Level.INFO, () -> "\nСписок зависимостей  фильмов и категорий:");
        selectSerAndCat();
        logger.log(Level.INFO, () -> CATEGORYLIST);
        selectSerAndCat();

        try (PreparedStatement statement = CONNECTION.prepareStatement("DELETE FROM public.\"Category\"\nWHERE id = ?;")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nВведите ID категории, которую хотите удалить: ");
            id = scanner.nextInt();

            statement.setInt(1, id);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> DELETEERROR);
            throw new RuntimeException(e);
        }
    }

    public static void deleteComments() {

        logger.log(Level.INFO, () -> FILMLIST);
        selectFilm();
        logger.log(Level.INFO, () -> "\nСписок комментариев:");
        selectComments();

        try (PreparedStatement statement = CONNECTION.prepareStatement("DELETE FROM public.\"Comments\"\nWHERE id = ?;")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nВведите ID комментария, который необходимо удалить: ");
            id = scanner.nextInt();

            statement.setInt(1, id);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> DELETEERROR);
            throw new RuntimeException(e);
        }
    }

    public static void deleteCountry() {

        logger.log(Level.INFO, () -> COUNTRYLIST);
        selectCountry();

        try (PreparedStatement statement = CONNECTION.prepareStatement("DELETE FROM public.\"Country\"\nWHERE id = ?;")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nВведите ID страны, которую необходимо удалить: ");
            id = scanner.nextInt();

            statement.setInt(1, id);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> DELETEERROR);
            throw new RuntimeException(e);
        }
    }

    public static void deleteFilm() {

        logger.log(Level.INFO, () -> "\nСписок зависимостей фильмов и актёров:");
        selectSerAndAct();
        logger.log(Level.INFO, () -> "\nСписок зависимостей фильмов и категорий:");
        selectSerAndCat();
        logger.log(Level.INFO, () -> "\nСписок фильмов и их оценок:");
        selectRating();
        logger.log(Level.INFO, () -> "\nСписок фильмов и их отзывов:");
        selectComments();
        logger.log(Level.INFO, () -> "\nСписок фильмов и их рецензий:");
        selectReviews();
        logger.log(Level.INFO, () -> FILMLIST);
        selectFilm();

        try (PreparedStatement statement = CONNECTION.prepareStatement("DELETE FROM public.\"Film\"\nWHERE id = ?;")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nВведите ID фильма, которого хотите удалить: ");
            id = scanner.nextInt();

            statement.setInt(1, id);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> DELETEERROR);
            throw new RuntimeException(e);
        }
    }

    public static void deleteProducer() {

        logger.log(Level.INFO, () -> FILMLIST);
        selectFilm();
        logger.log(Level.INFO, () -> PRODUCERLIST);
        selectProducer();

        try (PreparedStatement statement = CONNECTION.prepareStatement("DELETE FROM public.\"Producer\"\nWHERE id = ?;")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nВведите ID режиссёра, которого хотите удалить: ");
            id = scanner.nextInt();

            statement.setInt(1, id);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> DELETEERROR);
            throw new RuntimeException(e);
        }
    }

    public static void deleteRating() {

        logger.log(Level.INFO, () -> FILMLIST);
        selectFilm();
        logger.log(Level.INFO, () -> "\nСписок оценок:");
        selectRating();

        try (PreparedStatement statement = CONNECTION.prepareStatement("DELETE FROM public.\"Rating\"\nWHERE id = ?;")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nВведите ID фильма и его оценок, которые хотите удалить: ");
            id = scanner.nextInt();

            statement.setInt(1, id);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> DELETEERROR);
            throw new RuntimeException(e);
        }
    }

    public static void deleteReviews() {

        logger.log(Level.INFO, () -> FILMLIST);
        selectFilm();
        logger.log(Level.INFO, () -> "\nСписок рецензий:");
        selectReviews();

        try (PreparedStatement statement = CONNECTION.prepareStatement("DELETE FROM public.\"Reviews\"\nWHERE id = ?;")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nВведите ID рецензии, которую хотите удалить: ");
            id = scanner.nextInt();

            statement.setInt(1, id);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> DELETEERROR);
            throw new RuntimeException(e);
        }
    }

    public static void deleteSerAndAct() throws SQLException {

        logger.log(Level.INFO, () -> FILMLIST);
        selectFilm();
        logger.log(Level.INFO, () -> "\nСписок актёров");
        selectActors();
        logger.log(Level.INFO, () -> "\nСписок зависимостей фильмов и актёров:");
        selectSerAndAct();

        try (PreparedStatement statement = CONNECTION.prepareStatement("DELETE FROM public.\"Ser_and_Act\"\nWHERE ser_id = ? AND act_id = ?;")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nВведите ID зависимости фильма и актёра, которую хотите удалить: ");
            serID = scanner.nextInt();
            int actID = scanner.nextInt();

            statement.setInt(1, serID);
            statement.setInt(2, actID);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> DELETEERROR);
            throw new RuntimeException(e);
        }
    }

    public static void deleteSerAndCat() {

        logger.log(Level.INFO, () -> FILMLIST);
        selectFilm();
        logger.log(Level.INFO, () -> "\nСписок категорий");
        selectCategory();
        logger.log(Level.INFO, () -> "\nСписок зависимостей фильмов и категорий:");
        selectSerAndCat();

        try (PreparedStatement statement = CONNECTION.prepareStatement("DELETE FROM public.\"Ser_and_cat\"\nWHERE ser_id = ? AND cat_id = ?;")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nВведите зависимость фильма и категории, которую хотите удалить: ");
            serID = scanner.nextInt();
            int catID = scanner.nextInt();

            statement.setInt(1, serID);
            statement.setInt(2, catID);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> DELETEERROR);
            throw new RuntimeException(e);
        }
    }

    public static void deleteUser() {

        logger.log(Level.INFO, () -> "\nСписок отзывов:");
        selectComments();
        logger.log(Level.INFO, () -> "\nСписок рецензий:");
        selectReviews();
        logger.log(Level.INFO, () -> "\nСписок  пользователей:");
        selectUserList();

        try (PreparedStatement statement = CONNECTION.prepareStatement("DELETE FROM public.\"User\"\nWHERE id = ?;")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nВведите ID актёра, которого хотите удалить: ");
            id = scanner.nextInt();

            statement.setInt(1, id);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> DELETEERROR);
            throw new RuntimeException(e);
        }
    }

    public static void updateActors() throws SQLException {

        logger.log(Level.INFO, () -> ACTORLIST);
        selectActors();

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE public.\"Actors\" SET name=?, description=?, age=? WHERE id=?;")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nАктёр, данные о котором необходимо заменить: ");
            id = scanner.nextInt();
            scanner.nextLine();
            logger.log(Level.INFO, () -> "\nНапишите имя, описание и возраст актёра: ");
            name = scanner.nextLine();
            description = scanner.nextLine();
            age = scanner.nextInt();

            statement.setString(1, name);
            statement.setString(2, description);
            statement.setInt(3, age);
            statement.setInt(4, id);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> UPDATEERROR);
            throw new RuntimeException(e);
        }
    }

    public static void updateCategory() throws SQLException {

        logger.log(Level.INFO, () -> CATEGORYLIST);
        selectActors();

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE public.\"Category\" SET title=?, description=? WHERE id=?;")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nВведите ID категории, которую необходимо изменить: ");
            id = scanner.nextInt();
            scanner.nextLine();
            logger.log(Level.INFO, () -> "\nВведите название и описание категории: ");
            title = scanner.nextLine();
            description = scanner.nextLine();

            statement.setString(1, title);
            statement.setString(2, description);
            statement.setInt(3, id);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> UPDATEERROR);
            throw new RuntimeException(e);
        }
    }

    public static void updateComments() {

        logger.log(Level.INFO, () -> FILMLIST);
        selectFilm();
        logger.log(Level.INFO, () -> "\nСписок пользователей:");
        selectUserList();
        logger.log(Level.INFO, () -> "\nСписок комментариев");
        selectComments();

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE public.\"Comments\" SET username=?, commentary=?, ser_id=?, user_id=? WHERE id=?;")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nВведите ID комментария, который  необходимо изменить: ");
            id = scanner.nextInt();
            scanner.nextLine();
            logger.log(Level.INFO, () -> "\nВведите имя пользователя, комментарий к сериалу, ID этого сериала и ID пользователя: ");
            username = scanner.nextLine();
            String commentary = scanner.nextLine();
            serID = scanner.nextInt();
            userID = scanner.nextInt();

            statement.setString(1, username);
            statement.setString(2, commentary);
            statement.setInt(3, serID);
            statement.setInt(4, userID);
            statement.setInt(5, id);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> UPDATEERROR);
            throw new RuntimeException(e);
        }
    }

    public static void updateCountry() {

        logger.log(Level.INFO, () -> COUNTRYLIST);
        selectCountry();

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE public.\"Country\"\tSET title=?, description=? WHERE id=?;")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nВведите ID страны, которую необходимо изменить: ");
            id = scanner.nextInt();
            scanner.nextLine();
            logger.log(Level.INFO, () -> "\nВведите название страны производства и описание этой страны: ");
            title = scanner.nextLine();
            description = scanner.nextLine();

            statement.setString(1, title);
            statement.setString(2, description);
            statement.setInt(3, id);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> UPDATEERROR);
            throw new RuntimeException(e);
        }
    }

    public static void updateFilm() {

        logger.log(Level.INFO, () -> FILMLIST);
        selectFilm();
        logger.log(Level.INFO, () -> COUNTRYLIST);
        selectCountry();
        logger.log(Level.INFO, () -> PRODUCERLIST);
        selectProducer();

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE public.\"Film\" SET title=?, description=?, year=?, prod_id=?, country_id=? WHERE id=?;")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nВведите ID фильма, который необходимо изменить: ");
            id = scanner.nextInt();
            scanner.nextLine();
            logger.log(Level.INFO, () -> "\nВведите название фильма, его описание, год выхода, ID режисера и ID страны: ");
            name = scanner.nextLine();
            description = scanner.nextLine();
            int year = scanner.nextInt();
            int prodID = scanner.nextInt();
            int countryID = scanner.nextInt();

            statement.setString(1, name);
            statement.setString(2, description);
            statement.setInt(3, year);
            statement.setInt(4, prodID);
            statement.setInt(5, countryID);
            statement.setInt(6, id);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> UPDATEERROR);
            throw new RuntimeException(e);
        }
    }

    public static void updateProducer() {

        logger.log(Level.INFO, () -> PRODUCERLIST);
        selectProducer();

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE public.\"Producer\" SET name=?, description=?, age=?\tWHERE id=?;")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nВведите ID режиссёра, которого необходимо изменить: ");
            id = scanner.nextInt();
            scanner.nextLine();
            logger.log(Level.INFO, () -> "\nВведите ФИО, описание и возраст продюсера: ");
            name = scanner.nextLine();
            description = scanner.nextLine();
            age = scanner.nextInt();

            statement.setString(1, name);
            statement.setString(2, description);
            statement.setInt(3, age);
            statement.setInt(4, id);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> UPDATEERROR);
            throw new RuntimeException(e);
        }
    }

    public static void updateRating() {

        logger.log(Level.INFO, () -> FILMLIST);
        selectFilm();
        logger.log(Level.INFO, () -> "\nСписок рейтингов:");
        selectRating();

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE public.\"Rating\" SET kp=?, imdb=?, ser_id=? WHERE id=?;")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nВведите ID строчки в рейтинге, которую необходимо изменить: ");
            id = scanner.nextInt();
            scanner.nextLine();
            logger.log(Level.INFO, () -> "\nВведите оценку фильма на кинопоиске и imdb, а также ID фильма ");
            double kp = scanner.nextDouble();
            double imdb = scanner.nextDouble();
            serID = scanner.nextInt();

            statement.setDouble(1, kp);
            statement.setDouble(2, imdb);
            statement.setInt(3, serID);
            statement.setInt(4, id);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> UPDATEERROR);
            throw new RuntimeException(e);
        }
    }

    public static void updateReviews() {

        logger.log(Level.INFO, () -> FILMLIST);
        selectFilm();
        logger.log(Level.INFO, () -> USERSLIST);
        selectUserList();
        logger.log(Level.INFO, () -> "\nСписок рецензий");
        selectReviews();

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE public.\"Reviews\"\tSET username=?, review=?, ser_id=?, user_id=? WHERE id=?;")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nВведите ID рецензии, которую необходимо изменить: ");
            id = scanner.nextInt();
            scanner.nextLine();
            logger.log(Level.INFO, () -> "\nВведите ФИО, описание и возраст актёра: ");
            username = scanner.nextLine();
            String review = scanner.nextLine();
            serID = scanner.nextInt();
            userID = scanner.nextInt();

            statement.setString(1, username);
            statement.setString(2, review);
            statement.setInt(3, serID);
            statement.setInt(4, userID);
            statement.setInt(5, id);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> UPDATEERROR);
            throw new RuntimeException(e);
        }
    }

    public static void updateSerAndAct() throws SQLException {

        logger.log(Level.INFO, () -> FILMLIST);
        selectFilm();
        logger.log(Level.INFO, () -> ACTORLIST);
        selectActors();
        logger.log(Level.INFO, () -> "\nСписок фильмов и актёров:");
        selectSerAndAct();

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE public.\"Ser_and_Act\"\tSET ser_id=?, act_id=? WHERE ser_id=? AND act_id=?;")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nВведите ID фильма и ID актёра, отношение которых хотите поменять: ");
            int serIDchange = scanner.nextInt();
            int actIDchange = scanner.nextInt();
            logger.log(Level.INFO, () -> "\nВведите новые ID фильма и ID актёра: ");
            serID = scanner.nextInt();
            int actID = scanner.nextInt();

            statement.setInt(1, serID);
            statement.setInt(2, actID);
            statement.setInt(3, serIDchange);
            statement.setInt(4, actIDchange);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> UPDATEERROR);
            throw new RuntimeException(e);
        }
    }

    public static void updateSerAndCat() {

        logger.log(Level.INFO, () -> FILMLIST);
        selectFilm();
        logger.log(Level.INFO, () -> CATEGORYLIST);
        selectCategory();
        logger.log(Level.INFO, () -> "\nОтношение фильмов и категорий:");
        selectSerAndCat();

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE public.\"Ser_and_cat\" SET ser_id=?, cat_id=? WHERE ser_id=? AND cat_id=?;")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nВведите ID фильма и ID категории, отношение которых хотите поменять: ");
            int serIDchange = scanner.nextInt();
            int actIDchange = scanner.nextInt();
            logger.log(Level.INFO, () -> "\nВведите новые ID фильма и ID категории фильма: ");
            serID = scanner.nextInt();
            int catID = scanner.nextInt();

            statement.setInt(1, serID);
            statement.setInt(2, catID);
            statement.setInt(3, serIDchange);
            statement.setInt(4, actIDchange);

            statement.executeUpdate();

        } catch(SQLException e){
            logger.log(Level.INFO, () -> UPDATEERROR);
            throw new RuntimeException(e);
        }
    }

    public static void updateUser() throws SQLException {

        logger.log(Level.INFO, () -> "\nСписок пользователей:");
        selectUser();

        try (PreparedStatement statement = CONNECTION.prepareStatement("UPDATE public.\"User\" SET username=?, role=?, email=?, password=? WHERE id=?;")) {

            Scanner scanner = new Scanner(System.in);

            logger.log(Level.INFO, () -> "\nВведите ID категории, которую необходимо изменить: ");
            id = scanner.nextInt();
            scanner.nextLine();
            logger.log(Level.INFO, () -> "\nВведите имя пользователя, его роль, электронную почту и пароль: ");
            username = scanner.nextLine();
            String role = scanner.nextLine();
            String email = scanner.nextLine();
            String password = scanner.nextLine();

            statement.setString(1, username);
            statement.setString(2, role);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.setInt(5, id);

            statement.executeUpdate();
        } catch(SQLException e){
            logger.log(Level.INFO, () -> UPDATEERROR);
            throw new RuntimeException(e);
        }
    }
}
