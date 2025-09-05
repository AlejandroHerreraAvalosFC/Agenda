public class Empleo extends Persona{

    private String compañia;
    private String puesto;

    public Empleo(String nombre,String apellido_Materno, String apellido_Paterno, String direcciones, String telefono, String movil, String correo_Electronico,String compañia, String puesto, String URL, String fb, String ig){
        super(nombre, apellido_Materno, apellido_Paterno, direcciones, telefono, movil,correo_Electronico, URL, fb, ig);
        this.compañia = compañia;
        this.puesto = puesto;
    }

    //Setters
    public void setCompañia(String compañia){
        this.compañia=compañia;
    }
    public void setPuesto(String puesto){
        this.puesto=puesto;
    }
    //Getters
    public String getCompañia(){
        return this.compañia;
    }
    public String getPuesto(){
        return this.puesto;
    }
}