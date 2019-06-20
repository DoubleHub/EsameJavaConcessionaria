package it.poliba.esameconcessionaria;

public class AutoNotFoundException extends Exception {

    public AutoNotFoundException(String modelloAuto, Direttore direttore) {
        super("Non è stata trovata alcun modello di auto '" + modelloAuto + "' nel parco auto di " + direttore.getNome() + " " + direttore.getCognome() + "!");
    }

}
