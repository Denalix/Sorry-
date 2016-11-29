
package GUI;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.Border;


import BussinesLogic.Sorry;
import Data.Jugador;
import Data.Tablero;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class UITablero extends JPanel{
    
    
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
    
    
    
    private static  JPanel panelPrincipal;
    private static  JPanel[][] panel;
    private static  JLabel[][] label;
    private static  JFrame frame;
    private static ImageIcon casillaVacia = new ImageIcon("src/Imagenes/casillas/casillaVacia.jpg");
    private static ImageIcon casillaExterna = new ImageIcon("src/Imagenes/casillas/casillaExterna.jpg");
    private static ImageIcon casillaBaraja  = new ImageIcon("src/Imagenes/casillas/cartaBocaAbajo.jpg");
    private final Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
    private static GridBagConstraints c;
    private static JButton boton;
   

    public UITablero() throws AWTException{
        
        boton = new JButton("Exit");
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(16, 16, 0, 0));
        panel = new JPanel[16][16];
        label = new JLabel[16][16];
        frame = new JFrame("Sorry - The game of sweet revenge");
        frame.setSize(1600, 1600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        for(int i = 0; i < 16; i++){
            for(int j = 0; j < 16; j++){
                label[i][j] = new JLabel();
            }
        }
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                panel[i][j] = new JPanel();
                panel[i][j].setBounds(0, 0, i, i);
            }
        }
    }
    
    public static JFrame getFrame() {
        return frame;
    }
    
    
    
    
    
    //-------------------------------------------------------------------
    
    public static void panelBorder(JPanel panel){
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    }
    
    public static void asignarCasilla(Jugador[] jugador, int x, int y, int casillaTablero, Tablero tablero) {
        label[x][y].setName(String.valueOf(casillaTablero));
        label[x][y].setIcon(casillaLabel(Sorry.getTablero(), jugador, casillaTablero, 84));
        //if(sprite != null){
        //   labelJugador = new JLabel(sprite);
        //}
        //Sorry.getTablero().getTableroPoint()[casillaTablero] = posicionLabel(label[x][y]);
    }

      
     public static Point posicionLabel(JLabel a) {
        Point point = a.getLocation();
        return point;
    }
    
     
    public static void setTablero(Tablero tablero, Jugador[] jugador) throws IOException{
        
        frame.setSize(1600, 1600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        
        
        
        int casillaTablero = 0;
        
        for(int x = 0; x < 16; x++){
            asignarCasilla(jugador, 0, x, casillaTablero, tablero);
            casillaTablero++;
        }
        for(int x = 1; x < 16; x++){
            asignarCasilla(jugador, x, 15, casillaTablero, tablero);
            casillaTablero++;
        }
        for(int x = 14; x > -1; x--){
            asignarCasilla(jugador, 15, x, casillaTablero, tablero);
            casillaTablero++;
        }
        for(int x = 14; x > 0; x--){
            asignarCasilla(jugador, x, 0, casillaTablero, tablero);
            casillaTablero++;
        }
        for(int x = 1; x < 8; x++){
            asignarCasilla(jugador, x, 2, casillaTablero, tablero);
            casillaTablero++;
        }
        
        casillaTablero--;
        
        for(int x = 14; x > 8; x--){
            asignarCasilla(jugador, 2, x, casillaTablero, tablero);
            casillaTablero++;
        }
        for(int x = 14; x > 8; x--){
            asignarCasilla(jugador, x, 13, casillaTablero, tablero);
            casillaTablero++;
        }
        for(int x = 1; x < 7; x++){
            asignarCasilla(jugador, 13, x, casillaTablero, tablero);
            casillaTablero++;
        }
      
        
        if (Sorry.getNumJugadores() == 2) {
            
            agregarLabelJugador(tablero, jugador[0]);
            imprimirFichasInicio(jugador[0], label);
            agregarLabelJugador(tablero, jugador[1]);
            imprimirFichasInicio(jugador[1], label);
        } 
        else if (Sorry.getNumJugadores() == 3) {
            agregarLabelJugador(tablero, jugador[0]);
            imprimirFichasInicio(jugador[0], label);
            agregarLabelJugador(tablero, jugador[1]);
            imprimirFichasInicio(jugador[1], label);
            agregarLabelJugador(tablero, jugador[2]);
            imprimirFichasInicio(jugador[2], label);
        }
        else if (Sorry.getNumJugadores() == 4) {
            agregarLabelJugador(tablero, jugador[0]);
            imprimirFichasInicio(jugador[0], label);
            agregarLabelJugador(tablero, jugador[1]);
            imprimirFichasInicio(jugador[1], label);
            agregarLabelJugador(tablero, jugador[2]);
            imprimirFichasInicio(jugador[2], label);
            agregarLabelJugador(tablero, jugador[3]);
            imprimirFichasInicio(jugador[3], label);
        }
        
        panelPrincipal.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        
        
        
        
        
        //System.out.println("Punto label: " + posicionLabel(label[0][0]));
        //System.out.println("Punto tableroPoint: " + tablero.getTableroPoint()[0]);
        
        
        //----------------------------------------------------------------------------
                
        //abelBaraja.addMouseListener(new MouseAdapter() {
        //    public void MouseClicked(MouseEvent e) {
        //        System.out.println("WWWWWHWYYYYYYYYY");
        //    }
        // });

        
        
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if (label[i][j].getName() == null) {
                    ////
                    label[i][j].setIcon(casillaExterna);
                }
            }
        }
        
        
        
        //label[0][5].add(jugador[3].getJugador()[1].getLabelJugador());
        //label[0][7].add(jugador[2].getJugador()[2].getLabelJugador());
        //label[0][8].add(jugador[0].getJugador()[3].getLabelJugador());
        //label[0][9].add(jugador[1].getJugador()[3].getLabelJugador());
        
        
        
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                panel[i][j].add(label[i][j]);
            }
        }

        
        for(int i = 0; i < 16; i++){
            for(int j = 0; j < 16; j++){
                

                panelPrincipal.add(panel[i][j]);
            }
        } 
        
        
        frame.add(panelPrincipal);
    }
    
    
    //---------------------------------------------
    
    
    
    
    public static void imprimirTablero(Tablero tablero, Jugador[] jugador) throws IOException{
        
        
        setTablero(tablero, jugador);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                label[i][j].setName(null);
            }
        }
        
        
        
    }
    
    
    public static void remover(Jugador[] jugador){
        if (Sorry.getNumJugadores() == 2) {
            removerLabelJugador(jugador[0]);
            removerLabelJugador(jugador[1]);
        } 
        else if (Sorry.getNumJugadores() == 3) {
            removerLabelJugador(jugador[0]);
            removerLabelJugador(jugador[1]);
            removerLabelJugador(jugador[2]);
        }
        else if (Sorry.getNumJugadores() == 4) {
            removerLabelJugador(jugador[0]);
            removerLabelJugador(jugador[1]);
            removerLabelJugador(jugador[2]);
            removerLabelJugador(jugador[3]);
        }
    }
    
    
    public static void agregarLabelJugador(Tablero tablero, Jugador jugador) {
        
        for (int i = 0; i < jugador.getJugador().length; i++) {
            for (int j = 0; j < tablero.getTablero().length; j++) {
                if (tablero.getTablero()[j].getPos() == jugador.getJugador()[i].getPos()) {
                    for (int k = 0; k < 16; k++) {
                        for (int l = 0; l < 16; l++) {
                            if (label[k][l].getName() != null) {
                                try {
                                    if (tablero.getTablero()[j].getPos() == Integer.parseInt(label[k][l].getName())) {
                                        //jugador.getJugador()[i].setLabelPoint(posicionLabel(label[k][l]));
                                        label[k][l].add(jugador.getJugador()[i].getLabelJugador());
                                        //label[k][l].setName(jugador.getJugador()[i].getNombre());
                                    }
                                } catch (NumberFormatException ex) {
                                    System.err.println("Problem?");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public static void removerLabelJugador(Jugador jugador){
        for(int i = 0; i < 16; i++){
            for(int j = 0; j < 16; j++){
                for(int k = 0; k < jugador.getJugador().length; k++){
                    if(jugador.getJugador()[k].getNombre().equals(label[i][j].getName())){
                        label[i][j].remove(jugador.getJugador()[k].getLabelJugador());
                        label[i][j].validate();
                        label[i][j].repaint();
                    }
                }
            }
        }
    }

    
    
    
    public static ImageIcon casillaLabel(Tablero tablero, Jugador[] jugador, int y, int limite){
        
        ImageIcon outPut = null;
        boolean posicionJugador = false;
        
        
        if (y < 10) {
            if ((y >= 1) && (y <= 4)) {
                outPut = imprimirDash(y);
            } else {
                outPut = casillaVacia;
            }
        } else if ((y >= 10) && (y <= 14)) {
            outPut = imprimirDash(y);
        } else if ((y >= 16) && (y <= 19)) {
            outPut = imprimirDash(y);
        } else if ((y >= 24) && (y <= 28)) {
            outPut = imprimirDash(y);
        } else if ((y >= 31) && (y <= 34)) {
            outPut = imprimirDash(y);
        } else if ((y >= 39) && (y <= 43)) {
            outPut = imprimirDash(y);
        } else if ((y >= 46) && (y <= 49)) {
            outPut = imprimirDash(y);
        } else if ((y >= 54) && (y <= 58)) {
            outPut = imprimirDash(y);
        } else {
            outPut = casillaVacia;
        }
   
        
        return outPut;
    }
    
    
    public static void imprimirFichasInicio(Jugador jugador, JLabel[][] label){
        
        if (jugador.getColor().equals("azul")) {
            setCasillaInicio(jugador, 1, 4);
        }
        else if(jugador.getColor().equals("amarillo")){
            setCasillaInicio(jugador, 4, 13);
        }
        else if(jugador.getColor().equals("verde")){
            setCasillaInicio(jugador, 13, 10);
        }
        else if(jugador.getColor().equals("rojo")){
            setCasillaInicio(jugador, 10, 1);
        }
    }
    
    public static void setCasillaInicio(Jugador jugador, int a, int b){
        int k = 0;
        for(int i = a; i < a+2; i++){
            for(int j = b; j < b+2; j++){
                label[i][j].setName(String.valueOf(i) + String.valueOf(j));
                label[i][j].setIcon(jugador.imprimirColor(jugador.getColor()));
                //jugador.getJugador()[0].setLabelPoint(posicionLabel(label[i][j]));
                if (!jugador.getJugador()[k].isSalir()) {
                    label[i][j].add(jugador.getJugador()[k].getLabelJugador());
                }
                k++;
            }
        }
    }
    
    public static ImageIcon casillaJugador(Jugador[] jugador, Tablero tablero, int casillaTablero){
        ImageIcon outPut = null;
        for (int i = 0; i < jugador.length; i++) {
            for (int j = 0; j < jugador[0].getJugador().length; j++) {
                if (tablero.getTablero()[casillaTablero].getPos() == jugador[i].getJugador()[j].getPos()) {
                    outPut = jugador[i].getJugador()[j].getSprite();
                }
            }
        }
        return outPut;
    }
   
    
    
    public static ImageIcon imprimirDash(int y){
        ImageIcon outPut = null;
        
        if(y > 0 && y < 16){
            if (y == 1) outPut = new ImageIcon("src/Imagenes/casillas/dash3Espacios/dashAzul/dash1.jpg");
            if ((y > 1) && (y < 4)) outPut = new ImageIcon("src/Imagenes/casillas/dash3Espacios/dashAzul/dash2.jpg");
            if (y == 4) outPut = new ImageIcon("src/Imagenes/casillas/dash3Espacios/dashAzul/dash4.jpg");

            if (y == 10) outPut = new ImageIcon("src/Imagenes/casillas/dash3Espacios/dashAzul/dash1.jpg");
            if ((y > 10) && (y < 14)) outPut = new ImageIcon("src/Imagenes/casillas/dash3Espacios/dashAzul/dash2.jpg");
            if (y == 14) outPut = new ImageIcon("src/Imagenes/casillas/dash3Espacios/dashAzul/dash4.jpg");
        }//-----------------------
        if(y > 15 && y < 30){
            
            if (y == 16) outPut = new ImageIcon("src/Imagenes/casillas/dash3Espacios/dashAmarillo/dash1.jpg");
            if ((y > 16) && (y < 19)) outPut = new ImageIcon("src/Imagenes/casillas/dash3Espacios/dashAmarillo/dash2.jpg");
            if (y == 19) outPut = new ImageIcon("src/Imagenes/casillas/dash3Espacios/dashAmarillo/dash4.jpg");

            if (y == 24) outPut = new ImageIcon("src/Imagenes/casillas/dash3Espacios/dashAmarillo/dash1.jpg");
            if ((y > 24) && (y < 28)) outPut = new ImageIcon("src/Imagenes/casillas/dash3Espacios/dashAmarillo/dash2.jpg");
            if (y == 28) outPut = new ImageIcon("src/Imagenes/casillas/dash3Espacios/dashAmarillo/dash4.jpg");
        }//-----------------------
        if(y > 30 && y < 45){
            
            if (y == 31) outPut = new ImageIcon("src/Imagenes/casillas/dash3Espacios/dashVerde/dash1.jpg");
            if ((y > 31) && (y < 34)) outPut = new ImageIcon("src/Imagenes/casillas/dash3Espacios/dashVerde/dash2.jpg");
            if (y == 34) outPut = new ImageIcon("src/Imagenes/casillas/dash3Espacios/dashVerde/dash4.jpg");
            

            if (y == 39) outPut = new ImageIcon("src/Imagenes/casillas/dash3Espacios/dashVerde/dash1.jpg");
            if ((y > 39) && (y < 43)) outPut = new ImageIcon("src/Imagenes/casillas/dash3Espacios/dashVerde/dash2.jpg");
            if (y == 43) outPut = new ImageIcon("src/Imagenes/casillas/dash3Espacios/dashVerde/dash4.jpg");
        }//-----------------------
        if(y > 45 && y < 60){
            
            
            if (y == 46) outPut = new ImageIcon("src/Imagenes/casillas/dash3Espacios/dashRojo/dash1.jpg");
            if ((y > 46) && (y < 49)) outPut = new ImageIcon("src/Imagenes/casillas/dash3Espacios/dashRojo/dash2.jpg");
            if (y == 49) outPut = new ImageIcon("src/Imagenes/casillas/dash3Espacios/dashRojo/dash4.jpg");

            if (y == 54) outPut = new ImageIcon("src/Imagenes/casillas/dash3Espacios/dashRojo/dash1.jpg");
            if ((y > 54) && (y < 58)) outPut = new ImageIcon("src/Imagenes/casillas/dash3Espacios/dashRojo/dash2.jpg");
            if (y == 58) outPut = new ImageIcon("src/Imagenes/casillas/dash3Espacios/dashRojo/dash4.jpg");
        }
        return outPut;
    }

    
    

}
