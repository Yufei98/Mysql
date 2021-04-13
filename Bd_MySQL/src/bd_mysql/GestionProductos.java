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
import util.Configuracion;

/**
 *
 * @author wilberto david
 */
public class GestionProductos extends javax.swing.JDialog {

    /**
     * Creates new form GestionProductos
     */
    public GestionProductos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        inicio();
        this.setLocationRelativeTo(parent);
        this.setVisible(true);
    }
    
    private void inicio(){
        jlProductos.setText(Configuracion.titulo);
        
        if(Configuracion.accion == 2){
            rellenarCampos();
        }
        
        if(Configuracion.accion == 3){
            rellenarCampos();
            desactivarCampos();
        }
    }
    
    private void agregarProducto(){
        String valida = validarCampos();
        
        if(valida.length() == 0){
        boolean ejecuta = Control_Producto.agregar
               (txtCodigo.getText(), 
                txtNombre.getText(), 
                txtCantidad.getText(), 
                txtPrecio.getText(), 
                txtCategoria.getText());
        
        if(ejecuta){
            JOptionPane.showMessageDialog(null, "Productos agregados ");
            dispose();
        }else
            JOptionPane.showMessageDialog(null, "Error al agregar datos ", "Error", JOptionPane.ERROR_MESSAGE);
        
        }else
            JOptionPane.showMessageDialog(null, valida);
                
    }
    
    private void editarProducto(){
        String valida = validarCampos();
        
        if(valida.length() == 0){
        boolean ejecuta = Control_Producto.editar
               (txtCodigo.getText(), 
                txtNombre.getText(), 
                txtCantidad.getText(), 
                txtPrecio.getText(), 
                txtCategoria.getText());
        
        if(ejecuta){
            JOptionPane.showMessageDialog(null, "Producto editado");
            dispose();
        }else
            JOptionPane.showMessageDialog(null, "Error al editar datos ", "Error", JOptionPane.ERROR_MESSAGE);
        
        }else
            JOptionPane.showMessageDialog(null, valida);
                
    }
    
    private void eliminarProducto(){
        boolean ejecuta = Control_Producto.eliminar();
        
        if(ejecuta){
            JOptionPane.showMessageDialog(null, "Producto eliminado");
            dispose();
        }else
            JOptionPane.showMessageDialog(null, "Error al eliminar datos ", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private String validarCampos(){
        String msj = "";
        
        if(!txtCodigo.getText().matches("[A-Za-z0-9]{4,10}")) msj += "El codigo solo acepta letras y números de 4 a 10 caracteres\n";
        if(!txtNombre.getText().matches("[A-Za-z0-9 ]{4,50}")) msj += "El nombre solo acepta letras y números de 4 a 50 caracteres\n";
        if(!txtCantidad.getText().matches("[0-9]+")) msj += "Cantidad solo acepta números\n";
        if(!txtPrecio.getText().matches("[0-9]+.[0-9]{1,2}")) msj += "El precio no corresponde a un valor numerico\n";
        if(!txtCategoria.getText().matches("[A-Za-z0-9]{4,50}")) msj += "La categoria solo acepta letras y números de 4 a 50 caracteres\n";
        return msj;
    }
    
    private void rellenarCampos(){
        ResultSet rs = Control_Producto.producto();
        
        try {
            rs.next();
            this.txtCodigo.setText(rs.getString("Codigo"));
            txtNombre.setText(rs.getString("Nombre"));
            txtCantidad.setText(rs.getInt("Cantidad")+"");
            txtPrecio.setText(rs.getDouble("Precio")+"");
            txtCategoria.setText(rs.getString("Categoria"));
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void desactivarCampos(){
        txtCodigo.setEditable(false);
        txtNombre.setEditable(false);
        txtCantidad.setEditable(false);
        txtPrecio.setEditable(false);
        txtCategoria.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jlProductos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        Nombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel3.setText("jLabel2");

        jTextField2.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formulario");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlProductos.setFont(new java.awt.Font("AR JULIAN", 0, 18)); // NOI18N
        jlProductos.setForeground(new java.awt.Color(255, 255, 255));
        jlProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlProductos.setText("Nombre");
        jPanel1.add(jlProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 211, 32));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 153));
        jLabel2.setText("Código");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 76, -1, -1));

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 73, 127, -1));

        Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Nombre.setForeground(new java.awt.Color(102, 255, 153));
        Nombre.setText("Nombre");
        jPanel1.add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 107, -1, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 104, 127, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 255, 153));
        jLabel5.setText("Cantidad");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 138, -1, -1));
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 135, 127, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 255, 153));
        jLabel6.setText("Precio");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 169, -1, -1));
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 166, 127, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 255, 153));
        jLabel7.setText("Categoria");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 200, -1, -1));
        jPanel1.add(txtCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 197, 127, -1));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 245, 85, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 245, 85, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        switch(Configuracion.accion){
            case 1:
                agregarProducto();    
            break;
            
            case 2: 
                editarProducto();
            break;               
            
            case 3:
                eliminarProducto();    
            break;
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nombre;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel jlProductos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
