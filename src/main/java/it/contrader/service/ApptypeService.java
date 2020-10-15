package it.contrader.service;

import it.contrader.converter.ApptypeConverter;
import it.contrader.dao.ApptypeDAO;
import it.contrader.dto.ApptypeDTO;
import it.contrader.model.Apptype;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class ApptypeService extends AbstractService<Apptype, ApptypeDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public ApptypeService(){
		this.dao = new ApptypeDAO();
		this.converter = new ApptypeConverter();
	}
	

}
