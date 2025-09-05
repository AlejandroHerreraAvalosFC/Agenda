import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Cita{
    private String titulo;
    private Date fecha;// dd/mm/AAAA
    private Timestamp hora; // HH:mm

    public Cita(String Titulo, Date fecha, Timestamp hora){
        this.titulo = Titulo;
        this.fecha = fecha;
        this.hora = hora;
    }

    //Setters
    public void setTitulo(String titulo){
        this.titulo=titulo;
    }
    public void setFecha(Date fecha){
        this.fecha=fecha;
    }
    public void setHora(Timestamp hora){
        this.hora=hora;
    }

    //Getters
    public String getTitulo(){
        return this.titulo;
    }
    public Date getDate(){
        return this.fecha;
    }
    public Timestamp getHora(){
        return this.hora;
    }
}