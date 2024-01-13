package entities;

import java.awt.*;
import java.util.ArrayList;

import static DaneGryDoGenerowania.DataWaznosci.generateRandomDataWaznosciString;
import static DaneGryDoGenerowania.ImionaPetentow.*;
import static DaneGryDoGenerowania.KodPaszportu.getKodPaszportu;
import static DaneGryDoGenerowania.KodPaszportu.giveKodPaszportu;
import static DaneGryDoGenerowania.KodyBledowe.wygenerujKodBledu;
import static DaneGryDoGenerowania.MiastaWydajaceDokument.getMiasto;
import static DaneGryDoGenerowania.Panstwa.getPanstwo;
import static DaneGryDoGenerowania.RandomDataUrodzenia.getDataUrodzenia;

public class Petent {




    private String imie,nazwisko;
    private String plec;
    private String  dataUrodzin;
    private String miejsceWydaniaPaszportu;
    private String dataWygasnieciaPaszportu;
    private String krajPochodzenia;
    private String kodPaszportu;

    private int kodBledu; //Petent


    ArrayList<Dokument> dokumentArrayList = new ArrayList<>();

    private Paszport paszport;
    private PozwolenieNaWjazd pozwolenieNaWjazd;
    private DowodOsobisty dowodOsobisty;

    //TODO:GENEROWANIE PETENTÓW AUTOMATYCZNIE (PRZYPADKOWE SCENARIUSZE)
    public Petent() {
        this.krajPochodzenia = getPanstwo();
        this.kodBledu = wygenerujKodBledu(krajPochodzenia);
        this.plec = getPlec();
        this.imie = getImie();
        this.nazwisko = getNazwisko();
        this.dataUrodzin = getDataUrodzenia();
        this.dataWygasnieciaPaszportu = generateRandomDataWaznosciString();
        this.kodPaszportu = getKodPaszportu();
        this.miejsceWydaniaPaszportu = getMiasto(this.krajPochodzenia,kodBledu);

        paszport = new Paszport();
        paszport.setDanePaszportu(imie,nazwisko,dataUrodzin,plec,miejsceWydaniaPaszportu,dataWygasnieciaPaszportu,kodPaszportu,krajPochodzenia);
        dokumentArrayList.add(paszport);
        if(krajPochodzenia == "ARSTOTZKA"){
            dowodOsobisty = new DowodOsobisty();
            dowodOsobisty.setDaneDowodu(giveImie(imie,kodBledu),getNazwisko(),getDataUrodzenia(),getKodBledu());
            dokumentArrayList.add(dowodOsobisty);
        }else{
            pozwolenieNaWjazd = new PozwolenieNaWjazd();
            pozwolenieNaWjazd.setDanePozwoleniaNaWjazd(giveImie(imie,kodBledu),giveNazwisko(nazwisko,kodBledu),giveKodPaszportu(kodPaszportu,kodBledu),generateRandomDataWaznosciString());
            dokumentArrayList.add(pozwolenieNaWjazd);
        }
        System.out.println("Kod Bledu -> " + kodBledu);

    }

    public void aktualizuj(){
        for(Dokument dokument : dokumentArrayList){
            dokument.aktualizuj();
        }
    }

    public void render(Graphics g){

        for(Dokument dokument : dokumentArrayList){
            dokument.renderuj(g);
        }

    }

    @Override
    public String toString(){
        return imie + "/" + dataUrodzin + "/" + miejsceWydaniaPaszportu + "/" + dataWygasnieciaPaszportu + "/" + krajPochodzenia + "/" + kodPaszportu;
    }

    public int getKodBledu(){
        return kodBledu;
    }
    public Paszport getPaszport(){
        return paszport;
    }
    public DowodOsobisty getDowodOsobisty(){
        return dowodOsobisty;
    }
    public PozwolenieNaWjazd getPozwolenieNaWjazd(){
        return pozwolenieNaWjazd;
    }


}
