package it.contrader.controller;

import java.util.List;

import it.contrader.dto.AppDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.AppService;

/**
 * 
 * @author Vittorio
 *
 *Si osservi che nel Controller compaiono solo oggetti del DTO e non del Model!
 */
public class AppstoreController implements Controller {

	/**
	 * definisce il pacchetto di vista appstore
	 */
	private static String sub_package = "appstore.";
	
	private AppService appService;
	/**
	 * Costruisce un oggetto di tipo UserService per poterne usare i metodi
	 */
	public AppstoreController() {
		this.appService = new AppService();
	}
	
	@Override
	public void doControl(Request request) {
		
		
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int id;
		String appname;
		String apptype;

		switch (mode) {
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		
		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			appname = request.get("appname").toString();
			apptype = request.get("apptype").toString();
			
			//costruisce l'oggetto user da inserire
			AppDTO apptoinsert = new AppDTO(appname, apptype);
			//invoca il service
			appService.insert(apptoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "AppstoreInsert", request);
			break;
		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			appService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "AppstoreDelete", request);
			break;
			
			
			// Arriva qui dalla UserUpdateView
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			appname = request.get("appname").toString();
			apptype = request.get("apptype").toString();
			AppDTO apptoupdate = new AppDTO(appname, apptype);
			apptoupdate.setId(id);
			appService.update(apptoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "AppstoreUpdate", request);
			break;
			
		//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "APPLIST":
			List<AppDTO> appsDTO = appService.getAll();
			//Impacchetta la request con la lista degli user
			request.put("apps", appsDTO);
			MainDispatcher.getInstance().callView("Appstore", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "UserRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "AppstoreInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "AppstoreUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "AppstoreDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}