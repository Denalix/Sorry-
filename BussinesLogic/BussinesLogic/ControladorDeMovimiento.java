
package BussinesLogic;

import java.awt.Color;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import Data.Carta;
import Data.Jugador;
import Data.Tablero;
import GUI.UI;
import GUI.UICartas;

public class ControladorDeMovimiento {
    
    private static boolean repetir = false;
    private static int numPieza;
    private static JOptionPane pane = new JOptionPane();
    private static final String imagen = "src/Imagenes/casillas/dash.jpg";
    private static final String imagenDash = "src/Imagenes/casillas/dash.jpg";
    private static final String imagenCarta1 = "src/PF_cartas/C1.jpg";
    private static final String imagenCarta2 = "src/PF_cartas/C2.jpg";
    private static final String imagenCarta3 = "src/PF_cartas/C3.jpg";
    private static final String imagenCarta4 = "src/PF_cartas/C4.jpg";
    private static final String imagenCarta5 = "src/PF_cartas/C5.jpg";
    private static final String imagenCarta7 = "src/PF_cartas/C7.jpg";
    private static final String imagenCarta8 = "src/PF_cartas/C8.jpg";
    private static final String imagenCarta10 = "src/PF_cartas/C10.jpg";
    private static final String imagenCarta11 = "src/PF_cartas/C11.jpg";
    private static final String imagenCarta12 = "src/PF_cartas/C12.jpg";

