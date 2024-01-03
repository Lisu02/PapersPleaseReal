package gamestates;

import java.awt.*;
import java.awt.event.MouseEvent;

public interface Metodystanu {

    public void aktualizuj();
    public void rysuj(Graphics g);
    public void mouseClicked(MouseEvent e);
    public void mousePressed(MouseEvent e);
    public void mouseReleased(MouseEvent e);
    public void mouseMoved(MouseEvent e);
    public void mouseDragged(MouseEvent e);

}
