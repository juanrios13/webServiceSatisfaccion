package modelo;
public class SQLHelper {
    
   
    //guardar un registro en tabla
    public String guardarRadicadoSatisfaccion(){
        return "INSERT INTO radicadosatisfaccion (radicado,lvlsatisfaccion,repservicio) VALUES (?,?,?);";
    }
    
    public String buscarPersona(String radicado){
        return "SELECT * FROM radicadodatos WHERE radicado = '"+radicado+"';";
    }
    

}
