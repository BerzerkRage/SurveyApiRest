package cl.threeit.surveyapi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import cl.threeit.surveyapi.models.SurveyChart;
import cl.threeit.surveyapi.models.dao.ISurveyMusicFav;
import cl.threeit.surveyapi.models.dao.SurveyChartDao;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class SurveyMusicFavTest {
	
	@Autowired
	private ISurveyMusicFav iSurveyMusicFav;
	
	@Autowired
	private SurveyChartDao surveyChartDao;
	
	@Autowired
    private MockMvc mockMvc;
	
	@Test
	void createSurvey() throws Exception {

	    final String jsonCreateSurvey = "{\"email\": \"evil.esteban@gmail.com\", \"idMusicStyle\": 1}";
	    this.mockMvc.perform(post("/api/survey-music/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonCreateSurvey))
        .andDo(print())
        .andExpect(status().isOk());

	    assertThat(this.iSurveyMusicFav.findAll()).hasSize(11);
	}
	
	@Test
	void validChartData() throws Exception {
		List<SurveyChart> stadistics = this.surveyChartDao.getChartData();
		System.out.println(Arrays.asList(stadistics).toString());
	    assertThat(stadistics).hasSize(6);
	}
	
	/*
	@Mock
	private ISurveyMusicFav iSurveyMusicFav;
	
	@Mock
	private SurveyMusicFavService surveyMusicFavService;
	
	
	@Before(value = "")
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void registerSurvey() {
		SurveyMusicFav entity = new SurveyMusicFav();
		entity.setId(100);
		entity.setFechaCreacion(LocalDateTime.now());
		entity.setEmail("est.vergaraaedo@gmail.com");
		entity.setIdMusicStyle(1);
		
		surveyMusicFavService.create(entity);
		
		Mockito.verify(iSurveyMusicFav, Mockito.times(1)).save(entity);
		
		List<SurveyMusicFav> list = surveyMusicFavService.get();
		System.out.println(Arrays.asList(list).toString());
	}
	
	@Test 
	public void getChart() {
		try {
			List<SurveyChart> list = surveyMusicFavService.getChart();
			System.out.println(Arrays.asList(list).toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	*/
}
