import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigInteger;
import java.util.ArrayList;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

/**
 * @author Jonathan Rugama y Elier Cortes
 *
 */
public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private Jugadores jugador;
	private Paises pais;
	private JTextField txtEdad;
	private JTextField txtDNI;
	private JTextField txtFechaNacimiento;
	private JTextField txtNacionalidad;
	private DatosUtilizados datosU;
	private JModificar modificar;
	private 		JList listHashPos;
private HashTablePaises lista = new HashTablePaises(1301);
private JTextField txtNombrePais;
 private JList listNombrePais; 
private DefaultListModel modeloHashPosJugadores;
private DefaultListModel modeloClaveJugadores ;
 private JList listClaveJugadores;
 private JTextArea txtMostrar;
 private JList listClaves ;
	private JList listHashPosJugadores;
	private DefaultListModel modeloHashPos;
	private DefaultListModel modeloClaves;
	
	private DefaultListModel modeloNombrePais ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Inciializa y construye todo lo relacionado a interfaz de usuario, además tiene sus respectivos ActionPerformed que invocan a diferentes métodos esenciales.
	 */
	public Principal() {
		setTitle("MUNDIAL RUSIA 2018");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 926, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JScrollPane scrollClaveList = new JScrollPane();
		scrollClaveList.setOpaque(false);
		scrollClaveList.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Clave de pa\u00EDs:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollClaveList.setBounds(681, 34, 204, 115);
		contentPane.add(scrollClaveList);
       modeloClaves = new DefaultListModel();
		listClaves = new JList();
		listClaves.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			 int seleccion = listClaves.getSelectedIndex();
			 listNombrePais.setSelectedIndex(seleccion);
			 listHashPos.setSelectedIndex(seleccion);
	        
				//txtMostrar.setText(lista.buscar(String.valueOf(listDirecciones.getSelectedValue())).jugador.toString());
				;
			}
		});
		scrollClaveList.setViewportView(listClaves);
		listClaves.setModel(modeloClaves);
		

		
		JScrollPane scrollHashPos = new JScrollPane();
		scrollHashPos.setOpaque(false);
		scrollHashPos.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "HashTable - Paises - Pos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollHashPos.setBounds(285, 34, 177, 115);
		contentPane.add(scrollHashPos);
 modeloHashPos = new DefaultListModel();
		
		listHashPos = new JList();
		scrollHashPos.setViewportView(listHashPos);
		listHashPos.setModel(modeloHashPos);

		
		JScrollPane scrollNombreList = new JScrollPane();
		scrollNombreList.setOpaque(false);
		scrollNombreList.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Nombre de pa\u00EDs:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollNombreList.setBounds(480, 34, 164, 115);
		contentPane.add(scrollNombreList);
		
