package utils;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class WczytywaniePlikow {

    public static final String PASZPORT_ARZTOCKA = "Arstotzka_passport.png";
    public static final String PASZPORT_KOLECHIA = "Kolechia_passport.png";
    public static final String PASZPORT_REPUBLIA = "Republia_passport.png";
    public static final String POZWOLENIE_NA_WJAZD1 = "Entry_permit.png";
    public static final String POZWOLENIE_NA_WJAZD2 = "entry_permit_empty.png";
    public static final String GRA_WYGLAD = "outside_sprites.png";

    public static final String PRZYCISK_GRA = "button_atlas.png";
    public static final String PRZYCISK_MENU = "button_atlas.png";

    //TEST
    public static final String MENU_BACKGROUND_ATLAS = "menu_background.png";
    public static BufferedImage GetSpriteAtlas(String nazwaPliku){
        BufferedImage img = null;
        InputStream is = WczytywaniePlikow.class.getResourceAsStream("/" + nazwaPliku);

        try{
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return img;
    }



}
