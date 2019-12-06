package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.text.ParseException;

import javax.swing.*;
import ejercicios.*;

/**
 * Clase que define la vista de una pregunta
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero 
 */
public class VistaPregunta extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JPanel contenedor;
	private JLabel tipo;
	private JLabel enunciado;
	private JTextArea area;
	private JButton eliminar;
	private JLabel puntuacion;
	private JLabel penalizacion;
	private JLabel respuesta;
	private JScrollPane scroll;
	private SpringLayout layout;
	JFormattedTextField campo_puntuacion;
	JFormattedTextField campo_penalizacion;
	
	public VistaPregunta() throws ParseException{
		
		this.setBackground(Color.decode("#b0f373"));
		this.setPreferredSize(new Dimension(985, 200));
		
		tipo = new JLabel("");
		puntuacion = new JLabel("Puntuacion: ");
		penalizacion = new JLabel("Penalizacion: ");
		
		double numero = 00.00;

		campo_puntuacion = new JFormattedTextField(numero);
		campo_puntuacion.setPreferredSize(new Dimension(25,25));
		
		campo_penalizacion = new JFormattedTextField(numero);
		campo_penalizacion.setPreferredSize(new Dimension(25,25));
		
		eliminar = new JButton("Eliminar");
		respuesta = new JLabel("Respuestas: ");
		enunciado = new JLabel("Enunciado:");
		
		area = new JTextArea();
		area.setLineWrap(true); 
		
		scroll = new JScrollPane(area);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(500,30));
		scroll.setMaximumSize(new Dimension(800, 1000));
		
		layout = new SpringLayout();
		contenedor = new JPanel();
		contenedor.setLayout(layout);
		contenedor.setBackground(Color.decode("#ffffff"));
		contenedor.setPreferredSize(new Dimension(985, 200));
		
		contenedor.add(tipo);
		contenedor.add(enunciado);
		contenedor.add(scroll);
		contenedor.add(campo_puntuacion);
		contenedor.add(campo_penalizacion);
		contenedor.add(puntuacion);
		contenedor.add(respuesta);
		contenedor.add(penalizacion);
		contenedor.add(eliminar);
		//contenedor.add(scroll2);

		this.add(contenedor);
		
		/*lista*/
		//layout.putConstraint(SpringLayout.WEST, scroll2, 98, SpringLayout.WEST, this);
		//layout.putConstraint(SpringLayout.NORTH, scroll2, 100, SpringLayout.NORTH, this);
		
		/*tipo*/
		layout.putConstraint(SpringLayout.WEST, tipo, 20, SpringLayout.WEST, contenedor);
		layout.putConstraint(SpringLayout.NORTH, tipo, 5, SpringLayout.NORTH, contenedor);
		
		/*enunciado*/
		layout.putConstraint(SpringLayout.WEST, enunciado, 20, SpringLayout.WEST, contenedor);
		layout.putConstraint(SpringLayout.NORTH, enunciado, 15, SpringLayout.SOUTH, tipo);
		
		/*scroll*/
		layout.putConstraint(SpringLayout.WEST, scroll, 15, SpringLayout.EAST, enunciado);
		layout.putConstraint(SpringLayout.NORTH, scroll, 15, SpringLayout.SOUTH, tipo);
		
		/*puntuacion*/
		layout.putConstraint(SpringLayout.WEST, puntuacion, 280, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, puntuacion, 5, SpringLayout.NORTH, this);
		
		/*campo_puntuacion*/
		layout.putConstraint(SpringLayout.WEST, campo_puntuacion, 360, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, campo_puntuacion, 5, SpringLayout.NORTH, this);
		
		/*penalizacion*/
		layout.putConstraint(SpringLayout.WEST, penalizacion, 440, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, penalizacion, 5, SpringLayout.NORTH, this);
		
		/*campo_penalizacion*/
		layout.putConstraint(SpringLayout.WEST, campo_penalizacion, 520, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, campo_penalizacion, 5, SpringLayout.NORTH, this);
		
		/*respuesta*/
		layout.putConstraint(SpringLayout.WEST, respuesta, 20, SpringLayout.WEST, contenedor);
		layout.putConstraint(SpringLayout.NORTH, respuesta, 100, SpringLayout.SOUTH, tipo);	
		
		/*boton de eliminar*/
		layout.putConstraint(SpringLayout.WEST, eliminar, 750, SpringLayout.WEST, contenedor);
		layout.putConstraint(SpringLayout.NORTH, eliminar, 150, SpringLayout.NORTH, contenedor);
	}
	
	public JPanel getContenedor(){
		return contenedor;
	}
	
	public SpringLayout getLayout(){
		return layout;
	}
	
	public JLabel getTipoPregunta(){
		return tipo; 
	}
	
	public String getTipoPreg(){
		return null; 
	}
	
	public JLabel getRespuesta() {
		return respuesta;
	}
	
	public JScrollPane getScrollEnunciado() {
		return scroll;
	}
	
	public void aniadirOpcion(String opcion){ 
		
	}
	
	public JTextArea getEnunciado() {
		return area;
	}
	public JFormattedTextField getPuntuacion() {
		return campo_puntuacion;
	}
	public JFormattedTextField getPenalizacion() {
		return campo_penalizacion;
	}
	public Pregunta guardarPregunta() {
		return null;
	}
	
	/*public DefaultListModel<String> getLista() {
		return lista;
	}*/
}