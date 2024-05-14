
package controlador.productos;

public class Bebidas extends Producto {
    //ATRIBUTOS
    
    int idBebida;
    int cantidadPaca=8;
    
    //CONSTRUCTOR

    public Bebidas(int idBebida, int costo, int utilidad, int cantidadPaca, String nombre) {
        super(nombre, costo, utilidad);
        this.cantidadPaca = cantidadPaca;
        this.idBebida = idBebida;
    }

    public Bebidas() {}

    
    public int getIdBebida() {    
        return idBebida;
    }

    //METODOS
    public void setIdBebida(int idBebida) {
        this.idBebida = idBebida;
    }

    public int getCantidadPaca() {
        return cantidadPaca;
    }

    public void setCantidadPaca(int cantidadPaca) {
        this.cantidadPaca = cantidadPaca;
    }
    
    
    @Override
    public int precio(){
        return (this.costo/this.cantidadPaca) + this.utilidad;
    }
    
}
