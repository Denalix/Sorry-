
package BussinesLogic;

import java.awt.AWTException;
import java.awt.Color;
import java.io.IOException;
import javax.swing.*;

import Data.*;
import GUI.UI;
import GUI.UITablero;

public class Sorry extends JPanel{
    
    
    private static int numJugadores;
    private static final Jugador[] jugador = new Jugador[4];
    private static Jugador jugadorX = new Jugador();
    private static final String[] colorJugador = {"azul", "amarillo", "verde", "rojo"};
    private static Tablero tablero;
    private static Carta carta;
    private static String colorJugadorActual;
    private static UITablero uiTablero;
    private static JFrame frame;
    private static boolean repetir = true;
    private static boolean seguir = false;

    public static Jugador getJugadorX() {
        return jugadorX;
    }

    public static void setJugadorX(Jugador jugadorX) {
        Sorry.jugadorX = jugadorX;
    }
    
    
    
    
    public static String[] getColorJugador() {
        return colorJugador;
    }
    
    
    public static Tablero getTablero() {
        return tablero;
    }

    public static Jugador[] getJugador() {
        return jugador;
    }

    public static String getColorJugadorActual() {
        return colorJugadorActual;
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static int getNumJugadores() {
        return numJugadores;
    }
    
    
    
    public static void crearJugadorYColor(){
        
        for(int j = 0; j < 4; j++){
            jugador[j] = new Jugador(colorJugador[j], tablero.getCasillaInicio()[j],tablero.getCasillaSalida()[j], tablero.getTableroPoint()[tablero.getCasillaInicio()[j]], j, tablero.getCasillaHome()[j]);
        }
        
    }

    public static UITablero getUiTablero() {
        return uiTablero;
    }

    public static Carta getCarta() {
        return carta;
    }

    public static void setCarta(Carta carta) {
        Sorry.carta = carta;
    }
    
    
    
    
    public static void main() throws InterruptedException, IOException, AWTException{
        
        empezar();
    }
    
    public static void empezar() throws InterruptedException, IOException, AWTException{
        
        
        
        setUp();
    }
    
    public static void setUp() throws InterruptedException, IOException, AWTException{
        
        tablero = new Tablero();
        uiTablero = new UITablero();
        crearJugadorYColor();
        boolean rep = false;
        
        while(!rep){
            
            UITablero.imprimirTablero(tablero, jugador);
            JOptionPane.showMessageDialog(null, "COMIEZA EL JUEGO!", "Empezar", 1, new ImageIcon("src/Imagenes/pokemon/pokemonesAzul/gyarados.png"));
            
            switch(numJugadores){
            case 0:
                rep = true;
                break;
            case 2:
                jugar2();
                rep = true;
                break;
            case 3:
                jugar3();
                rep = true;
                break;
            case 4:
                jugar4();
                rep = true;
                break;
            default:
                UI.OpcionNoSoportada();
            }
        }
        
        
    }
    
    public static void jugar4() throws IOException{
        boolean repetir = true;
        boolean gano = false;
        while(!gano){
            jugar(jugador[0], repetir, gano);
            jugar(jugador[1], repetir, gano);
            jugar(jugador[2], repetir, gano);
            jugar(jugador[3], repetir, gano);
        }
    }
    
    public static void jugar3() throws IOException{
        boolean repetir = true;
        boolean gano = false;
        while(!gano){
            
            jugar(jugador[0], repetir, gano);
            jugar(jugador[1], repetir, gano);
            jugar(jugador[2], repetir, gano);
        }
    }
    
    public static void jugar2() throws IOException{
        boolean repetir = true;
        boolean gano = false;
            while(!gano){
                jugar(jugador[0], repetir, gano);
                jugar(jugador[1],repetir,gano);
            }
    }
    
    
    
    public static void jugar(Jugador jugadorActual, boolean repetir, boolean gano) throws IOException{
     
        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
            System.err.println("Problemassssss");
        }
        
        
        
        while (repetir) {
            jugadorX = jugadorActual;
            colorJugadorActual = jugadorActual.getColor();
            UI.mostrarTurno(jugadorActual);
            UI.posActual(jugadorActual);
            UITablero.imprimirTablero(tablero, jugador);
            
            
            JOptionPane.showMessageDialog(null, "Pulsa Aceptar para sacar una carta", "Turno del jugador " + jugadorActual.getColor(), 1, new ImageIcon("src/Imagenes/pokemon/pokemonesAzul/gyarados.png"));
            try{
                Thread.sleep(2000);
            }catch(Exception ex){
                System.err.println("Problemassssss");
            }
            repetir = ControladorDeMovimiento.movimientoCarta(jugadorActual.sacarCarta(carta), jugadorActual);
            gano = ControlVictoria.victoria(jugadorActual);
            controlMismoLugar();
            UI.posActual(jugadorActual);
            System.out.println("--------------------------");
            System.out.println("--------------------------");
            UITablero.setTablero(tablero, jugador);
            UITablero.getFrame().repaint();
            UITablero.getFrame().revalidate();
        }
    }

    public static boolean isSeguir() {
        return seguir;
    }

    public static void setSeguir(boolean seguir) {
        Sorry.seguir = seguir;
    }
   
    public static void controlMismoLugar() { //sirve para saber cual control de mismoLugar debe usar
        switch (Sorry.getNumJugadores()) {
            case 2:
                ControladorDeMovimiento.fichaMismoLugar2Jugadores(Sorry.getJugador()[0], Sorry.getJugador()[1]);
                break;
            case 3:
                ControladorDeMovimiento.fichaMismoLugar3Jugadores(Sorry.getJugador()[0], Sorry.getJugador()[1], Sorry.getJugador()[2]);
                break;
            default:
                ControladorDeMovimiento.fichaMismoLugar4Jugadores(Sorry.getJugador()[0], Sorry.getJugador()[1], Sorry.getJugador()[2], Sorry.getJugador()[3]);
                break;
        }
    }

    public static void setNumJugadores(int numJugadores) {
        Sorry.numJugadores = numJugadores;
    }
    
    
    
}
