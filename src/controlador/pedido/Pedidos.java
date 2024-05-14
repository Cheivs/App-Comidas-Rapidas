
package controlador.pedido;

import java.time.LocalDate;

public class Pedidos {
    //ATRIBUTOS
    
    private int idPedido;
    private int idCliente;
    private int idEmpleado;
    private LocalDate fecha;
    
    //CONSTRUCTOR
    
    public Pedidos(int idPedido, int idCliente, int idEmpleado, LocalDate fecha) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.fecha = fecha;
    }
    
    public Pedidos(){}
    
    //METODOS

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    
    
}
