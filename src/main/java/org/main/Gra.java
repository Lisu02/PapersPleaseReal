package org.main;

import gamestates.Granie;
import gamestates.Stangry;
import gamestates.Menu;

import java.awt.*;

public class Gra implements Runnable{

    private Thread watekGry;
    private GraPanel graPanel;
    private GraOkno graOkno;

    private Granie granie;
    private Menu menu;

    public final static int GAME_WIDTH = 1280;
    public final static int GAME_HEIGHT = 720;
    public final int FPS_SET = 120;
    private final int UPS_SET = 200;


    public Gra(){
        wczytajKlasy();// Wczytywanie wszystkich kluczowych klas

        //Wczytanie okna i jego zawartości
        graPanel = new GraPanel(this);
        graOkno = new GraOkno(graPanel);
        graPanel.requestFocus(); // ??Sprawdz wazne focus
        rozpocznijPetleGry(); //Na samym koncu
    }

    private void wczytajKlasy() {
        //MOCKUP WCZYTANIA KLAS
        granie = new Granie(this);
        menu = new Menu(this);

    }

    public void renderuj(Graphics g){
        //ELEMENT ODPOWIEDZIALNY ZA GENEROWANIE CALEJ GRAFIKI GRY
        //W ZALEZNOSCI OD STANU GRY

        switch (Stangry.state){
            case MENU -> menu.rysuj(g);
            case GRANIE -> granie.rysuj(g);
        }

    }

    public void rozpocznijPetleGry(){
        watekGry = new Thread(this);
        watekGry.start();
    }

    public void aktualizuj(){
        switch (Stangry.state){
            case MENU -> menu.aktualizuj();
            case GRANIE -> granie.aktualizuj();
            case QUIT,OPTIONS -> System.exit(0);
        }
    }



    @Override
    public void run() {
        //PĘTLA GRY

        double timePerFrame = 1000000000.0 /FPS_SET;
        double timePerUpdate = 1000000000.0 /UPS_SET;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while(true){
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if(deltaU >= 1){
                aktualizuj();
                updates++;
                deltaU--;
            }

            if(deltaF >= 1){
                graPanel.repaint();
                frames++;
                deltaF--;
            }

            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                //System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    public Gra getGra(){
        return this;
    }

    public Menu getMenu() {
        return menu;
    }

    public Granie getGranie(){
        return granie;
    }

}
