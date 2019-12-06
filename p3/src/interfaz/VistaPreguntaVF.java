package interfaz;

import java.text.ParseException;

import javax.swing.*;

/**
 * Clase que define la vista de una pregunta verdadero/falso
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero 
 */
public class VistaPreguntaVF extends VistaPregunta {
	private static final long serialVersionUID = 1L;
	private ButtonGroup group;
	private JRadioButton verdadero;
	private JRadioButton falso;
	
	public VistaPreguntaVF() throws ParseException{
		super();
		getTipoPregunta().setText("Tipo pregunta: Verdadero o falso");
		verdadero = new JRadioButton("Verdadero");
		falso = new JRadioButton("Falso");
		group = new ButtonGroup();
		group.add(verdadero);
		group.add(falso);
		
		getContenedor().add(verdadero);
		getContenedor().add(falso);
			
		getLayout().putConstraint(SpringLayout.WEST, verdadero, 5, SpringLayout.EAST, getRespuesta());
		getLayout().putConstraint(SpringLayout.NORTH, verdadero, 15, SpringLayout.SOUTH, getScrollEnunciado());
		
		getLayout().putConstraint(SpringLayout.WEST, falso, 5, SpringLayout.EAST, getRespuesta());
		getLayout().putConstraint(SpringLayout.NORTH, falso, 5, SpringLayout.SOUTH, verdadero);
	}
	
	public String getTipoPreg(){
		return "VF";
	}

	public JRadioButton getVerdadero() {
		return verdadero;
	}

	public JRadioButton getFalso() {
		return falso;
	}
	
	
}