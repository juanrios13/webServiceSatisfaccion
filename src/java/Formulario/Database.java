/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.Cliente;
import modelo.DAO;

/**
 *
 * @author jergf
 */
@WebService(serviceName = "Database")
public class Database {

    /**
     * 
     * @param  radicado
     * @param lvlSatisfaccion
     * @param repServicio 
     * @return String
     */
    @WebMethod(operationName = "create")
    public String create(@WebParam(name = "radicado") String radicado, @WebParam(name = "lvlSatisfaccion") String lvlSatisfaccion , 
            @WebParam(name = "repServicio") String repServicio) {
        
        //cliente clase pojo 
        
        Cliente cli=new Cliente();
        cli.setRadicado(radicado);
        cli.setLvlSatisfaccion(lvlSatisfaccion);
        cli.setRepServicio(repServicio);
        
        //dao clase para interpretacion de sql
        
        DAO client=new DAO();
        return  client.registrarRadicado(cli);
  
    }   
    
    @WebMethod(operationName = "read")
    public String[] read(@WebParam(name = "radicado") String radicado) {
        
        DAO client=new DAO();
        Cliente cli=client.buscarRadicado(radicado);
        
        String[] cliente={cli.getRadicado(),cli.getCedula(),cli.getCorreo(),cli.getNombre(),cli.getDependencia()};
        
        return cliente;
    }
    
    /*
    @WebMethod(operationName = "update")
    public String update(@WebParam(name = "correo") String correo , @WebParam(name = "vcambio") String vcambio , @WebParam(name = "valorCambio") String valorCambio) {
        return "UPDATE"+ vcambio + "=" +valorCambio +" WHERE correo="+correo;
    }
    
    @WebMethod(operationName = "delete")
    public String delete(@WebParam(name = "correo") String correo) {
        return "DELETE WHERE correo="+correo;
    }*/



}
