package cl.threeit.surveyapi.services;

import java.sql.SQLException;
import java.util.List;

import cl.threeit.surveyapi.models.SurveyChart;
import cl.threeit.surveyapi.models.entities.SurveyMusicFav;

public interface SurveyMusicFavService {
	public List<SurveyMusicFav> get();
	public Boolean create(SurveyMusicFav entity);
	List<SurveyChart> getChart() throws SQLException;
}
