package cl.threeit.surveyapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SurveyChart {
	@JsonProperty(value = "name")
	private String musica;
	@JsonProperty(value = "value")
	private Integer cantidad;
	
	public SurveyChart() {
		super();
	}

	public SurveyChart(String musica, Integer cantidad) {
		super();
		this.musica = musica;
		this.cantidad = cantidad;
	}
	
	public String getMusica() {
		return musica;
	}
	public void setMusica(String musica) {
		this.musica = musica;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}

