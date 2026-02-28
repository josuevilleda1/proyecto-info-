import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Dibujo extends JPanel {

    ArrayList<Integer> lX;
    ArrayList<Integer> ly;
    int ancho;
    ArrayList<String> dato;
    ArrayList<Node> listaArbol;
    ArrayList<Node> aux;

    public Dibujo(ArrayList<Integer> ly, int ancho, ArrayList<Integer> lX, ArrayList<Node> listaArbol, ArrayList<Node> aux) {
        this.ly = ly;
        this.lX = lX;
        this.ancho = ancho;
        this.aux = aux;
        this.listaArbol = listaArbol;
    }

    public void setDibujarNodo() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setFont(new Font("Arial", Font.BOLD, 16));

        for (int i = 0; i < aux.size(); i++) {
            if(aux.get(i) != null){
                if(aux.get(i).left != null){
                    for(int z = 0; z<aux.size();z++){
                        if(aux.get(z) == aux.get(i).left){
                        g.drawLine(lX.get(i), ly.get(i), lX.get(z), ly.get(z));
                        break;}
                    }
            }
        }
        if(aux.get(i) != null){
                if(aux.get(i).right != null){
                    for(int z = 0; z<aux.size();z++){
                        if(aux.get(z) == aux.get(i).right){
                        g.drawLine(lX.get(i), ly.get(i), lX.get(z), ly.get(z));
                        break;}
                    }
            }
        }}
        
        for (int i = 0; i < aux.size(); i++) {
            if(aux.get(i)!= null){
                int x = lX.get(i);
            int y = ly.get(i);
            String texto = String.valueOf(aux.get(i).dato);
            g.setColor(Color.GREEN);
            g.fillOval(x-25, y, ancho, ancho);
            g.setColor(Color.BLACK);
            g.drawString(texto, x-3, y+(ancho/2));
            }
        }


    }
}

















