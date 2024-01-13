package DaneGryDoGenerowania;
import java.util.Random;
public class MiastaWydajaceDokument {

    private static final String[] arztockaMiasta = {"Orvech Vonor", "Wsch.Grestin", "Paradizna"};
    private static final String[] kolechiaMiasta = {"Yurko City", "Vedor", "Zach.Grestin"};
    private static final String[] zjednoczFedMiasta = {"Great Rapid", "Shingleton", "Korista City"};
    private static final String[] bledneMiasta = {"Great Papid","Singleton","Tel Awiw","Ogurko City"};
    private static final Random random = new Random();

    public static String getMiasto(String kraj,int kodBledu){
        if(kodBledu != 1){
            return switch (kraj) {
                case "ARSTOTZKA" -> arztockaMiasta[random.nextInt(arztockaMiasta.length)];
                case "KOLECHIA" -> kolechiaMiasta[random.nextInt(kolechiaMiasta.length)];
                case "ZJEDNOCZONA FEDERACJA" -> zjednoczFedMiasta[random.nextInt(zjednoczFedMiasta.length)];
                default -> "";
            };
        }else{
            return bledneMiasta[random.nextInt(bledneMiasta.length)];
        }
    }

}
