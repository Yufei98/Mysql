
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
public class GestionCliente extends javax.swing.JDialog {

    /**
     * Creates new form GestionCliente
     */
    public GestionCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        inicio();
        this.setLocationRelativeTo(parent);
        this.setVisible(true);
    }
    
    private void inicio(){
        JlNombre.setText(Configuracion.titulo);
        
        if(Configuracion.accion == 2){
            rellenarCampos();
        }
        
        if(Configuracion.accion == 3){
            rellenarCampos();
            desactivarCampos();
        }
    }

    private void agregarCliente(){
        String valida = validarCampos();
        
        if(valida.length() == 0){
        boolean ejecuta = Control_Cliente.agregar(
                txtFolio.getText(), 
                txtNombre.getText(), 
                txtDireccion.getText(), 
                txtEdad.getText(), 
                txtTelefono.getText(), 
                txtOficio.getText());
        
        if(ejecuta){
            JOptionPane.showMessageDialog(null, "Cliente agregado");
            dispose();
        }else
            JOptionPane.showMessageDialog(null, "Error al agregar Cliente ", "Error", JOptionPane.ERROR_MESSAGE);
        
        }else
            JOptionPane.showMessageDialog(null, valida);
    
        }
    
    private void editarCliente(){
        String valida = validarCampos();
        
        if(valida.length() == 0){
        boolean ejecuta = Control_Cliente.editar
               (txtFolio.getText(), 
                txtNombre.getText(), 
                txtDireccion.getText(), 
                txtEdad.getText(), 
                txtTelefono.getText(),
                txtOficio.getText()
               );
        
        if(ejecuta){
            JOptionPane.showMessageDialog(null, "Cliente editado");
            dispose();
        }else
            JOptionPane.showMessageDialog(null, "Error al editar datos ", "Error", JOptionPane.ERROR_MESSAGE);
        
        }else
            JOptionPane.showMessageDialog(null, valida);
                
    }
    
    private void eliminarCliente(){
        boolean ejecuta = Control_Cliente.eliminar();
        
        if(ejecuta){
            JOptionPane.showMessageDialog(null, "Cliente eliminado");
            dispose();
        }else
            JOptionPane.showMessageDialog(null, "Error al eliminar datos ", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private String validarCampos(){
        String msj = "";
        
        if(!txtFolio.getText().matches("[A-Za-z0-9]{4,10}")) msj += "El folio solo acepta letras y números de 4 a 10 caracteres\n";
        if(!txtNombre.getText().matches("[A-Za-z0-9 ]{4,50}")) msj += "El nombre solo acepta letras y números de 4 a 50 caracteres\n";
        if(!txtDireccion.getText().matches("[A-Za-z0-9 ]{4,50}")) msj += "La direccion solo acepta letras y números de 4 a 50 caracteres\n";
        if(!txtEdad.getText().matches("[0-9]+")) msj += "La edad no corresponde a un valor numerico\n";
        if(!txtTelefono.getText().matches("[0-9]{4,50}")) msj += "El telefono no corresponde a un valor numerico\n";
        if(!txtOficio.getText().matches("[A-Za-z0-9]{4,50}")) msj += "El oficio solo acepta letras y números de 4 a 50 caracteres\n";
        return msj;
    }
    
    private void rellenarCampos(){
        ResultSet rs = Control_Cliente.cliente();
        
        try {
            rs.next();
            this.txtFolio.setText(rs.getString("Folio"));
            txtNombre.setText(rs.getString("Nombre"));
            txtDireccion.setText(rs.getString("Direccion"));
            txtEdad.setText(rs.getInt("Edad")+"");
            txtTelefono.setText(rs.getString("Telefono"));
            txtOficio.setText(rs.getString("Oficio"));
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void desactivarCampos(){
        txtFolio.setEditable(false);
        txtNombre.setEditable(false);
        txtDireccion.setEditable(false);
        txtEdad.setEditable(false);
        txtTelefono.setEditable(false);
        txtOficio.setEditable(false);
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
        JlNombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtFolio = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtOficio = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtEdad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JlNombre.setFont(new java.awt.Font("AR JULIAN", 0, 18)); // NOI18N
        JlNombre.setForeground(new java.awt.Color(255, 255, 255));
        JlNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlNombre.setText("Nombre");
        jPanel1.add(JlNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 19, 280, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 153));
        jLabel1.setText("Folio");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 86, 70, 23));
        jPanel1.add(txtFolio, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 87, 145, -1));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 121, 145, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 153));
        jLabel2.setText("Dirección");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 153, 70, 23));

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 153, 145, 22));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 255, 153));
        jLabel3.setText("Nombre");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 70, 23));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 255, 153));
        jLabel4.setText("Edad");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 187, 70, 23));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 255, 153));
        jLabel5.setText("Télefono");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 221, 70, 23));
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 222, 145, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 255, 153));
        jLabel6.setText("Oficio");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 70, 23));
        jPanel1.add(txtOficio, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 251, 145, -1));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 319, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 319, -1, -1));

        txtEdad.setMaximumSize(new java.awt.Dimension(145, 2147483647));
        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 188, 145, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 360));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        switch(Configuracion.accion){
            case 1:
                agregarCliente();    
            break;
            
            case 2: 
                editarCliente();
            break;               
            
            case 3:
                eliminarCliente();    
            break;
        }
    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlNombre;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtOficio;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
