
package modelo.personas;

import modelo.personas.Persona;

public class Empleado extends Persona {
    //ATRIBUTOS
    
    private int idEmpleado;
    private String correo;
    private String contraseña;
    private String rol;
    
    //CONSTRUCTOR
    public Empleado(int idEmpleado, String rol, String nombre, String identificacion, String correo, String contraseña) {
        super(nombre, identificacion);
        this.contraseña = contraseña;
        this.correo = correo;
        this.idEmpleado = idEmpleado;
        this.rol = rol;
        
    }
    
    public Empleado (){}
    
    //METODODS

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    

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
