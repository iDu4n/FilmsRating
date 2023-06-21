package model;

import model.CRUD.Delete;
import model.CRUD.Update;
import model.CRUD.Select;
import model.CRUD.Insert;

import java.sql.*;
import java.util.Scanner;

public class CRUDutils {
    
    private static final Connection CONNECTION = DatabaseConnection.databaseConnect() ;

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
            System.out.println("Некорректный выбор.");
        }
        Tables.start();
    }

    public static void selectActors() throws SQLException {
         try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                 ResultSet.CONCUR_UPDATABLE)) {

             ResultSet table = statement.executeQuery("SELECT * FROM public.\"Actors\"\n ORDER BY id ASC ");

             while (table.next()) {
                 int id = table.getInt("id");
                 String name = table.getString("name");
                 String description = table.getString("description");
                 int age = table.getInt("age");

                 System.out.println("ID: " + id + ", Name: " + name + ", Description: " + description + ", Age: " + age);
             }
             table.close();
         }
    }

    public static void selectCategory(){
        try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {

            ResultSet table = statement.executeQuery("SELECT * FROM public.\"Category\"\n ORDER BY id ASC ");

            while (table.next()) {
                int id = table.getInt("id");
                String title = table.getString("title");
                String description = table.getString("description");

                System.out.println("ID: " + id + ", Title: " + title + ", Description: " + description);
            }

            table.close();
        } catch(SQLException e){
            System.out.println("Ошибка в чтении таблицы.");
            e.printStackTrace();
        }
    }

    public static void selectComments(){
        try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {

            ResultSet table = statement.executeQuery("SELECT * FROM public.\"Comments\"\n ORDER BY id ASC ");

            while (table.next()) {
                int id = table.getInt("id");
                String username = table.getString("username");
                String comment = table.getString("commentary");
                int ser_id = table.getInt("ser_id");
                int User_id = table.getInt("User_id");

                System.out.println("ID: " + id + ", Username: " + username + ", Commentary: "
                        + comment + ", ser_id: " + ser_id + ", User_id: " + User_id);
            }

            table.close();
        } catch(SQLException e){
            System.out.println("Ошибка в чтении таблицы.");
            e.printStackTrace();
        }
    }

    public static void selectCountry(){
        try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {

            ResultSet table = statement.executeQuery("SELECT * FROM public.\"Country\"\n ORDER BY id ASC ");

            while (table.next()) {
                int id = table.getInt("id");
                String title = table.getString("title");
                String description = table.getString("description");

                System.out.println("ID: " + id + ", Title: " + title + ", Description: " + description);
            }

            table.close();
        } catch(SQLException e){
            System.out.println("Ошибка в чтении таблицы.");
            e.printStackTrace();
        }
    }

    public static void selectFilm(){
        try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {

            ResultSet table = statement.executeQuery("SELECT * FROM public.\"Film\"\n ORDER BY id ASC");

            while (table.next()) {
                int id = table.getInt("id");
                String title = table.getString("title");
                String description = table.getString("description");
                int year = table.getInt("year");
                int Prod_id = table.getInt("prod_id");
                int Country_id = table.getInt("country_id");

                System.out.println("ID: " + id + ", Title: " + title + ", Description: "
                        + description + ", Year: " + year + ", prod_id: " + Prod_id + ", Country_id: " + Country_id);
            }

            table.close();
        } catch(SQLException e){
            System.out.println("Ошибка в чтении таблицы.");
            e.printStackTrace();
        }
    }

    public static void selectProducer() {
        try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {

            ResultSet table = statement.executeQuery("SELECT * FROM public.\"Producer\"\n ORDER BY id ASC ");

            while (table.next()) {
                int id = table.getInt("id");
                String name = table.getString("name");
                String description = table.getString("description");
                int age = table.getInt("age");

                System.out.println("ID: " + id + ", Name: " + name + ", Description: " + description + ", Age: " + age);
            }

            table.close();
        } catch(SQLException e){
            System.out.println("Ошибка в чтении таблицы.");
            e.printStackTrace();
        }
    }

    public static void selectRating(){
        try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {

            ResultSet table = statement.executeQuery("SELECT * FROM public.\"Rating\"\n ORDER BY id ASC ");

            while (table.next()) {
                int id = table.getInt("id");
                String kp = table.getString("kp");
                String imdb = table.getString("imdb");
                int ser_id = table.getInt("ser_id");

                System.out.println("ID: " + id + ", Kp: " + kp + ", Imdb: " + imdb + ", ser_id: " + ser_id);
            }

            table.close();
        } catch(SQLException e){
            System.out.println("Ошибка в чтении таблицы.");
            e.printStackTrace();
        }
    }

    public static void selectReviews(){
         try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                 ResultSet.CONCUR_UPDATABLE)) {

             ResultSet table = statement.executeQuery("SELECT * FROM public.\"Reviews\"\n ORDER BY id ASC ");

             while (table.next()) {
                 int id = table.getInt("id");
                 String username = table.getString("username");
                 String review = table.getString("review");
                 int ser_id = table.getInt("ser_id");
                 int User_id = table.getInt("user_id");

                 System.out.println("ID: " + id + ", Username: " + username + ", Review: " + review
                         + ", ser_id: " + ser_id + ", User_id" + User_id);
             }

             table.close();
         } catch(SQLException e){
             System.out.println("Ошибка в чтении таблицы.");
             e.printStackTrace();
         }
    }

    public static void selectSerAndAct(){
         try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                 ResultSet.CONCUR_UPDATABLE)) {

             ResultSet table = statement.executeQuery("SELECT * FROM public.\"Ser_and_Act\"\n");

             while (table.next()) {
                 int ser_id = table.getInt("ser_id");
                 int act_id = table.getInt("act_id");

                 System.out.println("ser_id: " + ser_id + ", act_id: " + act_id);
             }

             table.close();
         } catch(SQLException e){
             System.out.println("Ошибка в чтении таблицы.");
             e.printStackTrace();
         }
    }

    public static void selectSerAndCat() {

         try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                 ResultSet.CONCUR_UPDATABLE)) {

             ResultSet table = statement.executeQuery("SELECT * FROM public.\"Ser_and_cat\"\n");

             while (table.next()) {
                 int ser_id = table.getInt("ser_id");
                 int cat_id = table.getInt("cat_id");

                 System.out.println("ser_id: " + ser_id + ", cat_id: " + cat_id);
             }

             table.close();
         } catch(SQLException e){
             System.out.println("Ошибка в чтении таблицы.");
             e.printStackTrace();
         }
    }

    public static void selectUser() {
        try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {

            ResultSet table = statement.executeQuery("SELECT * FROM public.\"User\"\n ORDER BY id ASC ");

            while (table.next()) {
                int id = table.getInt("id");
                String username = table.getString("username");
                String role = table.getString("role");
                String email = table.getString("email");
                String password = table.getString("password");

                System.out.println("ID: " + id + ", Username: " + username + ", Role: "
                        + role + ", Email: " + email + ", Password: " + password);
            }

            table.close();
        } catch(SQLException e){
            System.out.println("Ошибка в чтении таблицы.");
            e.printStackTrace();
        }
    }

    public static void selectUserList() {
        try (Statement statement = CONNECTION.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {

            ResultSet table = statement.executeQuery("SELECT id, username FROM public.\"User\"\n ORDER BY id ASC ");

            while (table.next()) {
                int id = table.getInt("id");
                String username = table.getString("username");

                System.out.println("ID: " + id + ", Username: " + username);
            }
            table.close();
        } catch(SQLException e){
            System.out.println("Ошибка в чтении таблицы.");
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

             System.out.println("Введите ФИО, описание и возраст актёра: ");
             String name = scanner.nextLine();
             String desc = scanner.nextLine();
             int age = scanner.nextInt();

             statement.setString(1, name);
             statement.setString(2, desc);
             statement.setInt(3, age);

             System.out.println(statement);

             statement.executeUpdate();
         } catch(SQLException e){
             System.out.println("Не удалось заполнить строку таблицы.");
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

             System.out.println("Введите название категории и её описание: ");
             String title = scanner.nextLine();
             String desc = scanner.nextLine();

             statement.setString(1, title);
             statement.setString(2, desc);

             System.out.println(statement);

             statement.executeUpdate();
         } catch(SQLException e){
             System.out.println("Не удалось заполнить строку таблицы.");
             e.printStackTrace();
         }
    }

    public static void insertComments() {

        System.out.println("Список фильмов:");
        selectFilm();
        System.out.println("Список пользователей");
        selectUserList();

        String INSERT_SQL = """
                INSERT INTO public."Comments"(
                \tusername, commentary, ser_id, user_id)
                \tVALUES (?, ?, ?, ?);""";

         try (PreparedStatement PreparedStatement = CONNECTION.prepareStatement(INSERT_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите имя пользователя, комментарий к сериалу, ID этого сериала и ID пользователя: ");
            String username = scanner.nextLine();
            String commentary = scanner.nextLine();
            int ser_id = scanner.nextInt();
            int User_id = scanner.nextInt();

            PreparedStatement.setString(1, username);
            PreparedStatement.setString(2, commentary);
            PreparedStatement.setInt(3, ser_id);
            PreparedStatement.setInt(4, User_id);

            System.out.println(PreparedStatement);

            PreparedStatement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Не удалось заполнить строку таблицы.");
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

             System.out.println("Введите название страны производства и описание этой страны: ");
             String title = scanner.nextLine();
             String desc = scanner.nextLine();

             statement.setString(1, title);
             statement.setString(2, desc);

             System.out.println(statement);

             statement.executeUpdate();
         } catch(SQLException e){
             System.out.println("Не удалось заполнить строку таблицы.");
             e.printStackTrace();
         }
    }

    public static void insertFilm() {

        System.out.println("Список стран:");
        selectCountry();
        System.out.println("Список режиссёров:");
        selectProducer();

        String INSERT_SQL = """
                INSERT INTO public."Film"(
                \ttitle, description, year, "prod_id", "country_id")
                \tVALUES (?, ?, ?, ?, ?);""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(INSERT_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите название фильма, его описание, год выхода, ID режисера и ID страны: ");
            String name = scanner.nextLine();
            String desc = scanner.nextLine();
            int year = scanner.nextInt();
            int Prod_id = scanner.nextInt();
            int Country_id = scanner.nextInt();

            statement.setString(1, name);
            statement.setString(2, desc);
            statement.setInt(3, year);
            statement.setInt(4, Prod_id);
            statement.setInt(5, Country_id);

            System.out.println(statement);

            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Не удалось заполнить строку таблицы.");
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

             System.out.println("Введите ФИО, описание и возраст продюсера: ");
             String name = scanner.nextLine();
             String desc = scanner.nextLine();
             int age = scanner.nextInt();

             statement.setString(1, name);
             statement.setString(2, desc);
             statement.setInt(3, age);

             System.out.println(statement);

             statement.executeUpdate();
         } catch(SQLException e){
             System.out.println("Не удалось заполнить строку таблицы.");
             e.printStackTrace();
         }
    }

    public static void insertRating() {
        System.out.println("Список фильмов:");
        selectFilm();

        String INSERT_SQL = """
                INSERT INTO public."Rating"(
                \tkp, imdb, ser_id)
                \tVALUES (?, ?, ?);""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(INSERT_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Оценку фильма на кинопоиске и imdb, ID фильма ");
            double kp = scanner.nextDouble();
            double imdb = scanner.nextDouble();
            int ser_id = scanner.nextInt();

            statement.setDouble(1, kp);
            statement.setDouble(2, imdb);
            statement.setInt(3, ser_id);

            System.out.println(statement);

            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Не удалось заполнить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void insertReviews() {

        System.out.println("Список фильмов:");
        selectFilm();
        System.out.println("Список пользователей");
        selectUserList();

        String INSERT_SQL = """
                INSERT INTO public."Reviews"(
                \tusername, review, ser_id, user_id)
                \tVALUES (?, ?, ?, ?);""";

         try (PreparedStatement statement = CONNECTION.prepareStatement(INSERT_SQL)) {

             Scanner scanner = new Scanner(System.in);

             System.out.println("Введите ФИО, описание и возраст актёра: ");
             String username = scanner.nextLine();
             String review = scanner.nextLine();
             int ser_id = scanner.nextInt();
             int User_id = scanner.nextInt();

             statement.setString(1, username);
             statement.setString(2, review);
             statement.setInt(3, ser_id);
             statement.setInt(4, User_id);

             System.out.println(statement);

             statement.executeUpdate();
         } catch(SQLException e){
             System.out.println("Не удалось заполнить строку таблицы.");
             e.printStackTrace();
         }
    }

    public static void insertSerAndAct() throws SQLException {

        System.out.println("Список фильмов:");
        selectFilm();
        System.out.println("Список актёров:");
        selectActors();

        String INSERT_SQL = """
                INSERT INTO public."Ser_and_Act"(
                \tser_id, act_id)
                \tVALUES (?, ?);""";

         try (PreparedStatement statement = CONNECTION.prepareStatement(INSERT_SQL)) {

             Scanner scanner = new Scanner(System.in);

             System.out.println("Введите ID фильма и ID актёра: ");
             int ser_id = scanner.nextInt();
             int act_id = scanner.nextInt();

             statement.setInt(1, ser_id);
             statement.setInt(2, act_id);

             System.out.println(statement);

             statement.executeUpdate();
         } catch(SQLException e){
             System.out.println("Не удалось заполнить строку таблицы.");
             e.printStackTrace();
         }
    }

    public static void insertSerAndCat() {

        System.out.println("Список фильмов:");
        selectFilm();
        System.out.println("Список категорий:");
        selectCategory();

        String INSERT_SQL = """
                INSERT INTO public."Ser_and_cat"(
                \tser_id, cat_id)
                \tVALUES (?, ?);""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(INSERT_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите ID фильма и ID категории фильма: ");
            int ser_id = scanner.nextInt();
            int cat_id = scanner.nextInt();

            statement.setInt(1, ser_id);
            statement.setInt(2, cat_id);

            System.out.println(statement);

            statement.executeUpdate();

        } catch(SQLException e){
            System.out.println("Не удалось заполнить строку таблицы.");
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

            System.out.println("Введите имя пользователя, его роль, электронную почту и пароль: ");
            String username = scanner.nextLine();
            String role = scanner.nextLine();
            String email = scanner.nextLine();
            String password = scanner.nextLine();

            statement.setString(1, username);
            statement.setString(2, role);
            statement.setString(3, email);
            statement.setString(4, password);

            System.out.println(statement);

            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Не удалось заполнить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void deleteActors() throws SQLException {

        System.out.println("Список фильмов" + "\u001B[31m" + " (не внешний ключ):" + "\u001B[0m");
        selectFilm();
        System.out.println("Список зависимостей фильмов и актёров:");
        selectSerAndAct();
        System.out.println("Список актёров:");
        selectActors();

        String DELETE_SQL = "DELETE FROM public.\"Actors\"\n" +
                            "WHERE id = ?;";

        try (PreparedStatement statement = CONNECTION.prepareStatement(DELETE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите ID актёра, которого хотите удалить: ");
            int id = scanner.nextInt();

            statement.setInt(1, id);

            System.out.println(statement);

            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Не удалось удалить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void deleteCategory() {

        System.out.println("Список зависимостей фильмов и категорий:");
        selectSerAndCat();
        System.out.println("Список категорий:");
        selectSerAndCat();

        String DELETE_SQL = "DELETE FROM public.\"Category\"\n" +
                "WHERE id = ?;";

        try (PreparedStatement statement = CONNECTION.prepareStatement(DELETE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите ID категории, которую хотите удалить: ");
            int id = scanner.nextInt();

            statement.setInt(1, id);

            System.out.println(statement);

            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Не удалось удалить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void deleteComments() {

        System.out.println("Список фильмов" + "\u001B[31m" + " (не внешний ключ):" + "\u001B[0m");
        selectFilm();
        System.out.println("Список комментариев:");
        selectComments();

        String DELETE_SQL = "DELETE FROM public.\"Comments\"\n" +
                "WHERE id = ?;";

        try (PreparedStatement statement = CONNECTION.prepareStatement(DELETE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите ID комментария, который необходимо удалить: ");
            int id = scanner.nextInt();

            statement.setInt(1, id);

            System.out.println(statement);

            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Не удалось удалить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void deleteCountry() {

        System.out.println("Список стран:");
        selectCountry();

        String DELETE_SQL = "DELETE FROM public.\"Country\"\n" +
                "WHERE id = ?;";

        try (PreparedStatement statement = CONNECTION.prepareStatement(DELETE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите ID страны, которую необходимо удалить: ");
            int id = scanner.nextInt();

            statement.setInt(1, id);

            System.out.println(statement);

            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Не удалось удалить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void deleteFilm() {

        System.out.println("Список зависимостей фильмов и актёров:");
        selectSerAndAct();
        System.out.println("Список зависимостей фильмов и категорий:");
        selectSerAndCat();
        System.out.println("Список фильмов и их оценок:");
        selectRating();
        System.out.println("Список фильмов и их отзывов:");
        selectComments();
        System.out.println("Список фильмов и их рецензий:");
        selectReviews();
        System.out.println("Список фильмов:");
        selectFilm();

        String DELETE_SQL = "DELETE FROM public.\"Film\"\n" +
                "WHERE id = ?;";

        try (PreparedStatement statement = CONNECTION.prepareStatement(DELETE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите ID фильма, которого хотите удалить: ");
            int id = scanner.nextInt();

            statement.setInt(1, id);

            System.out.println(statement);

            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Не удалось удалить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void deleteProducer() {

        System.out.println("Список фильмов:");
        selectFilm();
        System.out.println("Список режиссёров:");
        selectProducer();

        String DELETE_SQL = "DELETE FROM public.\"Producer\"\n" +
                "WHERE id = ?;";

        try (PreparedStatement statement = CONNECTION.prepareStatement(DELETE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите ID режиссёра, которого хотите удалить: ");
            int id = scanner.nextInt();

            statement.setInt(1, id);

            System.out.println(statement);

            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Не удалось удалить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void deleteRating() {

        System.out.println("Список фильмов" + "\u001B[31m" + " (не внешний ключ):" + "\u001B[0m");
        selectFilm();
        System.out.println("Список оценок:");
        selectRating();

        String DELETE_SQL = "DELETE FROM public.\"Rating\"\n" +
                "WHERE id = ?;";

        try (PreparedStatement statement = CONNECTION.prepareStatement(DELETE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите ID фильма и его оценок, которые хотите удалить: ");
            int id = scanner.nextInt();

            statement.setInt(1, id);

            System.out.println(statement);

            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Не удалось удалить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void deleteReviews() {

        System.out.println("Список фильмов" + "\u001B[31m" + " (не внешний ключ):" + "\u001B[0m");
        selectFilm();
        System.out.println("Список рецензий:");
        selectReviews();

        String DELETE_SQL = "DELETE FROM public.\"Reviews\"\n" +
                "WHERE id = ?;";

        try (PreparedStatement statement = CONNECTION.prepareStatement(DELETE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите ID рецензии, которую хотите удалить: ");
            int id = scanner.nextInt();

            statement.setInt(1, id);

            System.out.println(statement);

            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Не удалось удалить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void deleteSerAndAct() throws SQLException {

        System.out.println("Список фильмов" + "\u001B[31m" + " (не внешний ключ):" + "\u001B[0m");
        selectFilm();
        System.out.println("Список актёров" + "\u001B[31m" + " (не внешний ключ):" + "\u001B[0m");
        selectActors();
        System.out.println("Список зависимостей фильмов и актёров:");
        selectSerAndAct();

        String DELETE_SQL = "DELETE FROM public.\"Ser_and_Act\"\n" +
                "WHERE id = ?;";

        try (PreparedStatement statement = CONNECTION.prepareStatement(DELETE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите ID актёра, которого хотите удалить: ");
            int id = scanner.nextInt();

            statement.setInt(1, id);

            System.out.println(statement);

            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Не удалось удалить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void deleteSerAndCat() {

        System.out.println("Список фильмов" + "\u001B[31m" + " (не внешний ключ):" + "\u001B[0m");
        selectFilm();
        System.out.println("Список категорий" + "\u001B[31m" + " (не внешний ключ):" + "\u001B[0m");
        selectCategory();
        System.out.println("Список зависимостей фильмов и категорий:");
        selectSerAndCat();

        String DELETE_SQL = "DELETE FROM public.\"Ser_and_cat\"\n" +
                "WHERE id = ?;";

        try (PreparedStatement statement = CONNECTION.prepareStatement(DELETE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите ID актёра, которого хотите удалить: ");
            int id = scanner.nextInt();

            statement.setInt(1, id);

            System.out.println(statement);

            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Не удалось удалить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void deleteUser() {

        System.out.println("Список отзывов:");
        selectComments();
        System.out.println("Список рецензий:");
        selectReviews();
        System.out.println("Список пользователей:");
        selectUserList();

        String DELETE_SQL = "DELETE FROM public.\"User\"\n" +
                "WHERE id = ?;";

        try (PreparedStatement statement = CONNECTION.prepareStatement(DELETE_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите ID актёра, которого хотите удалить: ");
            int id = scanner.nextInt();

            statement.setInt(1, id);

            System.out.println(statement);

            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Не удалось удалить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void updateActors() throws SQLException {

        System.out.println("Список актёров:");
        selectActors();

        String INSERT_SQL = """
                UPDATE public."Actors"
                	SET name=?, description=?, age=?
                	WHERE id=?;""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(INSERT_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Актёр, данные о котором необходимо заменить: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Напишите имя, описание и возраст актёра: ");
            String name = scanner.nextLine();
            String desc = scanner.nextLine();
            int age = scanner.nextInt();

            statement.setString(1, name);
            statement.setString(2, desc);
            statement.setInt(3, age);
            statement.setInt(4, id);

            System.out.println(statement);

            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Не удалось изменить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void updateCategory() throws SQLException {

        System.out.println("Список категорий:");
        selectActors();

        String INSERT_SQL = """
                UPDATE public."Category"
                	SET title=?, description=?
                	WHERE id = ?;""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(INSERT_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите ID категории, которую необходимо изменить: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Введите название и описание категории: ");
            String title = scanner.nextLine();
            String desc = scanner.nextLine();

            statement.setString(1, title);
            statement.setString(2, desc);
            statement.setInt(3, id);

            System.out.println(statement);

            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Не удалось изменить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void updateComments() {

        System.out.println("Список фильмов:");
        selectFilm();
        System.out.println("Список пользователей:");
        selectUserList();
        System.out.println("Список комментариев");
        selectComments();

        String INSERT_SQL = """
                UPDATE public."Comments"
                	SET username=?, commentary=?, ser_id=?, user_id=?
                	WHERE id = ?""";

        try (PreparedStatement PreparedStatement = CONNECTION.prepareStatement(INSERT_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите ID комментария, который  необходимо изменить: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Введите имя пользователя, комментарий к сериалу, ID этого сериала и ID пользователя: ");
            String username = scanner.nextLine();
            String commentary = scanner.nextLine();
            int ser_id = scanner.nextInt();
            int User_id = scanner.nextInt();

            PreparedStatement.setString(1, username);
            PreparedStatement.setString(2, commentary);
            PreparedStatement.setInt(3, ser_id);
            PreparedStatement.setInt(4, User_id);
            PreparedStatement.setInt(5, id);

            System.out.println(PreparedStatement);

            PreparedStatement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Не удалось изменить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void updateCountry() {

        System.out.println("Список стран:");
        selectCountry();

        String INSERT_SQL = """
                UPDATE public."Country"
                	SET title=?, description=?
                	WHERE id=?;""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(INSERT_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите ID страны, которую необходимо изменить: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Введите название страны производства и описание этой страны: ");
            String title = scanner.nextLine();
            String desc = scanner.nextLine();

            statement.setString(1, title);
            statement.setString(2, desc);
            statement.setInt(3, id);

            System.out.println(statement);

            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Не удалось изменить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void updateFilm() {

        System.out.println("Список фильмов:");
        selectFilm();
        System.out.println("Список стран:");
        selectCountry();
        System.out.println("Список режиссёров:");
        selectProducer();

        String INSERT_SQL = """
                UPDATE public."Film"
                	SET title=?, description=?, year=?, prod_id=?, country_id=?
                	WHERE id=?;""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(INSERT_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите ID фильма, который необходимо изменить: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Введите название фильма, его описание, год выхода, ID режисера и ID страны: ");
            String name = scanner.nextLine();
            String desc = scanner.nextLine();
            int year = scanner.nextInt();
            int Prod_id = scanner.nextInt();
            int Country_id = scanner.nextInt();

            statement.setString(1, name);
            statement.setString(2, desc);
            statement.setInt(3, year);
            statement.setInt(4, Prod_id);
            statement.setInt(5, Country_id);
            statement.setInt(6, id);

            System.out.println(statement);

            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Не удалось изменить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void updateProducer() {

        System.out.println("Список режиссёров:");
        selectProducer();

        String INSERT_SQL = """
                UPDATE public."Producer"
                	SET name=?, description=?, age=?
                	WHERE id=?;""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(INSERT_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите ID режиссёра, которого необходимо изменить: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Введите ФИО, описание и возраст продюсера: ");
            String name = scanner.nextLine();
            String desc = scanner.nextLine();
            int age = scanner.nextInt();

            statement.setString(1, name);
            statement.setString(2, desc);
            statement.setInt(3, age);
            statement.setInt(4, id);

            System.out.println(statement);

            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Не удалось изменить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void updateRating() {

        System.out.println("Список фильмов:");
        selectFilm();
        System.out.println("Список рейтингов:");
        selectRating();

        String INSERT_SQL = """
                UPDATE public."Rating"
                    SET kp=?, imdb=?, ser_id=?
                    WHERE id=?;""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(INSERT_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите ID строчки в рейтинге, которую необходимо изменить: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Введите оценку фильма на кинопоиске и imdb, а также ID фильма ");
            double kp = scanner.nextDouble();
            double imdb = scanner.nextDouble();
            int ser_id = scanner.nextInt();

            statement.setDouble(1, kp);
            statement.setDouble(2, imdb);
            statement.setInt(3, ser_id);
            statement.setInt(4, id);

            System.out.println(statement);

            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Не удалось изменить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void updateReviews() {

        System.out.println("Список фильмов:");
        selectFilm();
        System.out.println("Список пользователей");
        selectUserList();
        System.out.println("Список рецензий");
        selectReviews();

        String INSERT_SQL = """
                UPDATE public."Reviews"
                	SET username=?, review=?, ser_id=?, user_id=?
                	WHERE id=?;""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(INSERT_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите ID рецензии, которую необходимо изменить: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Введите ФИО, описание и возраст актёра: ");
            String username = scanner.nextLine();
            String review = scanner.nextLine();
            int ser_id = scanner.nextInt();
            int User_id = scanner.nextInt();

            statement.setString(1, username);
            statement.setString(2, review);
            statement.setInt(3, ser_id);
            statement.setInt(4, User_id);
            statement.setInt(5, id);

            System.out.println(statement);

            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Не удалось изменить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void updateSerAndAct() throws SQLException {

        System.out.println("Список фильмов:");
        selectFilm();
        System.out.println("Список актёров:");
        selectActors();
        System.out.println("Список фильмов и актёров:");
        selectSerAndAct();

        String INSERT_SQL = """
                UPDATE public."Ser_and_Act"
                	SET ser_id=?, act_id=?
                	WHERE ser_id=? AND act_id=?;""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(INSERT_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите ID фильма и ID актёра, отношение которых хотите поменять: ");
            int ser_id_change = scanner.nextInt();
            int act_id_change = scanner.nextInt();
            System.out.println("Введите новые ID фильма и ID актёра: ");
            int ser_id = scanner.nextInt();
            int act_id = scanner.nextInt();

            statement.setInt(1, ser_id);
            statement.setInt(2, act_id);
            statement.setInt(3, ser_id_change);
            statement.setInt(4, act_id_change);

            System.out.println(statement);

            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Не удалось изменить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void updateSerAndCat() {

        System.out.println("Список фильмов:");
        selectFilm();
        System.out.println("Список категорий:");
        selectCategory();
        System.out.println("Отношение фильмов и категорий:");
        selectSerAndCat();

        String INSERT_SQL = """
                 UPDATE public."Ser_and_cat"
                    SET ser_id=?, cat_id=?
                    WHERE ser_id=? AND cat_id=?;""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(INSERT_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите ID фильма и ID категории, отношение которых хотите поменять: ");
            int ser_id_change = scanner.nextInt();
            int act_id_change = scanner.nextInt();
            System.out.println("Введите новые ID фильма и ID категории фильма: ");
            int ser_id = scanner.nextInt();
            int cat_id = scanner.nextInt();

            statement.setInt(1, ser_id);
            statement.setInt(2, cat_id);
            statement.setInt(3, ser_id_change);
            statement.setInt(4, act_id_change);

            System.out.println(statement);

            statement.executeUpdate();

        } catch(SQLException e){
            System.out.println("Не удалось изменить строку таблицы.");
            e.printStackTrace();
        }
    }

    public static void updateUser() throws SQLException {

        System.out.println("Список пользователей:");
        selectActors();

        String INSERT_SQL = """
                INSERT INTO public."User"(
                \tusername, role, email, password)
                \tVALUES (?, ?, ?, ?);""";

        try (PreparedStatement statement = CONNECTION.prepareStatement(INSERT_SQL)) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите ID категории, которую необходимо изменить: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Введите имя пользователя, его роль, электронную почту и пароль: ");
            String username = scanner.nextLine();
            String role = scanner.nextLine();
            String email = scanner.nextLine();
            String password = scanner.nextLine();

            statement.setString(1, username);
            statement.setString(2, role);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.setInt(5, id);

            System.out.println(statement);

            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println("Не удалось изменить строку таблицы.");
            e.printStackTrace();
        }
    }
}
