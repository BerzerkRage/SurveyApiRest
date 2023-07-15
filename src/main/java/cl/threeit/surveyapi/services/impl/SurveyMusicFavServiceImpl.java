package cl.threeit.surveyapi.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.threeit.surveyapi.models.dao.ISurveyMusicFav;
import cl.threeit.surveyapi.models.entities.SurveyMusicFav;
import cl.threeit.surveyapi.services.SurveyMusicFavService;

@Service
public class SurveyMusicFavServiceImpl implements SurveyMusicFavService {
	
	@Autowired
	private ISurveyMusicFav dao;

	@Override
	public List<SurveyMusicFav> get() {
		return (List<SurveyMusicFav>) dao.findAll();
	}

	@Override
	public Boolean create(SurveyMusicFav entity) {
		entity.setFechaCreacion(LocalDateTime.now());
		System.out.println(entity.toString());
		dao.save(entity);
		return true;
	}

}
