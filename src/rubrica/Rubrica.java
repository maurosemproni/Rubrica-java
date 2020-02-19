package rubrica;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Definisce la Rubrica telefonica
 * @author Mauro
 *
 */
public class Rubrica {
	public static final String PATH = "informazioni.txt";
	private ArrayList<Persona> contatti;
	
	/**
	 * Costruttore della classe. Crea un ArrayList di Persona 
	 * e lo riempie con i dati presi dal file informazioni.txt
	 */
	public Rubrica() { 
		contatti = new ArrayList<Persona>(); 
		creaFile();
		try{
			FileReader reader = new FileReader(PATH);
			Scanner in = new Scanner(reader);
			while(in.hasNextLine()) {
				String[] line = in.nextLine().split(";");
				Persona p = new Persona(line[0], line[1], line[2], line[3], Integer.parseInt(line[4]));
				aggiungiContatto(p);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		ordinaContatti();
	}
	
	/**
	 * Aggiunge una Persona alla Rubrica qualora questa non sia già presente, quindi ordina la rubrica
	 * @param p la Persona da aggiungere
	 */
	public void aggiungiContatto(Persona p) {
		if(!contatti.contains(p)) {
			contatti.add(p);
			ordinaContatti();
		}
	}
	
	/**
	 * Permette la rimozione di un contatto dalla Rubrica
	 * @param p la Persona da eliminare
	 * @return true se il contatto è stato rimosso, false altrimenti
	 */
	public boolean rimuoviContatto(Persona p) {
		return this.contatti.remove(p);
	}
	
	/**
	 * Metodo ausiliario che, facendo uso degli stream, ordina la rubrica 
	 * seguendo l'ordine lessicografico (prima per cognome poi per nome)
	 */
	private void ordinaContatti() {
		this.contatti = this.contatti.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
	}
	
	/**
	 * Restituisce il contatto all'indice index
	 * @param index l'index del contatto da restituire
	 * @return la persona all'indice index
	 */
	public Persona getContatto(int index) {
		return contatti.get(index);
	}
	
	/**
	 * Restituisce l'intera lista contatti
	 * @return un ArrayList<Persona> che rappresenta la lista contatti
	 */
	public ArrayList<Persona> getListaContatti() { return contatti; }
	
	@Override
	public String toString() {
		String result = "";
		for(Persona p : contatti) result += p + "\n";
		return result;
	}
	
	/**
	 * Metodo ausiliario che crea il file informazioni.txt qualora non sia presente
	 */
	private static void creaFile() {
		try {
			File file = new File(PATH);
			if(!file.exists()) file.createNewFile();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Effettua la scrittura della rubrica sul file informazioni.txt 
	 */
	public void salva() {
		try {
			PrintStream ps = new PrintStream(PATH);
			ps.print(this);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
