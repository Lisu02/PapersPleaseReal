package DaneGryDoGenerowania;

import utils.WczytywaniePlikow;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Twarz {

    private static BufferedImage twarzeKobietDuze ;
    private static BufferedImage twarzeKobietMale;
    private static BufferedImage twarzeMezczyznDuze;
    private static BufferedImage twarzeMezczyznMale;
    static int x;
    static int y;

    private static Random random = new Random();

    public static void initTwarze(){
//        for (int i = 0; i < 5; i++) {
//
//        }
        twarzeKobietDuze = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.TWARZE_KOBIET_DUZE_0);
        twarzeKobietMale = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.TWARZE_KOBIET_MALE_0);
        twarzeMezczyznDuze = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.TWARZE_MEZCZYZN_DUZE_0);
        twarzeMezczyznMale = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.TWARZE_MEZCZYZN_MALE_0);
    }

    public static BufferedImage getTwarzDuza(String plec){

        //TODO DODAĆ RANDOMOWE WYBIERANIE TWARZY RANDOM TYLKO TUTAJ GENERUJE SIE PRZY MALEJ TWARZY NIE I JEZELI NIE MA BLEDU
        //TO NIE ZMIENIAC A JAK JEST TO DAC TWARZ OBOK?1
        x = random.nextInt(2);
        y = random.nextInt(2);
           switch (plec){
               case "K":
                    return twarzeKobietDuze.getSubimage( 150*x,120*y,150,120);
               case "M":
                   return twarzeMezczyznDuze.getSubimage(150*x,120*y,150,120);
               default:
                   System.out.println("BŁAD WCZYTYWANIA TWARZY");
                   return null;
        }
    }
    public static BufferedImage getTwarzMala(String plec){
        switch (plec){
            case "K":
                return twarzeKobietMale.getSubimage( 150*x,120*y,150,120);
            case "M":
                return twarzeMezczyznMale.getSubimage(150*x,120*y,150,120);
            default:
                System.out.println("BŁAD WCZYTYWANIA TWARZY");
                return null;
        }
    }



}
