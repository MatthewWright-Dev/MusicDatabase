import java.util.Scanner;

/**
 * DataMenus.java manages the console menu interface for users of
 * the Music Review Database.
 *
 * @author Matt Wright (mattmyth@gmail.com)
 * @version 2019-12-09
 *
 */

public class DataMenus {

    private String databasePath;

    public DataMenus(String path)   {
        databasePath = path;
    }

    public void dbCreateMenu()  {
        System.out.println("Welcome to the Music Database Service\n" +
                "The current default Database file is: \n" +
                "" + databasePath + "\n" +
                "Would you like to" +
                "1: Continue with default database\n" +
                "2: Enter a file path for alternative database\n" +
                "3: Generate a new database" +
                "**********************************************");

        int choice = 0;
        while (choice != 1 && choice !=2 && choice != 3) {
            choice = getMenuChoice();
        }
        switch (choice)    {
            case (1): break;
            case (2): databasePath = getUserString();
                break;
            case (3):
        }


    }

    private static int getMenuChoice()  {
        Scanner user = new Scanner(System.in);
        return user.nextInt();
    }

    private static String getUserString()   {
        Scanner user = new Scanner(System.in).useDelimiter("\n");
        return user.nextLine();
    }
}
