package utils;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class WczytywaniePlikow {


    //TŁO - DO ODZIELENIA GRA WYGLAD


    //DOKUMENTY
    public static final String PASZPORT_ARZTOCKA_DUZY = "PassportInnerArstotzka.png";
    public static final String PASZPORT_ARZTOCKA_MALY = "PassportOuterArstotzka.png";
    public static final String PASZPORT_KOLECHIA_DUZY = "PassportInnerKolechia.png";
    public static final String PASZPORT_KOLECHIA_MALY = "PassportOuterKolechia.png";
    public static final String PASZPORT_ZJEDONOCZNA_FED_DUZY = "PassportInnerUnitedFed.png";
    public static final String PASZPORT_ZJEDONOCZONA_FED_MALY = "PassportOuterUnitedFed.png";

    public static final String POZWOLENIE_NA_WJAZD_DUZY = "EntryPermitInner.png";
    public static final String POZWOLENIE_NA_WJAZD_MALY = "EntryPermitOuter.png";

    public static final String DOWOD_OSOBISTY_DUZY = "IdCardInner.png";
    public static final String DOWOD_OSOBISTY_MALY = "IdCardOuter.png";

    //TŁO GRY
    public static final String GRA_WYGLAD = "tlo_gry.png";
    public static final String TLO_GORA = "CheckpointBack.png";
    public static final String BIURKO = "Desk.png";
    public static final String BUDKA = "OuterBooth.png";
    public static final String KRATY = "Shutter.png";
    public static final String KRATY_DZWIGNIA_UP = "ShutterSwitchUp.png";
    public static final String KRATY_DZWIGNIA_DOWN = "ShutterSwitchDown.png";
    public static final String SCIANA_BUDKI = "BoothWall.png";


    //PRZYCISKI
    public static final String PRZYCISK_GRA = "button_atlas.png";
    public static final String PRZYCISK_MENU = "button_atlas.png";

    //FONTY
    public static final String FONT_DO_DOKUMENTOW ="BMmini.TTF";
    public static final String FONT_OGOLNY = "pixelplay.ttf";

    //TEST
    public static final String MENU_BACKGROUND_ATLAS = "menu_background.png";
    public static final String TLUM1 = "crowd1.png";
    public static final String TLUM2 = "crowd2.png";
    public static final String TLUM3 = "crowd3.png";
    public static final String TLUM4 = "crowd4.png";

    //MENU
    public static final String ORZELEK_TLO = "";

    public static Font wczytajFont(String nazwaPliku, float rozmiar) {
        Font customFont = null;
        InputStream is = WczytywaniePlikow.class.getResourceAsStream("/" + nazwaPliku);

        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(rozmiar);

            // Dodaj niestandardowy font do systemowego środowiska fontów
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
        } catch (IOException | java.awt.FontFormatException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return customFont;
    }

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
