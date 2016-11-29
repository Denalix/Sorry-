
package Data;

import java.awt.Point;

public class Tablero {
    
    private Casilla[] tablero;
    private Point[] tableroPoint;
    private final int[] esquina = {15, 30, 45, 0};
    private final int[] casillaInicio = {84, 85, 86, 87};
    private final int[] casillaHome = {65, 71, 77, 83};
    private final int[] casillaSalida = {4, 19, 34, 49};
    private final int[] casillaDash = {1,10,16,24,31,39,46,58};
    private final int[] casillaInicioDash3 = {1, 16, 31, 46};
    private final int[] casillaFinDash3 = {4, 19, 34, 49};
    private final int[] casillaInicioDash4 = {10,24, 39, 54};
    private final int[] casillaFinDash4 = {14,28, 43, 58};
    private final int[] casillaInicioSeguro = {60, 66, 72, 78};
    
    
    
    
//   | 0|| >||--||--||-O|| 5|| 6|| 7|| 8|| 9|| >||--||--||--||-O||15|
//   |59||  ||60||  ||84||  ||  ||  ||  ||  ||  ||  ||  ||  ||  || V|
//   |O ||  ||61||  ||  ||  ||  ||  ||  ||71||70||69||68||67||66|| ||
//   || ||  ||62||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||  || ||
//   || ||  ||63||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||85|| O|
//   || ||  ||64||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||20|
//   |^ ||  ||65||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||21|
//   |53||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||22|
//   |52||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||23|
//   |51||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||77||  || V|
//   |50||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||76||  || ||
//   |O ||87||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||75||  || ||
//   || ||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||74||  || ||
//   || ||78||79||80||81||82||83||  ||  ||  ||  ||  ||  ||73||  || O|
//   |^ ||  ||  ||  ||  ||  ||  ||  ||  ||  ||  ||86||  ||72||  ||29|
//   |45||44||O-||--||--||--||-<||38||37||36||35||O-||--||--||-<||30|
    

    
    
    public Tablero(){
        
        boolean ocu = false;
        tablero = new Casilla[88];
        tableroPoint = new Point[88];
        
        for(int i = 0; i < tableroPoint.length; i++){
            tableroPoint[i] = new Point();
        }
   
        for (int j = 0; j < tablero.length; j++) {
            Casilla casilla = new Casilla(j, tableroPoint[j]);
            tablero[j] = casilla;
        }

    }
    
    public boolean isDash(int pos) {//sirve para saber si la casilla es un dash
        boolean isDash = false;
        
        for (int i = 0; i < casillaDash.length; i++) {
            if (pos == casillaDash[i]) {
                isDash = true;
                break;
            }
        }
        return isDash;
    }
     
    public boolean isDash3(int pos) {//sirve para saber si la casilla es un dash de 3
        boolean isDash3 = false;
        
        for (int i = 0; i < casillaInicioDash3.length; i++) {
            if (pos == casillaInicioDash3[i]) {
                isDash3 = true;
                break;
            }
        }
        return isDash3;
    }
    
    
    public Casilla[] getTablero(){
        return tablero;
    }

    public int[] getEsquinas() {
        return esquina;
    }
         
    public int[] getCasillaInicioSeguro() {
        return casillaInicioSeguro;
    }

    public int[] getCasillaInicio() {
        return casillaInicio;
    }

    public int[] getCasillaHome() {
        return casillaHome;
    }

    public int[] getCasillaSalida() {
        return casillaSalida;
    }

    public Point[] getTableroPoint() {
        return tableroPoint;
    }

    
    
    
}
