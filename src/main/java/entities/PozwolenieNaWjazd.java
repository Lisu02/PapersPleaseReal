package entities;

import utils.WczytywaniePlikow;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import static org.main.Gra.GAME_HEIGHT;
import static org.main.Gra.GAME_WIDTH;

public class PozwolenieNaWjazd implements MouseMotionListener, MouseListener {

    //DANE NA POZWOLENIU NA WJAZD
    private String imie,nazwisko,kodPaszportu,cel,czasTrwania,data;

    private BufferedImage pozwolenieNaWjazdObraz;
    private BufferedImage stempelPozwolenia;

    private final Font fontDokumentu = WczytywaniePlikow.wczytajFont(WczytywaniePlikow.FONT_DO_DOKUMENTOW,15f);

    int xPos=700,yPos=234; //POZYCJA W ROGU DOKUMENTOW
    int szerokosc=280,wysokosc=374;
    private Rectangle bounds;

    private boolean przesuwanieDokumentu = false;
    private int przesuniecieX, przesuniecieY;


    private void initBounds() {
        bounds = new Rectangle(xPos, yPos, szerokosc,wysokosc); //TODO:>?>
    }


    public PozwolenieNaWjazd(){
        this.imie ="Mykolski";
        this.nazwisko  ="Wladimir";
        wczytajObrazPozwoleniaNaWjazd();
    }

    private void wczytajObrazPozwoleniaNaWjazd(){
        //TODO: DO ROZWINIĘCIA Z ZATWIERDZONYMI I ODRZUCONYMI PASZPORTAMI
        BufferedImage img = WczytywaniePlikow.GetSpriteAtlas("EntryPermitInner.png");
        //PassportInnerArstotzka.png
        pozwolenieNaWjazdObraz = img;
    }

    public void aktualizuj(){
        initBounds();
        //Aktualizowanie pozycji lub stanu zatwierdzenia paszportu
    }

    public void renderuj(Graphics g){
        g.drawImage(pozwolenieNaWjazdObraz,xPos,yPos,szerokosc,wysokosc,null);
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point punkt = e.getPoint();

        if (getBounds().contains(punkt)) {
            przesuwanieDokumentu = true;
            przesuniecieX = punkt.x - xPos;
            przesuniecieY = punkt.y - yPos;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
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

            xPos = noweX;
            yPos = noweY;

            initBounds();
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public Rectangle getBounds() {
        return bounds;
    }

}
