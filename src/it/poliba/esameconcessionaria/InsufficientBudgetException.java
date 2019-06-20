package it.poliba.esameconcessionaria;

public class InsufficientBudgetException extends Exception {

    public InsufficientBudgetException(Cliente cliente, String modelloAuto) {
        super("Il cliente " + cliente.getNome() + " " + cliente.getCognome() + " non può acquistare l'auto '" + modelloAuto + "' per mancanza di fondi!");
    }

}
