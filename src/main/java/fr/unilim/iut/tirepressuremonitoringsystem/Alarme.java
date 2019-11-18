package fr.unilim.iut.tirepressuremonitoringsystem;

public class Alarme
{

    private Capteur capteur;
    private boolean estAllume;
    private IntervalleSecurite intervalle;
    
    public Alarme(Capteur capteur, IntervalleSecurite intervalle) {
    	this.capteur = capteur;
    	this.estAllume = false;
    	this.intervalle = intervalle;
    }
    public void verifier()
    {
        double valeurPression = this.capteur.afficherProchaineValeur();

        if (!this.intervalle.estComprise(valeurPression)){
        	this.estAllume = true;
        }
    }

    public boolean estAllume()
    {
        return estAllume; 
    }
}
