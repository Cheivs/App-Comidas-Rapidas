package vista;

import conexion.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import encriptacion.EncriptarContraseña;

public class InicioSesion extends javax.swing.JPanel {

    Conexion cn = new Conexion();
    Connection con;
    Statement st;
    ResultSet rs;
    
    public InicioSesion() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel1.setText("Correo:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(190, 40, 42, 20);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(240, 40, 170, 22);

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel2.setText("Contraseña:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(160, 70, 70, 20);

        jButton1.setBackground(new java.awt.Color(153, 255, 102));
        jButton1.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(240, 120, 90, 23);

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jPasswordField1);
        jPasswordField1.setBounds(240, 70, 170, 22);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String correo = jTextField1.getText().trim();
        String contraseña = jPasswordField1.getText().trim();
       
            if(correo.isEmpty() || contraseña.isEmpty()){
                JOptionPane.showMessageDialog(null, "Llena todos los campos");
            } else{
                
                EncriptarContraseña encriptar = new EncriptarContraseña();
                String contraEncriptada = encriptar.getMd5Hash(contraseña);
                
                try{
                    con = cn.getConnection();
                    st = con.createStatement();
                    rs = st.executeQuery("SELECT correoEmpleado, contraseña, nombreEmpleado FROM empleados WHERE correoEmpleado='" + correo + "' AND contraseña='" + contraEncriptada + "'");

                    if(rs.next()){
                        JOptionPane.showMessageDialog(null, "Bienvenido " + rs.getString("nombreEmpleado"));
                        new Inicio().setVisible(true);
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Datos incorrectos" );
                    }
                    
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Error al iniciar sesion: " + e);
                }
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
