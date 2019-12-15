/**
 * DataDriver.java contains the main method and controls the order of
 * execution of all objects and associated methods for the
 * Music Review Database.
 *
 * @author Matt Wright (mattmyth@gmail.com)
 * @version 2019-12-13
 *
 */


public class DataDriver {

    private static String databasePath = "jdbc:sqlite:C:/Users/Matt/Dropbox/Java_Code/MusicDatabase/MusicReviewsDB/ReviewsDB.db";

    public static void main(String[] args)  {

        System.out.println("#####################################\n" +
                           "Welcome to the Music Database Service\n" +
                           "#####################################\n");
        DataMenus menu = new DataMenus(databasePath);

        try {
            menu.mainMenu();
        } catch (Exception e)   {
            System.out.println(e.getMessage() + "\n" + e.getStackTrace());
        }
    }
}
