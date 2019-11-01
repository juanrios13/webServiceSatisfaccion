
package modelo;

public class Cliente {
    String radicado,cedula,nombre,correo,dependencia;
    String lvlSatisfaccion,repServicio;
    
    
    
    //Creamos los getter y los setter

    public String getRadicado() {
        return radicado;
    }

    public void setRadicado(String radicado) {
        this.radicado = radicado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

        //Getters and setters para guardar

    public String getLvlSatisfaccion() {
        return lvlSatisfaccion;
    }

    public void setLvlSatisfaccion(String lvlSatisfaccion) {
        this.lvlSatisfaccion = lvlSatisfaccion;
    }

    public String getRepServicio() {
        return repServicio;
    }

    public void setRepServicio(String repServicio) {
        this.repServicio = repServicio;
    }

        
    
    
}
