
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.productos.Bebidas;

public class ControladorBebidas {
    
    static Conexion cn = new Conexion();
    static Connection con;
    static Statement st;
    static ResultSet rs;
    int id = 0;
    
    public static void listar(JTable tablaBebidas, DefaultTableModel model){
        String sql = "select * from bebidas";
        try {
            con = cn.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            Object[] bebida = new Object[5];
            model = (DefaultTableModel) tablaBebidas.getModel();
            while (rs.next()) {
                bebida[0] = rs.getInt("idBebida");
                bebida[1] = rs.getString("nombreBebida");
                bebida[2] = rs.getString("costoPaqueta");
                bebida[3] = rs.getString("utilidad");
                bebida[4] = rs.getInt("valorUnitario");
                model.addRow(bebida);
            }
            tablaBebidas.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar las bebidas: " +e);
        }
    }
    
    public static void Agregar(JTextField jTextField1, JTextField jTextField2, JTextField jTextField3, DefaultTableModel model, JTable tablaBebidas){
        Bebidas bebidax = new Bebidas();
        String nombre = jTextField1.getText().trim();
        int costo = Integer.parseInt(jTextField2.getText().trim());
        int utilidad =Integer.parseInt(jTextField3.getText().trim());
        bebidax.setCosto(costo);
        bebidax.setUtilidad(utilidad);
        int valorUnitario = bebidax.precio();
        try {
            if(nombre.isEmpty() || costo==0|| utilidad ==0){
                JOptionPane.showMessageDialog(null, "Llena todos los datos");
                limpiarTabla(tablaBebidas, model);
            } else {
                String sql = "insert into bebidas(nombreBebida, costoPaqueta, utilidad, valorUnitario) VALUES('" + nombre + "','" + costo + "','" + utilidad + "','" + valorUnitario +"')";
                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Bebida registrada con exito");
                
                limpiarTabla(tablaBebidas, model);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar la bebida: " +e);
        }
    }
    
    public static void modificar(JTextField jTextField1, JTextField jTextField2, JTextField jTextField3, DefaultTableModel model, JTable tablaBebidas){
        Bebidas bebidax = new Bebidas();
        String nombre = jTextField1.getText().trim();
        int costo = Integer.parseInt(jTextField2.getText().trim());
        int utilidad =Integer.parseInt(jTextField3.getText().trim());
        bebidax.setCosto(costo);
        bebidax.setUtilidad(utilidad);
        int valorUnitario = bebidax.precio();
        
        int fila = tablaBebidas.getSelectedRow();
        int id = (int) tablaBebidas.getValueAt(fila, 0);
        
        String sql = "update bebidas set nombreBebida='" + nombre + "', costoPaqueta='"+ costo +"', utilidad='"+ utilidad + "', valorUnitario='" + valorUnitario + "' where idBebida=" + id;

        try {
            if (nombre != null || costo != 0 || utilidad != 0 || valorUnitario != 0 ){
                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Bebida Modificada");
                limpiarTabla(tablaBebidas, model); 
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar la bebida: " +e);
        }
    }
    
    public static void eliminar(JTable tablaBebidas, DefaultTableModel model){
        int fila = tablaBebidas.getSelectedRow();
        int id = (int) tablaBebidas.getValueAt(fila, 0);
        String sql = "delete from bebidas where idBebida=" + id;
 
        if(fila<0){
            JOptionPane.showMessageDialog(null,"Selecciona una bebida");
        } else {
            try {
                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Bebida eliminada");
                limpiarTabla(tablaBebidas, model);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar la bebida: " +e);
            }
        }
    }
    
    public static void nuevo(JTextField jTextField1, JTextField jTextField2, JTextField jTextField3){
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField1.requestFocus();
    }
    
    public static void limpiarTabla(JTable tablaBebidas, DefaultTableModel model) {
        model = (DefaultTableModel) tablaBebidas.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }
    
}
