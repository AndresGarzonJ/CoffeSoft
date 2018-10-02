/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;
import ACCESODATOS.GestorBD;
import java.util.ArrayList;
/**
 *
 * @author Viviana
 */
public class Empleado {
    
    private long cedula;
    private String nombres;
    private String apellidos;
    private int edad;
    private long telefono;
    
    //<editor-fold defaultstate="collapsed" desc="Constructor Get Set">
    
    public Empleado() {
        this.cedula = 0;
        this.nombres = "";
        this.apellidos = "";
        this.edad = 0;
        this.telefono = 0;
        
    }
    public Empleado(long cedula, String nombres, String apellidos, int edad,long telefono) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad= edad;
        this.telefono= telefono;
        
    }
     
    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    //</editor-fold>
    
    
    public int registrar()
    {
        String sql = "INSERT INTO Empleado VALUES( " + cedula + ",  '" + nombres + "', '" + apellidos + "'," + edad + ", "+telefono+")";
        return GestorBD.ejecutarDML(sql);
    }
    
    public int eliminar()
    {
        String sql = "DELETE FROM Empleado WHERE empCedula = " + cedula;
        return GestorBD.ejecutarDML(sql);
    }
    public int actualizar()
    {
       String sql = "UPDATE Empleado SET empEdad = " + edad + 
                      ", empNombre = '" + nombres + "', empApellidos = '" + apellidos + "', empTelefono = " + telefono + " WHERE empCedula = " + cedula;
                               
        return GestorBD.ejecutarDML(sql);
    }
    
}