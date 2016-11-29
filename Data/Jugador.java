package Data;

import java.awt.Point;
import java.util.Random;
import javax.swing.ImageIcon;

public class Jugador {
    
    private int casillaSalida;
    private Pieza[] jugador;

    private String color;
    private int posInicial;
    private Random rand;
    private String homeAzul = "src/Imagenes/casillas/homeAzul.jpg";
    private String homeAmarillo = "src/Imagenes/casillas/homeAmarillo.jpg";
    private String homeVerde = "src/Imagenes/casillas/homeVerde.jpg";
    private String homeRojo = "src/Imagenes/casillas/homeRojo.jpg";
    private static ImageIcon[][] sprite = new ImageIcon[4][4];
    private static String[][] nombre = new String[4][4];

    
    
    public static void asignarSprites(){
        
        sprite[0][0] = new ImageIcon("src/Imagenes/pokemon/pokemonesAzul/lapras.png");
        sprite[0][1] = new ImageIcon("src/Imagenes/pokemon/pokemonesAzul/golduck.png");
        sprite[0][2] = new ImageIcon("src/Imagenes/pokemon/pokemonesAzul/gyarados.png");
        sprite[0][3] = new ImageIcon("src/Imagenes/pokemon/pokemonesAzul/blastoise.png");
        
        sprite[1][0] = new ImageIcon("src/Imagenes/pokemon/pokemonesAmarillo/ampharos.png");
        sprite[1][1] = new ImageIcon("src/Imagenes/pokemon/pokemonesAmarillo/jolteon.png");
        sprite[1][2] = new ImageIcon("src/Imagenes/pokemon/pokemonesAmarillo/pikachu.png");
        sprite[1][3] = new ImageIcon("src/Imagenes/pokemon/pokemonesAmarillo/zapdos.png");
        
        sprite[2][0] = new ImageIcon("src/Imagenes/pokemon/pokemonesVerde/exeggutor.png");
        sprite[2][1] = new ImageIcon("src/Imagenes/pokemon/pokemonesVerde/meganium.png");
        sprite[2][2] = new ImageIcon("src/Imagenes/pokemon/pokemonesVerde/venusaur.png");
        sprite[2][3] = new ImageIcon("src/Imagenes/pokemon/pokemonesVerde/victreebel.png");
        
        sprite[3][0] = new ImageIcon("src/Imagenes/pokemon/pokemonesRojo/charizard.png");
        sprite[3][1] = new ImageIcon("src/Imagenes/pokemon/pokemonesRojo/moltres.png");
        sprite[3][2] = new ImageIcon("src/Imagenes/pokemon/pokemonesRojo/arcanine.png");
        sprite[3][3] = new ImageIcon("src/Imagenes/pokemon/pokemonesRojo/rapidash.png");
    }
    
    public static void asignarNombres(){
        
        nombre[0][0] = "lapras";
        nombre[0][1] = "golduck";
        nombre[0][2] = "gyarados";
        nombre[0][3] = "blastoise";
        
        nombre[1][0] = "ampharos";
        nombre[1][1] = "jolteon";
        nombre[1][2] = "pikachu";
        nombre[1][3] = "zapdos";
        
        nombre[2][0] = "exeggutor";
        nombre[2][1] = "meganium";
        nombre[2][2] = "venusaur";
        nombre[2][3] = "victreebel";
        
        nombre[3][0] = "charizard";
        nombre[3][1] = "moltres";
        nombre[3][2] = "arcanine";
        nombre[3][3] = "rapidash";
    }
    
    
    
    public Jugador(){
        
    }
    
    public Jugador(String color, int posInicial, int casillaSalida, Point pointInicial, int j, int casillaHome){
        
        asignarSprites();
        asignarNombres();
        
        jugador = new Pieza[4];
        this.color = color;
        this.casillaSalida = casillaSalida;
        
        this.posInicial = posInicial;
        for(int i = 0; i<jugador.length; i++){
            Pieza pieza = new Pieza(posInicial, color, nombre[j][i], pointInicial, sprite[j][i], i, casillaHome);
            jugador[i] = pieza;
        }
        
        
    }

    public int getPosInicial() {
        return posInicial;
    }

    
    
    public Pieza[] getJugador() {
        return jugador;
    }

    public ImageIcon imprimirColor(String color){
        switch (color) {
            case "azul":
            {
                ImageIcon icon = new ImageIcon(homeAzul);
                return icon;
                
            }
            case "amarillo":
            {
                ImageIcon icon = new ImageIcon(homeAmarillo);
                return icon;
            }
            case "verde":
            {
                ImageIcon icon = new ImageIcon(homeVerde);
                return icon;
            }
            default:
            {
                ImageIcon icon = new ImageIcon(homeRojo);
                return icon;//rojo
            }
        }
    }
    

    public String getColor() {
        return color;
    }

    public int getCasillaSalida() {
        return casillaSalida;
    }
    
    
    public int getPiezasLibres(){
        int numPieLibres = 0;
        for(int i = 0; i<jugador.length; i++){
            if( (jugador[i].isSalir() == true) && (jugador[i].isHome() == false) ){
                numPieLibres++;
            }
        }
        return numPieLibres;
    }
    
    public Carta sacarCarta(Carta carta){
        rand = new Random();
        int pos = rand.nextInt(10);
        
        
        if(pos == 9){
            carta = new SorryTarjeta();
        }
        else{
            int cartasPosibles[] = {1,2,3,-4,5,7,8,10,12};
            carta = new TarjetaMovimiento(cartasPosibles[pos]);
        }
        
        return carta;
    }    
    
}
