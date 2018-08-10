import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.JTextComponent;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Permiso extends JFrame implements Runnable {

	private JPanel contentPane;
	private JTextField txtCedula;
	private JTextField txtCarnet;
	private JTextField txtCarneResidente;
	private Conexion conexion;
	private Date fecha = new Date ();
	private DateFormat hourDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private String hora, minutos, segundos, ampm;
	private JLabel lblReloj = new JLabel("");
	private Thread h1;
	private JTextField txtNombre;
	private DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<String>();
	
	
	public Permiso() {
		h1 = new Thread(this);//se crea el hilo
		h1.start();
		setTitle("Solicitud de permisos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel lblUniversidadDeCosta = new JLabel("UNIVERSIDAD DE COSTA RICA");
		lblUniversidadDeCosta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUniversidadDeCosta.setBounds(10, 11, 251, 14);
		contentPane.add(lblUniversidadDeCosta);
		
		JLabel lblSedeDeGuancaste = new JLabel("SEDE DE GUANACASTE");
		lblSedeDeGuancaste.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSedeDeGuancaste.setBounds(10, 23, 216, 14);
		contentPane.add(lblSedeDeGuancaste);
		
		JLabel lblCoordinacinDeVida = new JLabel("COORDINACI\u00D3N DE VIDA ESTUDIANTIL");
		lblCoordinacinDeVida.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCoordinacinDeVida.setBounds(10, 36, 282, 14);
		contentPane.add(lblCoordinacinDeVida);
		
		JLabel lblOficinaDeTrabajo = new JLabel("OFICINA DE TRABAJO SOCIAL");
		lblOficinaDeTrabajo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOficinaDeTrabajo.setBounds(10, 48, 261, 14);
		contentPane.add(lblOficinaDeTrabajo);
		
		JLabel lblPermisoDeIngreso = new JLabel("PERMISO DE INGRESO A LA RESIDENCIA");
		lblPermisoDeIngreso.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPermisoDeIngreso.setBounds(214, 90, 308, 14);
		contentPane.add(lblPermisoDeIngreso);
		
		JLabel lblYo = new JLabel("Yo");
		lblYo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblYo.setBounds(40, 135, 46, 14);
		contentPane.add(lblYo);
		
		JLabel lblConCdula = new JLabel("con c\u00E9dula");
		lblConCdula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConCdula.setBounds(381, 135, 83, 14);
		contentPane.add(lblConCdula);
		
		txtCedula = new JTextField();
		txtCedula.setToolTipText("C\u00E9dula del estudiante que solicita el permiso");
		txtCedula.setBounds(448, 132, 86, 20);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
		
		JLabel lblYCarnN = new JLabel("y carn\u00E9 N\u00BA");
		lblYCarnN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblYCarnN.setBounds(548, 135, 83, 14);
		contentPane.add(lblYCarnN);
		
		txtCarnet = new JTextField();
		txtCarnet.setToolTipText("N\u00FAmero del estudiante que solicita el permiso");
		txtCarnet.setBounds(617, 132, 86, 20);
		contentPane.add(txtCarnet);
		txtCarnet.setColumns(10);
		
		JLabel lblSolicitoPermisoPara = new JLabel("solicito permiso para estudiar en la Residencia Estudiantil con");
		lblSolicitoPermisoPara.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSolicitoPermisoPara.setBounds(40, 167, 331, 14);
		contentPane.add(lblSolicitoPermisoPara);
		
		JDateChooser dcDia = new JDateChooser();
		dcDia.setToolTipText("D\u00EDa del permiso");
		dcDia.setBounds(76, 196, 104, 20);
		contentPane.add(dcDia);
		
		JLabel lblCarn = new JLabel("carn\u00E9");
		lblCarn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCarn.setBounds(558, 167, 46, 14);
		contentPane.add(lblCarn);
		
		txtCarneResidente = new JTextField();
		txtCarneResidente.setToolTipText("N\u00FAmero de carn\u00E9 del estudiante del Progama de Residencia");
		txtCarneResidente.setBounds(617, 165, 86, 20);
		contentPane.add(txtCarneResidente);
		txtCarneResidente.setColumns(10);
		
		JLabel lblElDa = new JLabel("el d\u00EDa");
		lblElDa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblElDa.setBounds(40, 198, 46, 14);
		contentPane.add(lblElDa);
		
		JLabel lblDeLas = new JLabel("de las");
		lblDeLas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDeLas.setBounds(190, 199, 46, 14);
		contentPane.add(lblDeLas);
		
		JComboBox<Object> comboBoxDe = new JComboBox<Object>();
		comboBoxDe.setModel(new DefaultComboBoxModel<Object>(new String[] {"7am", "8am", "9am", "10am", "11am", "12md", "1pm", "2mp", "3pm", "4pm", "5pm"}));
		comboBoxDe.setToolTipText("Hora de entrada del estudiante");
		comboBoxDe.setBounds(228, 196, 64, 20);
		contentPane.add(comboBoxDe);
		
		JLabel lblALas = new JLabel("a las");
		lblALas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblALas.setBounds(299, 199, 46, 14);
		contentPane.add(lblALas);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(70, 133, 301, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		obtenerLista(comboBox);
		comboBox.setBounds(381, 165, 152, 20);
		contentPane.add(comboBox);
		
		JComboBox<Object> comboBoxA = new JComboBox<Object>();
		comboBoxA.setModel(new DefaultComboBoxModel<Object>(new String[] {"8am", "9am", "10am", "11am", "12md", "1pm", "2mp", "3pm", "4pm", "5pm", "6pm","7pm", "8pm", "9pm", "10pm"}));
		comboBoxA.setToolTipText("Hora de salida del estudiante");
		comboBoxA.setBounds(331, 196, 71, 20);
		contentPane.add(comboBoxA);
		
		JLabel lblMeHagoResponsable = new JLabel("Me hago responsable de cualquier da\u00F1o que ocasione durante el tiempo que permanezca en la Residencia y me");
		lblMeHagoResponsable.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMeHagoResponsable.setBounds(40, 240, 663, 14);
		contentPane.add(lblMeHagoResponsable);
		
		JLabel lblComprometoACumplir = new JLabel("comprometo a cumplir con las Reglamentos y Normas de la Residencia.");
		lblComprometoACumplir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblComprometoACumplir.setBounds(40, 261, 410, 14);
		contentPane.add(lblComprometoACumplir);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setOpaque(false);
		panel.setBounds(10, 73, 715, 229);
		contentPane.add(panel);
		
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = new Conexion("Resi");
				//objetos para poder crear la conexion
				Connection cs;
				java.sql.Statement stm;
				String sentencia = "";
				
				if(txtCarneResidente.getText().isEmpty()||txtNombre.getText().isEmpty()||txtCarnet.getText().isEmpty()||txtCedula.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "Ingrese los datos que se le solicitan");

				}else {
				
				try{
					cs = Conexion.getConexion();
					stm = cs.createStatement();
					sentencia = "INSERT INTO permisos (nombreEstudiante, cedula, carnet, nombreResidente, carnetResidente, fecha, horaIngreso, horaSalida, fechaSolicitud) VALUES ("
							+"'"+txtNombre.getText()+"',"+"'"+txtCedula.getText()+"',"+"'"+txtCarnet.getText()+"',"+"'"+String.valueOf(comboBox.getSelectedItem())+"',"+"'"+txtCarneResidente.getText()+"',"+
							"'"+hourDateFormat.format(dcDia.getDate())+"',"+"'"+String.valueOf(comboBoxDe.getSelectedItem())+"',"+"'"+String.valueOf(comboBoxA.getSelectedItem())+"',"+
							"'"+hourDateFormat.format(fecha)+"');";//sentencia SQL
					stm.executeUpdate(sentencia);//se ejecuta la sentencia
					Limpiar(contentPane);
					JOptionPane.showMessageDialog(null, "Permiso ingresado correctamente");
					dispose();
					
				}catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Error al ingresar permiso \n ", "Error", JOptionPane.ERROR_MESSAGE);
			
				}
				//llama a limpia y cargarTabla para refrescar el frame
				
			}}
			
		});
		btnAceptar.setIcon(new ImageIcon(Permiso.class.getResource("/Imagenes/login.png")));
		btnAceptar.setToolTipText("Acepta la solicitud del permiso");
		btnAceptar.setBounds(614, 334, 111, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String [] opciones = {"Sí", "No", "Cancelar"};//definicion de los botones en el joptionpane
				int opcion = 0;
				//joptionpane para ver si quiere salir
				opcion = JOptionPane.showOptionDialog(null, " ¿DESEA CANCELAR?", "CANCELAR", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[1]);
				
				if(opcion == 0) {//se la opcion es cero es decir que seleccionó si
					
					
					dispose();//cierra el frame
					
				}
			}
		});
		btnCancelar.setIcon(new ImageIcon(Permiso.class.getResource("/Imagenes/eliminar.png")));
		btnCancelar.setToolTipText("Bot\u00F3n que regresa al men\u00FA principal");
		btnCancelar.setBounds(479, 334, 125, 23);
		contentPane.add(btnCancelar);
		
		
	  	JPanel barraEstado = new JPanel();
		barraEstado.setOpaque(false);
		barraEstado.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		barraEstado.setBounds(8, 327, 456, 30);
		contentPane.add(barraEstado);
		barraEstado.add(lblReloj);
		
		JLabel Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon(Permiso.class.getResource("/Imagenes/FondoFrame.jpg")));
		Fondo.setBounds(-80, -99, 940, 568);
		contentPane.add(Fondo);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void run() {
		
		Thread ct = Thread.currentThread();//crea el hilo

		while (ct==Thread.currentThread()) {//
		
			calcula ();//llama calcula
			//envia al label la fecha y hora
			lblReloj.setText(("Fecha: "+hourDateFormat.format(fecha)+" Hora: "+hora+ ":" + minutos+ ":" +segundos+ " " +ampm + " RESIDENCIAS - UCR"));
			revalidate();
			try {
				
				Thread.sleep(1000);
				
			}catch (InterruptedException e) {}
		}
	}
	

	
	public void calcula() {
	    Calendar calendario = new GregorianCalendar();
	    Date fechaHoraActual = new Date();
	    
	    calendario.setTime(fechaHoraActual);
	    ampm = calendario.get(Calendar.AM_PM) ==Calendar.AM? "AM" : "PM";
		if (ampm.equals("PM")) {   //Verifica si la hora es AM o PM... si es PM, resta 12 horas
			int h = calendario.get(Calendar.HOUR_OF_DAY)-12;
			hora = h>9?  " "+ h:  "0" + h;
			
		} else {
			                                                                                               /*Si la horaes mayor a 9 no se agrega nada , pero sino, nos agrega un 0 antes de la hora.*/
			hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY): "0" +calendario.get(Calendar.HOUR_OF_DAY);
		}
		  /*Lo mismo aplica para minutos.*/
		minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE) : "0"+ calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND)>9? "" +calendario.get(Calendar.SECOND): "0"+calendario.get(Calendar.SECOND);
	}
	
	public void Limpiar (JPanel Panel){
		for (Object o : Panel.getComponents()){
			if (o instanceof JTextField){
				((JTextField) o).setText("");

			}
		}
	}
	
		



