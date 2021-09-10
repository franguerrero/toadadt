package franguerrero.modelo;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public enum EstacionMeteorologicaDao {
	INSTANCE;
	private Map<String, EstacionMeteorologica> proveedorContenidos = new HashMap<String, EstacionMeteorologica>();
	private EstacionMeteorologicaDao() {
	 EstacionMeteorologica estacionmeteo = new EstacionMeteorologica("1", "Granada Aeropuerto");
	 estacionmeteo.setDescripcion("Estacion Meteorologica del Aeropuerto de Granada");
	 estacionmeteo.setFechalectura(new Date(System.currentTimeMillis()));
	 estacionmeteo.setTemperatura(18.3);
	 estacionmeteo.setHumedad(2);
	 estacionmeteo.setVientoVelocidad(23.1);
	 estacionmeteo.setPresionAtmosferica(995);
	 
	 
	 
	 proveedorContenidos.put("1", estacionmeteo);
	
	 // Otra estacion
	 estacionmeteo = new EstacionMeteorologica("2", "Sevilla Aeropuerto");
	 estacionmeteo.setDescripcion("Estacion Meteorologica del Aeropuerto de Sevilla");
	 estacionmeteo.setFechalectura(new Date(System.currentTimeMillis()));
	 estacionmeteo.setTemperatura(28.3);
	 estacionmeteo.setHumedad(21);
	 estacionmeteo.setVientoVelocidad(2);
	 estacionmeteo.setPresionAtmosferica(998);
	 proveedorContenidos.put("2", estacionmeteo);
	}
	public Map<String, EstacionMeteorologica> getModel(){
		return proveedorContenidos;
	}
}
