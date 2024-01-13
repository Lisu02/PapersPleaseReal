package DaneGryDoGenerowania;

import java.util.Random;

public class DataWaznosci {
    private static Random random = new Random();

    public static String generateRandomDataWaznosciString() {
        int year = random.nextInt(2031 - 2024 + 1) + 2024; // Losowy rok między 2024 a 2031
        int month = random.nextInt(12) + 1; // Losowy miesiąc od 1 do 12
        int day;

        if (month == 2) {
            // Luty - uwzględnij przestępny rok
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                day = random.nextInt(29) + 1;
            } else {
                day = random.nextInt(28) + 1;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            // Kwiecień, czerwiec, wrzesień, listopad - 30 dni
            day = random.nextInt(30) + 1;
        } else {
            // Pozostałe miesiące - 31 dni
            day = random.nextInt(31) + 1;
        }

        String dayStr = String.format("%02d", day);
        String monthStr = String.format("%02d", month);
        String yearStr = String.valueOf(year);


        return dayStr + "/" + monthStr + "/" + yearStr;
    }

//    public static String[] generateRandomDataWaznosciArray() {
//        String dataWaznosciString = generateRandomDataWaznosciString();
//        return dataWaznosciString.split("/");
//    }

}

