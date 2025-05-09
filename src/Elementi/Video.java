package Elementi;

import java.util.Scanner;

// Classe che rappresenta un video, estende ElementoMultimediale e implementa Riproducibile.
//  I video hanno titolo, durata, volume e luminosità.

public class Video extends  ElementoMultimediale implements Riproducibile {
    private int durata;
    private int volume;
    private int luminosita;

  //  Costruttore per la classe Video.

    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo);
        this.durata = durata;
        this.volume = Math.max(0, Math.min(10, volume));
        this.luminosita = Math.max(0, luminosita);

    }

    //Implementazione del metodo play() dall'interfaccia Riproducibile.
    // Stampa il titolo seguito da punti esclamativi (volume) e asterischi (luminosità).

    @Override
    public void play() {
        System.out.println("VIDEO: " + getTitolo() + " " + "!".repeat(volume) + "*".repeat(luminosita));
    }


// implementazione del metodo getDurata() dall'interfaccia Riproducibile.

    @Override
    public int getDurata() {
        return durata;
    }

    public int getVolume() {
        return volume;
    }


// Imposta il livello del volume del video.

    public void setVolume(int volume) {
        this.volume = Math.max(0, Math.min(10, volume));
    }

    public int getLuminosita() {
        return luminosita;
    }

    public void setLuminosita(int luminosita) {
        this.luminosita = Math.max(0, luminosita);
    }


    // Implementazione del metodo show() per il video.//

    @Override
    public void show() {
        play();
    }

    // Metodo statico per creare un oggetto Video leggendo l'input da tastiera

    public static Video creaVideo(Scanner scanner) {
        System.out.print("Inserisci il titolo del video: ");
        String titolo = scanner.nextLine();
        System.out.print("Inserisci la durata del video (in secondi): ");
        int durata = scanner.nextInt();
        System.out.print("Inserisci il livello del volume (0-10): ");
        int volume = scanner.nextInt();
        System.out.print("Inserisci il livello di luminosità (0-10): ");
        int luminosita = scanner.nextInt();
        scanner.nextLine();
        return new Video(titolo, durata, volume, luminosita);
    }
}