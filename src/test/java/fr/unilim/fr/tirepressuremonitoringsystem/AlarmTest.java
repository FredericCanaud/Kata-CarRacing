package fr.unilim.fr.tirepressuremonitoringsystem;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.unilim.iut.tirepressuremonitoringsystem.Alarme;
import fr.unilim.iut.tirepressuremonitoringsystem.Capteur;

import static org.mockito.Mockito.mock;  
import static org.mockito.Mockito.when;

public class AlarmTest{
	
	public Alarme alarm;
	
	
	@Test
	public void AlarmeSeDeclenchePourPressionTropBasse() {
		
		Capteur sensor = mock(Capteur.class);
		when(sensor.afficherProchaineValeurPression()).thenReturn(7.0);
		
		this.alarm = new Alarme(sensor);
		this.alarm.verifier();
		assertTrue(this.alarm.estAllume());
	}
	
	@Test
	public void AlarmeSeDeclenchePourPressionTropHaute() {
		
		Capteur sensor = mock(Capteur.class);
		when(sensor.afficherProchaineValeurPression()).thenReturn(37.0);
		
		this.alarm = new Alarme(sensor);
		this.alarm.verifier();
		assertTrue(this.alarm.estAllume());
	}
	
	@Test
	public void AlarmeSeDeclenchePas() {
		Capteur sensor = mock(Capteur.class);
		when(sensor.afficherProchaineValeurPression()).thenReturn(20.0);
		
		this.alarm = new Alarme(sensor);
		this.alarm.verifier();
		assertFalse(this.alarm.estAllume());
	}
	
	@Test
	public void AlarmeResteDeclenche() {
		Capteur sensor = mock(Capteur.class);
		when(sensor.afficherProchaineValeurPression()).thenReturn(30.0).thenReturn(20.0);
		
		this.alarm = new Alarme(sensor);
		this.alarm.verifier();
		this.alarm.verifier();
		
		assertTrue(this.alarm.estAllume());
	}
}