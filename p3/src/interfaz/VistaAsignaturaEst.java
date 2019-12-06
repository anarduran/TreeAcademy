package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;


import javax.swing.*;

/**
 * Clase que define la vista del menu de una asignatura de un estudiante
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero 
 */
public class VistaAsignaturaEst extends JPanel{
	private static final long serialVersionUID = 1L;

	private JLabel titulo;
	private JLabel encabezado;
	private JLabel fin1;
	private JLabel logo1;
	private JLabel logo2;
	private JLabel t_arbol;
	private JLabel arbol;
	private JLabel solicitud;
	private JLabel nombre;
	private JButton salir;
	private JButton inicio;
	private JButton volver;
	
	private DefaultListModel<String> lista;
	private JList<String> lista2;
	private JScrollPane scroll;
	private JLabel temas;
	private JButton ir;
	private JButton ver_nota;
	
	public VistaAsignaturaEst(){
		this.setBackground(Color.decode("#b0f373"));
		this.setPreferredSize(new Dimension(1050, 750));
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		Dimension dim = new Dimension(90, 35);
		Dimension dim2 = new Dimension(250, 280);
		Dimension dim3 = new Dimension(150, 40);
		
		logo1 = new JLabel(new ImageIcon("Logo.png"));
		logo2 = new JLabel(new ImageIcon("Logo copia.png"));
		t_arbol = new JLabel(new ImageIcon("T_arbol.png"));
		
		encabezado = new JLabel("ree Academy");
		encabezado.setFont(new Font("Gabriola", Font.PLAIN, 70));
		arbol = new JLabel(new ImageIcon("arbol.png"));
		
		titulo = new JLabel("<<ASIGNATURA ESTUDIANTE>>");
		
		nombre = new JLabel("Nombre asignatura");
		nombre.setFont(new Font("Gabriola", Font.PLAIN, 24));
		
		fin1 = new JLabel("reeAcademy 2017");
		fin1.setFont(new Font("Helvetica", Font.BOLD, 12));
		
		salir = new JButton("Salir");
		salir.setPreferredSize(dim);
		
		inicio = new JButton("Inicio");
		inicio.setPreferredSize(dim);
		
		volver = new JButton("Volver");
		volver.setPreferredSize(dim);
		
		lista = new DefaultListModel<String>();
		lista2 = new JList<String>(lista);
		scroll = new JScrollPane(lista2);
		scroll.setPreferredSize(dim2);
		temas = new JLabel ("Temas");
		temas.setFont(new Font("Gabriola", Font.PLAIN, 20));
		ir = new JButton ("Acceder");
		ir.setPreferredSize(dim);
		ver_nota = new JButton ("Ver nota");
		ver_nota.setPreferredSize(dim3);
		
		this.add(titulo);
		this.add(encabezado);
		this.add(fin1);
		this.add(logo1);
		this.add(logo2);
		this.add(t_arbol);
		this.add(arbol);
		this.add(salir);
		this.add(inicio);
		this.add(volver);
		this.add(nombre);
		this.add(scroll);
		this.add(scroll);
		this.add(temas);
		this.add(ir);
		this.add(ver_nota);
		
		/*titulo*/
		layout.putConstraint(SpringLayout.WEST, titulo, 90, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, titulo, 130, SpringLayout.NORTH, this);
		
		/*Nombre*/
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
		
		/*fin1*/
		layout.putConstraint(SpringLayout.WEST, fin1, 500, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, fin1, 590, SpringLayout.NORTH, this);
		
		/*t_arbol*/
		layout.putConstraint(SpringLayout.WEST, t_arbol, -28, SpringLayout.WEST, fin1);
		layout.putConstraint(SpringLayout.SOUTH, t_arbol, 7, SpringLayout.SOUTH, fin1);
		
		/*boton salir*/
		layout.putConstraint(SpringLayout.EAST, salir, -110, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, salir, 150, SpringLayout.WEST, this);
		
		/*boton inicio*/
		layout.putConstraint(SpringLayout.EAST, inicio, -270, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, inicio, 150, SpringLayout.WEST, this);
		
		/*boton volver*/
		layout.putConstraint(SpringLayout.WEST, volver, 200, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, volver, 550, SpringLayout.NORTH, this);
		
		/*scroll*/
		layout.putConstraint(SpringLayout.WEST, scroll, 400, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scroll, 250, SpringLayout.NORTH, this);
		
		/*temas*/
		layout.putConstraint(SpringLayout.WEST, temas, 400, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, temas, 210, SpringLayout.NORTH, this);
		
		/*ir*/
		layout.putConstraint(SpringLayout.WEST, ir, 700, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, ir, 480, SpringLayout.NORTH, this);
		
		/*ver_notas*/
		layout.putConstraint(SpringLayout.WEST, ver_nota, 100, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, ver_nota, 250, SpringLayout.NORTH, this);
	}
	
