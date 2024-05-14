
package controlador.personas;

import controlador.personas.Persona;

public class Empleado extends Persona {
    //ATRIBUTOS
    
    private int idEmpleado;
    private String correo;
    private String contraseña;
    
    //CONSTRUCTOR
    public Empleado(int idEmpleado, String nombre, String identificacion, String correo, String contraseña) {
        super(nombre, identificacion);
        this.contraseña = contraseña;
        this.correo = correo;
        this.idEmpleado = idEmpleado;
        
    }
    
    public Empleado (){}
    
    //METODODS

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    
}
