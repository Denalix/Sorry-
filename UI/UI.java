

package sorry.UI;

import java.io.Console;
import java.util.Scanner;
import sorry.Data.Carta;
import sorry.Data.Jugador;
import sorry.Data.Pieza;
import sorry.Data.Tablero;
import java.util.*;

public class UI {
    
    public static Scanner sc = new Scanner(System.in);
    private static int op;
    private static int numPieza1;
    private static int numPieza2;
    private static String matrizTablero[][];
    
    
    
    public static int setUp() throws InterruptedException{
        
        sc = new Scanner(System.in);
        System.out.println("\n¿Cuántos jugadores son?");
        System.out.println("   1   2   3   4   \n0.Atrás.");
        
        int s = 1;
        try{
        s = sc.nextInt();
        if(s == 0)
            Operaciones.menu();
        else if(s == 4)
            jugar(s);
        else if(s>4 || s<0){
            System.out.println("Lo siento, el juego no está para esa cantidad de jugadores. Inténtalo de nuevo.");
            setUp();
        }   
        else{
            siMaq(s);
        }
        }catch(InputMismatchException esc){
            System.out.println("Introduciste carateres inválidos. Inténtalo de nuevo.");
            setUp();
        }
       return s;
    }
    
    public static void siMaq(int s) throws InterruptedException{
        sc = new Scanner(System.in);
        
        System.out.println("\n¿Deseas jugar contra la máquina? si/no \n0.Atrás.");
            String e = sc.next();
            if(e.equalsIgnoreCase("0"))
                setUp();
            
            else if(e.equalsIgnoreCase("si"))                
                numDeMaq(s);           
            else if(e.equalsIgnoreCase("no")){
                jugar(s);
            }
            else{
                System.out.println("No es una opción válida. Inténtalo de nuevo.");
                siMaq(s);
            }
        
    }
    
    public static void numDeMaq(int s) throws InterruptedException{
        sc = new Scanner(System.in);
        int m = 0;
        
        System.out.println("\n¿Contra cuántos jugadores de la máquina quieres jugar?");
        
        int i = 0;
        int j=0;
        for(i=0; i<4-s; i++){
            System.out.print("       " + (i+1));
        }
            System.out.println("\n0.Atrás.");
            
        try{
            m = sc.nextInt();
            
            if(m == 0)
                siMaq(s);
            else if(m<0 || m>i){
                System.out.println("No está dentro de las opciones. Inténtalo de nuevo.");
                numDeMaq(s);
            }
            else {
                j = s + m;
                jugar(s);
            }
        }catch(InputMismatchException exc){
            System.out.println("No está dentro de las opciones. Inténtalo de nuevo.");
            numDeMaq(s);
        }
        
    }
    
    public static void comoJugar(){
        System.out.println("\n(1)Sacar una ficha de la salida.\n(2)Seleccionar y mover una ficha.");
    }
    
    public static void jugar(int j){
        
        System.out.println("\nOk, entonces... Preparados o no, COMIENZA EL JUEGO!");
        //Vista del tablero
        comoJugar();
    }

    
    
    
    
    
    
    //---------------------------------------------------------------------------------
    public static String colorNegro(){
        return "\033[30m";
    }
    
    public static void waitForEnter() {
        System.out.println("Presione la tecla Enter para sacar una carta.");
        sc.nextLine();
    }

    public static void mostrarCarta(Carta carta){
        System.out.println("La carta sacada es ..." + carta.getVal());
    }
   
    public static void mostrarCartaSorry(){
        System.out.println("La carta sacada es ... sorry");
    }
    
    public static void mostrarTurno(Jugador jugador){
        System.out.println(jugador.imprimirColor(jugador.getColor()) + "Turno del jugador " + jugador.getColor() + colorNegro());
    }
   
    
    public static int Bienvenida(){
        
        System.out.println("Bienvenido al juego Sorry!");
        System.out.println("Elige la opcion que quieras:");
        System.out.println("1. Empezar a jugar,");
        System.out.println("2. Instrucciones.");
        System.out.println("3. salir.");
        
        op = sc.nextInt();
        
        return op;
    }
    
    public static void datoEquivovado(){
        System.out.println("Uno de los datos que ingreso no concuerda. Por favor ingrelos de nuevo.");
    }
    
    public static void Despedida(){
        System.out.println("Muchas gracias por jugar. Esperamos que vuelvas pronto");
    }
    
    public static void Instrucciones(){
        System.out.println("Aqui van las instrucciones.");
    }
    
