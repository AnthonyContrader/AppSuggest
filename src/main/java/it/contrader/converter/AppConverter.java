package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.AppDTO;
import it.contrader.model.App;

/**
 * 
 * @author Vittorio
 * 
 * Implementando questa l'interfaccia converter la classe AppConverter è OBBLIGATA ad implementarne i metodi
 *
 */
public class AppConverter  implements Converter<App, AppDTO> {
	
	/**
	 * Crea un oggetto di tipo AppDTO e lo riempie con i campi del parametro user di tipo App.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public AppDTO toDTO(App user) {
		AppDTO userDTO = new AppDTO(user.getId(), user.getAppname(), user.getApptype());
		return userDTO;
	}

	/**
	 * Crea un oggetto di tipo App e lo riempie con i campi del parametro user di tipo AppDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public App toEntity(AppDTO userDTO) {
		App user = new App(userDTO.getId(), userDTO.getAppname(), userDTO.getApptype());
		return user;
	}
	
	/**
	 * Metodo per convertire le liste di App.
	 */
	@Override
	public List<AppDTO> toDTOList(List<App> userList) {
		//Crea una lista vuota.
		List<AppDTO> userDTOList = new ArrayList<AppDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(App user : userList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			userDTOList.add(toDTO(user));
		}
		return userDTOList;
	}

	
	
}
