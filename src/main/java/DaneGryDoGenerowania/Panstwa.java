package DaneGryDoGenerowania;
import java.util.Random;
public class Panstwa {

    private static String[] tablicaPanstw = {"ARSTOTZKA","KOLECHIA","ZJEDNOCZONA FEDERACJA"};

    private static Random random = new Random();
    public static String getPanstwo(){
        return tablicaPanstw[random.nextInt(tablicaPanstw.length)];
    }
}
