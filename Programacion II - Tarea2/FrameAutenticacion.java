import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class FrameAutenticacion extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField password;
	private Interfaz menuPrincipal;
	private Timer timer;
	private int contador = 0;
	private ActionListener evento;
	

	
	public FrameAutenticacion() {
		setTitle("Autentificaci\u00F3n");
	//	setIconImage(Toolkit.getDefaultToolkit().getImage(FrameAutenticacion.class.getResource("/Imagenes/usser.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(135, 78, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(135, 123, 86, 20);
		contentPane.add(password);
		
		JLabel lblAutenticacinDeUsuario = new JLabel("AUTENTICACI\u00D3N DE USUARIO:");
		lblAutenticacinDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAutenticacinDeUsuario.setBounds(33, 34, 215, 22);
		contentPane.add(lblAutenticacinDeUsuario);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(56, 81, 62, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(56, 126, 74, 14);
		contentPane.add(lblContrasea);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setMaximum(10);
		progressBar.setBounds(145, 179, 146, 23);
		contentPane.add(progressBar);
		
		JLabel lblVerificar = new JLabel("");
		lblVerificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerificar.setBounds(145, 164, 146, 14);
		contentPane.add(lblVerificar);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
			      if (autenticarIngresoASistema()==true) {
			 
			    	  evento = new ActionListener() {//se crea el eventp
					
					
					public void actionPerformed(ActionEvent e) {//se ejecuta el evento
						contador = contador+1;//el contator va hacer igual al mismo más 1
						progressBar.setValue(contador);//se le envia el valor del contador a la barra progresiva
						
						
						if(progressBar.getValue()==1) {//cuando valor de la barra progresiva sea 1 
							
							lblVerificar.setText("Usuario verificado");//el contenido del label pasa a ser esto
						}
						
						if(progressBar.getValue()==5) {//cuando valor de la barra progresiva sea 5
							
							lblVerificar.setText("Contraseña verificada");//el contenido del label pasa a ser esto
							
						}
						if(progressBar.getValue()==9) {//cuando valor de la barra progresiva sea 9
							
							lblVerificar.setText("¡Bienvenido ".concat(txtUsuario.getText().concat("!")));//el contenido del label pasa a ser esto

						}
						
						if(progressBar.getValue()==10) {//si el valor de la barra progresiva el igual a 10
							
							timer.stop();//se detiene el temporizador
							try {
								menuPrincipal = new Interfaz ();// se crea el objeto de interfaz
							} catch (InterruptedException e1) {
								
								e1.printStackTrace();//se ejecuta la excepcion en caso de que algo salga mal
							}
							menuPrincipal.setVisible(true);//se hace visible el objeto de la interfaz
							dispose();//se cierra el frame de verificacion
						}
					}
				};
			  
				timer = new Timer(150, evento);//se le define al temporizador cuanto debe durar y el evento se ejecuta varias veces hasta
				timer.start();//inicia el temporizador 							//que la barra progresiva llegue al maximo

			      }else{
			    	  JOptionPane.showMessageDialog(null, "La contraseña no es correcta, ingrese de nuevo la contraseña", "ERROR", JOptionPane.ERROR_MESSAGE);
			      }
				} catch (InterruptedException e1) {
		
					e1.printStackTrace();
				}
				
			
			}
		});
		btnIngresar.setBounds(33, 179, 89, 23);
		contentPane.add(btnIngresar);
		
		
		
		
		
		
		JLabel lblImagen = new JLabel("New label");
		lblImagen.setIcon(new ImageIcon(FrameAutenticacion.class.getResource("/Imagenes/FondoFrame.jpg")));
		lblImagen.setBounds(-16, 0, 398, 241);
		contentPane.add(lblImagen);
		
		
	}
	public boolean autenticarIngresoASistema () throws InterruptedException {

        String pass2 = String.valueOf(password.getPassword());
	   boolean verificacion = false;
		if (pass2.equals("admin")&&txtUsuario.getText().equals("admin")){
		
			verificacion = true;
		}else {
			
			password.setText("");
			verificacion = false;
		}
		
		return verificacion;
	}
	
	
}
