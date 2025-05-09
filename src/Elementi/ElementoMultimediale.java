package Elementi;

/**
 * Classe astratta che rappresenta un elemento multimediale generico.
 * Fornisce una base per le classi più specifiche come Immagine, Video e Audio.
 */
public abstract class ElementoMultimediale {
    private String titolo;

/*
 * Costruttore per la classe ElementoMultimediale.
 */
    public ElementoMultimediale(String titolo) {
        this.titolo = titolo;

    }
    public  String getTitolo() {
        return titolo;
    }
    public  abstract void show();
}
