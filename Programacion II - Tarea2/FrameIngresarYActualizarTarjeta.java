import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class FrameIngresarYActualizarTarjeta extends JFrame {

	private JPanel contentPane;
	private JTextField txtTarjeta;
	private JTextField txtCedula;
	private JTextField txtFechaEmision;
	private JLabel lblCodigoSeguridad;
	private JTextField txtCodigoSeguridad;
	private JLabel lblSaldoColones;
	private JTextField txtSaldoColones;
	private JLabel lblSaldoDlares;
	private JTextField txtSaldoDolares;
	private JLabel lblMarca;

	
	public FrameIngresarYActualizarTarjeta(String tituloFrame, String tituloBoton) {
		setTitle(tituloFrame);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumTarjeta = new JLabel("N\u00FAmero de Tarjeta:");
		lblNumTarjeta.setBounds(26, 29, 113, 14);
		contentPane.add(lblNumTarjeta);
		
		txtTarjeta = new JTextField();
		txtTarjeta.setBounds(148, 26, 86, 20);
		contentPane.add(txtTarjeta);
		txtTarjeta.setColumns(10);
		
		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(26, 71, 46, 14);
		contentPane.add(lblCdula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(148, 68, 86, 20);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
		
		JLabel lblFechaDeEmisin = new JLabel("Fecha de emisi\u00F3n:");
		lblFechaDeEmisin.setBounds(26, 116, 103, 14);
		contentPane.add(lblFechaDeEmisin);
		
		txtFechaEmision = new JTextField();
		txtFechaEmision.setBounds(148, 113, 86, 20);
		contentPane.add(txtFechaEmision);
		txtFechaEmision.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Fecha de vencimiento:");
		lblNewLabel.setBounds(26, 159, 122, 14);
		contentPane.add(lblNewLabel);
		
		lblCodigoSeguridad = new JLabel("Codigo Seguridad:");
		lblCodigoSeguridad.setBounds(26, 197, 113, 14);
		contentPane.add(lblCodigoSeguridad);
		
		txtCodigoSeguridad = new JTextField();
		txtCodigoSeguridad.setBounds(148, 194, 86, 20);
		contentPane.add(txtCodigoSeguridad);
		txtCodigoSeguridad.setColumns(10);
		
		lblSaldoColones = new JLabel("Saldo Colones:");
		lblSaldoColones.setBounds(26, 247, 103, 14);
		contentPane.add(lblSaldoColones);
		
		txtSaldoColones = new JTextField();
		txtSaldoColones.setBounds(148, 244, 86, 20);
		contentPane.add(txtSaldoColones);
		txtSaldoColones.setColumns(10);
		
		lblSaldoDlares = new JLabel("Saldo D\u00F3lares:");
		lblSaldoDlares.setBounds(26, 288, 103, 14);
		contentPane.add(lblSaldoDlares);
		
		txtSaldoDolares = new JTextField();
		txtSaldoDolares.setBounds(148, 285, 86, 20);
		contentPane.add(txtSaldoDolares);
		txtSaldoDolares.setColumns(10);
		
		lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(26, 332, 64, 14);
		contentPane.add(lblMarca);
		
		JComboBox cmbxMarca = new JComboBox();
		cmbxMarca.setModel(new DefaultComboBoxModel(new String[] {"VISA", "MASTERCARD", "AMERICAN EXPRESS"}));
		cmbxMarca.setBounds(148, 329, 86, 20);
		contentPane.add(cmbxMarca);
		
		JButton btnIngresar = new JButton(tituloBoton);
		btnIngresar.setBounds(21, 377, 89, 23);
		contentPane.add(btnIngresar);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
