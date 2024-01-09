package entities;

import utils.WczytywaniePlikow;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Collection;

import static org.main.Gra.GAME_HEIGHT;
import static org.main.Gra.GAME_WIDTH;
import static utils.Stale.UI.Przyciski.B_HEIGHT;
import static utils.Stale.UI.Przyciski.B_WIDTH;

public class Paszport implements MouseMotionListener, MouseListener {


    //DANE NA PASZPORCIE
    private String imie,nazwisko;
    private String dataUrodzenia;
    private String plec;
    private String miejsceWydania;
    private String dataWaznosci;

    //OBRAZY NA PASZPORCIE
    private BufferedImage paszport;
    private BufferedImage zdjeciePaszportowe;
    private BufferedImage zdjecieDecyzjiZatwierdzeniaPaszportu;
    private final Font fontDokumentow = WczytywaniePlikow.wczytajFont(WczytywaniePlikow.FONT_DO_DOKUMENTOW,15f);


    //wieklość i lokalizacja paszportu
    int xPos=400,yPos=234; //POZYCJA W ROGU DOKUMENTOW
    int szerokosc=260,wysokosc=324;
    private Rectangle bounds;
    boolean przesuwanie = false;
    private boolean mouseOver = false;

    //TODO:LEPSZEPRZESUWANIE ZMIENNE
    Point lokalizacja;
    Point poprzedniaLokalizacja;

    private void initBounds() {
        bounds = new Rectangle(xPos, yPos, szerokosc,wysokosc); //TODO:>?>
    }



    public Paszport(String imie,String nazwisko){
        this.imie = imie;
        this.nazwisko = nazwisko;
        wczytajObrazPaszportu();
        //initBounds();
        //KONSTRUKOTR DO TESTÓW
    }
    public Paszport(){
        this.imie = "Mykolski";
        this.nazwisko  ="Wladimir";
        wczytajObrazPaszportu();
        //initBounds();
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

        g.setColor(new Color(87,72,72));
        g.setFont(fontDokumentow);
        String fullname = this.imie + ", " + this.nazwisko;
        g.drawString(fullname,xPos + 15,yPos + 187);

        g.drawString("26/08/2002",xPos + 135,yPos + 208);
        g.drawString("M",xPos + 135,yPos + 223);
        g.drawString("Bialystok",xPos + 135,yPos + 238);
        g.drawString("31/03/2015",xPos + 135,yPos + 256);
        g.drawString("ABCD-1234",xPos + 15,yPos + 308);



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
        //TODO: LEPSZE PRZESUWANIE
        poprzedniaLokalizacja = e.getPoint();
        przesuwanie = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        przesuwanie = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //1280 i 720
//        if(przesuwanie){
//            Point aktualnaLokalizacja = e.getPoint();
//            this.p
//        }
        if( (e.getX() <=GAME_WIDTH) && (e.getX() >= 0) && (e.getY() < GAME_HEIGHT) && (e.getY() >= 0)){
            xPos=e.getX() -60;
            yPos=e.getY() -50;
            initBounds();
        }

        System.out.println(e.getX() + " oraz " + e.getY());

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public Rectangle getBounds() {
        return bounds;
    }
}
