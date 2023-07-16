package cl.threeit.surveyapi.models.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import cl.threeit.surveyapi.models.SurveyChart;
import cl.threeit.surveyapi.models.dao.SurveyChartDao;

@Repository
public class SurverChartDaoImpl implements SurveyChartDao {

	@Value("${spring.datasource.url}")
	private String SQL_SOURCE;
	@Value("${spring.datasource.name}")
	private String SQL_USER;
	@Value("${spring.datasource.password}")
	private String SQL_PASS;
	
	@Override
	public List<SurveyChart> getChartData() throws SQLException {
		List<SurveyChart> result = null;
		Connection conn = DriverManager.getConnection(SQL_SOURCE, SQL_USER, SQL_PASS);
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT B.nombre AS musica, COUNT(*) AS cantidad\n"
					+ "	FROM TA_SURVEYMUSICFAV A \n"
					+ "	JOIN TA_MUSICSTYLE B ON (A.ID_MUSICSTYLE = B.ID)\n"
					+ "	GROUP BY B.nombre;");
			result = new LinkedList<>();
			while (rs.next()) {
				SurveyChart data = new SurveyChart(rs.getString(1), rs.getInt(2));
				result.add(data);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.close();
		}
		
		return result;
	}
}
