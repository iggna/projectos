
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class CargaBase {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase(String nombre, String email, String contra, String fecha) throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
              connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/formulario?"
                            + "user=root");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from formulario.usuarios");
            writeResultSet(resultSet);

            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect
                    .prepareStatement("INSERT INTO usuarios VALUES (?,?,?,?)");
            // "usuario, email, fecha de nacimiento, contraseÃ±a, COMMENTS from juegoonline.comments");
            // Parameters start with 1
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, contra);
            preparedStatement.setString(4, fecha);
            preparedStatement.executeUpdate();

            preparedStatement = connect
                    .prepareStatement("SELECT  * from formulario.usuarios");
            resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);

            // Remove again the insert comment
     /*       preparedStatement = connect
            .prepareStatement("delete from formulario.usuarios where myuser= ? ; ");
            preparedStatement.setString(1, "Test");
            preparedStatement.executeUpdate();

            resultSet = statement
            .executeQuery("select * from formulario.usuarios");
            writeMetaData(resultSet);*/

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
            String Nombre = resultSet.getString("Nombre");
            String Email = resultSet.getString("Email");
            String contraseña = resultSet.getString("contra");
            String fecha = resultSet.getString("Fecha de Nacimiento");
            System.out.println("Nombre: " + Nombre);
            System.out.println("Email: " + Email);
            System.out.println("Contraseña: " + contraseña);
            System.out.println("Fecha de Nacimiento: " + fecha);            
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
        } catch (SQLException e) {

        }
    }

}



