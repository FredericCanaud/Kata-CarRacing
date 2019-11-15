package fr.unilim.fr.tirepressuremonitoringsystem;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.unilim.iut.tirepressuremonitoringsystem.Alarm;
import fr.unilim.iut.tirepressuremonitoringsystem.Sensor;

import static org.mockito.Mockito.mock;  
import static org.mockito.Mockito.when;

public class AlarmTest{
	
	public Alarm alarm;
	
	
	@Test
	public void AlarmeSeDeclenchePourPressionTropBasse() {
		
		Sensor sensor = mock(Sensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(7.0);
		
		this.alarm = new Alarm(sensor);
		this.alarm.check();
		assertTrue(this.alarm.isAlarmOn());
	}
	
	@Test
	public void AlarmeSeDeclenchePourPressionTropHaute() {
		
		Sensor sensor = mock(Sensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(37.0);
		
		this.alarm = new Alarm(sensor);
		this.alarm.check();
		assertTrue(this.alarm.isAlarmOn());
	}
	
	@Test
	public void AlarmeSeDeclenchePas() {
		Sensor sensor = mock(Sensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(20.0);
		
		this.alarm = new Alarm(sensor);
		this.alarm.check();
		assertFalse(this.alarm.isAlarmOn());
	}
	
	@Test
	public void AlarmeResteDeclenche() {
		Sensor sensor = mock(Sensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(30.0).thenReturn(20.0);
		
		this.alarm = new Alarm(sensor);
		this.alarm.check();
		this.alarm.check();
		
		assertTrue(this.alarm.isAlarmOn());
	}
}