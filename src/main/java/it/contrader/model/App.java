package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class App {

	/**
	 * Qui sotto definisco gli attributi di App. 
	 */
	private int id;

	private String appname;
	
	private String apptype;
	

	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo App
	 */
	public App() {
		
	}

	public App (String appname, String apptype) {
		this.appname = appname;
		this.apptype = apptype;
	}

	public App (int id, String appname, String apptype) {
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
		return  id + "\t"  + appname +"\t\t" +   apptype + "\t\t";
	}

	//Metodo per il confronto degli oggetti
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		App other = (App) obj;
		if (id != other.id)
			return false;
		if (apptype == null) {
			if (other.apptype != null)
				return false;
		} else if (!apptype.equals(other.apptype))
			return false;
		if (appname == null) {
			if (other.appname != null)
				return false;
		} else if (!appname.equals(other.appname))
			return false;
		return true;
	}
}

