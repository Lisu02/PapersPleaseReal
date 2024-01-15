package ui;

import gamestates.Metodystanu;
import gamestates.Stangry;
import utils.WczytywaniePlikow;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utils.Stale.UI.Przyciski.*;
import static utils.Stale.UI.Przyciski.B_HEIGHT_DEFAULT;

public class MenuPrzycisk {


    private int xPos, yPos, columnIndex;
    private int yOffsetCenter = B_HEIGHT; //TODO:???
    private BufferedImage[] images;
    private Stangry stangry;
    private String stan;

    private int index;

    private boolean mousePressed , mouseOver;
    private Rectangle bounds;

    public MenuPrzycisk(String stan){
        this.stan = stan.toUpperCase();
    }
    public MenuPrzycisk(int xPos, int yPos, int columnIndex, Stangry stan){

        this.xPos = xPos;
        this.yPos = yPos;
        this.columnIndex = columnIndex;
        this.stangry = stan;



        loadImages();
        initBounds();

    }

    private void initBounds() {
        bounds = new Rectangle(xPos, yPos - yOffsetCenter, B_WIDTH,B_HEIGHT);
    }

    private void loadImages() {
        images = new BufferedImage[3];
        BufferedImage tmp = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.PRZYCISK_GRA);
        for (int i = 0; i < images.length; i++) {
            images[i] = tmp.getSubimage(i*B_WIDTH_DEFAULT,columnIndex*B_HEIGHT_DEFAULT,B_WIDTH_DEFAULT,B_HEIGHT_DEFAULT);

        }
    }

    public void aktualicuj() {
        index = 0;
        if(mouseOver){index = 1;}
        if (mousePressed){index =2;}
    }

    public void rysuj(Graphics g) {
        g.drawImage(images[index],xPos, yPos - yOffsetCenter,B_WIDTH,B_HEIGHT,null);

    }


    public boolean getMousePressed(){
        return mousePressed;
    }
    public void setMousePressed(boolean b) {
        this.mousePressed = b;
    }
    public boolean getMouseOver(){
        return mouseOver;
    }
    public void setMouseOver(boolean b){
        this.mouseOver = b;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void resetBools(){
        mouseOver = false;
        mousePressed = false;
    }

    public void zastosujStanGry(){
        Stangry.state = stangry;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }
}
