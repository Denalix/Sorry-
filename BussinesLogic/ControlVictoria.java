
package sorry.BussinesLogic;

import sorry.Data.Jugador;
import sorry.UI.UI;

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
            if("rojo".equals(jugador.getColor()) ){
                
                jugadorEnHome(jugador, 66);
            }
            if("azul".equals(jugador.getColor()) ){
                
                jugadorEnHome(jugador, 72);
            }
            if("verde".equals(jugador.getColor()) ){
                
                jugadorEnHome(jugador, 78);
            }
            if("amarillo".equals(jugador.getColor()) ){
                
                jugadorEnHome(jugador, 84);
            }
               
    }
    
    public static void jugadorEnHome(Jugador jugador, int posHome){
        for(int i = 0; i < jugador.getJugador().length; i++){
            if( jugador.getJugador()[i].getPos() == posHome){
            
                jugador.getJugador()[i].setHome(true);
            }
        }
    }
}

    
