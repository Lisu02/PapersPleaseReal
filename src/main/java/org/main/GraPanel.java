package org.main;

import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

import static org.main.Gra.GAME_HEIGHT;
import static org.main.Gra.GAME_WIDTH;

public class GraPanel extends JPanel {

    private MouseInputs mouseInputs; //ZCZYTUJE MYSZKE
    Gra gra;

    public GraPanel(Gra gra){
        mouseInputs = new MouseInputs(this);
        this.gra = gra;
        ustawRozmiarPanelu();

        //TODO:USTAWIENIE NOWEGO KURSORA
//        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        Image ikonaKursora = toolkit.getImage("C:/Users/Karolina/IdeaProjects/PapersPleaseReal/src/main/res/CursorHand.png");
//        Cursor kursor = toolkit.createCustomCursor(ikonaKursora, new Point(0, 0), "My Coursor");
//        setCursor(kursor);


        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void ustawRozmiarPanelu(){
        Dimension rozmiar = new Dimension(GAME_WIDTH,GAME_HEIGHT);
        setPreferredSize(rozmiar);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        gra.renderuj(g);
    }


    public Gra getGra(){
        return gra;
    }




}
