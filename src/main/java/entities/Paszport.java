package entities;

import utils.WczytywaniePlikow;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Collection;

import static utils.Stale.UI.Przyciski.B_HEIGHT;
import static utils.Stale.UI.Przyciski.B_WIDTH;

public class Paszport implements MouseMotionListener, MouseListener {

    private String imie,nazwisko;
    private BufferedImage paszport;
    int xPos=0,yPos=0;
    int szerokosc=260,wysokosc=324;
    private Rectangle bounds;


    private boolean mouseOver = false;

    Point lokalizacja;
    Point poprzedniaLokalizacja;

    private void initBounds() {
        bounds = new Rectangle(xPos, yPos, szerokosc,wysokosc); //TODO:>?>
    }



    public Paszport(String imie,String nazwisko){
        this.imie = imie;
        this.nazwisko = nazwisko;
        wczytajObrazPaszportu();
        initBounds();
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
        initBounds();
        //Aktualizowanie pozycji lub stanu zatwierdzenia paszportu
        if(mouseOver){
            System.out.println("jest nad paszportem!");
        }
    }

    public void renderuj(Graphics g){
        g.drawImage(paszport,xPos,yPos,szerokosc,wysokosc,null);
    }

    public int getxPos(){return xPos;}
    public int getyPos(){return yPos;}

    public void setxPos(int xPos){this.xPos = xPos;}
    public void setyPos(int yPos){this.yPos = yPos;}


    //IMPLEMENTACJA MYSZKI
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        xPos=e.getX() -60;
        yPos=e.getY() -50;
        System.out.println(e.getX() + " oraz " + e.getY());
        initBounds();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public Rectangle getBounds() {
        return bounds;
    }
}
