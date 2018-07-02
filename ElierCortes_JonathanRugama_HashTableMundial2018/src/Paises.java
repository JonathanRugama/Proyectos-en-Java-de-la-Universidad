import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Paises {

	private String nombrePais;
	private String clave;
	public HashTableJugadores listaJugadores = new HashTableJugadores(101);
	public ArrayList<DatosUtilizados>arrayDatosU = new ArrayList<DatosUtilizados>();
	
	public Paises() {
	}
	
	
	public String extraerCodigoASCII (String nombrePais){
		String ascii = "";
		for (int x= 0; x<nombrePais.length(); x++) {
			if (x%2 !=0 ) {
			ascii += String.valueOf(nombrePais.codePointAt(x));
		}
		
			
		}
		if (ascii.length()>=15) {
			return ascii.substring(0, 15);
		}
		
		return ascii;
	}
	public void ingresarDatosUtilizados(DatosUtilizados datosU){
		arrayDatosU.add(datosU);
	}
	
	public void eliminarElementoArray(String clave) {
		//metodo eliminar
		 boolean verificacionSalida = false;//booleano para verificar definido en falso
	

		 for(int i = 0; i < arrayDatosU.size(); i++) {//se recorre el arrglo
			 if(arrayDatosU.get(i).getClaveUtilizada()==clave) {//se compara si idXEliminar es igual al getID de arrayPersona en la posicion i
				 
				 arrayDatosU.remove(i);//se elimina el contenido de la posicion i
				 verificacionSalida=true;//vereficacion es verdadero
				
				 break;//rompe
			 }
			
		 }
		 
		 if (verificacionSalida==true) {//si verificacionSalida es verdadero
			 //se elimina correctamente
			 JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente el jugador", "ELIMINADO EXITOSO", JOptionPane.INFORMATION_MESSAGE);
		 }else if (verificacionSalida==false) {//si verificacionSalida es falso
			 //muestra un mensaje de error
			 JOptionPane.showMessageDialog(null, "No se ha encontrado el número de clave a eliminar", "ELIMINADO FALLIDO", JOptionPane.ERROR_MESSAGE);
		 }//fin del if
		 
	}
	
	public String getNombrePais() {
		return nombrePais;
	}
	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
	
}
