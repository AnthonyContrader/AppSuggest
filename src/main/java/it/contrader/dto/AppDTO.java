package it.contrader.dto;

/**
 * Per dettagli vedi guida sez 4 Model
 */
public class AppDTO {

	/**
	 * Qui sotto definisco gli attributi di App. 
	 */
	private int id;

	private String appname;
	
	private String apptype;
	

	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo App
	 */
	public AppDTO() {
		
	}

	public AppDTO (String appname, String apptype) {
		this.appname = appname;
		this.apptype = apptype;
	}

	public AppDTO (int id, String appname, String apptype) {
		this.id = id;
		this.appname = appname;
		this.apptype = apptype;
	}

	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di App
	 */
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getApptype() {
		return this.apptype;
	}

	public void setApptype(String apptype) {
		this.apptype = apptype;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getAppname() {
		return appname;
	}

	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		return  id + "\t"  + appname +"\t\t" +   apptype ;
	}
}