package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Clase que define la vista de un tema de profesor
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero 
 */
public class VistaTemaProf extends JPanel{
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
	
	private DefaultListModel<String> lista_sub;
	private JList<String> lista_sub2;
	private JScrollPane scroll_sub;
	private JLabel subtemas;
	private JTextField campo_crear;
	private JButton crear;
	private JLabel solicitud;
	private JCheckBox visibilidad_sub;
	
	private DefaultListModel<String> lista_apun;
	private JList<String> lista_apun2;
	private JScrollPane scroll_apun;
	private JLabel apuntes;
	private JTextField campo_crear_apun;
	private JButton crear_apun;
	private JLabel solicitud_apun;
	private JCheckBox visibilidad_apun;
	private JButton eliminar_apun;
	
	private DefaultListModel<String> lista_ejer;
	private JList<String> lista_ejer2;
	private JScrollPane scroll_ejer;
	private JLabel ejercicio;
	private JButton crear_ejer;
	private JButton eliminar_ejer;
	private JButton modificar_ejer;
	
	private JButton ir;
	private JButton ir_apunte;
	private JButton ir_ejer;
	
	private JLabel visibilidad_eti;
	private JCheckBox visibilidad2;
	private JLabel modificar_vis;
	private JCheckBox invisible;

	public VistaTemaProf(){
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
		
		titulo = new JLabel("<<TEMA PROFESOR>>");
		
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
		
		lista_sub = new DefaultListModel<String>();
		lista_sub2 = new JList<String>(lista_sub);
		scroll_sub = new JScrollPane(lista_sub2);
		scroll_sub.setPreferredSize(dim2);
		
		subtemas = new JLabel ("Subtemas");
		subtemas.setFont(new Font("Gabriola", Font.PLAIN, 20));
		
		ir = new JButton("Acceder subtema");
		ir.setPreferredSize(dim4);
		
		ir_apunte = new JButton("Acceder apunte");
		ir_apunte.setPreferredSize(dim3);
		
		
		solicitud = new JLabel("Crear Subtema");
		solicitud.setFont(new Font("Gabriola", Font.PLAIN, 14));
		campo_crear = new JTextField(10);
		crear = new JButton("Crear subtema");
		crear.setPreferredSize(dim3);
		
		lista_apun = new DefaultListModel<String>();
		lista_apun2 = new JList<String>(lista_apun);
		scroll_apun = new JScrollPane(lista_apun2);
		scroll_apun.setPreferredSize(dim2);
		
		apuntes = new JLabel ("Apuntes");
		apuntes.setFont(new Font("Gabriola", Font.PLAIN, 20));
		
		solicitud_apun = new JLabel("Crear Apunte");
		solicitud_apun.setFont(new Font("Gabriola", Font.PLAIN, 14));
		campo_crear_apun = new JTextField(10);
		crear_apun = new JButton("Crear apunte");
		crear_apun.setPreferredSize(dim3);
		eliminar_apun = new JButton("Eliminar apunte");
		eliminar_apun.setPreferredSize(dim3);
		
		lista_ejer = new DefaultListModel<String>();
		lista_ejer2 = new JList<String>(lista_ejer);
		scroll_ejer = new JScrollPane(lista_ejer2);
		scroll_ejer.setPreferredSize(dim2);
		ejercicio = new JLabel("Ejercicios");
		ejercicio.setFont(new Font("Gabriola", Font.PLAIN, 20));
		crear_ejer = new JButton("Crear ejercicio");
		crear_ejer.setPreferredSize(dim3);
		ir_ejer = new JButton ("Acceder ejercicio");
		ir_ejer.setPreferredSize(dim4);
		eliminar_ejer = new JButton("Eliminar ejercicio");
		eliminar_ejer.setPreferredSize(dim4);
		modificar_ejer = new JButton("Modificar ejercicio");
		modificar_ejer.setPreferredSize(dim4);
		
		visibilidad_sub = new JCheckBox("Visibilidad");
		visibilidad_apun = new JCheckBox("Visibilidad");
		
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
		this.add(scroll_sub);
		this.add(subtemas);
		this.add(ir);
		this.add(solicitud);
		this.add(campo_crear);
		this.add(crear);
		this.add(scroll_apun);
		this.add(apuntes);
		this.add(solicitud_apun);
		this.add(campo_crear_apun);
		this.add(crear_apun);
		this.add(ir_apunte);
		this.add(eliminar_apun);
		this.add(scroll_ejer);
		this.add(crear_ejer);
		this.add(ejercicio);
		this.add(ir_ejer);
		this.add(visibilidad_apun);
		this.add(visibilidad_sub);
		this.add(eliminar_ejer);
		this.add(modificar_ejer);
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
		layout.putConstraint(SpringLayout.WEST, scroll_sub, 140, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scroll_sub, 250, SpringLayout.NORTH, this);
		
		/*temas*/
		layout.putConstraint(SpringLayout.WEST, subtemas, 160, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, subtemas, 210, SpringLayout.NORTH, this);
		
		/*ir*/
		layout.putConstraint(SpringLayout.WEST, ir, 160, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, ir, 530, SpringLayout.NORTH, this);
		
		/*solicitud*/
		layout.putConstraint(SpringLayout.WEST, solicitud, 160, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, solicitud, 415, SpringLayout.NORTH, this);
		
		/*campo crear tema*/
		layout.putConstraint(SpringLayout.WEST, campo_crear, 150, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, campo_crear, 435, SpringLayout.NORTH, this);
		
		/*boton crear tema*/
		layout.putConstraint(SpringLayout.WEST, crear, 160, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, crear, 490, SpringLayout.NORTH, this);
		
		/*scroll apunte*/
		layout.putConstraint(SpringLayout.WEST, scroll_apun, 410, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scroll_apun, 250, SpringLayout.NORTH, this);
		
		/*apuntes*/
		layout.putConstraint(SpringLayout.WEST, apuntes, 430, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, apuntes, 210, SpringLayout.NORTH, this);
		
		/*solicitud_apun*/
		layout.putConstraint(SpringLayout.WEST, solicitud_apun, 430, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, solicitud_apun, 415, SpringLayout.NORTH, this);
		
		/*campo_crear_apun*/
		layout.putConstraint(SpringLayout.WEST, campo_crear_apun, 420, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, campo_crear_apun, 435, SpringLayout.NORTH, this);
		
		/*crear_apun*/
		layout.putConstraint(SpringLayout.WEST, crear_apun, 385, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, crear_apun, 490, SpringLayout.NORTH, this);
		
		/*ir_apunte*/
		layout.putConstraint(SpringLayout.WEST, ir_apunte, 450, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, ir_apunte, 530, SpringLayout.NORTH, this);
		
		/*eliminar_apun*/
		layout.putConstraint(SpringLayout.WEST, eliminar_apun, 500, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, eliminar_apun, 490, SpringLayout.NORTH, this);
		
		/*scroll_ejer*/
		layout.putConstraint(SpringLayout.WEST, scroll_ejer, 710, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scroll_ejer, 250, SpringLayout.NORTH, this);
		
		/*ejercicio*/
		layout.putConstraint(SpringLayout.WEST, ejercicio, 710, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, ejercicio, 210, SpringLayout.NORTH, this);
		
		/*crear_ejer*/
		layout.putConstraint(SpringLayout.WEST, crear_ejer, 680, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, crear_ejer, 450, SpringLayout.NORTH, this);
		
		/*ir_ejer*/
		layout.putConstraint(SpringLayout.WEST, ir_ejer, 680, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, ir_ejer, 490, SpringLayout.NORTH, this);
		
		/*eliminar_ejer*/
		layout.putConstraint(SpringLayout.WEST, eliminar_ejer, 800, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, eliminar_ejer, 450, SpringLayout.NORTH, this);
		
		/*visibilidad_sub*/
		layout.putConstraint(SpringLayout.WEST, visibilidad_sub, 160, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, visibilidad_sub, 459, SpringLayout.NORTH, this);
		
		/*visibilidad_apun*/
		layout.putConstraint(SpringLayout.WEST, visibilidad_apun, 430, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, visibilidad_apun, 459, SpringLayout.NORTH, this);
		
		/*modificar_ejer*/
		layout.putConstraint(SpringLayout.WEST, modificar_ejer, 820, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, modificar_ejer, 490, SpringLayout.NORTH, this);
		
		/*visibilidad_eti*/
		layout.putConstraint(SpringLayout.WEST, visibilidad_eti, 450, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, visibilidad_eti, 160, SpringLayout.NORTH, this);
		
		/*modificar_vis*/
		layout.putConstraint(SpringLayout.WEST, modificar_vis, 700, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, modificar_vis, 520, SpringLayout.NORTH, this);
		
		/*visibilidad2*/
		layout.putConstraint(SpringLayout.WEST, visibilidad2, 700, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, visibilidad2, 540, SpringLayout.NORTH, this);
		
		/*invisible*/
		layout.putConstraint(SpringLayout.WEST, invisible, 700, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, invisible, 560, SpringLayout.NORTH, this);
	}
	
