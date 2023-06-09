package ProyectoFinal.Huellas.Domain;

public class Animal {
	
	protected int id;
	protected String nombre;
	protected String fechaNac;
	protected String sexo;
	protected boolean adoptado;
	
	public Animal() {}
	
	
	public Animal(int id, String nombre, String fechaNac, String sexo, boolean adoptado) {
		this.id = id;
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.sexo = sexo;
		this.adoptado = adoptado;
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
	public boolean isAdoptado() {
		return adoptado;
	}
	public void setAdoptado(boolean adoptado) {
		this.adoptado = adoptado;
	}


	@Override
	public String toString() {
		return "Animales [id=" + id + ", nombre=" + nombre + ", fechaNac=" + fechaNac + ", sexo=" + sexo + "]";
	}
	
	
	
		

}
