package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Clase que define la vista de los estudiantes matriculados en una asignatura
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero 
 */
public class VistaEstudiantesMatriculados extends JPanel{
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
	
	private DefaultListModel<String> lista_estudiantes;
	private JList<String> lista_estudiantes2;
	private JScrollPane scroll_estudiantes;
	private JLabel estudiantes;
	
	private DefaultListModel<String> lista_bloqueados;
	private JList<String> lista_bloqueados2;
	private JScrollPane scroll_bloqueados;
	private JLabel bloqueados;
	
	private JButton bloqueado;
	private JButton readmitido;
	
	
	public VistaEstudiantesMatriculados(){
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
		
		titulo = new JLabel("<<ESTUDIANTES MATRICULADOS>>");
		
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
		
		lista_estudiantes = new DefaultListModel<String>();
		lista_estudiantes2 = new JList<String>(lista_estudiantes);
		scroll_estudiantes = new JScrollPane(lista_estudiantes2);
		scroll_estudiantes.setPreferredSize(new Dimension(250, 280));
		estudiantes = new JLabel("Estudiantes matriculados");
		estudiantes.setFont(new Font("Gabriola", Font.PLAIN, 20));
		
		lista_bloqueados = new DefaultListModel<String>();
		lista_bloqueados2 = new JList<String>(lista_bloqueados);
		scroll_bloqueados = new JScrollPane(lista_bloqueados2);
		scroll_bloqueados.setPreferredSize(new Dimension(250, 280));
		bloqueados = new JLabel("Estudiantes bloqueados");
		bloqueados.setFont(new Font("Gabriola", Font.PLAIN, 20));
		
		bloqueado = new JButton("Bloquear");
		readmitido = new JButton("Readmitir");
		
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
		this.add(scroll_bloqueados);
		this.add(scroll_estudiantes);
		this.add(estudiantes);
		this.add(bloqueados);
		this.add(bloqueado);
		this.add(readmitido);
		
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
		
		/*scroll_estudiantes*/
		layout.putConstraint(SpringLayout.WEST, scroll_estudiantes, 200, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scroll_estudiantes, 250, SpringLayout.NORTH, this);
		
		/*estudiantes*/
		layout.putConstraint(SpringLayout.WEST, estudiantes, 200, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, estudiantes, 210, SpringLayout.NORTH, this);
		
		/*scroll_bloqueados*/
		layout.putConstraint(SpringLayout.WEST, scroll_bloqueados, 595, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scroll_bloqueados, 250, SpringLayout.NORTH, this);
		
		/*bloqueados*/
		layout.putConstraint(SpringLayout.WEST, bloqueados, 595, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, bloqueados, 210, SpringLayout.NORTH, this);
		
		/*boton bloqueado*/
		layout.putConstraint(SpringLayout.WEST, bloqueado, 470, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, bloqueado, 350, SpringLayout.WEST, this);
		
		/*boton readmitido*/
		layout.putConstraint(SpringLayout.WEST, readmitido, 470, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, readmitido, 400, SpringLayout.WEST, this);
		
	}
	
	/**
	 * Funcion que agrega un actionlistener a los botones que se utilizaran en esta clase
	 * @param c actionlistener que se le asignara a los botones
	 */
	public void setControlador(ActionListener c){
		salir.addActionListener(c);
		inicio.addActionListener(c);
		volver.addActionListener(c);
		bloqueado.addActionListener(c);
		readmitido.addActionListener(c);
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
	 * Funcion que obtiene el arbol, etiqueta
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
	 * Funcion que establece el nombre la vista
	 * @param n string 
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
	 * Funcion que obtiene la lista de estudiantes
	 * @return lista_estudiantes lista_estudiantes
	 */
	public DefaultListModel<String> getLista_estudiantes() {
		return lista_estudiantes;
	}

	/**
	 * Funcion que obtiene la lista de estudiantes 2
	 * @return lista_estudiantes2 lista_estudiantes2
	 */
	public JList<String> getLista_estudiantes2() {
		return lista_estudiantes2;
	}

	/**
	 * Funcion que obtiene el scroll de la lista de estudiantes
	 * @return scroll_estudiantes scroll_estudiantes
	 */
	public JScrollPane getScroll_estudiantes() {
		return scroll_estudiantes;
	}

	/**
	 * Funcion que obtiene la etiqueta de estudiantes 
	 * @return estudiantes estudiantes
	 */
	public JLabel getEstudiantes() {
		return estudiantes;
	}

	/**
	 * Funcion que obtiene la lista de bloqueados
	 * @return lista_bloqueados lista_bloqueados
	 */
	public DefaultListModel<String> getLista_bloqueados() {
		return lista_bloqueados;
	}

	/**
	 * Funcion que obtiene la lista de bloqueados 2
	 * @return lista_bloqueados2 lista_bloqueados2
	 */
	public JList<String> getLista_bloqueados2() {
		return lista_bloqueados2;
	}

	/**
	 * Funcion que obtiene el scroll de la lista de bloqueados
	 * @return scroll_bloqueados scroll_bloqueados
	 */
	public JScrollPane getScroll_bloqueados() {
		return scroll_bloqueados;
	}

	/**
	 * Funcion que obtiene la etiqueta de bloqueados
	 * @return bloqueados bloqueados
	 */
	public JLabel getBloqueados() {
		return bloqueados;
	}

	/**
	 * Funcion que obtiene el boton de bloquear
	 * @return bloqueado bloqueado
	 */
	public JButton getBloqueado() {
		return bloqueado;
	}

	/**
	 * Funcion que obtiene el boton de readmitir 
	 * @return readmitido readmitido
	 */
	public JButton getReadmitido() {
		return readmitido;
	}
	
	
}
