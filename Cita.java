public class Cita{
    private String titulo;
    private String fecha;// dd/mm/AAAA
    private String hora; // HH:mm

    public Cita(String Titulo, String fecha, String hora){
        this.titulo = Titulo;
        this.fecha = fecha;
        this.hora = hora;
    }

    //Setters
    public void setTitulo(String titulo){
        this.titulo=titulo;
    }
    public void setFecha(String fecha){
        this.fecha=fecha;
    }
    public void setHora(String hora){
        this.hora=hora;
    }

    //Getters
    public String getTitulo(){
        return this.titulo;
    }
    public String getDate(){
        return this.fecha;
    }
    public String getHora(){
        return this.hora;
    }
    @Override
    public String toString(){
        return this.titulo+ "#" +this.fecha + "#" +this.hora;
    }
}