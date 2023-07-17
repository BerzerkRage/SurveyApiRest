package cl.threeit.surveyapi.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.threeit.surveyapi.models.dao.IMusicStyle;
import cl.threeit.surveyapi.models.entities.MusicStyle;
import cl.threeit.surveyapi.services.MusicStyleService;

@Service
public class MusicStyleServiceImpl implements MusicStyleService {
	
	@Autowired
	private IMusicStyle musicStyle;

	@Override
	public List<MusicStyle> get() {
		return StreamSupport.stream(musicStyle.findAll().spliterator(), false).filter(m->m.getActivado().equals(true)).collect(Collectors.toList());
	}

}
