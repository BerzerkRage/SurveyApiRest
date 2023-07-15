package cl.threeit.surveyapi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.threeit.surveyapi.models.dao.IMusicStyle;
import cl.threeit.surveyapi.models.entities.MusicStyle;
import cl.threeit.surveyapi.services.MusicStyleService;

@Service
public class MusicStyleImpl implements MusicStyleService {
	
	@Autowired
	private IMusicStyle musicStyle;

	@Override
	public List<MusicStyle> get() {
		return (List<MusicStyle>) musicStyle.findAll();
		
		
	}

}
