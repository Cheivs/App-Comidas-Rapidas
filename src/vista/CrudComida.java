
package vista;

import javax.swing.JOptionPane;
import controlador.productos.Comidas;
import java.util.ArrayList;
import conexion.Conexion;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class CrudComida extends javax.swing.JPanel {

    Conexion cn = new Conexion();
    Connection con;
    DefaultTableModel model;
    Statement st;
    ResultSet rs;
    int id = 0;
    
    ArrayList <Comidas> comidas = new ArrayList();
    public CrudComida() {
        initComponents();
        listar();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaComidas = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel6.setText("Utilidad:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, 20));
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 140, 20));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 20)); // NOI18N
        jLabel3.setText("Comidas");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel4.setText("Nombre:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, 20));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 140, -1));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel5.setText("Costo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, 20));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 140, -1));

        jButton2.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add_user.png"))); // NOI18N
        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jButton5.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        jButton5.setText("Nuevo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, -1));

        jButton10.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/button_cancel.png"))); // NOI18N
        jButton10.setText("Eliminar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, -1, -1));

        jButton11.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/revert.png"))); // NOI18N
        jButton11.setText("Modificar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 110, -1));

        tablaComidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Valor Unitario"
            }
        ));
        jScrollPane1.setViewportView(tablaComidas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 370, 180));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    
    private void TablaDatosMouseClicked(java.awt.event.MouseEvent evt) {                                        
        int row = tablaComidas.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "No se Selecciono");
        } else {
            id = Integer.parseInt((String) tablaComidas.getValueAt(row, 0).toString());
            String nombre = (String) tablaComidas.getValueAt(row, 1);
            String cedula = (String) tablaComidas.getValueAt(row, 2);
            jTextField3.setText(cedula);
            jTextField1.setText(nombre);

        }
    } 
    
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


    void listar(){
        String sql = "select * from comidas";
        try {
            con = cn.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            Object[] comida = new Object[3];
            model = (DefaultTableModel) tablaComidas.getModel();
            while (rs.next()) {
                comida[0] = rs.getInt("idComida");
                comida[1] = rs.getString("nombreComida");
                comida[2] = rs.getInt("valorUnitario");
                model.addRow(comida);
            }
            tablaComidas.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar las comidas: " +e);
        }
    }
    
    void Agregar(){
        Comidas comidax = new Comidas();
        String nombre = jTextField1.getText().trim();
        int costo = Integer.parseInt(jTextField2.getText().trim());
        int utilidad =Integer.parseInt(jTextField3.getText().trim());
        comidax.setCosto(costo);
        comidax.setUtilidad(utilidad);
        int valorUnitario = comidax.precio();
        //System.out.println(nombre+" "+valorUnitario);
        try {
            if(nombre.isEmpty() || costo==0|| utilidad ==0){
                JOptionPane.showMessageDialog(null, "Llena todos los datos");
                limpiarTabla(model);
            } else {
                String sql = "insert into comidas(nombreComida, valorUnitario) VALUES('" + nombre + "','" + valorUnitario +"')";
                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Comida registrada con exito");
                
                limpiarTabla(model);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar la comida: " +e);
        }
    }
    
    void modificar(){
        Comidas comidax = new Comidas();
        String nombre = jTextField1.getText().trim();
        int costo = Integer.parseInt(jTextField2.getText().trim());
        int utilidad =Integer.parseInt(jTextField3.getText().trim());
        comidax.setCosto(costo);
        comidax.setUtilidad(utilidad);
        int valorUnitario = comidax.precio();
        
        int fila = tablaComidas.getSelectedRow();
        int id = (int) tablaComidas.getValueAt(fila, 0);
        
        String sql = "update comidas set nombreComida='" + nombre + "', valorUnitario='" + valorUnitario + "' where idComida=" + id;

        try {
            if (nombre != null || costo != 0 || utilidad != 0 || valorUnitario != 0 ){
                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Comida Modificada");
                limpiarTabla(model); //AQUI SALE UN ERROR PERO SI EJECUTA LA OPERACION
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar la comida: " +e);
        }
    }
    
    void eliminar(){
        int fila = tablaComidas.getSelectedRow();
        int id = (int) tablaComidas.getValueAt(fila, 0);
        String sql = "delete from comidas where idComida=" + id;
 
        if(fila<0){
            JOptionPane.showMessageDialog(null,"Selecciona una comida");
        } else {
            try {
                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Comida eliminada");
                limpiarTabla(model);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar la comida: " +e);
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
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tablaComidas;
    // End of variables declaration//GEN-END:variables
}
