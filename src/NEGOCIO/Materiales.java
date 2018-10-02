
package NEGOCIO;

import ACCESODATOS.GestorBD;
import java.util.ArrayList;

/**
 *
 * @author Yeison Caicedo - Andrés Garzón
 */
public class Materiales {
    
    // Inicio Variables Materiales
    
    private String nombre;
    private String tipo;
    private String descripcion;
    private long cantidad;
    private double costoUni;
    private String fechaCompra;
   
    private String estado;
    private String provedor;
    private String marca;
    private double total;
    private long codigo;
    
    // Fin Variables Materiales
    public Materiales (){
        this.nombre = "";
        this.tipo = "";
        this.descripcion = "";
        this.cantidad = 0;
        this.costoUni = 0;
        this.fechaCompra = "";
        
        this.estado = "";
        this.provedor = "";
        this.marca = "";
        this.total = 0;
        
    
    }
    
 // Constructor Materiales
    public Materiales(String nombre, String descripcion, long cantidad, double costoUni, String provedor, String marca,String fechaCompra,String tipo, String estado) {
        
        this.nombre = nombre;
       
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.costoUni = costoUni;
        this.fechaCompra = fechaCompra;
        
        this.estado = estado;
        this.provedor = provedor;
        this.marca = marca;
        this.total = total;
        
    }
    public Materiales(long vCodInsumo ,String nombre, String descripcion, long cantidad, double costoUni, String provedor, String marca,String fechaCompra,String tipo, String estado) {
        
        this.nombre = nombre;
       
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.costoUni = costoUni;
        this.fechaCompra = fechaCompra;
        
        this.estado = estado;
        this.provedor = provedor;
        this.marca = marca;
        this.total = total;
        this.codigo = vCodInsumo;
        
    }
// Fin constructor Materiales

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCostoUni() {
        return costoUni;
    }

    public void setCostoUni(double costoUni) {
        this.costoUni = costoUni;
    }

    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getProvedor() {
        return provedor;
    }

    public void setProvedor(String provedor) {
        this.provedor = provedor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    // Métodos para modificar las tablas en la base de datos
     public int registrar()
    {
        String sql = "INSERT INTO Materiales VALUES(SECUENCIA_COD_MATERIALES.nextval, '" + nombre + "' ,'" + descripcion + "','" + provedor  + "','" + fechaCompra  + "','" + tipo  + "','" + estado  + "','" + marca  + "', " + costoUni + ","+cantidad+" )";
        return GestorBD.ejecutarDML(sql);
    }
    
    public int eliminar()
    {
        String sql = "DELETE FROM Materiales WHERE matCodigo = " + codigo;
        return GestorBD.ejecutarDML(sql);
    }
    public int actualizar()
    {
         String sql = "UPDATE Materiales SET  matNombre = '" + nombre + "',  matDescripcion = '" + descripcion +  "',matCantidad = " + cantidad +  ",matCosto = " + costoUni +  ",matProveedor= '" + provedor +  "',matMarca = '" + marca +  "',matFecha = '" + fechaCompra +  "',matTipo = '" + tipo +  "',matEstado = '" + estado +  "' WHERE matCodigo = " + codigo;
        return GestorBD.ejecutarDML(sql);
    }
    
}
