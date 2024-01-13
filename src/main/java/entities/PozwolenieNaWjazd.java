package entities;

import utils.WczytywaniePlikow;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import static org.main.Gra.GAME_HEIGHT;
import static org.main.Gra.GAME_WIDTH;

public class PozwolenieNaWjazd extends Dokument {

    //DANE NA POZWOLENIU NA WJAZD
    private String imie,nazwisko,kodPaszportu,cel,czasTrwania,dataWaznosci;

    private BufferedImage stempelPozwolenia;

    private final Font fontDokumentu = WczytywaniePlikow.wczytajFont(WczytywaniePlikow.FONT_DO_DOKUMENTOW,15f);

    //int xPos=700,yPos=234; //POZYCJA W ROGU DOKUMENTOW
    //int szerokosc=280,wysokosc=374;
    //private Rectangle bounds;

//    private boolean przesuwanieDokumentu = false;
//    private int przesuniecieX, przesuniecieY;

    public void setDanePozwoleniaNaWjazd(String imie,String nazwisko,String kodPaszportu,String dataWaznosci) {

    }

    @Override
    public void initBounds(){super.initBounds();}

    public PozwolenieNaWjazd(){
        szerokosc=280;
        wysokosc=374;
        xPos=700;
        yPos=234;
        initBounds();
        this.imie ="Mykolski";
        this.nazwisko  ="Wladimir";
        wczytajObrazPozwoleniaNaWjazd();

    }

    private void wczytajObrazPozwoleniaNaWjazd(){
        //TODO: DO ROZWINIĘCIA Z ZATWIERDZONYMI I ODRZUCONYMI PASZPORTAMI
        BufferedImage imgDuze = WczytywaniePlikow.GetSpriteAtlas("EntryPermitInner.png");
        BufferedImage imgMale = WczytywaniePlikow.GetSpriteAtlas("EntryPermitOuter.png");
        //PassportInnerArstotzka.png
        zdjecieDokumentu = imgDuze;
        maleZdjecieDokumentu = imgMale;
        aktualneZdjecie = zdjecieDokumentu;
    }

    public void aktualizuj(){
        super.aktualizuj();
        //Aktualizowanie pozycji lub stanu zatwierdzenia paszportu
    }

    public void renderuj(Graphics g){
        super.renderuj(g);
    }

    @Override
    public void mouseDragged(MouseEvent e){
        super.mouseDragged(e);

        if(e.getX() < 390 && aktualneZdjecie != maleZdjecieDokumentu){
            aktualneZdjecie = maleZdjecieDokumentu;
            szerokosc -= 170;
            wysokosc -= 320;
            xPos = e.getX()-25;
            yPos = e.getY()-25;
            Point punkt = e.getPoint();
            przesuniecieX = punkt.x - xPos;
            przesuniecieY = punkt.y - yPos;
            initBounds();
        } else if (aktualneZdjecie != zdjecieDokumentu && e.getX() >390) {
            aktualneZdjecie = zdjecieDokumentu;
            szerokosc += 170;
            wysokosc += 320;
            xPos = e.getX()-70;
            yPos = e.getY()-90;
            Point punkt = e.getPoint();
            przesuniecieX = punkt.x - xPos;
            przesuniecieY = punkt.y - yPos;
            initBounds();
        }
    }


}
