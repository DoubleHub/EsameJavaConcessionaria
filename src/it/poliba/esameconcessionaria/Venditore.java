package it.poliba.esameconcessionaria;

public class Venditore extends Persona {

    private Direttore direttoreAssociato;
    private float incasso = 0;

    public Venditore(String nome, String cognome, Direttore direttoreAssociato) {
        super(nome, cognome);
        this.direttoreAssociato = direttoreAssociato;
    }

    public Direttore getDirettoreAssociato() {
        return direttoreAssociato;
    }

    public float getIncasso() {
        return incasso;
    }

    public void vendiAuto(Auto auto) {
        incasso += auto.getCosto();
        direttoreAssociato.rimuoviAuto(auto);
    }

}
