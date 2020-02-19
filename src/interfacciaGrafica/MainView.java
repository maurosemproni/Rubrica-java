package interfacciaGrafica;

import javax.swing.*;

import rubrica.Persona;
import rubrica.Rubrica;

import java.awt.*;

public class MainView extends JFrame {
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 700;
	
	private Rubrica rubrica;
	private JTable table;
	
	public MainView() {
		super("Rubrica");
		
		rubrica = new Rubrica();
		table = new JTable(new PersonaTableModel(rubrica));
		
		JToolBar toolbar = new JToolBar();
		populateToolBar(toolbar);
		this.getContentPane().add(toolbar, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane(table);
		this.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setSize(WIDTH, HEIGHT);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(((int)dim.getWidth()-this.getWidth())/2, ((int)dim.getHeight()-this.getHeight())/2);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainView();
	}
	
	private void populateToolBar(JToolBar toolBar) {
        ButtonListener listener = new ButtonListener(rubrica, table);
		JButton nuovo = new JButton(ButtonValue.NUOVO.getNome());
        toolBar.add(nuovo);
        nuovo.addActionListener(listener);
        JButton modifica = new JButton(ButtonValue.MODIFICA.getNome());
        toolBar.add(modifica);
        modifica.addActionListener(listener);
        JButton elimina = new JButton(ButtonValue.ELIMINA.getNome());
        toolBar.add(elimina);
        elimina.addActionListener(listener);
    }

}
