import java.util.ArrayList;

import javax.print.DocFlavor.STRING;

public class BinaryTree {
    private String abdcdario;
    private ArrayList<String> palabra;
    public BinaryTree(String filePath) {
        // Constructor de la clase. Aqui debes leer el archivo y construir tu arbol binario
        StringReader Nodo = new StringReader(filePath);
        palabra = Nodo.Contenido();
       // System.out.println(palabra); //se usa momentaneamente para los test personales que hacemos 
        abdcdario = palabra.get(0);
        //System.out.println("lectura del abcdario"+ abdcdario); //se usa momentaneamente para los test personales que hacemos 

    }

    public boolean contains_string(String string) {
        // Evalua si un arbol contiene otro sub arbol que pueda generar la cadena proporcionada
        return false;
    }
}
