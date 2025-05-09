package Elementi;

import java.util.Scanner;

// Classe che rappresenta un'immagine, estende ElementoMultimediale.

public class Immagine extends ElementoMultimediale {
    private int luminosita;

    // Costruttore per la classe Immagine.

    public  Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    // Restituisce il livello di luminosità dell'immagine.

    public  int getLuminosita() {
        return luminosita;
    }

//Imposta il livello di luminosità dell'immagine.//

    public void setLuminosita(int luminosita){
        this.luminosita = Math.max(0, luminosita);
    }

    //  Implementazione del metodo show() per l'immagine.

    @Override
    public  void show() {
        System.out.println("IMMAGINE: " + getTitolo() + " " + "*".repeat(luminosita));
    }

    //Metodo statico per creare un oggetto Immagine leggendo l'input da tastiera.//
    public  static Immagine creaImmagine(Scanner scanner) {
        System.out.println("Inserisci il titolo dell'immagine: ");
        String titolo = scanner.nextLine();
        System.out.println("Inserisci il livello di luminosita (intero positivo): ");
        int luminosita = scanner.nextInt();
        scanner.nextLine();
        return new  Immagine(titolo, luminosita);
    }

}
