/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd_mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Configuracion;

/**
 *
 * @author wilberto david
 */
public class Ventana_Cliente extends javax.swing.JFrame {

    /**
     * Creates new form Ventana_Productos
     */
    public Ventana_Cliente() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        mostrarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        eqCliente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCliente = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Productos");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eqCliente.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        eqCliente.setForeground(new java.awt.Color(204, 255, 204));
        eqCliente.setText("Clientes");
        jPanel1.add(eqCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 6, -1, -1));

        TablaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folio", "Nombre ", "Direccion", "Edad", "Telefono", "Oficio"
            }
        ));
        jScrollPane1.setViewportView(TablaCliente);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 58, 572, 101));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AgregarProducto.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 177, 57, -1));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.jpg"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 177, 56, -1));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/descarga.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 177, 55, -1));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar.jpg"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(483, 212, 55, 43));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo 1.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 270));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Configuracion.titulo = "Agregar Cliente";
        Configuracion.accion = 1;
        new GestionCliente(this, true);
        mostrarTabla();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        seleccionarFila();
        
        if(Configuracion.id.length()>0){
        Configuracion.titulo = "Editar producto";
        Configuracion.accion = 2;
        new GestionCliente(this, true);
        mostrarTabla();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        seleccionarFila();
        
        if(Configuracion.id.length()>0){
        Configuracion.titulo = "Eliminar Producto";
        Configuracion.accion = 3;
        new GestionCliente(this, true);
        mostrarTabla();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void seleccionarFila(){
        int fila = -1;
        Configuracion.id = "";
        
        if(TablaCliente.getSelectedRowCount()==1)
            fila = TablaCliente.getSelectedRow();
        else
            JOptionPane.showMessageDialog(this, "Selecionar solo una fila", "Error", JOptionPane.ERROR_MESSAGE);
        
        if(fila>-1)
            Configuracion.id = (String)TablaCliente.getValueAt(fila,1);
        
        System.out.println(Configuracion.id);
    }
    
    private void mostrarTabla(){
        String[] titulos = {"#", "Folio", "Nombre", "Direccion", "Edad", "Telefono", "Oficio"};
        DefaultTableModel tabla = new DefaultTableModel();
        ResultSet rs = Control_Cliente.mostrar();
        int x=0;
             
        try {
            int nf = Control_Cliente.getRows();
            Object[][] filas = new String[nf][7];
            
            while(rs.next()){
                filas[x][0] = (x+1) + "";
                filas[x][1] = rs.getString("Folio");
                filas[x][2] = rs.getString("Nombre");
                filas[x][3] = rs.getString("Direccion");
                filas[x][4] = rs.getInt("Edad") + "";
                filas[x][5] = rs.getString("Telefono");
                filas[x][6] = rs.getString("Oficio");
                x++;
            }
            tabla.setDataVector(filas, titulos);
            TablaCliente.setModel(tabla);
        } catch (SQLException ex) {
            Logger.getLogger(Ventana_Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaCliente;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel eqCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
