package it.contrader.converter;

import it.contrader.dto.ApptypeDTO;
import it.contrader.model.Apptype;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Vittorio
 * 
 * Implementando questa l'interfaccia converter la classe ApptypeConverter � OBBLIGATA ad implementarne i metodi
 *
 */
public class ApptypeConverter  implements Converter<Apptype, ApptypeDTO> {
	
	/**
	 * Crea un oggetto di tipo ApptypeDTO e lo riempie con i campi del parametro apptype di tipo Apptype.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public ApptypeDTO toDTO(Apptype apptype) {
		ApptypeDTO apptypeDTO = new ApptypeDTO(apptype.getId(), apptype.getTag());
		return apptypeDTO;
	}

	/**
	 * Crea un oggetto di tipo Apptype e lo riempie con i campi del parametro apptype di tipo ApptypeDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public Apptype toEntity(ApptypeDTO apptypeDTO) {
		Apptype apptype = new Apptype(apptypeDTO.getId(), apptypeDTO.getTag());
		return apptype;
	}
	
	/**
	 * Metodo per convertire le liste di Apptype.
	 */
	@Override
	public List<ApptypeDTO> toDTOList(List<Apptype> apptypeList) {
		//Crea una lista vuota.
		List<ApptypeDTO> apptypeDTOList = new ArrayList<ApptypeDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Apptype apptype : apptypeList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			apptypeDTOList.add(toDTO(apptype));
		}
		return apptypeDTOList;
	}

	
	
}
