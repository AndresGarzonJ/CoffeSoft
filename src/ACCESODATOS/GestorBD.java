/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACCESODATOS;
import java.util.*;
import java.sql.*;
/**
 *
 * @author Yeison-Andres
 */
public class GestorBD {
    static Connection miConexion;
    static Statement miSt;
    static ResultSet miRs;
    static Connection miCon2;
   
    
    public static void conectar()
    {
        try{
           miConexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "COFFESOFT", "nelcy");
           miSt = miConexion.createStatement();            
        }
        catch(SQLException e)
        {
            System.out.println("Error al abrir conexión -> " + e.getMessage());
        }        
    }
    
    public static Connection conectar2()
    {
        try{
           miConexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "COFFESOFT", "nelcy");
           miSt = miConexion.createStatement();   
           return miConexion;
        }
        catch(SQLException e)
        {
            System.out.println("Error al abrir conexión -> " + e.getMessage());
        } 
        return miConexion;
    }
    
    public static void desconectar()
    {
        try{
            miConexion.close();
        }
        catch(SQLException e)
        {
            System.out.println("Error al cerrar conexión -> " + e.getMessage());
        }        
    }
    
    public static int ejecutarDML(String sql)
    {
        try{
            conectar();
            int res = miSt.executeUpdate(sql);
            desconectar();
            return res;
        }
        catch(SQLException e)
        {
            System.out.println("Error al ejecutar DML -> " + e.getMessage());
            return 0;
        } 
    }
    
    public static ArrayList<Object[]> ejecutarSelect(String sql)
    {
        try{
            conectar();
            ArrayList<Object[]> registros = new ArrayList<>();
            int numCols;
            miRs = miSt.executeQuery(sql);
            
            numCols = miRs.getMetaData().getColumnCount();
            
            //Obtener los nombres de las columnas que trae la consulta
            Object[] columnas = new Object[numCols];
            for(int i=0; i<numCols; i++)
                columnas[i] = miRs.getMetaData().getColumnLabel(i+1);
            registros.add(columnas);
            
            //Armar vectores de registros
            while(miRs.next())
            {
                Object[] registro = new Object[numCols];
                for(int i=0; i<numCols; i++)
                    registro[i] = miRs.getObject(i+1);
                registros.add(registro);
            }
            
            desconectar();
            return registros;
        }
        catch(SQLException e)
        {
            System.out.println("Error al ejecutar DML -> " + e.getMessage());
            return null;
        } 
    }
}
