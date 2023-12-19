package DaneGryDoGenerowania;
import java.util.Random;
public class Dystrykty {

    private static String[] dystryktyPoprawne = {"Ałtan","Vescillo","Burnton","Octovalis","Gennistora","Lendiforma","Woznefield","Fardesto"};
    private static String[] dystryktyNiePoprawne = {"Bambus","Kaktus","Noga","Motyl"};
    private static Random random = new Random();
    public static String getDystrykt(int kodBledu){
        if(kodBledu == 4){return dystryktyNiePoprawne[random.nextInt(dystryktyNiePoprawne.length)];}
        else {return dystryktyPoprawne[random.nextInt(dystryktyPoprawne.length)];}
    }
}