    public static void OpcionNoSoportada(){
        System.out.println("No ingresaste una opcion valida, intentalo de nuevo.");
    }
    
    public static void posActual(Jugador jugador){
        System.out.println("La posicion actual de sus fichas es:");
        for(int i = 0; i < jugador.getJugador().length; i++){
            System.out.println("ficha " + jugador.imprimirColor(jugador.getColor()) + jugador.getJugador()[i].getNombre() + colorNegro() + " en posicion " + jugador.getJugador()[i].getPos());
        }
    }
    
    public static void ganador(Jugador jugador){
        System.out.println("El jugador " + jugador.imprimirColor(jugador.getColor()) + 
                jugador.getColor() + " es el ganador.");
    }
    
    
    //---------------------------------------------------------------------------
    
    
    public static int NumDeJug(){
        System.out.println("Con cuantos jugadores quiere jugar:");
        System.out.println("     1        2       3        4   ");
        op = sc.nextInt();
        return op;
    }
    
    public static int NumDeMaq(){
        System.out.println("Cuantas maquinas desea que hayan:");
        System.out.println("       1        2        3   ");
        op = sc.nextInt();
        return op;
    }
    
    public static void noPiezasLibres(){
        System.out.println("No tienes fichas libres, no puedes mover.");
    }
    
    
    
    
    
    
    //---------------------------------------------------------------------------
    
    
     public static int preguntaSalida(){
        System.out.println("ingrese (1) si desea sacar a una ficha de la salida o"
                + " (2) si desea mover una ficha?");
        op = sc.nextInt();
        return op;
    }
    
     public static void movimientoSalida(Jugador jugador){
        boolean salir = false;
        int i = 0;
        while(!salir){
            if(jugador.getJugador()[i].isSalir() == false){
                System.out.println("La ficha " + jugador.imprimirColor(jugador.getColor()) +
                        jugador.getJugador()[i].getNombre() + colorNegro() + 
                        " se ha movido de la salida a la casilla " + 
                        jugador.getCasillaSalida() );
                jugador.getJugador()[i].setSalir(true);
                
                jugador.getJugador()[i].setPos(jugador.getCasillaSalida());
                salir = true;
            }
            i++;
        }
    }
    
    public static int preguntaMovimiento(Jugador jugador){
        System.out.println("Que ficha desea mover?");
        for(int i = 0; i < jugador.getJugador().length; i++){
            if(jugador.getJugador()[i].isSalir() ==  true){
                System.out.println(jugador.getJugador()[i].getNombre());
            }
        }
        op = sc.nextInt();
        
        return op;
    }
     
    public static void movPiezaUnica(Jugador jugador, Carta carta){
        for(int i =0; i<jugador.getJugador().length; i++){
            if(jugador.getJugador()[i].isSalir() == true){
                System.out.println("La ficha " + jugador.imprimirColor(jugador.getColor())
                        + jugador.getJugador()[i].getNombre() + " se ha movido " +
                        (jugador.getJugador()[i].getPos()-carta.getVal()) + 
                        "de la salida.");
            }
        }
        
    }
    
    
    
    //---------------------------------------------------------------------------
    
    
    
    
    public static void cantMov(Carta carta, Jugador jugador, int numPieza){
        System.out.println("La ficha " + jugador.getJugador()[numPieza].getNombre() + 
                " se ha movido " + carta.getVal() + " espacio/s");
    }
    
    
    
    public static int mov7(){
        System.out.println("Ingresa (1) si quieres mover una ficha 7 espacios o "
                + "(2) si quieres dividir el movimiento entre dos fichas.");
        
        op = sc.nextInt();
        return op;
    }
    
    public static void mov10(Carta carta){
        System.out.println("Ingresa (1) si quieres mover una ficha 10 espacios o "
                + "(2) si quieres hacer retorceder una ficha 1.");
        
        op = sc.nextInt();
        if(op == 1){
            carta.setVal(10); 
        }
        else{
            carta.setVal(-1);
        }
    }
    
    public static void preguntaMovimiento7(Jugador jugador){
        System.out.println("Que ficha/s desea mover?");
        
        for(int i = 0; i < jugador.getJugador().length; i++){
            if(jugador.getJugador()[i].isSalir() ==  true){
                System.out.println(jugador.getJugador()[i]);
            }
        }
        
        op = sc.nextInt();
        jugador.getJugador()[op].setElegido(true);
        op = sc.nextInt();
        jugador.getJugador()[op].setElegido(true);
        
        System.out.println("Ha elegido las fichas: ");
        for(int i = 0; i < jugador.getJugador().length; i++){
            if(jugador.getJugador()[i].isElegido() == true){
                System.out.println(jugador.getJugador()[i].getNombre());
            }
        }
        
    }
    
