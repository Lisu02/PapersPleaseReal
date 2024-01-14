package DaneGryDoGenerowania;

import utils.WczytywaniePlikow;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Twarz {

    private static BufferedImage twarzeKobietDuze ;
    private static BufferedImage twarzeKobietMale;
    private static BufferedImage[] twarzeMezczyznDuze = new BufferedImage[5];
    private static BufferedImage[] TwarzeMezczyznMale = new BufferedImage[5];

    private static Random random = new Random();

    public static void initTwarze(){
//        for (int i = 0; i < 5; i++) {
//
//        }
        twarzeKobietDuze = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.TWARZE_KOBIET_DUZE_0);
        twarzeKobietMale = WczytywaniePlikow.GetSpriteAtlas(WczytywaniePlikow.TWARZE_KOBIET_MALE_0);
//        twarzeMezczyznDuze = ;
//        twarzeMezczyznMale = ;
    }

    public static BufferedImage getTwarzDuza(String plec){

        //TODO DODAĆ RANDOMOWE WYBIERANIE TWARZY RANDOM TYLKO TUTAJ GENERUJE SIE PRZY MALEJ TWARZY NIE I JEZELI NIE MA BLEDU
        //TO NIE ZMIENIAC A JAK JEST TO DAC TWARZ OBOK?1
        int x = random.nextInt(2), y = random.nextInt(2);
//        switch (plec){
//            case "K" -> {
                return twarzeKobietDuze.getSubimage(0,0,150,120);
            //}
        //}
       // return null;
    }



}
