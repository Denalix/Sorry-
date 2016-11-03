
package sorry.Data;

public abstract class Carta{
    
    private String tipo;
    private int val;
    
    public Carta(String tipo){
        this.tipo = tipo;
    }

    public int getVal() {
        return val;
    }

    public String getTipo() {
        return tipo;
    }
    
    public void setVal(int val) {
        this.val = val;
    }
}
