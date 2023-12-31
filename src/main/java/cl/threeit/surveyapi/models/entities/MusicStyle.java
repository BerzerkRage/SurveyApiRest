package cl.threeit.surveyapi.models.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TA_MUSICSTYLE")
public class MusicStyle implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private Boolean activado;
	
	public MusicStyle(Integer id, String nombre, Boolean activado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.activado = activado;
	}
	
	public MusicStyle() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Boolean getActivado() {
		return activado;
	}
	public void setActivado(Boolean activado) {
		this.activado = activado;
	}

	@Override
	public String toString() {
		return "MusicStyle [id=" + id + ", nombre=" + nombre + ", activado=" + activado + "]";
	}
	
	
}
