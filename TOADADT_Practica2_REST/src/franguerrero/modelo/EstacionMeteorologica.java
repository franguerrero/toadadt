package franguerrero.modelo;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class EstacionMeteorologica {
	private String id;
	private String localizacion;
	private String descripcion;
	private double temperatura;
	private double humedad;
	private double vientoVelocidad;
	private double presionAtmosferica;
	private Date fechalectura;
	
	public EstacionMeteorologica(){
	}
	public EstacionMeteorologica (String id, String localizacion){
		this.id = id;
		this.localizacion = localizacion;
		setFechalectura(new Date(System.currentTimeMillis()));
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	public double getHumedad() {
		return humedad;
	}
	public void setHumedad(double humedad) {
		this.humedad = humedad;
	}
	public double getVientoVelocidad() {
		return vientoVelocidad;
	}
	public void setVientoVelocidad(double vientoVelocidad) {
		this.vientoVelocidad = vientoVelocidad;
	}
	public double getPresionAtmosferica() {
		return presionAtmosferica;
	}
	public void setPresionAtmosferica(double presionAtmosferica) {
		this.presionAtmosferica = presionAtmosferica;
	}
	public Date getFechalectura() {
		return fechalectura;
	}
	public void setFechalectura(Date fechalectura) {
		this.fechalectura = fechalectura;
	}
}
