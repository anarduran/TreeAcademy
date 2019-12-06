package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Clase que define la vista del apunte que visualizara el profesor
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero 
 */
public class VistaApunteProf extends JPanel{
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
	
	private JTextArea apunte;
	private JScrollPane scroll;
	private JLabel apunte_etiqueta;
	private JButton guardar;
	
	private JLabel visibilidad_eti;
	private JCheckBox visibilidad2;
	private JLabel modificar_vis;
	private JCheckBox invisible;
	
	public VistaApunteProf(){
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
		
		titulo = new JLabel("<<APUNTE PROFESOR>>");
		
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
		
		apunte = new JTextArea();
		apunte.setEditable(true);
		scroll = new JScrollPane(apunte);
		scroll.setPreferredSize(new Dimension(600,315));
		apunte_etiqueta = new JLabel ("Escribe el apunte: ");
		apunte_etiqueta .setFont(new Font("Helvetica", Font.PLAIN, 18));
		guardar = new JButton("Guardar");
		guardar.setPreferredSize(dim);
		
		visibilidad_eti = new JLabel("Estado: ");
		visibilidad2 = new JCheckBox("Visibilidad");
		invisible = new JCheckBox("Inivisible");
		modificar_vis = new JLabel("Modificar visibilidad");
		
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
		this.add(apunte_etiqueta);
		this.add(guardar);
		this.add(visibilidad_eti);
		this.add(visibilidad2);
		this.add(invisible);
		this.add(modificar_vis);
		
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
		
		/*scroll*/
		layout.putConstraint(SpringLayout.WEST, scroll, 100, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scroll, 230, SpringLayout.NORTH, this);
		
		/*guardar*/
		layout.putConstraint(SpringLayout.WEST, guardar, 750, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, guardar, 400, SpringLayout.NORTH, this);
		
		/*apunte_etiqueta*/
		layout.putConstraint(SpringLayout.WEST, apunte_etiqueta, 100, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, apunte_etiqueta, 205, SpringLayout.NORTH, this);
		
		/*visibilidad_eti*/
		layout.putConstraint(SpringLayout.WEST, visibilidad_eti, 750, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, visibilidad_eti, 250, SpringLayout.NORTH, this);
		
		/*modificar_vis*/
		layout.putConstraint(SpringLayout.WEST, modificar_vis, 750, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, modificar_vis, 300, SpringLayout.NORTH, this);
		
		/*visibilidad2*/
		layout.putConstraint(SpringLayout.WEST, visibilidad2, 750, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, visibilidad2, 320, SpringLayout.NORTH, this);
		
		/*invisible*/
		layout.putConstraint(SpringLayout.WEST, invisible, 750, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, invisible, 340, SpringLayout.NORTH, this);
	}
	
	/**
	 * Funcion que agrega un actionlistener a los botones que se utilizaran en esta clase
	 * @param c actionlistener que se le asignara a los botones
	 */
	public void setControlador(ActionListener c){
		salir.addActionListener(c);
		inicio.addActionListener(c);
		volver.addActionListener(c);
		guardar.addActionListener(c);
	}

	/**
	 * Funcion para poner a cero el JTextField
	 */
	public void clear () {
		apunte.setText("");
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

	/**
	 * Funcion que obtiene el apunte
	 * @return apunte apunte
	 */
	public JTextArea getApunte() {
		return apunte;
	}

	/**
	 * Funcion que obtiene el scroll
	 * @return scroll scroll
	 */
	public JScrollPane getScroll() {
		return scroll;
	}

	/**
	 * Funcion que obtiene la etiqueta del apunte
	 * @return apunte_etiqueta etiqueta del apunte
	 */
	public JLabel getApunte_etiqueta() {
		return apunte_etiqueta;
	}

	/**
	 * Funcion que obtiene el boton de guardar
	 * @return guardar guardar
	 */
	public JButton getGuardar() {
		return guardar;
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

