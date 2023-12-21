package gamestates;

import org.main.Gra;
import ui.MenuPrzycisk;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Menu extends Stan implements Metodystanu{

    private MenuPrzycisk[] menuPrzycisk = new MenuPrzycisk[3];

    public Menu(Gra gra) {
        super(gra);
        //wczytajPrzyciski();
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
        System.out.println("menuClicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //mb.setMousePressed(true);
        System.out.println("pressed");

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
