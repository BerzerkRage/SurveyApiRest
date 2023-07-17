package cl.threeit.surveyapi.controllers;

import java.util.List;

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
	
	@Autowired
	private SurveyMusicFavService service;
	
	@GetMapping(path = "/get")
	public ResponseEntity<List<SurveyMusicFav>> getSurveis() {
		ResponseEntity<List<SurveyMusicFav>> response = null;
		
		try {
			response = new ResponseEntity<List<SurveyMusicFav>>(service.get(),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
	
	@GetMapping(path = "/chart")
	public ResponseEntity<List<SurveyChart>> getChart() {
		ResponseEntity<List<SurveyChart>> response = null;
		
		try {
			response = new ResponseEntity<List<SurveyChart>>(service.getChart(),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
	
	@PostMapping(path = "/")
	public ResponseEntity<Boolean> registerSurvey(
			@RequestBody SurveyMusicFav entity
		) {
		ResponseEntity<Boolean> response = null;
		
		try {
			response = new ResponseEntity<Boolean>(service.create(entity),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
}
