import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class file{
    public static void leerArchivo(){
        try{
            File archivo = new File("ejemplo.data");
            Scanner lector = new Scanner (archivo);
            while (lector.hasNextLine()){
                String linea=lector.nextLine();
                System.out.println(linea);
            }
            lector.close() ;
        }
        catch(FileNotFoundException e){
            System.out.println("No␣se␣encontr␣el␣archivo.");
            e.printStackTrace() ;
        }
    }
}

