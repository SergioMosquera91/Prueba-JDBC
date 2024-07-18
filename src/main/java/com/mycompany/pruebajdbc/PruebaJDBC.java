/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YEYO
 */
public class PruebaJDBC {

    public static void main(String[] args) {
       String usuario="root";
       String password="";
       String url="jdbc:mysql://localhost:3306/PruebaJDBC";
       Connection conexion;
       Statement statement;
       ResultSet rs;
        
       try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            // Insercion de datos 
            statement.execute("INSERT INTO `usuarios` (`Id`, `Nombre`) VALUES (NULL, 'juanjose');");
            System.out.println("");
             rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            //Actualizacion de datos
            statement.execute("UPDATE `usuarios` SET `Nombre` = 'juanpablo' WHERE `usuarios`.`Id` = 3;");
            System.out.println("");
             rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            // Borrado o elimacion de datos 
             statement.execute("DELETE FROM 'usuarios' WHERE 'usuarios' . 'id' = 2");
            System.out.println("");
             rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
       } catch (SQLException ex) {
            Logger.getLogger(PruebaJDBC.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}


