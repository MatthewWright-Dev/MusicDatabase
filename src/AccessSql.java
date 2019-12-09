import java.sql.*;
import java.time.LocalDateTime;

/**
 * AccessSql.java is a class responsible for the vast majority of the interfacing
 * with the Music Reviews Database for inserting and querying data.
 *
 * @author Matt Wright (mattmyth@gmail.com)
 * @version 2019-12-09
 *
 */

public class AccessSql {

    private String databasePath;

    public AccessSql(String dPath)   {
        databasePath = dPath;
    }

    private Connection connect() {
        // SQLite connection string is attached to the AccessSQL object

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(databasePath);
            conn.createStatement().executeUpdate("PRAGMA foreign_keys = ON;");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    /**
     *
     * @param dPath database filepath whose parent folder will be used for new database.
     * @param tPath the text file containing the SQL create table statements.
     * @return the filepath of the newly created database.
     */
    public String buildDatabase(String dPath, String tPath)   {
        LocalDateTime now = LocalDateTime.now();
        String url = databasePath + now.toString();

        try (Connection conn = this.connect())    {
            if (conn != null)   {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("IN DATABASE BUILDER LINE 33\n" +
                        "The driver name is " + meta.getDriverName() + "\n" +
                        "A new database has been created...");
            }
        }
        catch (SQLException e)  {
            System.out.println(e.getMessage());
        }

        //A Placeholder for my create table statements
        String createTables = "CREATE TABLE Albums(\n" +
                "\tartist VARCHAR(20) PRIMARY KEY,\n" +
                "\talbum VARCHAR(20),\n" +
                "        label VARCHAR(20),\n" +
                "        genre VARCHAR(20),\n" +
                "        rating VARCHAR(20),\n" +
                "        desc VARCHAR(20) );";
        //execute the create table statements

        sqlQuery("SELECT * FROM Albums;");

        return url;
    }

    public void createTables(String sql)    {
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

        }catch (SQLException s) {
            System.out.println(s + " tried createTables... whooooop");
        }
    }

    public void printTables(String sql) {

    }

    public void sqlQuery(String sql) {
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            printResult(rs);

        }catch (SQLException s) {
            System.out.println(s + " tried sqlQuerie... whooooop");
        }
    }

    private void printResult(ResultSet rs) {
        try {
            ResultSetMetaData md = rs.getMetaData();
            int colCount = md.getColumnCount();
            int headerChars = 0;

            //Print the Column Names as Header
            for (int i = 1; i <= colCount; i++) {
                String col_name = md.getColumnName(i);
                System.out.print(String.format("%-24s ", col_name));
                headerChars += col_name.length();
            }

            //Print line under column names
            System.out.println();
            int e = md.getColumnCount() * 25;
            for(int i = 0; i < e; i++)  {
                System.out.print("-");
            }
            System.out.println();

            //print each line of the table
            while (rs.next()) {
                for (int i = 1; i <= colCount; i++)  {
                    System.out.print(String.format("%-24s ", rs.getString(i)));
                }
                System.out.println();
            }
            System.out.println();


        } catch (SQLException e) {
            System.out.println(e + "tried to print column name result in printResult");
        }
    }

}
