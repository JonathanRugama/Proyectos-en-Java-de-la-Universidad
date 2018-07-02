import java.lang.Character.Subset;

public class Jugadores {

	private String nombre;
	private String edad;
	private String dni;
	private String fechaNacimiento;
	private String nacionalidad;
	private String clave;
	
	public Jugadores(String nombre){
		this.nombre=nombre;
	}
	
	
	public Jugadores() {
	}

	


	@Override
	public String toString() {
		return "\n Nombre: " + getNombre() +
				"\n Edad: " + getEdad() + 
				"\n DNI: " + getDni()
				+ "\n Fecha de nacimiento: " + getFechaNacimiento() +
				"\n Nacionalidad: " + getNacionalidad() + 
				"\n Clave: " + getClave() ;
	}


	


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEdad() {
		return edad;
	}


	public void setEdad(String edad) {
		this.edad = edad;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
	
	
	
}
