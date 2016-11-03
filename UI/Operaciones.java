
package sorry.UI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Operaciones {
        
    public static void bienvenida(){
        
        System.out.println("SORRY\nHola compañero, bienvenido a Sorry! "
                + "Un juego de astucia y suerte que te hará agarrate de los pelos!\n"
                + "(Si nunca has jugado \"Sorry\" te recomendamos leer las instrucciones).");
        
    }
    
    public static int menu() throws InterruptedException{
        int numJugadores = 0;
        UI.sc = new Scanner(System.in);
        System.out.println("\n¿Qué quieres hacer?\n 1.Jugar.\n 2.Instrucciones.\n 0.Salir.");
        
        try{
        int s = UI.sc.nextInt();
        switch(s){
            case 1:
                numJugadores = UI.setUp();
                break;
            case 2:
                instrucciones();
                break;
            case 0:
                despedida();
                break;
            default:
                System.out.println("No existe esa opción. Inténtalo de nuevo.\n");
                menu();
                break;
        }
        }catch(InputMismatchException exc){
            System.out.println("No existe esa opción. Inténtalo de nuevo.\n");
            menu();
        }
        return numJugadores;
    }
    
    public static void menuinstrucciones() throws InterruptedException{
        
        Scanner entrada = new Scanner(System.in);
        System.out.println("\n¿Sobre qué quieres saber?\n1.Desarrollo del juego. \n2.Descipción de las cartas."
                + " \n3.Descripción de los discos. \n4.Movimimentos especiales. \n0.Atrás.");
        
        try{
            int s = entrada.nextInt();
        switch(s){
            case 1:
                desarrollo();
                break;
            case 2:
                descripcartas();
                break;
            case 3:
                descripdiscos();
                break;
            case 4:
                movespeciales();
                break;
            case 0:
                menu();
            default:
                System.out.println("No existe esa opción. Inténtalo de nuevo.");
                menuinstrucciones();
        }
        }catch(InputMismatchException exc){
            System.out.println("No existe esa opción. Inténtalo de nuevo.");
            menuinstrucciones();
        }
    }
    
    public static void instrucciones() throws InterruptedException{
        
        objetivo();
        menuinstrucciones();
        
    }
    
    public static void objetivo(){
        
        System.out.println("\nTu objetivo en el juego es llevar las cuatro fichas a casa (HOME). "
                + "Para ello, deberás partir desde la salida (START)\ny atravesar un enorme tablero lleno "
                + "de fichas que intentarán comerte y enviarte de nuevo al inicio.");
        
    }
    
    public static void desarrollo() throws InterruptedException{
               
        System.out.println("\nAntes de comenzar...\n *Elige un color de fichas y colócalas en la casilla de "
                + "salida correspondiente.\n *Mezcla las cartas.\n *Coloca los discos en el centro del tablero.\n");
        Thread.sleep(7000);
        System.out.println("Durante el juego...\n *Decide quien empieza primero con una ronda de piedra, papel o tijeras. "
                + "Al ganador le continúa el jugador de la izquierda.\n *Roba una carta y sigue las instrucciones.\n "
                + "*Si se terminan las cartas para robar revuelve la baraja y utilízala como una nueva pila para robar.\n"
                + " *Puedes salir de la casilla START con una carta de valor uno o dos.\n");
        Thread.sleep(12000);
        System.out.println("Final de la partida...\n *El primer jugador en llevar sus fichas a \"HOME\" será el ganador.");
        Thread.sleep(3000);
        
        menuinstrucciones();
        
    }
    
    public static void descripcartas() throws InterruptedException{
        
        System.out.println("\nCada carta tiene un número del 1 al 12 y un efecto diferente (excluyendo el 6 y el 9)."
                + "\n 1: Mueve el disco de hielo y adelanta un espacio.\n 2: Mueve el disco de fuego y "
                + "adelanta dos espacios.\n 3: Adelanta tres espacios.\n 4: Retrocede cuatro espacios.\n 5: Adelanta "
                + "cinco espacios.\n 7: Adelanta siete espacios o divídelo en dos partes.\n 8: Adelanta ocho espacios.\n"
                + "10: Adelanta diez espacios o retrocede uno.\n11: Adelanta once espacios o cambia de posición con un "
                + "oponente.\n12: Adelanta doce espacios.\n\nCarta \"Sorry!\":Toma una ficha desde la salida y cambia de "
                + "lugar con un oponente.\n               El oponente debe regresar a la salida o retroceder cuatro espacios.");
        Thread.sleep(30000);
        
        menuinstrucciones();
    }
    
    public static void descripdiscos() throws InterruptedException{
        
        System.out.println("\nDisco de fuego: Este disco tiene dos poderes especiales: "
                + "\n *Puedes adelantar hasta la próxima casilla con un círculo de fuego o "
                + "\n *Si llegas a HOME con el círculo de fuego puedes adelantar otra de tus fichas hasta la meta.");
        System.out.println("Disco de hielo: \n *Este disco congela a la ficha que lo posea. "
                + "No podrá moverse, ser intercambiada o comida por una ficha del adversario.");
        Thread.sleep(13000);
        
        menuinstrucciones();
        
    }
    
    public static void movespeciales() throws InterruptedException{
        
        System.out.println("\n*Brincar: Puedes brincar tus propias fichas o las de tus oponentes si al contar tus"
                + " movimientos puedes rebasar las fichas.\n El movimiento de brincar cuenta como un espacio.\n"
                + "*Chocar: Si al realizar tus movimientos terminas en la misma casilla con tu oponente puedes "
                + "comerte la ficha.\n Esto significa que esa ficha volverá a la casilla de salida.\n"
                + "*Deslizamiento: Cuando al mover tu ficha terminas en el espacio con un triángulo al principio "
                + "del tramo de deslizamiento,\n con el color de tu ficha, puedes deslizarte. "
                + "Todas la fichas que se encuentren en el camino serán comidas y regresadas a la salida.\n "
                + "Si el tramo de deslizamiento no tiene tu color no te podrás deslizar.");
        Thread.sleep(30000);
        
        menuinstrucciones();
        
    }
    
    public static void despedida(){
        System.out.println("Gracias por jugar. Nos vemos en otra ocasión.");
    }
    
}