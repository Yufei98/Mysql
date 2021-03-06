package bd_mysql;

import bd_mysql.ControlProveedor;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import util.Configuracion;
import java.sql.ResultSet; 
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class GestionProveedor extends javax.swing.JDialog {

    /**
     * Creates new form GestionProveedor
     */
    public GestionProveedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        inicio ();
        this.setLocationRelativeTo(parent);
        this.setVisible(true);
    }

    //Metodos de accion
    private void inicio (){
        lblTitulo.setText(Configuracion.titulo);
         if(Configuracion.accion ==2) rellenarCampos();
         
         if(Configuracion.accion ==3){
            rellenarCampos();
            desactivarCampos();
        }
        
        
       
    }
    private void agregarproveedor(){
        String Valida =ValidarCampos ();
        if (Valida.length() == 0){
        boolean ejecuta = ControlProveedor.agregar(
                     txtCodigo.getText(),
                     txtNombre.getText(),
                     txtDireccion.getText(),
                     txtTelefono.getText());
                     
        if (ejecuta){
            JOptionPane.showMessageDialog(this, "Proveedor Agregado" );
        dispose ();
        
        }else
            
             JOptionPane.showMessageDialog(this, "¡Error al Agregar Proveedor!", "Error", JOptionPane.ERROR_MESSAGE );
        
    }else
                     JOptionPane.showMessageDialog(this, Valida );

  
    }
    
    private void editarproveedor(){
        String Valida =ValidarCampos ();
        if (Valida.length() == 0){
        boolean ejecuta = ControlProveedor.editar(
                     txtCodigo.getText(),
                     txtNombre.getText(),
                     txtDireccion.getText(),
                     txtTelefono.getText());
                     
        if (ejecuta){
            JOptionPane.showMessageDialog(this, "Proveedor Editado Correctamente" );
        dispose ();
        
        }else
            
             JOptionPane.showMessageDialog(this, "Error Al Editar Proveedor!", "Error", JOptionPane.ERROR_MESSAGE );
        
    }else
                     JOptionPane.showMessageDialog(this, Valida );

  
    }
    private void eliminarproveedor(){
        boolean ejecuta = ControlProveedor.eliminar();
        if (ejecuta){
            JOptionPane.showMessageDialog(this, "Proveedor Eliminado Correctamente" );
        dispose ();
        
        }else
            
             JOptionPane.showMessageDialog(this, "Error Al Eliminar Proveedor!", "Error", JOptionPane.ERROR_MESSAGE );
       
    }
    
    
    private String ValidarCampos (){
        String msj = "";
        if(!txtCodigo.getText().matches("[A-Za-z0-9 ]{4,10}")) msj +="El codigo Solo Acepta Numeros y Letras De 4 a 10\n";
        if(!txtNombre.getText().matches("[A-Za-z0-9 ]{4,50}")) msj +="El Nombre Solo Acepta Numeros y Letras De 4 a 50 Caracteres\n";
        if(!txtDireccion.getText().matches("[A-Za-z0-9 ]{4,50}")) msj +="La Direccion Solo Acepta Numeros y Letras De 4 a 50 Caracteres\n";
        if(!txtTelefono.getText().matches("[0-9]*")) msj +="El Telefono Solo Acepta Numeros\n";
        return msj;
    
   }
    
    private void rellenarCampos(){
        ResultSet rs = ControlProveedor.proveedor();
        try {
            rs.next();
            txtCodigo.setText(rs.getString("codigo")+ "");
            txtNombre.setText(rs.getString("nombre"));
            txtDireccion.setText(rs.getString("direccion"));
            txtTelefono.setText(rs.getString("telefono") + "");
            } catch (SQLException ex) {
            Logger.getLogger(GestionProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void desactivarCampos(){
        txtCodigo.setEditable(false);
        txtNombre.setEditable(false);
        txtDireccion.setEditable(false);
        txtTelefono.setEditable(false);
        
    }
    
    
    
    
    //Fin metodos de accion
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtTelefono = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Titulo");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 250, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Codigo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 47, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 255, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 47, 10));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 255, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Direccion");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 255, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Telefono");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 52, -1));
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 137, 29));
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 137, 29));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 137, 29));

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 250, -1, 31));

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 250, -1, 31));
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 137, 29));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo.jpg"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        switch(Configuracion.accion){
         case 1: agregarproveedor(); break;
         case 2: editarproveedor();  break;
         case 3: eliminarproveedor(); break;
     }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
