package Elementi;

import java.util.Scanner;

// Classe che rappresenta una registrazione audio, estende ElementoMultimediale e implementa Riproducibile.
//  Le registrazioni audio hanno titolo, durata e volume.

public class RegistrazioneAudio extends ElementoMultimediale implements Riproducibile {
    private int durata;
    private int volume;

    //Costruttore per la classe RegistrazioneAudio.

    public RegistrazioneAudio(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = Math.max(0, Math.min(100, volume));
    }

    // Implementazione del metodo play() dall'interfaccia Riproducibile.
    // Stampa il titolo seguito da punti esclamativi in base al volume.

    @Override
    public void play() {
        System.out.println("AUDIO: " + getTitolo() + " " + "!".repeat(volume));
    }

    // Implementazione del metodo getDurata() dall'interfaccia Riproducibile.

    @Override
    public int getDurata() {
        return durata;
    }

    // Restituisce il livello del volume della registrazione audio.

    public int getVolume() {
        return volume;
    }

    // Imposta il livello del volume della registrazione audio.
    public void setVolume(int volume) {
        this.volume = Math.max(0, Math.min(100, volume));
    }

    // Implementazione del metodo show() per la registrazione audio.

    @Override
    public void show() {
        play();
    }

    //  Metodo statico per creare un oggetto RegistrazioneAudio leggendo l'input da tastiera.
    //     L'oggetto Scanner per leggere l' input dell'utente.
    //     Una nuova istanza di RegistrazioneAudio creata con i dati inseriti.

    public static RegistrazioneAudio creaRegistrazioneAudio(Scanner scanner) {
        System.out.print("Inserisci il titolo della registrazione audio: ");
        String titolo = scanner.nextLine();
        System.out.print("Inserisci la durata della registrazione (in secondi): ");
        int durata = scanner.nextInt();
        System.out.print("Inserisci il livello del volume (0-100): ");
        int volume = scanner.nextInt();
        scanner.nextLine();
        return new RegistrazioneAudio(titolo, durata, volume);
    }
}