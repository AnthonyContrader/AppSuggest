package it.contrader.service;

import it.contrader.converter.ApptypeConverter;
import it.contrader.dao.ApptypeRepository;
import it.contrader.dto.ApptypeDTO;
import it.contrader.model.Apptype;
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
public class ApptypeService extends AbstractService<Apptype, ApptypeDTO> {


	public List<ApptypeDTO> findAll() {
		return converter.toDTOList(repository.findAll());
	}
/*	public List<ApptypeDTO> findByNameTag(long id) {
		return converter.toDTOList(repository.findByNameTag(id ));
	}
*/
}
