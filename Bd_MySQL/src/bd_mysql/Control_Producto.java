
package bd_mysql;

//import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Configuracion;

public class Control_Producto {
    public static boolean agregar(String codigo, String nombre, String cantidad, 
            String precio, String categoria){
        
        String sql = "INSERT INTO productostabla (codigo, nombre, cantidad, precio, categoria)"
                +"VALUES ('"+codigo+"', '"+nombre+"', '"+cantidad+"', '"+precio+"', '"+categoria+"');" ; 
        
        return Configuracion.conexion.ejecutaSQL(sql);
    }
        
        public static boolean editar(String codigo, String nombre, String cantidad, 
            String precio, String categoria){
        
        String sql = "UPDATE productostabla SET "
                + "codigo= '"+codigo+"', nombre='"+nombre+"', cantidad='"+cantidad+"', precio='"+precio+"', categoria='"+categoria+"' WHERE codigo = '"+Configuracion.id+"' "; 
        
        return Configuracion.conexion.ejecutaSQL(sql);

        }
        
        public static boolean eliminar(){
        
        String sql = "DELETE FROM productostabla WHERE codigo = '"+Configuracion.id+"' "; 
        
        return Configuracion.conexion.ejecutaSQL(sql);

        }
    
    public static ResultSet mostrar(){
        ResultSet rs = null;
        
        String sql = "SELECT * FROM productostabla ORDER BY nombre ASC";
        rs = Configuracion.conexion.consultaSQL(sql);
        return rs;
    }
    
    public static int getRows(){
        ResultSet rs = null;
        
        String sql = "SELECT COUNT(*) AS cantidad FROM productostabla";
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
    
    public static ResultSet producto(){
        ResultSet rs = null;
        
        String sql = "SELECT * FROM productostabla WHERE codigo = '"+Configuracion.id+"'";
        rs = Configuracion.conexion.consultaSQL(sql);
        
        return rs;
    }
}
