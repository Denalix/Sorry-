
package sorry.Data;

public class Tablero {
    
    private Casilla[] tablero;
    
    public Tablero(){
        
    }
    
    public Tablero(int a){
        
        boolean ocu = false;
        tablero = new Casilla[88];
        
        for(int pos = 0; pos < tablero.length; pos++){
             for(int i = 0; i < tablero.length; i++){
                    Casilla casilla = new Casilla(pos);
                    tablero[pos] = casilla;
             }       
        }
    }
    
    
    
    public Casilla[] getTablero(){
        return tablero;
    }
    
    public void UpdateCasilla(Jugador jugador){
        for(int pos = 0; pos < tablero.length; pos++){
             for(int i = 0; i < jugador.getJugador().length; i++){
                 if(jugador.getJugador()[i].getPos() == pos){
                     jugador.getJugador()[i].setPos(jugador.getJugador()[i].getPos()); 
                 }
                 else{
                    Casilla casilla = new Casilla(pos);
                    tablero[pos] = casilla;
             }
               
             }            
        }
    }
    
    
}
