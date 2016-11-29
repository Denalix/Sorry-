
package BussinesLogic;

import Data.Jugador;
import Data.Tablero;
import GUI.UI;

public class ControlVictoria {
    
    public static boolean victoria(Jugador jugador){
        llegadaHome(jugador);
        boolean gano = false;
        int ganador = 0;
        for(int i = 0; i < jugador.getJugador().length; i++){
            if(jugador.getJugador()[i].isHome() == true){
                ganador++;
            }
             if(ganador == 4){
                 gano = true;
                 UI.ganador(jugador);
             }
        }
        
        return gano;
    }
    
    
    public static void llegadaHome(Jugador jugador){
        
        for(int i =0; i < jugador.getJugador().length; i++){
            for(int j = 0; j < Sorry.getTablero().getCasillaHome().length; j++){
                jugadorEnHome(jugador, Sorry.getTablero().getCasillaHome()[j]);
            }
        }
    }
    
    public static void jugadorEnHome(Jugador jugador, int posHome){
        for(int i = 0; i < jugador.getJugador().length; i++){
            if( jugador.getJugador()[i].getPos() == posHome){
                jugador.getJugador()[i].setHome(true);
                jugador.getJugador()[i].setSalir(false);
                System.out.println("La pieza " + jugador.getJugador()[i].getNombre() + " llego a home");
            }
        }
    }
}

    
