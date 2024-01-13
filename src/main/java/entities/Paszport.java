package entities;

import utils.WczytywaniePlikow;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Collection;

import static DaneGryDoGenerowania.ImionaPetentow.getImie;
import static DaneGryDoGenerowania.ImionaPetentow.getNazwisko;
import static org.main.Gra.GAME_HEIGHT;
import static org.main.Gra.GAME_WIDTH;
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
    private final Font fontDokumentow = WczytywaniePlikow.wczytajFont(WczytywaniePlikow.FONT_DO_DOKUMENTOW,15f);


    //wieklość i lokalizacja paszportu
    //int xPos=400,yPos=234; //POZYCJA W ROGU DOKUMENTOW
//    int szerokosc=260,wysokosc=324;



    protected void initBounds() {
        super.initBounds();
    }


    public Paszport(){
        //Lokalizacja paszportu
        xPos = 400;
        yPos = 234;
        //Stan paszportu (czy w wersji małej czy dużej)

        this.imie = getImie();
        this.nazwisko  = getNazwisko();
        this.dataUrodzenia = "26/08/2002";
        this.plec = "M";
        this.miejsceWydania = "Bialystok";
        this.dataWaznosci = "31/03/2015";
        this.kodPaszportu = "ABCD-1234";
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

            int imieX = xPos + 15,imieY = yPos + 187;
            int daneX = xPos + 135,daneY = yPos + 208;
            int kodX = xPos + 15,kodY = yPos + 308;

            switch (krajPochodzenia.toUpperCase()){
                case "ARSTOTZKA":
                    break;
                case "ZJEDNOCZONA FEDERACJA":
                    imieY = yPos + 207;
                    daneY = daneY + 17;
                    daneX = daneX + 4;
                    kodX += 150;
                    break;
                case "KOLECHIA":
                    imieY = yPos + 207;
                    daneY = daneY + 19;
                    daneX = daneX + 6;
                    kodX += 150;
                    break;
            }

            g.drawString(fullname,imieX,imieY);
            g.drawString(dataUrodzenia,daneX,daneY);
            g.drawString(plec,daneX,daneY + 15);
            g.drawString(miejsceWydania,daneX,daneY + 30);
            g.drawString(dataWaznosci,daneX,daneY + 48);
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

        if(e.getX() < 390 && aktualneZdjecie != maleZdjecieDokumentu){
            aktualneZdjecie = maleZdjecieDokumentu;
            szerokosc -= 190;
            wysokosc -= 230;
            xPos = e.getX()-25;
            yPos = e.getY()-25;
            Point punkt = e.getPoint();
            przesuniecieX = punkt.x - xPos;
            przesuniecieY = punkt.y - yPos;
            initBounds();
        } else if (aktualneZdjecie != zdjecieDokumentu && e.getX() >390) {
            aktualneZdjecie = zdjecieDokumentu;
            szerokosc += 190;
            wysokosc += 230;
            xPos = e.getX()-70;
            yPos = e.getY()-90;
            Point punkt = e.getPoint();
            przesuniecieX = punkt.x - xPos;
            przesuniecieY = punkt.y - yPos;
            initBounds();
        }

    }

}
