package entities;
import java.awt.*;

public class RamieZatwierdzaniaOdrzucania {

    private int szerokosc;
    private int wysokosc;
    private int x;  // pozycja x wysuwającego się ramienia
    private int y;  // pozycja y wysuwającego się ramienia
    private int cienOffset;  // odległość cienia od wysuwającego się ramienia
    private int cienWysokosc;  // wysokość cienia

    public RamieZatwierdzaniaOdrzucania(int szerokosc, int wysokosc, int cienOffset, int cienWysokosc) {
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
        this.cienOffset = cienOffset;
        this.cienWysokosc = cienWysokosc;
    }
    public RamieZatwierdzaniaOdrzucania(){
        this.szerokosc = 300;
        this.wysokosc = 40;
        this.cienOffset = 50;
        this.cienWysokosc = 50;
        x = 900;
        y = 400;
    }

    public void update(){
        //ZMIANA STANU RAMIENIA NA WYSUNIETY LUB SCHOWANY
    }

    public void renderuj(Graphics g) {
        // Rysowanie cienia
        g.setColor(new Color(0, 0, 0, 75));  // Czarny kolor cienia z przyciemnieniem (Alpha)
        g.fillRect(x - cienOffset, y, szerokosc + cienOffset, cienWysokosc);

        // Rysowanie ramienia zatwierdzania/odrzucania
        //g.setColor(new Color(150, 150, 150));  // Kolor ramienia
        //g.fillRect(x, y, szerokosc, wysokosc);
    }

    // Metody do ustawiania pozycji ramienia
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

