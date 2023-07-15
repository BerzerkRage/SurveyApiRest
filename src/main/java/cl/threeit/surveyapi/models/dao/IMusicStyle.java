package cl.threeit.surveyapi.models.dao;

import org.springframework.data.repository.CrudRepository;

import cl.threeit.surveyapi.models.entities.MusicStyle;

public interface IMusicStyle extends CrudRepository<MusicStyle, Integer>{

}
