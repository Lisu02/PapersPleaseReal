package entities;

import utils.Dzwieki;
import utils.WczytywaniePlikow;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import static org.main.Gra.GAME_HEIGHT;
import static org.main.Gra.GAME_WIDTH;

public abstract class Dokument implements MouseMotionListener, MouseListener {

    //OBRAZY NA PASZPORCIE
    protected BufferedImage aktualneZdjecie;
    protected BufferedImage zdjecieDokumentu;
    protected BufferedImage maleZdjecieDokumentu;
    protected final Font fontDokumentow = WczytywaniePlikow.wczytajFont(WczytywaniePlikow.FONT_DO_DOKUMENTOW,15f);


    //wieklość i lokalizacja paszportu
    protected int xPos = 300,yPos = 300;
    protected int szerokosc=260,wysokosc=324;
    protected Rectangle bounds;

    protected boolean przesuwanieDokumentu = false;
    protected int przesuniecieX, przesuniecieY;

    //TODO:LEPSZEPRZESUWANIE ZMIENNE


    protected void initBounds() {
        bounds = new Rectangle(xPos, yPos, szerokosc,wysokosc);
        //System.out.println("Zmienione granice");
    }

    protected void wczytajObrazDokumentu(){
        BufferedImage img = WczytywaniePlikow.GetSpriteAtlas("PassportInnerArstotzka.png");
        zdjecieDokumentu = img;
    }

    protected void wczytajObrazDokumentu(String nazwaPliku){
        BufferedImage img = WczytywaniePlikow.GetSpriteAtlas(nazwaPliku);
        zdjecieDokumentu = img;
    }
    protected void wczytajObrazDokumentu(String nazwaPliku,String nazwaPlikuMale){
        BufferedImage imgBig = WczytywaniePlikow.GetSpriteAtlas(nazwaPliku);
        BufferedImage imgSmall = WczytywaniePlikow.GetSpriteAtlas(nazwaPlikuMale);
        zdjecieDokumentu = imgBig;
        maleZdjecieDokumentu = imgSmall;
    }

    protected void wczytajObrazPaszportu(String kraj){

        kraj = kraj.toUpperCase();
        BufferedImage imgBig = null;
        BufferedImage imgSmall = null;
        switch (kraj){
            case "ARSTOTZKA":
                imgBig = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.PASZPORT_ARZTOCKA_DUZY);
                imgSmall = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.PASZPORT_ARZTOCKA_MALY);
                break;
            case "KOLECHIA":
                imgBig = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.PASZPORT_KOLECHIA_DUZY);
                imgSmall = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.PASZPORT_KOLECHIA_MALY);
                break;
            case "ZJEDNOCZONA FEDERACJA":
                imgBig = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.PASZPORT_ZJEDONOCZNA_FED_DUZY);
                imgSmall = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.PASZPORT_ZJEDONOCZONA_FED_MALY);
                break;
        }
        if(imgBig == null|| imgSmall == null)
        {
            throw new RuntimeException("Blad w wczytywaniu obrazu dokumentu");
        }else{
            zdjecieDokumentu = imgBig;
            maleZdjecieDokumentu =imgSmall;
            aktualneZdjecie = zdjecieDokumentu;
        }

    }

    public void aktualizuj(){
        initBounds();
    }

    public void renderuj(Graphics g){

        //RYSOWANIE CIENI DOKUMENTOW
        if(przesuwanieDokumentu && aktualneZdjecie == zdjecieDokumentu){
            Color kolorCienia = new Color(0,0,0,100);
            g.setColor(kolorCienia);
            g.fillRect(xPos + 12,yPos + 10,szerokosc,wysokosc);
        } else if (przesuwanieDokumentu && aktualneZdjecie == maleZdjecieDokumentu ) {

            Color kolorCienia = new Color(0,0,0,100);
            g.setColor(kolorCienia);
            g.fillRect(xPos + 12,yPos + 10,szerokosc,wysokosc);
        }

        g.drawImage(aktualneZdjecie,xPos,yPos,szerokosc,wysokosc,null);
    }


    //IMPLEMENTACJA MYSZKI
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {

        Point punkt = e.getPoint();
        if (getBounds().contains(punkt)) {
            Dzwieki.addDzwieki(Dzwieki.PODNOSZENIE_KARTKI_0);
            Dzwieki.odtworzDzwiek();
            przesuwanieDokumentu = true;
            przesuniecieX = punkt.x - xPos;
            przesuniecieY = punkt.y - yPos;
        }

    }
    @Override
    public void mouseReleased(MouseEvent e) {
        Random random = new Random();

        if(przesuwanieDokumentu){
//            Dzwieki.addDzwieki(Dzwieki.OPUSZCZANIE_KARTKI_0);
//            Dzwieki.odtworzDzwiek();
        }
        przesuwanieDokumentu = false;
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
    @Override
    public void mouseDragged(MouseEvent e) {
            if (przesuwanieDokumentu) {
                int noweX = e.getX() - przesuniecieX;
                int noweY = e.getY() - przesuniecieY;
                if(noweX + 160 < GAME_WIDTH && noweX > 0){
                    xPos = noweX;
                }
                if(noweY + 124 < GAME_HEIGHT && noweY >= 0){
                    yPos = noweY;
                }
                initBounds();
            }

            //Warunek na zmiane wielkosci


    }
    @Override
    public void mouseMoved(MouseEvent e) {

    }
    public Rectangle getBounds() {
        return bounds;
    }
}
