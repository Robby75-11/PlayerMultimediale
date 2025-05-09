package Elementi;
/**
 * Interfaccia che definisce il comportamento degli elementi multimediali riproducibili.
 * Gli elementi che implementano questa interfaccia devono avere una durata
 * e un modo per essere riprodotti.
 */
public interface Riproducibile {

    /**
     * Metodo astratto per avviare la riproduzione dell'elemento.
     */
    void play();



     // Metodo astratto per ottenere la durata dell'elemento in secondi.

    int getDurata();
}
