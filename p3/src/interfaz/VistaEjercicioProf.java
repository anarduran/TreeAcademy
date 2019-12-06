package interfaz;

import java.awt.*;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Clase que define la vista del menu de una asignatura de profesor
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero 
 */
public class VistaEjercicioProf extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel titulo;
	private JLabel encabezado;
	private JLabel logo1;
	private JLabel logo2;
	private JLabel arbol;
	private JLabel nombre;
	private JLabel respuesta;
	private JLabel numPregunta;
	private JLabel peso;
	private JLabel numPregunta1;
	
	private JButton salir;
	private JButton inicio;
	private JButton volver;
	private JButton guardar;
	private JButton aniadir;
	private JButton aniadirRespuesta;
	private JButton eliminar;
	private JButton cancelar;
	
	private JFormattedTextField numeroPregunta;
	private JFormattedTextField campo_peso;
	private JFormattedTextField numeroPregunta1;
	
	private JTextField campo_respuesta;
	
	private JPanel contenedor;
	private JPanel contenedor2;
	private JPanel contenedor3;
	private JPanel contenedor4;
	
	private JCheckBox correcta;
	private JCheckBox incorrecta;
	
	private JScrollPane scroll;
	
	private JSeparator separador;
	
	private JComboBox<String> combobox;
	ArrayList<VistaPregunta> vistaPreguntas;
	
	public VistaEjercicioProf() throws ParseException{
		this.setBackground(Color.decode("#b0f373"));
		this.setPreferredSize(new Dimension(1050, 750));
		vistaPreguntas = new ArrayList<VistaPregunta>();
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		Dimension dim = new Dimension(90, 35);
		Dimension dim2 = new Dimension(150, 20);
		
		logo1 = new JLabel(new ImageIcon("Logo.png"));
		logo2 = new JLabel(new ImageIcon("Logo copia.png"));
		
		encabezado = new JLabel("ree Academy");
		encabezado.setFont(new Font("Gabriola", Font.PLAIN, 70));
		arbol = new JLabel(new ImageIcon("arbol.png"));
		
		titulo = new JLabel("<<EJERCICIO PROFESOR>>");
		
		nombre = new JLabel("Nombre ejercicio");
		nombre.setFont(new Font("Gabriola", Font.PLAIN, 24));
		
		salir = new JButton("Salir");
		salir.setPreferredSize(dim);
		
		inicio = new JButton("Inicio");
		inicio.setPreferredSize(dim);
		
		volver = new JButton("Volver");
		volver.setPreferredSize(dim);
		
		guardar = new JButton("Guardar");
		guardar.setPreferredSize(dim2);
		
		aniadir = new JButton("Añadir pregunta");
		aniadir.setPreferredSize(dim2);
		
		cancelar = new JButton("Cancelar");
		cancelar.setPreferredSize(dim2);
		
		contenedor = new JPanel();
		SpringLayout layout2 = new SpringLayout();
		contenedor.setLayout(layout2);
		contenedor.setBackground(Color.decode("#ffffff"));
		contenedor.setPreferredSize(new Dimension(850, 150));
		contenedor.setBorder(BorderFactory.createLineBorder(Color.decode("#45BC3C"),1));
	
		contenedor2 = new JPanel();
		BoxLayout layout3 = new BoxLayout(contenedor2, BoxLayout.Y_AXIS);
		contenedor2.setLayout(layout3);
		contenedor2.setBackground(Color.decode("#ffffff"));
		
		scroll = new JScrollPane(contenedor2);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setPreferredSize(new Dimension(850, 250));
		scroll.setMaximumSize(new Dimension(850, 20000));
       
		separador = new JSeparator();
		separador.setOrientation(SwingConstants.HORIZONTAL);
		separador.setPreferredSize(new Dimension(1050,2));
		separador.setVisible(true);
		separador.setBackground(Color.decode("#ffffff"));
		
		combobox = new JComboBox<String>();
		combobox.addItem("Pregunta de opcion única");
		combobox.addItem("Pregunta de verdadero/falso");
		combobox.addItem("Pregunta de opcion múltiple");
		combobox.addItem("Pregunta de texto libre");
		
		SpringLayout layout4 = new SpringLayout();
		
		contenedor3 = new JPanel();
		contenedor3.setLayout(layout4);
		contenedor3.setBackground(Color.decode("#ffffff"));
		contenedor3.setPreferredSize(new Dimension(820, 40));
		contenedor3.setBorder(BorderFactory.createLineBorder(Color.decode("#45BC3C"),1));
		
		aniadirRespuesta = new JButton("Añadir respuesta");
		campo_respuesta = new JTextField(20);
		respuesta = new JLabel("Respuesta: ");
		
		numPregunta = new JLabel("Numero de pregunta: ");
		
		int numero=0;
		
		numeroPregunta = new JFormattedTextField(numero);
		numeroPregunta.setPreferredSize(new Dimension(25,25));
		
		peso = new JLabel("Peso del ejercicio: ");

		double numero1 = 00.00;
		
		campo_peso = new JFormattedTextField(numero1);
		campo_peso.setPreferredSize(new Dimension(25,25));
		
		SpringLayout layout5 = new SpringLayout();
		
		contenedor4 = new JPanel();
		contenedor4.setLayout(layout5);
		contenedor4.setBackground(Color.decode("#ffffff"));
		contenedor4.setPreferredSize(new Dimension(300, 40));
		contenedor4.setBorder(BorderFactory.createLineBorder(Color.decode("#45BC3C"),1));
		
		numPregunta1 = new JLabel("Numero de pregunta: ");
		numeroPregunta1 = new JFormattedTextField();
		numeroPregunta1.setPreferredSize(new Dimension(25,25));
		numeroPregunta1.setValue(numero);
		
		eliminar = new JButton("Eliminar pregunta");
		eliminar.setFont(new Font("Arial ", 1, 11));
		
		setCorrecta(new JCheckBox("Correcta"));
		setIncorrecta(new JCheckBox("Incorrecta"));
		
		this.add(titulo);
		this.add(encabezado);
		this.add(logo1);
		this.add(logo2);
		this.add(arbol);
		this.add(salir);
		this.add(inicio);
		this.add(volver);
		this.add(nombre);
		this.add(contenedor);
		this.add(scroll);
		contenedor.add(cancelar);
		
		contenedor.add(guardar);
		contenedor.add(aniadir);
		contenedor.add(contenedor3);
		contenedor.add(contenedor4);
		contenedor.add(combobox);
		
		contenedor3.add(campo_respuesta);
		contenedor3.add(respuesta);
		contenedor3.add(aniadirRespuesta);
		contenedor3.add(numeroPregunta);
		contenedor3.add(numPregunta);
		contenedor3.add(correcta);
		contenedor3.add(incorrecta);
		
		contenedor4.add(eliminar);
		contenedor4.add(numeroPregunta1);
		contenedor4.add(numPregunta1);
		
		/*titulo*/
		layout.putConstraint(SpringLayout.WEST, titulo, 90, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, titulo, 130, SpringLayout.NORTH, this);
		
		/*nombre*/
		layout.putConstraint(SpringLayout.WEST, nombre, 90, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, nombre, 160, SpringLayout.NORTH, this);
		
		/*encabezado*/
		layout.putConstraint(SpringLayout.WEST, encabezado, 410, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, encabezado, 15, SpringLayout.NORTH, this);
		
		/*arbol encabezado*/
		layout.putConstraint(SpringLayout.WEST, arbol, 350,SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, arbol, 8, SpringLayout.NORTH, this);
		
		/*logo1*/
		layout.putConstraint(SpringLayout.WEST, logo1, 70, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, logo1, 10, SpringLayout.NORTH, this);
		
		/*logo2*/
		layout.putConstraint(SpringLayout.WEST, logo2, 870, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, logo2, 10, SpringLayout.NORTH, this);
		
		/*boton salir*/
		layout.putConstraint(SpringLayout.EAST, salir, -110, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, salir, 150, SpringLayout.WEST, this);
		
		/*boton inicio*/
		layout.putConstraint(SpringLayout.EAST, inicio, -220, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, inicio, 150, SpringLayout.WEST, this);
		
		/*boton volver*/
		layout.putConstraint(SpringLayout.WEST, volver, 580, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, volver, 150, SpringLayout.NORTH, this);
		
		/*boton guardar*/
		layout2.putConstraint(SpringLayout.WEST, guardar, 680, SpringLayout.WEST, contenedor);
		layout2.putConstraint(SpringLayout.NORTH, guardar, 15, SpringLayout.NORTH, contenedor);
		
		/*boton aniadir*/
		layout2.putConstraint(SpringLayout.WEST, aniadir, 300, SpringLayout.WEST, contenedor);
		layout2.putConstraint(SpringLayout.NORTH, aniadir, 5, SpringLayout.NORTH, contenedor);
		
		/*combobox*/
		layout2.putConstraint(SpringLayout.WEST, combobox, 10, SpringLayout.WEST, contenedor);
		layout2.putConstraint(SpringLayout.NORTH, combobox, 5, SpringLayout.NORTH, contenedor);
		
		/*separador*/
		layout.putConstraint(SpringLayout.NORTH, separador, 150, SpringLayout.NORTH, this);
		
		/*contenedor*/
		layout.putConstraint(SpringLayout.WEST, contenedor, 90, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, contenedor, 50, SpringLayout.NORTH, nombre);
		
		/*contenedor2*/
		layout.putConstraint(SpringLayout.WEST, scroll, 90, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scroll, 5, SpringLayout.SOUTH, contenedor);
		
		/*contenedor3*/
		layout2.putConstraint(SpringLayout.WEST, contenedor4, 10, SpringLayout.WEST, contenedor);
		layout2.putConstraint(SpringLayout.NORTH, contenedor4, 40, SpringLayout.NORTH, contenedor);
		
		/*respuesta*/
		layout4.putConstraint(SpringLayout.WEST, respuesta, 5, SpringLayout.WEST, contenedor3);
		layout4.putConstraint(SpringLayout.NORTH, respuesta, 5, SpringLayout.NORTH, contenedor3);
		
		/*campo_respuesta*/
		layout4.putConstraint(SpringLayout.WEST, campo_respuesta, 5, SpringLayout.EAST, respuesta);
		layout4.putConstraint(SpringLayout.NORTH, campo_respuesta, 5, SpringLayout.NORTH, contenedor3);
		
		/*numPregunta*/
		layout4.putConstraint(SpringLayout.WEST, numPregunta, 10, SpringLayout.EAST, campo_respuesta);
		layout4.putConstraint(SpringLayout.NORTH, numPregunta, 5, SpringLayout.NORTH, contenedor3);
		
		/*numPregunta*/
		layout4.putConstraint(SpringLayout.WEST, numeroPregunta, 10, SpringLayout.EAST, numPregunta);
		layout4.putConstraint(SpringLayout.NORTH, numeroPregunta, 5, SpringLayout.NORTH, contenedor3);
		
		/*aniadirRespuesta*/
		layout4.putConstraint(SpringLayout.WEST, aniadirRespuesta, 200, SpringLayout.EAST, numeroPregunta);
		layout4.putConstraint(SpringLayout.NORTH, aniadirRespuesta, 5, SpringLayout.NORTH, contenedor3);
		
		/*correcta*/
		layout4.putConstraint(SpringLayout.WEST, correcta, 20, SpringLayout.EAST, numeroPregunta);
		layout4.putConstraint(SpringLayout.NORTH, correcta, 5, SpringLayout.NORTH, contenedor3);
		
		/*incorrecta*/
		layout4.putConstraint(SpringLayout.WEST, incorrecta, 100, SpringLayout.EAST, numeroPregunta);
		layout4.putConstraint(SpringLayout.NORTH, incorrecta, 5, SpringLayout.NORTH, contenedor3);
		
		/*contenedor4*/
		layout2.putConstraint(SpringLayout.WEST, contenedor3, 10, SpringLayout.WEST, contenedor);
		layout2.putConstraint(SpringLayout.NORTH, contenedor3, 15, SpringLayout.SOUTH, contenedor4);
		
		/*numPregunta1*/
		layout5.putConstraint(SpringLayout.WEST, numPregunta1, 5, SpringLayout.WEST, contenedor4);
		layout5.putConstraint(SpringLayout.NORTH, numPregunta1, 5, SpringLayout.NORTH, contenedor4);
		
		/*numPregunta1*/
		layout5.putConstraint(SpringLayout.WEST, numeroPregunta1, 5, SpringLayout.EAST, numPregunta1);
		layout5.putConstraint(SpringLayout.NORTH, numeroPregunta1, 5, SpringLayout.NORTH, contenedor4);
		
		/*eliminar*/
		layout5.putConstraint(SpringLayout.WEST, eliminar, 5, SpringLayout.EAST, numeroPregunta1);
		layout5.putConstraint(SpringLayout.NORTH, eliminar, 5, SpringLayout.NORTH, contenedor4);
		
		/*peso*/
		layout2.putConstraint(SpringLayout.WEST, peso, 5, SpringLayout.EAST, contenedor4);
		layout2.putConstraint(SpringLayout.NORTH, peso, 15, SpringLayout.SOUTH, contenedor3);
		
		/*campo_peso*/
		layout2.putConstraint(SpringLayout.WEST, campo_peso, 5, SpringLayout.EAST, peso);
		layout2.putConstraint(SpringLayout.NORTH, campo_peso, 15, SpringLayout.SOUTH, contenedor3);
		
		/*cancelar*/
		layout2.putConstraint(SpringLayout.WEST, cancelar, 680, SpringLayout.WEST, contenedor);
		layout2.putConstraint(SpringLayout.NORTH, cancelar, 45, SpringLayout.NORTH, contenedor);
		
		/*Contenedor2*/
		
	}	
	
	public void setControlador(ActionListener c){
		salir.addActionListener(c);
		inicio.addActionListener(c);
		guardar.addActionListener(c);
		volver.addActionListener(c);
		aniadir.addActionListener(c);
		aniadirRespuesta.addActionListener(c);
	}
	
	public void addVistaPregunta(VistaPregunta pregunta){
		vistaPreguntas.add(pregunta);
	}
	
	public JLabel getTitulo(){
		return this.titulo;
	}
	
	public JLabel getEncabezado(){
		return this.encabezado;
	}
	
	public JLabel getLogo1(){
		return this.logo1;
	}
	
	public JLabel getLogo2(){
		return this.logo2;
	}
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JLabel getArbol() {
		return arbol;
	}

	public JButton getSalir() {
		return salir;
	}

	public JLabel getNombre() {
		return nombre;
	}

	public void setNombre(String n) {
		nombre.setText(n);
	}

	public JButton getInicio() {
		return inicio;
	}

	public JButton getVolver() {
		return volver;
	}
	
	public JComboBox<String> getCombobox() {
		return combobox;
	}
	
	public JFormattedTextField getNumeroPregunta(){
		return numeroPregunta;
	}
	
	public JFormattedTextField getNumeroPregunta1(){
		return numeroPregunta1;
	}

	public JPanel getContenedor2() {
		return contenedor2;
	}

	public ArrayList<VistaPregunta> getVistaPreguntas() {
		return vistaPreguntas;
	}
	
	public JTextField getRespuesta(){
		return campo_respuesta;
	}

	public JCheckBox getIncorrecta() {
		return incorrecta;
	}

	public void setIncorrecta(JCheckBox incorrecta) {
		this.incorrecta = incorrecta;
	}

	public JCheckBox getCorrecta() {
		return correcta;
	}

	public void setCorrecta(JCheckBox correcta) {
		this.correcta = correcta;
	}

	public JTextField getCampo_respuesta() {
		return campo_respuesta;
	}

	public void setCampo_respuesta(JTextField campo_respuesta) {
		this.campo_respuesta = campo_respuesta;
	}

	public JFormattedTextField getCampo_peso() {
		return campo_peso;
	}

	public void setCampo_peso(JFormattedTextField campo_peso) {
		this.campo_peso = campo_peso;
	}
	
	
	
}