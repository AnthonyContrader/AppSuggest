package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.AppDTO;
import it.contrader.model.App;

/**
 * 
 * @author Vittorio
 * 
 * Implementando questa l'interfaccia converter la classe AppConverter � OBBLIGATA ad implementarne i metodi
 *
 */
public class AppConverter  implements Converter<App, AppDTO> {
	
	/**
	 * Crea un oggetto di tipo AppDTO e lo riempie con i campi del parametro user di tipo App.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public AppDTO toDTO(App app) {
		AppDTO appDTO = new AppDTO(app.getId(), app.getAppname(), app.getApptype());
		return appDTO;
	}

	/**
	 * Crea un oggetto di tipo App e lo riempie con i campi del parametro user di tipo AppDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public App toEntity(AppDTO appDTO) {
		App app = new App(appDTO.getId(), appDTO.getAppname(), appDTO.getApptype());
		return app;
	}
	
	/**
	 * Metodo per convertire le liste di App.
	 */
	@Override
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
