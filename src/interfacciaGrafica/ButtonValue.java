package interfacciaGrafica;

public enum ButtonValue {
	NUOVO("Nuovo"), 
	MODIFICA("Modifica"), 
	ELIMINA("Elimina"),
	SALVA("Salva"),
	ANNULLA("Annulla");
	
	private String nome;
	
	ButtonValue(String nome) { this.nome = nome; }
	public String getNome() { return nome; }
}
