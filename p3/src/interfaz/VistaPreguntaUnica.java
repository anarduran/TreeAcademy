package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Clase que define la vista de una pregunta unica
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero 
 */
public class VistaPreguntaUnica extends VistaPregunta {
	private static final long serialVersionUID = 1L;
	private ButtonGroup grupo;
	private JPanel contenedor;
	private JScrollPane scroll;
	private ArrayList<JRadioButton> opciones;
	
	public VistaPreguntaUnica() throws ParseException{
		super();
		getTipoPregunta().setText("Tipo pregunta: Opcion unica");
		contenedor = new JPanel();
		BoxLayout layout = new BoxLayout(contenedor, BoxLayout.Y_AXIS);
		contenedor.setLayout(layout);
		contenedor.setBackground(Color.decode("#ffffff"));
		
		scroll = new JScrollPane(contenedor);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(500, 80));
		scroll.setMaximumSize(new Dimension(500, 800));
		
		grupo = new ButtonGroup();
		
		opciones = new ArrayList<JRadioButton>();
		
		super.getContenedor().add(scroll);
		getLayout().putConstraint(SpringLayout.WEST, scroll, 5, SpringLayout.EAST, getRespuesta());
		getLayout().putConstraint(SpringLayout.NORTH, scroll, 10, SpringLayout.SOUTH, getScrollEnunciado());
	
	}
	
	public String getTipoPreg(){
		return "opcionUnica";
	}
	@Override
	public void aniadirOpcion(String opcion){
		JRadioButton opcion1;
		opcion1 = new JRadioButton(opcion);
		super.getContenedor().add(opcion1);
		grupo.add(opcion1);
		contenedor.add(opcion1);
		opciones.add(opcion1);
	}

	public ArrayList<JRadioButton> getOpciones() {
		return opciones;
	}
	
}