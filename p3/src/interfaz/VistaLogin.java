package interfaz;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Clase que define la vista para el login
 * 
 * @author Ana Rodriguez Duran
 * @author Candelaria Orellana Pero 
 */
public class VistaLogin extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel titulo;
	private JLabel nombre;
	private JLabel contrasenia;
	private JLabel encabezado;
	private JLabel fin1;
	private JLabel logo1;
	private JLabel logo2;
	private JLabel t_arbol;
	private JLabel arbol;
	
	private JPanel contenedor;
	
	private JTextField campo_nombre;
	private JPasswordField campo_password;
	
	private JButton aceptar;
	
	public VistaLogin() {
		this.setBackground(Color.decode("#b0f373"));
		this.setPreferredSize(new Dimension(1050, 750));
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		Dimension dim = new Dimension(85, 30);
		
		contenedor = new JPanel();
		SpringLayout layout2 = new SpringLayout();
		contenedor.setLayout(layout2);
		
		contenedor.setBackground(Color.decode("#FFFFFF"));
		contenedor.setPreferredSize(new Dimension(400, 320));
		contenedor.setBorder(BorderFactory.createLineBorder(Color.decode("#45BC3C"),2));
		
		logo1 = new JLabel(new ImageIcon("Logo.png"));
		logo2 = new JLabel(new ImageIcon("Logo copia.png"));
		t_arbol = new JLabel(new ImageIcon("T_arbol.png"));
		
		encabezado = new JLabel("ree Academy");
		encabezado.setFont(new Font("Gabriola", Font.PLAIN, 70));
		arbol = new JLabel(new ImageIcon("arbol.png"));
		
		fin1 = new JLabel("reeAcademy 2017");
		fin1.setFont(new Font("Helvetica", Font.BOLD, 12));
		
		titulo = new JLabel("     · Iniciar sesion ·");
		titulo.setFont(new Font("Calibri Light", Font.ITALIC, 24));
		titulo.setForeground(Color.decode("#45BC3C"));
		
		nombre = new JLabel("Usuario");
		nombre.setFont(new Font("Gabriola", Font.BOLD, 18));
		contrasenia = new JLabel("Contraseña");
		contrasenia.setFont(new Font("Gabriola", Font.BOLD, 18));
		
		campo_nombre = new JTextField(18);
		campo_password = new JPasswordField(18);
		
		aceptar = new JButton("Entrar");
		aceptar.setPreferredSize(dim);
		
		contenedor.add(titulo);
		contenedor.add(nombre);
		contenedor.add(campo_nombre);
		contenedor.add(contrasenia);
		contenedor.add(campo_password);
		contenedor.add(aceptar);
		this.add(encabezado);
		this.add(fin1);
		this.add(logo1);
		this.add(logo2);
		this.add(t_arbol);
		this.add(arbol);
		this.add(contenedor);
		
		/*contenedor*/
		layout.putConstraint(SpringLayout.WEST, contenedor, 340, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, contenedor, 180, SpringLayout.NORTH, this);
		
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

		/*titulo*/
		layout2.putConstraint(SpringLayout.WEST, titulo, 100, SpringLayout.WEST, contenedor);
		layout2.putConstraint(SpringLayout.NORTH, titulo, 10, SpringLayout.NORTH, contenedor);
		
		/*nombre*/
		layout2.putConstraint(SpringLayout.WEST, nombre, 0, SpringLayout.WEST, titulo);
		layout2.putConstraint(SpringLayout.NORTH, nombre, 15, SpringLayout.SOUTH, titulo);
		
		/*camponombre*/
		layout2.putConstraint(SpringLayout.WEST, campo_nombre, 0, SpringLayout.WEST, nombre);
		layout2.putConstraint(SpringLayout.NORTH, campo_nombre, 10, SpringLayout.SOUTH, nombre);
		
		/*password*/
		layout2.putConstraint(SpringLayout.WEST, contrasenia, 0, SpringLayout.WEST, campo_nombre);
		layout2.putConstraint(SpringLayout.NORTH, contrasenia, 20, SpringLayout.SOUTH, campo_nombre);
		
		/*campopass*/
		layout2.putConstraint(SpringLayout.WEST, campo_password, 0, SpringLayout.WEST, contrasenia);
		layout2.putConstraint(SpringLayout.NORTH, campo_password, 10, SpringLayout.SOUTH, contrasenia);
		
		/*aceptar*/
		layout2.putConstraint(SpringLayout.WEST, aceptar, 50, SpringLayout.WEST, campo_password);
		layout2.putConstraint(SpringLayout.NORTH, aceptar, 30, SpringLayout.SOUTH, campo_password);
		
		/*fin1*/
		layout.putConstraint(SpringLayout.WEST, fin1, 490, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, fin1, 590, SpringLayout.NORTH, this);
		
		/*t_arbol*/
		layout.putConstraint(SpringLayout.WEST, t_arbol, -28, SpringLayout.WEST, fin1);
		layout.putConstraint(SpringLayout.SOUTH, t_arbol, 7, SpringLayout.SOUTH, fin1);		
	}
	
	public void clear () {
		campo_nombre.setText("");
		campo_password.setText("");
		updateUI();	
	}
	
	/*En cada vista tiene que haber un setControlador para saber que hacer en cada accion*/
	public void setControlador(ActionListener c) {
		aceptar.addActionListener(c);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JLabel getTitulo() {
		return this.titulo;
	}
	
	public JLabel getNombre() {
		return this.nombre;
	}

	public JLabel getContrasenia() {
		return this.contrasenia;
	}

	public JTextField getCampo_nombre() {
		return this.campo_nombre;
	}

	public JPasswordField getCampo_password() {
		return this.campo_password;
	}

	public JButton getAceptar() {
		return this.aceptar;
	}
	
	public JLabel getEtiqueta(){
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
}