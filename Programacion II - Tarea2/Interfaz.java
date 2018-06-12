import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class Interfaz extends JFrame {

	private JPanel contentPane;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido1;
	private JTextField txtApellido2;
	private JTextArea txtDireccion;
	private JScrollPane ScrollDireccion;
	private JTextField txtTelefono;
	private JButton btnIngresar;
	private JButton btnSalir;
	private JMenuBar menuBar;
	private JTextField txtActualizar;
	private JTextField txtEliminar;
	public FrameIngresarYActualizarTransaccion frameIngresarT;
	public FrameIngresarYActualizarTransaccion frameActualizarT;
	public FrameIngresarYActualizarTarjeta frameIngresarTarj;
	public FrameIngresarYActualizarTarjeta frameActualizarTarj;
	


	
	public Interfaz() throws InterruptedException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Interfaz.class.getResource("/Imagenes/usuario.png")));
		setTitle("Clientes");
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setBounds(100, 100, 600, 489);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane.setLayout(null);
		
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnACercaDe = new JMenu("Acerca de");
		menuBar.add(mnACercaDe);
		
		JMenuItem mntmPrograma = new JMenuItem("Programa");
		mnACercaDe.add(mntmPrograma);
		
		JMenuItem mntmAutores = new JMenuItem("Autores");
		mntmAutores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Cortés Baltodano Elier B72410 \nRugama Obando Jonathan B56367", "INFORMACIÓN DE LOS AUTORES", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		mnACercaDe.add(mntmAutores);
		
		JMenu mnIngresar = new JMenu("Ingresar");
		menuBar.add(mnIngresar);
		
		JMenuItem mntmTransaccion = new JMenuItem("Transacci\u00F3n");
		mntmTransaccion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
			 frameIngresarT = new FrameIngresarYActualizarTransaccion("INGRESAR TRANSACCION", "Ejecutar");
			 frameIngresarT.setVisible(true);
			}
		});
		mnIngresar.add(mntmTransaccion);
		
		JMenuItem mntmTarjeta = new JMenuItem("Tarjeta");
		mntmTarjeta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				frameIngresarTarj = new FrameIngresarYActualizarTarjeta ("INGRESAR TARJETA", "Ingresar");
				frameIngresarTarj.setVisible(true);
				
			}
		});
		mnIngresar.add(mntmTarjeta);
		
		JMenu mnActualizar = new JMenu("Actualizar");
		menuBar.add(mnActualizar);
		
		JMenuItem mntmATransaccion = new JMenuItem("Transacci\u00F3n");
		mntmATransaccion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				 frameActualizarT = new FrameIngresarYActualizarTransaccion("ACTUALIZAR TRANSACCION", "Actualizar");
				 frameActualizarT.setVisible(true);
			}
		});
		mnActualizar.add(mntmATransaccion);
		
		JMenuItem mntmATarjeta = new JMenuItem("Tarjeta");
		mntmATarjeta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				 frameActualizarTarj = new FrameIngresarYActualizarTarjeta("ACTUALIZAR TARJETA", "Actualizar");
				 frameActualizarTarj.setVisible(true);
			}
		});
		mnActualizar.add(mntmATarjeta);
		
		JMenu mnEliminar = new JMenu("Eliminar");
		menuBar.add(mnEliminar);
		
		JMenuItem mntmETransaccion = new JMenuItem("Transacci\u00F3n");
		mnEliminar.add(mntmETransaccion);
		
		JMenuItem mntmETrajeta = new JMenuItem("Tarjeta");
		mnEliminar.add(mntmETrajeta);
	
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(30, 84, 61, 14);
		contentPane.add(lblNombre);
		
		JLabel lblCedula = new JLabel("C\u00E9dula:");
		lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCedula.setBounds(30, 51, 46, 14);
		contentPane.add(lblCedula);
		
		JLabel lblApellido1 = new JLabel("Primer apellido:");
		lblApellido1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellido1.setBounds(30, 109, 82, 14);
		contentPane.add(lblApellido1);
		
		JLabel lblApellido2 = new JLabel("Segundo apellido:");
		lblApellido2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellido2.setBounds(30, 134, 110, 14);
		contentPane.add(lblApellido2);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDireccion.setBounds(30, 170, 110, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefono.setBounds(30, 243, 82, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaNacimiento.setBounds(30, 286, 125, 14);
		contentPane.add(lblFechaNacimiento);
		
		txtCedula = new JTextField();
		txtCedula.setToolTipText("Ingresa el n\u00FAmero de c\u00E9dula del cliente");
		txtCedula.setBounds(86, 49, 86, 20);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setToolTipText("Nombre completo del cliente");
		txtNombre.setBounds(86, 78, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido1 = new JTextField();
		txtApellido1.setToolTipText("Primer apellido del cliente");
		txtApellido1.setBounds(138, 107, 86, 20);
		contentPane.add(txtApellido1);
		txtApellido1.setColumns(10);
		
		txtApellido2 = new JTextField();
		txtApellido2.setToolTipText("Segundo apellido del cliente");
		txtApellido2.setBounds(138, 132, 86, 20);
		contentPane.add(txtApellido2);
		txtApellido2.setColumns(10);
		
		txtActualizar = new JTextField();
		txtActualizar.setToolTipText("Ingrese el n\u00FAmero de c\u00E9dula del clienta a actualizar");
		txtActualizar.setBounds(356, 49, 86, 20);
		contentPane.add(txtActualizar);
		txtActualizar.setColumns(10);
		
		txtEliminar = new JTextField();
		txtEliminar.setToolTipText("Ingrese el n\u00FAmero de c\u00E9dula del cliente a eliminar");
		txtEliminar.setBounds(356, 78, 86, 20);
		contentPane.add(txtEliminar);
		txtEliminar.setColumns(10);
		
		ScrollDireccion = new JScrollPane((Component) null);
		ScrollDireccion.setEnabled(false);
		ScrollDireccion.setPreferredSize(new Dimension(0, 0));
		ScrollDireccion.setBounds(107, 165, 229, 47);
		contentPane.add(ScrollDireccion);
		
		txtDireccion = new JTextArea();
		txtDireccion.setToolTipText("Direcci\u00F3n del cliente");
		ScrollDireccion.setViewportView(txtDireccion);
		
		txtTelefono = new JTextField();
		txtTelefono.setToolTipText("N\u00FAmero de tel\u00E9fono del cliente");
		txtTelefono.setBounds(107, 241, 86, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIngresar.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/login.png")));
		btnIngresar.setToolTipText("Ingresa los datos a la base de datos");
		btnIngresar.setBounds(30, 378, 110, 23);
		contentPane.add(btnIngresar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null,
						"¿DESEA FINALIZAR?", "FINALIZAR",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION  ) {
					JOptionPane.showMessageDialog(null,"PROGRAMA FINALIZADO");	
					System.exit(0);
			}
			}
		});
		btnSalir.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/salida.png")));
		btnSalir.setToolTipText("Regresa al men\u00FA principal");
		btnSalir.setBounds(473, 394, 110, 23);
		contentPane.add(btnSalir);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setToolTipText("Genera una acci\u00F3n para poder actualizar los datos del cliente");
		btnActualizar.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/actualizar.png")));
		btnActualizar.setBounds(452, 48, 131, 23);
		contentPane.add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setToolTipText("Eliminar los datos del cliente");
		btnEliminar.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/eliminar.png")));
		btnEliminar.setBounds(452, 77, 131, 23);
		contentPane.add(btnEliminar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 153, 153));
		panel.setOpaque(false);
		panel.setForeground(new Color(30, 144, 255));
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 32, 336, 387);
		contentPane.add(panel);
		
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy\n HH:mm:ss ");
		
		JLabel lblHora = new JLabel(hourdateFormat.format(date).concat("PROGRAMACIÓN II/UCR "));
		lblHora.setBounds(180, 7, 262, 14);
		contentPane.add(lblHora);
		Thread.sleep(1000);
		
		JLabel lblImagenFondo = new JLabel("New label");
		lblImagenFondo.setIcon(new ImageIcon(Interfaz.class.getResource("/Imagenes/FondoFrame.jpg")));
		lblImagenFondo.setBounds(0, 0, 607, 460);
		contentPane.add(lblImagenFondo);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
