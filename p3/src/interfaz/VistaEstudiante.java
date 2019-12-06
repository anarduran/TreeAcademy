package interfaz;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Clase que define la vista del menu inicial de estudiantes
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero 
 */
public class VistaEstudiante extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel titulo;
	private JLabel encabezado;
	private JLabel fin1;
	private JLabel logo1;
	private JLabel logo2;
	private JLabel t_arbol;
	private JLabel solicitud;
	private JLabel arbol;
	private JButton salir;
	
	private JPanel contenedor;

	private JButton boton_solicitar;
	
	private DefaultListModel<String> lista;
	private JList<String> lista2;
	private JScrollPane scroll;
	
	private DefaultListModel<String> lista_asignaturas;
	private JList<String> lista_asignaturas2;
	private JScrollPane scroll2;
	private JLabel mis_asignaturas;
	
	private JButton ir;
	
	public VistaEstudiante() {
		this.setBackground(Color.decode("#b0f373"));
		this.setPreferredSize(new Dimension(1050, 750));
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		Dimension dim = new Dimension(90, 35);
		Dimension dim2 = new Dimension(75, 20);
		
		lista = new DefaultListModel<String>();
		lista2 = new JList<String>(lista);
		scroll = new JScrollPane(lista2);
		lista2.setPreferredSize(new Dimension(300, 200));
		lista2.setSelectionMode((ListSelectionModel.SINGLE_SELECTION));
		
		lista_asignaturas = new DefaultListModel<String>();
		lista_asignaturas2 = new JList<String>(lista_asignaturas);
		scroll2 = new JScrollPane(lista_asignaturas2);
		lista_asignaturas2.setPreferredSize(new Dimension(300, 200));
		mis_asignaturas = new JLabel("Mis Asignaturas");
		mis_asignaturas.setFont(new Font("Gabriola", Font.PLAIN, 20));
		lista_asignaturas2.setSelectionMode((ListSelectionModel.SINGLE_SELECTION));
		
		contenedor = new JPanel();
		SpringLayout layout2 = new SpringLayout();
		contenedor.setLayout(layout2);
		
		contenedor.setBackground(Color.decode("#FFFFFF"));
		contenedor.setPreferredSize(new Dimension(300, 200)); //cambie esto
		contenedor.setBorder(BorderFactory.createLineBorder(Color.decode("#45BC3C"),1));
		
		logo1 = new JLabel(new ImageIcon("Logo.png"));
		logo2 = new JLabel(new ImageIcon("Logo copia.png"));
		t_arbol = new JLabel(new ImageIcon("T_arbol.png"));
		
		encabezado = new JLabel("ree Academy");
		encabezado.setFont(new Font("Gabriola", Font.PLAIN, 70));
		arbol = new JLabel(new ImageIcon("arbol.png"));
		
		titulo = new JLabel("<<PAGINA INICIO ESTUDIANTES>>");
		
		fin1 = new JLabel("reeAcademy 2017");
		fin1.setFont(new Font("Helvetica", Font.BOLD, 12));
		
		solicitud = new JLabel("Solicitar Asignatura");
		solicitud.setFont(new Font("Gabriola", Font.PLAIN, 24));
		
		salir = new JButton("Salir");
		salir.setPreferredSize(dim);
		
		boton_solicitar = new JButton("Solicitar");
		boton_solicitar.setPreferredSize(dim2);
		
		ir = new JButton("Ir");
		ir.setPreferredSize(dim);
		
		//this.add(contenedor);
		this.add(titulo);
		this.add(solicitud);
		this.add(encabezado);
		this.add(fin1);
		this.add(logo1);
		this.add(logo2);
		this.add(t_arbol);
		this.add(arbol);
		this.add(salir);
		this.add(boton_solicitar);
		this.add(scroll);
		this.add(scroll2);
		this.add(mis_asignaturas);
		this.add(ir);
		
		
		/*contenedor*/
		//layout.putConstraint(SpringLayout.WEST, contenedor, 110, SpringLayout.WEST, this);
		//layout.putConstraint(SpringLayout.NORTH, contenedor, 275, SpringLayout.NORTH, this);
		
		/*titulo*/
		layout.putConstraint(SpringLayout.WEST, titulo, 90, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, titulo, 155, SpringLayout.NORTH, this);
		
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
		
		/*solicitud*/
		layout.putConstraint(SpringLayout.WEST, solicitud, 770, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, solicitud, 230, SpringLayout.NORTH, this);
		
		/*boton salir*/
		layout.putConstraint(SpringLayout.EAST, salir, -110, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, salir, 150, SpringLayout.WEST, this);
		
		/*boton solicitar*/
		layout.putConstraint(SpringLayout.EAST, boton_solicitar, -195, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, boton_solicitar, 430, SpringLayout.NORTH, this);
		
		/*tabla*/
		layout.putConstraint(SpringLayout.EAST, scroll, -100, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, scroll, 270, SpringLayout.NORTH, this);
		
		/*lista asignaturas*/
		layout.putConstraint(SpringLayout.WEST, scroll2, 100, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scroll2, 270, SpringLayout.NORTH, this);
		
		/*mis asignaturas*/
		layout.putConstraint(SpringLayout.WEST, mis_asignaturas, 100, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, mis_asignaturas, 230, SpringLayout.NORTH, this);
		
		/*boton ir*/
		layout.putConstraint(SpringLayout.WEST, ir, 190, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, ir, 430, SpringLayout.NORTH, this);
		
	}
	
	/**
	 * Funcion que agrega un actionlistener a los botones que se utilizaran en esta clase
	 * @param c actionlistener que se le asignara a los botones
	 */
	public void setControlador(ActionListener c){
		salir.addActionListener(c);
		boton_solicitar.addActionListener(c);
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
	 * Funcion que establece el titulo de la vista
	 * @param n string que establecera el titulo de la vista
	 */
	public void setTitulo(String n) {
		titulo.setText(n);
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
	 * Funcion que obtiene el contenedor
	 * @return contenedor contenedor
	 */
	public JPanel getContenedor() {
		return contenedor;
	}

	/**
	 * Funcion que obtiene el boton_solicitar
	 * @return boton_solicitar boton_solicitar
	 */
	public JButton getBoton_solicitar() {
		return boton_solicitar;
	}

	/**
	 * Funcion que obtiene la lista
	 * @return lista lista
	 */
	public DefaultListModel<String> getLista() {
		return lista;
	}

	/**
	 * Funcion que obtiene la lista2
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
	 * Funcion que obtiene la lista_asignaturas
	 * @return lista_asignaturas lista_asignaturas
	 */
	public DefaultListModel<String> getLista_asignaturas() {
		return lista_asignaturas;
	}

	/**
	 * Funcion que obtiene la lista_asignaturas2
	 * @return lista_asignaturas2 lista_asignaturas2
	 */
	public JList<String> getLista_asignaturas2() {
		return lista_asignaturas2;
	}

	/**
	 * Funcion que obtiene el scroll2
	 * @return scroll2 scroll2
	 */
	public JScrollPane getScroll2() {
		return scroll2;
	}

	/**
	 * Funcion que obtiene mis_asignaturas
	 * @return mis_asignaturas mis_asignaturas
	 */
	public JLabel getMis_asignaturas() {
		return mis_asignaturas;
	}
	
}