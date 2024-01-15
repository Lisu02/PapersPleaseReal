package utils;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;
import java.io.FileNotFoundException;

public class Dzwieki {

    private static Clip clip;
    private static FloatControl gainControl;

    public static final String GLOWNA_MUZYKA = "src/main/res/audio/Glowna-Muzyka.wav";

    public static final String ALARM = "src/main/res/audio/Border-Alarm.wav";
    public static final String PODNOSZENIE_KARTKI_0 = "src/main/res/audio/Paper-Dragstart0.wav";
    public static final String PODNOSZENIE_KARTKI_1 = "src/main/res/audio/Paper-Dragstart1.wav";
    public static final String PODNOSZENIE_KARTKI_2 = "src/main/res/audio/Paper-Dragstart2.wav";

    public static final String OPUSZCZANIE_KARTKI_0 = "src/main/res/audio/Paper-Dragstop0.wav";
    public static final String OPUSZCZANIE_KARTKI_1 = "src/main/res/audio/Paper-Dragstop1.wav";
    public static final String OPUSZCZANIE_KARTKI_2 = "src/main/res/audio/Paper-Dragstop2.wav";

    public static final String DZWIEK_TLA = "src/main/res/audio/Border-Ambient.wav";
    public static final String OPUSZCZENIE_KRAT = "src/main/res/audio/Shutter Drop.wav";
    public static final String PODNIESIENIE_KRAT = "src/main/res/audio/Shutter Rise.wav";
    public static final String MEGAFON_GRACZ = "src/main/res/audio/Speech Announce.wav";
    public static final String STEPEL_DOL = "src/main/res/audio/Stamp Down.wav";
    public static final String STEPEL_GORA = "src/main/res/audio/Stamp Up.wav";
    public static final String ROZWINIECIE_STEPLA = "src/main/res/audio/Stampbar Open.wav";
    public static final String ZWINIECIE_STEPLA = "src/main/res/audio/Stampbar Close.wav";





    public static void addDzwieki(String sciezkaDoDzwieku) {
        try {
            //System.out.println("Katalog roboczy: " + System.getProperty("user.dir"));

            File plikDzwieku = new File(sciezkaDoDzwieku);

            if (!plikDzwieku.exists()) {
                throw new FileNotFoundException("Plik dźwiękowy nie istnieje: " + sciezkaDoDzwieku);
            }

            AudioInputStream audioInput = AudioSystem.getAudioInputStream(plikDzwieku);
            clip = AudioSystem.getClip();
            clip.open(audioInput);

            gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            //ustawGlosnosc(1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void odtworzDzwiek(String sciezkaDoDzwieku) {
        addDzwieki(sciezkaDoDzwieku);
        if (clip != null && !clip.isRunning()) {
            clip.setFramePosition(0);  // Przewiń do początku przed odtworzeniem
            clip.start();
        }
    }

    public static void odtworzDzwiek() {
        if (clip != null && !clip.isRunning()) {
            clip.setFramePosition(0);  // Przewiń do początku przed odtworzeniem
            clip.start();
        }
    }

    public static void zatrzymajDzwiek() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public static void ustawGlosnosc(float wartosc) {
        if (gainControl != null) {
            gainControl.setValue(wartosc);
        }
    }

    public static float pobierzGlosnosc() {
        if (gainControl != null) {
            return gainControl.getValue();
        }
        return 0.0f;
    }

}

