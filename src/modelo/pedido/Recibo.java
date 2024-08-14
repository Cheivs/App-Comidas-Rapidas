
package modelo.pedido;

public class Recibo {
    
    //ATRIBUTOS
    private int idRecibo;
    private int idEmpleado;

    //CONSTRUCTOR
    public Recibo(int idRecibo, int idEmpleado) {
        this.idRecibo = idRecibo;
        this.idEmpleado = idEmpleado;
    }

    //METODOS
    public int getIdRecibo() {
        return idRecibo;
    }

    public void setIdRecibo(int idRecibo) {
        this.idRecibo = idRecibo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    
}
