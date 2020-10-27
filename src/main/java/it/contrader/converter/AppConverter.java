package it.contrader.converter;

import it.contrader.dto.AppDTO;
import it.contrader.model.App;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Vittorio
 * 
 * Implementando questa l'interfaccia converter la classe AppConverter � OBBLIGATA ad implementarne i metodi
 *
 */
@Component
public class AppConverter extends AbstractConverter<App, AppDTO> {
	
	/**
	 * Crea un oggetto di tipo AppDTO e lo riempie con i campi del parametro user di tipo App.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public AppDTO toDTO(App app) {
		AppDTO appDTO = new AppDTO(app.getId(), app.getAppname(),app.getApptype());
		return appDTO;
	}

	/**
	 * Crea un oggetto di tipo App e lo riempie con i campi del parametro user di tipo AppDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public App toEntity(AppDTO appDTO) {
		App app = new App(appDTO.getId(), appDTO.getAppname(),appDTO.getApptype());
		return app;
	}
	
	/**
	 * Metodo per convertire le liste di App.
	 */


	
	
}
