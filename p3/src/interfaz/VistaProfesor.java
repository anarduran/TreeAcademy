package interfaz;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Clase que define la vista del menu inicial de profesor
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero 
 */
public class VistaProfesor extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel titulo;
	private JLabel encabezado;
	private JLabel fin1;
	private JLabel logo1;
	private JLabel logo2;
	private JLabel t_arbol;
	private JLabel arbol;
	private JLabel solicitud;
	
	private JButton crear;
	private JButton salir;
	
	private JTextField campo_crear;
	
	private JPanel contenedor;
	
	private DefaultListModel<String> lista;
	private JList<String> lista2;
	private JLabel asignaturas_disponibles;
	private JScrollPane scroll;
	private JButton ir;
	
	private DefaultListModel<String> lista_matriculas;
	private JList<String> lista_matriculas2;
	private JScrollPane scroll2;
	private JLabel matriculas;
	private JButton aceptar;
	private JButton rechazar;
	
	private JCheckBox visibilidad;
	
	public VistaProfesor() {
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
		asignaturas_disponibles = new JLabel("Asignaturas creadas");
		ir = new JButton("Ir");
		ir.setPreferredSize(dim2);
	
		lista_matriculas = new DefaultListModel<String>();
		lista_matriculas2 = new JList<String>(lista_matriculas);
		lista_matriculas2.setPreferredSize(new Dimension(300, 200));
		scroll2 = new JScrollPane(lista_matriculas2);
		matriculas = new JLabel("Solicitudes");
		//matriculas.setFont(new Font("Helvetica", Font.BOLD, 12));
		aceptar = new JButton("Aceptar");
		aceptar.setPreferredSize(dim2);
		rechazar = new JButton("Rechazar");
		rechazar.setPreferredSize(dim2);
		
		contenedor = new JPanel();
		SpringLayout layout2 = new SpringLayout();
		contenedor.setLayout(layout2);
		
		contenedor.setBackground(Color.decode("#FFFFFF"));
		contenedor.setPreferredSize(new Dimension(250, 250));
		contenedor.setBorder(BorderFactory.createLineBorder(Color.decode("#45BC3C"),1));
		logo1 = new JLabel(new ImageIcon("Logo.png"));
		logo2 = new JLabel(new ImageIcon("Logo copia.png"));
		t_arbol = new JLabel(new ImageIcon("T_arbol.png"));
		
		encabezado = new JLabel("ree Academy");
		encabezado.setFont(new Font("Gabriola", Font.PLAIN, 70));
		arbol = new JLabel(new ImageIcon("arbol.png"));
		
		titulo = new JLabel("<<PAGINA INICIO PROFESORES>>");
		
		fin1 = new JLabel("reeAcademy 2017");
		fin1.setFont(new Font("Helvetica", Font.BOLD, 12));
		
		solicitud = new JLabel("Crear Asignatura");
		solicitud.setFont(new Font("Gabriola", Font.PLAIN, 24));
		campo_crear = new JTextField(20);
		crear = new JButton("Crear");
		crear.setPreferredSize(dim2);
		
		salir = new JButton("Salir");
		salir.setPreferredSize(dim);
		
		visibilidad = new JCheckBox("Visibilidad");
		
		//AGREGUE ESTO
		this.add(contenedor);
		this.add(titulo);
		contenedor.add(solicitud);
		this.add(encabezado);
		this.add(fin1);
		this.add(logo1);
		this.add(logo2);
		this.add(t_arbol);
		this.add(arbol);
		this.add(salir);
		contenedor.add(campo_crear);
		contenedor.add(crear);
		contenedor.add(visibilidad);
		this.add(scroll);
		this.add(asignaturas_disponibles);
		this.add(scroll2);
		this.add(aceptar);
		this.add(rechazar);
		this.add(matriculas);
		this.add(ir);
		
		
		/*contenedor*/
		layout.putConstraint(SpringLayout.WEST, contenedor, 690, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, contenedor, 200, SpringLayout.NORTH, this);
		
		/*titulo*/
		layout.putConstraint(SpringLayout.WEST, titulo, 90, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, titulo, 135, SpringLayout.NORTH, this);
		
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
		
		/*solicitud*/
		layout2.putConstraint(SpringLayout.WEST, solicitud, 65, SpringLayout.WEST, contenedor);
		layout2.putConstraint(SpringLayout.NORTH, solicitud, 10, SpringLayout.NORTH, contenedor);
		
		/*campo crear*/
		layout2.putConstraint(SpringLayout.WEST, campo_crear,-50, SpringLayout.WEST, solicitud);
		layout2.putConstraint(SpringLayout.NORTH, campo_crear, 60, SpringLayout.NORTH, solicitud);
		
		/*visibilidad*/
		layout2.putConstraint(SpringLayout.WEST, visibilidad, 60, SpringLayout.WEST, campo_crear);
		layout2.putConstraint(SpringLayout.NORTH, visibilidad, 45, SpringLayout.NORTH, campo_crear);
		
		/*boton crear*/
		layout2.putConstraint(SpringLayout.WEST, crear, 60, SpringLayout.WEST, campo_crear);
		layout2.putConstraint(SpringLayout.NORTH, crear, 80, SpringLayout.NORTH, campo_crear);
		
		/*lista*/
		layout.putConstraint(SpringLayout.WEST, scroll, 105, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scroll, 200, SpringLayout.NORTH, this);
		
		/*asignaturas disponibles*/
		layout.putConstraint(SpringLayout.WEST, asignaturas_disponibles, 170, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, asignaturas_disponibles, 175, SpringLayout.NORTH, this);
		
		/*lista matriculas*/
		layout.putConstraint(SpringLayout.WEST, scroll2, 105, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scroll2, 400, SpringLayout.NORTH, this);
		
		/*matriculas*/
		layout.putConstraint(SpringLayout.WEST, matriculas, 200, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, matriculas, 370, SpringLayout.NORTH, this);
		
		/*aceptar*/
		layout.putConstraint(SpringLayout.WEST, aceptar, 430, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, aceptar, 450, SpringLayout.NORTH, this);
		
		/*rechazar*/
		layout.putConstraint(SpringLayout.WEST, rechazar, 430, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, rechazar, 490, SpringLayout.NORTH, this);
		
		/*ir*/
		layout.putConstraint(SpringLayout.WEST, ir, 430, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, ir, 250, SpringLayout.NORTH, this);
		
		
	}	
	
	
	public void setControlador(ActionListener c){
		salir.addActionListener(c);
		aceptar.addActionListener(c);
		rechazar.addActionListener(c);
		ir.addActionListener(c);
		crear.addActionListener(c);
	}
		
	public void clear () {
		campo_crear.setText("");
	}
	
	public JLabel getTitulo(){
		return this.titulo;
	}
	
	public JLabel getEncabezado(){
		return this.encabezado;
	}
	
	public JLabel getFin1(){
		return this.fin1;
	}
	
	public JLabel getLogo1(){
		return this.logo1;
	}
	
	public JLabel getLogo2(){
		return this.logo2;
	}
	
	public JLabel getTArbol(){
		return this.t_arbol;
	}

	public JLabel getSolicitud() {
		return this.solicitud;
	}
	
	public JTextField getCampoCrear() {
		return this.campo_crear;
	}
	
	public JButton getCrear() {
		return this.crear;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JLabel getT_arbol() {
		return t_arbol;
	}

	public JLabel getArbol() {
		return arbol;
	}

	public JButton getSalir() {
		return salir;
	}

	public JTextField getCampo_crear() {
		return campo_crear;
	}

	public JPanel getContenedor() {
		return contenedor;
	}

	public DefaultListModel<String> getLista() {
		return lista;
	}

	public JList<String> getLista2() {
		return lista2;
	}

	public JLabel getAsignaturas_disponibles() {
		return asignaturas_disponibles;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public DefaultListModel<String> getLista_matriculas() {
		return lista_matriculas;
	}

	public JList<String> getLista_matriculas2() {
		return lista_matriculas2;
	}

	public JScrollPane getScroll2() {
		return scroll2;
	}
	
	public JLabel getMatriculas() {
		return matriculas;
	}

	public JButton getAceptar() {
		return aceptar;
	}

	public JButton getRechazar() {
		return rechazar;
	}

	public JButton getIr() {
		return ir;
	}

	public JCheckBox getVisibilidad() {
		return visibilidad;
	}
	
	public boolean getVisibilidad_seleccionada(){
		return visibilidad.isSelected();
	}
}