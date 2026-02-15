import java.util.ArrayList;
import java.util.Scanner;

public class TestRunner {
    //usamos esta funcion para tener un encaezado en nuestros test
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
    // usammos esto para dar el menu de las pruebas que podemos hacer
    private static void mostrarMenu() {
        System.out.println("1) Prueba lectura de Arbol");
        System.out.println("2) prueba de lectura de cuerdas");
        System.out.println("3)");
        System.out.println("4)");
        System.out.println("0)Salir\n");
    }
    //esto nos ayuda a poner enpausa el scanner para que no siga leyendo mientras se esta haciendo el testing
    private static void pausa(Scanner scanner) {
        System.out.println("\nPresione ENTER para continuar...");
        scanner.nextLine(); 
        scanner.nextLine();
    }
    // esta limpia la panatalla para que cuando se empieze a correr el test no tengamos menu
    private static void limpiarPantalla() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            limpiarPantalla();
            mostrarEncabezado();
            mostrarMenu();
            
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            
            limpiarPantalla();
            mostrarEncabezado();

            switch (opcion) {
                case 1:
                    System.out.println("--- PRUEBA LECTURA DE ARBOL ---");
                    String rutaArbol = "/Users/josuevilleda/proyecto-info-/KIT PROYECTO NO. 1/base/test/binary_trees/lectura.binary_tree";
                    BinaryTree miArbol = new BinaryTree(rutaArbol);
                    pausa(scanner);
                    break;

                case 2:
                    System.out.println("--- PRUEBA LECTURA DE CUERDAS ---");
                    String rutaCuerdas = "/Users/josuevilleda/proyecto-info-/KIT PROYECTO NO. 1/base/test/cuerdas/cuerda.txt";
                    StringReader lectorCuerdas = new StringReader(rutaCuerdas);
                    System.out.println("Total de cuerdas leídas: " + lectorCuerdas.length());
                    System.out.println("Contenido extraído:");
                    ArrayList<String> lista = lectorCuerdas.Contenido();
                    for (String s : lista) {
                        System.out.println(" -> " + s);
                    }
                    pausa(scanner);
                    break;


            }

              

        } while (opcion != 0);

        scanner.close();
    }
}


