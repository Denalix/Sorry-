
package sorry.Data;

public class Pieza extends Jugador{
    
    private int pos;
    private String nombre;
    private String color;
    private boolean salir;//si esta afuera del inicio
    private boolean elegido;
    private boolean home;
    
    
    public Pieza(int pos, String color, String nombre){
        this.pos = pos;
        this.color = color;
        this.nombre = nombre;
        this.elegido = false;
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
    
    
    public void mover(Carta carta,Jugador jugador, int numPieza){
        if( (carta.getVal() == -4) || (carta.getVal() == -1) ){
            jugador.getJugador()[numPieza].setPos(jugador.getJugador()[numPieza].getPos() - 1);
        }
        
        else{
            jugador.getJugador()[numPieza].setPos(jugador.getJugador()[numPieza].getPos() + 1);
        }
        
    }

    public boolean isElegido() {
        return elegido;
    }

    public void setElegido(boolean elegido) {
        this.elegido = elegido;
    }
    
    
    
    public boolean Salida(Carta carta){
        if( (carta.getVal() == 1) || (carta.getVal() == 2)){
            this.salir = true;
        }
        
        return salir;
    }

    public boolean isHome() {
        return home;
    }

    public void setHome(boolean home) {
        this.home = home;
    }
    
    
}
