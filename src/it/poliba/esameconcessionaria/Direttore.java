package it.poliba.esameconcessionaria;

import java.io.*;
import java.util.ArrayList;

public class Direttore extends Persona {

    private ArrayList<Auto> parcoAuto = new ArrayList<>();
    private ArrayList<Venditore> venditoriAssociati = new ArrayList<>();

    public Direttore(String nome, String cognome) {
        super(nome, cognome);
    }

    public void caricaAutoDaFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String modello = "";
        int annoImmatricolazione = 0, cilindrata = 0;
        float costo = 0;

        String s = reader.readLine();
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0: modello = s; break;
                case 1: annoImmatricolazione = Integer.parseInt(s); break;
                case 2: cilindrata = Integer.parseInt(s); break;
                case 3: costo = Float.parseFloat(s); break;
            }
            s = reader.readLine();
        }

        parcoAuto.add(new Auto(modello, annoImmatricolazione, cilindrata, costo));
        reader.close();
    }

    public void registraIncassiSuFile(String fileName) throws IOException {
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        printWriter.println("[Concessionaria di " + nome + " " + cognome + "]");
        printWriter.println("Incassi totali: " + getIncassiTotali());
        printWriter.println("Incassi per venditore:");

        for (Venditore venditore : getVenditoriOrdinatiPerIncassoCrescente()) {
            printWriter.println(venditore.getNome() + " " + venditore.getCognome() + ": " + venditore.getIncasso() + " euro");
        }

        printWriter.close();
    }

    public void addAuto(Auto auto) {
        parcoAuto.add(auto);
    }
    public void addAuto(ArrayList<Auto> auto) {
        parcoAuto.addAll(auto);
    }

    public void addVenditori(Venditore venditore) {
        venditoriAssociati.add(venditore);
    }
    public void addVenditori(ArrayList<Venditore> venditori) {
        venditoriAssociati.addAll(venditori);
    }

    public void rimuoviAuto(Auto auto) {
        parcoAuto.remove(auto);
    }

    public ArrayList<Auto> getParcoAuto() {
        return parcoAuto;
    }

    public ArrayList<Venditore> getVenditoriAssociati() {
        return venditoriAssociati;
    }

    private float getIncassiTotali() {
        float incassiTotali = 0;
        for (Venditore venditore : venditoriAssociati) {
            incassiTotali += venditore.getIncasso();
        }
        return incassiTotali;
    }

    private ArrayList<Venditore> getVenditoriOrdinatiPerIncassoCrescente() {
        ArrayList<Venditore> venditoriOrdinati = venditoriAssociati;
        venditoriOrdinati.sort((v1, v2) -> Float.compare(v1.getIncasso(), v2.getIncasso()));
        return venditoriOrdinati;
    }

}
