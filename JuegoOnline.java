/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.online;


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
                    .prepareStatement("insert into  juegoonline.comments values (default, ?, ?, ?, ? , ?)");
            // "usuario, email, datum, contraseÃ±a, COMMENTS from juegoonline.comments");
            // Parameters start with 1
            preparedStatement.setString(1, "Testid");
            preparedStatement.setString(2, "TestUsuario");
            preparedStatement.setString(3, "TestEmail");
            preparedStatement.setDate(4, new java.sql.Date(1998, 04, 26));
            preparedStatement.setString(5, "Testcontraseña");
            preparedStatement.executeUpdate();

            preparedStatement = connect
                    .prepareStatement("SELECT id, Usuario ,email, datum, contraseña, from juegoonline.comments");
            resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);

            // Remove again the insert comment
            preparedStatement = connect
            .prepareStatement("delete from juegoonline.comments where myuser= ? ; ");
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
            String id = resultSet.getString("id");
            String Usuario = resultSet.getString("Usuario");
            String Email = resultSet.getString("Email");
            Date date = resultSet.getDate("datum");
            String contraseña = resultSet.getString("contraseÃ±a");
            System.out.println("Id: " + id);
            System.out.println("Usuario: " + Usuario);
            System.out.println("Email: " + Email);
            System.out.println("Date: " + date);
            System.out.println("Comment: " + contraseña);
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
    
    