/*public void MostrarDatos(JComboBox<String> combobox){
        combobox.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
           @Override 
            public void keyReleased(KeyEvent evt) {
                String cadenaEscrita = combobox.getEditor().getItem().toString();//se envia los datos obtenidos por la base de datos, agregados como un item al combobox

                if (evt.getKeyCode() >= 65 && evt.getKeyCode() <= 90 || evt.getKeyCode() >= 96 && evt.getKeyCode() <= 105 || evt.getKeyCode() == 8) {
                    combobox.setModel(obtenerLista(cadenaEscrita));  //envia lo que contine el combobox
                    if (combobox.getItemCount() > 0) { 
                        combobox.showPopup();
                        
                        if(evt.getKeyCode()!=8){
                            ((JTextComponent)combobox.getEditor().getEditorComponent()).select(cadenaEscrita.length(), combobox.getEditor().getItem().toString().length());
                            
                        }else{
                            combobox.getEditor().setItem(cadenaEscrita);
                        }

                    } else {
                        combobox.addItem(cadenaEscrita);
                    }
                }
            } 
        });
}*/

public void obtenerLista( JComboBox<String> combobox) {
	conexion = new Conexion("Resi");
	//objetos para poder crear la conexion
	Connection cs;
	java.sql.Statement stm;
	ResultSet rs;
	String sentencia = "";
	
	JOptionPane.showMessageDialog(null, "Entra");

	
	try {
		sentencia = "SELECT* nombre FROM estudiantes;";
		cs = Conexion.getConexion();
		stm = cs.createStatement();
		rs = stm.executeQuery(sentencia);
		JOptionPane.showMessageDialog(null, "Ejecutó la sentencia");
		
		while(rs.next()) {
		
			combobox.addItem(rs.getString("nombre"));
		

		}
		
	}catch (SQLException e) {

		JOptionPane.showMessageDialog(null, "Se ha presentado un error: \n" + e, "Error", JOptionPane.ERROR_MESSAGE);
		
	}
	

	}
}
