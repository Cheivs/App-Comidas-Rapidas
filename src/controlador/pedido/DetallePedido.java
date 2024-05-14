
package controlador.pedido;

public class DetallePedido {
    //ATRIBUTOS
    
    private int idDetallePedido;
    private int idProducto;
    private int cantidad;
    private int subtotal;
    private int valorFinal;
    
    //CONSTRUCTOR
    
    public DetallePedido(int idDetallePedido, int idProducto, int cantidad, int subtotal, int valorFinal) {
        this.idDetallePedido = idDetallePedido;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.valorFinal = valorFinal;
    }
    
    public DetallePedido(){}
    
    //METODOS

    public int getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(int idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(int valorFinal) {
        this.valorFinal = valorFinal;
    }

    
    
}
