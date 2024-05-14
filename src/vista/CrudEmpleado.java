
package vista;

import conexion.Conexion;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import controlador.personas.Empleado;
import encriptacion.EncriptarContraseña;


public class CrudEmpleado extends javax.swing.JPanel {

    Conexion cn = new Conexion();
    Connection con;
    DefaultTableModel model;
    Statement st;
    ResultSet rs;
    int id = 0;
    
    
    ArrayList <Empleado> proveedores = new ArrayList();
    public CrudEmpleado() {
        initComponents();
        listar();
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
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel5.setText("Identificación:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel7.setText("Correo:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, 10));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 140, -1));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 140, 20));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 20)); // NOI18N
        jLabel3.setText("Empleados");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel4.setText("Nombre:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 140, -1));

        jButton2.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add_user.png"))); // NOI18N
        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jButton5.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        jButton5.setText("Nuevo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, -1));

        jButton10.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/button_cancel.png"))); // NOI18N
        jButton10.setText("Eliminar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, -1, -1));

        jButton11.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/revert.png"))); // NOI18N
        jButton11.setText("Modificar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 110, -1));

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Cedula", "Correo"
            }
        ));
        tablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEmpleados);
        if (tablaEmpleados.getColumnModel().getColumnCount() > 0) {
            tablaEmpleados.getColumnModel().getColumn(0).setMinWidth(50);
            tablaEmpleados.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 450, 150));

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel8.setText("Contraseña:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, 10));
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 140, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Agregar();
        listar();
        nuevo();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        nuevo();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        eliminar();
        listar();
        nuevo();

        /*Cliente clientex = new Cliente();

        int num = Integer.parseInt(JOptionPane.showInputDialog("Digite el cliente a eliminar: "));

        for(int i=0; i<clientes.size(); i++){

            if(clientes.get(i).getNumeroCliente()== num){
                clientes.remove(i);
            }
        }
        clientex.disminuirContadorClientes();*/
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        modificar();
        listar();
        nuevo();

        /*int num = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero del cliente a modificar:"));

        int cambiar = Integer.parseInt(JOptionPane.showInputDialog("1) Cambiar nombre del cliente "
            + "\n2) Cambiar identificacion del cliente "
            + "\n3) Cambiar el pedido del cliente "
            + "\n0) Cancelar "));

    switch(cambiar){
        case 1:
        for(int i=0; i<clientes.size(); i++){
            if(clientes.get(i).getNumeroCliente()== num){
                String nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del cliente: ");
                clientes.get(i).setNombre(nombre);
                JOptionPane.showMessageDialog(null, "Registrado correctamente");
            }
        }
        break;

        case 2:
        for(int i=0; i<clientes.size(); i++){
            if(clientes.get(i).getNumeroCliente()== num){
                String identificacion = JOptionPane.showInputDialog("Ingrese la nueva identificacion del cliente: ");
                clientes.get(i).setIdentificacion(identificacion);
                JOptionPane.showMessageDialog(null, "Registrado correctamente");

            }
        }
        break;

        case 3:
        for(int i=0; i<clientes.size(); i++){
            if(clientes.get(i).getNumeroCliente()== num){
                String pedido = JOptionPane.showInputDialog("Ingrese el nuevo pedido del cliente: ");
                clientes.get(i).setPedido(pedido);
                JOptionPane.showMessageDialog(null, "Registrado correctamente");

            }
        }
        break;

        }*/
    }//GEN-LAST:event_jButton11ActionPerformed

    private void tablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMouseClicked
        
        int row = tablaEmpleados.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "No se Selecciono");
        } else {
            
            
            String nombre = (String) tablaEmpleados.getValueAt(row, 1);
            String cedula = (String) tablaEmpleados.getValueAt(row, 2);
            String correo = (String) tablaEmpleados.getValueAt(row, 3);
            
            
            
            jTextField1.setText(nombre);
            jTextField2.setText(cedula);
            jTextField3.setText(correo);
            
        }

    }//GEN-LAST:event_tablaEmpleadosMouseClicked
    void listar(){
        String sql = "select * from empleados";
        try {
            con = cn.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            Object[] empleado = new Object[4];
            model = (DefaultTableModel) tablaEmpleados.getModel();
            while (rs.next()) {
                empleado[0] = rs.getInt("idEmpleado");
                empleado[1] = rs.getString("nombreEmpleado");
                empleado[2] = rs.getString("cedulaEmpleado");
                empleado[3] = rs.getString("correoEmpleado");
                
                model.addRow(empleado);
            }
            tablaEmpleados.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar los empleados: " +e);
        }
    }
    
    void Agregar(){
        
        String nombre = jTextField1.getText().trim();
        String cedula = jTextField2.getText().trim();
        String correo = jTextField3.getText().trim();
        String contraseña = jPasswordField1.getText().trim();
       
        try {
            if(nombre.isEmpty() || cedula.isEmpty() || correo.isEmpty() || contraseña.isEmpty()){
                JOptionPane.showMessageDialog(null, "Llena todos los datos");
                limpiarTabla(model);
            } else {
                
                //ENCRIPTAR CONTRASEÑA
                EncriptarContraseña encriptar = new EncriptarContraseña();
                String contraEncriptada = encriptar.getMd5Hash(contraseña);
                
                String sql = "insert into empleados(nombreEmpleado, cedulaEmpleado, correoEmpleado, contraseña) VALUES('" + nombre + "','" + cedula +"','" + correo +"','" + contraEncriptada + "')";
                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Empleado registrado con exito");
                
                limpiarTabla(model);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el empleado: " +e);
        }
    }
    
    void modificar(){
        String nombre = jTextField1.getText().trim();
        String cedula = jTextField2.getText().trim();
        String correo = jTextField3.getText().trim();
        String contraseña = jPasswordField1.getText().trim();
        
        EncriptarContraseña encriptar = new EncriptarContraseña();
        String contraEncriptada = encriptar.getMd5Hash(contraseña);
        
        int fila = tablaEmpleados.getSelectedRow();
        int id = (int) tablaEmpleados.getValueAt(fila, 0);
       
        
        String sql = "update empleados set nombreEmpleado='" + nombre + "', cedulaEmpleado='" + cedula + "', correoEmpleado='" + correo + "', contraseña='" + contraEncriptada + "' where idEmpleado=" + id;

        try {
            
            
            
            if (nombre != null || cedula != null || correo != null || contraseña != null ){
               
                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Empleado Modificado");
                limpiarTabla(model); //AQUI SALE UN ERROR PERO SI EJECUTA LA OPERACION
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el empleado: " +e);
        }
    }
    
    void eliminar(){
        int fila = tablaEmpleados.getSelectedRow();
        int id = (int) tablaEmpleados.getValueAt(fila, 0);
        String sql = "delete from empleados where idEmpleado=" + id;
 
        if(fila<0){
            JOptionPane.showMessageDialog(null,"Selecciona un empleado");
        } else {
            try {
                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Empleado eliminado");
                limpiarTabla(model);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar el empleado: " +e);
            }
        }
    }
    
    void nuevo(){
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jPasswordField1.setText("");
        jTextField1.requestFocus();
    }
    
    void limpiarTabla(DefaultTableModel model) {
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    
    void Actualizar(){
        limpiarTabla(model);
        listar();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tablaEmpleados;
    // End of variables declaration//GEN-END:variables
}
