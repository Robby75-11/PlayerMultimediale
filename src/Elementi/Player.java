package Elementi;

import java.util.Scanner;


public class Player {
    private ElementoMultimediale[] elementi = new ElementoMultimediale[5];
    private Scanner scanner = new Scanner(System.in);
    private int numeroElementi = 0;

    public void aggiungiElemento(ElementoMultimediale elemento) {
        if (numeroElementi < elementi.length) {
            elementi[numeroElementi++] = elemento;
        } else {
            System.out.println("Limite di elementi raggiunto.");
        }
    }

    public void creaElementi() {
        for (int i = 0; i < elementi.length; i++) {
            System.out.println("Creazione elemento " + (i + 1) + ":");
            System.out.println("Seleziona il tipo (1: Immagine, 2: Video, 3: Audio):");
            int sceltaTipo = scanner.nextInt();
            scanner.nextLine();

            switch (sceltaTipo) {
                case 1:
                    aggiungiElemento(Immagine.creaImmagine(scanner));
                    break;
                case 2:
                    aggiungiElemento(Video.creaVideo(scanner));
                    break;
                case 3:
                    aggiungiElemento(RegistrazioneAudio.creaRegistrazioneAudio(scanner));
                    break;
                default:
                    System.out.println("Scelta non valida. Elemento non creato.");
                    i--;
                    break;
            }
            System.out.println();
        }
    }

    public void esegui() {
        int scelta;
        do {
            System.out.println("Seleziona un elemento da eseguire (1-" + numeroElementi + ", 0 per uscire):");
            if (scanner.hasNextInt()) {
                scelta = scanner.nextInt();
                scanner.nextLine();

                if (scelta >= 1 && scelta <= numeroElementi) {
                    elementi[scelta - 1].show();
                } else if (scelta != 0) {
                    System.out.println("Scelta non valida.");
                }
            } else {
                System.out.println("Input non valido. Inserisci un numero.");
                scanner.nextLine();
                scelta = -1;
            }
            System.out.println();
        } while (scelta != 0);

        System.out.println("Chiusura del Player Multimediale.");
        scanner.close();
    }

    public static void main(String[] args) {
        Player player = new Player();
        player.creaElementi();
        player.esegui();
    }
}
