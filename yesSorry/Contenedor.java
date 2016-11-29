package yesSorry;

import javax.swing.*;
import java.awt.*;

public class Contenedor extends JComponent {
    static int detenteeee;//seria el numero de casillas que se movera
    
    static JLabel label;
    static int columna;
    static int fila=134;
    static int numero=1;
    
    
    Contenedor(JLabel label, int columna, int e){
        this.label=label;
        this.columna= columna;
        this.detenteeee=e;
        
        setBounds(columna, 0, label.getWidth(), label.getHeight());//iniciar con 40 20 para que empiece bien
    
    }
    
    public void paint(Graphics g){
        ImageIcon imagen= new ImageIcon(new ImageIcon(getClass().getResource("imagenes/jugLinux.png")).getImage());
        g.drawImage(imagen.getImage(), columna, fila, 50, 50, null);
    
    }
    
    static boolean m=true;
    static Thread hilo= new Thread()
    {
        public void run()
        {
        
        try
        {
            while(m)
            {
            label.repaint();
            fila+=1;
                System.out.println(fila);
            hilo.sleep(20);
            if(fila==20+detenteeee*57){
            m=false;
            }
            }
                    
                    }catch(Exception ex){
                    System.out.println(ex);
                    }
        }
        
        
    
    
    
};
       
public void mover(){

    
        hilo.start();
    
    
        columna=3;
        fila=3;

}

}