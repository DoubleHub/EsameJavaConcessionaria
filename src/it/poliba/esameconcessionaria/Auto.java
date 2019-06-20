package it.poliba.esameconcessionaria;

public class Auto {

    private String nome;
    private int annoImmatricolazione;
    private int cilindrata;
    private float costo;
    private TipologiaAuto tipologia = TipologiaAuto.FAMILIARE;

    public Auto(String nome, int annoImmatricolazione, int cilindrata, float costo) {
        this.nome = nome;
        this.annoImmatricolazione = annoImmatricolazione;
        this.cilindrata = cilindrata;
        this.costo = costo;
    }

    public String getNome() {
        return nome;
    }

    public int getAnnoImmatricolazione() {
        return annoImmatricolazione;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public TipologiaAuto getTipologia() {
        return tipologia;
    }
    public void setTipologia(TipologiaAuto tipologia) {
        this.tipologia = tipologia;
    }

    public float getCosto() {
        return costo;
    }

    public enum TipologiaAuto {
        SPORTIVA,
        FAMILIARE,
        ELETTRICA
    }

}
