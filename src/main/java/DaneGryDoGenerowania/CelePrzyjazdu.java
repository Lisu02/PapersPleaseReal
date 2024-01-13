package DaneGryDoGenerowania;

import java.util.Objects;
import java.util.Random;

public class CelePrzyjazdu {

    private static String[] celPrzyjazdu = {"TRANSIT","VISIT","WORK","IMMIGRATION"};
    private static String[] czasPrzyjazdu = {"2 DAYS","3 DAYS","7 DAYS","14 DAYS","3 MONTHS","6 MONTHS","FOREVER"};
    //od 0 do 3 TRANSIT ORAZ VISIT
    //od 4 do 5 WORK
    //IMIGRTION FOREVER
    private static Random random = new Random();
    public static String getCelPrzyjazdu(){
        return celPrzyjazdu[random.nextInt(celPrzyjazdu.length)];
    }

    public static String getCzasPrzyjazdu(String celprzyjazdu){
        if( (Objects.equals(celprzyjazdu, "TRANSIT")) || (Objects.equals(celprzyjazdu, "VISIT")) ){
            return czasPrzyjazdu[random.nextInt(czasPrzyjazdu.length-3)];
        }
        if(Objects.equals(celprzyjazdu, "WORK")){
            return czasPrzyjazdu[random.nextInt(4,5)];
        }
        if(Objects.equals(celprzyjazdu, "IMMIGRATION")){return czasPrzyjazdu[6];}
        return "BRAK WARUNKU";
    }
}