    public static void movDoble(Jugador jugador){
        boolean salir = false;
        System.out.println("Como desea dividir sus movidas: ");
        int i = 0;
        while(!salir){
            
            if(jugador.getJugador()[i].isElegido() == true){
                System.out.println("Cuanto se debera mover la ficha " +
                        jugador.getJugador()[i].getNombre());
                
                op = sc.nextInt();
                if(op < 7){
                    numPieza1 = i;
                    jugador.getJugador()[numPieza1].setPos(op);
                    jugador.getJugador()[numPieza1].setElegido(true);
                    salir = true;
                }
                else{
                    UI.OpcionNoSoportada();
                    i--;
                }
            i++;
            }
        salir = false;
        while(!salir){
            if(jugador.getJugador()[i].isElegido() == true){
                numPieza2 = i;
                jugador.getJugador()[numPieza2].setPos(op);
                jugador.getJugador()[numPieza2].setElegido(true);
                salir = true;
            }
            i++;
        }
        }
    }
    
    public static int pregunta11(Jugador jugador){
        System.out.println("Ingrese (1) si quiere mover una ficha 11 espacios o "
                + "ingrese (2) si quiere cambiar una de sus fichas con la de un "
                + "oponente.(NO se pueden iintercambiar peones en el inicio).");
        op = sc.nextInt();
        return op;
    }
    
    public static void cambio(Jugador jugador){
        String color;
        int pieza;
        boolean salir = false;
        while(!salir){
                System.out.println("Ingrese la ficha que quiere cambiar:");
            op = sc.nextInt();
            System.out.println("Ingrese el color del jugador con el que quiere intercambiar ficha:");
            color = sc.nextLine();
            if( (color != "rojo") && (color != "amarillo") && (color != "verde") && (color != "azul") ){
                datoEquivovado();
                continue;
            };
            System.out.println("Ingrese la ficha con la que quiere intercambiar su ficha:");
            pieza = sc.nextInt();
            salir = true;
        }
        
    }

    public static int getNumPieza1() {
        return numPieza1;
    }

    public static void setNumPieza1(int numPieza1) {
        UI.numPieza1 = numPieza1;
    }

    public static int getNumPieza2() {
        return numPieza2;
    }

    public static void setNumPieza2(int numPieza2) {
        UI.numPieza2 = numPieza2;
    }
    
    
    
    
    
//-----------------------------------------------------------------------------    

//lo que sigue apartir de este punto es parte del tablero que aun no esta terminado    
    
