
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControladorClientes {
    
    static Conexion cn = new Conexion();
    static Connection con;
    static Statement st;
    static ResultSet rs;
    int id = 0;
    
    public static void Agregar(JTable tablaClientes, DefaultTableModel model, JTextField jTextField1, JTextField jTextField2, JTextField jTextField3){
        String nombre = jTextField1.getText().trim();
        String cedula = jTextField3.getText().trim();
        String telefono = jTextField2.getText().trim();
        
        
        try {
            if(nombre.isEmpty()||cedula.isEmpty()||telefono.isEmpty()){
                JOptionPane.showMessageDialog(null, "Llena todos los datos");
                limpiarTabla(tablaClientes, model);
            } else {
                String sql = "insert into clientes(nombreCliente, cedulaCliente, telefonoCliente) VALUES('" + nombre + "','" + cedula +"','" + telefono +"')";
                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Cliente registrado con exito");
                
                limpiarTabla(tablaClientes, model);
            }
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al agregar el cliente: " + e);
        }
    }
    
    public static void limpiarTabla(JTable tablaClientes, DefaultTableModel model) {
        model = (DefaultTableModel) tablaClientes.getModel();
        while (model.getRowCount() > 0) {
        model.removeRow(0);
        }
    }
    
    public static void listar(DefaultTableModel model, JTable tablaClientes){
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
    
    public static void modificar(JTextField jTextField1, JTextField jTextField2, JTextField jTextField3, DefaultTableModel model, JTable tablaClientes){
        String nombre = jTextField1.getText().trim();
        String cedula = jTextField3.getText().trim();
        String telefono = jTextField2.getText().trim();
        model = (DefaultTableModel) tablaClientes.getModel();
        int fila = tablaClientes.getSelectedRow();
        int id = (int) tablaClientes.getValueAt(fila, 0);
        String sql = "update clientes set nombreCliente='" + nombre +"', cedulaCliente='" + cedula +"', telefonoCliente='" + telefono + "' where idCliente=" + id;
        try {
            if (cedula != null || nombre != null || telefono != null){
                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Cliente Modificado");
                limpiarTabla(tablaClientes, model);
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el cliente: " + e);
        }
    }
    
    public static void eliminar(DefaultTableModel model, JTable tablaClientes){
        int fila = tablaClientes.getSelectedRow();
        int id = (int) tablaClientes.getValueAt(fila, 0);
        model = (DefaultTableModel) tablaClientes.getModel();
        String sql = "delete from clientes where idCliente=" + id;
 
        if(fila<0){
            JOptionPane.showMessageDialog(null,"Selecciona un cliente");
        } else {
            try {
                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Cliente eliminado");
                limpiarTabla(tablaClientes, model);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar el cliente: " + e);
            }
        }
    }
    
    public static void nuevo(JTextField jTextField1, JTextField jTextField2, JTextField jTextField3){
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField1.requestFocus();
    }
    
}
