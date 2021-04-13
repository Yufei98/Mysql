package bd_mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Configuracion;

public class Control_Cliente {
    public static boolean agregar(String folio, String nombre, String direccion, 
            String edad, String telefono, String oficio){
        
        String sql = "INSERT INTO clientestabla (folio, nombre, direccion, edad, telefono, oficio)"
                +"VALUES ('"+folio+"', '"+nombre+"', '"+direccion+"', '"+edad+"', '"+telefono+"', '"+oficio+"');" ; 
        
        return Configuracion.conexion.ejecutaSQL(sql);
    }
    
    public static boolean editar(String folio, String nombre, String direccion, 
            String edad, String telefono, String oficio){
        
        String sql = "UPDATE clientestabla SET "
                + "folio= '"+folio+"', nombre='"+nombre+"', direccion='"+direccion+"', edad='"+edad+"', telefono='"
                +telefono+"', oficio='"+oficio+"' WHERE folio = '"+Configuracion.id+"' "; 
        
        return Configuracion.conexion.ejecutaSQL(sql);

        }
    
    public static boolean eliminar(){
        
        String sql = "DELETE FROM clientestabla WHERE folio = '"+Configuracion.id+"' "; 
        
        return Configuracion.conexion.ejecutaSQL(sql);

        }
    
    public static ResultSet mostrar(){
        ResultSet rs = null;
        
        String sql = "SELECT * FROM clientestabla ORDER BY nombre ASC";
        rs = Configuracion.conexion.consultaSQL(sql);
        return rs;
    }
    
    public static int getRows(){
        ResultSet rs = null;
        
        String sql = "SELECT COUNT(*) AS cantidad FROM clientestabla";
        rs = Configuracion.conexion.consultaSQL(sql);
        
        try {
            while(rs.next()){
                return rs.getInt("cantidad");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Control_Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static ResultSet cliente(){
        ResultSet rs = null;
        
        String sql = "SELECT * FROM clientestabla WHERE folio = '"+Configuracion.id+"'";
        rs = Configuracion.conexion.consultaSQL(sql);
        
        return rs;
    }
}
