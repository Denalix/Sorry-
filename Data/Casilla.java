
package sorry.Data;

public class Casilla extends Tablero{
    
    private int pos;//posicion de la casilla

    public Casilla(int pos){
        this.pos = pos;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    } 
    
    
}
