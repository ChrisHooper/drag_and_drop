import java.awt.Graphics;
import java.awt.Point;

public class Figura {
    public static final int LINEA=0;
    public static final int RECTANGULO=1;
    public static final int ELIPSE=2;
    private int tipo;
    private Point ini, fin;
//figura final
    public Figura(int tipo, Point ini, Point fin) {
        this.tipo=tipo;
        this.ini=ini;
        this.fin=fin;
    }
    public Figura(){
        this(LINEA, new Point(), new Point());
    }
    public Figura(int tipo){
        this(tipo, new Point(), new Point());
    }
//mientras se dibuja la figura
    public void dibujar(Graphics g, Point ini, Point fin){
        this.ini=ini;
        this.fin=fin;
        if(tipo==LINEA){
            g.drawLine(ini.x, ini.y, fin.x, fin.y);
        }else{
            int ancho=Math.abs(ini.x-fin.x);
            int alto=Math.abs(ini.x-fin.x);
            int iniX=Math.min(ini.x, fin.x);
            int iniY=Math.min(ini.y, fin.y);
            if(tipo==ELIPSE){
                g.drawOval(iniX, iniY, ancho, alto);
            }else{
                g.drawRect(iniX, iniY, ancho, alto);
            }
        }
    }
//figura final
    public void dibujar(Graphics g){
        dibujar(g, ini, fin);
    }
}