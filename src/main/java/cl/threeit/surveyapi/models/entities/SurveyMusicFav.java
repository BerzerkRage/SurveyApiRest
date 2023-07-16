package cl.threeit.surveyapi.models.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TA_SURVEYMUSICFAV")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SurveyMusicFav implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "FECHA_CREACION")
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime fechaCreacion;
	private String email;
	@Column(name = "ID_MUSICSTYLE")
	private Integer idMusicStyle;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdMusicStyle() {
		return idMusicStyle;
	}

	public void setIdMusicStyle(Integer idMusicStyle) {
		this.idMusicStyle = idMusicStyle;
	}

	@Override
	public String toString() {
		return "SurveyMusicFav [id=" + id + ", fechaCreacion=" + fechaCreacion + ", email=" + email + ", idMusicStyle="
				+ idMusicStyle + "]";
	}

}
