import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Vector;






public class MiCanvas extends Canvas {
	private Draw_Applet parent;
	private Vector figuras=new Vector();
	private Figura figActual;
	private Graphics gc;
	private Point ini, fin;
	public MiCanvas(Draw_Applet parent) {
		setBackground(Color.white);
		addMouseListener(new RatonPoner());
		addMouseMotionListener(new RatonMover());
		figActual=new Figura(Figura.LINEA);
		this.parent=parent;
	}
	public void borrar(){
		figuras.removeAllElements();
		repaint();
	}
	private void getTipo(){
		String s=parent.chkGrupo.getSelectedCheckbox().getLabel();
		if(s.equals("Línea")){
			figActual=new Figura(Figura.LINEA);
		}else if(s.equals("Rectángulo")){
			figActual=new Figura(Figura.RECTANGULO);
		}else if(s.equals("Elipse")){
			figActual=new Figura(Figura.ELIPSE);
		}
	}
	private void empiezaDibujar(Point p){
		getTipo();
		ini=p;
		fin=p;
		gc=getGraphics();
		gc.setXORMode(getBackground());
		figActual.dibujar(gc, ini, fin);
	}
	private void dibuja(Point p){
		figActual.dibujar(gc, ini, fin);
		fin=p;
		figActual.dibujar(gc, ini, fin);
	}
	private void terminaDibujar(){
		figActual.dibujar(gc, ini, fin);
		gc.setPaintMode();
		figActual.dibujar(gc, ini, fin);
		gc.dispose();
	}
	public void paint(Graphics g){
		for(int i=0; i<figuras.size(); i++){
			Figura fig=(Figura)figuras.elementAt(i);
			fig.dibujar(g);
		}
	}
	class RatonPoner extends MouseAdapter{
		public void mousePressed(MouseEvent ev){
			empiezaDibujar(ev.getPoint());
		}
		public void mouseReleased(MouseEvent ev){
			terminaDibujar();
			figuras.addElement(figActual);
		}
	}
	class RatonMover extends MouseMotionAdapter{
		public void mouseDragged(MouseEvent ev){
			dibuja(ev.getPoint());
		}
	}
}