package ui;

import org.main.Gra;
import utils.WczytywaniePlikow;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utils.Stale.UI.Przyciski.*;

public class GraPrzycisk {

    private int xPos, yPos, columnIndex;
    private int yOffsetCenter = B_WIDTH; //TODO:???
    private BufferedImage[] images;

    private int index;
    private boolean mousePressed;
    private boolean mouseOver;
    private Rectangle bounds;


    public GraPrzycisk(int xPos, int yPos,int columnIndex){
        this.xPos = xPos;
        this.yPos = yPos;
        this.columnIndex = columnIndex;



        loadImages();
        initBounds();
    }

    private void initBounds() {
        bounds = new Rectangle(xPos, yPos - yOffsetCenter, B_WIDTH,B_HEIGHT); //TODO:>?>
    }

    private void loadImages() {
        images = new BufferedImage[2];
        BufferedImage tmp = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.PRZYCISK_GRA);
        for (int i = 0; i < 2; i++) {
            images[i] = tmp.getSubimage(i*B_WIDTH_DEFAULT,columnIndex*B_HEIGHT_DEFAULT,B_WIDTH_DEFAULT,B_HEIGHT_DEFAULT);

        }
    }

    public void rysuj(Graphics g){
        g.drawImage(images[index],xPos, yPos - yOffsetCenter,B_WIDTH,B_HEIGHT,null);
    }

    public void update(){
        index = 0;
        if(mouseOver){index = 1;}
        if (mousePressed){index =2;}
    }

    public boolean isMousePressed(){
        return mousePressed;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }

    public boolean isMouseOver() {
        return mouseOver;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public void resetBools(){
        mouseOver = false;
        mousePressed = false;
    }




}
