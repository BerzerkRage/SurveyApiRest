package cl.threeit.surveyapi.services.impl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.threeit.surveyapi.models.SurveyChart;
import cl.threeit.surveyapi.models.dao.ISurveyMusicFav;
import cl.threeit.surveyapi.models.dao.SurveyChartDao;
import cl.threeit.surveyapi.models.entities.SurveyMusicFav;
import cl.threeit.surveyapi.services.SurveyMusicFavService;

@Service
public class SurveyMusicFavServiceImpl implements SurveyMusicFavService {
	
	@Autowired
	private ISurveyMusicFav dao;
	@Autowired
	private SurveyChartDao chart;

	@Override
	public List<SurveyMusicFav> get() {
		return (List<SurveyMusicFav>) dao.findAll();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean create(SurveyMusicFav entity) {
		entity.setFechaCreacion(LocalDateTime.now());
		entity.setEmail(entity.getEmail().toLowerCase());
		dao.save(entity);
		return true;
	}
	
	@Override
	public List<SurveyChart> getChart() throws SQLException {
		return chart.getChartData();
	}

}
