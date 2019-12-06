package interfaz;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Clase que define la vista del menu de una asignatura de profesor
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero 
 */
public class VistaAsignaturaProf extends JPanel {
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
	
	private JButton crear;
	private JButton salir;
	private JButton inicio;
	private JButton volver;
	
	private JTextField campo_crear;
	
	private DefaultListModel<String> lista;
	private JList<String> lista2;
	private JScrollPane scroll;
	
	private JLabel temas;
	private JButton ir;
	
	
	private JCheckBox visibilidad;
	
	private JButton estudiantes;
	private JButton estadisticas;
	
	private JLabel visibilidad_eti;
	private JCheckBox visibilidad2;
	private JLabel modificar_vis;
	private JCheckBox invisible;
	
	public VistaAsignaturaProf() {
		this.setBackground(Color.decode("#b0f373"));
		this.setPreferredSize(new Dimension(1050, 750));
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		Dimension dim = new Dimension(90, 35);
		Dimension dim2 = new Dimension(75, 20);
		
		lista = new DefaultListModel<String>();
		lista2 = new JList<String>(lista);
		scroll = new JScrollPane(lista2);
		scroll.setPreferredSize(new Dimension(250, 280));
		temas = new JLabel ("Temas");
		temas.setFont(new Font("Gabriola", Font.PLAIN, 20));
		
		logo1 = new JLabel(new ImageIcon("Logo.png"));
		logo2 = new JLabel(new ImageIcon("Logo copia.png"));
		t_arbol = new JLabel(new ImageIcon("T_arbol.png"));
		
		encabezado = new JLabel("ree Academy");
		encabezado.setFont(new Font("Gabriola", Font.PLAIN, 70));
		arbol = new JLabel(new ImageIcon("arbol.png"));
		
		titulo = new JLabel("<<ASIGNATURA PROFESOR>>");
		
		nombre = new JLabel("Nombre asignatura");
		nombre.setFont(new Font("Gabriola", Font.PLAIN, 24));
		
		fin1 = new JLabel("reeAcademy 2017");
		fin1.setFont(new Font("Helvetica", Font.BOLD, 12));
		
		solicitud = new JLabel("Crear Tema");
		solicitud.setFont(new Font("Gabriola", Font.PLAIN, 22));
		campo_crear = new JTextField(15);
		crear = new JButton("Crear");
		crear.setPreferredSize(dim2);
		
		salir = new JButton("Salir");
		salir.setPreferredSize(dim);
		
		inicio = new JButton("Inicio");
		inicio.setPreferredSize(dim);
		
		volver = new JButton("Volver");
		volver.setPreferredSize(dim);
		
		ir = new JButton("Ir");
		ir.setPreferredSize(dim2);
		
		visibilidad = new JCheckBox("Visibilidad");
		
		estudiantes = new JButton("Estudiantes matriculados");
		estudiantes.setPreferredSize(new Dimension(200, 35));
		
		estadisticas = new JButton("Ver estadisticas");
		estadisticas.setPreferredSize(new Dimension(200, 35));
		
		visibilidad_eti = new JLabel("Estado: ");
		visibilidad2 = new JCheckBox("Visibilidad");
		invisible = new JCheckBox("Inivisible");
		modificar_vis = new JLabel("Modificar visibilidad");
		
		this.add(titulo);
		this.add(solicitud);
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
		this.add(temas);
		this.add(campo_crear);
		this.add(crear);
		this.add(ir);
		this.add(visibilidad);
		this.add(estudiantes);
		this.add(estadisticas);
		this.add(visibilidad_eti);
		this.add(visibilidad2);
		this.add(invisible);
		this.add(modificar_vis);
		
		
		/*scroll*/
		layout.putConstraint(SpringLayout.WEST, scroll, 100, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scroll, 250, SpringLayout.NORTH, this);
		
		/*temas*/
		layout.putConstraint(SpringLayout.WEST, temas, 100, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, temas, 210, SpringLayout.NORTH, this);
		
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
		layout.putConstraint(SpringLayout.WEST, volver, 90, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, volver, 570, SpringLayout.NORTH, this);
		
		/*solicitud*/
		layout.putConstraint(SpringLayout.WEST, solicitud, 400, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, solicitud, 250, SpringLayout.NORTH, this);
		
		/*campo crear tema*/
		layout.putConstraint(SpringLayout.WEST, campo_crear, 400, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, campo_crear, 300, SpringLayout.NORTH, this);
		
		/*boton crear tema*/
		layout.putConstraint(SpringLayout.WEST, crear, 405, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, crear, 360, SpringLayout.NORTH, this);	

		/*ir*/
		layout.putConstraint(SpringLayout.WEST, ir, 190, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, ir, 540, SpringLayout.NORTH, this);
		
		/*visibilidad*/
		layout.putConstraint(SpringLayout.WEST, visibilidad, 405, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, visibilidad, 330, SpringLayout.NORTH, this);
		
		/*estudiantes*/
		layout.putConstraint(SpringLayout.WEST, estudiantes, 400, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, estudiantes, 400, SpringLayout.NORTH, this);
		
		/*estadisticas*/
		layout.putConstraint(SpringLayout.WEST, estadisticas, 400, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, estadisticas, 450, SpringLayout.NORTH, this);
		
		/*visibilidad_eti*/
		layout.putConstraint(SpringLayout.WEST, visibilidad_eti, 700, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, visibilidad_eti, 300, SpringLayout.NORTH, this);
		
		/*modificar_vis*/
		layout.putConstraint(SpringLayout.WEST, modificar_vis, 700, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, modificar_vis, 350, SpringLayout.NORTH, this);
		
		/*visibilidad2*/
		layout.putConstraint(SpringLayout.WEST, visibilidad2, 700, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, visibilidad2, 370, SpringLayout.NORTH, this);
		
		/*invisible*/
		layout.putConstraint(SpringLayout.WEST, invisible, 700, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, invisible, 390, SpringLayout.NORTH, this);
		
	}	
	
