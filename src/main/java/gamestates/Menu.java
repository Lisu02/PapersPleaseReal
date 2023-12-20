package gamestates;

import org.main.Gra;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Menu extends Stan implements Metodystanu{



    public Menu(Gra gra) {
        super(gra);
        //Wczytywanie guzików
        //Wczytywanie tła gry
    }

    @Override
    public void aktualizuj() {
        //aktualizowanie guzików w for
    }

    @Override
    public void rysuj(Graphics g) {
        //rysowanie tła oraz guzików
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        //mb.setMousePressed(true);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
