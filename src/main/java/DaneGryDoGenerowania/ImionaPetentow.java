package DaneGryDoGenerowania;
import java.util.Random;
public class ImionaPetentow {

    private static String[] imiona = {
            "Aarya","Akshara","Dragan","Carlos","Kayden","Leonardo","Natalie","Pedro","Jewgenij","Pablo","Antonio","Leonarde"
    };
    private static  String[] nazwiska = {
      "Petkovski","Kostovski","Kavaliauskas","Ferrari","Abuladze","Durand","Hendriks","Lopes","Wagner","Papner","Kapritiozo"
    };

    private static Random random = new Random();

    public static String getImie(){
        return imiona[random.nextInt(imiona.length)] + " " + nazwiska[random.nextInt(nazwiska.length)];
    }
    public static String giveImie(String imie,int kodBledu){
        //TODO: OPERACJE NA IMIE JEŻELI KOD BLEDU NIE OBEJMUJE BLEDU TO WYDAC ZWYKLE IMIE
        if(kodBledu != 2){return imie;}
        else {
            //TODO:TUTAJ (SPRYTNY MYK RYZYKO TEGO SAMEGO IMIENIA NA RAZIE)
            return getImie();
            //return "IMIE Z BŁĘDEM";
        }
    }
}
