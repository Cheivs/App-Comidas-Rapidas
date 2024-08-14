package controlador;

import conexion.Conexion;
import encriptacion.EncriptarContraseña;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class ControladorEmpleados {

    static Conexion cn = new Conexion();
    static Connection con;
    static Statement st;
    static ResultSet rs;
    int id = 0;

    public static void listar(DefaultTableModel model, JTable tablaEmpleados) {
        String sql = "select * from empleados";
        try {
            con = cn.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            Object[] empleado = new Object[5];
            model = (DefaultTableModel) tablaEmpleados.getModel();
            while (rs.next()) {
                empleado[0] = rs.getInt("idEmpleado");
                empleado[1] = rs.getString("nombreEmpleado");
                empleado[2] = rs.getString("cedulaEmpleado");
                empleado[3] = rs.getString("idTipoUsuario");
                empleado[4] = rs.getString("correoEmpleado");
                model.addRow(empleado);
            }
            tablaEmpleados.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar los empleados: " + e);
        }
    }

    public static void limpiarTabla(JTable tablaEmpleados, DefaultTableModel model) {
        model = (DefaultTableModel) tablaEmpleados.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    public static void Agregar(JTable tablaEmpleados, DefaultTableModel model, JTextField jTextField4, JTextField jTextField1, JTextField jTextField2, JTextField jTextField3, JPasswordField jPasswordField1) {

        String nombre = jTextField1.getText().trim();
        String cedula = jTextField2.getText().trim();
        String correo = jTextField3.getText().trim();

        int idTipoUsuario = Integer.parseInt(jTextField4.getText().trim());

        String contraseña = jPasswordField1.getText().trim();

      
        try {
            if (nombre.isEmpty() || idTipoUsuario != 1 || idTipoUsuario != 2 || jTextField4.getText().trim().isEmpty() || cedula.isEmpty() || correo.isEmpty() || contraseña.isEmpty()) {

                if (idTipoUsuario != 1 || idTipoUsuario != 2) {
                    JOptionPane.showMessageDialog(null, "Para el tipo de usuario digita 1 para Administrador y 2 para Usuario normal");
                }
                JOptionPane.showMessageDialog(null, "Llena todos los datos");
                limpiarTabla(tablaEmpleados, model);
            } else {

                //ENCRIPTAR CONTRASEÑA
                EncriptarContraseña encriptar = new EncriptarContraseña();
                String contraEncriptada = encriptar.getMd5Hash(contraseña);

                String sql = "insert into empleados(nombreEmpleado, cedulaEmpleado, idTipoUsuario, correoEmpleado, contraseña) VALUES('" + nombre + "','" + cedula + "','" + idTipoUsuario + "','" + correo + "','" + contraEncriptada + "')";
                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Empleado registrado con exito");

                limpiarTabla(tablaEmpleados, model);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el empleado: " + e);
        }
    }

    public static void modificar(DefaultTableModel model, JTable tablaEmpleados, JTextField jTextField4, JTextField jTextField1, JTextField jTextField2, JTextField jTextField3, JPasswordField jPasswordField1) {
        String nombre = jTextField1.getText().trim();
        String cedula = jTextField2.getText().trim();
        int idTipoUsuario = Integer.parseInt(jTextField4.getText().trim());
        String correo = jTextField3.getText().trim();
        String contraseña = jPasswordField1.getText().trim();

        EncriptarContraseña encriptar = new EncriptarContraseña();
        String contraEncriptada = encriptar.getMd5Hash(contraseña);

        int fila = tablaEmpleados.getSelectedRow();
        int id = (int) tablaEmpleados.getValueAt(fila, 0);

        String sql = "update empleados set nombreEmpleado='" + nombre + "', cedulaEmpleado='" + cedula + "', idTipoUsuario='" + idTipoUsuario + "', correoEmpleado='" + correo + "', contraseña='" + contraEncriptada + "' where idEmpleado=" + id;

        try {

            if (nombre != null || idTipoUsuario != 0 || cedula != null || correo != null || contraseña != null) {

                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Empleado Modificado");
                limpiarTabla(tablaEmpleados, model);
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el empleado: " + e);
        }
    }

    public static void eliminar(JTable tablaEmpleados, DefaultTableModel model) {
        int fila = tablaEmpleados.getSelectedRow();
        int id = (int) tablaEmpleados.getValueAt(fila, 0);
        String sql = "delete from empleados where idEmpleado=" + id;

        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Selecciona un empleado");
        } else {
            try {
                con = cn.getConnection();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Empleado eliminado");
                limpiarTabla(tablaEmpleados, model);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar el empleado: " + e);
            }
        }
    }

    public static void nuevo(JTextField jTextField1, JTextField jTextField4, JTextField jTextField2, JTextField jTextField3, JPasswordField jPasswordField1) {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jPasswordField1.setText("");
        jTextField1.requestFocus();
    }

}
