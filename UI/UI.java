

package GUI;

import java.util.Scanner;
import Data.Carta;
import Data.Jugador;
import Data.Pieza;
import Data.Tablero;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

public class UI {
    
    private static int op;
    

    
    
    public static void jugar(int j){
        
        System.out.println("\nOk, entonces... Preparados o no, COMIENZA EL JUEGO!");
        System.out.println("");
        //Vista del tablero
    }

    
    
    
    
    
    
    //---------------------------------------------------------------------------------
  
    

    public static void mostrarCarta(Carta carta){
        System.out.println("La carta sacada es ..." + carta.getVal());
    }
   
    public static void mostrarCartaSorry(){
        System.out.println("La carta sacada es ... sorry");
    }
    
    public static void mostrarTurno(Jugador jugador){
        System.out.println("Turno del jugador " + jugador.getColor());
    }
   
   
    
    public static void datoEquivovado(){
        System.out.println("Uno de los datos que ingreso no concuerda. Por favor ingrelos de nuevo.");
    }
    
    public static void Despedida(){
        System.out.println("Muchas gracias por jugar. Esperamos que vuelvas pronto");
    }
    
    public static void Instrucciones(){
        System.out.println("Aqui van las instrucciones.");
    }
    
    public static void OpcionNoSoportada(){
        System.out.println("No ingresaste una opcion valida, intentalo de nuevo.");
        showMessageDialog(UITablero.getFrame(), "No ingresaste una opcion valida, intentalo de nuevo.");
    }
    
    public static void posActual(Jugador jugador){
        System.out.println("La posicion actual de sus fichas es:");
        for(int i = 0; i < jugador.getJugador().length; i++){
            System.out.println("ficha "+ jugador.getJugador()[i].getNombre() + " en posicion " + jugador.getJugador()[i].getPos());
        }
    }
    
    public static void ganador(Jugador jugador){
        System.out.println("El jugador " + jugador.imprimirColor(jugador.getColor()) + 
                jugador.getColor() + " es el ganador.");
    }
    
    
    public static boolean seleccionPosible(Jugador jugador){
        if(jugador.getJugador()[op].isSalir()){
            return true; 
        }
        else{
            System.out.println("La ficha " +  jugador.getJugador()[op].getNombre()
                     + " no ha salido." +  "Por favor vuelva ha ingresar lo datos.");
            return false;
        }
    }
    
    //---------------------------------------------------------------------------
    
    
    
    public static void noPiezasLibres(){
        JOptionPane.showMessageDialog(null, null, "No tienes fichas libres, no puedes mover.", JOptionPane.INFORMATION_MESSAGE, null);
    }
    
    
    
    
    
    
    //---------------------------------------------------------------------------
    
    
     public static int preguntaSalida(){
         
        int seleccion;
        
        System.out.println("ingrese (1) si desea sacar a una ficha de la salida o"
                + " (2) si desea mover una ficha?");
        
        
         seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opcion",
                 "Selector de salida", JOptionPane.YES_NO_CANCEL_OPTION,
                 JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                 new Object[]{"Sacar una ficha", "Mover una Ficha"}, "Sacar una ficha");

        
         System.out.println("Retorno de funcion " + String.valueOf(seleccion));
         
        return seleccion + 1;
    }
     
     
    
     public static void movimientoSalida(Jugador jugador){
        boolean salir = false;
        int i = 0;
        while(!salir){
            if(jugador.getJugador()[i].isSalir() == false){
                System.out.println("La ficha " + jugador.getJugador()[i].getNombre() 
                        + " se ha movido de la salida a la casilla " + 
                        jugador.getCasillaSalida() );
                
                jugador.getJugador()[i].setSalir(true);
                
                jugador.getJugador()[i].setPos(jugador.getCasillaSalida());
                salir = true;
            }
            i++;
        }
    }
    
    public static String preguntaMovimiento(Jugador jugador){
        
        String[] disponible;
        String seleccion;
        int tam = 0;
        while(true){
            System.out.println("Que ficha desea mover?");
            for(int i = 0; i < jugador.getJugador().length; i++){
                if( (jugador.getJugador()[i].isSalir() ==  true) && (jugador.getJugador()[i].isHome() ==  false) ){
                   tam++;
                }
            }
            disponible = new String[tam];
            for(int i = 0; i < jugador.getJugador().length; i++){
                if( (jugador.getJugador()[i].isSalir() ==  true) && (jugador.getJugador()[i].isHome() ==  false) ){
                   System.out.println(jugador.getJugador()[i].getNombre());
                   disponible[i] = jugador.getJugador()[i].getNombre();
                }
            }
            
            seleccion = (String)JOptionPane.showInputDialog(UITablero.getFrame(), "Que ficha desea mover?", "Selecion ficha a mover", JOptionPane.INFORMATION_MESSAGE, null, disponible, disponible[0]);
            
            
            
            break;
        }
        
        return seleccion;
    }
     
    public static void movPiezaUnica(Jugador jugador, Carta carta){
        for(int i =0; i<jugador.getJugador().length; i++){
            if(jugador.getJugador()[i].isSalir() == true){
                System.out.println("La ficha " + jugador.imprimirColor(jugador.getColor())
                        + jugador.getJugador()[i].getNombre() + " se ha movido " +
                        (jugador.getJugador()[i].getPos()-carta.getVal()) + 
                        "de la salida.");
            }
        }
        
    }
   
 
}
