package entities;
import utils.Dzwieki;
import utils.WczytywaniePlikow;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Collection;

import gamestates.Stan.*;
import static org.main.Gra.SCALE;

public class RamieZatwierdzaniaOdrzucania implements MouseMotionListener, MouseListener {


    private BufferedImage StampBarBot = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.STAMP_BAR_BOT);
    private BufferedImage StampBarMid = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.STAMP_BAR_MID);
    private BufferedImage StampBarTop = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.STAMP_BAR_TOP);
    private BufferedImage StampBotApproved = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.STAMP_BOT_APPROVED);
    private BufferedImage StampBotDenied = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.STAMP_BOT_DENIED);
    private BufferedImage StampTop = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.STAMP_TOP);





    private int szerokosc;
    private int wysokosc;
    private int x;  // pozycja x wysuwającego się ramienia
    private int y;  // pozycja y wysuwającego się ramienia
    private int cienOffset;  // odległość cienia od wysuwającego się ramienia
    private int cienWysokosc;  // wysokość cienia
    private double offset = 1.9;
    private Rectangle border;
    private Rectangle borderDenied,borderApproved;
    int stampHeightDenied = 121*SCALE,stampTopHeightDenied = 101*SCALE;
    int stampHeightApproved = 121*SCALE,stampTopHeightApproved = 101*SCALE;
    boolean deniedObnizanie = false, approvedObnizanie = false;

    private Petent petent;

    private void initBorderBig(){
        border = new Rectangle(290*SCALE,126*SCALE,20*SCALE,60*SCALE);
        borderDenied = new Rectangle(330*SCALE,121*SCALE,75*SCALE,65*SCALE);
        borderApproved = new Rectangle(450*SCALE,121*SCALE,75*SCALE,65*SCALE);
    }

    private void initBorderSmall(){
        border = new Rectangle(550*SCALE,126*SCALE,20*SCALE,60*SCALE);
        borderDenied = new Rectangle((int)(330*SCALE*offset*2),121*SCALE,75*SCALE,65*SCALE);
        borderApproved = new Rectangle((int)(450*SCALE*offset*2),121*SCALE,75*SCALE,65*SCALE);
        //475
    }
    public RamieZatwierdzaniaOdrzucania(int szerokosc, int wysokosc, int cienOffset, int cienWysokosc) {
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
        this.cienOffset = cienOffset;
        this.cienWysokosc = cienWysokosc;
    }
    public RamieZatwierdzaniaOdrzucania(){
        this.szerokosc = 300;
        this.wysokosc = 40;
        this.cienOffset = 50;
        this.cienWysokosc = 50;
        x = 900;
        y = 400;
        initBorderSmall();
    }

    public void update(){
        //ZMIANA STANU RAMIENIA NA WYSUNIETY LUB SCHOWANY
        //APPROVED
        if(approvedObnizanie){
            if(stampHeightApproved >= 121*SCALE + 60){
                approvedObnizanie = false;
            }
            stampHeightApproved += 1;
            stampTopHeightApproved += 1;
//            if(stampHeightApproved >= 121*SCALE + 20){
//                stampTopHeightApproved += 1;
//            }
            //System.out.println(stampHeightApproved + "Wysokosc true");
        }
        if(!approvedObnizanie && stampHeightApproved >= 121*SCALE){
            stampHeightApproved -= 1;
            stampTopHeightApproved -= 1;
            if(stampHeightApproved < 121*SCALE)
            {
                Dzwieki.addDzwieki(Dzwieki.STEPEL_GORA);
                Dzwieki.odtworzDzwiek();
                //stampHeightApproved = 121*SCALE + 1;
            }
//            if(stampHeightApproved <= 121*SCALE + 50){
//                stampTopHeightApproved -= 1;
//            }
            System.out.println(stampHeightApproved + "Wysokosc false");
        }


        //DENIED
        if(deniedObnizanie){
            if(stampHeightDenied >= 121*SCALE + 60){
                deniedObnizanie = false;
            }
            stampHeightDenied += 1;
            stampTopHeightDenied+= 1;
        }
        if(!deniedObnizanie && stampHeightDenied >= 121*SCALE){
            stampHeightDenied -= 1;
            stampTopHeightDenied -= 1;
            if(stampHeightDenied < 121*SCALE)
            {
                Dzwieki.addDzwieki(Dzwieki.STEPEL_GORA);
                Dzwieki.odtworzDzwiek();
            }
        }


    }

    public void renderuj(Graphics g) {
        // Rysowanie cienia
        //g.setColor(new Color(0, 0, 0, 75));  // Czarny kolor cienia z przyciemnieniem (Alpha)
        //g.fillRect(x - cienOffset, y, szerokosc + cienOffset, cienWysokosc);
        g.drawImage(StampBarTop,(int) (290*SCALE*offset),120*SCALE,280*SCALE,47*SCALE,null);
        g.drawImage(StampBotDenied,(int) (330*SCALE*offset),stampHeightDenied,75*SCALE,65*SCALE,null);
        g.drawImage(StampBotApproved,(int)(450*SCALE*offset),stampHeightApproved,75*SCALE,65*SCALE,null);
        g.drawImage(StampBarMid,(int)(290*SCALE*offset),167*SCALE,280*SCALE,16*SCALE,null);
        g.drawImage(StampBarBot,(int)(290*SCALE*offset),183*SCALE,280*SCALE,20*SCALE,null);
        g.drawImage(StampTop,(int)(354*SCALE*offset),stampTopHeightDenied,27*SCALE,34*SCALE,null);
        g.drawImage(StampTop,(int)(474*SCALE*offset),stampTopHeightApproved,27*SCALE,34*SCALE,null);
        g.setColor(Color.BLUE);
        g.drawRect(border.x,border.y, border.width, border.height);
        g.drawRect(borderDenied.x,borderDenied.y, borderDenied.width, borderDenied.height);
        g.drawRect(borderApproved.x,borderApproved.y, borderApproved.width, borderApproved.height);
        //200 + 47 + 16 -? 247 263
        // Rysowanie ramienia zatwierdzania/odrzucania
        //g.setColor(new Color(150, 150, 150));  // Kolor ramienia
        //g.fillRect(x, y, szerokosc, wysokosc);(int)
    }



    public void mouseClicked(MouseEvent e) {
        if(isIn(e,border)){
            if(offset == 1.90){
                Dzwieki.addDzwieki(Dzwieki.ROZWINIECIE_STEPLA);
                Dzwieki.odtworzDzwiek();
                initBorderBig();
                offset = 1;
            }else{
                Dzwieki.addDzwieki(Dzwieki.ZWINIECIE_STEPLA);
                Dzwieki.odtworzDzwiek();
                initBorderSmall();
                offset = 1.90;
            }
        }
        if(isIn(e,borderDenied)){
            Dzwieki.addDzwieki(Dzwieki.STEPEL_DOL);
            Dzwieki.odtworzDzwiek();
            obnizStepelDenied();
            if(isIn(e,petent.getPaszport().getBounds())){
                petent.getPaszport().addStampDenied();
            }



        }
        if(isIn(e,borderApproved)){
            Dzwieki.addDzwieki(Dzwieki.STEPEL_DOL);
            Dzwieki.odtworzDzwiek();
            obnizStepelApproved();
            if(isIn(e,petent.getPaszport().getBounds())) {
                petent.getPaszport().addStampApproved();
                System.out.println("DENIEDSTAMP");
            }
        }

    }

    private void obnizStepelApproved() {
        approvedObnizanie = true;
    }
        //    int stampHeightDenied = 121*SCALE,stampTopHeightDenied = 101*SCALE;
    private void obnizStepelDenied() {
        deniedObnizanie = true;
    }

    private boolean isIn(MouseEvent e, Rectangle border) {
        return border.contains(e.getX(),e.getY());
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

    // Metody do ustawiania pozycji ramienia
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rectangle getBounds() {
        return border;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void setPetent(Petent petent) {
        this.petent = petent;
    }
}

