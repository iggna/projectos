package juegoonline;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class JuegoOnline {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/juegoonline?"+"user=root");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from juegoonline.comments");
            writeResultSet(resultSet);

            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect
                    .prepareStatement("insert into juegoonline.comments values (default, ?, ?, ?, ?)");
            // "usuario, email, datum, contraseña, COMMENTS from juegoonline.comments");
            // Parameters start with 1
            //preparedStatement.setInt(1, Integer.valueOf("21")); // Integer.valueOf("Id"));
            preparedStatement.setString(1, "Usuario");
            preparedStatement.setString(2, "Email");
            preparedStatement.setString(3, "FechaDeNacimiento"); //new java.sql.Date(1998, 04, 26));
            preparedStatement.setString(4, "Contrasena");
            preparedStatement.executeUpdate();

            preparedStatement = connect
                    .prepareStatement("SELECT * from juegoonline.comments");
            resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);

            // Remove again the insert comment
            preparedStatement = connect
            .prepareStatement("delete from juegoonline.comments where Usuario= ? ; ");
            preparedStatement.setString(1, "Test");
            preparedStatement.executeUpdate();

            resultSet = statement
            .executeQuery("select * from juegoonline.comments");
            writeMetaData(resultSet);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            int id = resultSet.getInt("id");
            String Usuario = resultSet.getString("Usuario");
            String Email = resultSet.getString("Email");
            String date = resultSet.getString("FechaDeNacimiento");
            String contrasena = resultSet.getString("Contrasena");
            System.out.println("Id: " + id);
            System.out.println("Usuario: " + Usuario);
            System.out.println("Email: " + Email);
            System.out.println("FechaDeNacimiento: " + date);
            System.out.println("Comment: " + contrasena);
        }
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}

    









/**
 *
 * @author usuario
 */


    /**
     * @param args the command line arguments
     */
  
        // TODO code application logic here
    
    

