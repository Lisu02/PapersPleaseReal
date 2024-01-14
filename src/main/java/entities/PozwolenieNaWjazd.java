package entities;

import utils.Dzwieki;
import utils.WczytywaniePlikow;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import static org.main.Gra.*;
import static utils.WczytywaniePlikow.POZWOLENIE_NA_WJAZD_DUZY;
import static utils.WczytywaniePlikow.POZWOLENIE_NA_WJAZD_MALY;

public class PozwolenieNaWjazd extends Dokument {

    //DANE NA POZWOLENIU NA WJAZD
    private String imie,nazwisko,kodPaszportu,cel,czasTrwania,dataWaznosci;

    private BufferedImage stempelPozwolenia;

    private final Font fontDokumentu = WczytywaniePlikow.wczytajFont(WczytywaniePlikow.FONT_DO_DOKUMENTOW,8f * SCALE);

    //int xPos=700,yPos=234; //POZYCJA W ROGU DOKUMENTOW
    //int szerokosc=280,wysokosc=374;
    //private Rectangle bounds;

//    private boolean przesuwanieDokumentu = false;
//    private int przesuniecieX, przesuniecieY;

    public void setDanePozwoleniaNaWjazd(String imie,String nazwisko,String kodPaszportu,String dataWaznosci) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.kodPaszportu = kodPaszportu;
        this.dataWaznosci = dataWaznosci;
    }

    @Override
    public void initBounds(){super.initBounds();}

    public PozwolenieNaWjazd(){
        szerokosc=150 * SCALE;
        wysokosc=201 * SCALE;
        //150 x 201;
        xPos=700;
        yPos=234;
        initBounds();
        this.imie ="Mykolski";
        this.nazwisko  ="Wladimir";
        wczytajObrazPozwoleniaNaWjazd();

    }

    private void wczytajObrazPozwoleniaNaWjazd(){
        //TODO: DO ROZWINIĘCIA Z ZATWIERDZONYMI I ODRZUCONYMI PASZPORTAMI
        BufferedImage imgDuze = WczytywaniePlikow.GetSpriteAtlas(POZWOLENIE_NA_WJAZD_DUZY);
        BufferedImage imgMale = WczytywaniePlikow.GetSpriteAtlas(POZWOLENIE_NA_WJAZD_MALY);
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

        if(e.getX() < 178*SCALE && aktualneZdjecie != maleZdjecieDokumentu && przesuwanieDokumentu){
            aktualneZdjecie = maleZdjecieDokumentu;
            //280 x 374
            //150 x 201
            szerokosc -= 100*SCALE;
            wysokosc -= 180*SCALE;
            xPos = e.getX()-20*SCALE;
            yPos = e.getY()-10*SCALE;
            Point punkt = e.getPoint();
            przesuniecieX = punkt.x - xPos;
            przesuniecieY = punkt.y - yPos;
            initBounds();
        } else if (aktualneZdjecie != zdjecieDokumentu && e.getX() >178*SCALE && przesuwanieDokumentu) {
            aktualneZdjecie = zdjecieDokumentu;
            szerokosc += 100*SCALE;
            wysokosc += 180*SCALE;
            xPos = e.getX()-75*SCALE;
            yPos = e.getY()-95*SCALE;
            Point punkt = e.getPoint();
            przesuniecieX = punkt.x - xPos;
            przesuniecieY = punkt.y - yPos;
            initBounds();
        }
    }


}
