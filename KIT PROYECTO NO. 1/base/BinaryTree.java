import java.util.ArrayList;

import javax.print.DocFlavor.STRING;

public class BinaryTree {
    private String abdcdario;
    private ArrayList<String> palabra;
    ArrayList<Node> aux = new ArrayList<>();//Lista auxiliar para guardar nodos que aun pueden tener hijos
    int i = 0;
    ArrayList<Node> imprimir = new ArrayList<>();//arbol binario resultante

    public BinaryTree(String filePath) {
        // Constructor de la clase. Aqui debes leer el archivo y construir tu arbol binario
        StringReader Nodo = new StringReader(filePath); //lee el archivo
        palabra = Nodo.Contenido(); //obtiene el archivo en formato de ArrayList
        //Tokeniza cada linea para encontrar los nodos
              for(int i = 0; i<palabra.size(); i++){
            String linea = palabra.get(i);
            String [] nueva = linea.split("\\|");
            for (int j=0; j<nueva.length;j++){//recorre mi arreglo de nodo x para crear el nodo.
                if(aux.isEmpty()){//Si es el primer nodo, lo crea como nodo raiz.
                    Node nodo = new Node(null, nueva[j].charAt(0), null, null,nueva[j].charAt(2),nueva[j].charAt(4));
                    aux.add(nodo);
                    imprimir.add(nodo);}
                else{
                    while(true){
                    if(aux.isEmpty()){
                        break;
                    }
                    Node nodo_anterior = aux.get(0);//Extraemos el nodo anterior de al lista aux
                    if(nodo_anterior.hz == '1'){//Evaluamos si posee un hijo a la izquierda para crear el nuevo nodo
                        Node nodo = new Node(nodo_anterior, nueva[j].charAt(0), null, null,nueva[j].charAt(2),nueva[j].charAt(4));
                        nodo_anterior.left = nodo;
                        nodo_anterior.getChangeI('0');
                        aux.add(nodo);
                        imprimir.add(nodo);
                        break;}

                    else if(nodo_anterior.hd == '1'){//Evaluamos si posee hijo a la derecha para crear nuevo nodo.
                        Node nodo = new Node(nodo_anterior, nueva[j].charAt(0), null, null,nueva[j].charAt(2),nueva[j].charAt(4));
                        nodo_anterior.right = nodo;
                        nodo_anterior.getChangeD('0');
                        aux.add(nodo);
                        imprimir.add(nodo);
                        break;}
                    else{
                        aux.remove(0);//elimina a un nodo de auxiliar si ya no tiene oportunidades de hijos.
                    }
                    }

                    }

                    }
                }
       // System.out.println(palabra); //se usa momentaneamente para los test personales que hacemos 
        abdcdario = palabra.get(0);
        //System.out.println("lectura del abcdario"+ abdcdario); //se usa momentaneamente para los test personales que hacemos 

    }
            

    public boolean contains_string(String string) {
        // Evalua si un arbol contiene otro sub arbol que pueda generar la cadena proporcionada
        return false;
    }
}
