package cl.threeit.surveyapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.threeit.surveyapi.models.entities.MusicStyle;
import cl.threeit.surveyapi.services.MusicStyleService;

@RestController
@RequestMapping(path = "api/musicstyle")
public class MusicStyleRestController {
	
	@Autowired
	private MusicStyleService musicStyleService;
	
	@GetMapping(path = "/get")
	public ResponseEntity<List<MusicStyle>> getMusicStyle() {
		ResponseEntity<List<MusicStyle>> response = null;
		
		try {
			response = new ResponseEntity<List<MusicStyle>>(musicStyleService.get(),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
}
