package bd_mysql;

import util.Configuracion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Daniel
 */
public class ControlProveedor {
    public static boolean agregar (String codigo, String nombre, String direccion, String telefono){
     String sql = "INSERT INTO proveedorestabla (codigo, nombre, direccion, telefono)"
             + "VALUES ('"+codigo+"', '"+nombre+"', '"+direccion+"', '"+telefono+"');";
     
             return Configuracion.conexion.ejecutaSQL(sql);
    
    }
    
    public static boolean editar (String codigo, String nombre, String direccion, String telefono){
     String sql = "UPDATE proveedorestabla SET "
             + "codigo = '"+codigo+"', nombre = '"+nombre+"', direccion = '"+direccion+"', telefono ='"+telefono+"' WHERE codigo = '"+Configuracion.id+"'";
     
             return Configuracion.conexion.ejecutaSQL(sql);
             
    }
    
     public static boolean eliminar (){
     String sql = "DELETE FROM proveedorestabla WHERE codigo = '"+Configuracion.id+"'";
     
             return Configuracion.conexion.ejecutaSQL(sql);
             
    }
     
    public static ResultSet mostrar(){
        ResultSet rs = null;
        String sql = "SELECT * FROM proveedorestabla ORDER BY nombre ASC";
        rs = Configuracion.conexion.consultaSQL(sql);
        return rs;
        
    }
    public static int getRows(){
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) AS cantidad FROM proveedorestabla";
        rs= Configuracion.conexion.consultaSQL(sql);
        try {
            while(rs.next())
                return rs.getInt("cantidad");
        } catch (SQLException ex) {
            Logger.getLogger(ControlProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    } 
    public static ResultSet proveedor(){
        ResultSet rs = null;
        String sql = "SELECT * FROM proveedorestabla WHERE codigo = '"+Configuracion.id+"'";
        rs= Configuracion.conexion.consultaSQL(sql);
        return rs;
    } 
}
