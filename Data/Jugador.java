package sorry.Data;

import java.util.Random;

public class Jugador {
    
    private int casillaSalida;
    private Pieza[] jugador;
    private String color;
    private int posIni;//posicion inicial
    private boolean human;
    private Random rand;
    
    public Jugador(){
        
    }
    
    public Jugador(Tablero tablero, String color, int posIni, boolean human, int casillaSalida){
        jugador = new Pieza[4];
        this.human = human;
        this.color = color;
        this.casillaSalida = casillaSalida;
        
        this.posIni = posIni;
        for(int i = 0; i<jugador.length; i++){
            Pieza pieza = new Pieza(posIni, color, String.valueOf(i));
            jugador[i] = pieza;
        }
        
        
    }

    public int getPosIni() {
        return posIni;
    }

    
    
    public Pieza[] getJugador() {
        return jugador;
    }

    public String imprimirColor(String color){
        if(color.equals("rojo")){
            return "\033[31m";

        }
        if(color.equals("azul")){
            return "\033[36m";
        }
        if(color.equals("verde")){
            return "\033[32m";
        }
        else{
            return "\033[33m";
        }
    }
    
    public void setJugador(Pieza[] jugador) {
        this.jugador = jugador;
    }

    public String getColor() {
        return color;
    }

    public int getCasillaSalida() {
        return casillaSalida;
    }
    
    

    public boolean isHuman() {
        return human;
    }

    public void setHuman(boolean human) {
        this.human = human;
    }
    
    public int getPiezasLibres(){
        int numPieLibres = 0;
        for(int i = 0; i<jugador.length; i++){
            if(jugador[i].isSalir() == true){
                numPieLibres++;
            }
        }
        return numPieLibres;
    }
    
    public Carta sacarCarta(Carta carta){
        rand = new Random();
        int pos = rand.nextInt(11) + 1;
        
        if( pos == 11){
            carta = new Sorry();
        }
        else{
            int cartasPosibles[] = {1,2,3,-4,5,7,8,10,12};
            
            carta = new TarjetaMovimiento(cartasPosibles[rand.nextInt(pos)]);
        }
        
        return carta;
    }    
}
