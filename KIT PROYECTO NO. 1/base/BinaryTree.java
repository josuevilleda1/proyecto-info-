import java.util.ArrayList;

public class BinaryTree {
    private String abdcdario;
    private ArrayList<String> palabra;
    ArrayList<Node> aux = new ArrayList<>();//Lista auxiliar para guardar nodos que aun pueden tener hijos
    int i = 0;
    ArrayList<Node> imprimir = new ArrayList<>();//arbol binario resultante
    private Node root; //Etsa variable nos ayudara a guardar quien es la raiz 


    public BinaryTree(String filePath) {
        // Constructor de la clase. Aqui debes leer el archivo y construir tu arbol binario
        StringReader Nodo = new StringReader(filePath); //lee el archivo
        palabra = Nodo.Contenido(); //obtiene el archivo en formato de ArrayList
        //Tokeniza cada linea para encontrar los nodos
              for(int i = 1; i<palabra.size(); i++){ 
            String linea = palabra.get(i).trim(); // Limpiamos espacios para evitar errores de lectura
            if(linea.isEmpty()) continue; // Si la linea esta vacia, saltamos para no contar de mas
            String [] nueva = linea.split("\\|");
            for (int j=0; j<nueva.length;j++){//recorre mi arreglo de nodo x para crear el nodo.
                
                // CORRECCION: Usamos this.root para verificar existencia, no aux.isEmpty()
                if(this.root == null){ //Si es el primer nodo, lo crea como nodo raiz.
                    Node nodo = new Node(null, nueva[j].charAt(0), null, null,nueva[j].charAt(2),nueva[j].charAt(4));
                    this.root = nodo;
                    aux.add(nodo);
                    imprimir.add(nodo);
                }
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
                            break;
                        }

                        else if(nodo_anterior.hd == '1'){//Evaluamos si posee hijo a la derecha para crear nuevo nodo.
                            Node nodo = new Node(nodo_anterior, nueva[j].charAt(0), null, null,nueva[j].charAt(2),nueva[j].charAt(4));
                            nodo_anterior.right = nodo;
                            nodo_anterior.getChangeD('0');
                            aux.add(nodo);
                            imprimir.add(nodo);
                            break;
                        }
                        else{
                            aux.remove(0);//elimina a un nodo de auxiliar si ya no tiene oportunidades de hijos.
                        }
                    }
                }
            }
        }
        abdcdario = palabra.get(0);
    }

    /*Etse metodo solo nos devolvera cual es la raiz del arbol, esto nos ayudar a poder usar el caso recursvo para poder buscar */
    public Node getRoot(){
        return this.root;
    }

    public ArrayList<Node> arbolArmado(){
        return this.imprimir;
    }
            

    public boolean contains_string(String string) {
        //lamba es un sub arbol tecnicmanete entonces si la palabra no es nada cuenta jajaja 
        if (string == null || string.isEmpty()) return true; 
        return Buscador(this.root, string, 0);
    }

    private boolean Buscador(Node actual, String palabra, int indice) {
        if (actual == null) return false;
        if (actual.dato == palabra.charAt(indice)) {
            if (indice == palabra.length() - 1) return true;
            if (Buscador(actual.left, palabra, indice + 1) || Buscador(actual.right, palabra, indice + 1)) return true;
        }
        if(indice == 0) {
            return Buscador(actual.left, palabra, 0) || Buscador(actual.right, palabra, 0);
        }
        return false;
    }    
}