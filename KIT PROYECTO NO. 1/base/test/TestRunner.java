import java.util.ArrayList;
import java.util.Scanner;

public class TestRunner {
    private static void mostrarEncabezado() {
        System.out.println(
"████████╗███████╗███████╗████████╗    ██╗   ██╗██╗███╗   ███╗██████╗  ██████╗\n" +
"╚══██╔══╝██╔════╝██╔════╝╚══██╔══╝    ██║   ██║██║████╗ ████║██╔══██╗██╔═══██╗\n" +
"   ██║   █████╗  ███████╗   ██║       ██║   ██║██║██╔████╔██║██████╔╝██║   ██║\n" +
"   ██║   ██╔══╝  ╚════██║   ██║       ╚██╗ ██╔╝██║██║╚██╔╝██║██╔══██╗██║   ██║\n" +
"   ██║   ███████╗███████║   ██║        ╚████╔╝ ██║██║ ╚═╝ ██║██████╔╝╚██████╔╝\n" +
"   ╚═╝   ╚══════╝╚══════╝   ╚═╝         ╚═══╝  ╚═╝╚═╝     ╚═╝╚═════╝  ╚═════╝"
        );
    }

    private static void mostrarMenu() {
        System.out.println("1) Prueba lectura de Arbol");
        System.out.println("2) prueba de lectura de cuerdas");
        System.out.println("3) prueba de estructura del arbol");
        System.out.println("4) busqueda de arbol");
        System.out.println("0) Salir");
    }

    private static void pausa(Scanner scanner) {
        System.out.println("Presione ENTER para continuar...");
        scanner.nextLine(); 
        scanner.nextLine();
    }

    private static void limpiarPantalla() {
        for (int i = 0; i < 2; i++) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        String pathArbol = "/Users/josuevilleda/proyecto-info-/KIT PROYECTO NO. 1/base/test/binary_trees/lectura";
        String pathCuerdas = "/Users/josuevilleda/proyecto-info-/KIT PROYECTO NO. 1/base/test/cuerdas/cuerda";

        do {
            limpiarPantalla();
            mostrarEncabezado();
            mostrarMenu();
            
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            
            limpiarPantalla();
            mostrarEncabezado();

            // 1. Manejamos la salida primero
            if (opcion == 0) {
                System.out.println("Saliendo...");
                break; 
            }

            // 2. Pedimos la cantidad solo si es una opción válida de prueba
            int cantidadTests = 0; 
            if (opcion >= 1 && opcion <= 4) {
                System.out.print("¿Cuántos test desea realizar? (1-10): ");
                cantidadTests = scanner.nextInt();
            }

            // 3. El switch ahora está fuera del IF de cantidadTests
            switch (opcion) {
                case 1:
                    for (int i = 1; i <= cantidadTests; i++) {
                        System.out.println("--- PRUEBA LECTURA DE ARBOL #" + i + " ---");
                        String rutaActual = pathArbol + i + ".binary_tree";
                        BinaryTree miArbol = new BinaryTree(rutaActual);
                    }
                    pausa(scanner);
                    break;

                case 2:
                    for (int i = 1; i <= cantidadTests; i++) {
                        System.out.println("--- PRUEBA LECTURA DE CUERDAS #" + i + " ---");
                        String rutaActual = pathCuerdas + i + ".txt";
                        StringReader lectorCuerdas = new StringReader(rutaActual);
                        System.out.println("Total de cuerdas leídas: " + lectorCuerdas.length());
                        System.out.println("Contenido extraído:");
                        ArrayList<String> lista = lectorCuerdas.Contenido();
                        for (String s : lista) {
                            System.out.println(" -> " + s);
                        }
                    }
                    pausa(scanner);
                    break;
                
                case 3:
                    for (int i = 1; i <= cantidadTests; i++) {
                        System.out.println("--- PRUEBA DE LA CREACION DE NODOS (ARBOL #" + i + ") ---");
                        String rutaActual = pathArbol + i + ".binary_tree";
                        BinaryTree arbol = new BinaryTree(rutaActual);
                        ArrayList<Node> listaNodos = arbol.arbolArmado();
                        
                        for(Node n : listaNodos){
                            System.out.println("\nAnalizando nodo: " + n.dato);
                            if(n.left != null){
                                assert n.left.parent == n : "El nodo " + n.left.dato + " No reconoce a " + n.dato + " Como su nodo padre";
                                System.out.println("  - Hijo izquierdo (" + n.left.dato + ") reconoce a " + n.dato + " como padre.");
                            }
                            if(n.right != null){
                                assert n.right.parent == n : "El nodo " + n.right.dato + " No reconoce a " + n.dato + " Como su nodo padre";
                                System.out.println("  - Hijo derecho (" + n.right.dato + ") reconoce a " + n.dato + " como padre.");
                            }
                            if (n.left == null && n.right == null) {
                                System.out.println("  - " + n.dato + " no tiene hijos (es hoja)");
                            }
                        }
                        System.out.println("\n--- ¡PRUEBA #" + i + " FINALIZADA CON ÉXITO! ---");
                    }
                    pausa(scanner);
                    break;
                
                case 4:
                    for (int i = 1; i <= cantidadTests; i++) {
                        System.out.println("--- PRUEBA DE BÚSQUEDA DE SUB-ÁRBOLES (SET #" + i + ") ---");
                        String rutaArbolActual = pathArbol + i + ".binary_tree";
                        String rutaCuerdasActual = pathCuerdas + i + ".txt";
                        
                        BinaryTree arbol4 = new BinaryTree(rutaArbolActual);
                        StringReader lector = new StringReader(rutaCuerdasActual);
                        ArrayList<String> palabrasABuscar = lector.Contenido();

                        System.out.println("Buscando palabras del archivo en el árbol...");
                        for (String palabra : palabrasABuscar) {
                            boolean existe = arbol4.contains_string(palabra);
                            if (existe) {
                                System.out.println("La palabra '" + palabra + "' SÍ es un sub-árbol.");
                            } else {
                                System.out.println("La palabra '" + palabra + "' NO se encontró como sub-árbol.");
                            }
                        }
                        System.out.println("\n--- ¡PRUEBA DE BÚSQUEDA #" + i + " FINALIZADA! ---");
                    }
                    pausa(scanner);
                    break;

                default:
                    System.out.println("Opción no válida.");
                    pausa(scanner);
                    break;
            } 
        } while (opcion != 0); 
        
        scanner.close();
    }
}