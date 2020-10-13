package it.contrader.service;

import it.contrader.converter.AppConverter;
import it.contrader.dao.AppDAO;
import it.contrader.dto.AppDTO;
import it.contrader.model.App;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class AppService extends AbstractService<App, AppDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public AppService(){
		this.dao = new AppDAO();
		this.converter = new AppConverter();
	}
	

}
