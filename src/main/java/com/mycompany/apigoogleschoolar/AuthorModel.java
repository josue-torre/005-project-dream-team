
package com.mycompany.apigoogleschoolar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Armando Josué
 */
public class AuthorModel {
    private final String name;
    private final String link;
    private final String affiliations;
    
    public AuthorModel(String name, String affiliations, String link){
        this.name = name;
        this.affiliations = affiliations;
        this.link = link;
    }
    
    public String getName(){
        return name;
    }
    
    public String getAffiliations(){
        return affiliations;
    }
    
    public String getLink(){
        return link;
    }
    
    public void save(){
        Connection conn = null;
        PreparedStatement statement = null;
        String query = "INSERT INTO scientists (name, affiliations, link) VALUES (?, ?, ?)";
        try {
            conn = DbConnection.getConnection();
            statement = conn.prepareStatement(query);
            
            statement.setString(1, this.getName());
            statement.setString(2, this.getAffiliations());
            statement.setString(3, this.getLink());
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Ocurrio un error al guardar los datos");
        }
        finally{
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("Ocurrio un error al cerrar la declaracion");
                }
            }
            if(conn != null){
                DbConnection.closeConnection();
            }
        }
    }
}
