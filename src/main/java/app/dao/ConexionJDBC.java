/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Cristian
 */
public class ConexionJDBC {
    private static final String USUARIO = "root";
    private static final String PASSWORD = "anf0ter0";
    private static final String URL_CONEXION = "jdbc:mysql://localhost:3306/app-rrhh";
    private static Connection CONEXION;

    public static Connection getConexion() {
        try{
            if (CONEXION == null) {
                CONEXION = DriverManager.getConnection(URL_CONEXION, USUARIO, PASSWORD);
            }
            return CONEXION;
        }catch (SQLException ex) {
                Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void liberarConexion() {
        try{
            if (CONEXION != null) {
                CONEXION.close();
                CONEXION = null;
            }
        }catch (SQLException ex) {
                Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
