package ProyectoFinal.Huellas.Data;

public class Animal {
	
	protected int id;
	protected String nombre;
	protected String fechaNac;
	protected String sexo;
	
	public Animal() {}
	
	
	public Animal(int id, String nombre, String fechaNac, String sexo) {
		this.id = id;
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.sexo = sexo;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	@Override
	public String toString() {
		return "Animales [id=" + id + ", nombre=" + nombre + ", fechaNac=" + fechaNac + ", sexo=" + sexo + "]";
	}
	
	
	
		

}
