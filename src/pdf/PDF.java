package pdf;

import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.Conexion;
import static controlador.ControladorInicioSesion.idEmpleado;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PDF {

    static Conexion cn = new Conexion();
    static Connection con;
    static Statement st;
    static ResultSet rs;

    public static void imprimirRecibo(JTable tablaPedidos, JTextField jTextField1, JTextField jTextField2, JTextField jTextField4) throws SQLException {

        con = cn.getConnection();
        st = con.createStatement();

        int fila = tablaPedidos.getSelectedRow();
        int idPedido = (int) tablaPedidos.getValueAt(fila, 0);

        String sqlPedidos = "SELECT * FROM pedidos WHERE idPedido=" + idPedido;

        rs = st.executeQuery(sqlPedidos);
        rs.next();
        int cantComida = rs.getInt("cantComida");
        int cantBebida = rs.getInt("cantBebida");
        int idCliente = rs.getInt("idCliente");
        int idComida = rs.getInt("idComida");
        int idBebida = rs.getInt("idBebida");

        String sqlClientes = "SELECT nombreCliente, cedulaCliente, telefonoCliente FROM clientes WHERE idCliente=" + idCliente;

        String sqlComidas = "SELECT nombreComida, valorUnitario FROM comidas WHERE idComida=" + idComida;

        String sqlBebidas = "SELECT nombreBebida, valorUnitario FROM bebidas WHERE idBebida=" + idBebida;
        
        String sqlEmpleados = "SELECT * FROM empleados WHERE idEmpleado=" + idEmpleado;

        try {
            if (jTextField1.getText().trim().isEmpty() || jTextField2.getText().trim().isEmpty() || jTextField4.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Asegurate de registrar todos los datos");
            } else {

                Date fecha = rs.getDate("fechaPedido");

                rs = st.executeQuery(sqlClientes);
                rs.next();

                String nombreCliente = rs.getString("nombreCliente");
                String cedulaCliente = rs.getString("cedulaCliente");
                String telefonoCliente = rs.getString("telefonoCliente");

                rs = st.executeQuery(sqlComidas);
                rs.next();

                String nombreComida = rs.getString("nombreComida");
                int valorUnitarioComida = rs.getInt("valorUnitario");

                rs = st.executeQuery(sqlBebidas);
                rs.next();

                String nombreBebida = rs.getString("nombreBebida");
                int valorUnitarioBebida = rs.getInt("valorUnitario");

                int subTotalComida = valorUnitarioComida * cantComida;
                int subTotalBebida = valorUnitarioBebida * cantBebida;
                
                rs = st.executeQuery(sqlEmpleados);
                rs.next();
                
                String nombreEmpleado = rs.getString("nombreEmpleado");
                String cedulaEmpleado = rs.getString("cedulaEmpleado");

                Document document = new Document();
                String destino = "recibo.pdf";
                PdfWriter.getInstance(document, new FileOutputStream(destino));

                document.open(); //INICIO DEL DOCUMENTO

                document.add(new Paragraph("JUANCHO'S COMIDAS RAPIDAS"));
                document.add(new Paragraph("Recibo del pedido"));
                document.add(new Paragraph("--------------------------------------------------------"));

                document.add(new Paragraph("Cliente: " + nombreCliente));
                document.add(new Paragraph("Cedula: " + cedulaCliente));
                document.add(new Paragraph("Telefono: " + telefonoCliente));
                document.add(new Paragraph(" "));
                
                document.add(new Paragraph("Empleado: " + nombreEmpleado));
                document.add(new Paragraph("Cedula: " + cedulaEmpleado));
                document.add(new Paragraph(" "));
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                

                document.add(new Paragraph("Numero de pedido: " + idPedido));
                document.add(new Paragraph("Fecha del pedido: " + fecha));
                document.add(new Paragraph(" "));

                //INICIO DE LA TABLA
                PdfPTable table = new PdfPTable(4); //Cantidad de celdas

                float[] medidaCeldas = {0.5f, 0.2f, 0.2f, 0.2f}; //Ajustar las medidas de las celdas
                table.setWidths(medidaCeldas);
                table.setWidthPercentage(50); // Ajustar el ancho al 50% de la página
                table.setHorizontalAlignment(Element.ALIGN_LEFT); // Alinear hacia la izquierda

                Font fontNegrita = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);

                PdfPCell celdaInicial = new PdfPCell(new Paragraph("DESCRIPCION", fontNegrita));
                celdaInicial.setColspan(4);
                celdaInicial.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(celdaInicial);

                table.addCell(new Paragraph("Nombre Producto", fontNegrita));
                table.addCell(new Paragraph("Cantidad", fontNegrita));
                table.addCell(new Paragraph("Valor Unitario", fontNegrita));
                table.addCell(new Paragraph("Subtotal", fontNegrita));

                PdfPCell celdaComida = new PdfPCell(new Paragraph("Comidas Pedidas", fontNegrita));
                celdaComida.setColspan(4);
                table.addCell(celdaComida);
                
                table.addCell(nombreComida);
                table.addCell(Integer.toString(cantComida));
                table.addCell(Integer.toString(valorUnitarioComida));
                table.addCell(Integer.toString(subTotalComida));

                PdfPCell celdaBebida = new PdfPCell(new Paragraph("Bebidas Pedidas", fontNegrita));
                celdaBebida.setColspan(4);
                table.addCell(celdaBebida);
                
                table.addCell(nombreBebida);
                table.addCell(Integer.toString(cantBebida));
                table.addCell(Integer.toString(valorUnitarioBebida));
                table.addCell(Integer.toString(subTotalBebida));

                PdfPCell celdaFinal = new PdfPCell(new Paragraph("Monto total: " + (subTotalComida + subTotalBebida)));
                celdaFinal.setColspan(4);
                table.addCell(celdaFinal);

                document.add(table);

                //FINAL DE LA TABLA
                document.add(new Paragraph(" "));

                document.add(new Paragraph("Gracias por su compra."));

                document.close(); //FINAL DEL DOCUMENTO
                
                abrirPDF(destino);

                JOptionPane.showMessageDialog(null, "Recibo en PDF creado correctamente");

            }

        } catch (FileNotFoundException | DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear el recibo: " + ex);
        }
    }

    private static void abrirPDF(String rutaPDF) {
        if (Desktop.isDesktopSupported()) {
            try {
                File file = new File(rutaPDF);
                Desktop.getDesktop().open(file);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al abrir el archivo PDF: " + ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "La apertura automática de archivos no es compatible con este sistema.");
        }
    }
}
