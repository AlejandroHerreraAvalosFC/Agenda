import java.time.*;
public class Calendario{
    private int año;
    private int mes;

    public Calendario(int año, int mes){
        this.año=año;
        this.mes=mes;
    }

    public int getAño(){
        return this.año;
    }
    public int getMes(){
        return this.mes;
    }
    public void setAño(int año){
        this.año=año;
    }
    public void setMes(int mes){
        this.mes=mes;
    }
    public void getCalendario(int año, int mes){
        System.out.println("Calendario de " + getMes(mes) +" de" + año);
        System.out.println("Lu Ma Mi Ju Vi Sa Do");
        YearMonth ym = YearMonth.of(año, mes);
        LocalDate primerDia = ym.atDay(1);
        int lenMes = ym.lengthOfMonth();
        int primerDiaSemana = primerDia.getDayOfWeek().getValue();
        for (int i = 1; i < primerDiaSemana; i++) {
            System.out.print("   ");
        }
        for (int day = 1; day <= lenMes; day++) {
            System.out.printf("%2d ", day);
            if ((day + primerDiaSemana - 1) % 7 == 0) {
                System.out.println("");
            }
        }
        System.out.println("");
    }
    public String getMes(int mes){
        String [] meses ={"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        return meses[mes-1];
    }
}