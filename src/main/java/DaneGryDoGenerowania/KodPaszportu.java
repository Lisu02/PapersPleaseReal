package org.example.DaneGryDoGenerowania;

import java.util.Arrays;
import java.util.Random;

public class KodPaszportu {
    private static char[] kodPaszportu = new char[9];
    private static Random random = new Random();


    public static String getKodPaszportu(){
        for(int i = 0 ; i < 4 ; i++){
            kodPaszportu[i]= (char) random.nextInt(65,90);
        }
        kodPaszportu[4] = '-';
        for(int i = 5 ; i < 9 ; i++){
            kodPaszportu[i]= (char) random.nextInt(48,57);
        }
        String kodWlasciwy;
        kodWlasciwy = Arrays.toString(kodPaszportu);
        kodWlasciwy = kodWlasciwy.replace(",","");
        kodWlasciwy = kodWlasciwy.replace("[","");
        kodWlasciwy = kodWlasciwy.replace("]","");
    return kodWlasciwy;
    }
    public static String giveKodPaszportu(String kodPaszportu,int kodBledu){
        if(kodBledu == 3) {
            char[] zmiana = kodPaszportu.toCharArray();
            zmiana[0] = kodPaszportu.charAt(2);
            zmiana[1] = kodPaszportu.charAt(3);
            zmiana[2] = 'E';
            String kodWlasciwy = new String(zmiana);
            kodWlasciwy = kodWlasciwy.replace(",","");
            kodWlasciwy = kodWlasciwy.replace("[","");
            return kodWlasciwy;
        }
        else {
            return kodPaszportu;
        }
    }

}
