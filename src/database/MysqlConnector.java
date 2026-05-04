/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Safal
 */
public class MysqlConnector implements db {
    @Override
    public Connection openConnection(){
    try {
        String username = "frahia";
        String password= "2007";
        String database = "monday";
    Connection connection;
    connection = DriverManager .getConnection(
            "jdbc:mysql://127.0.0.1:3306/" + database ,username, password 
          );
             if(connection == null){

                System.out.println("Database connection fail");

            }else{

                System.out.println("Database connection success");

            }

            return connection;

           } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
            return null;

        }

    }


}
    