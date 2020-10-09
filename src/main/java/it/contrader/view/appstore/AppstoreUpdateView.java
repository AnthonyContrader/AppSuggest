package it.contrader.view.appstore;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class AppstoreUpdateView extends AbstractView {
	private Request request;

	private int id;
	private String appname;
	private String apptype;
	private final String mode = "UPDATE";

	public AppstoreUpdateView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Appstore", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id dell'app:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci il nome dell'app:");
			appname = getInput();
			System.out.println("Inserisci tipo dell'app:");
			apptype = getInput();
		} catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("appname", appname);
		request.put("apptype", apptype);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Appstore", "doControl", request);
	}

}
