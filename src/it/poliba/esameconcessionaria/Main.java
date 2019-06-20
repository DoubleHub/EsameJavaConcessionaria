package it.poliba.esameconcessionaria;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            // Direttori (proprietari di una concessionaria)
            Direttore dClaudio = new Direttore("Claudio", "Pomo");
            Direttore dGiovanni = new Direttore("Giovanni", "Orciuolo");
            Direttore dSilvio = new Direttore("Silvio", "Troia");

            // Caricamento parchi auto tramite file
            dClaudio.caricaAutoDaFile("auto/audi.txt");
            dGiovanni.caricaAutoDaFile("auto/mercedes.txt");
            dSilvio.caricaAutoDaFile("auto/tesla.txt");

            // Popolazione parchi auto
            dClaudio.addAuto(new Auto("Lancia Y", 1999, 300, 5000));
            dClaudio.addAuto(new Auto("Audi R8", 2012, 1000, 80000));
            dGiovanni.addAuto(new Auto("Fiat Panda", 1989, 200, 3000));
            dGiovanni.addAuto(new Auto("Lamborghini", 2010, 1500, 200000));
            ArrayList<Auto> autoSilvio = new ArrayList<>();
            autoSilvio.add(new Auto("Lancia Y", 1999, 300, 5000));
            autoSilvio.add(new Auto("Ferrari", 2006, 1200, 250000));
            dSilvio.addAuto(autoSilvio);

            // Venditori associati a Claudio
            Venditore vUmberto = new Venditore("Umberto", "Foggi", dClaudio);
            Venditore vLuca = new Venditore("Luca", "Rella", dClaudio);
            Venditore vSara = new Venditore("Sara", "Montrone", dClaudio);
            dClaudio.addVenditori(vUmberto);
            dClaudio.addVenditori(vLuca);
            dClaudio.addVenditori(vSara);

            // Venditori associati a Giovanni
            Venditore vAndrea = new Venditore("Andrea", "Fortunato", dGiovanni);
            Venditore vMarco = new Venditore("Marco", "Moschetta", dGiovanni);
            Venditore vSabino = new Venditore("Sabino", "Gazzillo", dGiovanni);
            Venditore vGianfranco = new Venditore("Gianfranco", "Zagaria", dGiovanni);
            dGiovanni.addVenditori(vAndrea);
            dGiovanni.addVenditori(vMarco);
            dGiovanni.addVenditori(vSabino);
            dGiovanni.addVenditori(vGianfranco);

            // Venditori associati a Silvio
            Venditore vFlavio = new Venditore("Flavio", "Troia", dSilvio);
            Venditore vRoberto = new Venditore("Roberto", "Martiradonna", dSilvio);
            Venditore vGiuseppe = new Venditore("Giuseppe", "Bruno", dSilvio);
            dSilvio.addVenditori(vFlavio);
            dSilvio.addVenditori(vRoberto);
            dSilvio.addVenditori(vGiuseppe);

            // Lista clienti
            Cliente cEdoardo = new Cliente("Edoardo", "Loconte", 1000000);
            Cliente cFrancesco = new Cliente("Francesco", "Abruzzese", 130000);

            cEdoardo.acquistaAuto(vAndrea, "Lamborghini");
            cEdoardo.acquistaAuto(vUmberto, "Audi R8");
            cEdoardo.acquistaAuto(vLuca, "Audi A1");

            cFrancesco.acquistaAuto(vFlavio, "Lancia Y");
            cFrancesco.acquistaAuto(vMarco, "Fiat Panda");

            // Registrazione finale degli incassi su file
            dClaudio.registraIncassiSuFile("incassi_claudio.txt");
            dGiovanni.registraIncassiSuFile("incassi_giovanni.txt");
            dSilvio.registraIncassiSuFile("incassi_silvio.txt");
        } catch (AutoNotFoundException | InsufficientBudgetException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException ricevuta mentre si cercava di leggere o scrivere su un file!");
            e.printStackTrace();
        }
    }

}
