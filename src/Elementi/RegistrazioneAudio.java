package Elementi;

import java.util.Scanner;

public class RegistrazioneAudio extends ElementoMultimediale implements Riproducibile {
    private int durata;
    private int volume;

    public RegistrazioneAudio(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = Math.max(0, Math.min(10, volume));
    }

    @Override
    public void play() {
        System.out.println("AUDIO: " + getTitolo() + " " + "!".repeat(volume));
    }

    @Override
    public int getDurata() {
        return durata;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = Math.max(0, Math.min(10, volume));
    }

    @Override
    public void show() {
        play();
    }

    public static RegistrazioneAudio creaRegistrazioneAudio(Scanner scanner) {
        System.out.print("Inserisci il titolo della registrazione audio: ");
        String titolo = scanner.nextLine();
        System.out.print("Inserisci la durata della registrazione (in secondi): ");
        int durata = scanner.nextInt();
        System.out.print("Inserisci il livello del volume (0-10): ");
        int volume = scanner.nextInt();
        scanner.nextLine();
        return new RegistrazioneAudio(titolo, durata, volume);
    }
}