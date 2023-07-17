package cl.threeit.surveyapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.threeit.surveyapi.models.dao.IMusicStyle;
import cl.threeit.surveyapi.models.entities.MusicStyle;
import cl.threeit.surveyapi.services.impl.MusicStyleServiceImpl;

@ExtendWith(MockitoExtension.class)
public class MusicStyleTest {

	@Mock 
	private IMusicStyle iMusicStyle;
	
	@InjectMocks
	private MusicStyleServiceImpl musicStyleService;
	
	
	@Before(value = "")
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	
	@Test 
	public void getData() {
		List<MusicStyle> listTest = new LinkedList<>();
		listTest.add(new MusicStyle(1, "Rock", true));
		listTest.add(new MusicStyle(2, "Pop", true));
		listTest.add(new MusicStyle(3, "Clásica", true));
		listTest.add(new MusicStyle(4, "Salsa", true));
		listTest.add(new MusicStyle(5, "Ambiental", false));  // SERVICIO FILTRA ACTIVOS, POR LO TANTO ESTE NO DEBE DEVOLVERSE POR UN SERVICIO
		listTest.add(new MusicStyle(6, "Electronica", true));
		
		when((List<MusicStyle>)iMusicStyle.findAll()).thenReturn(listTest); // DESDE LA PERSITENCIA SE DEVUELVE TODOS LOS ELEMENTOS
		
		List<MusicStyle> musicStylesList = musicStyleService.get();
		System.out.println(Arrays.asList(musicStylesList).toString());
		assertEquals(5, musicStylesList.size()); // ENTONCES DESDE UN SERVICIO ESPERAMOS SOLO 5 ELEMENTOS, QUE SON LOS ACTIVADOS (activado = TRUE)
		verify(iMusicStyle, times(1)).findAll();
		
	}
}
