package bd_mysql;

import java.sql.Connection;
import javax.swing.JFrame;
import util.Configuracion;
import util.MySQL;

public class Bd_MySQL {
    public static void main(String[] args) {
        
        Ventana_Menu vm = new Ventana_Menu();
        vm.setVisible(true);
        vm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Configuracion.conexion = new MySQL();
        
        MySQL my;
        
        my = new MySQL();
        Connection reg = my.getConnection();
        
    }  
}