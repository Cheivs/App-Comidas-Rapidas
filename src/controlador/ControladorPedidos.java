
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControladorPedidos {
    
    static Conexion cn = new Conexion();
    static Connection con;
    static Statement st;
    static ResultSet rs;
    int id = 0;
    
    public static void listar(JTable tablaPedidos, DefaultTableModel model){
        String sql = "select * from pedidos";
        try {
            con = cn.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            Object[] comida = new Object[7];
            model = (DefaultTableModel) tablaPedidos.getModel();
            while (rs.next()) {
                comida[0] = rs.getInt("idPedido");
                comida[1] = rs.getString("idCliente");
                comida[2] = rs.getInt("idComida");
                comida[3] = rs.getInt("cantComida");
                comida[4] = rs.getInt("idBebida");
                comida[5] = rs.getInt("cantBebida");
                comida[6] = rs.getString("fechaPedido");
                model.addRow(comida);
            }
            tablaPedidos.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar los pedidos: " +e);
        }
    }
    
    public static void Agregar(JTable tablaPedidos, DefaultTableModel model, JTextField jTextField5, JTextField jTextField6, JTextField jTextField1, JTextField jTextField2, JTextField jTextField4){

        int idCliente = Integer.parseInt(jTextField1.getText().trim());
        int idComida = Integer.parseInt(jTextField4.getText().trim());
        int idBebida = Integer.parseInt(jTextField2.getText().trim());
        int cantComida = Integer.parseInt(jTextField5.getText().trim());
        int cantBebida = Integer.parseInt(jTextField6.getText().trim());
        
        

        try {
            if(idCliente==0 || idComida ==0|| idBebida ==0){
                JOptionPane.showMessageDialog(null, "Llena todos los datos");
                limpiarTabla(tablaPedidos, model);
            } else {
                String sql = "insert into pedidos(idCliente, idComida, cantComida, idBebida, cantBebida) VALUES('" + idCliente + "','"+ idComida + "','" + cantComida + "','" + idBebida + "','" + cantBebida + "')";
                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Pedido registrado con exito");
                
                limpiarTabla(tablaPedidos, model);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el pedido: " +e);
        }
    }
    
    public static void modificar(JTable tablaPedidos, DefaultTableModel model, JTextField jTextField5, JTextField jTextField6, JTextField jTextField1, JTextField jTextField2, JTextField jTextField4){
        
        int idCliente = Integer.parseInt(jTextField1.getText().trim());
        int idComida = Integer.parseInt(jTextField4.getText().trim());
        int idBebida =Integer.parseInt(jTextField2.getText().trim());
        int cantComida = Integer.parseInt(jTextField5.getText().trim());
        int cantBebida = Integer.parseInt(jTextField6.getText().trim());
        
        int fila = tablaPedidos.getSelectedRow();
        int id = (int) tablaPedidos.getValueAt(fila, 0);
        
        String sql = "update pedidos set idCliente='" + idCliente + "', idComida='" + idComida + "', cantComida='" + cantComida + "', idBebida='" + idBebida + "', cantBebida='"+ cantBebida + "' where idPedido=" + id;

        try {
            if (idCliente != 0 || idComida != 0 || idBebida != 0){
                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Pedido Modificado");
                limpiarTabla(tablaPedidos, model);
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el pedido: " +e);
        }
    }
    
    public static void eliminar(JTable tablaPedidos, DefaultTableModel model){
        int fila = tablaPedidos.getSelectedRow();
        int id = (int) tablaPedidos.getValueAt(fila, 0);
        String sql = "delete from pedidos where idPedido=" + id;
 
        if(fila<0){
            JOptionPane.showMessageDialog(null,"Selecciona un pedido");
        } else {
            try {
                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Pedido eliminado");
                limpiarTabla(tablaPedidos, model);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar el pedido: " +e);
            }
        }
    }
    
    public static void nuevo(JTextField jTextField1, JTextField jTextField5, JTextField jTextField6, JTextField jTextField2, JTextField jTextField4){
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField1.requestFocus();
    }
    
    public static void limpiarTabla(JTable tablaPedidos, DefaultTableModel model) {
        model = (DefaultTableModel) tablaPedidos.getModel();
        while (model.getRowCount() > 0) {
        model.removeRow(0);
        }
    }
    
}
