package interfaz;

import java.awt.Dimension;
import java.text.ParseException;

import javax.swing.*;

/**
 * Clase que define la vista de una pregunta abierta
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero 
 */
public class VistaPreguntaAbierta extends VistaPregunta {
	
	private static final long serialVersionUID = 1L;
	private JScrollPane scroll;
	private DefaultListModel<String> listaPreguntaTL;
	private JList<String> lista2;
	
	public VistaPreguntaAbierta() throws ParseException{
		
		super();
		getTipoPregunta().setText("Tipo pregunta: Texto libre");
		listaPreguntaTL = new DefaultListModel<String>();
		lista2 = new JList<String>(listaPreguntaTL);
		scroll = new JScrollPane(lista2);
		scroll.setPreferredSize(new Dimension(500,80));
		scroll.setMaximumSize(new Dimension(500,400));
		lista2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		getContenedor().add(scroll);
		
		getLayout().putConstraint(SpringLayout.WEST, scroll, 5, SpringLayout.EAST, getRespuesta());
		getLayout().putConstraint(SpringLayout.NORTH, scroll, 15, SpringLayout.SOUTH, getScrollEnunciado());
	}
	
	@Override
	public void aniadirOpcion(String respuesta){
		listaPreguntaTL.addElement(respuesta);
	}
	
	
	public String getTipoPreg(){
		return "textoLibre";
	}
	
	public DefaultListModel<String>  getLista(){
		return listaPreguntaTL;
	}
}