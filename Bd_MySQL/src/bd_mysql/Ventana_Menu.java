package bd_mysql;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ventana_Menu extends JFrame {
    public Ventana_Menu() {
        setTitle("Menu");
        setSize(215,300);
        setLocationRelativeTo(null);
        this.setBackground(Color.MAGENTA);
        
        Panel p = new Panel();
        add(p);
        p.setLayout(null);
        
    }
}

class Panel extends JPanel{
    
    public void paintComponent (Graphics g){
        
        JLabel etMenu = new JLabel("Menu");
        
        JButton btnProveedor = new JButton ("Proveedores");
        JButton btnProducto = new JButton ("Productos");
        JButton btnCliente = new JButton ("Clientes");
        
        btnProveedor.setBounds(30, 70, 130, 30);
        btnProducto.setBounds(30, 120, 130, 30);
        btnCliente.setBounds(30, 170, 130, 30);
        
        etMenu.setBounds(55, 20, 130, 30);
        
        etMenu.setFont(new Font("arial", Font.BOLD, 30));
        etMenu.setForeground(Color.WHITE);
        
        add(etMenu);
        add(btnProveedor);
        add(btnProducto);
        add(btnCliente);
        
        ActionListener Evento = new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==btnProveedor){
                    Ventana_Provedores vp = new Ventana_Provedores();
                    vp.setVisible(true);
                    vp.setLocationRelativeTo(null);
                }else    
                
                if(e.getSource()==btnCliente){
                    Ventana_Cliente vc = new Ventana_Cliente();
                    vc.setVisible(true);
                    vc.setLocationRelativeTo(null);
                }
                
                if(e.getSource()==btnProducto){
                    Ventana_Producto vpr = new Ventana_Producto();
                    vpr.setVisible(true);
                    vpr.setLocationRelativeTo(null);
                }
            }
             
        };
                btnProveedor.addActionListener(Evento);
                btnCliente.addActionListener(Evento);
                btnProducto.addActionListener(Evento);
    }  
}