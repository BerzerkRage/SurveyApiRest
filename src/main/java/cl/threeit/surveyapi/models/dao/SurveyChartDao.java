package cl.threeit.surveyapi.models.dao;

import java.sql.SQLException;
import java.util.List;

import cl.threeit.surveyapi.models.SurveyChart;

public interface SurveyChartDao {

	List<SurveyChart> getChartData() throws SQLException;

}
