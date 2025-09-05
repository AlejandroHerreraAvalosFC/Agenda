import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException ;
public class file {
    public static void escribirArchivo(String str){
        try {
            File archivo= new File(str);
            if (archivo.createNewFile ( ) ) {
                System.out.println("Archivo creado");
            }else {
                System.out.println();
            }
            FileWriter fw = new FileWriter( " ejemplo.data" ,false ) ;
            BufferedWriter bw = new BufferedWriter ( fw ) ;
            bw.write(str) ;
            bw. newLine () ;
            bw.close() ;
            System .out.println ( "Listo" ) ;
            } catch ( IOException e ) {
            System.out.println ( "Ocurrio un error al escribir " ) ;
            e.printStackTrace( ) ;
        }
    }
}
