
package vista;


import conexion.Conexion;
import controlador.personas.Cliente;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CrudCliente extends javax.swing.JPanel {
    
    Conexion cn = new Conexion();
    Connection con;
    DefaultTableModel model;
    Statement st;
    ResultSet rs;
    int id = 0;

    //ArrayList <Cliente> clientes = new ArrayList();
    public CrudCliente() {
        initComponents();
        //setLocationRelativeTo(null);
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
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel6.setText("Telefono:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, 20));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 150, -1));

        jButton2.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add_user.png"))); // NOI18N
        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jButton4.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        jButton4.setText("Nuevo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 20)); // NOI18N
        jLabel3.setText("Clientes");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel4.setText("Nombre:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        jButton7.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/button_cancel.png"))); // NOI18N
        jButton7.setText("Eliminar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 150, -1));

        jButton8.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/revert.png"))); // NOI18N
        jButton8.setText("Modificar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 110, -1));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel5.setText("Identificacion:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, 20));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 150, -1));

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Cedula", "Telefono"
            }
        ));
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaClientes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 410, 190));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void TablaDatosMouseClicked(java.awt.event.MouseEvent evt) {                                        
        int row = tablaClientes.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "No se Selecciono");
        } else {
            id = Integer.parseInt((String) tablaClientes.getValueAt(row, 0).toString());
            String nombre = (String) tablaClientes.getValueAt(row, 1);
            String cedula = (String) tablaClientes.getValueAt(row, 2);
            jTextField3.setText(cedula);
            jTextField1.setText(nombre);

        }
    } 
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        /*Cliente clientex = new Cliente();

        clientex.addContadorClientes();
        clientex.setNumeroCliente();
        clientex.setNombre(jTextField1.getText());
        clientex.setIdentificacion(jTextField2.getText());
        clientex.setPedido(jTextField3.getText());

        clientes.add(clientex);*/

        Agregar(); 
        listar();
        nuevo();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        nuevo();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
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
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        
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
    }//GEN-LAST:event_jButton8ActionPerformed
    

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        
        int row = tablaClientes.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "No se Selecciono");
        } else {
            String nombre = (String) tablaClientes.getValueAt(row, 1);
            String cedula = (String) tablaClientes.getValueAt(row, 2);
            String telefono = (String) tablaClientes.getValueAt(row, 3);
            jTextField1.setText(nombre);
            jTextField2.setText(cedula);
            jTextField3.setText(telefono);
        }
    }//GEN-LAST:event_tablaClientesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables
    void listar(){
        String sql = "select * from clientes";
        try {
            con = cn.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            Object[] cliente = new Object[4];
            model = (DefaultTableModel) tablaClientes.getModel();
            while (rs.next()) {
                cliente[0] = rs.getInt("idCliente");
                cliente[1] = rs.getString("nombreCliente");
                cliente[2] = rs.getString("cedulaCliente");
                cliente[3] = rs.getString("telefonoCliente");
                model.addRow(cliente);
            }
            tablaClientes.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar los clientes: " + e);
        }
    }
    
    void Agregar(){
        String nombre = jTextField1.getText().trim();
        String cedula = jTextField3.getText().trim();
        String telefono = jTextField2.getText().trim();
        //System.out.println(nombre+" "+cedula);
        try {
            if(nombre.isEmpty()||cedula.isEmpty()||telefono.isEmpty()){
                JOptionPane.showMessageDialog(null, "Llena todos los datos");
                limpiarTabla(model);
            } else {
                String sql = "insert into clientes(nombreCliente, cedulaCliente, telefonoCliente) VALUES('" + nombre + "','" + cedula +"','" + telefono +"')";
                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Cliente registrado con exito");
                
                limpiarTabla(model);
            }
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al agregar el cliente: " + e);
        }
    }
    
    void modificar(){
        String nombre = jTextField1.getText().trim();
        String cedula = jTextField3.getText().trim();
        String telefono = jTextField2.getText().trim();
        int fila = tablaClientes.getSelectedRow();
        int id = (int) tablaClientes.getValueAt(fila, 0);
        String sql = "update clientes set nombreCliente='" + nombre +"', cedulaCliente='" + cedula +"', telefonoCliente='" + telefono + "' where idCliente=" + id;
        try {
            if (cedula != null || nombre != null || telefono != null){
                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Cliente Modificado");
                limpiarTabla(model);
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el cliente: " + e);
        }
    }
    
    void eliminar(){
        int fila = tablaClientes.getSelectedRow();
        int id = (int) tablaClientes.getValueAt(fila, 0);
        String sql = "delete from clientes where idCliente=" + id;
 
        if(fila<0){
            JOptionPane.showMessageDialog(null,"Selecciona un cliente");
        } else {
            try {
                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Cliente eliminado");
                limpiarTabla(model);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar el cliente: " + e);
            }
        }
    }
    
    void nuevo(){
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
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
    
}
