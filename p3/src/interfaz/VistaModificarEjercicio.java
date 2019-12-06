package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Clase que define la vista de modificar un ejercicio
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero 
 */
public class VistaModificarEjercicio extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private JLabel encabezado;
	private JLabel fin1;
	private JLabel logo1;
	private JLabel logo2;
	private JLabel t_arbol;
	private JLabel arbol;
	private JLabel nombre;
	private JButton salir;
	private JButton inicio;
	private JButton volver;
	
	private JLabel enunciado;
	private JTextField campo_enunciado;
	private JCheckBox visibilidad;
	private JLabel fecha_ini;
	private JTextField campo_fecha_ini;
	private JLabel fecha_fin;
	private JTextField campo_fecha_fin;
	private JCheckBox orden;
	private JCheckBox desordenadas;
	private JLabel nota;
	private JTextField campo_nota;
	private JLabel ponderacion;
	private JTextField campo_ponderacion;
	
	private JButton crear;
	private JButton agregar;
	
	private DefaultListModel<String> lista_preg;
	private JList<String> lista_preg2;
	private JScrollPane scroll_preg;
	private JLabel preguntas;
	private JButton eliminar;
	private JCheckBox invisible;
	
	public VistaModificarEjercicio(){
		this.setBackground(Color.decode("#b0f373"));
		this.setPreferredSize(new Dimension(1050, 750));
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		Dimension dim = new Dimension(90, 35);
		
		logo1 = new JLabel(new ImageIcon("Logo.png"));
		logo2 = new JLabel(new ImageIcon("Logo copia.png"));
		t_arbol = new JLabel(new ImageIcon("T_arbol.png"));
		
		encabezado = new JLabel("ree Academy");
		encabezado.setFont(new Font("Gabriola", Font.PLAIN, 70));
		arbol = new JLabel(new ImageIcon("arbol.png"));
		
		titulo = new JLabel("<<CREAR EJERCICIO>>");
		
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
		
		enunciado = new JLabel ("Enunciado");
		campo_enunciado = new JTextField(18);
		fecha_ini = new JLabel("Fecha de inicio (DD/MM/AAAA)");
		campo_fecha_ini = new JTextField (8);
		fecha_fin = new JLabel ("Fecha de fin (DD/MM/AAAA)");
		campo_fecha_fin = new JTextField (8);
		visibilidad = new JCheckBox("Visibilidad");
		orden = new JCheckBox("Ordenadas");
		desordenadas = new JCheckBox ("Desordenadas");
		nota = new JLabel ("Nota");
		campo_nota = new JTextField(5);
		ponderacion = new JLabel("Ponderacion");
		campo_ponderacion = new JTextField(5);
		
		crear = new JButton("Crear ejercicio");
		crear.setPreferredSize(new Dimension(150, 20));
		agregar = new JButton("Agregar pregunta");
		agregar.setPreferredSize(new Dimension(150, 20));
		
		lista_preg = new DefaultListModel<String>();
		lista_preg2 = new JList<String>(lista_preg);
		scroll_preg = new JScrollPane(lista_preg2);
		scroll_preg.setPreferredSize(new Dimension(300, 150));
		preguntas = new JLabel("Preguntas");
		preguntas.setFont(new Font("Gabriola", Font.PLAIN, 20));
		eliminar = new JButton("Eliminar");
		eliminar.setPreferredSize(new Dimension(75, 20));
		invisible = new JCheckBox("Invisible");
		
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
		this.add(enunciado);
		this.add(campo_enunciado);
		this.add(fecha_ini);
		this.add(campo_fecha_ini);
		this.add(fecha_fin);
		this.add(campo_fecha_fin);
		this.add(visibilidad);
		this.add(orden);
		this.add(desordenadas);
		this.add(nota);
		this.add(campo_nota);
		this.add(ponderacion);
		this.add(campo_ponderacion);
		this.add(crear);
		this.add(agregar);
		this.add(scroll_preg);
		this.add(preguntas);
		this.add(eliminar);
		this.add(invisible);
		
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
		
		/*enunciado*/
		layout.putConstraint(SpringLayout.WEST, enunciado, 200, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, enunciado, 250, SpringLayout.NORTH, this);
		
		/*campo_enunciado*/
		layout.putConstraint(SpringLayout.WEST, campo_enunciado, 270, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, campo_enunciado, 245, SpringLayout.NORTH, this);
		
		/*ponderacion*/
		layout.putConstraint(SpringLayout.WEST, ponderacion, 190, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, ponderacion, 285, SpringLayout.NORTH, this);
		
		/*campo_ponderacion*/
		layout.putConstraint(SpringLayout.WEST, campo_ponderacion, 270, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, campo_ponderacion, 280, SpringLayout.NORTH, this);
		
		/*visibilidad*/
		layout.putConstraint(SpringLayout.WEST, visibilidad, 200, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, visibilidad, 320, SpringLayout.NORTH, this);
		
		/*orden*/
		layout.putConstraint(SpringLayout.WEST, orden, 200, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, orden, 350, SpringLayout.NORTH, this);
		
		/*desordenadas*/
		layout.putConstraint(SpringLayout.WEST, desordenadas, 300, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, desordenadas, 350, SpringLayout.NORTH, this);
		
		/*fecha_ini*/
		layout.putConstraint(SpringLayout.WEST, fecha_ini, 200, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, fecha_ini, 380, SpringLayout.NORTH, this);
		
		/*campo_fecha_ini*/
		layout.putConstraint(SpringLayout.WEST, campo_fecha_ini, 400, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, campo_fecha_ini, 380, SpringLayout.NORTH, this);
		
		/*fecha_fin*/
		layout.putConstraint(SpringLayout.WEST, fecha_fin, 200, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, fecha_fin, 410, SpringLayout.NORTH, this);
		
		/*campo_fecha_fin*/
		layout.putConstraint(SpringLayout.WEST, campo_fecha_fin, 400, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, campo_fecha_fin, 410, SpringLayout.NORTH, this);
		
		/*crear*/
		layout.putConstraint(SpringLayout.WEST, crear, 300, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, crear, 470, SpringLayout.NORTH, this);
		
		/*agregar*/
		layout.putConstraint(SpringLayout.WEST, agregar, 720, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, agregar, 450, SpringLayout.NORTH, this);
		
		/*scroll_preg*/
		layout.putConstraint(SpringLayout.WEST, scroll_preg, 630, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scroll_preg, 250, SpringLayout.NORTH, this);
		
		/*preguntas*/
		layout.putConstraint(SpringLayout.WEST, preguntas, 735, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, preguntas, 210, SpringLayout.NORTH, this);
		
		/*eliminar*/
		layout.putConstraint(SpringLayout.WEST, eliminar, 750, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, eliminar, 420, SpringLayout.NORTH, this);
		
		/*invisible*/
		layout.putConstraint(SpringLayout.WEST, invisible, 300, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, invisible, 320, SpringLayout.NORTH, this);
	}
	

	
	/**
	 * Funcion que agrega un actionlistener a los botones que se utilizaran en esta clase
	 * @param c actionlistener que se le asignara a los botones
	 */
	public void setControlador(ActionListener c){
		salir.addActionListener(c);
		inicio.addActionListener(c);
		volver.addActionListener(c);
		crear.addActionListener(c);
		agregar.addActionListener(c);
		eliminar.addActionListener(c);
	}
	
	/**
	 * Funcion para poner a cero el JTextField
	 */
	public void clear () {
		campo_enunciado.setText("");
		campo_fecha_ini.setText("");
		campo_fecha_fin.setText("");
		campo_ponderacion.setText("");
		this.updateUI();	
	}

	/**
	 * Funcion que obtiene el serialVersionUID
	 * @return serialVersionUId serialVersionUID
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Funcion que obtiene el titulo de la vista
	 * @return titulo titulo de la vista
	 */
	public JLabel getTitulo() {
		return titulo;
	}

	/**
	 * Funcion que obtiene el encabezado de la vista
	 * @return encabezado encabezado
	 */
	public JLabel getEncabezado() {
		return encabezado;
	}

	/**
	 * Funcion que obtiene el fin1
	 * @return fin1 fin1
	 */
	public JLabel getFin1() {
		return fin1;
	}

	/**
	 * Funcion que obtiene el logo1
	 * @return logo1 logo1
	 */
	public JLabel getLogo1() {
		return logo1;
	}

	/**
	 * Funcion que obtiene el logo2
	 * @return logo2 logo2
	 */
	public JLabel getLogo2() {
		return logo2;
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
	 * Funcion que obtiene el boton salir
	 * @return salir salir
	 */
	public JButton getSalir() {
		return salir;
	}

	/**
	 * Funcion que obtiene el boton de inicio
	 * @return inicio inicio
	 */
	public JButton getInicio() {
		return inicio;
	}

	/**
	 * Funcion que obtien el boton de volver
	 * @return volver volver
	 */
	public JButton getVolver() {
		return volver;
	}

	public JLabel getEnunciado() {
		return enunciado;
	}

	public JTextField getCampo_enunciado() {
		return campo_enunciado;
	}

	public JCheckBox getVisibilidad() {
		return visibilidad;
	}
	
	public boolean getVisibilidad_() {
		return visibilidad.isSelected();
	}

	public JLabel getFecha_ini() {
		return fecha_ini;
	}

	public JTextField getCampo_fecha_ini() {
		return campo_fecha_ini;
	}

	public JLabel getFecha_fin() {
		return fecha_fin;
	}

	public JTextField getCampo_fecha_fin() {
		return campo_fecha_fin;
	}

	public JCheckBox getOrden() {
		return orden;
	}
	
	public boolean getOrden_() {
		return orden.isSelected();
	}

	public JCheckBox getDesordenadas() {
		return desordenadas;
	}
	
	public boolean getDesordenadas_(){
		return desordenadas.isSelected();
	}

	public JLabel getNota() {
		return nota;
	}

	public JTextField getCampo_nota() {
		return campo_nota;
	}

	public JLabel getPonderacion() {
		return ponderacion;
	}

	public JTextField getCampo_ponderacion() {
		return campo_ponderacion;
	}

	public JButton getCrear() {
		return crear;
	}

	public JButton getAgregar() {
		return agregar;
	}

	public DefaultListModel<String> getLista_preg() {
		return lista_preg;
	}

	public JList<String> getLista_preg2() {
		return lista_preg2;
	}

	public JCheckBox getInvisible() {
		return invisible;
	}
	
	public boolean getInvisible_() {
		return invisible.isSelected();
	}

}
