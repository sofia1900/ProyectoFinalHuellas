package ProyectoFinal.Huellas;

enum Sexo {H, M}

public class Animales {
	
	protected int id;
	protected String nombre;
	protected String fechaNac;
	protected Sexo sexo;
	
	public Animales() {}
	
	
	public Animales(int id, String nombre, String fechaNac, Sexo sexo) {
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
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}


	@Override
	public String toString() {
		return "Animales [id=" + id + ", nombre=" + nombre + ", fechaNac=" + fechaNac + ", sexo=" + sexo + "]";
	}
	
	
	
		

}
