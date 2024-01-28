package level;

import DaneGryDoGenerowania.Twarz;
import org.main.Gra;
import utils.WczytywaniePlikow;

import java.awt.*;
import java.awt.image.BufferedImage;

import static DaneGryDoGenerowania.Twarz.getTwarzDuza;
import static org.main.Gra.*;

public class HandlerPoziomu {

    private Gra gra;
    private BufferedImage poziomSprite;
    private BufferedImage tloGora;

    private BufferedImage[] budkaZGlosnikiem = new BufferedImage[2];
    private BufferedImage scianaBudki;
    private BufferedImage biurko;
    private BufferedImage[] wajcha = new BufferedImage[2];

    private BufferedImage twarzNaSciance ;


    private BufferedImage[] tlumSprite = new BufferedImage[4];
    private int indexTlum = 0;
    private BufferedImage radioSprite; //RAZEM Z BUTTONEM?
    private int licznik=0;
    private int indexBudki = 0;
    private int animacjaTwarz = 0;

    public HandlerPoziomu(Gra gra){
        Twarz.initTwarze();
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

        img = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.TLO_GORA);
        tloGora = img;

        img = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.BUDKA);
        budkaZGlosnikiem[0] = img;

        img = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.SCIANA_BUDKI);
        scianaBudki = img;

        img = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.BIURKO);
        biurko = img;

        img = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.TWARZE_KOBIET_DUZE_0);
        img = getTwarzDuza("K");
        twarzNaSciance = img;
                //= img.getSubimage(0,0,150,120);
    }

    public void rysuj(Graphics g){
        g.drawImage(tloGora,0,0,570*SCALE,103*SCALE,null);
        g.drawImage(budkaZGlosnikiem[indexBudki],(103*SCALE)+(42*SCALE),(178*SCALE)-(114*SCALE),FINAL_GAME_WIDTH/10,FINAL_GAME_HEIGHT/4,null);
        g.drawImage(scianaBudki,0,103*SCALE,178*SCALE,135*SCALE,null);
        g.drawImage(twarzNaSciance,10*SCALE,103*SCALE,150*SCALE,120*SCALE,null);
        g.drawImage(biurko,0,103*SCALE,570*SCALE,217*SCALE,null);



    }

    public void zmienTwarz(String plec){
        BufferedImage img = getTwarzDuza(plec);
        twarzNaSciance = img;
    }

    public void aktualizuj(){
        //Aktualizowanie i nanoszenie zmian na poziom?0
        if(licznik % 30 == 0){

        }
        licznik++;

    }

}