	public void setControlador(ActionListener c){
		salir.addActionListener(c);
		inicio.addActionListener(c);
		crear.addActionListener(c);
		crear_apun.addActionListener(c);
		volver.addActionListener(c);
		ir.addActionListener(c);
		ir_apunte.addActionListener(c);
		crear_ejer.addActionListener(c);
		ir_ejer.addActionListener(c);
		eliminar_apun.addActionListener(c);
		eliminar_ejer.addActionListener(c);
		modificar_ejer.addActionListener(c);
	}

	public void clear () {
		campo_crear.setText("");
		campo_crear_apun.setText("");
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

	public JLabel getSolicitud() {
		return solicitud;
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

	public DefaultListModel<String> getLista_sub() {
		return lista_sub;
	}

	public JList<String> getLista_sub2() {
		return lista_sub2;
	}

	public JScrollPane getScroll_sub() {
		return scroll_sub;
	}

	public JLabel getSubtemas() {
		return subtemas;
	}

	public JTextField getCampo_crear() {
		return campo_crear;
	}

	public JButton getCrear() {
		return crear;
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

	public JLabel getApuntes() {
		return apuntes;
	}

	public JTextField getCampo_crear_apun() {
		return campo_crear_apun;
	}

	public JButton getCrear_apun() {
		return crear_apun;
	}

	public JLabel getSolicitud_apun() {
		return solicitud_apun;
	}

	public JButton getIr() {
		return ir;
	}

	public JButton getIr_apunte() {
		return ir_apunte;
	}

	public boolean getVisibilidad_sub() {
		return visibilidad_sub.isSelected();
	}

	public boolean getVisibilidad_apun() {
		return visibilidad_apun.isSelected();
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

	public JLabel getEjercicio() {
		return ejercicio;
	}

	public JButton getCrear_ejer() {
		return crear_ejer;
	}
	
	public JCheckBox getVisibilidadApun() {
		return visibilidad_apun;
	}
	
	public JCheckBox getVisibilidadSub() {
		return visibilidad_sub;
	}

	public JButton getIr_ejer() {
		return ir_ejer;
	}

	public JButton getEliminar_apun() {
		return eliminar_apun;
	}

	public JButton getEliminar_ejer() {
		return eliminar_ejer;
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
