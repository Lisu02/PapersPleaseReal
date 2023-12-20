package entities;

import utils.WczytywaniePlikow;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Paszport {

    private String imie,nazwisko;
    private BufferedImage paszport;
    int xPos=0,yPos=0;
    int szerokosc=260,wysokosc=324;
    Point lokalizacja;
    Point poprzedniaLokalizacja;


    public Paszport(String imie,String nazwisko){
        this.imie = imie;
        this.nazwisko = nazwisko;
        wczytajObrazPaszportu();
        //KONSTRUKOTR DO TESTÓW
    }
    public Paszport(){
        this.imie = "TEST IMIE";
        this.nazwisko  ="TEST NAZWISKO";
        wczytajObrazPaszportu();
        //AUTO GENEROWANIE DANYCH
    }

    private void wczytajObrazPaszportu(){
        //TODO: DO ROZWINIĘCIA Z ZATWIERDZONYMI I ODRZUCONYMI PASZPORTAMI
        BufferedImage img = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.PASZPORT_ARZTOCKA);
        paszport = img;
    }

    public void aktualizuj(){
        //Aktualizowanie pozycji lub stanu zatwierdzenia paszportu
    }

    public void renderuj(Graphics g){
        g.drawImage(paszport,xPos,yPos,szerokosc,wysokosc,null);
    }

}
