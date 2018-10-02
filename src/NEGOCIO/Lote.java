/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

import ACCESODATOS.GestorBD;

/**
 *
 * @author NELCY
 */
public class Lote {
    
    String nombre;
    String ubicacion;
    int nArbolesCafe;
    String fechaSiembra;
    int nArbolesSombra;
    int codigo;
    //<editor-fold defaultstate="collapsed" desc="Constructor Get Set">
    
    public Lote(String nombre, String ubicacion, int nArbolesCafe, String fechaSiembra, int nArbolesSombra) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.nArbolesCafe = nArbolesCafe;
        this.fechaSiembra = fechaSiembra;
        this.nArbolesSombra = nArbolesSombra;
        this.codigo = 0;
    }

    public Lote() {
        this.nombre = "";
        this.ubicacion = "";
        this.nArbolesCafe = 0;
        this.fechaSiembra = "";
        this.nArbolesSombra = 0;
        this.codigo = 0;
    } 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getnArbolesCafe() {
        return nArbolesCafe;
    }

    public void setnArbolesCafe(int nArbolesCafe) {
        this.nArbolesCafe = nArbolesCafe;
    }

    public String getFechaSiembra() {
        return fechaSiembra;
    }

    public void setFechaSiembra(String fechaSiembra) {
        this.fechaSiembra = fechaSiembra;
    }

    public int getnArbolesSombra() {
        return nArbolesSombra;
    }

    public void setnArbolesSombra(int nArbolesSombra) {
        this.nArbolesSombra = nArbolesSombra;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    //</editor-fold>    
    
    //Metodos
    public int registrar()
    {
        String sql = "INSERT INTO LOTE VALUES(SECUENCIA_CODIGO.nextval, '" + nombre + "', '" + ubicacion + "', " + nArbolesCafe + ", '" + fechaSiembra + "', " + nArbolesSombra + ")";
        return GestorBD.ejecutarDML(sql);
    }
    
    public int eliminar()
    {
        String sql = "DELETE FROM LOTE WHERE LOTCODIGO = " + codigo;
        return GestorBD.ejecutarDML(sql);
    }

    public int actualizar(int codigoo)
    {
        String sql = "UPDATE LOTE SET LOTNARBOLESSOMBRA = " + nArbolesSombra+" , LOTNOMBRE = '" + nombre + "', LOTUBICACION = '" + ubicacion + "', LOTNARBOLES = " + nArbolesCafe + ", LOTFECHASIEMBRA = '" + fechaSiembra + "' WHERE LOTCODIGO = "+ codigoo; 
        return GestorBD.ejecutarDML(sql);
    }
     
    
    
}