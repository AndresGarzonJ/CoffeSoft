/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

import ACCESODATOS.GestorBD;
import java.util.ArrayList;
import NEGOCIO.Materiales;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Yeison Caicedo - Andrés Garzón
 */
public class Administrador{
    
        
    //Modificar numero de secuencia
    //select SECUENCIA_COD_EVENTO.nextval from dual;
    //alter sequence SECUENCIA_COD_EVENTO increment by -2;
    
    //select SECUENCIA_CODIGO.nextval from dual;
    //alter sequence SECUENCIA_CODIGO increment by -2;

    //Crear secuencias
    //CREATE sequence SECUENCIA_COD_MATERIALES start with 1
    //increment by 1;

    //CREATE sequence SECUENCIA_COD_EVENTO start with 1
    //increment by 1;
    
    //Eliminar Secuencias
    //drop sequence "ADMINMARCIAL2"."SECUENCIA_CODIGO"

    //<editor-fold defaultstate="collapsed" desc="CRUD LOTE">
    //</editor-fold>
    
    ////////////////////////////////////
    //CRUD EMPLEADO
    ////////////////////////////////////

//////////////////////////////////////

//////////////////////////////////////

    private String nombre;
    private String clave;
    
    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTOR GET SET">
    
    public Administrador() {
        this.nombre = "";
        this.clave = "";
    }
    
