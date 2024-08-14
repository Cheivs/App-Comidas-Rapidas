    package controlador;

import conexion.Conexion;
import encriptacion.EncriptarContraseña;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import vista.Inicio;

public class ControladorInicioSesion {

    public static int rolUsuario;
    public static int idEmpleado;
    
    static Conexion cn = new Conexion();
    static Connection con;
    static Statement st;
    static ResultSet rs;
    
    

    public static void IniciarSesion(JTextField jTextField1, JPasswordField jPasswordField1) {
        String correo = jTextField1.getText().trim();
        String contraseña = jPasswordField1.getText().trim();
        

        if (correo.isEmpty() || contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llena todos los campos");
        } else {

            EncriptarContraseña encriptar = new EncriptarContraseña();
            String contraEncriptada = encriptar.getMd5Hash(contraseña);

            try {
                con = cn.getConnection();
                st = con.createStatement();
                rs = st.executeQuery("SELECT * FROM empleados WHERE correoEmpleado='" + correo + "' AND contraseña='" + contraEncriptada + "'");

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Bienvenido " + rs.getString("nombreEmpleado"));
                    rolUsuario = rs.getInt("idTipoUsuario");
                    idEmpleado = rs.getInt("idEmpleado");
                    new Inicio().setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Datos incorrectos");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al iniciar sesion: " + e);
            }
        }
    }

}
