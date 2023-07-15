package cl.threeit.surveyapi.services;

import java.util.List;

import cl.threeit.surveyapi.models.entities.SurveyMusicFav;

public interface SurveyMusicFavService {
	public List<SurveyMusicFav> get();
	public Boolean create(SurveyMusicFav entity);
}
