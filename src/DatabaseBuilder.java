/**
 * DatabaseBuilder.java creates a new empty database using the parent directory
 * of the default database and a text file containing the SQL Create Table
 * statements.
 *
 * @author Matt Wright (mattmyth@gmail.com)
 * @version 2019-12-09
 *
 */

public class DatabaseBuilder {

    private String databasePath;
    private String tablePath;

    public DatabaseBuilder(String dPath, String tPath)  {
        databasePath = dPath;
        tablePath = tPath;
    }

    public String buildDatabase(String dPath)   {


        return null;
    }
}
