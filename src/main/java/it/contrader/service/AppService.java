package it.contrader.service;

import it.contrader.converter.AppConverter;
import it.contrader.dao.AppRepository;
import it.contrader.dto.AppDTO;
import it.contrader.model.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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





	/*public List<AppDTO> findByApptype() {
		return converter.toDTOList(repository.findByApptype());
	}

	public AppDTO findByAppById(long id) {
		return converter.toDTO( repository.findByAppById(id) );
	}*/
}
