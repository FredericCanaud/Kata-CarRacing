package fr.unilim.iut.tirepressuremonitoringsystem;

public class Alarme
{
    private double valeurPressionMinimale;
    private double valeurPressionMaximale;
    private Capteur capteur;
    private boolean estAllume;
    
    public Alarme(Capteur capteur) {
    	this.valeurPressionMinimale = 17;
    	this.valeurPressionMaximale = 21;
    	this.capteur = capteur;
    	this.estAllume = false;
    }
    public void check()
    {
        double valeurPression = capteur.afficherProchaineValeurPression();

        if (valeurPression < valeurPressionMinimale || valeurPressionMaximale < valeurPression)
        {
            estAllume = true;
        }
    }

    public boolean estAllume()
    {
        return estAllume; 
    }
}
