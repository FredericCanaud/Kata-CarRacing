package fr.unilim.iut.tirepressuremonitoringsystem;

import java.util.Random;

public class CapteurPression implements Capteur{
	public static final double DECALAGE = 16;

    public double afficherProchaineValeur() {
        double valeurPressionMesuree;
        valeurPressionMesuree = mesurerPression( );

        return DECALAGE + valeurPressionMesuree;
    }

    private static double mesurerPression() {
        Random nombreAleatoire = new Random();
        double valeurPressionMesuree = 6 * nombreAleatoire.nextDouble() * nombreAleatoire.nextDouble();
        return valeurPressionMesuree;
    }
}
