package gamestates;

import org.main.Gra;
import ui.GraPrzycisk;
import ui.MenuPrzycisk;
import utils.Dzwieki;
import utils.WczytywaniePlikow;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static org.main.Gra.*;

public class Menu extends Stan implements Metodystanu{

    private MenuPrzycisk[] menuPrzycisk = new MenuPrzycisk[3];
    private BufferedImage logoGry = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.LOGO_GRY_MENU);
    private BufferedImage[] introGry = new BufferedImage[4];
    private int przesuniecie = 5;
    private int licznik = 0;
    private int pomoc1 = 5,pomoc2;
    //private MenuPrzycisk opcjePrzycisk;
    public Menu(Gra gra) {
        super(gra);
        wczytajPrzyciski();
        //Wczytywanie guzików
        //Wczytywanie tła gry
    }

    private void wczytajPrzyciski() {
        menuPrzycisk[0] = new MenuPrzycisk(260*SCALE,225*SCALE,0,Stangry.GRANIE);
        menuPrzycisk[1] = new MenuPrzycisk(260*SCALE,250*SCALE,1,Stangry.OPTIONS);
        menuPrzycisk[2] = new MenuPrzycisk(260*SCALE,275*SCALE,2,Stangry.QUIT);

        //opcjePrzycisk = new MenuPrzycisk(50*SCALE,400*SCALE,4,Stangry.OPTIONS);

        introGry[0] = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.INTRO_0);
        introGry[1] = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.INTRO_1);
        introGry[2] = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.INTRO_2);
        introGry[3] = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.INTRO_3);

        Dzwieki.addDzwieki(Dzwieki.GLOWNA_MUZYKA);
        Dzwieki.ustawGlosnosc(-20); // od -80 do 6 skala głośności
        Dzwieki.odtworzDzwiek();

    }

    @Override
    public void aktualizuj() {
        licznik++;
        if(licznik%240 == 0){
//            if(licznik % 60 == 0){
//                przesuniecie += pomoc1;
//            }
            if(przesuniecie == 0){
                przesuniecie = 20;
            }else{
                przesuniecie = 0;
            }

        }
        //aktualizowanie guzików w for
        for(MenuPrzycisk mp: menuPrzycisk){
            mp.aktualicuj();
        }

    }

    @Override
    public void rysuj(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,FINAL_GAME_WIDTH,FINAL_GAME_HEIGHT);
        g.drawImage(logoGry,125*SCALE,10*SCALE+przesuniecie,315*SCALE,197*SCALE,null);
        //rysowanie tła oraz guzików
        for(MenuPrzycisk mp: menuPrzycisk){
            mp.rysuj(g);
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
            if(isIn(e,mp)){
                mp.setMousePressed(true);
            }

        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        for(MenuPrzycisk mp: menuPrzycisk){
            if(isIn(e,mp)){
                if(mp.isMousePressed()){
                    Dzwieki.zatrzymajDzwiek();
                    mp.zastosujStanGry();
                    break;
                }
            }

        }
        resetButtons();
    }

    private void resetButtons() {
        for(MenuPrzycisk mp : menuPrzycisk){
            mp.resetBools();
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
