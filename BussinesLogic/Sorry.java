
package sorry.BussinesLogic;

import sorry.Data.*;
import sorry.UI.Operaciones;
import sorry.UI.UI;

public class Sorry {
    
    private static int numJugadores;
    private static Jugador jugador1;
    private static Jugador jugador2;
    private static Jugador jugador3;
    private static Jugador jugador4;
    private static Tablero tablero;
    private static Carta carta;
    
    
    
    public static void main(String[] args) throws InterruptedException {
        empezar();
    }
    
    public static void empezar() throws InterruptedException{
        
        Operaciones.bienvenida();
        numJugadores = Operaciones.menu();
        
        setUp();
    }
    
    public static void setUp() throws InterruptedException{
        
        tablero = new Tablero(0);
        boolean rep = false;
        while(!rep){
            switch(numJugadores){//puse todos los jugadores excepto el rojo como cpu por default
            case 2:
                //int numMaq1 = UI.NumDeMaq();
                jugador1 = new Jugador(tablero, "rojo", 84, true, 4);
                jugador2 = new Jugador(tablero, "azul", 85, false, 19);
                rep = true;
                break;
            case 3:
                //int numMaq2 = UI.NumDeMaq();
                jugador1 = new Jugador(tablero, "rojo", 84, true, 4);
                jugador2 = new Jugador(tablero, "azul", 85, false, 19);
                jugador3 = new Jugador(tablero, "verde", 86, false, 34);
                rep = true;
                break;
            case 4:
                //int numMaq3 = UI.NumDeMaq();
                jugador1 = new Jugador(tablero, "rojo", 84, true, 4);
                jugador2 = new Jugador(tablero, "azul", 85, false, 19);
                jugador3 = new Jugador(tablero, "verde", 86, false, 34);
                jugador4 = new Jugador(tablero, "amarillo", 87, false, 49);
                rep = true;
                break;
            default:
                UI.OpcionNoSoportada();
            }
        }
        
        if(numJugadores == 2){
            jugar2();
        }
        else if(numJugadores == 3){
            jugar3();
        }
        else{
            jugar4();
        }
        
    }
    
    public static void jugar4(){
        boolean repetir = true;
        boolean gano = false;
        UI.sc.nextLine();
        while(!gano){
            repetir = true;
            while(repetir){
                //UI.imprimirTablero(tablero, jugador1);
                UI.mostrarTurno(jugador1);
                UI.posActual(jugador1);
                UI.waitForEnter();
                repetir = ControladorDeMovimiento.movimiento(jugador1.sacarCarta(carta), jugador1);
                gano = ControlVictoria.victoria(jugador1);
                tablero.UpdateCasilla(jugador1);
            }
            
            repetir = true;
            while(repetir){
                UI.mostrarTurno(jugador2);
                UI.posActual(jugador2);
                UI.waitForEnter();
                repetir = ControladorDeMovimiento.movimiento(jugador2.sacarCarta(carta), jugador2);
                gano = ControlVictoria.victoria(jugador2);
                tablero.UpdateCasilla(jugador2);
            }
            
            repetir = true;
            while(repetir){
                UI.mostrarTurno(jugador3);
                UI.posActual(jugador3);
                UI.waitForEnter();
                repetir = ControladorDeMovimiento.movimiento(jugador3.sacarCarta(carta), jugador3);
                gano = ControlVictoria.victoria(jugador3);
                tablero.UpdateCasilla(jugador3);
            }
            
            repetir = true;
            while(repetir){
                UI.mostrarTurno(jugador4);
                UI.posActual(jugador4);
                UI.waitForEnter();
                repetir = ControladorDeMovimiento.movimiento(jugador4.sacarCarta(carta), jugador4);
                gano = ControlVictoria.victoria(jugador4);
                tablero.UpdateCasilla(jugador4);
            }
        }
    }
    
    public static void jugar3(){
        boolean repetir = true;
        boolean gano = false;
        UI.sc.nextLine();
        while(!gano){
            repetir = true;
            while(repetir){
                //UI.imprimirTablero(tablero, jugador1);
                UI.mostrarTurno(jugador1);
                UI.posActual(jugador1);
                UI.waitForEnter();
                repetir = ControladorDeMovimiento.movimiento(jugador1.sacarCarta(carta), jugador1);
                gano = ControlVictoria.victoria(jugador1);
                tablero.UpdateCasilla(jugador1);
            }
            
            repetir = true;
            while(repetir){
                UI.mostrarTurno(jugador2);
                UI.posActual(jugador2);
                UI.waitForEnter();
                repetir = ControladorDeMovimiento.movimiento(jugador2.sacarCarta(carta), jugador2);
                gano = ControlVictoria.victoria(jugador2);
                tablero.UpdateCasilla(jugador2);
            }
            
            repetir = true;
            while(repetir){
                UI.mostrarTurno(jugador3);
                UI.posActual(jugador3);
                UI.waitForEnter();
                repetir = ControladorDeMovimiento.movimiento(jugador3.sacarCarta(carta), jugador3);
                gano = ControlVictoria.victoria(jugador3);
                tablero.UpdateCasilla(jugador3);
            }
        }
    }
    
    public static void jugar2(){
        boolean repetir = true;
        boolean gano = false;
        if(numJugadores == 2){
            UI.sc.nextLine();
            while(!gano){
                repetir = true;
               while(repetir){
                   //UI.imprimirTablero(tablero, jugador1);
                    UI.mostrarTurno(jugador1);
                    UI.posActual(jugador1);
                    UI.waitForEnter();
                    repetir = ControladorDeMovimiento.movimiento(jugador1.sacarCarta(carta), jugador1);
                    gano = ControlVictoria.victoria(jugador1);
                    tablero.UpdateCasilla(jugador1);
                }
            
                repetir = true;
                while(repetir){
                    UI.mostrarTurno(jugador2);
                   UI.posActual(jugador2);
                   UI.waitForEnter();
                   repetir = ControladorDeMovimiento.movimiento(jugador2.sacarCarta(carta), jugador2);
                   gano = ControlVictoria.victoria(jugador2);
                   tablero.UpdateCasilla(jugador2);
                }
            }
        }
    }
}
