package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que define la vista de las estadisticas
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero 
 */
public class VistaEstadisticas extends JPanel{
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
	
	private DefaultTableModel tabla_alumno;
	private JTable tabla_alumno2;
	private JScrollPane scroll_alumno;
	private JLabel alumno;
	
	private DefaultTableModel tabla_estadistica;
	private JTable tabla_estadistica2;
	private JScrollPane scroll_estadistica;
	private JLabel estadistica;
	
	
	public VistaEstadisticas(){
		this.setBackground(Color.decode("#b0f373"));
		this.setPreferredSize(new Dimension(1050, 750));
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		Dimension dim = new Dimension(90, 35);
		Dimension dim2 = new Dimension(250, 280);
		
		logo1 = new JLabel(new ImageIcon("Logo.png"));
		logo2 = new JLabel(new ImageIcon("Logo copia.png"));
		t_arbol = new JLabel(new ImageIcon("T_arbol.png"));
		
		encabezado = new JLabel("ree Academy");
		encabezado.setFont(new Font("Gabriola", Font.PLAIN, 70));
		arbol = new JLabel(new ImageIcon("arbol.png"));
		
		titulo = new JLabel("<<ESTADISTIDICAS>>");
		
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
		
		tabla_alumno = new DefaultTableModel();
		tabla_alumno2 = new JTable(tabla_alumno);
		scroll_alumno = new JScrollPane(tabla_alumno2);
		scroll_alumno.setPreferredSize(dim2);
		tabla_alumno.addColumn("           Alumnos");
		tabla_alumno.addColumn("        Nota media");
		alumno = new JLabel("Estudiantes matriculados");
		alumno.setFont(new Font("Gabriola", Font.PLAIN, 20));
		
		tabla_estadistica = new DefaultTableModel();
		tabla_estadistica2 = new JTable(tabla_estadistica);
		scroll_estadistica = new JScrollPane(tabla_estadistica2);
		scroll_estadistica.setPreferredSize(new Dimension(250, 80));
		tabla_estadistica.addColumn("        		 Estadistica");
		tabla_estadistica.addColumn("    %");
		estadistica = new JLabel("Estadisticas");
		estadistica.setFont(new Font("Gabriola", Font.PLAIN, 20));
		
		tabla_estadistica2.getColumnModel().getColumn(0).setPreferredWidth(600);
		
		
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
		this.add(scroll_alumno);
		this.add(alumno);
		this.add(scroll_estadistica);
		this.add(estadistica);
		
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
		
		/*scroll_alumno*/
		layout.putConstraint(SpringLayout.WEST, scroll_alumno, 200, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scroll_alumno, 250, SpringLayout.NORTH, this);
		
		/*alumno*/
		layout.putConstraint(SpringLayout.WEST, alumno, 200, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, alumno, 210, SpringLayout.NORTH, this);
		
		/*scroll_estadistica*/
		layout.putConstraint(SpringLayout.WEST, scroll_estadistica, 595, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scroll_estadistica, 250, SpringLayout.NORTH, this);
		
		/*estadistica*/
		layout.putConstraint(SpringLayout.WEST, estadistica, 595, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, estadistica, 210, SpringLayout.NORTH, this);
		
	}
	
	/**
	 * Funcion que agrega un actionlistener a los botones que se utilizaran en esta clase
	 * @param c actionlistener que se le asignara a los botones
	 */
	public void setControlador(ActionListener c){
		salir.addActionListener(c);
		inicio.addActionListener(c);
		volver.addActionListener(c);
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
	 * @param n string que se le establecera el nombre a la vista
	 */
	public void setNombre(String n) {
		nombre.setText(n);
	}

	/**
	 * Funcion que obtiene el boton de salir
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
	 * Funcion que obtiene el boton de volver
	 * @return volver volver
	 */
	public JButton getVolver() {
		return volver;
	}

	/**
	 * Funcion que obtiene la tabla de alumno
	 * @return tabla_alumno tabla_alumno
	 */
	public DefaultTableModel getTabla_alumno() {
		return tabla_alumno;
	}

	/**
	 * Funcion que obtiene la tabla_alumno2
	 * @return tabla_alumno2 tabla_alumno2
	 */
	public JTable getTabla_alumno2() {
		return tabla_alumno2;
	}

	/**
	 * Funcion que obtiene el scroll del alumno
	 * @return scroll_alumno scroll_alumno
	 */
	public JScrollPane getScroll_alumno() {
		return scroll_alumno;
	}

	/**
	 * Funcion que obtiene el alumno
	 * @return alumno alumno
	 */
	public JLabel getAlumno() {
		return alumno;
	}

	/**
	 * Funcion que obti la talbla estadisticas
	 * @return tabla_estadistica
	 */
	public DefaultTableModel getTabla_estadistica() {
		return tabla_estadistica;
	}

	/**
	 * Funcion que obtiene la tabla_estadisticas2
	 * @return tabla_estadistica2
	 */
	public JTable getTabla_estadistica2() {
		return tabla_estadistica2;
	}

	/**
	 * Funcion que obtiene el scroll de la tabla estadistica
	 * @return scroll_estadistica
	 */
	public JScrollPane getScroll_estadistica() {
		return scroll_estadistica;
	}

	/**
	 * Funcion que obtiene la etiqueta de estadisticas
	 * @return estadistica estadistica
	 */
	public JLabel getEstadistica() {
		return estadistica;
	}
	
	

}
