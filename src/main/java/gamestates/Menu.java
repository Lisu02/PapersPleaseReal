package gamestates;

import org.main.Gra;
import ui.GraPrzycisk;
import ui.MenuPrzycisk;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Menu extends Stan implements Metodystanu{

    private MenuPrzycisk[] menuPrzycisk = new MenuPrzycisk[3];

    public Menu(Gra gra) {
        super(gra);
        wczytajPrzyciski();
        //Wczytywanie guzików
        //Wczytywanie tła gry
    }

    private void wczytajPrzyciski() {
        menuPrzycisk[0] = new MenuPrzycisk();
        menuPrzycisk[1] = new MenuPrzycisk();
        menuPrzycisk[2] = new MenuPrzycisk();
    }

    @Override
    public void aktualizuj() {
        //aktualizowanie guzików w for
        for(MenuPrzycisk mp: menuPrzycisk){
            mp.aktualicuj();
        }
    }

    @Override
    public void rysuj(Graphics g) {
        //rysowanie tła oraz guzików
        for(MenuPrzycisk mp: menuPrzycisk){
            mp.rysuj();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //nie uzywane???
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //mb.setMousePressed(true);
//        System.out.println("pressed");
        for(MenuPrzycisk mp: menuPrzycisk){
            mp.setMousePressed(true);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        for(MenuPrzycisk mp: menuPrzycisk){

        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for(MenuPrzycisk mp: menuPrzycisk){
            mp.setMouseOver(false);
        }

        for(MenuPrzycisk mp: menuPrzycisk){
            if(isIn(e,mp)){
                mp.setMouseOver(true);
                break;
            }
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