	/**
	 * Funcion que agrega un actionlistener a los botones que se utilizaran en esta clase
	 * @param c actionlistener que se le asignara a los botones
	 */
	public void setControlador(ActionListener c){
		salir.addActionListener(c);
		inicio.addActionListener(c);
		volver.addActionListener(c);
		ir.addActionListener(c);
	}
	
	/**
	 * Funcion que obtiene el titulo de la vista
	 * @return titulo titulo de la vista
	 */
	public JLabel getTitulo(){
		return this.titulo;
	}
	
	/**
	 * Funcion que obtiene el encabezado de la vista
	 * @return encabezado encabezado
	 */
	public JLabel getEncabezado(){
		return this.encabezado;
	}
	
	/**
	 * Funcion que obtiene el fin1
	 * @return fin1 fin1
	 */
	public JLabel getFin1(){
		return this.fin1;
	}
	
	/**
	 * Funcion que obtiene el logo1
	 * @return logo1 logo1
	 */
	public JLabel getLogo1(){
		return this.logo1;
	}
	
	/**
	 * Funcion que obtiene el logo2
	 * @return logo2 logo2
	 */
	public JLabel getLogo2(){
		return this.logo2;
	}
	
	/**
	 * funcion que obtiene el t_arbol
	 * @return t_arbol t_arbol
	 */
	public JLabel getTArbol(){
		return this.t_arbol;
	}

	/**
	 * Funcion que obtiene el label de solicitud
	 * @return solicitud solicitud
	 */
	public JLabel getSolicitud() {
		return this.solicitud;
	}
		
	/**
	 * Funcion que obtiene el serialVersionUID
	 * @return serialVersionUId serialVersionUID
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * funcion que obtiene el t_arbol
	 * @return t_arbol t_arbol
	 */
	public JLabel getT_arbol() {
		return t_arbol;
	}

	/**
	 * Funcion que obtiene el arbol
	 * @return arbol arbol
	 */
	public JLabel getArbol() {
		return arbol;
	}

	/**
	 * Funcion que obtiene el boton de salir
	 * @return salir salir
	 */
	public JButton getSalir() {
		return salir;
	}

	/**
	 * Funcion que obtiene el nombre de la vista
	 * @return nombre nombre
	 */
	public JLabel getNombre() {
		return nombre;
	}

	/**
	 * Funcion que establece el nombre de la vista
	 * @param n string que establecera el nombre
	 */
	public void setNombre(String n) {
		nombre.setText(n);
	}

	/**
	 * Funcion que obtiene la lista
	 * @return lista lista
	 */
	public DefaultListModel<String> getLista() {
		return lista;
	}

	/**
	 * Funcion que obtiene la lista 2
	 * @return lista2 lista2
	 */
	public JList<String> getLista2() {
		return lista2;
	}

	/**
	 * Funcion que obtiene el scroll
	 * @return scroll scroll
	 */
	public JScrollPane getScroll() {
		return scroll;
	}
	
	/**
	 * Funcion que establece el titulo de la vista
	 * @param n string que se le establecera al titulo
	 */
	public void setTitulo(String n){
		titulo.setText(n);
	}
	
	
	
}