modeloNombrePais = new DefaultListModel();
		 listNombrePais = new JList();
		listNombrePais.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			desplegarModelosJugadores();
				
			}
		});
		scrollNombreList.setViewportView(listNombrePais);
		listNombrePais.setModel(modeloNombrePais);
		
		JScrollPane scrollMostrar = new JScrollPane();
		scrollMostrar.setOpaque(false);
		scrollMostrar.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Datos de jugador:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollMostrar.setBounds(681, 166, 199, 198);
		contentPane.add(scrollMostrar);
		
		 txtMostrar = new JTextArea();
		txtMostrar.setBorder(null);
		scrollMostrar.setViewportView(txtMostrar);
		
		JScrollPane scrollHashPosJugadores = new JScrollPane();
		scrollHashPosJugadores.setOpaque(false);
		scrollHashPosJugadores.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "HashTable-Jugadores-Pos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollHashPosJugadores.setBounds(281, 166, 181, 198);
		contentPane.add(scrollHashPosJugadores);
		 modeloHashPosJugadores= new DefaultListModel ();
		listHashPosJugadores = new JList();
		listHashPosJugadores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int seleccion = listHashPosJugadores.getSelectedIndex();
				listClaveJugadores.setSelectedIndex(seleccion);
			}
		});
		scrollHashPosJugadores.setViewportView(listHashPosJugadores);
		listHashPosJugadores.setModel(modeloHashPosJugadores);
		
		JPanel panelPais = new JPanel();
		panelPais.setOpaque(false);
		panelPais.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Ingresar pa\u00EDs:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPais.setBounds(22, 36, 249, 113);
		contentPane.add(panelPais);
		panelPais.setLayout(null);
		
		JLabel lblNombreDePas = new JLabel("Nombre de pa\u00EDs:");
		lblNombreDePas.setBounds(10, 35, 100, 14);
		panelPais.add(lblNombreDePas);
		
		txtNombrePais = new JTextField();
		txtNombrePais.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtNombrePais.setBounds(117, 32, 86, 20);
		panelPais.add(txtNombrePais);
		txtNombrePais.setColumns(10);
		
		JButton btnIngresar_1 = new JButton("Ingresar");
		btnIngresar_1.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/login.png")));
		btnIngresar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			ingresarPais();
	
	
			}
		});
		btnIngresar_1.setBounds(10, 79, 119, 23);
		panelPais.add(btnIngresar_1);
		
		JPanel panelDatosJugador = new JPanel();
		panelDatosJugador.setOpaque(false);
		panelDatosJugador.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Ingresar datos de jugador:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDatosJugador.setBounds(24, 166, 247, 306);
		contentPane.add(panelDatosJugador);
		panelDatosJugador.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(10, 31, 56, 14);
		panelDatosJugador.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(113, 31, 86, 20);
		panelDatosJugador.add(txtNombre);
		
		txtNombre.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtNombre.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(10, 68, 46, 14);
		panelDatosJugador.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(112, 67, 86, 20);
		panelDatosJugador.add(txtEdad);
		txtEdad.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtEdad.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 105, 46, 14);
		panelDatosJugador.add(lblDni);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(111, 102, 86, 20);
		panelDatosJugador.add(txtDNI);
		txtDNI.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtDNI.setColumns(10);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento: ");
		lblFechaNacimiento.setBounds(10, 144, 96, 14);
		panelDatosJugador.add(lblFechaNacimiento);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setBounds(112, 138, 86, 20);
		panelDatosJugador.add(txtFechaNacimiento);
		txtFechaNacimiento.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtFechaNacimiento.setColumns(10);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setBounds(10, 183, 96, 14);
		panelDatosJugador.add(lblNacionalidad);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setBounds(111, 174, 86, 20);
		panelDatosJugador.add(txtNacionalidad);
		txtNacionalidad.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtNacionalidad.setColumns(10);
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/login.png")));
		btnIngresar.setBounds(10, 231, 121, 23);
		panelDatosJugador.add(btnIngresar);
		
		JScrollPane scrollClaveJugadores = new JScrollPane();
		scrollClaveJugadores.setOpaque(false);
		scrollClaveJugadores.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Clave de jugadores:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollClaveJugadores.setBounds(480, 166, 164, 198);
		contentPane.add(scrollClaveJugadores);
	 modeloClaveJugadores = new DefaultListModel();
		listClaveJugadores = new JList();
		listClaveJugadores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
		   
				mostrarJugadorX();
				
				
			}
		});
		scrollClaveJugadores.setViewportView(listClaveJugadores);
		listClaveJugadores.setModel(modeloClaveJugadores);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Seleccione una clave para:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(480, 375, 395, 86);
		contentPane.add(panel);
				panel.setLayout(null);
		
				
				JButton btnModificar = new JButton("Modificar jugador");
				btnModificar.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/actualizar.png")));
				btnModificar.setBounds(10, 18, 159, 23);
				panel.add(btnModificar);
				
				JButton btnEliminar = new JButton("Eliminar jugador");
				btnEliminar.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/eliminar.png")));
				btnEliminar.addActionListener(new ActionListener() {
			
		
					public void actionPerformed(ActionEvent e) {
						
						
			eliminar();
					}
				});
				btnEliminar.setBounds(10, 52, 159, 23);
				panel.add(btnEliminar);
				
				JButton btnMostrarTodo = new JButton("Mostrar selecci\u00F3n");
				btnMostrarTodo.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/mostrar.png")));
				btnMostrarTodo.setBounds(208, 18, 151, 23);
				panel.add(btnMostrarTodo);
				
				JButton btnSalir = new JButton("Salir");
				btnSalir.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/salida.png")));
				btnSalir.setBounds(208, 52, 89, 23);
				panel.add(btnSalir);
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/FondoFrame.jpg")));
				lblNewLabel.setBounds(0, 0, 910, 503);
				contentPane.add(lblNewLabel);
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				btnMostrarTodo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				      mostrarSeleccion();
						
					}
				});
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
				 modificar();
				
					}
				});
		
	
		
	  
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
           ingresar(panelDatosJugador);
			
			}
		});
		
	
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	/**
	 * Este método funciona para limpiar toda instancia de Jtextfield que este almacenado en el Panel para ingresar los datos de jugadores. Es útil para aplicar
	 *  el setText("") individual a cada JTextField. 
	 * @param Panel Obtieneel panel que contiene los JLabel y Jtextfields de Ingresar jugador
	 */
	public void Limpiar (JPanel Panel){
		for (Object o : Panel.getComponents()){
			if (o instanceof JTextField){
				((JTextField) o).setText("");
			}
		}
	}
	
	/**
	 * Este método permite eliminar un jugador en especifico a nivel interno del sistema, es decir, eliminarlo en su tablaHashJugadores
	 * respectiva, pero además eliminar o remover los datos que se visualizan en los JList correspondiente a jugadores. Es decir, su posición y su clave.
	 * Una vez que se eliminan los elementos, gracias a la ayuda de las variables "posiciónUtilizada" y "claveUtilizada" (almecenan una lista con los datos utilizados 
	 * para no tener que recorrer toda la tabla e ir a la posición especifica). Se usa un for para remover y otro for para actualizar los Jlist al final del método.
	 */
	public void eliminar (){
		lista.buscar(String.valueOf(listClaves.getSelectedValue())).pais.listaJugadores.eliminar(String.valueOf(listClaveJugadores.getSelectedValue()), Integer.parseInt(String.valueOf(listHashPosJugadores.getSelectedValue())));
		
		ArrayList<DatosUtilizados> arrayDatos = lista.buscar(String.valueOf(listClaves.getSelectedValue())).pais.arrayDatosU;
		lista.buscar(String.valueOf(listClaves.getSelectedValue())).pais.eliminarElementoArray(String.valueOf(listClaveJugadores.getSelectedValue()));
		for (int i= 0; i<arrayDatos.size(); i++) {
			if (String.valueOf(listClaveJugadores.getSelectedValue()).equals(arrayDatos.get(i).claveUtilizada)){
	
				modeloHashPosJugadores.removeElement(arrayDatos.get(i).posicionUtilizada);	
	     modeloClaveJugadores.removeElement(arrayDatos.get(i).claveUtilizada);
			}
		}
		modeloHashPosJugadores.clear();
		modeloClaveJugadores.clear();
		
		
		for (int i= 0; i<arrayDatos.size(); i++) {
		     modeloHashPosJugadores.addElement(arrayDatos.get(i).posicionUtilizada);	
		     modeloClaveJugadores.addElement(arrayDatos.get(i).claveUtilizada);
			}
		txtMostrar.setText("");
	}
	/**
	 * En caso de que no se haya seleccionado la clave de un país o el nombre de un país, no se podrá ingresar un jugador, porque no se esta
	 * especificando a cual selección pertenece. Si se selecciona el país, si se va a permitir ingresar, y se extraeran del os JtextFields los datos que se necesitan
	 * para llenar el objeto de "jugador" y "datosU" . Cada vez que se invoque este método se van a limipiar los modelos de "HashPosJugadores" y "claveJugadores"
	 * con el fin de verificar si se encuentran en el ArrayList de Datos utilizados y estos puedan ser visualizados con precisión y de forma automatizada.
	 * @param panelDatosJugador recibe el panel para que una vez ingresados los datos, se puedan eliminar de los Jtextfields con el método limpiar()
	 * 
	 * (otra forma de hacerlo para no declarar la variable global)
	 * 
	 */
	public void ingresar(JPanel panelDatosJugador){
		if (listClaves.isSelectionEmpty()|| listNombrePais.isSelectionEmpty()) {
			JOptionPane.showMessageDialog(null, "Seleccione un país ante de ingresar un jugador", "ERROR", JOptionPane.ERROR_MESSAGE);
		}else{
		jugador = new Jugadores ();
		datosU= new DatosUtilizados();
		jugador.setNombre(txtNombre.getText());
		jugador.setEdad(txtEdad.getText());
		jugador.setDni((txtDNI.getText()));
		jugador.setFechaNacimiento(txtFechaNacimiento.getText());
		jugador.setNacionalidad(txtNacionalidad.getText());
		jugador.setClave(txtDNI.getText());
		datosU.setClaveUtilizada(txtDNI.getText());
		datosU.setNombreUtilizado(txtNombre.getText());
		//datosU.setPosicionUtilizada(lista.buscar(String.valueOf(listClaves.getSelectedValue())).pais.listaJugadores.aritmeticaModular(jugador.getClave()).toString());
		datosU.setPosicionUtilizada(	lista.buscar(String.valueOf(listClaves.getSelectedValue())).pais.listaJugadores.insertar(jugador));
	
		lista.buscarXPosicion(String.valueOf(listClaves.getSelectedValue()), Integer.parseInt(String.valueOf(listHashPos.getSelectedValue()))).pais.ingresarDatosUtilizados(datosU);
	
	//	modelo2.addElement((lista.insertar(jugador)));
	    Limpiar(panelDatosJugador);
	   modeloHashPosJugadores.clear();
	   modeloClaveJugadores.clear();
		ArrayList<DatosUtilizados> arrayDatos = lista.buscar(String.valueOf(listClaves.getSelectedValue())).pais.arrayDatosU;
		for (int i= 0; i<arrayDatos.size(); i++) {
	     modeloHashPosJugadores.addElement(arrayDatos.get(i).posicionUtilizada);	
	     modeloClaveJugadores.addElement(arrayDatos.get(i).claveUtilizada);
		}
		
		}
	}
	/**
	 * Este método crea un objeto  de la clase Paises, asigna su respectivo nombre y clave, y añade los datos ingresados al módelo de JList con el fin de 
	 * facilitar la busqueda de sus jugadores.
	 */
	public void ingresarPais() {
		
		pais = new Paises();
		pais.setNombrePais(txtNombrePais.getText());
		pais.setClave(pais.extraerCodigoASCII(txtNombrePais.getText()));
		modeloHashPos.addElement( lista.insertar(pais));
		modeloClaves.addElement(pais.getClave());
		modeloNombrePais.addElement(txtNombrePais.getText());
   	 
   	  txtNombrePais.setText("");
	}
	/**
	 * Este método va a permitir mostrar la selección de cada país, es decir, todos los jugadores que se visualizan en el JList, respecto a cada selección.
	 * PAra esto, se hace uso del método buscarXPosición , para que igual, en caso de existir colisiones, no existan problemas a la hora de mostrar y no salgan 
	 * datos repetidos. 
	 */
	public void mostrarSeleccion (){
		String imprimir = "";
		ArrayList<DatosUtilizados> arrayDatos = lista.buscar(String.valueOf(listClaves.getSelectedValue())).pais.arrayDatosU;
	
		for (int i= 0; i<arrayDatos.size(); i++) {

	     imprimir+= lista.buscar(String.valueOf(listClaves.getSelectedValue())).pais.listaJugadores.buscarXPosicion(arrayDatos.get(i).getClaveUtilizada(), Integer.parseInt(arrayDatos.get(i).getPosicionUtilizada())).jugador.toString() +"\n____________\n";
	     
		}
	 txtMostrar.setText(imprimir);	
	}
	
	/**
	 * Este método se utiliza para modificar un jugador en especifico, en este caso se obtiene el nodo aModificar, con el fin de mandarlo por parametro
	 * al Frame modificar, para que este pueda visualizar los datos especificos de ese nodo buscado, y poder sobrescribirlos en caso de que hayan modificaciones
	 * en el siguiente frame. 
	 */
	public void modificar(){
		try {
			NodoJugadores aModificar=lista.buscar(String.valueOf(listClaves.getSelectedValue())).pais.listaJugadores.buscarXPosicion(String.valueOf(listClaveJugadores.getSelectedValue()), Integer.parseInt(String.valueOf(listHashPosJugadores.getSelectedValue())));
			if (aModificar== null){
				JOptionPane.showMessageDialog(null, "No se ha encontrado el jugador", "ERROR: Jugador no encontrado", JOptionPane.ERROR_MESSAGE);
			}else {
		       String clavePais = String.valueOf(listClaves.getSelectedValue());
		       String posicion = String.valueOf(listHashPosJugadores.getSelectedValue());
		       String claveJugador= String.valueOf(listClaveJugadores.getSelectedValue());
				modificar = new JModificar(aModificar.jugador.getNombre(), aModificar.jugador.getEdad(), aModificar.jugador.getDni(), aModificar.jugador.getFechaNacimiento(), aModificar.jugador.getNacionalidad(), aModificar,  txtMostrar, lista, clavePais, posicion, claveJugador, String.valueOf(listHashPos.getSelectedValue()));
       modificar.setVisible(true);				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Tiene que seleccionar una clave de un país y jugador", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Este método lo que hace es que una vez seleccionada la clave del jugador, automaticamente selecciona la posición, y con base a esas selecciones en JList, se busca el nodo especifico
	 * con la clave seleccionada y con la posición seleccionada de la tabla de países,, después se busca en la tabla de jugadores el jugador especifico mediante la clave y la posicion
	 * para así poder ser mostrado. Pero notese que igual se busca en la tablaHash de países para así ir progresivamente obteniendo los datos necesarios para la busqueda del jugador. 
	 */
	public void mostrarJugadorX(){
		try {
			int seleccion = listClaveJugadores.getSelectedIndex();
			listHashPosJugadores.setSelectedIndex(seleccion);
			txtMostrar.setText(lista.buscarXPosicion(String.valueOf(listClaves.getSelectedValue()), Integer.parseInt(String.valueOf(listHashPos.getSelectedValue()))).pais.listaJugadores.buscarXPosicion(String.valueOf(listClaveJugadores.getSelectedValue()), Integer.parseInt(String.valueOf(listHashPosJugadores.getSelectedValue()))).jugador.toString());
		} catch (Exception e2) {
		JOptionPane.showMessageDialog(null, "No hay datos de jugador", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Este método lo que hace es desplegar los valores de JList, con base en los datos utilizados, para así facilitar la visualización y la busqueda de los datos ingresados en la tabla de jugadores.
	 * Entonces, con base en la clave y la posición hash seleccionada en la tabla países, se van a mostrar los datos de jugadores que contiene esa tabla en especifico. 
	 */
	public void desplegarModelosJugadores(){
		modeloHashPosJugadores.clear();
		modeloClaveJugadores.clear();
		int seleccion = listNombrePais.getSelectedIndex();
		
		listHashPos.setSelectedIndex(seleccion);
		listClaves.setSelectedIndex(seleccion);
		txtMostrar.setText("");
		ArrayList<DatosUtilizados> arrayDatos = lista.buscarXPosicion(String.valueOf(listClaves.getSelectedValue()), Integer.parseInt(String.valueOf(listHashPos.getSelectedValue()))).pais.arrayDatosU;
		for (int i= 0; i<arrayDatos.size(); i++) {
	     modeloHashPosJugadores.addElement(arrayDatos.get(i).posicionUtilizada);	
	     modeloClaveJugadores.addElement(arrayDatos.get(i).claveUtilizada);
		}
		
	}
	}




