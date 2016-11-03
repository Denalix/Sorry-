
package sorry.BussinesLogic;

import sorry.Data.Carta;
import sorry.Data.Jugador;
import sorry.Data.Tablero;
import sorry.UI.UI;

public class ControladorDeMovimiento {
    
    private static boolean repetir = false;
    private static int numPieza;

    public static boolean movimiento(Carta carta, Jugador jugador){
        
        if("sorry".equals(carta.getTipo())){
            UI.mostrarCartaSorry();
            System.out.println("Sorryyyyy");
            repetir = false;
        }
        
        UI.mostrarCarta(carta);
        
        switch( Math.abs(carta.getVal()) ){
            case 1:
                cartaSalida(carta, jugador);
                repetir = false;
                UI.posActual(jugador);
                break;
            case 2:
                cartaSalida(carta, jugador);
                repetir = true;
                UI.posActual(jugador);
                break;
            case 3:
                numPieza = movida(carta, jugador);
                casillaDash(jugador, numPieza);
                repetir = false;
                UI.posActual(jugador);
                break;
            case 4:
                numPieza = movida(carta, jugador);
                casillaDash(jugador, numPieza);
                repetir = false;
                UI.posActual(jugador);
                break;
            case 5:
                numPieza = movida(carta, jugador);
                casillaDash(jugador, numPieza);
                repetir = false;
                UI.posActual(jugador);
                break;
            case 7:
                if(jugador.getPiezasLibres() > 1){
                    int op = UI.mov7();
                    if(op == 1){
                        numPieza = movida(carta, jugador);
                        casillaDash(jugador, numPieza);
                    }
                    else{
                        UI.preguntaMovimiento7(jugador);
                        UI.movDoble(jugador);
                        casillaDash(jugador, UI.getNumPieza1());
                        casillaDash(jugador, UI.getNumPieza2());
                    }
                }
                else{
                    movida(carta,jugador);
                }
                repetir = false;
                UI.posActual(jugador);
                break;
            case 8:
                numPieza = movida(carta, jugador);
                casillaDash(jugador, numPieza);
                repetir = false;
                UI.posActual(jugador);
                break;
            case 10:
                UI.mov10(carta);
                numPieza = movida(carta, jugador);
                casillaDash(jugador, numPieza);
                repetir = false;
                UI.posActual(jugador);
                break;
            case 11:
                if(UI.pregunta11(jugador) == 2){
                    System.out.println("El once no esta soportado.");
                }
                else{
                    numPieza = movida(carta, jugador);
                    casillaDash(jugador, numPieza);
                }
                repetir = false;
                UI.posActual(jugador);
                break;
            case 12:
                numPieza = movida(carta, jugador);
                casillaDash(jugador, numPieza);
                repetir = false;
                UI.posActual(jugador);
                break;
        }
        return repetir;
    }
    
    public static void movidaDoble(Jugador jugador, Carta carta){
        for(int i = 0; i < jugador.getJugador().length; i++){
            if(jugador.getJugador()[i].isElegido() == true){
                
            }
        }
    }
    
    public static int movida(Carta carta, Jugador jugador){
        int numPieza = 0;
        if(jugador.getPiezasLibres() > 0){
            if(jugador.getPiezasLibres() == 1){
                for(int i = 0; i < Math.abs(carta.getVal()); i++){
                    if(jugador.getJugador()[numPieza].isSalir() == true){
                        jugador.getJugador()[numPieza].mover(carta, jugador, numPieza);
                    }
                    
                    //aqui va algo que muestre en la interfaz como se mueve casilla a casilla
                }
                UI.cantMov(carta, jugador, numPieza);
            }
            
            else{
                numPieza = UI.preguntaMovimiento(jugador);
            
                for(int i = 0; i < Math.abs(carta.getVal()); i++){
                    jugador.getJugador()[numPieza].mover(carta, jugador, numPieza);
                    //aqui va algo que muestre en la interfaz como se mueve casilla a casilla
                }
                UI.cantMov(carta, jugador, numPieza);            }
        }
        
        
        
        else{
            numPieza = -1;
            UI.noPiezasLibres();
        }
        return numPieza;
        
    }
    
    public static void cartaSalida(Carta carta, Jugador jugador){
        if(jugador.getPiezasLibres() == 0){
                UI.movimientoSalida(jugador);
            }
            else if( (jugador.getPiezasLibres() > 0) && (jugador.getPiezasLibres() < 4) ){
                boolean salir = false;
                while(!salir){
                    switch(UI.preguntaSalida()){
                    case 1:
                        UI.movimientoSalida(jugador);
                        salir = true;
                        break;
                    case 2:
                        numPieza = movida(carta, jugador);
                        casillaDash(jugador, numPieza);
                        salir = true;
                        break;
                    default:
                        UI.OpcionNoSoportada();
                        continue;
                    }
                }
        }
    }
    
    public static void dash(Jugador jugador, int numPieza){
        if( (jugador.getJugador()[numPieza].getPos() == 1) || 
             (jugador.getJugador()[numPieza].getPos() == 16) || 
             (jugador.getJugador()[numPieza].getPos() == 31) ||
             (jugador.getJugador()[numPieza].getPos() == 46)){
            
            jugador.getJugador()[numPieza].setPos(jugador.getJugador()[numPieza].getPos() + 3);
            
        }
        else if( (jugador.getJugador()[numPieza].getPos() == 1) || 
                  (jugador.getJugador()[numPieza].getPos() == 16) || 
                  (jugador.getJugador()[numPieza].getPos() == 31) ||
                  (jugador.getJugador()[numPieza].getPos() == 46)){
            
            jugador.getJugador()[numPieza].setPos(jugador.getJugador()[numPieza].getPos() + 4);
            
        }
    }
    
    public static void casillaDash(Jugador jugador, int numPieza){
        if(numPieza > 0){
            if( (jugador.getJugador()[numPieza].getPos() == 1) ||
                        (jugador.getJugador()[numPieza].getPos() == 9) ){
                    
                    if(!"rojo".equals(jugador.getJugador()[numPieza].getColor())){
                        dash(jugador, numPieza);
                    }
                }
                if( (jugador.getJugador()[numPieza].getPos() == 16) ||
                        (jugador.getJugador()[numPieza].getPos() == 24) ){
                    
                    if(!"azul".equals(jugador.getJugador()[numPieza].getColor())){
                        dash(jugador, numPieza);
                    }
                }
                if( (jugador.getJugador()[numPieza].getPos() == 31) ||
                        (jugador.getJugador()[numPieza].getPos() == 39) ){
                    
                    if(!"verde".equals(jugador.getJugador()[numPieza].getColor())){
                        dash(jugador, numPieza);
                    }
                }
                if( (jugador.getJugador()[numPieza].getPos() == 46) ||
                        (jugador.getJugador()[numPieza].getPos() == 55) ){
                    
                    if(!"amarillo".equals(jugador.getJugador()[numPieza].getColor())){
                        dash(jugador, numPieza);
                    }
                }
        }
        
    }
}
