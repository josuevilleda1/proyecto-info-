import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Frame extends JFrame {

    public Frame() {
        setTitle("INICIO");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear Formulario
        setLayout(new FlowLayout());
        JLabel tx1 = new JLabel("Write the filepath of your Binary Tree");
        JTextField B = new JTextField(25);
        JLabel tx2 = new JLabel("Write the filepath of your document results");
        JTextField W = new JTextField(25);
        JLabel tx3 = new JLabel("Write the filepath of document of strings");
        JTextField R = new JTextField(25);
        JButton guardar = new JButton("GUARDAR");

        guardar.addActionListener(e -> {
            try {
                BinaryTree binary_tree = new BinaryTree(B.getText());
                StringWriter string_writer = new StringWriter(W.getText());
                StringReader string_reader = new StringReader(R.getText());

                for (int index = 0; index < string_reader.length(); index++) {
                    if (binary_tree.contains_string(string_reader.get(index))) {
                        string_writer.write(true);
                    } else {
                        string_writer.write(false);
                    }
                }

                string_writer.close();
                dispose();
                cuadro2(binary_tree);
            } catch (Exception er) {
                er.printStackTrace(); // Cambiado para ver errores en consola
            }
        });

        add(tx1);
        add(B);
        add(tx2);
        add(W);
        add(tx3);
        add(R);
        add(guardar);
        setVisible(true);
    }

    public void cuadro2(BinaryTree arbol) {
        JFrame ventanaArbol = new JFrame("VISUALIZADOR DE ARBOL BINARIO");
        ventanaArbol.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventanaArbol.setLocationRelativeTo(null);
        ArrayList<Integer> lX = new ArrayList<>();
        ArrayList<Integer> ly = new ArrayList<>();
        ArrayList<Node> nodosOrdenados = new ArrayList<>();
        if (arbol.getRoot() != null) {
            calcularPosiciones(arbol.getRoot(), 600, 50, 250, lX, ly, nodosOrdenados);
        }
        int diametroNodo = 50;
        Dibujo panel = new Dibujo(ly, diametroNodo, lX, arbol.arbolArmado(), nodosOrdenados);
        panel.setPreferredSize(new Dimension(2000, 1000)); 

        JScrollPane scroll = new JScrollPane(panel);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        ventanaArbol.add(scroll);
        ventanaArbol.setVisible(true);
        ventanaArbol.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

  
    private void calcularPosiciones(Node nodo, int x, int y, int gap, 
                                   ArrayList<Integer> lX, ArrayList<Integer> ly, 
                                   ArrayList<Node> nodos) {
        if (nodo == null) return;

        nodos.add(nodo);
        lX.add(x);
        ly.add(y);

        if (nodo.left != null) {
            calcularPosiciones(nodo.left, x - gap, y + 100, gap / 2, lX, ly, nodos);
        }
        if (nodo.right != null) {
            calcularPosiciones(nodo.right, x + gap, y + 100, gap / 2, lX, ly, nodos);
        }
    }

    public static void main(String[] args) {
        new Frame();
    }
}