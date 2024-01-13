package entities;

import utils.WczytywaniePlikow;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static DaneGryDoGenerowania.Dystrykty.getDystrykt;
import static utils.WczytywaniePlikow.DOWOD_OSOBISTY_DUZY;
import static utils.WczytywaniePlikow.DOWOD_OSOBISTY_MALY;

public class DowodOsobisty extends Dokument{

    private BufferedImage twarzPetentaDowod;

    private String imie ="Testowe",nazwisko = "Tescicho";
    private String dystrykt = "faresto";
    private String dataUrodzenia;
    private String waga = "111";
    private String wzrost = "111";
    private int kodBledu;

    //FONT??
    private Font fontKonkretny = WczytywaniePlikow.wczytajFont(WczytywaniePlikow.FONT_OGOLNY,15f);;

    public DowodOsobisty(){
        szerokosc=250;
        wysokosc=140;
        xPos=900;
        yPos=234;
        initBounds();
        wczytajObrazDokumentu(DOWOD_OSOBISTY_DUZY,DOWOD_OSOBISTY_MALY);
        aktualneZdjecie = zdjecieDokumentu;
    }

    private void wczytajObrazDowodu() {
    }


    public void setDaneDowodu(String imie,String nazwisko,String dataUrodzenia,int kodBledu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.kodBledu = kodBledu;
        dystrykt = getDystrykt(kodBledu);
    }


    public void aktualizuj(){
        super.aktualizuj();
    }

    public void renderuj(Graphics g) {
        super.renderuj(g);

        if (aktualneZdjecie == zdjecieDokumentu) {
            g.setColor(new Color(200,180,227));
            //g.setFont();
            //g.setFont(new Font("Courier New", Font.PLAIN, 15));
            g.drawString(dystrykt.toUpperCase() + " " + "DISTRICT",xPos + 10,yPos +32);



            g.setColor(new Color(69,60,89));
            //KOLOR NA DANE
            g.setFont(fontDokumentow);
            //String fullname = this.imie + ", " + this.nazwisko;
            g.drawString(imie + ",",xPos+100,yPos +53);
            g.drawString(nazwisko + ",",xPos+100,yPos +67);

        }
    }

    @Override
    public void mouseDragged(MouseEvent e){
        super.mouseDragged(e);

        if(e.getX() < 390 && aktualneZdjecie != maleZdjecieDokumentu){
            aktualneZdjecie = maleZdjecieDokumentu;
            szerokosc -= 160;
            wysokosc -= 100;
            xPos = e.getX()-25;
            yPos = e.getY()-25;
            Point punkt = e.getPoint();
            przesuniecieX = punkt.x - xPos;
            przesuniecieY = punkt.y - yPos;
            initBounds();
        } else if (aktualneZdjecie != zdjecieDokumentu && e.getX() >390) {
            aktualneZdjecie = zdjecieDokumentu;
            szerokosc += 160;
            wysokosc += 100;
            xPos = e.getX()-70;
            yPos = e.getY()-90;
            Point punkt = e.getPoint();
            przesuniecieX = punkt.x - xPos;
            przesuniecieY = punkt.y - yPos;
            initBounds();
        }
    }


}
