package org.main;

import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GraPanel extends JPanel {

    private MouseInputs mouseInputs;
    Gra gra;
    public GraPanel(Gra gra){
        mouseInputs = new MouseInputs(this);
        this.gra = gra;
        ustawRozmiarPanelu();

        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void ustawRozmiarPanelu(){
        Dimension rozmiar = new Dimension(gra.GAME_WIDTH,gra.GAME_HEIGHT);
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
