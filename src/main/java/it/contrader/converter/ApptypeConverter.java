package it.contrader.converter;

import it.contrader.dto.ApptypeDTO;
import it.contrader.model.Apptype;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Vittorio
 * 
 * Implementando questa l'interfaccia converter la classe AppConverter � OBBLIGATA ad implementarne i metodi
 *
 */
@Component
public class ApptypeConverter extends AbstractConverter<Apptype, ApptypeDTO> {
	
	/**
	 * Crea un oggetto di tipo AppDTO e lo riempie con i campi del parametro user di tipo App.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public ApptypeDTO toDTO(Apptype apptype) {
		ApptypeDTO apptypeDTO = new ApptypeDTO(apptype.getId(), apptype.getTag());
		return apptypeDTO;
	}

	/**
	 * Crea un oggetto di tipo App e lo riempie con i campi del parametro user di tipo AppDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public Apptype toEntity(ApptypeDTO apptypeDTO) {
		Apptype apptype = new Apptype(apptypeDTO.getId(), apptypeDTO.getTag());
		return apptype;
	}
	
	/**
	 * Metodo per convertire le liste di App.
	 */


	
	
}
