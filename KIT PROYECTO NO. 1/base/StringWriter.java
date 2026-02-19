import java.io.FileWriter;
import java.io.IOException;

public class StringWriter {
    FileWriter archivo;

    public StringWriter(String filePath) {
        try {
            archivo = new FileWriter(filePath); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(boolean result) {
        try {
            if (result) {
                archivo.write("true\n");
            } else {
                archivo.write("false\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (archivo != null) {
                archivo.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}