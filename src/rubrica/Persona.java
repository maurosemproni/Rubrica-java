package rubrica;

/**
 * Definisce il contatto della Rubrica. Implementa la classe Comparable per stabilire un ordine tra i contatti
 * @author Mauro
 *
 */
public class Persona implements Comparable<Persona> {
	/**
	 * il nome della persona
	 */
	private String nome;
	/**
	 * il cognome della persona
	 */
	private String cognome;
	/**
	 * l'indirizzo di residenza della persona
	 */
	private String indirizzo;
	/**
	 * il telefono della persona
	 */
	private String telefono;
	/**
	 * l'età anagrafica della persona
	 */
	private int eta;
	
	/**
	 * Costruttore vuoto
	 */
	public Persona() {
		nome = "";
		cognome = "";
		indirizzo = "";
		telefono = "";
		eta = 0;
	}
	
	/**
	 * Costruttore della Classe
	 * @param nome il nome della persona
	 * @param cognome il cognome della persona
	 * @param indirizzo l'indirizzo di residenza della persona
	 * @param telefono il telefono della persona
	 * @param eta l'età anagrafica della persona
	 */
	public Persona(String nome, String cognome, String indirizzo, String telefono, int eta) {
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.eta = eta;
	}
	
	/**
	 * Permette la modifica del nome della persona
	 * @param nome il nuovo nome da assegnare alla persona
	 */
	public void setNome(String nome) { this.nome = nome; }
	
	/**
	 * Permette la modifica del cognome della Persona
	 * @param cognome il nuovo cognome da assegnare alla persona
	 */
	public void setCognome(String cognome) { this.cognome = cognome; }
	
	/**
	 * Permette la modifica dell'indirizzo di residenza della Persona
	 * @param indirizzo il nuovo indirizzo della persona
	 */
	public void setIndirizzo(String indirizzo) { this.indirizzo = indirizzo; }
	
	/**
	 * Permette la modifica del numero di telefono della Persona
	 * @param telefono il nuovo numero di telefono della persona
	 */
	public void setTelefono(String telefono) { this.telefono = telefono; }
	
	/**
	 * permette la modifica dell'età della Persona
	 * @param eta la nuova età della persona
	 */
	public void setEta(int eta) { this.eta = eta; }
	
	/**
	 * Restituisce il nome della persona salvato in memoria
	 * @return il nome
	 */
	public String getNome() { return this.nome; }
	
	/**
	 * Restituisce il cognome della persona salvato in memoria
	 * @return il cognome
	 */
	public String getCognome() { return this.cognome; }
	
	/**
	 * Restituisce l'indirizzo della persona salvato in memoria
	 * @return l'indirizzo
	 */
	public String getIndirizzo() { return this.indirizzo; }
	
	/**
	 * Restituisce il telefono della persona salvato in memoria
	 * @return il telefono
	 */
	public String getTelefono() { return this.telefono; }
	
	/**
	 * Restituisce l'età della persona salvata in memoria
	 * @return l'età
	 */
	public int getEta() { return this.eta; }
	
	/**
	 * Ovverride del metodo equals. Due persone sono considerate uguali se hanno lo stesso telefono
	 */
	@Override
	public boolean equals(Object o) {
		if(o == this) return true;
		if(o == null || o.getClass() != this.getClass()) return false;
		Persona p = (Persona) o;
		return this.telefono.equals(p.telefono);
	}
	
	/**
	 * Override del metodo hashCode
	 */
	@Override
	public int hashCode() { return this.telefono.hashCode(); }
	
	/**
	 * Override del metodo compareTo.
	 * Permette di di stabilire un ordine lessicografico tra le persone per cognome e quindi per nome
	 */
	@Override
	public int compareTo(Persona o) {
		int v = this.cognome.compareTo(o.cognome);
		return v == 0 ? this.nome.compareTo(o.nome) : v;
	}
	
	@Override
	public String toString() {
		return nome + ";" + cognome + ";" + indirizzo + ";" + telefono + ";" + eta;
	}
	
}
