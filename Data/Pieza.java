
package Data;

import java.awt.Point;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import BussinesLogic.ControladorDeMovimiento;
import BussinesLogic.Sorry;
import GUI.UITablero;
import static GUI.UITablero.posicionLabel;


public class Pieza extends Jugador{
    
    private int pos;
    private int casillaHome;
    private String nombre;
    private String color;
    private boolean salir;//si esta afuera del inicio
    private boolean elegido;
    private boolean home;
    private boolean vuelta;
    private int numeroVueltas;
    private Point point;
    private ImageIcon sprite;
    private JLabel labelJugador;
    
    
    public Pieza(int pos, String color, String nombre, Point point, ImageIcon sprite, int i, int casillaHome){
        this.pos = pos;
        this.color = color;
        this.nombre = nombre;
        this.elegido = false;
        this.vuelta = false;
        this.numeroVueltas = 0;
        this.point = point;
        this.casillaHome = casillaHome;
        labelJugador = new JLabel(sprite);
        //labelJugador.setLocation(point);
        switch(i){
            case 0:
                labelJugador.setBounds(0, -10, 40, 40);
                break;
            case 1:
                labelJugador.setBounds(30, -10, 40, 40);
                break;
            case 2:
                labelJugador.setBounds(0, 10, 40, 40);
                break;
            case 3:
                labelJugador.setBounds(30, 10, 40, 40);
                break;
        }
    }
    
    public void setLabelPoint(Point point){
        labelJugador.setLocation(point);
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSalir(boolean salir) {
        this.salir = salir;
    }

    public boolean isSalir() {
        return salir;
    }

    public String getNombre() {
        return nombre;
    }
    
    public int irSalida(){
        return pos;
    }
    
        public boolean isElegido() {
        return elegido;
    }

    public void setElegido(boolean elegido) {
        this.elegido = elegido;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
    
    
    
    public boolean Salida(Carta carta){
        if( (carta.getVal() == 1) || (carta.getVal() == 2)){
            this.salir = true;
        }
        
        return salir;
    }

    public JLabel getLabelJugador() {
        return labelJugador;
    }

    public void setLabelJugador(JLabel labelJugador) {
        this.labelJugador = labelJugador;
    }

    public int getCasillaHome() {
        return casillaHome;
    }

    
    
    
    public boolean isHome() {
        return home;
    }

    public void setHome(boolean home) {
        this.home = home;
    }

    public boolean isVuelta() {
        return vuelta;
    }

    public void setVuelta(boolean vuelta) {
        this.vuelta = vuelta;
    }

    public int getNumeroVueltas() {
        return numeroVueltas;
    }

    public void setNumeroVueltas(int numeroVueltas) {
        this.numeroVueltas = numeroVueltas;
    }

    public ImageIcon getSprite() {
        return sprite;
    }
    
    
    
//--------------------------------------------------------------------
    public void mover(Carta carta,Jugador jugador, int numPieza) throws IOException{
    
        if(carta.getVal() > 0){
            unMovimiento(jugador, numPieza, true, false);
        }
        else{
            unMovimiento(jugador, numPieza, false, false);
        }
    }
    
    public void moverDash(Jugador jugador, int numPieza) throws IOException{
        unMovimiento(jugador, numPieza, true, true);
    }

    
    
    
    public void unMovimiento(Jugador jugador, int numPieza, boolean avanzar, boolean isDash) throws IOException{
        
        if (avanzar) {
            jugador.getJugador()[numPieza].setPos(jugador.getJugador()[numPieza].getPos() + 1);
        } else {
            jugador.getJugador()[numPieza].setPos(jugador.getJugador()[numPieza].getPos() - 1);
        }
        vuelta(jugador);
        entradaSeguro(jugador, numPieza);
        try {
            Thread.sleep(500);
        } catch (Exception ex) {
            System.err.println("Error en el metodo unMovimiento en clase Pieza");
        }
        if (isDash) {
            Sorry.controlMismoLugar();
        }
        UITablero.imprimirTablero(Sorry.getTablero(), Sorry.getJugador());
        UITablero.getFrame().repaint();
        UITablero.getFrame().revalidate();

    }
    
    
    
    
    
    
    public void vuelta(Jugador jugador){
        
        for (int i = 0; i < jugador.getJugador().length; i++) {
            if (jugador.getColor().equals(Sorry.getColorJugador()[i])) {
                contadorVuelta(jugador, i);
            }
        }
    }

    
    public void entradaSeguro(Jugador jugador, int numPieza){
        
        
        if (jugador.getJugador()[numPieza].isVuelta()) {
            
            
            if ("azul".equals(jugador.getJugador()[numPieza].getColor())) {
                
                jugador.getJugador()[numPieza].setPos(60);
                jugador.getJugador()[numPieza].setPoint(Sorry.getTablero().getTableroPoint()[jugador.getJugador()[numPieza].getPos()]);
            } 
            else if ("amarillo".equals(jugador.getJugador()[numPieza].getColor())) {

                jugador.getJugador()[numPieza].setPos(66);
                jugador.getJugador()[numPieza].setPoint(Sorry.getTablero().getTableroPoint()[jugador.getJugador()[numPieza].getPos()]);
            } 
            else if ("verde".equals(jugador.getJugador()[numPieza].getColor())) {

                jugador.getJugador()[numPieza].setPos(72);
                jugador.getJugador()[numPieza].setPoint(Sorry.getTablero().getTableroPoint()[jugador.getJugador()[numPieza].getPos()]);
            } 
            else if ("rojo".equals(jugador.getJugador()[numPieza].getColor())) {

                jugador.getJugador()[numPieza].setPoint(Sorry.getTablero().getTableroPoint()[jugador.getJugador()[numPieza].getPos()]);
                jugador.getJugador()[numPieza].setPos(78);
            }
        }
        
        else{
            movimientoDe59a0(jugador, numPieza);
        }
    }
    
    
    public void movimientoDe59a0(Jugador jugador, int numPieza){
        if (jugador.getJugador()[numPieza].getPos() > 59) {
            jugador.getJugador()[numPieza].setPos(0);
            jugador.getJugador()[numPieza].setPoint(Sorry.getTablero().getTableroPoint()[0]);
        } else if (jugador.getJugador()[numPieza].getPos() < 0) {
            jugador.getJugador()[numPieza].setPos(59);
            jugador.getJugador()[numPieza].setPoint(Sorry.getTablero().getTableroPoint()[59]);
        }
    }
    
    
    
    
    public void contadorVuelta(Jugador jugador, int numPieza){
        
        
        for(int k = 0; k < Sorry.getTablero().getEsquinas().length; k++){
            
            if(jugador.getJugador()[numPieza].getPos() == Sorry.getTablero().getEsquinas()[k]){
                jugador.getJugador()[numPieza].setNumeroVueltas(jugador.getJugador()[numPieza].getNumeroVueltas() + 1);
            }
            
            if (jugador.getJugador()[numPieza].getNumeroVueltas() == 4) {
                jugador.getJugador()[numPieza].setVuelta(true);
            }
        }
    }
    
    


}
