package entities;

import DaneGryDoGenerowania.RandomDataUrodzenia;
import utils.Dzwieki;
import utils.WczytywaniePlikow;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import static DaneGryDoGenerowania.Dystrykty.getDystrykt;
import static org.main.Gra.SCALE;
import static utils.WczytywaniePlikow.DOWOD_OSOBISTY_DUZY;
import static utils.WczytywaniePlikow.DOWOD_OSOBISTY_MALY;

public class DowodOsobisty extends Dokument{

    private BufferedImage twarzPetentaDowod;

    private String imie ="Testyowe",nazwisko = "Tescicho";
    private String dystrykt = "faresto";
    private String dataUrodzenia;
    private String waga = "111";
    private String wzrost = "111";
    private int kodBledu;

    //FONT??
    private Font fontKonkretny = WczytywaniePlikow.wczytajFont(WczytywaniePlikow.FONT_OGOLNY,8f * SCALE);;

    public DowodOsobisty(){
        //126x71
        //250 X 140 STARE ROZMIARY
        szerokosc=126 * SCALE;
        wysokosc=71 * SCALE;
        xPos=900;
        yPos=234;
        initBounds();
        wczytajObrazDokumentu(DOWOD_OSOBISTY_DUZY,DOWOD_OSOBISTY_MALY);
        aktualneZdjecie = zdjecieDokumentu;
        Random random = new Random();
        Integer tmp = random.nextInt(65,88);
        this.waga = tmp.toString();
        tmp = random.nextInt(158,182);
        this.wzrost = tmp.toString();
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
            g.setFont(fontDokumentow);
            //g.setFont(new Font("Courier New", Font.PLAIN, 15));
            g.drawString(dystrykt.toUpperCase() + " " + "DISTRICT",xPos + (5*SCALE),yPos +(16*SCALE) + 1);



            g.setColor(new Color(69,60,89));
            //KOLOR NA DANE
            g.setFont(fontDokumentow);
            //String fullname = this.imie + ", " + this.nazwisko;
            g.drawString(imie + ",",xPos+(50 * SCALE),yPos +(26*SCALE));
            g.drawString(nazwisko,xPos+(50*SCALE),yPos +(34*SCALE));
            g.drawString(dataUrodzenia,xPos+(65*SCALE),yPos + (45*SCALE));
            g.drawString(wzrost + "cm",xPos+(65*SCALE),yPos + (55*SCALE));
            g.drawString(waga + "kg",xPos+(65*SCALE),yPos + (65*SCALE));

        }
    }

    @Override
    public void mouseDragged(MouseEvent e){
        super.mouseDragged(e);



        if(e.getX() < 178*SCALE && aktualneZdjecie != maleZdjecieDokumentu && przesuwanieDokumentu){
            aktualneZdjecie = maleZdjecieDokumentu;
            szerokosc -= 90*SCALE; // PO ODJECIU 36 * SCALE PASZPORT WYS -> 72 MIN 42
            wysokosc -= 50*SCALE; // PO ODJECIU 21 * SCALE -> SZER 41 MIN ~36
            xPos = e.getX()-(15*SCALE);
            yPos = e.getY()-(10*SCALE);
            Point punkt = e.getPoint();
            przesuniecieX = punkt.x - xPos;
            przesuniecieY = punkt.y - yPos;
            initBounds();
        } else if (aktualneZdjecie != zdjecieDokumentu && e.getX() >178*SCALE && przesuwanieDokumentu) {
            aktualneZdjecie = zdjecieDokumentu;
            szerokosc += 90*SCALE;
            wysokosc += 50*SCALE;
            xPos = e.getX()-(45*SCALE);
            yPos = e.getY()-(35*SCALE);
            Point punkt = e.getPoint();
            przesuniecieX = punkt.x - xPos;
            przesuniecieY = punkt.y - yPos;
            initBounds();
            //0.563
        }
    }


}
