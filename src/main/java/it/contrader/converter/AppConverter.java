package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.AppDTO;
import it.contrader.model.App;

/**
 * 
 * @author Vittorio, De Santis 
 *
 */
public class AppConverter   {
	
	/**
	 * Crea un oggetto di tipo UserDTO e lo riempie con i campi del parametro user di tipo User.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public AppDTO toDTO(App app) {
		AppDTO AppDTO = new AppDTO(app.getId(), app.getAppname(), app.getApptype());
		return AppDTO;
	}

	/**
	 * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo UserDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public App toEntity(AppDTO appDTO) {
		App app = new App(appDTO.getId(), appDTO.getAppname(), appDTO.getApptype());
		return app;
	}
	
	/**
	 * Metodo per convertire le liste di User.
	 */
	public List<AppDTO> toDTOList(List<App> appList) {
		//Crea una lista vuota.
		List<AppDTO> appDTOList = new ArrayList<AppDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(App app : appList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			appDTOList.add(toDTO(app));
		}
		return appDTOList;
	}

	
	
}
