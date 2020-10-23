package it.contrader.service;

import it.contrader.converter.AppConverter;
import it.contrader.dao.AppRepository;
import it.contrader.dto.AppDTO;
import it.contrader.dto.ApptypeDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.App;
import it.contrader.model.Apptype;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditariet� mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */

@Service
public class AppService extends AbstractService<App, AppDTO> {

	@Autowired
	private AppConverter converter;

	@Autowired
	private AppRepository repository;
	//Istanzio DAO  e Converter specifici.




	/*public List<AppDTO> findByApptype() {
		return converter.toDTOList(repository.findByApptype());
	}

	public AppDTO findByAppById(long id) {
		return converter.toDTO( repository.findByAppById(id) );
	}*/
}
