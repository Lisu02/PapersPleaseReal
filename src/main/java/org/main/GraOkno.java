package org.main;

import javax.swing.*;

public class GraOkno {

    private JFrame jRamka;

    public  GraOkno(GraPanel graPanel){
        jRamka = new JFrame();

        jRamka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jRamka.add(graPanel);
        jRamka.setResizable(false);
        jRamka.pack();
        jRamka.setVisible(true);


    }
}
