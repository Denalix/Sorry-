
package GUI;

import java.awt.Component;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;
import BussinesLogic.Sorry;
import Data.Carta;
import Data.Jugador;
import static GUI.UI.datoEquivovado;

public class UICartas {
    
    private static int op;
    private static int numPieza1;
    private static int numPieza2;

    public static int getNumPieza1() {
        return numPieza1;
    }

    public static int getNumPieza2() {
        return numPieza2;
    }
    
    
    
    
    public static void cantMov(Carta carta, Jugador jugador, int numPieza){
        System.out.println("La ficha " + jugador.getJugador()[numPieza].getNombre() + 
                " se ha movido " + carta.getVal() + " espacio/s");
    }
    
    
    public static boolean seleccionPosibleMov7(Jugador jugador, int numPieza){
        if(jugador.getJugador()[numPieza].isSalir()){
            return true; 
        }
        else{
            System.out.println("La ficha " +  jugador.getJugador()[numPieza].getNombre()
                + " no ha salido." + "Por favor vuelva ha ingresar lo datos.");
            return false;
        }
    }
    
    
    
    public static int mov7(){
        System.out.println("Ingresa (1) si quieres mover una ficha 7 espacios o "
                + "(2) si quieres dividir el movimiento entre dos fichas.");
        
        op = JOptionPane.showOptionDialog(null, "Seleccione una opcion",
                 "Selector movimiento 7", JOptionPane.YES_NO_CANCEL_OPTION,
                 JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                 new Object[]{"Mover una ficha 7 espacios", "Dividir el movimiento entre dos fichas"}, "Mover una ficha 7 espacios");
                
        return op + 1;
    }

    public static int preguntaMovimiento7(Jugador jugador) {
        System.out.println("Que ficha/s desea mover?");

        String seleccion;

        seleccion = seleccion(jugador, "elija la ficha que se movera primero");

        for (int i = 0; i < jugador.getJugador().length; i++) {//pasar del nombre de la pieza al numero de la pieza
            if (seleccion.equals(jugador.getJugador()[i].getNombre())) {
                numPieza1 = i;
                jugador.getJugador()[numPieza1].setElegido(true);
                break;
            }
        }

        seleccion = seleccion(jugador, "elija una segunda ficha");

        for (int i = 0; i < jugador.getJugador().length; i++) {//pasar del nombre de la pieza al numero de la pieza
            if (seleccion.equals(jugador.getJugador()[i].getNombre()) && !jugador.getJugador()[i].isElegido()) {
                numPieza2 = i;
                jugador.getJugador()[numPieza2].setElegido(true);
                break;
            }
        }

        showMessageDialog(UITablero.getFrame(), "Ha elegido a " + jugador.getJugador()[numPieza1].getNombre()
                + " y a " + jugador.getJugador()[numPieza2].getNombre());
        
        
        while(true){
           
            System.out.println("Cuanto se debera mover la ficha "
                    + jugador.getJugador()[numPieza1].getNombre());

            try {
                op = Integer.parseInt(showInputDialog("Cuanto se debera mover la ficha " + jugador.getJugador()[numPieza1].getNombre()));
                if (op < 7) {
                    break;
                } else {
                    UI.OpcionNoSoportada();
                }
            } catch (NumberFormatException ex) {
                System.out.println("Problema en el movimiento 7");
            }

            
        }
        
        return op;
        
    }
    
        
    public static String seleccion(Jugador jugador, String string) {

        String[] disponible;
        String seleccion;
        int tam = 0;

        System.out.println("Elija a primera ficha que desea mover");

        for (int i = 0; i < jugador.getJugador().length; i++) {
            if ((jugador.getJugador()[i].isSalir() == true) && (jugador.getJugador()[i].isHome() == false)) {
                tam++;
            }
        }

        disponible = new String[tam];
        for (int i = 0; i < jugador.getJugador().length; i++) {
            if ((jugador.getJugador()[i].isSalir() == true) && (jugador.getJugador()[i].isHome() == false)) {
                System.out.println(jugador.getJugador()[i].getNombre());
                disponible[i] = jugador.getJugador()[i].getNombre();
            }
        }

        seleccion = (String) JOptionPane.showInputDialog(UITablero.getFrame(), string, "Selecion de ficha movimiento multiple", JOptionPane.INFORMATION_MESSAGE, null, disponible, disponible[0]);
        
        return seleccion;
    }
    
    

    
 //   public static int pregunta11(Jugador jugador){
 //       System.out.println("Ingrese (1) si quiere mover una ficha 11 espacios o "
 //               + "ingrese (2) si quiere cambiar una de sus fichas con la de un "
 //               + "oponente.(NO se pueden iintercambiar peones en el inicio).");
 //       
 //       
 //       op = sc.nextInt();
 //       return op;
 //   }
    
 //   public static void cambio(Jugador jugador){
 //       String color;
 //       int pieza;
 //       boolean salir = false;
 //       while(!salir){
 //               System.out.println("Ingrese la ficha que quiere cambiar:");
 //          op = sc.nextInt();
  //          System.out.println("Ingrese el color del jugador con el que quiere intercambiar ficha:");
//            color = sc.nextLine();
 //           if( (color != "rojo") && (color != "amarillo") && (color != "verde") && (color != "azul") ){
 //               datoEquivovado();
 //               continue;
 //           };
 //           System.out.println("Ingrese la ficha con la que quiere intercambiar su ficha:");
 //           pieza = sc.nextInt();
 //           salir = true;
 //       }
 //       
 //   }

     public static void mov10(Carta carta){
        System.out.println("Ingresa (1) si quieres mover una ficha 10 espacios o "
                + "(2) si quieres hacer retorceder una ficha 1.");
        
        
         op = JOptionPane.showOptionDialog(null, "Seleccione una opcion",
                 "Selector movimiento 10", JOptionPane.YES_NO_CANCEL_OPTION,
                 JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                 new Object[]{"Mover una ficha 10", "Mover una ficha -1"}, "Mover una ficha 10");

        
        if(op == 0){
            carta.setVal(10); 
        }
        else{
            carta.setVal(-1);
        }
    }
    
}
