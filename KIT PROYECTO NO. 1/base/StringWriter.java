import java.io.FileWriter;
import java.io.IOException;
public class StringWriter {
    FileWriter archivo;
    public StringWriter(String filePath) {
        // Constructor de la clase. Aqui debe crear un FileWriter o una estructura similar para escribir a disco
        try{
            archivo = new FileWriter(filePath,true);
        }catch (IOException e) {}
    }

    public void write(boolean result) {
        // Escribe "true" o "false" en elS archivo, uno por linea
        try{
        if (result == true){
            archivo.write("True \n");
        }else{
            archivo.write("False \n");
        }}catch(IOException e){
        }
    }

    public void close() {
        // Cierra el archivo
        try{archivo.close();}catch(IOException e){}
    }
}
