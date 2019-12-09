/**
 * DataDriver.java contains the main method and controls the order of
 * execution of all objects and associated methods for the
 * Music Review Database.
 *
 * @author Matt Wright (mattmyth@gmail.com)
 * @version 2019-12-09
 *
 */


public class DataDriver {

    private static String databasePath = "jdbc:sqlite:C:/SQLite/MusicReviews/ReviewsDB.db";

    public static void main(String[] args)  {

        DataMenus menu = new DataMenus(databasePath);
        databasePath = menu.createDatabaseMenu();
        System.out.println(databasePath);
    }
}
