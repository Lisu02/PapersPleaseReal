package entities;

import utils.Dzwieki;
import utils.WczytywaniePlikow;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Collection;

import static DaneGryDoGenerowania.ImionaPetentow.getImie;
import static DaneGryDoGenerowania.ImionaPetentow.getNazwisko;
import static org.main.Gra.*;
import static utils.Stale.UI.Przyciski.B_HEIGHT;
import static utils.Stale.UI.Przyciski.B_WIDTH;

public class Paszport extends Dokument{


    //DANE NA PASZPORCIE
    private String imie,nazwisko;
    private String dataUrodzenia;
    private String plec;
    private String miejsceWydania;
    private String dataWaznosci;
    private String kodPaszportu;
    private String krajPochodzenia;

    //OBRAZY NA PASZPORCIE
    private BufferedImage zdjeciePaszportowe;
    private BufferedImage zdjecieDecyzjiZatwierdzeniaPaszportu;
    //private final Font fontDokumentow = WczytywaniePlikow.wczytajFont(WczytywaniePlikow.FONT_DO_DOKUMENTOW,15f);


    //wieklość i lokalizacja paszportu
    //int xPos=400,yPos=234; //POZYCJA W ROGU DOKUMENTOW
//    int szerokosc=260,wysokosc=324;



    protected void initBounds() {
        super.initBounds();
    }


    public Paszport(){
        //Lokalizacja paszportu
        xPos = 178*SCALE + 10;
        yPos = 103*SCALE + 10;
        //Stan paszportu (czy w wersji małej czy dużej)

        this.imie = getImie();
        this.nazwisko  = getNazwisko();
        this.dataUrodzenia = "26/08/2002";
        this.plec = "M";
        this.miejsceWydania = "Bialystok";
        this.dataWaznosci = "31/03/2015";
        this.kodPaszportu = "ABCD-1234";
        initBounds();
    }

    public void aktualizuj(){
        super.aktualizuj();
        //Aktualizowanie pozycji lub stanu zatwierdzenia paszportu
    }

    @Override
    public void renderuj(Graphics g){
        super.renderuj(g);


        if(aktualneZdjecie == zdjecieDokumentu){
            g.setColor(new Color(87,72,72));
            g.setFont(fontDokumentow);
            String fullname = this.imie + ", " + this.nazwisko;
            //130 x 162\
//            int imieX = (xPos + 15),imieY = (yPos + (187*(SCALE-1)) );

            int imieX = (xPos + 6*SCALE),imieY = (yPos + (93*SCALE) );
            int daneX = (xPos + 67*SCALE),daneY = (yPos + (105*SCALE));
            int kodX = (xPos + 6*SCALE),kodY = (yPos + (155*SCALE));

            switch (krajPochodzenia.toUpperCase()){
                case "ARSTOTZKA":
                    break;
                case "ZJEDNOCZONA FEDERACJA":
                    imieX = (xPos + 7*SCALE);
                    imieY = yPos + 104*SCALE;
                    daneY = daneY + 19;
                    daneX = daneX + 4;
                    kodX += 150;
                    break;
                case "KOLECHIA":
                    imieX = (xPos + 7*SCALE);
                    //315
                    imieY = yPos + 104*SCALE;
                    daneY = daneY + 19;
                    daneX = daneX + 6;
                    kodX += 150;
                    break;
            }

            g.drawString(fullname,imieX,imieY);
            g.drawString(dataUrodzenia,daneX ,daneY + 1*SCALE);
            g.drawString(plec,daneX,daneY + 8*SCALE);
            g.drawString(miejsceWydania,daneX,daneY + 16*SCALE);
            g.drawString(dataWaznosci,daneX,daneY + 24*SCALE);
            g.drawString(kodPaszportu,kodX,kodY);

        }
    }



    public void setDanePaszportu(String imie,String nazwisko,String dataUrodzenia,String plec,String miejsceWydania,String dataWaznosci,String kodPaszportu,String krajPochodzenia){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.plec = plec;
        this.miejsceWydania = miejsceWydania;
        this.dataWaznosci = dataWaznosci;
        this.kodPaszportu = kodPaszportu;
        this.krajPochodzenia = krajPochodzenia;
        wczytajObrazPaszportu(krajPochodzenia);
    }


    @Override
    public void mouseDragged(MouseEvent e){
        super.mouseDragged(e);
        // szerokosc=260,wysokosc=324;
        // 70   X   94
        // 130x162
        // 36 x 52
        // 42 WYS X 36
//        szerokosc -= 190;
//        wysokosc -= 230;
        if(e.getX() < 178*SCALE && aktualneZdjecie != maleZdjecieDokumentu && przesuwanieDokumentu){
            aktualneZdjecie = maleZdjecieDokumentu;
            szerokosc -= 98*SCALE;
            wysokosc -= 120*SCALE;
            xPos = e.getX()-(20*SCALE);
            yPos = e.getY()-(20*SCALE);
            Point punkt = e.getPoint();
            przesuniecieX = punkt.x - xPos;
            przesuniecieY = punkt.y - yPos;
            initBounds();
        } else if (aktualneZdjecie != zdjecieDokumentu && e.getX() >178*SCALE && przesuwanieDokumentu) {
            aktualneZdjecie = zdjecieDokumentu;
            szerokosc += 98*SCALE;
            wysokosc += 120*SCALE;
            xPos = e.getX()-(45*SCALE);
            yPos = e.getY()-(55*SCALE);
            Point punkt = e.getPoint();
            przesuniecieX = punkt.x - xPos;
            przesuniecieY = punkt.y - yPos;
            initBounds();
        }

    }

}
