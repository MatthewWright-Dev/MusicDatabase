import java.util.ArrayList;
import java.util.List;
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

    public void mainMenu()  {
        while(true) {
            System.out.println("*** MAIN MENU ***\n" +
                    "1: Manage the Database Source or Create a New Database\n" +
                    "2: Add Reviews to the database\n" +
                    "3: Execute Queries on the Database\n" +
                    "4: Quit\n" +
                    "**********************************************");
            int choice = 0;
            while (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
                choice = getUserInt();
            }

            switch (choice) {
                case 1:
                    createDatabaseMenu();
                    break;
                case 2:
                    addReviews();
                    break;
                case 3:
                    getQueries();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("No Case Met in the Main Menu...... Weird!");
            }
        }
    }

    private void createDatabaseMenu()  {
        System.out.println("The current default Database file is: \n" +
                "" + databasePath + "\n" +
                "Would you like to\n" +
                "1: Continue with default database\n" +
                "2: Enter a file path for alternative database\n" +
                "3: Generate a new database\n" +
                "4: Main Menu\n" +
                "**********************************************");

        int choice = 0;
        while (choice != 1 && choice !=2 && choice != 3 && choice != 4) {
            choice = getUserInt();
        }

        AccessSql temp = new AccessSql(databasePath);

        switch (choice)    {
            case (1):
                break;
            case (2):
                databasePath = getUserString();
                break;
            case (3):
                databasePath = temp.buildDatabase(databasePath, "Not Yet Needed");
                break;
            case (4):
                return;
        }

        System.out.println("The file path for the database is set as \n" +
                databasePath);
    }

    private void addReviews()    {

        boolean cont = true;
        while (cont) {
            cont = false;

            System.out.println("Please enter the website address:");
            String reviewURL = getUserString();

            WebScrubber ws = new WebScrubber(reviewURL);
            List<Review> reviews = new ArrayList<>();

            try {
                reviews = ws.reviewScraper();
            } catch (Exception e)   {
                System.out.println(e.getStackTrace());
            }

            for (Review rev : reviews) {
                System.out.println(rev.toString());
            }

            AccessSql db = new AccessSql(databasePath);

            for (Review rev : reviews) {
                db.addReview(rev);
            }

            System.out.println("Enter another link?\n1 = Yes\n2 = No\n" +
                               "*******************");
            int choice = 0;
            while (choice != 1 && choice != 2 ) {
                choice = getUserInt();
            }
            if (getUserInt() == 1)    {
                cont = true;
            }
        }

    }

    private void getQueries()   {
        System.out.println("QUERIES COMING SOON!");
    }

    private static int getUserInt()  {
        Scanner user = new Scanner(System.in);
        return user.nextInt();
    }

    private static String getUserString()   {
        Scanner user = new Scanner(System.in).useDelimiter("\n");
        return user.nextLine();
    }
}
