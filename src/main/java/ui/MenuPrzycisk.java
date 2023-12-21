package ui;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utils.Stale.UI.Przyciski.B_HEIGHT;
import static utils.Stale.UI.Przyciski.B_WIDTH;

public class MenuPrzycisk {


    private int xPos, yPos, columnIndex;
    private int xOffsetCenter = B_WIDTH; //TODO:???
    private BufferedImage[] images;

    private int index;

    private boolean mousePressed , mouseOver;
    private Rectangle bounds;

    public void aktualicuj() {
    }

    public void rysuj() {

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

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }
}
