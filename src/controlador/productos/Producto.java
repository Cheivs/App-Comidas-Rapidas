
package controlador.productos;


public abstract class Producto {
    //ATRIBUTOS
    
    protected String nombre;
    protected int costo;
    protected int utilidad;
    
    
    //CONSTRUCTOR
    
    public Producto(String nombre, int costo, int utilidad) {
        this.nombre = nombre;
        this.costo = costo;
        this.utilidad = utilidad;
    }
    
    public Producto(){}
    
    //METODOS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(int utilidad) {
        this.utilidad = utilidad;
    }
    
    
    
    //METODO ABSTRACTO
    public abstract int precio();
    
}
