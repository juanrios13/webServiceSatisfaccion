package modelo;

import utilidades.*;
import java.sql.*;

public class DAO {
    ConexionBD con=new ConexionBD();
    Cliente client=new Cliente();
    SQLHelper sql=new SQLHelper();
    
    //buscar 1 persona en BD
    public Cliente buscarRadicado(String documento){
        try {
            
            PreparedStatement stm= con.getCon().prepareStatement(sql.buscarPersona(documento));
            ResultSet rs=stm.executeQuery();
            
            while(rs.next()){
                client.setRadicado(rs.getString(1));
                client.setCedula(rs.getString(2));
                client.setCorreo(rs.getString(3));
                client.setNombre(rs.getString(4));
                client.setDependencia(rs.getString(5));
                
                System.out.println("Encontró la persona");
                return client;
            }
            
        } catch (Exception e) {
            System.err.println("Error al buscar registro: "+e.getMessage());
        }finally{
            try {
                con.cerrarBD();
            } catch (Exception e) {
            }
        }
        return null;
    }//cierro buscar 1 persona  

    //metodo guardar 1 registro en bd
    public String registrarRadicado(Cliente client){
        try {
            
             PreparedStatement stm= con.getCon().prepareStatement(sql.guardarRadicadoSatisfaccion());
             
             stm.setString(1, client.getRadicado());
             stm.setString(2, client.getLvlSatisfaccion());
             stm.setString(3, client.getRepServicio());
            
             stm.execute();
             System.out.println("Registro exitoso");
             return "Envio exitoso" ;
             
        } catch (Exception e) {
            System.err.println("Error al guardar registro: "+e.getMessage());
        }finally{
            try {
                con.cerrarBD();
            } catch (Exception e) {
            }
        }
        return "Hubo un error, intente mas tarde";
    }//cerrar guardar
    
    
}
