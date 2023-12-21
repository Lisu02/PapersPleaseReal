package gamestates;

import org.main.Gra;
import ui.GraPrzycisk;

import java.awt.event.MouseEvent;

public class Stan {

    protected Gra gra;

    public Stan(Gra gra){this.gra = gra;}

    public boolean isIn(MouseEvent e, GraPrzycisk gp){
        return gp.getBounds().contains(e.getX(),e.getY());
    }

    public Gra getGra(){return gra;}
}
