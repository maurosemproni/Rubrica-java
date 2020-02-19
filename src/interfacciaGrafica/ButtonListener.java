package interfacciaGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import rubrica.Persona;
import rubrica.Rubrica;

public class ButtonListener implements ActionListener {
	private Rubrica rubrica;
	private JTable table;
	
	public ButtonListener(Rubrica r, JTable t) {
		this.rubrica = r;
		this.table = t;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		if(b.getText().equals(ButtonValue.NUOVO.getNome())) new EditorPersona(rubrica, table, null);
		if(b.getText().equals(ButtonValue.ELIMINA.getNome())) {
			if(table.getSelectedRowCount() != 1) selectionError();
			else {
				Persona p = rubrica.getContatto(table.getSelectedRow());
				int returnValue = JOptionPane.showConfirmDialog(table, "Vuoi eliminare " + p.getNome() + " " + p.getCognome() + "?");
				if(returnValue == JOptionPane.YES_OPTION) {
					rubrica.rimuoviContatto(p);
					table.setModel(new PersonaTableModel(rubrica));
					rubrica.salva();
				}
			}
		}
		if(b.getText().equals(ButtonValue.MODIFICA.getNome())) {
			if(table.getSelectedRowCount() != 1) selectionError();
			else {
				Persona p = rubrica.getContatto(table.getSelectedRow());
				new EditorPersona(rubrica, table, p);
			}
		}
	}
	
	private void selectionError() {
		JOptionPane.showMessageDialog(table, "Selezionare una riga della tabella");
	}

}
