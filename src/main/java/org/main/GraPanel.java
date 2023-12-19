package org.main;

import javax.swing.*;
import java.awt.*;

public class GraPanel extends JPanel {

    Gra gra;
    public GraPanel(Gra gra){
        this.gra = gra;
        ustawRozmiarPanelu();
    }

    private void ustawRozmiarPanelu(){
        Dimension rozmiar = new Dimension(gra.GAME_WIDTH,gra.GAME_HEIGHT);
        setPreferredSize(rozmiar);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        gra.renderuj(g);
    }




}
