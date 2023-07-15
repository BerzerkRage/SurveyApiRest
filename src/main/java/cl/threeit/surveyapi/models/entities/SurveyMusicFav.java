package cl.threeit.surveyapi.models.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TA_SURVEYMUSICFAV")
public class SurveyMusicFav implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "fecha_creacion")
	private LocalDateTime fechaCreacion;
	private String email;
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

}
