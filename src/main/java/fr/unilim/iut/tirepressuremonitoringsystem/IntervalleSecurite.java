package fr.unilim.iut.tirepressuremonitoringsystem;

public class IntervalleSecurite {
    private final double valeurMinimale;
    private final double valeurMaximale;
    
    public IntervalleSecurite(double valeurMinimale, double valeurMaximale) {
    	this.valeurMinimale = valeurMinimale;
    	this.valeurMaximale = valeurMaximale;
    }
    
    public boolean estComprise(double valeur) {
    	return this.valeurMinimale <= valeur && this.valeurMaximale >= valeur;
    }
}
