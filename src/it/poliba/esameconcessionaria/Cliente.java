package it.poliba.esameconcessionaria;

import java.util.ArrayList;

public class Cliente extends Persona {

    private ArrayList<Auto> autoAcquistate = new ArrayList<>();
    private float budget;

    public Cliente(String nome, String cognome, float budget) {
        super(nome, cognome);
        this.budget = budget;
    }

    public void acquistaAuto(Venditore venditore, String modello) throws AutoNotFoundException, InsufficientBudgetException {
        ArrayList<Auto> autoDisponibili = venditore.getDirettoreAssociato().getParcoAuto();
        for (Auto auto : autoDisponibili) {
            if (auto.getNome().equals(modello)) {
                if (auto.getCosto() > budget) {
                    throw new InsufficientBudgetException(this, modello);
                }
                budget -= auto.getCosto();
                venditore.vendiAuto(auto);
                autoAcquistate.add(auto);
                System.out.println("Il cliente " + nome + " " + cognome + " ha acquistato l'auto '" + modello + "' dal venditore " + venditore.getNome() + " " + venditore.getCognome() + "!");
                return;
            }
        }
        throw new AutoNotFoundException(modello, venditore.getDirettoreAssociato());
    }

    public ArrayList<Auto> getAutoAcquistate() {
        return autoAcquistate;
    }

    public float getBudget() {
        return budget;
    }

}
