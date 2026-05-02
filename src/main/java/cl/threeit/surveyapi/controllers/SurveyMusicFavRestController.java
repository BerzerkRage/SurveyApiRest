package cl.threeit.surveyapi.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.threeit.surveyapi.models.SurveyChart;
import cl.threeit.surveyapi.models.entities.SurveyMusicFav;
import cl.threeit.surveyapi.services.SurveyMusicFavService;

@RestController
@RequestMapping(path = "api/survey-music")
public class SurveyMusicFavRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SurveyMusicFavRestController.class);
	
	@Autowired
	private SurveyMusicFavService service;
	
	@GetMapping(path = "/get")
	public ResponseEntity<List<SurveyMusicFav>> getSurveys() {
		try {
			return new ResponseEntity<List<SurveyMusicFav>>(service.get(), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Error obteniendo encuestas musicales", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/chart")
	public ResponseEntity<List<SurveyChart>> getChart() {
		try {
			return new ResponseEntity<List<SurveyChart>>(service.getChart(), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Error obteniendo datos del grafico de encuestas", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path = "/")
	public ResponseEntity<Boolean> registerSurvey(
			@RequestBody SurveyMusicFav entity
		) {
		try {
			return new ResponseEntity<Boolean>(service.create(entity), HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			LOGGER.warn("Solicitud invalida para registrar encuesta: {}", e.getMessage());
			return new ResponseEntity<Boolean>(Boolean.FALSE, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			LOGGER.error("Error registrando encuesta musical", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
