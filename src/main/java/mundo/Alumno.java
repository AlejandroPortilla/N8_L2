
package mundo;

public class Alumno {
    private String nombre;
    private String apellido;
    private String semestre;
    private String correo;
    private String telefono;
    private String cedula;
    
public Alumno(){
    
}    

public Alumno(String nombre, String apellido,String semestre, String correo, String telefono, String cedula ){
    this.nombre   = nombre;
    this.apellido = apellido;
    this.semestre = semestre;
    this.correo   = correo;
    this.telefono = telefono;
    this.cedula   = cedula;
   
    
}
public String getNombre(){
    return nombre;
}
public void setNombre(String nombre){
    this.nombre =nombre;
}

public String getApellido(){
    return apellido;
}
public void setApellido(String apellido){
    this.apellido =apellido;
}

public String getSemestre(){
    return semestre;
}
public void setSemestre(String semestre){
    this.semestre =semestre;
}
public String getCorreo(){
    return correo;
}
public void setCorreo(String correo){
    this.correo =correo;
}
public String getTelefono(){
    return telefono;
}
public void setTelefono(String telefono){
    this.telefono = telefono;
}
public String getCedula(){
    return cedula;
}
public void setCedula(String cedula){
    this.cedula =cedula;
}


}
