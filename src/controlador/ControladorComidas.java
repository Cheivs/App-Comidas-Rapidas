
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.productos.Comidas;

public class ControladorComidas {
    
    static Conexion cn = new Conexion();
    static Connection con;
    static Statement st;
    static ResultSet rs;
    int id = 0;
    
    public static void listar(JTable tablaComidas, DefaultTableModel model){
        String sql = "select * from comidas";
        try {
            con = cn.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            Object[] comida = new Object[6];
            model = (DefaultTableModel) tablaComidas.getModel();
            while (rs.next()) {
                comida[0] = rs.getInt("idComida");
                comida[1] = rs.getString("nombreComida");
                comida[2] = rs.getInt("cantidadIngredientes");
                comida[3] = rs.getInt("costo");
                comida[4] = rs.getInt("utilidad");
                comida[5] = rs.getInt("valorUnitario");
                model.addRow(comida);
            }
            tablaComidas.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar las comidas: " +e);
        }
    }
    
    public static void Agregar(JTable tablaComidas, DefaultTableModel model, JTextField jTextField1, JTextField jTextField2, JTextField jTextField3, JTextField jTextField4){
        Comidas comidax = new Comidas();
        String nombre = jTextField1.getText().trim();
        int cantidadIngredientes = Integer.parseInt(jTextField4.getText().trim());
        int costo = Integer.parseInt(jTextField2.getText().trim());
        int utilidad =Integer.parseInt(jTextField3.getText().trim());
        comidax.setCosto(costo);
        comidax.setUtilidad(utilidad);
        int valorUnitario = comidax.precio();
        
        try {
            if(nombre.isEmpty() || costo==0|| cantidadIngredientes==0 || utilidad ==0){
                JOptionPane.showMessageDialog(null, "Llena todos los datos");
                limpiarTabla(tablaComidas, model);
            } else {
                String sql = "insert into comidas(nombreComida, cantidadIngredientes, costo, utilidad, valorUnitario) VALUES('" + nombre + "','"+ cantidadIngredientes + "','"+ costo + "','"+ utilidad + "','" + valorUnitario +"')";
                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Comida registrada con exito");
                
                limpiarTabla(tablaComidas, model);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar la comida: " +e);
        }
    }
    
    public static void eliminar(JTable tablaComidas, DefaultTableModel model){
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
                limpiarTabla(tablaComidas, model);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar la comida: " +e);
            }
        }
    }
    
    public static void nuevo(JTextField jTextField1, JTextField jTextField2, JTextField jTextField3, JTextField jTextField4){
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField1.requestFocus();
    }
    
    public static void limpiarTabla(JTable tablaComidas, DefaultTableModel model) {
        model = (DefaultTableModel) tablaComidas.getModel();
        while (model.getRowCount() > 0) {
        model.removeRow(0);
        }
    }
    
    public static void modificar(DefaultTableModel model, JTable tablaComidas, JTextField jTextField1, JTextField jTextField2, JTextField jTextField3, JTextField jTextField4){
        Comidas comidax = new Comidas();
        String nombre = jTextField1.getText().trim();
        int cantidadIngredientes = Integer.parseInt(jTextField4.getText().trim());
        int costo = Integer.parseInt(jTextField2.getText().trim());
        int utilidad =Integer.parseInt(jTextField3.getText().trim());
        comidax.setCosto(costo);
        comidax.setUtilidad(utilidad);
        int valorUnitario = comidax.precio();
        
        int fila = tablaComidas.getSelectedRow();
        int id = (int) tablaComidas.getValueAt(fila, 0);
        
        String sql = "update comidas set nombreComida='" + nombre + "', cantidadIngredientes='" + cantidadIngredientes + "', costo='"+ costo + "', utilidad='" + utilidad + "', valorUnitario='" + valorUnitario + "' where idComida=" + id;

        try {
            if (nombre != null || costo != 0 || utilidad != 0 || cantidadIngredientes != 0 || valorUnitario != 0 ){
                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Comida Modificada");
                limpiarTabla(tablaComidas, model);
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar la comida: " +e);
        }
    }
    
}
