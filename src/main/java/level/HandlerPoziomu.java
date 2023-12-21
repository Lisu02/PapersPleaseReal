package level;

import org.main.Gra;
import utils.WczytywaniePlikow;

import java.awt.*;
import java.awt.image.BufferedImage;

public class HandlerPoziomu {

    private Gra gra;
    private BufferedImage poziomSprite;


    public HandlerPoziomu(Gra gra){
        this.gra = gra;
        wczytajGraWyglad();
    }

    private void wczytajGraWyglad(){
        BufferedImage img = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.GRA_WYGLAD);
        poziomSprite = img;
    }

    public void rysuj(Graphics g){
        g.drawImage(poziomSprite,300,300,384,128,null);
    }

    public void aktualizuj(){
        //Aktualizowanie i nanoszenie zmian na poziom?
    }

}
