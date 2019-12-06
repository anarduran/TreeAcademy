package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Clase que define la vista de un subtema de profesor
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero 
 */
public class VistaSubtemaProf extends JPanel{
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
	
	private DefaultListModel<String> lista_apun;
	private JList<String> lista_apun2;
	private JScrollPane scroll_apun;
	private JButton acceder_apun;
	private JButton eliminar_apun;
	private JLabel apunte;
	private JTextField campo_apunte;
	private JButton crear_apunte;
	private JLabel solicitud_apunte;
	private JCheckBox visibilidad_apun;
	
	private DefaultListModel<String> lista_ejer;
	private JList<String> lista_ejer2;
	private JScrollPane scroll_ejer;
	private JButton acceder_ejer;
	private JButton modificar_ejer;
	private JButton eliminar_ejer;
	private JLabel ejercicio;
	private JButton crear_ejercicio;
	
	private JLabel visibilidad_eti;
	private JCheckBox visibilidad2;
	private JLabel modificar_vis;
	private JCheckBox invisible;
	
	public VistaSubtemaProf(){
		this.setBackground(Color.decode("#b0f373"));
		this.setPreferredSize(new Dimension(1050, 750));
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		Dimension dim = new Dimension(90, 35);
		Dimension dim2 = new Dimension(150, 150);
		Dimension dim3 = new Dimension(110, 20);
		Dimension dim4 = new Dimension(130, 20);
		
		logo1 = new JLabel(new ImageIcon("Logo.png"));
		logo2 = new JLabel(new ImageIcon("Logo copia.png"));
		t_arbol = new JLabel(new ImageIcon("T_arbol.png"));
		
		encabezado = new JLabel("ree Academy");
		encabezado.setFont(new Font("Gabriola", Font.PLAIN, 70));
		arbol = new JLabel(new ImageIcon("arbol.png"));
		
		titulo = new JLabel("<<SUBTEMA PROFESOR>>");
		
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
		
		lista_apun = new DefaultListModel<String>();
		lista_apun2 = new JList<String>(lista_apun);
		scroll_apun = new JScrollPane(lista_apun2);
		scroll_apun.setPreferredSize(dim2);
		acceder_apun = new JButton("Acceder apunte");
		acceder_apun.setPreferredSize(dim3);
		eliminar_apun = new JButton("Eliminar apunte");
		eliminar_apun.setPreferredSize(dim3);
		apunte = new JLabel ("Apuntes");
		apunte.setFont(new Font("Gabriola", Font.PLAIN, 20));
		campo_apunte = new JTextField(10);
		crear_apunte = new JButton("Crear apunte");
		crear_apunte.setPreferredSize(dim3);
		solicitud_apunte = new JLabel("Crear apunte");
		solicitud_apunte.setFont(new Font("Gabriola", Font.PLAIN, 14));
		visibilidad_apun = new JCheckBox("Visbilidad");
		
		lista_ejer = new DefaultListModel<String>();
		lista_ejer2 = new JList<String>(lista_ejer);
		scroll_ejer = new JScrollPane(lista_ejer2);
		scroll_ejer.setPreferredSize(dim2);
		acceder_ejer = new JButton("Acceder ejercicio");
		acceder_ejer.setPreferredSize(dim4);
		modificar_ejer = new JButton("Modidicar ejercicio");
		modificar_ejer.setPreferredSize(dim4);
		eliminar_ejer = new JButton("Eliminar ejercicio");
		eliminar_ejer.setPreferredSize(dim4);
		ejercicio = new JLabel("Ejercicios");
		ejercicio.setFont(new Font("Gabriola", Font.PLAIN, 20));
		crear_ejercicio = new JButton("Crear ejercicio");
		crear_ejercicio.setPreferredSize(dim4);
		
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
		this.add(scroll_apun);
		this.add(acceder_apun);
		this.add(eliminar_apun);
		this.add(apunte);
		this.add(campo_apunte);
		this.add(crear_apunte);
		this.add(solicitud_apunte);
		this.add(visibilidad_apun);
		this.add(scroll_ejer);
		this.add(acceder_ejer);
		this.add(modificar_ejer);
		this.add(eliminar_ejer);
		this.add(ejercicio);
		this.add(crear_ejercicio);
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
		
		/*scroll_apun*/
		layout.putConstraint(SpringLayout.WEST, scroll_apun, 150, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scroll_apun, 250, SpringLayout.NORTH, this);
		
		/*acceder_apun*/
		layout.putConstraint(SpringLayout.WEST, acceder_apun, 190, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, acceder_apun, 530, SpringLayout.NORTH, this);
		
		/*apunte*/
		layout.putConstraint(SpringLayout.WEST, apunte, 170, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, apunte, 210, SpringLayout.NORTH, this);
		
		/*eliminar apunte*/
		layout.putConstraint(SpringLayout.WEST, eliminar_apun, 250, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, eliminar_apun, 490, SpringLayout.NORTH, this);
		
		/*solicitud_apunte*/
		layout.putConstraint(SpringLayout.WEST, solicitud_apunte, 160, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, solicitud_apunte, 405, SpringLayout.NORTH, this);
		
		/*campo_apunte*/
		layout.putConstraint(SpringLayout.WEST, campo_apunte, 150, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, campo_apunte, 425, SpringLayout.NORTH, this);
		
		/*crear_apunte*/
		layout.putConstraint(SpringLayout.WEST, crear_apunte, 120, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, crear_apunte, 490, SpringLayout.NORTH, this);
		
		/*visibilidad_apun*/
		layout.putConstraint(SpringLayout.WEST, visibilidad_apun, 160, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, visibilidad_apun, 450, SpringLayout.NORTH, this);
		
		/*scroll_ejer*/
		layout.putConstraint(SpringLayout.WEST, scroll_ejer, 480, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scroll_ejer, 250, SpringLayout.NORTH, this);
		
		/*acceder_ejer*/
		layout.putConstraint(SpringLayout.WEST, acceder_ejer, 440, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, acceder_ejer, 470, SpringLayout.NORTH, this);
		
		/*ejercicio*/
		layout.putConstraint(SpringLayout.WEST, ejercicio, 500, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, ejercicio, 210, SpringLayout.NORTH, this);
		
		/*modificar ejer*/
		layout.putConstraint(SpringLayout.WEST, modificar_ejer, 580, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, modificar_ejer, 425, SpringLayout.NORTH, this);
		
		/*eliminar ejer*/
		layout.putConstraint(SpringLayout.WEST, eliminar_ejer, 580, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, eliminar_ejer, 470, SpringLayout.NORTH, this);
		
		/*crear_ejercicio*/
		layout.putConstraint(SpringLayout.WEST, crear_ejercicio, 440, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, crear_ejercicio, 425, SpringLayout.NORTH, this);
		
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
	
	public void setControlador(ActionListener c){
		salir.addActionListener(c);
		inicio.addActionListener(c);
		volver.addActionListener(c);
		acceder_apun.addActionListener(c);
		eliminar_apun.addActionListener(c);
		crear_apunte.addActionListener(c);
		acceder_ejer.addActionListener(c);
		modificar_ejer.addActionListener(c);
		eliminar_ejer.addActionListener(c);
		crear_ejercicio.addActionListener(c);
	}

	public void clear () {
		campo_apunte.setText("");
		this.updateUI();	
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public JLabel getEncabezado() {
		return encabezado;
	}

	public JLabel getFin1() {
		return fin1;
	}

	public JLabel getLogo1() {
		return logo1;
	}

	public JLabel getLogo2() {
		return logo2;
	}

	public JLabel getT_arbol() {
		return t_arbol;
	}

	public JLabel getArbol() {
		return arbol;
	}

	public JLabel getNombre() {
		return nombre;
	}
	
	public void setNombre(String n) {
		nombre.setText(n);
	}

	public JButton getSalir() {
		return salir;
	}

	public JButton getInicio() {
		return inicio;
	}

	public JButton getVolver() {
		return volver;
	}

	public DefaultListModel<String> getLista_apun() {
		return lista_apun;
	}

	public JList<String> getLista_apun2() {
		return lista_apun2;
	}

	public JScrollPane getScroll_apun() {
		return scroll_apun;
	}

	public JButton getAcceder_apun() {
		return acceder_apun;
	}

	public JButton getEliminar_apun() {
		return eliminar_apun;
	}

	public JLabel getApunte() {
		return apunte;
	}

	public JTextField getCampo_apunte() {
		return campo_apunte;
	}

	public JButton getCrear_apunte() {
		return crear_apunte;
	}

	public JLabel getSolicitud_apunte() {
		return solicitud_apunte;
	}

	public DefaultListModel<String> getLista_ejer() {
		return lista_ejer;
	}

	public JList<String> getLista_ejer2() {
		return lista_ejer2;
	}

	public JScrollPane getScroll_ejer() {
		return scroll_ejer;
	}

	public JButton getAcceder_ejer() {
		return acceder_ejer;
	}

	public JButton getModificar_ejer() {
		return modificar_ejer;
	}

	public JButton getEliminar_ejer() {
		return eliminar_ejer;
	}

	public JLabel getEjercicio() {
		return ejercicio;
	}

	public JButton getCrear_ejercicio() {
		return crear_ejercicio;
	}

	public JCheckBox getVisibilidad_apun() {
		return visibilidad_apun;
	}
	
	public boolean getVisibilidadApun(){
		return visibilidad_apun.isSelected();
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
