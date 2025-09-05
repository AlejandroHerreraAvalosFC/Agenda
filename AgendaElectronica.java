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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int respuestaMenu=0;
        respuestaMenu=menu(respuestaMenu, scanner);
        while (respuestaMenu!=6){
            switch (respuestaMenu) {
                //Caso 1.Añadir registro
                case 1:
                    System.out.println("Caso1");
                    Persona p =new Persona(null, null, null, null, null, null, null, null, null, null, null, null);
                    p = menuCrearRegistro(scanner,p);
                    escribirArchivo(p.toString());
                    respuestaMenu=menu(respuestaMenu, scanner);
                    break;
                //Caso 2.Buscar registro
                case 2:
                    System.out.println("Caso2");
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