
package modelo.productos;

public class Comidas extends Producto {
    //ATRIBUTOS
    
    private int idComida;
    private int cantidadIngredientes;
    
    //CONSTRUCTOR
   
    public Comidas(int idComida, int costo, int utilidad, String nombre, int cantidadIngredientes) {
        super(nombre, costo, utilidad);
        this.cantidadIngredientes = cantidadIngredientes;
        this.idComida = idComida;
    }
    
    public Comidas(){}
    
    //METODOS

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    
    public int getCantidadIngredientes() {
        return cantidadIngredientes;
    }

    public void setCantidadIngredientes(int cantidadIngredientes) {
        this.cantidadIngredientes = cantidadIngredientes;
    }

    @Override
    public int precio(){
        return this.costo + this.utilidad;
    }

}
