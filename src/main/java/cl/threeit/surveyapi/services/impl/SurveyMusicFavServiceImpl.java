package cl.threeit.surveyapi.services.impl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.threeit.surveyapi.models.SurveyChart;
import cl.threeit.surveyapi.models.dao.IMusicStyle;
import cl.threeit.surveyapi.models.dao.ISurveyMusicFav;
import cl.threeit.surveyapi.models.dao.SurveyChartDao;
import cl.threeit.surveyapi.models.entities.SurveyMusicFav;
import cl.threeit.surveyapi.services.SurveyMusicFavService;

@Service
public class SurveyMusicFavServiceImpl implements SurveyMusicFavService {

	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$",
			Pattern.CASE_INSENSITIVE);
	
	@Autowired
	private ISurveyMusicFav dao;
	@Autowired
	private SurveyChartDao chart;
	@Autowired
	private IMusicStyle musicStyleDao;

	@Override
	public List<SurveyMusicFav> get() {
		return (List<SurveyMusicFav>) dao.findAll();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean create(SurveyMusicFav entity) {
		validateSurvey(entity);
		entity.setFechaCreacion(LocalDateTime.now());
		entity.setEmail(entity.getEmail().trim().toLowerCase());
		dao.save(entity);
		return true;
	}
	
	@Override
	public List<SurveyChart> getChart() throws SQLException {
		return chart.getChartData();
	}

	private void validateSurvey(SurveyMusicFav entity) {
		if (entity == null) {
			throw new IllegalArgumentException("La encuesta es requerida");
		}
		if (entity.getEmail() == null || entity.getEmail().trim().isEmpty()) {
			throw new IllegalArgumentException("El email es requerido");
		}
		if (!EMAIL_PATTERN.matcher(entity.getEmail().trim()).matches()) {
			throw new IllegalArgumentException("El email no tiene un formato valido");
		}
		if (entity.getIdMusicStyle() == null) {
			throw new IllegalArgumentException("El estilo musical es requerido");
		}
		if (!musicStyleDao.existsById(entity.getIdMusicStyle())) {
			throw new IllegalArgumentException("El estilo musical no existe");
		}
	}

}