	/**
	 * Funcion que agrega un actionlistener a los botones que se utilizaran en esta clase
	 * @param c actionlistener que se le asignara a los botones
	 */
	public void setControlador(ActionListener c){
		salir.addActionListener(c);
		inicio.addActionListener(c);
		crear.addActionListener(c);
		volver.addActionListener(c);
		ir.addActionListener(c);
		estudiantes.addActionListener(c);
		estadisticas.addActionListener(c);
	}

	/**
	 * Funcion para poner a cero el JTextField
	 */
	public void clear () {
		campo_crear.setText("");
		this.updateUI();	
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
	 * Funcion que obtiene el boton de solicitud
	 * @return solicitud solicitud
	 */
	public JLabel getSolicitud() {
		return this.solicitud;
	}
	
	/**
	 * Funcion que obtiene el campo crear
	 * @return campo_crear campo_crear
	 */
	public JTextField getCampoCrear() {
		return this.campo_crear;
	}
	
	/**
	 * Funcion que obtiene el boton de crear
	 * @return crear crear
	 */
	public JButton getCrear() {
		return this.crear;
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
	 * Funcion que obtiene el campo de crear
	 * @return campo_crear campo_crear
	 */
	public JTextField getCampo_crear() {
		return campo_crear;
	}

	/**
	 * Funcion que obtiene el nombre
	 * @return nombre nombre
	 */
	public JLabel getNombre() {
		return nombre;
	}

	/**
	 * Funcion que establece el nombre de la vista
	 * @param n string que se le establecera como nombre a la vista
	 */
	public void setNombre(String n) {
		nombre.setText(n);
	}

	/**
	 * Funcion que obtiene el scrol
	 * @return scroll scroll
	 */
	public JScrollPane getScroll() {
		return scroll;
	}

	/**
	 * Funcion que obtiene el boton de inicio
	 * @return inicio inicio
	 */
	public JButton getInicio() {
		return inicio;
	}

	/**
	 * Funcion que obtiene el boton de volver
	 * @return volver volver
	 */
	public JButton getVolver() {
		return volver;
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
	 * Funcion que obtiene el tema
	 * @return temas temas
	 */
	public JLabel getTemas() {
		return temas;
	}

	/**
	 * Funcion que obtiene el checkbox de visibilidad
	 * @return visibilidad visibilidad
	 */
	public JCheckBox getVisibilidad() {
		return visibilidad;
	}
	
	/**
	 * Funcion que obtiene si la visibilidad esta seleccionada o no
	 * @return true or false
	 */
	public boolean getVisibilidad_(){
		return visibilidad.isSelected();
	}

	public JButton getIr() {
		return ir;
	}

	public JButton getEstudiantes() {
		return estudiantes;
	}

	public JButton getEstadisticas() {
		return estadisticas;
	}

	public JLabel getVisibilidad_eti() {
		return visibilidad_eti;
	}
	
	public void setVisibilidad_eti(String n) {
		visibilidad_eti.setText(n);
	}

	public JCheckBox getVisibilidad2() {
		return visibilidad2;
	}
	
	public boolean getVisibilidad2_() {
		return visibilidad2.isSelected();
	}

	public JLabel getModificar_vis() {
		return modificar_vis;
	}

	public JCheckBox getInvisible() {
		return invisible;
	}
	
	public boolean getInvisible_() {
		return invisible.isSelected();
	}
	
}