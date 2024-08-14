
package modelo.pedido;

public class DetalleRecibo {
    
    //ATRIBUTOS
    private int idDetallePedido;
    private int idPedido;

    //CONSTRUCTOR
    public DetalleRecibo(int idPedido, int idDetallePedido) {
        this.idPedido = idPedido;
        this.idDetallePedido = idDetallePedido;
    }

    //METODOS
    public int getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(int idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }
    
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    
    
}
