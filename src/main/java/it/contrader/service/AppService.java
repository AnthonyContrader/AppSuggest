package it.contrader.service;

import java.util.List;


import it.contrader.converter.AppConverter;
import it.contrader.dao.AppDAO;
import it.contrader.dto.AppDTO;

/**
 * 
 * @author Vittorio, De Santis
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class AppService {
	
	private AppDAO appDAO;
	private AppConverter appConverter;
	
	//Istanzio DAO  e Converter specifici.
	public AppService(){
		this.appDAO = new AppDAO();
		this.appConverter = new AppConverter();
	}
	

	public List<AppDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return appConverter.toDTOList(appDAO.getAll());
	}


	public AppDTO read(int id) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return appConverter.toDTO(appDAO.read(id));
	}


	public boolean insert(AppDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return appDAO.insert(appConverter.toEntity(dto));
	}


	public boolean update(AppDTO dto) {
		// Converte un appDTO in entità e lo passa allo appDAO per la modifica
		return appDAO.update(appConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return appDAO.delete(id);
	}
	

}