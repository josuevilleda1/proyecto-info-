import java.util.ArrayList;
//CLASE TEMPORAL, SOLO PARA PROBAR COMO FUNCIONA LA TOKENIZACIÓN, CREACIÓN Y CONEXIÓN DE NODOS
public class token{

    ArrayList<Node> aux = new ArrayList<>();
    int i = 0;
    ArrayList<Node> imprimir = new ArrayList<>();
    public static void main(String []args){
        ArrayList<String> contenido = new ArrayList<>();
        contenido.add("A,1,1");
        contenido.add("b,1,0|c,1,1");
        contenido.add("d,0,0|f,0,0|g,0,0");
        ArrayList<Node> aux = new ArrayList<>();
        token t = new token();
    ArrayList<Node> resultado = t.tokenizar(contenido);

    for (Node n : resultado) {
    char leftDato = (n.left != null) ? n.left.dato : 'n';
    char rightDato = (n.right != null) ? n.right.dato : 'n';

    System.out.println(n.dato + "," + leftDato + "," + rightDato);
    }
            
}
        

    public ArrayList<Node> tokenizar(ArrayList<String> contenido){
        for(int i = 0; i<contenido.size(); i++){
            String linea = contenido.get(i);
            String [] nueva = linea.split("\\|");
            for (int j=0; j<nueva.length;j++){
                if(aux.isEmpty()){
                    Node nodo = new Node(null, nueva[j].charAt(0), null, null,nueva[j].charAt(2),nueva[j].charAt(4));
                    aux.add(nodo);
                    imprimir.add(nodo);}
                else{
                    while(true){
                    if(aux.isEmpty()){
                        break;
                    }
                    Node nodo_anterior = aux.get(0);
                    if(nodo_anterior.hz == '1'){
                        Node nodo = new Node(nodo_anterior, nueva[j].charAt(0), null, null,nueva[j].charAt(2),nueva[j].charAt(4));
                        nodo_anterior.left = nodo;
                        nodo_anterior.getChangeI('0');
                        aux.add(nodo);
                        imprimir.add(nodo);
                        break;}

                    else if(nodo_anterior.hd == '1'){
                        Node nodo = new Node(nodo_anterior, nueva[j].charAt(0), null, null,nueva[j].charAt(2),nueva[j].charAt(4));
                        nodo_anterior.right = nodo;
                        nodo_anterior.getChangeD('0');
                        aux.add(nodo);
                        imprimir.add(nodo);
                        break;}
                    else{
                        aux.remove(0);
                    }
                    }

                    }

                    }
                }return imprimir;}
            
        }  
