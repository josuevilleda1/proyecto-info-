public class Node<N>{
    //Cada nodo almacena la informacion necesaria de:
    /* padre
    * nodo hijo izquierda
    * nodo hijo derecha
    * hz indica si posee hijo izquierdo. 
    * hd indica si posee hijo derecha
    * NOTAR: que no son valores fijos, sino cambiantes y solo sirven
    * para almacenar si se posee hijo izquierda o derecha, si no tiene, o ya fue ocupado.*/
    Node <N> parent, left, right;
    char dato;
    char hz;
    char hd;

    Node(Node <N> parent, char dato, Node <N> left, Node <N> right, char hz, char hd){
        this.parent = parent;
        this.dato = dato;
        this.left = left;
        this.right = right;
        this.hz = hz;
        this.hd = hd;
    }

    public void getChangeI(char s){
        this.hz = s;
    }
    public void getChangeD(char s){
        this.hd = s;
    }

}
