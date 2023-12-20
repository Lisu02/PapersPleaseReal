package gamestates;

import entities.Paszport;
import level.HandlerPoziomu;
import org.main.Gra;
import ui.GraPrzycisk;
import utils.Stale;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Granie extends Stan implements Metodystanu {

    private HandlerPoziomu handlerPoziomu;
    private Paszport paszport;
    private GraPrzycisk[] przyciski = new GraPrzycisk[2];

    public Granie(Gra gra) {
        super(gra);
        wczytajKlasy();
        wczytajPrzyciski();
    }

    private void wczytajPrzyciski() {
        przyciski[0] = new GraPrzycisk(400,750,0);
        przyciski[1] = new GraPrzycisk(600,750,1);

    }

    private void wczytajKlasy(){
        handlerPoziomu = new HandlerPoziomu(gra);
        paszport = new Paszport();
    }

    @Override
    public void aktualizuj() {
        handlerPoziomu.aktualizuj();
        paszport.aktualizuj();
        for (GraPrzycisk gp: przyciski){
            gp.update();
        }
    }

    @Override
    public void rysuj(Graphics g) {
        handlerPoziomu.rysuj(g);
        paszport.renderuj(g);

        for(GraPrzycisk mb : przyciski){
            mb.rysuj(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for(GraPrzycisk gp : przyciski){
            if(isIn(e,gp)){
                gp.setMousePressed(true);
                break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for(GraPrzycisk gp : przyciski){
            if(isIn(e,gp)){
                if(gp.isMousePressed()){
                    break;
                }
            }
        }
        resetButtons();

    }

    private void resetButtons() {
        for(GraPrzycisk gp: przyciski){
            gp.resetBools();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for(GraPrzycisk gp: przyciski){
            gp.setMouseOver(false);
        }

        for(GraPrzycisk gp: przyciski){
            if(isIn(e,gp)){
                gp.setMouseOver(true);
                break;
            }
        }
    }
}
