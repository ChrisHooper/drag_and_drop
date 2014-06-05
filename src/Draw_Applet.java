import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Draw_Applet extends Applet {
    boolean isStandalone = false;
    Panel panel1 = new Panel();
    MiCanvas canvas;
    Panel panel2 = new Panel();
    Panel panel3 = new Panel();
    CheckboxGroup chkGrupo = new CheckboxGroup();
    Checkbox chkLinea = new Checkbox();
    Checkbox chkElipse = new Checkbox();
    Checkbox chkRectangulo = new Checkbox();
    Button btnBorrar = new Button();
    FlowLayout flowLayout1 = new FlowLayout();
    FlowLayout flowLayout2 = new FlowLayout();
    BorderLayout borderLayout1 = new BorderLayout();
    BorderLayout borderLayout2 = new BorderLayout();
    //Construct the applet

    public void init() {
        try {
        jbInit();
        }
        catch (Exception e) {
        e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        int ancho = Integer.parseInt(this.getParameter("WIDTH"));
        int alto = Integer.parseInt(this.getParameter("HEIGHT"));
        this.setSize(new Dimension(ancho, alto));
        this.setLayout(borderLayout2);
        canvas=new MiCanvas(this);
        panel1.setLayout(borderLayout1);
        panel2.setLayout(flowLayout1);
        panel3.setLayout(flowLayout2);
        chkLinea.setLabel("Línea");
        chkElipse.setLabel("Elipse");
        chkRectangulo.setLabel("Rectángulo");
        chkLinea.setCheckboxGroup(chkGrupo);
        chkElipse.setCheckboxGroup(chkGrupo);
        chkRectangulo.setCheckboxGroup(chkGrupo);
        chkGrupo.setSelectedCheckbox(chkLinea);
      /*  ItemRadio item=new ItemRadio(canvas);
        chkLinea.addItemListener(item);
        chkElipse.addItemListener(item);
        chkRectangulo.addItemListener(item);
        */btnBorrar.setLabel("Borrar");
        btnBorrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                btnBorrar_actionPerformed(ev);
            }
        });
       this.add(panel1, BorderLayout.NORTH);
        panel1.add(panel2, BorderLayout.CENTER);
        panel2.add(chkLinea, null);
        panel2.add(chkElipse, null);
        panel2.add(chkRectangulo, null);
        panel1.add(panel3, BorderLayout.EAST);
        panel3.add(btnBorrar, null);
        this.add(canvas, BorderLayout.CENTER);
    }
    void btnBorrar_actionPerformed(ActionEvent ev){
        canvas.borrar();
    }

}
 /*
class ItemRadio implements ItemListener{
    private MiCanvas canvas;
    public ItemRadio(MiCanvas canvas){
        this.canvas=canvas;
    }
    public void itemStateChanged(ItemEvent ev){
        String s=(String)ev.getItem();
        if(s.equals("Línea")){
            canvas.setFigura(Figura.LINEA);
        }else if(s.equals("Rectángulo")){
            canvas.setFigura(Figura.RECTANGULO);
        }else if(s.equals("Elipse")){
            canvas.setFigura(Figura.ELIPSE);
        }
    }
}   */