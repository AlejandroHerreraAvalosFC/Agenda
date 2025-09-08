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
    public void toStringBonito(Persona p, String msg){
        Nota notas = new Nota(p.getnotas());
        String [] notadeP=notas.toString().split("&",-1);
        System.out.println(msg);
        System.out.println("Nombre: " + p.getnombre());
        System.out.println("Apellido Paterno: " + p.getapellido_Paterno());
        System.out.println("Apellido Materno: " + p.getapellido_Materno());
        System.out.println("Dirección: " + p.getdirecciones());
        System.out.println("Telefono: " + p.gettelefeno());
        System.out.println("Movil: " + p.getmovil());
        System.out.println("Correo electronico: " + p.getcorreo_Electronico());
        System.out.println("Compañia: " + p.getCompañia());
        System.out.println("Puesto: " + p.getPuesto());
        System.out.println("URL: " + p.getURL());
        System.out.println("FB: " + p.getFB());
        System.out.println("IG: " + p.getIG());
        System.out.println("Notas:");
        for(int i=0;i<notadeP.length;i++){
            if(notadeP[i].equals("")){
                break;
            }
            System.out.println("  "+notadeP[i]);
        }
        String[] citaPersona = citas.toString().split("&",-1);
        System.out.println("Cita(s): ");
        for(int i=0;i<citaPersona.length;i++){
            if(citaPersona[i].equals("")) {
                continue;
            }
            String[] datosCita = citaPersona[i].split("#");
            if(datosCita.length == 3) {
                System.out.println("  Título: " + datosCita[0]);
                System.out.println("  Fecha: " + datosCita[1]);
                System.out.println("  Hora: " + datosCita[2]);
            }
        }
    }
}