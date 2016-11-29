
package Data;

import java.awt.Point;

public class Casilla{
    
    private int pos;//posicion de la casilla
    private Point point;

    public Casilla(int pos, Point point){
        this.pos = pos;
        this.point = point;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    } 

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
    
    
}
