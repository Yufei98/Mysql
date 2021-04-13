
package util;

import java.sql.*;
import java.util.logging.*;
import javax.swing.*;

public class MySQL {
    private final String BD = "proyecto";
    private final String USER = "root";
    private final String PASS = "Los3reyesvagos*";
    private final String SERVER = "localhost:3306";
    protected Connection conexion;
    
    public MySQL(){
        String url = "jdbc:mysql://"+SERVER+"/"+BD+"?serverTimezone=UTC";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(url,USER,PASS);
            System.out.println("Conectado ");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar ", "Error", JOptionPane.WARNING_MESSAGE);
            System.err.println(e);
            System.exit(0);
        }
    }
    
    public boolean ejecutaSQL(String SQL){
        
        try{
        Statement consulta = conexion.createStatement();
        consulta.executeUpdate(SQL);
        consulta.close();
        return true;
        
    }catch(Exception ex){
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
            }
    }
    
    public ResultSet consultaSQL(String SQL){
        ResultSet rs = null;
        
        try{
            Statement consulta = conexion.createStatement();
            rs = consulta.executeQuery(SQL);
        }catch(Exception ex){
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public Connection getConnection() {
        return conexion;
            }
}
