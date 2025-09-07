import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AgendaElectronica {
    public static int menu (int respuestaMenu, Scanner scanner){
        boolean flag=true;
        System.out.println("Seleccione la opción que desea:");
        System.out.println("1. Añadir registro");
        System.out.println("2. Buscar registro");
        System.out.println("3. Eliminar registro");
        System.out.println("4. Modificar registro");
        System.out.println("5. Imprimir calendario");
        System.out.println("6. Salir");
        do{
            System.out.print("Opción seleccionada: ");
            try {
                respuestaMenu = scanner.nextInt();
                flag=false; 
            } 
            catch(InputMismatchException e){
                flag=true;
                scanner.nextLine();
                System.out.println("Solo números");
            }
            catch (Exception e) {
                flag=true;
                scanner.nextLine();
                System.out.println("Opción incorrecta. Vuelva a intentarlo");
            }
        }
        while(flag==true);
        scanner.nextLine();
        return respuestaMenu;
    }
    public static int [] menuCalendario(int año, int mes, Scanner scanner, int [] arrCalendario){
        boolean flag=true;
        do {
            try {
                System.out.print("Ingresa el año (e.g.2025): ");
                año=scanner.nextInt();
                if(año<1900){
                    throw new IllegalArgumentException("Año invalido");
                }
                arrCalendario[0]=año;
                scanner.nextLine();
                System.out.print("Ingresa el mes (1-12): ");
                mes=scanner.nextInt();
                arrCalendario[1]=mes;
                if(mes<=0 || mes>12){
                    throw new IllegalArgumentException();
                }
                flag=false;
            }
            catch(InputMismatchException e){
                flag=true;
                scanner.nextLine();
                System.out.println("Solo números validos.");
            }
            catch(IllegalArgumentException e){
                flag=true;
                scanner.nextLine();
                System.out.println("Ingresa un año valido.");
            }
             catch (Exception e) {
                flag=true;
                scanner.nextLine();
                System.out.println("Ocurrio un error");
            }
        } while (flag==true);
        scanner.nextLine();
        return arrCalendario;
    }
    public static Persona menuCrearRegistro(Scanner scanner, Persona p){
        boolean flag=true;
        boolean flag_notas=true;
        boolean flag_citas=true;
        do {
            try {
                System.out.println("=====Datos del contacto=====");
                System.out.print("Nombre(s):");
                p.setnombre(scanner.nextLine());
                System.out.print("Apellido Paterno:");
                p.setapellido_Paterno(scanner.nextLine());
                System.out.print("Apellido Materno:");
                p.setapellido_materno(scanner.nextLine());
                System.out.print("Dirección:");
                p.setdirecciones(scanner.nextLine());
                System.out.print("Telefono:");
                p.settelefono(scanner.nextLine());
                System.out.print("Movil:");
                p.setmovil(scanner.nextLine());
                System.out.print("Correo Electrónico:");
                p.setcorreoElectronico(scanner.nextLine());
                System.out.print("Compañia:");
                p.setCompañia(scanner.nextLine());
                System.out.print("Puesto:");
                p.setPuesto(scanner.nextLine());
                System.out.print("URL:");
                p.setURL(scanner.nextLine());
                System.out.print("FB:");
                p.setfb(scanner.nextLine());
                System.out.print("IG:");
                p.setIG(scanner.nextLine());
                System.out.print("Desea agregar notas: (S/N)");
                String notas="";
                if (scanner.nextLine().equalsIgnoreCase("S")){
                    do {
                        try {
                            System.out.print("¿Cuantas notas deseas agregar?:");
                            int total_notas=scanner.nextInt();
                            scanner.nextLine();
                            int num=0;
                            for(int i=0;i<total_notas;i++){
                                num=i+1;
                                System.out.println("==== Registro de nota " + num + " ====");
                                System.out.print("Descripción:");
                                String notas_act=scanner.nextLine();
                                notas=notas + notas_act +"&";
                                p.setNotas(notas);
                            }
                            flag_notas=false;
                        }
                        catch(InputMismatchException e){
                            flag=true;
                            scanner.nextLine();
                            System.out.println("Solo números.");
                        }
                        catch (Exception e) {
                        }
                    } while (flag_notas==true);
                }
                else{
                    p.setNotas(notas);
                }
                System.out.print("¿Desea agregar citas? (S/N):");
                String citas="";
                if (scanner.nextLine().equalsIgnoreCase("S")){
                    do {
                        try {
                            System.out.print("¿Cuantas citas deseas agregar?:");
                            int total_citas=scanner.nextInt();
                            scanner.nextLine();
                            int num=0;
                            for(int i=0;i<total_citas;i++){
                                num=i+1;
                                System.out.println("==== Registro de cita " + num + " ====");
                                System.out.print("Descripción:");
                                String cita_act=scanner.nextLine();
                                citas=citas+ cita_act +"&";
                                p.setCitas(citas);
                            }
                            flag_notas=false;
                            }
                            catch(InputMismatchException e){
                                flag=true;
                                scanner.nextLine();
                                System.out.println("Solo números.");
                            }
                            catch (Exception e) {
                            }
                    } while (flag_notas==true);
                }
                else {
                    p.setCitas(citas);
                }
                System.out.print("Presiona enter para terminar :)");
                scanner.nextLine();
                System.out.println();
                flag=false;
            }
            catch(InputMismatchException e){
                flag=true;
                scanner.nextLine();
                System.out.println("Solo números validos.");
            }
            catch(IllegalArgumentException e){
                flag=true;
                scanner.nextLine();
                System.out.println("Ingresa un año valido.");
            }
             catch (Exception e) {
                flag=true;
                scanner.nextLine();
                System.out.println("Ocurrio un error");
            }
        } while (flag==true);
        return p;
    }
    public static void escribirArchivo(String str){
        try {
            File archivo= new File("ejemplo.data");
            if (archivo.createNewFile ( ) ) {
                System.out.println("Archivo creado");
            }else {
                System.out.println();
            }
            FileWriter fw = new FileWriter( " ejemplo.data" ,true ) ;
            BufferedWriter bw = new BufferedWriter ( fw ) ;
            bw. newLine () ;
            bw.write(str) ;
            bw.close() ;
            System .out.println ( "Listo" ) ;
            } catch ( IOException e ) {
            System.out.println ( "Ocurrio un error al escribir " ) ;
            e.printStackTrace( ) ;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int respuestaMenu=0;
        respuestaMenu=menu(respuestaMenu, scanner);
        while (respuestaMenu!=6){
            switch (respuestaMenu) {
                //Caso 1.Añadir registro
                case 1:
                    System.out.println("Caso1");
                    Persona p =new Persona(null, null, null, null, null, null, null, null, null, null, null, null,null,null);
                    p = menuCrearRegistro(scanner,p);
                    escribirArchivo(p.toString());
                    respuestaMenu=menu(respuestaMenu, scanner);
                    break;
                //Caso 2.Buscar registro
                case 2:
                    System.out.println("Caso2");
                    System.out.println("");
                    respuestaMenu=menu(respuestaMenu, scanner);
                    break;
                //Caso 3. Eliminar registro
                case 3:
                    System.out.println("Caso3");
                    respuestaMenu=menu(respuestaMenu, scanner);
                    break;
                //Caso 4. Modificar registro
                case 4:
                    System.out.println("Caso4");
                    respuestaMenu=menu(respuestaMenu, scanner);
                    break;
                //Caso 5. Imprimir calendario
                case 5:
                    int año=0;
                    int mes=0;
                    int[] arrCalendario = new int[2];
                    menuCalendario(año, mes, scanner, arrCalendario);
                    Calendario c1= new Calendario(arrCalendario[0], arrCalendario[1]);
                    c1.getCalendario(arrCalendario[0], arrCalendario[1]);
                    respuestaMenu=menu(respuestaMenu, scanner);
                    break;
                //Caso 6. Salir
                case 6:
                    break;
                case 7:

                //Caso erroneo
                default:
                    System.out.println("Opción invalida, vuelva a intentarlo");
                    respuestaMenu=menu(respuestaMenu, scanner);
            }
        }
        scanner.close();
    } 
}