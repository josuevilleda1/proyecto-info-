import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StringReader {

    private ArrayList<String> contenido;

    public StringReader(String filePath) {
        contenido = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String linea;

            while ((linea = reader.readLine()) != null) {
                contenido.add(linea);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public int length() {
        return contenido.size();
    }

    public String get(int index) {
        return contenido.get(index);
    }

    public ArrayList<String> Contenido() {
        return contenido;
    }
} 