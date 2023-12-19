package gamestates;

import entities.Paszport;
import level.HandlerPoziomu;
import org.main.Gra;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Granie extends Stan implements Metodystanu {

    private HandlerPoziomu handlerPoziomu;
    private Paszport paszport;

    public Granie(Gra gra) {
        super(gra);
        wczytajKlasy();
    }

    private void wczytajKlasy(){
        handlerPoziomu = new HandlerPoziomu(gra);
        paszport = new Paszport();
    }

    @Override
    public void aktualizuj() {
        handlerPoziomu.aktualizuj();
        paszport.aktualizuj();
    }

    @Override
    public void rysuj(Graphics g) {
        handlerPoziomu.rysuj(g);
        paszport.renderuj(g);
    }

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
    public void mouseMoved(MouseEvent e) {

    }
}
