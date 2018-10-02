/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

import ACCESODATOS.GestorBD;

/**
 *
 * @author SGTheDreamer
 */
public class Evento {
    
    long codigo;
    String fecha;
    String nombre;
    String descripcion;
    long costo;
    long cantidad;
    
    
    //<editor-fold defaultstate="collapsed" desc="Constructores & Get Set">
    public Evento( String fecha, String nombre, String descripcion, long costo, long cantidad) {
        this.codigo = 0;
        this.fecha = fecha;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.cantidad = cantidad;
    }
    
    public Evento() {
        this.codigo = 0;
        this.fecha = "";
        this.nombre = "";
        this.descripcion = "";
        this.costo = 0;
        this.cantidad = 0;
    }
    
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getCosto() {
        return costo;
    }

    public void setCosto(long costo) {
        this.costo = costo;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }
    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc="Metodos">
    
    public int registrar(long empCedula, int lotCodigo)
    {   //res = 2 ...Es por que falta empleado
        //res = 3 ...Es por que falta lote 
        //res = 4... No se registro
        if ( empCedula != 0){
            if (lotCodigo != 0){
                String sql = "INSERT INTO EVENTO VALUES(SECUENCIA_COD_EVENTO.nextval, "+empCedula+", "+lotCodigo+",  '"+fecha+"',  '"+nombre+"',  '"+descripcion+"',  "+costo+", "+cantidad+")";
                return GestorBD.ejecutarDML(sql);
            }
            if (lotCodigo == 0)
                return 3;
            return 4;
        }else
            return 2;
        
        
    }
    
    public int eliminar()
    {
        String sql = "DELETE FROM EVENTO WHERE EVECODIGO = " + codigo;
        return GestorBD.ejecutarDML(sql);
    }
    
    public int actualizar(long vEmpCedula, int vLotCodigo, long codigoEvento)
    {
        String sql = "UPDATE EVENTO SET EVECANTIDAD = "+ cantidad+" , EMPCEDULA =  "+vEmpCedula+", LOTCODIGO  = "+vLotCodigo+", EVEFECHA = '"+fecha+"', EVENOMBRE = '"+nombre+"', EVEDESCRIPCION = '"+descripcion+"', EVECOSTO = "+costo+"  WHERE EVECODIGO = "+ codigoEvento;   
        return GestorBD.ejecutarDML(sql);
    }
    
    
    
    //</editor-fold>
    
}