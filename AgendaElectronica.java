import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
                                Cita cita =new Cita(null, null, null);
                                num=i+1;
                                System.out.println("==== Registro de cita " + num + " ====");
                                System.out.print("Título:");
                                String temp=scanner.nextLine();
                                cita.setTitulo(temp);
                                citas=citas+ temp +"#";
                                System.out.print("Fecha:");
                                temp=scanner.nextLine();
                                cita.setFecha(temp);
                                citas=citas+ temp +"#";
                                System.out.print("Hora:");
                                temp=scanner.nextLine();
                                cita.setHora(temp);
                                citas=citas+ temp +"&";
                                p.setCitas(citas);
                                System.out.println("====Cita====");
                                System.out.println("Título: " + cita.getTitulo());
                                System.out.println("Fecha: " + cita.getDate());
                                System.out.println("Hora: " + cita.getHora());
                            }
                            flag_citas=false;
                            }
                            catch(InputMismatchException e){
                                flag=true;
                                scanner.nextLine();
                                System.out.println("Solo números.");
                            }
                            catch (Exception e) {
                            }
                    } while (flag_citas==true);
                }
                else {
                    p.setCitas(citas);
                }
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
                                System.out.println("====Nota====");
                                System.out.println("Descripción: " + notas_act);
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
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado");
            }
            FileWriter fw = new FileWriter("ejemplo.data", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(str);
            bw.close();
            System.out.println("Listo");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir");
            e.printStackTrace();
        }
    }
    public static void escribirArchivo(List <Persona> personas){
        try {
            File archivo= new File("ejemplo.data");
            if (archivo.createNewFile()) {
                System.out.println("No se encontro el archivo.");
            }
            else{
                FileWriter fw = new FileWriter("ejemplo.data", false);
                BufferedWriter bw = new BufferedWriter(fw);
                for (int i=0;i<personas.size();i++){
                    if(i>0){
                        bw.newLine();
                    }
                    bw.write(personas.get(i).toString());
                }
                bw.close();
                System.out.println("Listo");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir");
            e.printStackTrace();
        }
    }
    public static List<Persona> leerPersonas(String nombreArchivo) {
        List<Persona> personas = new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(Paths.get(nombreArchivo));
            for (String linea : lineas) {
                if (linea.trim().isEmpty()) continue; // Ignorar líneas vacías
                String[] partes = linea.split("-"); // Split con límite para preservar notas
                Persona p = new Persona(null, null, null, null, null, null, null, null, null, null, null, null, null, null);
                p.setnombre(partes[0]);
                p.setapellido_Paterno(partes[1]);
                p.setapellido_materno(partes[2]);
                p.setdirecciones(partes[3]);
                p.settelefono(partes[4]);
                p.setmovil(partes[5]);
                p.setcorreoElectronico(partes[6]);
                p.setCompañia(partes[7]);
                p.setPuesto(partes[8]);
                p.setURL(partes[9]);
                p.setfb(partes[10]);
                p.setIG(partes[11]);
                p.setNotas(partes[12]);
                p.setCitas(partes[13]);
                personas.add(p);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
        return personas;
    }
    public static List<Persona> eliminaPersona(String nombreArchivo, Persona aeliminar) {
        List<Persona> personas = new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(Paths.get(nombreArchivo));
            for (String linea : lineas) {
                if (linea.trim().isEmpty()) continue; // Ignorar líneas vacías
                String[] partes = linea.split("-"); // Split con límite para preservar notas
                if(partes[0].equals(aeliminar.getnombre()) && partes[1].equals(aeliminar.getapellido_Paterno()) && partes[2].equals(aeliminar.getapellido_Materno())){
                    System.out.println(aeliminar.getnombre());
                    continue;
                }
                Persona p = new Persona(null, null, null, null, null, null, null, null, null, null, null, null, null, null);
                p.setnombre(partes[0]);
                p.setapellido_Paterno(partes[1]);
                p.setapellido_materno(partes[2]);
                p.setdirecciones(partes[3]);
                p.settelefono(partes[4]);
                p.setmovil(partes[5]);
                p.setcorreoElectronico(partes[6]);
                p.setCompañia(partes[7]);
                p.setPuesto(partes[8]);
                p.setURL(partes[9]);
                p.setfb(partes[10]);
                p.setIG(partes[11]);
                p.setNotas(partes[12]);
                p.setCitas(partes[13]);
                personas.add(p);
                //System.out.println(p.getnombre());
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
        return personas;
    }
    public static Persona buscarPersona(List <Persona> personas, Persona buscado){
        for (Persona persona : personas) {
            if(persona.getnombre().equals(buscado.getnombre()) && persona.getapellido_Paterno().equals(buscado.getapellido_Paterno()) && persona.getapellido_Materno().equals(buscado.getapellido_Materno())){
                return persona;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int respuestaMenu=0;
        List <Persona> encontradosArchivo;
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
                    Persona buscado =new Persona(null, null, null, null, null, null, null, null, null, null, null, null, null, null);
                    System.out.println("Ingrese el nombre, apellido paterno y apellido materno de la persona que quiere buscar");
                    System.out.print("Nombre: ");
                    buscado.setnombre(scanner.nextLine());
                    System.out.print("Apellido Paterno: ");
                    buscado.setapellido_Paterno(scanner.nextLine());
                    System.out.print("Apellido Materno: ");
                    buscado.setapellido_materno(scanner.nextLine());
                    encontradosArchivo= leerPersonas("ejemplo.data");
                    buscado=buscarPersona(encontradosArchivo, buscado);
                    if (buscado != null) {
                        buscado.toStringBonito(buscado, "\nResultado");
                    } else {
                        System.out.println("No se encontró el registro buscado.");
                    }
                    encontradosArchivo.clear();
                    respuestaMenu=menu(respuestaMenu, scanner);
                    break;
                //Caso 3. Eliminar registro
                case 3:
                    Persona eliminado =new Persona(null, null, null, null, null, null, null, null, null, null, null, null, null, null);
                    System.out.println("Ingrese el nombre, apellido paterno y apellido materno de la persona que quiere buscar");
                    System.out.print("Nombre: ");
                    eliminado.setnombre(scanner.nextLine());
                    System.out.print("Apellido Paterno: ");
                    eliminado.setapellido_Paterno(scanner.nextLine());
                    System.out.print("Apellido Materno: ");
                    eliminado.setapellido_materno(scanner.nextLine());
                    encontradosArchivo= leerPersonas("ejemplo.data");
                    eliminado=buscarPersona(encontradosArchivo, eliminado);
                    if (eliminado != null) {
                        List <Persona> no_eliminados=eliminaPersona("ejemplo.data", eliminado);
                        escribirArchivo(no_eliminados);
                    } else {
                        System.out.println("No se encontró el registro a eliminar.");
                    }
                    encontradosArchivo.clear();
                    respuestaMenu = menu(respuestaMenu, scanner);
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