package level;

import org.main.Gra;
import utils.WczytywaniePlikow;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.main.Gra.GAME_HEIGHT;
import static org.main.Gra.GAME_WIDTH;

public class HandlerPoziomu {

    private Gra gra;
    private BufferedImage poziomSprite;
    private BufferedImage[] tlumSprite = new BufferedImage[4];
    private int indexTlum = 0;
    private BufferedImage radioSprite; //RAZEM Z BUTTONEM?
    private int licznik=0;


    public HandlerPoziomu(Gra gra){
        this.gra = gra;
        wczytajGraWyglad();
    }

    private void wczytajGraWyglad(){
        BufferedImage img = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.GRA_WYGLAD);
        poziomSprite = img;

        img = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.TLUM1);
        tlumSprite[0] = img;
        img = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.TLUM2);
        tlumSprite[1] = img;
        img = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.TLUM3);
        tlumSprite[2] = img;
        img = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.TLUM4);
        tlumSprite[3] = img;

    }

    public void rysuj(Graphics g){
        g.drawImage(poziomSprite,0,0,GAME_WIDTH,GAME_HEIGHT,null);
       // g.drawImage(tlumSprite[indexTlum],0,0,328,215,null);
        //indexTlum++;
    }

    public void aktualizuj(){
        //Aktualizowanie i nanoszenie zmian na poziom?0
        if(licznik % 100 == 0){
            indexTlum = indexTlum%3 + 1;
        }
        licznik++;

    }

}
