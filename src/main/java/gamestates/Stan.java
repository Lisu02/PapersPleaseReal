package gamestates;

import entities.Paszport;
import entities.PozwolenieNaWjazd;
import org.main.Gra;
import ui.GraPrzycisk;
import ui.MenuPrzycisk;

import java.awt.event.MouseEvent;

public class Stan {

    protected Gra gra;

    public Stan(Gra gra){this.gra = gra;}

    public boolean isIn(MouseEvent e, GraPrzycisk gp){
        return gp.getBounds().contains(e.getX(),e.getY());
    }
    public boolean isIn(MouseEvent e, MenuPrzycisk mp){
        return mp.getBounds().contains(e.getX(),e.getY());
    }

    public boolean isIn(MouseEvent e, Paszport paszport){return paszport.getBounds().contains(e.getX(),e.getY());}
    public boolean isIn(MouseEvent e, PozwolenieNaWjazd pozwolenieNaWjazd){return pozwolenieNaWjazd.getBounds().contains(e.getX(),e.getY());}

    public Gra getGra(){return gra;}
}
