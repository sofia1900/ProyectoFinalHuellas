package domain;

public class Perro extends Animales {
	private String raza;
	private boolean amigable;
	
	public Perro() {}
	public Perro(int id, String nombre, String fechaNac, Sexo sexo,String raza, boolean amigable) {
		super(id, nombre, fechaNac, sexo);
		this.raza=raza;
		this.amigable=amigable;
	}
	
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public boolean getAmigable() {
		return amigable;
	}
	public void setAmigable(boolean amigable) {
		this.amigable = amigable;
	}
	
	
	@Override
	public String toString() {
		return "Perro [raza=" + raza + ", amigable=" + amigable + ", id=" + id + ", nombre=" + nombre + ", fechaNac="
				+ fechaNac + ", sexo=" + sexo + "]";
	}
	
	
	

}
