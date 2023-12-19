package org.example.DaneGryDoGenerowania;
import java.util.Random;
public class KodyBledowe {

    private static String[] kody = {"POPRAWNY","BŁĘDNE MIEJSCE WYDANIA","ZŁE IMIE","ZŁY KOD PASZPORTU","ZŁY DYSTRYKT"};

    private static Random random = new Random();

    public static Integer wygenerujKodBledu(String panstwo){
        String slowo;
        if(panstwo.equals("ARZTOCKA")){
            int tmp = random.nextInt(kody.length-1);
            if(tmp == 3){tmp = 4;}
            //
            //
            // slowo = kody[random.nextInt(tmp)];//TO NA RAZIE ZBĘDNE TODO:pokombinować cos z tym
            return tmp;
        }else {
            int tmp = random.nextInt(kody.length-1);
            if(tmp == 4){tmp = 3;}
             //slowo = kody[random.nextInt(tmp)];
            return tmp;
        }
    }
}