    public static void setTablero(Tablero tablero, Jugador jugador){
        
        matrizTablero = new String[16][16];
        for(int posTab = 0; posTab < tablero.getTablero().length; posTab++){
            
        for(int i = 0; i < 16; i++){
            for(int j = 0; j < 16; j++){
                switch(i){
                    case 0:
                        matrizTablero[i][j] = casillaJugador(tablero, jugador, posTab);
                        break;
                    case 1:
                        if( (tablero.getTablero()[posTab].getPos() == 59) || (tablero.getTablero()[posTab].getPos() == 60) || (tablero.getTablero()[posTab].getPos() == 84) || (tablero.getTablero()[posTab].getPos() == 16) ){
                            matrizTablero[i][j] = casillaJugador(tablero, jugador, posTab);
                        }
                        else{
                            matrizTablero[i][j] = " ";
                        }
                        break;
                    case 2:
                        if( (posTab == 58) || (posTab == 61) || ((posTab >= 66)) && (posTab <= 71) ){
                            matrizTablero[i][j] = casillaJugador(tablero, jugador, posTab);
                        }
                        else{
                            matrizTablero[i][j] = " ";
                        }
                        break;
                    case 3:
                        if( (posTab == 57) || (posTab == 62) || (posTab == 18) ){
                            matrizTablero[i][j] = casillaJugador(tablero, jugador, posTab);
                        }
                        else{
                            matrizTablero[i][j] = " ";
                        }
                        break;
                    case 4:
                        if( (posTab == 56) || (posTab == 63) || (posTab == 85) || (posTab == 19) ){
                            matrizTablero[i][j] = casillaJugador(tablero, jugador, posTab);
                        }
                        else{
                            matrizTablero[i][j] = " ";
                        }
                        break;
                    case 5:
                        if( (posTab == 55) || (posTab == 64) || (posTab == 20) ){
                            matrizTablero[i][j] = casillaJugador(tablero, jugador, posTab);
                        }
                        else{
                            matrizTablero[i][j] = " ";
                        }
                        break;
                    case 6:
                        if( (posTab == 54) || (posTab == 65) || (posTab == 21) ){
                            matrizTablero[i][j] = casillaJugador(tablero, jugador, posTab);
                        }
                        else{
                            matrizTablero[i][j] = " ";
                        }
                        break;
                    case 7:
                        if( (posTab == 53) || (posTab == 22) ){
                            matrizTablero[i][j] = casillaJugador(tablero, jugador, posTab);
                        }
                        else{
                            matrizTablero[i][j] = " ";
                        }
                        break;
                    case 8:
                        if( (posTab == 52) || (posTab == 23) ){
                            matrizTablero[i][j] = casillaJugador(tablero, jugador, posTab);
                        }
                        else{
                            matrizTablero[i][j] = " ";
                        }
                        break;
                    case 9:
                        if( (posTab == 51) || (posTab == 77) || (posTab == 24) ){
                            matrizTablero[i][j] = casillaJugador(tablero, jugador, posTab);
                        }
                        else{
                            matrizTablero[i][j] = " ";
                        }
                        break;
                    case 10:
                        if( (posTab == 50) || (posTab == 76) || (posTab == 25) ){
                            matrizTablero[i][j] = casillaJugador(tablero, jugador, posTab);
                        }
                        else{
                            matrizTablero[i][j] = " ";
                        }
                        break;
                    case 11:
                        if( (posTab == 49) || (posTab == 87) || (posTab == 75) || (posTab == 26) ){
                            matrizTablero[i][j] = casillaJugador(tablero, jugador, posTab);
                        }
                        else{
                            matrizTablero[i][j] = " ";
                        }
                        break;
                    case 12:
                        if( (posTab == 48) || (posTab == 74) || (posTab == 27) ){
                            matrizTablero[i][j] = casillaJugador(tablero, jugador, posTab);
                        }
                        else{
                            matrizTablero[i][j] = " ";
                        }
                        break;
                    case 13:
                        if( (posTab == 47) || ((posTab >= 78) && (posTab <= 83)) || (posTab == 73) || (posTab == 28) ){
                            matrizTablero[i][j] = casillaJugador(tablero, jugador, posTab);
                        }
                        else{
                            matrizTablero[i][j] = " ";
                        }
                        break;
                    case 14:
                        if( (posTab == 46) || (posTab == 86) || (posTab == 72) || (posTab == 29) ){
                            matrizTablero[i][j] = casillaJugador(tablero, jugador, posTab);
                        }
                        else{
                            matrizTablero[i][j] = " ";
                        }
                        break;
                    case 15:
                        matrizTablero[i][j] = casillaJugador(tablero, jugador, posTab);
                        break;
                    }
                }
            }
        }
    }
    
    public static void imprimirTablero(Tablero tablero, Jugador jugador){
        setTablero(tablero, jugador);
        for(int i = 0; i < matrizTablero.length; i++){
            for(int j = 0; j < matrizTablero.length; j++){
                System.out.print(matrizTablero[i][j]);
            }
            System.out.println("");
        }
    }
    
    public static String casillaJugador(Tablero tablero, Jugador jugador, int posTab){
        String outPut = "";
            if( (tablero.getTablero()[posTab].getPos() == jugador.getJugador()[0].getPos()) ||
                    (tablero.getTablero()[posTab].getPos() == jugador.getJugador()[1].getPos()) ||
                    (tablero.getTablero()[posTab].getPos() == jugador.getJugador()[2].getPos()) ||
                    (tablero.getTablero()[posTab].getPos() == jugador.getJugador()[3].getPos()) ){
                
                for(int j = 0; j < jugador.getJugador().length; j++){
                    if(tablero.getTablero()[posTab].getPos() == jugador.getJugador()[j].getPos()){
                       int pos = posTab;
                       outPut = "|" + jugador.imprimirColor(jugador.getColor()) + jugador.getJugador()[j].getNombre() + colorNegro() + "|";
                        
                    }
                }
            }
            
            
            else{
                int pos = posTab;
                outPut = "|" + String.valueOf(tablero.getTablero()[pos].getPos()) + "|";
            }
            
            return outPut;
    }
}
