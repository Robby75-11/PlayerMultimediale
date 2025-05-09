package Elementi;

import java.util.Scanner;


// Classe principale che gestisce la creazione e l'esecuzione
// degli elementi multimediali.

public class Player {
    private ElementoMultimediale[] elementi = new ElementoMultimediale[5];
    private Scanner scanner = new Scanner(System.in);
    private int numeroElementi = 0;

    //Metodo per aggiungere un elemento multimediale all'array.

    public void aggiungiElemento(ElementoMultimediale elemento) {
        if (numeroElementi < elementi.length) {
            elementi[numeroElementi++] = elemento;
        } else {
            System.out.println("Limite di elementi raggiunto.");
        }
    }

    // Metodo per creare gli elementi multimediali leggendo l'input da tastiera.
    // Crea fino a 5 elementi.

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

    //Metodo principale per l'interazione con l'utente e l'esecuzione degli elementi.

    public void esegui() {
        int scelta;
        do {
            System.out.println("Seleziona un'azione:");
            System.out.println("1-5: Esegui elemento");
            System.out.println("6: Alza volume (elemento selezionato)");
            System.out.println("7: Abbassa volume (elemento selezionato)");
            System.out.println("0: Esci");
            System.out.print("Scelta: ");
            System.out.println("Seleziona un elemento da eseguire (1-" + numeroElementi + ", 0 per uscire):");

            if (scanner.hasNextInt()) {
                scelta = scanner.nextInt();
                scanner.nextLine();

                if (scelta >= 1 && scelta <= numeroElementi) {
                    elementi[scelta - 1].show();
                } else if (scelta == 6) {
                    if (elementoSelezionatoIndice != -1 && elementi[elementoSelezionatoIndice] instanceof RegistrazioneAudio) {
                        ((RegistrazioneAudio) elementi[elementoSelezionatoIndice]).alzaVolume();
                    } else {
                        System.out.println("Nessun elemento audio selezionato o elemento non è audio.");
                    }
                } else if (scelta == 7) {
                    if (elementoSelezionatoIndice != -1 && elementi[elementoSelezionatoIndice] instanceof RegistrazioneAudio) {
                        ((RegistrazioneAudio) elementi[elementoSelezionatoIndice]).abbassaVolume();
                    } else {
                        System.out.println("Nessun elemento audio selezionato o elemento non è audio.");
                    }
                } else if (scelta == 0) {
                    System.out.println("Chiusura del Player Multimediale.");
                    break;
                } else {
                    System.out.println("Scelta non valida.");
                }
            } else {
                System.out.println("Input non valido. Inserisci un numero.");
                scanner.nextLine();
                scelta = -1;
            }
            System.out.println();
        } while (true); // Modificato a true per gestire il break
        scanner.close();
    }

    // Aggiungi una variabile di istanza per tenere traccia dell'elemento selezionato
    private int elementoSelezionatoIndice = -1;


//Metodo main, punto di ingresso per l'esecuzione del programma.

    public static void main(String[] args) {
        Player player = new Player();
        player.creaElementi();
        player.esegui();
    }
}