    public Administrador(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="SESION">
    
    public ArrayList<Object[]> ingresar(){
        
        String sql= "Select * from administrador where admUsuario = '"+nombre+"' AND admClave = '"+clave+"' ";
        return GestorBD.ejecutarSelect(sql);
    }
    
    
    public int actualizarDatos(String usuarioActual){
        
        String sql = "UPDATE administrador SET admUsuario = '" + nombre +"', admClave = '"+ clave +"' WHERE admUsuario = '"+usuarioActual+"' ";
        return GestorBD.ejecutarDML(sql);
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="CRUD LOTE">
    ////////////////////////////////////
    //CRUD LOTE
    ////////////////////////////////////
    
    public int registrarLote(String nombre, String ubicacion, int nArbolesCafe, String fechaSiembra, int nArbolesSombra)
    {
        Lote miLote = new Lote(nombre, ubicacion, nArbolesCafe, fechaSiembra,nArbolesSombra);
        return miLote.registrar();
    }
    
    public int eliminarLote(int codigo)
    {
        Lote miLote = new Lote();
        miLote.setCodigo(codigo);
        return miLote.eliminar();
    }
    
    public int actualizarLote(String nombres, String ubicacion, int nAC, String fechaS, int nAS, int codigo)
    {
        Lote miLote = new Lote(nombres, ubicacion, nAC, fechaS, nAS);
        return miLote.actualizar(codigo);
    }
    
    public ArrayList<Object[]> listarLotes()
    {
        String sql = "SELECT lo.lotCodigo Codigo, lo.lotNombre Nombre, lo.lotUbicacion Ubicacion, lo.lotNArboles N_Arboles_Cafe , lo.lotFechaSiembra Fecha_Siembra, lo.lotNArbolesSombra N_Arboles_Sombra "
                + "FROM LOTE lo ORDER BY Nombre ASC ";
        return GestorBD.ejecutarSelect(sql);
    }
    public ArrayList<Object[]> buscarLoteCodigoCompleto(int Codigo){
        Lote miLote = new Lote();
        miLote.setCodigo(Codigo);
        String sql= "Select lo.lotCodigo Codigo, lo.lotNombre Nombre, lo.lotUbicacion Ubicacion, lo.lotNArboles #_Arboles_Cafe , lo.lotFechaSiembra Fecha_Siembra, lo.lotNArbolesSombra #_Arboles_Sombra "
                + "FROM LOTE lo where lo.LOTCODIGO =  "+miLote.getCodigo();
        return GestorBD.ejecutarSelect(sql);
    }
    
    public ArrayList<Object[]> buscarEnEventoLoteCod(int Codigo){
        Lote miLote = new Lote();
        miLote.setCodigo(Codigo);
        String sql= "Select lo.lotCodigo Codigo, lo.lotNombre Nombre, lo.lotUbicacion Ubicacion, lo.lotNArboles #_Arboles_Cafe , lo.lotFechaSiembra Fecha_Siembra, lo.lotNArbolesSombra #_Arboles_Sombra "
                + "FROM LOTE lo where lo.LOTCODIGO =  "+miLote.getCodigo();
        return GestorBD.ejecutarSelect(sql);
    }
    
    public ArrayList<Object[]> buscarLotesNombre(String bNombreLote){
        
        String sql= "SELECT lo.lotCodigo Codigo, lo.lotNombre Nombre, lo.lotUbicacion Ubicacion, lo.lotNArboles #_Arboles_Cafe , lo.lotFechaSiembra Fecha_Siembra, lo.lotNArbolesSombra #_Arboles_Sombra "
                + "FROM LOTE lo WHERE lo.lotnombre LIKE  '"+bNombreLote+"%' ORDER BY lotnombre ASC";//ORDER BY empnombre ASC
        return GestorBD.ejecutarSelect(sql);
    }
    
    public ArrayList<Object[]> buscarLotesNombreCompleto(String bNombreLote){
        
        String sql= "SELECT lo.lotCodigo Codigo, lo.lotNombre Nombre, lo.lotUbicacion Ubicacion, lo.lotNArboles #_Arboles_Cafe , lo.lotFechaSiembra Fecha_Siembra, lo.lotNArbolesSombra #_Arboles_Sombra "
                + "FROM LOTE lo WHERE lo.lotnombre =  '"+bNombreLote+"' ORDER BY lotnombre ASC";//ORDER BY empnombre ASC
        return GestorBD.ejecutarSelect(sql);
    }
    
    public ArrayList<Object[]> buscarlotesCodigo(int bCodigo){
        
        String sql = " SELECT lo.lotCodigo Codigo, lo.lotNombre Nombre, lo.lotUbicacion Ubicacion, lo.lotNArboles #_Arboles_Cafe , lo.lotFechaSiembra Fecha_Siembra, lo.lotNArbolesSombra #_Arboles_Sombra "
                + "FROM LOTE lo WHERE lo.LOTCODIGO = "+bCodigo+" ";
        return GestorBD.ejecutarSelect(sql);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="CRUD EMPLEADO">
    
    ////////////////////////////////////
    //CRUD EMPLEADO
    ////////////////////////////////////
    public int registrarEmpleados(long cedula, String nombres, String apellidos, int edad,long telefono)
    {
        Empleado miEmpleado = new Empleado(cedula, nombres, apellidos, edad, telefono);
        return miEmpleado.registrar();
    }
    
    public int eliminarEmpleados(long cedula)
    {
        Empleado miProfesor = new Empleado();
        miProfesor.setCedula(cedula);
        return miProfesor.eliminar();
    }
    public int actualizarEmpleados(long cedula, String nombres, String apellidos, int edad,long telefono)
    {
        Empleado miEmpleado = new Empleado(cedula, nombres, apellidos, edad,telefono);
        return miEmpleado.actualizar();
    }
   
    public ArrayList<Object[]> listarEmpleados()
    {
        String sql = "SELECT em.empCedula Cedula, em.empNombre Nombre, em.empApellidos Apellidos, em.empEdad, em.empTelefono "
                + "FROM Empleado em ORDER BY em.EMPNOMBRE ASC";
        return GestorBD.ejecutarSelect(sql);
    }

    public ArrayList<Object[]> buscarEmpleadosNombre(String bNombre){
        
        String sql= "SELECT em.empCedula Cedula, em.empNombre Nombre, em.empApellidos Apellidos, em.empEdad, em.empTelefono "
                + "FROM Empleado em WHERE em.empnombre LIKE  '"+bNombre+"%' ORDER BY empnombre ASC";//ORDER BY empnombre ASC
        return GestorBD.ejecutarSelect(sql);
    }
    
    public ArrayList<Object[]> buscarEmpleadosCedulaDigitando(long bCedula){
        
        String sql= "SELECT em.empCedula Cedula, em.empNombre Nombre, em.empApellidos Apellidos, em.empEdad, em.empTelefono "
                + "FROM Empleado em WHERE em.empcedula LIKE  '"+bCedula+"%' ORDER BY empnombre ASC";//ORDER BY empnombre ASC
        return GestorBD.ejecutarSelect(sql);
    }
    
    public ArrayList<Object[]> buscarEmpleadosCedula(long bCedula){
        
        String sql = " SELECT em.empCedula Cedula, em.empNombre Nombre, em.empApellidos Apellidos, em.empEdad, em.empTelefono "
                + "FROM Empleado em WHERE em.EMPCEDULA = "+bCedula+" ";
        return GestorBD.ejecutarSelect(sql);
    }
    
    public ArrayList<Object[]> buscarEnEventoEmpleadoCed(long vCedula){
        Empleado miEmpleado = new Empleado();
        miEmpleado.setCedula(vCedula);
        String sql= "Select * from EVENTO where EMPCEDULA =  "+miEmpleado.getCedula();
        return GestorBD.ejecutarSelect(sql);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="CRUD MATERIAL">
       
    public int registrarMaterial(String nombre, String descripcion, long cantidad, double costoUni, String provedor, String marca,String fechaCompra,String tipo, String estado)
    {
        Materiales miMaterial = new Materiales(nombre,descripcion,cantidad,costoUni,provedor,marca,fechaCompra,tipo,estado);
        return miMaterial.registrar();
    }
    
    public int eliminarMaterial(long codigo)
    {
        Materiales miMaterial = new Materiales();
        miMaterial.setCodigo(codigo);
        return miMaterial.eliminar();
    }
       public int actualizarMaterial(long vCodInsumo,String nombre, String descripcion, long cantidad, double costoUni, String provedor, String marca,String fechaCompra,String tipo, String estado)
    {
        Materiales miMaterial = new Materiales(vCodInsumo, nombre,descripcion,cantidad,costoUni,provedor,marca,fechaCompra,tipo,estado);
       return miMaterial.actualizar();
    }
    
   
    public ArrayList<Object[]> listarMateriales()
    {
        String sql = "SELECT ma.matCodigo Codigo, ma.matNombre Nombre, ma.matDescripcion, ma.matProveedor, ma.matFecha Fecha, ma.matTipo Tipo, ma.matEstado Estado, ma.matMarca Marca, ma.matCosto, ma.matCantidad Cantidad "
                + "FROM Materiales ma";
        return GestorBD.ejecutarSelect(sql);
    }
    
    public ArrayList<Object[]> buscarPorTipoyNombre(String bNombre){
        
        String sql= "SELECT ma.matCodigo Codigo, ma.matNombre Nombre, ma.matDescripcion, ma.matProveedor, ma.matFecha Fecha, ma.matTipo Tipo, ma.matEstado Estado, ma.matMarca Marca, ma.matCosto, ma.matCantidad Cantidad"
                + " FROM materiales  WHERE  ma.matnombre LIKE  '"+bNombre+"%' ORDER BY matnombre ASC";//ORDER BY empnombre ASC
        return GestorBD.ejecutarSelect(sql);
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="CRUD EVENTO">

    ////////////////////////////////////
    //CRUD EVENTO
    ////////////////////////////////////
       
    public int registrarEvento(long vEmpCedula, int vLotCodigo, String fecha, String nombre, String descripcion, long costo, long cantidad){
        Evento miEvento = new Evento(fecha, nombre, descripcion, costo, cantidad);
        return miEvento.registrar(vEmpCedula, vLotCodigo);
        
    }
    
    public int eliminarEvento(long codigo)
    {
        Evento miEvento = new Evento();
        miEvento.setCodigo(codigo);
        return miEvento.eliminar();
    }
    
    public int actualizarEvento(long vEmpCedula, int vLotCodigo, long codigoEvento, String fecha, String nombre, String descripcion, long costo, long cantidad){
        
        
        Evento miEvento = new Evento(fecha, nombre, descripcion, costo, cantidad);
        return miEvento.actualizar(vEmpCedula,vLotCodigo, codigoEvento);
    }
    
    
    public ArrayList<Object[]> listarEventos()
    {
        String sql = "SELECT eveCodigo Codigo, empCedula Cedula_Encargado, lotCodigo Codigo_Lote, eveFecha Fecha, eveNombre Nombre, "
                + "eveDescripcion Descripcion, eveCosto Costo, eveCantidad Cantidad FROM EVENTO ev  ORDER BY eveFecha DESC";
        return GestorBD.ejecutarSelect(sql);
    }
    
    public ArrayList<Object[]> buscarEventosActividad(String vActividad)
    {
        String sql = "SELECT eveCodigo Codigo, empCedula Cedula_Encargado, lotCodigo Codigo_Lote, eveFecha Fecha, eveNombre Nombre, "
                + " eveDescripcion Descripcion, eveCosto Costo, eveCantidad Cantidad FROM EVENTO WHERE EVENOMBRE = '"+vActividad+"' ORDER BY eveFecha DESC";
        return GestorBD.ejecutarSelect(sql);
    }
    
    
    //</editor-fold>
    

}