    public static boolean movimientoCarta(Carta carta, Jugador jugador) throws IOException{
    
        String mensajeTurno = "Turno de " + Sorry.getColorJugadorActual();

        
        if("sorry".equals(carta.getTipo())){
            UI.mostrarCartaSorry();
            cartaSorry(jugador);
            repetir = false;
        }

        UI.mostrarCarta(carta);

        if (posMayorHome(jugador, carta)) {
            switch (Math.abs(carta.getVal())) {
                case 1:

                    pane.showMessageDialog(null, null, mensajeTurno, numPieza, new ImageIcon(imagenCarta1));

                    cartaSalida(carta, jugador);
                    repetir = false;
                    break;
                case 2:
                    pane.showMessageDialog(null, null, mensajeTurno, numPieza, new ImageIcon(imagenCarta2));
                    cartaSalida(carta, jugador);
                    repetir = true;
                    break;
                case 3:
                    pane.showMessageDialog(null, null, mensajeTurno, numPieza, new ImageIcon(imagenCarta3));
                    movida(carta, jugador);
                    repetir = false;
                    break;
                case 4:
                    pane.showMessageDialog(null, null, mensajeTurno, numPieza, new ImageIcon(imagenCarta4));
                    movida(carta, jugador);
                    repetir = false;

                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, null, mensajeTurno, numPieza, new ImageIcon(imagenCarta5));
                    movida(carta, jugador);
                    repetir = false;
                    break;
                case 7:
                    pane.showMessageDialog(null, null, mensajeTurno, numPieza, new ImageIcon(imagenCarta7));
                    if (jugador.getPiezasLibres() > 1) {
                        int op = UICartas.mov7();
                        if (op == 1) {
                            movida(carta, jugador);
                        } else {
                            movida(carta, jugador);
                        }
                    } else {
                        movida(carta, jugador);
                    }
                    repetir = false;
                    break;
                case 8:

                    pane.showMessageDialog(null, null, mensajeTurno, numPieza, new ImageIcon(imagenCarta8));
                    movida(carta, jugador);
                    repetir = false;
                    UI.posActual(jugador);
                    break;
                case 10:
                    pane.showMessageDialog(null, null, mensajeTurno, numPieza, new ImageIcon(imagenCarta10));
                    if (jugador.getPiezasLibres() > 0) {
                        UICartas.mov10(carta);
                        movida(carta, jugador);
                    }
                    repetir = false;
                    UI.posActual(jugador);
                    break;
                case 11:
                    pane.showMessageDialog(null, null, mensajeTurno, numPieza, new ImageIcon(imagenCarta11));
                    movida(carta, jugador);
                    repetir = false;
                    UI.posActual(jugador);
                    break;
                case 12:
                    pane.showMessageDialog(null, null, mensajeTurno, numPieza, new ImageIcon(imagenCarta12));
                    movida(carta, jugador);
                    repetir = false;
                    UI.posActual(jugador);
                    break;
            }
        }
        else{
            pane.showMessageDialog(null, "Tiene que sacar un numero exacto para entrar al home", "Problem?",JOptionPane.INFORMATION_MESSAGE, null);
        }
        return repetir;
    }
    
    
    public static void cartaSorry(Jugador jugador){
        if(jugador.getPiezasLibres() > 0){
            for(int i = 0; i < jugador.getJugador().length; i++){
                if(jugador.getJugador()[i].isSalir()){
                    jugador.getJugador()[i].setPos(jugador.getPosInicial());
                    jugador.getJugador()[i].setSalir(false);
                    jugador.getJugador()[i].setPoint(Sorry.getTablero().getTableroPoint()[jugador.getJugador()[i].getPos()]);
                    break;
                }
            }
        }
        else{
            UI.noPiezasLibres();
        }
    }
    
    
    public static int movida(Carta carta, Jugador jugador) throws IOException{
        int numPieza = 0;
        if(jugador.getPiezasLibres() > 0){
            if(jugador.getPiezasLibres() == 1){
                for(int i = 0; i < Math.abs(carta.getVal()); i++){
                    if( (jugador.getJugador()[numPieza].isSalir() == true) && (jugador.getJugador()[numPieza].isHome() == false) ){
                        jugador.getJugador()[numPieza].mover(carta, jugador, numPieza);
                    }
                }
                UICartas.cantMov(carta, jugador, numPieza);
            } 
            
            else if ( (carta.getVal() == 7) && (jugador.getPiezasLibres() != 1) ) {
                int cantidadMovimiento = UICartas.preguntaMovimiento7(jugador);
                int numPieza1 = UICartas.getNumPieza1();
                int numPieza2 = UICartas.getNumPieza2();

                for (int i = 0; i < cantidadMovimiento; i++) {
                    jugador.getJugador()[numPieza1].mover(carta, jugador, numPieza1);
                }
                for (int i = 0; i < (7 - cantidadMovimiento); i++) {
                    jugador.getJugador()[numPieza2].mover(carta, jugador, numPieza2);
                }
                
                UICartas.cantMov(carta, jugador, numPieza1);
                UICartas.cantMov(carta, jugador, numPieza2);
                
            } 
            else {
                
                String seleccion = UI.preguntaMovimiento(jugador);
                
                for(int i = 0; i < jugador.getJugador().length; i++){//pasar del nombre de la pieza al numero de la pieza
                    if(seleccion.equals(jugador.getJugador()[i].getNombre())){
                        numPieza = i;
                        break;
                    }
                }
                
                

                for (int i = 0; i < Math.abs(carta.getVal()); i++) {
                    jugador.getJugador()[numPieza].mover(carta, jugador, numPieza);
                }
                UICartas.cantMov(carta, jugador, numPieza);
            }
        }
        
        else{
            numPieza = -1;
            UI.noPiezasLibres();
        }
        
        
        casillaDash(jugador, numPieza);
        return numPieza;
        
    }
    
    public static void cartaSalida(Carta carta, Jugador jugador) throws IOException{
        
        
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
                    movida(carta, jugador);
                    salir = true;
                    break;
                default:
                    UI.OpcionNoSoportada();
                    continue;
                }
            }
        }
        
        else{
            movida(carta, jugador);
        }
    }
    
    
    public static void casillaDash(Jugador jugador, int numPieza) throws IOException{//verificacion de si la casilla es de dash
        if(numPieza >= 0){
            
            if(Sorry.getTablero().isDash(jugador.getJugador()[numPieza].getPos())){
                dash(jugador, numPieza);
            }  
        }
    }
    
    
    public static void dash(Jugador jugador, int numPieza) throws IOException{
        if(Sorry.getTablero().isDash3(jugador.getJugador()[numPieza].getPos())){
            JOptionPane.showMessageDialog(null, 3, "Dash", numPieza, new ImageIcon(imagenDash));
            for(int i = 0; i < 3; i++){
                jugador.getJugador()[numPieza].moverDash(jugador, numPieza);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, 3, "Dash", numPieza, new ImageIcon(imagenDash));
            for(int i = 0; i < 4; i++){
                jugador.getJugador()[numPieza].moverDash(jugador, numPieza);
            }
        }
    }
    
    
    
    public static void fichaMismoLugar2Jugadores(Jugador jugador1, Jugador jugador2){
        
        for(int i = 0; i < jugador1.getJugador().length; i++){
            for(int j = 0; j < jugador1.getJugador().length; j++){
                
                if(jugador1.getJugador()[i].getPos() == jugador2.getJugador()[j].getPos()) {
                    mismoLugar(jugador1, jugador2, i, j);
                }
            }
        }
    }
    public static void fichaMismoLugar3Jugadores(Jugador jugador1, Jugador jugador2, Jugador jugador3){
        
        fichaMismoLugar2Jugadores(jugador1, jugador2);
        
        for(int i = 0; i < jugador1.getJugador().length; i++){
            for(int j = 0; j < jugador1.getJugador().length; j++){
                if (jugador1.getJugador()[i].getPos() == jugador3.getJugador()[i].getPos()) {
                    mismoLugar(jugador1, jugador3, i, j);
                } 
                else if (jugador2.getJugador()[i].getPos() == jugador3.getJugador()[i].getPos()) {
                    mismoLugar(jugador2, jugador3, i, j);
                }
            }
        }
    }
    public static void fichaMismoLugar4Jugadores(Jugador jugador1, Jugador jugador2, Jugador jugador3, Jugador jugador4){
        
        fichaMismoLugar2Jugadores(jugador1, jugador2);
        fichaMismoLugar3Jugadores(jugador1, jugador2, jugador3);
        
        for(int i = 0; i < jugador1.getJugador().length; i++){
            for(int j = 0; j < jugador1.getJugador().length; j++){
                if (jugador1.getJugador()[i].getPos() == jugador4.getJugador()[i].getPos()) {
                    mismoLugar(jugador1, jugador4, i, j);
                }
                else if (jugador2.getJugador()[i].getPos() == jugador4.getJugador()[i].getPos()) {
                    mismoLugar(jugador2, jugador4, i, j);
                }
                else if (jugador3.getJugador()[i].getPos() == jugador4.getJugador()[i].getPos()) {
                    mismoLugar(jugador3, jugador4, i, j);
                }
            }
        }
    }
    
    public static void mismoLugar(Jugador jugadorX, Jugador jugadorY, int i, int j){
        if(jugadorX.getColor().equals(Sorry.getColorJugadorActual())){
                    jugadorY.getJugador()[j].setPos(jugadorY.getPosInicial());
                    jugadorY.getJugador()[j].setPoint(Sorry.getTablero().getTableroPoint()[jugadorY.getJugador()[j].getPos()]);
                    jugadorY.getJugador()[j].setSalir(false);
                    jugadorY.getJugador()[j].setVuelta(false);
                    jugadorY.getJugador()[j].setNumeroVueltas(0);
                }
                else{
                    jugadorX.getJugador()[i].setPos(jugadorX.getPosInicial());
                    jugadorX.getJugador()[i].setPoint(Sorry.getTablero().getTableroPoint()[jugadorX.getJugador()[i].getPos()]);
                    jugadorX.getJugador()[i].setSalir(false);
                    jugadorX.getJugador()[i].setVuelta(false);
                    jugadorX.getJugador()[i].setNumeroVueltas(0);
                }
    }
    
    public static boolean posMayorHome(Jugador jugador, Carta carta) {
        for (int i = 0; i < jugador.getJugador().length; i++) {
            if( (jugador.getJugador()[i].getPos() + Math.abs(carta.getVal()) > jugador.getJugador()[i].getCasillaHome()) && (jugador.getJugador()[i].isSalir() == true)){
                return false;
            }
        }
        return true;
    }


}
