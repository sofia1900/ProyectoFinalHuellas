package ProyectoFinal.Huellas.Domain;

public class Adoptante extends Persona {
	
	private String fechaNac;
	private String direccion;
	
	public Adoptante () {}

	public Adoptante(int id, String nombre, String apellidos, String dni, String fechaNac, String direccion) {
		super(id, nombre, apellidos, dni);
		this.fechaNac = fechaNac;
		this.direccion = direccion;
	}

	
	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Adoptante [fechaNac=" + fechaNac + ", direccion=" + direccion + ", id=" + id + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", dni=" + dni + "]";
	}
	
}
