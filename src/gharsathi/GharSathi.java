/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gharsathi;

import Database.MysqlConnector;
import database.db;

/**
 *
 * @author Safal
 */
public class GharSathi {



/**
 *
 * @author Safal
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        db database = new MysqlConnector();
        database.openConnection();
    }
    
}
}

