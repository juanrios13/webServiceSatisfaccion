package utilidades;
import java.sql.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
    Connection con;
    
    public ConexionBD(){}
    
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException e1) {
            System.err.println("ClassNotFoundException"+e1.getMessage());
        } catch (InstantiationException e2) {
            System.err.println("InstantiationException"+e2.getMessage());
        } catch (IllegalAccessException e3) {
            System.err.println("IllegalAccessException"+e3.getMessage());
        }catch(Exception e){
            System.err.println(e.getMessage());   
        }
    }//cierre static
    
    public Connection getCon(){
        conectarBD();
        return con;
    }
    public void setCon(Connection con){
        this.con=con;
    }
    public String conectarBD(){
        String url="jdbc:mysql://localhost:3306/usuariosalcaldia";
        String user="root";
        String password="";
        
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            setCon(DriverManager.getConnection(url,user,password));                        
            return ("Conexión con la base de datos "+url+" Exitosa");
        
        } catch (Exception e) {
            return ("Error en la conexión "+e.getMessage());
        }
        
        
    }//cierra conectarBD() no tocar
    
    public void cerrarBD () throws SQLException{
        con.close();
    }
    
    public static void main(String[] args) throws SQLException{
        ConexionBD c=new ConexionBD();
        
        try {
           /* ResultSet r=c.getCon().prepareStatement("SELECT * FROM usuarios").executeQuery();
            
            
           while(r.next()){
                
                System.out.println("Documento: "+r.getString(1));
                System.out.println("Nombre: "+r.getString(2));
                System.out.println("Apellido1: "+r.getString(3));
                System.out.println("Correo: "+r.getString(6));
                
           
            }
            
             if(!r.next()){
                System.err.println("No hay más datos en la tabla");
            }
             */
             
        } catch (Exception e) {
            System.err.println("Excepción: "+e.getMessage());
            
        }finally{
            try {
                c.cerrarBD();
            } catch (Exception e) {
                
            }
        }
        
    }
    
    
    
    
    
    
}//cierre clase ConexionBD
