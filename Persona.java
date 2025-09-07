import java.util.List;

public class Persona{
    
    private String nombre;
    private String apellido_Materno;
    private String apellido_Paterno;
    private String direcciones;
    private String telefono;
    private String movil;
    private String correo_Electronico;
    private String URL;
    private String fb;
    private String ig;
    private String compañia;
    private String puesto;
    private String notas;
    private String citas;
    //URL, IG, Fck

    public Persona(String nombre,String apellido_Paterno, String apellido_Materno, String direcciones, String telefono, String movil, String correo_Electronico, String compañia, String puesto,String URL, String fb, String ig, String notas, String citas){
        this.nombre=nombre;
        this.apellido_Materno= apellido_Materno;
        this.apellido_Paterno= apellido_Paterno;
        this.direcciones = direcciones;
        this.telefono= telefono;
        this.movil= movil;
        this.correo_Electronico=correo_Electronico;
        this.URL=URL;
        this.fb=fb;
        this.ig=ig;
        this.compañia=compañia;
        this.puesto=puesto;
        this.notas=notas;
        this.citas=citas;

    }
    /*
     * Getters de Persona
     */
    public String getnombre(){
        return this.nombre;
    }
    public String getapellido_Materno(){
        return this.apellido_Materno;
    }

    public String getapellido_Paterno(){
        return this.apellido_Paterno;
    }

    public String getdirecciones(){
        return this.direcciones;
    }

    public String gettelefeno(){
        return this.telefono;
    }

    public String getmovil(){
        return this.movil;
    }

    public String getcorreo_Electronico(){
        return this.correo_Electronico;
    }
    public String getURL(){
        return this.URL;
    }
    public String getIG(){
        return this.ig;
    }
    public String getFB(){
        return this.fb;
    }
    public String getCitas(){
        return this.citas;
    }
    public String getnotas(){
        return this.notas;
    }

    /*
     * Setters de Persona
     */
    public void setnombre(String nombre){
        this.nombre=nombre;
    }
    public void setapellido_materno( String apellido_Materno){
        this.apellido_Materno= apellido_Materno;
    }

    public void setapellido_Paterno(String apellido_Paterno){
        this.apellido_Paterno= apellido_Paterno;
    }

    public void setdirecciones(String direcciones){
       this.direcciones= direcciones;
    }

    public void settelefono(String telefono){
        this.telefono= telefono;
    }

    public void setmovil(String movil){
        this.movil= movil;
    }

    public void setcorreoElectronico(String correo_Electronico){
        this.correo_Electronico= correo_Electronico;
    }
    public void setURL(String URL){
        this.URL=URL;
    }
    public void setfb(String fb){
        this.fb=fb;
    }
    public void setIG(String ig){
        this.ig=ig;
    }
    //Setters
    public void setCompañia(String compañia){
        this.compañia=compañia;
    }
    public void setPuesto(String puesto){
        this.puesto=puesto;
    }
    public void setCitas(String citas){
        this.citas=citas;
    }
    public void setNotas(String notas){
        this.notas=notas;
    }
    //Getters
    public String getCompañia(){
        return this.compañia;
    }
    public String getPuesto(){
        return this.puesto;
    }
    @Override
    public String toString(){
        return nombre + "-" + apellido_Paterno + "-" +apellido_Materno + "-"+ direcciones + "-"+ telefono + "-" + movil + "-" +correo_Electronico + "-" + compañia + "-" + puesto + "-" + URL +"-" + fb + "-" + ig + "-" + notas + "-" + citas;
    }
}