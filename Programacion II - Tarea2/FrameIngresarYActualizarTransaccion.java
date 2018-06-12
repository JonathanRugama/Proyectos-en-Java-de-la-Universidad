import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class FrameIngresarYActualizarTransaccion extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumeroTransaccion;
	private JTextField txtNumeroTarjeta;
	private JTextField txtMonto;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public FrameIngresarYActualizarTransaccion(String tituloFrame, String tituloBoton) {
		setTitle(tituloFrame);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N\u00FAmero de Transacci\u00F3n:");
		lblNewLabel.setBounds(31, 46, 134, 14);
		contentPane.add(lblNewLabel);
		
		txtNumeroTransaccion = new JTextField();
		txtNumeroTransaccion.setBounds(168, 43, 86, 20);
		contentPane.add(txtNumeroTransaccion);
		txtNumeroTransaccion.setColumns(10);
		
		JLabel lblNmeroDeTarjeta = new JLabel("N\u00FAmero de Tarjeta:");
		lblNmeroDeTarjeta.setBounds(31, 94, 110, 14);
		contentPane.add(lblNmeroDeTarjeta);
		
		txtNumeroTarjeta = new JTextField();
		txtNumeroTarjeta.setBounds(168, 91, 86, 20);
		contentPane.add(txtNumeroTarjeta);
		txtNumeroTarjeta.setColumns(10);
		
		JLabel lblMonto = new JLabel("Monto:");
		lblMonto.setBounds(34, 145, 57, 14);
		contentPane.add(lblMonto);
		
		txtMonto = new JTextField();
		txtMonto.setBounds(168, 142, 86, 20);
		contentPane.add(txtMonto);
		txtMonto.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(31, 193, 46, 14);
		contentPane.add(lblTipo);
		
		JRadioButton rdbtnDeposito = new JRadioButton("Deposito");
		rdbtnDeposito.setBounds(102, 189, 93, 23);
		contentPane.add(rdbtnDeposito);
		
		JRadioButton rdbtnRetiro = new JRadioButton("Retiro");
		rdbtnRetiro.setBounds(197, 189, 109, 23);
		contentPane.add(rdbtnRetiro);
		
		JLabel lblMoneda = new JLabel("Moneda:");
		lblMoneda.setBounds(31, 236, 62, 14);
		contentPane.add(lblMoneda);
		
		JRadioButton rdbtnColones = new JRadioButton("Colones");
		rdbtnColones.setBounds(102, 232, 93, 23);
		contentPane.add(rdbtnColones);
		
		JRadioButton rdbtnDlares = new JRadioButton("D\u00F3lares");
		rdbtnDlares.setBounds(197, 232, 109, 23);
		contentPane.add(rdbtnDlares);
		
		JLabel lblFecha = new JLabel("Fecha: ");
		lblFecha.setBounds(31, 285, 46, 14);
		contentPane.add(lblFecha);
		
		JButton btnEjecutar = new JButton(tituloBoton);
		btnEjecutar.setBounds(31, 329, 89, 23);
		contentPane.add(btnEjecutar);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
