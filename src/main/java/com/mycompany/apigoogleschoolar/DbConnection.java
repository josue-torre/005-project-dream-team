
package com.mycompany.apigoogleschoolar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author balaz
 */
public class DbConnection {
    //USANDO EL PATRON DE DISEÑO SIGLETON
    //Variable de entorno
    private static final String DB_HOST = "jdbc:mysql://localhost:3307/";
    private static final String DB_NAME = "apigooglescholar";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";
    
    private static Connection conn = null;
    
    //Metodo para crear/devolver la conexion a la bd msyql
    public static Connection getConnection(){
        if(conn == null){
            try {
                conn = DriverManager.getConnection(DB_HOST + DB_NAME, DB_USER, DB_PASS);
            } catch (SQLException e) {
                return null;
            }
        }
        return conn;
    }
    //Metodo para cerrar la conexion con la bd
    public static void closeConnection(){
        if(conn != null){
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
