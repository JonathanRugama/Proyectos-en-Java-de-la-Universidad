import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class JModificar extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtDNI;
	private JTextField txtFechaNacimiento;
	private JTextField txtNacionalidad;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public JModificar(String nombre,String edad, String dni, String fechaNacimiento, String nacionalidad, NodoJugadores aModificar, JTextArea txtMostrar, HashTablePaises lista, String clavePais, String posicionJugador, String claveJugador, String posicionPais) {
		setTitle("MODIFICAR DATOS DE JUGADOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Modificar datos de jugador:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 247, 267);
		contentPane.add(panel);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(10, 31, 56, 14);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setText(nombre);
		txtNombre.setColumns(10);
		txtNombre.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtNombre.setBounds(113, 31, 86, 20);
		panel.add(txtNombre);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(10, 68, 46, 14);
		panel.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setText(edad);
		txtEdad.setColumns(10);
		txtEdad.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtEdad.setBounds(112, 67, 86, 20);
		panel.add(txtEdad);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(10, 105, 46, 14);
		panel.add(lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.setText(dni);
		txtDNI.setColumns(10);
		txtDNI.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtDNI.setBounds(111, 102, 86, 20);
		panel.add(txtDNI);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento: ");
		lblFechaNacimiento.setBounds(10, 144, 96, 14);
		panel.add(lblFechaNacimiento);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setText(fechaNacimiento);
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtFechaNacimiento.setBounds(112, 138, 86, 20);
		panel.add(txtFechaNacimiento);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setBounds(10, 183, 96, 14);
		panel.add(lblNacionalidad);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setText(nacionalidad);
		txtNacionalidad.setColumns(10);
		txtNacionalidad.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtNacionalidad.setBounds(111, 174, 86, 20);
		panel.add(txtNacionalidad);
		
		JButton brnModificar = new JButton("Modificar");
		brnModificar.setIcon(new ImageIcon(JModificar.class.getResource("/Imagenes/actualizar.png")));
		brnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean verificacion = false;
				String mensaje ="Se ha modificado: \n ";
				
				if (!aModificar.jugador.getNombre().equals(txtNombre.getText())) {
					aModificar.jugador.setNombre(txtNombre.getText());
					verificacion = true;
					mensaje += "- Nombre \n";
				}
				if (!aModificar.jugador.getDni().equals(txtDNI.getText())) {
					aModificar.jugador.setDni(txtDNI.getText());
					verificacion = true;
					mensaje += "- DNI \n";
				}
				if (!aModificar.jugador.getFechaNacimiento().equals(txtFechaNacimiento.getText())) {
					aModificar.jugador.setFechaNacimiento(txtFechaNacimiento.getText());
					verificacion = true;
					mensaje += "- Fecha Nacimiento \n";
				}
				if(!aModificar.jugador.getNacionalidad().equals(txtNacionalidad.getText())){
					aModificar.jugador.setNacionalidad(txtNacionalidad.getText());
					verificacion = true;
					mensaje += "- Nacionalidad\n";
				}
				if (!aModificar.jugador.getEdad().equals(txtEdad.getText())){
					aModificar.jugador.setEdad(txtEdad.getText());
					verificacion = true;
					mensaje += "- Edad\n";
				}
			if (verificacion == true){
				JOptionPane.showMessageDialog(null, mensaje, "MODIFICACIONES: ", JOptionPane.INFORMATION_MESSAGE);
				txtMostrar.setText(lista.buscarXPosicion(clavePais, Integer.parseInt(posicionPais)).pais.listaJugadores.buscarXPosicion(aModificar.jugador.getClave(), Integer.parseInt(posicionJugador)).jugador.toString());
				
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "Por favor ingrese una MODIFICACIÓN", "ERROR: No hay modificaciones", JOptionPane.ERROR_MESSAGE);
			}
			
				
			
			
				
				
				
			}
		});
		brnModificar.setBounds(10, 231, 106, 23);
		panel.add(brnModificar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(JModificar.class.getResource("/Imagenes/back.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(267, 244, 114, 23);
		contentPane.add(btnCancelar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(JModificar.class.getResource("/Imagenes/FondoFrame.jpg")));
		label.setBounds(0, 0, 409, 299);
		contentPane.add(label);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
