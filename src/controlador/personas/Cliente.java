
package controlador.personas;

import controlador.personas.Persona;

public class Cliente extends Persona {
    //ATRIBUTOS

    private int idCliente;
    private String pedido;
    
    //CONSTRUCTOR
    
    
    public Cliente(int idCliente, String pedido, String nombre, String identificacion) {
        super(nombre, identificacion);
        this.pedido = pedido;
        this.idCliente = idCliente;
    }
    
    public Cliente(){}
    
    //METODOS

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    
    
    public void setPedido(String pedido) {
        this.pedido = pedido;
    }
    
    public String getPedido() {
        return pedido;
    }
    
    
}
