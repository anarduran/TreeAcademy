package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Clase que define la vista de una pregunta multiopcion
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero 
 */
public class VistaPreguntaMulti extends VistaPregunta {
	private static final long serialVersionUID = 1L;
	ArrayList<JCheckBox> opciones;
	private ButtonGroup grupo;
	private JPanel contenedor;
	private JScrollPane scroll;
	
	public VistaPreguntaMulti() throws ParseException{
		super();
		getTipoPregunta().setText("Tipo pregunta: Opcion multiple");
		contenedor = new JPanel();
		BoxLayout layout = new BoxLayout(contenedor, BoxLayout.Y_AXIS);
		contenedor.setLayout(layout);
		contenedor.setBackground(Color.decode("#ffffff"));
		
		scroll = new JScrollPane(contenedor);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(500, 50));
		scroll.setMaximumSize(new Dimension(500, 800));
		
		grupo = new ButtonGroup();
		
		opciones = new ArrayList<JCheckBox>();
		
		super.getContenedor().add(scroll);
		getLayout().putConstraint(SpringLayout.WEST, scroll, 5, SpringLayout.EAST, getRespuesta());
		getLayout().putConstraint(SpringLayout.NORTH, scroll, 10, SpringLayout.SOUTH, getScrollEnunciado());
	}
	
	@Override
	public void aniadirOpcion(String opcion){
		JCheckBox opcion1;
		opcion1 = new JCheckBox(opcion);
		grupo.add(opcion1);
		contenedor.add(opcion1);
		opciones.add(opcion1);
	}
		
	public String getTipoPreg(){
		return "opcionMultiple";
	}

	public ArrayList<JCheckBox> getOpciones() {
		return opciones;
	}
	
	
}