package interfacciaGrafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import rubrica.*;

public class EditorPersona extends JFrame {
	
	private Rubrica rubrica;
	private Persona persona;
	private JTable table;

	public EditorPersona(Rubrica r, JTable t, Persona p) {
		super("Editor Persona");
		
		rubrica = r;
		persona = p == null ? new Persona() : p;
		table = t;
		
		JPanel form = new JPanel();
		JPanel buttons = new JPanel();
		
		form.setLayout(new GridLayout(5,2,20,20));
		form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		form.add(new JLabel("Nome"));
		JTextField nome = new JTextField(20);
		nome.setText(persona.getNome());
		form.add(nome);
		form.add(new JLabel("Cognome"));
		JTextField cognome = new JTextField(30);
		cognome.setText(persona.getCognome());
		form.add(cognome);
		form.add(new JLabel("Indirizzo"));
		JTextField indirizzo = new JTextField(30);
		indirizzo.setText(persona.getIndirizzo());
		form.add(indirizzo);
		form.add(new JLabel("Telefono"));
		JTextField telefono = new JTextField(20);
		telefono.setText(persona.getTelefono());
		form.add(telefono);
		form.add(new JLabel("Età"));
		JTextField eta = new JTextField(3);
		eta.setText(persona.getEta() == 0 ? "" : persona.getEta() + "");
		form.add(eta);
		
		JButton salva = new JButton(ButtonValue.SALVA.getNome());
		salva.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 persona.setNome(nome.getText());
				 persona.setCognome(cognome.getText());
				 persona.setIndirizzo(indirizzo.getText());
				 persona.setTelefono(telefono.getText());
				 persona.setEta(Integer.parseInt(eta.getText()));
				 rubrica.aggiungiContatto(persona);
				 table.setModel(new PersonaTableModel(rubrica));
				 rubrica.salva();
				 dispose();
			 }
		});
		JButton annulla = new JButton(ButtonValue.ANNULLA.getNome());
		annulla.addActionListener(new ActionListener() {
			@Override
			 public void actionPerformed(ActionEvent e) {
				 dispose();
			 }
		});
		buttons.add(salva);
		buttons.add(annulla);
		
		Container c = this.getContentPane();
		c.add(form, BorderLayout.CENTER);
		c.add(buttons, BorderLayout.SOUTH);
		
		pack();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(((int)dim.getWidth()-this.getWidth())/2, ((int)dim.getHeight()-this.getHeight())/2);
		this.setVisible(true);
	}
	
	@Override
	public void dispose() {
		super.dispose();
	}
}
