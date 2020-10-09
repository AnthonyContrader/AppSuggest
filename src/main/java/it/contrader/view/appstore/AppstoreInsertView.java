package it.contrader.view.appstore;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class AppstoreInsertView extends AbstractView{
	private Request request;

	private String appname;
	private String apptype;
	private final String mode = "INSERT";

	public AppstoreInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento dell'app andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Appstore", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci nome dell'applicazione:");
			appname = getInput();
			System.out.println("Inserisci il tipo dell'applicazione:");
			apptype = getInput();
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("appname", appname);
		request.put("apptype", apptype);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Appstore", "doControl", request);
	}


}