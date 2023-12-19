package org.example.DaneGryDoGenerowania;

public class Ksiazka {

    private static String[][] strony;

    static{
        String[] stronaWstepu = {

                "┳┳┓┳┳┓┳┏┓┏┳┓┏┓┳┓┏┓┏┳┓┓ ┏┏┓  ┏┓┳┓┏┓┓┏┏┳┏┓┏┓ ",
                "┃┃┃┃┃┃┃┗┓ ┃ ┣ ┣┫┗┓ ┃ ┃┃┃┃┃  ┃┃┣┫┏┛┗┫ ┃┣ ┃",
                "┛ ┗┻┛┗┻┗┛ ┻ ┗┛┛┗┗┛ ┻ ┗┻┛┗┛  ┣┛┛┗┗┛┗┛┗┛┗┛┗┛",
                "",
                "┏┓┏┓┏┓┏┓┳┓┓┏  ┳  ┳┓┏┓┏┓┳┳┓ ┏┓┏┓┏┳┏┓",
                "┏┛┣┫┗┓┣┫┃┃┗┫  ┃  ┣┫┣ ┃┓┃┃┃ ┣┫┃  ┃┣",
                "┗┛┛┗┗┛┛┗┻┛┗┛  ┻  ┛┗┗┛┗┛┗┛┗┛┛┗┗┛┗┛┗┛",
                "",
                "┳┓┓ ┏┓  ┳┳┓┏┓┏┓┏┓┓┏┓┏┳┓┏┓┳┓┏┓┓ ┏",
                "┃┃┃ ┣┫  ┃┃┃┗┓┃┃┣ ┃┫  ┃ ┃┃┣┫┃┃┃┃┃",
                "┻┛┗┛┛┗  ┻┛┗┗┛┣┛┗┛┛┗┛ ┻ ┗┛┛┗┗┛┗┻┛",
                "",

        };
        String[] stronaZasad = {

                "| Petenci muszą mieć paszport",
                "",
                "| Obywatele muszą mieć dowód osobisty",
                "",
                "| Cudzoziemcy muszą mieć zgode na wjazd",
                "",
                "| Wszystkie dane między dokumentami muszą się zgadzać",
                "",
                "| Miejsca wydania i dystrykty muszą być prawidłowe",
                "",
                "| Dokumenty muszą być zgodne z terminem ważności"

        };
        String[] stronaPanstw = {
                "ZAWRÓĆ",
                "ARZTOCKA",
                "KOLECHIA",
                "ZJEDNOCZONA FEDERACJA"

        };
        String[] stronaPanstwWydanieArztocka = {
                "┏┓┳┓┏┓┏┳┓┏┓┏┓┓┏┓┏┓",
                "┣┫┣┫┏┛ ┃ ┃┃┃ ┃┫ ┣┫",
                "┛┗┛┗┗┛ ┻ ┗┛┗┛┛┗┛┛┗",
                "",
                "MIASTA WYDAJĄCE PASZPORT",
                "Orvech Vonor",
                "Wsch.Grestin",
                "Paradizna",
                " ",
                "DYSTRYKTY",
                "Ałtan",
                "Vescillo",
                "Burnton",
                "Octovalis",
                "Gennistora",
                "Lendiforma",
                "Wozenfield",
                "Fardesto"
        };
        String[] stronaPanstwWydanieKolechia = {
                "┓┏┓┏┓┓ ┏┓┏┓┓┏┳┏┓",
                "┃┫ ┃┃┃ ┣ ┃ ┣┫┃┣┫",
                "┛┗┛┗┛┗┛┗┛┗┛┛┗┻┛┗",
                " ",
                "Miasta wydajace paszport",
                "Skal",
                "Lorndaz",
                "Mergerous"

        };
        String[] stronaPanstwWydanieZjednoczonaFederacja = {
                "┏┓┏┳┏┓┳┓┳┓┏┓┏┓┏┓┏┓┳┓┏┓  ┏┓┏┓┳┓┏┓┳┓┏┓┏┓┏┳┏┓",
                "┏┛ ┃┣ ┃┃┃┃┃┃┃ ┏┛┃┃┃┃┣┫  ┣ ┣ ┃┃┣ ┣┫┣┫┃  ┃┣┫",
                "┗┛┗┛┗┛┻┛┛┗┗┛┗┛┗┛┗┛┛┗┛┗  ┻ ┗┛┻┛┗┛┛┗┛┗┗┛┗┛┛┗",
                " ",
                "Miasta wydające paszport",
                "Great Rapid",
                "Shingleton",
                "KoristaCity"

        };
        strony = new String[][]{stronaWstepu, stronaZasad, stronaPanstw, stronaPanstwWydanieArztocka, stronaPanstwWydanieKolechia, stronaPanstwWydanieZjednoczonaFederacja};
    }


//    public static String[] getSronaTest(){
//        String[] wynik = new String[strony[wybor].length];
//        for(int i = 0 ; i < twarze[wybor].length ; i++)
//        {
//            wynik[i] = twarze[wybor][i];
//        }
//        return wynik;
//    }

    public void zmienZasady(){}

    public static String[] getStrona(String nazwaStrony){
        switch (nazwaStrony){
            case "STRONA WSTEPU":
                return strony[0];
            case "PODSTAWOWE ZASADY":
                return strony[1];
            case "PAŃSTWA":
                return strony[2];
            case "KsiazkaArztocka":
                return  strony[3];
            case "KsiazkaKolechia":
                return strony[4];
            case "KsiazkaZjednoczonaFederacja":
                return strony[5];
            case "ZAWRÓĆ":
                return strony[0];
        }
        return null;
    }
}
