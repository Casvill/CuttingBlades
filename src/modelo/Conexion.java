// Para buscar rápido esta clase contiene:
//borrar

package modelo;

import java.sql.*;
import javax.swing.JOptionPane;

//jdbc:postgresql://localhost:5432/CuttingBladesDB

public class Conexion {
    
    private String url;
    private String user;
    private String pass;
    
    
    private Connection conexion;
    private java.sql.Statement st;
    private ResultSet result;
    
    //--------------------------------------------------------------------------//borrar
    //Este constructor es temporal, sólo lo usaré mientras tanto para no tener que estar escribiendo 
    //la url, el usuario y la contraseña en otra parte, así sólo llamo este para pruebas y listo.
    public Conexion()
    { 
        url = "jdbc:postgresql://localhost:5432/CuttingBladesDB";
        user= "postgres";
        pass= "new3r4";

        
        try
        {
            Class.forName("org.postgresql.Driver");
            //conexion = DriverManager.getConnection(url,user,pass);
        }catch(ClassNotFoundException error)
        {
            JOptionPane.showMessageDialog(null, "Error al tratar de conectar con la base de datos:\n"+error.getMessage());
        }
    }
    //Fin constructor sin parámetros------------------------------------------------------------//fin borrar
    
    /******************************************************************************************************/
    
    //El constructor (sólo conecta el programa con la base de datos):-----------------------------------
    //Deberá proveerse la url de donde se encuentra alojada la base de datos, el usuario y la contraseña.
    public Conexion(String url, String user, String pass)
    { 
        this.url=url;
        this.user=user;
        this.pass=pass;
        
        try
        {
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException error)
        {
            JOptionPane.showMessageDialog(null, "Error al tratar de conectar con la base de datos:\n"+error.getMessage());
        }
    }
    //Fin constructor con parámetros-------------------------------------------------------------------------
    
    /******************************************************************************************************/
    
    //Método para enviar una query que no retorna nada al servidor:--------------------------------------
    //retorna true si pudo ejecutar la query / false si ocurre algún error
    public boolean ejecutarQuery(String query)
    {
        try 
        {
            st= conexion.createStatement();
            st.execute(query);
            return true;
        }catch (SQLException | NullPointerException error) 
        {
            JOptionPane.showMessageDialog(null, "Error al tratar de ejecutar la query:\n"+error.getMessage());
            return false;
        }
    }
    //Fin ejecutarQuery()---------------------------------------------------------------------------------
    
    /******************************************************************************************************/
    
    //Método para enviar una query que retorna algo:-----------------------------------------------------
    public ResultSet ejecutarQueryResult(String query)
    { 
        int i=0;
        try 
        {
            st= conexion.createStatement();
            result = st.executeQuery(query);
      
        }catch (SQLException | NullPointerException error) 
        {
            JOptionPane.showMessageDialog(null, "Error al tratar de ejecutar la query:\n"+error.getMessage());
        }
        
        return result;
    }
    //Fin ejecutarQueryResult()---------------------------------------------------------------------------
    
    /******************************************************************************************************/
    
    //Método para establecer la conexión con la base de datos:--------------------------------------------
    public void abrirConexion()
    {
        try 
        {
            conexion = DriverManager.getConnection(url,user,pass);
        } catch (SQLException error) 
        {
            JOptionPane.showMessageDialog(null, "Error al tratar de establecer la conexión:\n"+error.getMessage());
        }
    }
    //Fin abrirConexion()-------------------------------------------------------------------------------------
    
    /******************************************************************************************************/
    
    //Método para cerrar la conexión con la base de datos:------------------------------------------------------
    public void cerrarConexion()
    {
        try
        {
            conexion.close();
            st.close();
            result.close();
        }catch(SQLException | NullPointerException error)
        {
            //JOptionPane.showMessageDialog(null, "Error al tratar de cerrar la conexión:\n"+error.getMessage());
        }
    }
    //Fin cerrarConexion()---------------------------------------------------------------------------------------
}
