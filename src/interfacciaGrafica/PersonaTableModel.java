package interfacciaGrafica;

import javax.swing.table.AbstractTableModel;

import rubrica.*;

public class PersonaTableModel extends AbstractTableModel{
	public static final String[] COLUMNS = new String[] {"Nome", "Cognome", "Telefono"};
	public static final Class[] CLASSES = {String.class, String.class, String.class};
	private Rubrica data;
	private int rows;
	
	public PersonaTableModel(Rubrica r) {
		this.data = r;
		rows = data.getListaContatti().size();
	}
	
	@Override
	public int getRowCount() {
		return rows;
	}
	@Override
	public int getColumnCount() {
		return COLUMNS.length;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Persona p = (Persona) data.getContatto(rowIndex);
		switch(columnIndex) {
		case 0: return p.getNome();
		case 1: return p.getCognome();
		case 2: return p.getTelefono();
		default: return null;
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	@Override
	public String getColumnName(int col) {
		return COLUMNS[col];
	}
	
	@Override
	public Class getColumnClass(int c) {
		return CLASSES[c];
	}
}
