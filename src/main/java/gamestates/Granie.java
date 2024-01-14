package gamestates;

import entities.*;
import level.HandlerPoziomu;
import org.main.Gra;
import ui.GraPrzycisk;
import utils.Stale;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class Granie extends Stan implements Metodystanu {

    private HandlerPoziomu handlerPoziomu; //OBSŁUGA TŁA POZIOMU

    //DOKUMENTY
    private Paszport paszport; //paszport OBSŁUGA PRZESUWANIA
    private PozwolenieNaWjazd pozwolenieNaWjazd;
    private DowodOsobisty dowodOsobisty;

    private LinkedList<Dokument> dokumentLinkedList = new LinkedList<>();


    private RamieZatwierdzaniaOdrzucania ramie;

    //TODO LISTA PASZPORT DOKUMENTY ITP
    private GraPrzycisk[] przyciski = new GraPrzycisk[2];

    public Granie(Gra gra) {
        super(gra);
        wczytajKlasy();
        wczytajPrzyciski();
    }

    private void wczytajPrzyciski() {
        przyciski[0] = new GraPrzycisk(400,750,0);
        przyciski[1] = new GraPrzycisk(600,750,1);

    }

    private void wczytajKlasy(){
        handlerPoziomu = new HandlerPoziomu(gra);
        Petent petent = new Petent();
        paszport = petent.getPaszport();
        pozwolenieNaWjazd = new PozwolenieNaWjazd();
        ramie = new RamieZatwierdzaniaOdrzucania();
        dowodOsobisty = new DowodOsobisty();
        dokumentLinkedList.addAll(petent.getDokumentList());
    }

    @Override
    public void aktualizuj() {
        handlerPoziomu.aktualizuj(); //Aktualizowanie dynamicznego tła
        for(Dokument dokument: dokumentLinkedList){
            dokument.aktualizuj();
        }
        //pozwolenieNaWjazd.aktualizuj();
        //paszport.aktualizuj();
        //dowodOsobisty.aktualizuj();

        for (GraPrzycisk gp: przyciski){
            gp.update();
        }
    }

    @Override
    public void rysuj(Graphics g) {
        handlerPoziomu.rysuj(g);
        for(Dokument dokument: dokumentLinkedList){
            dokument.renderuj(g);
        }
        //pozwolenieNaWjazd.renderuj(g);
        //paszport.renderuj(g);
        //ramie.renderuj(g);
        //dowodOsobisty.renderuj(g);


        for(GraPrzycisk gp : przyciski){
            gp.rysuj(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }



    @Override
    public void mousePressed(MouseEvent e) {
        for(GraPrzycisk gp : przyciski){
            if(isIn(e,gp)){
                gp.setMousePressed(true);
                System.out.println("Wcisniety przycisk w ramce");
                break;
            }
        }

        for(Dokument dokument: dokumentLinkedList){
            if(isIn(e,dokument)){
                dokument.mousePressed(e);
                Dokument dokumentTmp;
                dokumentTmp = dokument;
                dokumentLinkedList.remove(dokument);
                dokumentLinkedList.add(dokumentTmp);
                dokumentLinkedList.push(dokumentTmp); //TODO:POPRAWIC
                System.out.println(dokumentLinkedList.size()); //WIADOMO

                break;
            }
        }



//        if(isIn(e,paszport)){
//            System.out.println("Wcisniety paszport");
//            paszport.mousePressed(e);
//        }
//
//        if(isIn(e,pozwolenieNaWjazd)){
//            pozwolenieNaWjazd.mousePressed(e);
//        }
//
//        if(isIn(e,dowodOsobisty)){
//            dowodOsobisty.mousePressed(e);
//        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        for(Dokument dokument: dokumentLinkedList){
            if(isIn(e,dokument)){
                dokument.mouseReleased(e);
                //TODO: DO POPRAWY BADZIEWIE JEDNE
                Dokument dokumentTmp;
                dokumentTmp = dokument;
//                dokumentLinkedList.remove(dokument);
//                dokumentLinkedList.add(dokumentTmp);
//                dokumentLinkedList.push(dokumentTmp);
                System.out.println(dokumentLinkedList.size()); //WIADOMO
                System.out.println(dokumentLinkedList.toString());
                break;
            }
        }

        for(GraPrzycisk gp : przyciski){
            if(isIn(e,gp)){
                if(gp.isMousePressed()){
                    Petent petent = new Petent();
                    //paszport = petent.getPaszport();
                    dokumentLinkedList = (LinkedList<Dokument>) petent.getDokumentList();
                    break;
                }
            }
        }
        resetButtons();


//        paszport.mouseReleased(e);
//        pozwolenieNaWjazd.mouseReleased(e);
//        dowodOsobisty.mouseReleased(e);
    }

    private void resetButtons() {
        for(GraPrzycisk gp: przyciski){
            gp.resetBools();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for(GraPrzycisk gp: przyciski){
            gp.setMouseOver(false);
        }

        for(GraPrzycisk gp: przyciski){
            if(isIn(e,gp)){
                gp.setMouseOver(true);
                break;
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
//        if(isIn(e,paszport)){
//            paszport.mouseDragged(e);
//        }
//
//        if(isIn(e,pozwolenieNaWjazd)){
//            pozwolenieNaWjazd.mouseDragged(e);
//        }
//
//        if(isIn(e,dowodOsobisty)){
//            dowodOsobisty.mouseDragged(e);
//        }

        for(Dokument dokument: dokumentLinkedList){
            if(isIn(e,dokument)){
                dokument.mouseDragged(e);
//                Dokument dokumentTmp;
//                dokumentTmp = dokument;
//                dokumentLinkedList.push(dokument);
//                dokumentLinkedList.add(dokumentTmp);
                break;
            }
        }
    }


}
